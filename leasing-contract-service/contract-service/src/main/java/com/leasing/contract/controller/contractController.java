package com.leasing.contract.controller;

import com.leasing.common.service.RedisService;
import com.leasing.common.util.RedisLock;
import com.leasing.contract.entity.ContractVO;
import com.leasing.contract.service.contractService;
import com.leasing.contract.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @project:leasing-cloud
 * @date:2019/9/23
 * @author:wangjc@yonyou.com
 * @description:
 **/
@RestController
@Transactional
@RequestMapping(value="/leasing/contract")
public class contractController{
    @Autowired
    private JedisPool jedisPool;

    @Resource
    FeignService feignService;
    @Resource
    contractService contractService;
    @Resource
    RedisService redisService;
    @Resource
    RedisLock redisLock;


    @RequestMapping(value = "/test")
    public String TestFeign() {
        return "合同新增节点测试";
    }

    @RequestMapping(value ="/testFeign")
    public String FeignTest(){
        return feignService.TestFeign("rollback test feign");
    }

    @RequestMapping(value ="/testJdbc")
    public String findContractbyCode(String cont_code) {
        ContractVO vo = contractService.findContractbyCode(cont_code);
        if(vo!=null){
            return vo.getContent().toString();
        }
        return null;
    }

    @RequestMapping(value ="/testddd")
    public String findContractbyCondition() {
        StringBuffer result = new StringBuffer("");
        List<ContractVO> list = contractService.findContractbyCondition();
        for(ContractVO vo:list){
            result.append(vo.toString()+"\n");
        }
        return result.toString();
    }


    @RequestMapping(value="/updateContract")
    public String updateContractNamebyCode(String cont_name,String cont_code){
        contractService.updateContractNamebyCode(cont_name,cont_code);
        ContractVO vo = contractService.findContractbyCode(cont_code);
        return vo.toString();
    }


    @RequestMapping(value="/testadd")
    public  String testadd(){
        ContractVO user = new ContractVO();
        user.setPk("888");
        user.setCode("222");
        user.setName("张三");
        contractService.save(user);
        return "保存业务对象实体数据";
    }


    @RequestMapping(value="/testupdate")
    public void TestUpdate(){
        ContractVO contractVO =contractService.findbyContractPk("8888");
        contractVO.setCode("521521512");
        contractService.update(contractVO);
        System.out.println("更改业务对象实体数据");
    }


    @RequestMapping(value="/redisadd")
    public void TestContractsave(){
        ContractVO user = new ContractVO();
        user.setPk("8888");
        user.setCode("222");
        user.setName("张三");
        contractService.save(user);
        redisService.set("contract",user,60*2);
        System.out.println("保存业务对象实体数据");
    }

    @RequestMapping(value="/redisget")
    public void TestRedisget(){
        try{
            String requestid = UUID.randomUUID().toString();
            boolean haskey = redisService.hasKey("contract");
            if(haskey){   //有数据则从缓存中获取数据更改
                //加锁，保证下面的代码单线程的访问
                Jedis jedis = jedisPool.getResource();
                ContractVO vo =redisService.get("contract",ContractVO.class);
                boolean lockStatus = RedisLock.Lock(jedis, vo.getPk(), requestid, 100000);
                if(lockStatus){
                    vo.setCode("1234");
                    redisService.del("contract");
                    redisService.set("contract",vo,2*60);
                    System.out.println("线程1拿到锁了,所以更新");
                    RedisLock.unLock(jedis, vo.getPk(), redisService.beanToString(vo));
                }else{
                    System.out.println("线程1没拿到锁,同一时刻无法更新");
                }
//                contractService.update(vo);
            }else{   //无数据则从数据库中获取数据更改
                ContractVO vo =contractService.findbyContractPk("8888");
                vo.setCode("1234");
                contractService.update(vo);
                redisService.set("contract",vo,2*60);
            }
            Thread.sleep(1000);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String requestid = UUID.randomUUID().toString();
                    boolean haskey = redisService.hasKey("contract");
                    if(haskey){   //有数据则从缓存中获取数据更改
                        ContractVO vo =redisService.get("contract",ContractVO.class);
                        Jedis jedis = jedisPool.getResource();
                        boolean lockStatus = RedisLock.Lock(jedis, vo.getPk(), requestid, 100000);
                        if(lockStatus){
                            vo.setCode("4444");
                            redisService.del("contract");
                            redisService.set("contract",vo,2*60);
                            System.out.println("线程2拿到锁了,所以更新");
                            RedisLock.unLock(jedis, vo.getPk(), redisService.beanToString(vo));
                        }else{
                            System.out.println("线程2没拿到锁,同一时刻无法更新");
                        }
                    }else{   //无数据则从数据库中获取数据更改
                        ContractVO vo =contractService.findbyContractPk("8888");
                        vo.setCode("55555");
                        contractService.update(vo);
                        redisService.set("contract",vo,2*60);
                    }
                }
            }).start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    @RequestMapping(value="/testCRUD")
//    public  String findByCont_codeAndCont_name(String cont_code,String cont_name){
//        StringBuffer result = new StringBuffer("");
//        List<ContractVO> list = contractService.findByCont_codeAndCont_name(cont_code,cont_name);
//        for(ContractVO vo:list){
//            result.append(vo.toString()+"\n");
//        }
//        return result.toString();
//    }
}