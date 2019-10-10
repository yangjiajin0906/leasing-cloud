package com.leasing.sys.controller;

import com.leasing.common.service.RedisService;
import com.leasing.common.util.RedisLock;
import com.leasing.sys.entity.ContractVO;
import com.leasing.sys.service.contractService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.lettuce.core.RedisCommandTimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import javax.persistence.QueryTimeoutException;
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
@RequestMapping(value="/leasing/sys")
public class contractController{
    @Autowired
    private JedisPool jedisPool;

    @Resource
    contractService contractService;
    @Resource
    RedisService redisService;


    @RequestMapping(value = "/test")
    public String TestFeign() {
        return "合同新增节点测试";
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

    @RequestMapping(value="/testcopy")
    public void TestCopy(){
        StringBuffer print=new StringBuffer("");
        ContractVO contractVO =contractService.findbyContractPk("8888");
        ContractVO newvo = (ContractVO) contractVO.clone();
        ContractVO newvo1 = (ContractVO) contractVO.cloneWithoutProperties(new String[]{"code"});
        ContractVO newvo2 = (ContractVO) contractVO.cloneWithProperties(new String[]{"pk","code"});
        String modal[] = newvo.getAttributeNames();
        for(int i =0;i<modal.length;i++){
            Object k = newvo.getAttributeValue(modal[i]);
            print.append(k+",");
        }
        System.out.println("获取属性对象值打印:"+print);
        System.out.println("整体复制对象打印:"+newvo.toString());
        System.out.println("未改变时equals的值:"+newvo.equals(contractVO));
        System.out.println("忽略部分复制对象打印:"+newvo1.toString());
        System.out.println("选择部分复制对象打印:"+newvo2.toString());
        newvo.setAttributeValue("code","2224");
        System.out.println("改变对象属性值后打印:"+newvo.toString());
        System.out.println("改变属性值后equals的值:"+newvo.equals(contractVO));
    }


    @RequestMapping(value="/redisadd")
    public void TestContractsave(){
        ContractVO user = new ContractVO();
        user.setPk("8888");
        user.setCode("222");
        user.setName("张三");
        contractService.save(user);
        boolean haskey = redisService.hasKey("contract");
        if (haskey) {   //有则删除重新添加
            redisService.del("contract");
            redisService.set("contract", user, 2 * 60);
        }
        System.out.println("保存业务对象实体数据");
    }

    @RequestMapping(value="/redisget")
//    @HystrixCommand(fallbackMethod = "testRongduan")
    public String TestRedisget(){
            ContractVO vo =new ContractVO();
//        try {
            String requestid = UUID.randomUUID().toString();
            boolean haskey = redisService.hasKey("contract");
            if (haskey) {   //有数据则从缓存中获取数据更改
                vo = redisService.get("contract", ContractVO.class);
                Jedis jedis = jedisPool.getResource();
                //加锁，保证下面的代码单线程的访问
                boolean lockStatus = RedisLock.Lock(jedis, vo.getPk(), requestid, 100 * 1000);
                if (lockStatus) {
                    vo.setCode("1234");
                    redisService.del("contract");
                    redisService.set("contract", vo, 2 * 60);
                    System.out.println("线程1拿到锁了,所以更新");
                    RedisLock.unLock(jedis, vo.getPk(), requestid);
                    contractService.update(vo);
                } else {
                    System.out.println("单据信息已被他人修改,请刷新页面获取最新的单据信息");
                }
            } else {   //无数据则从数据库中获取数据更改  修改完成后插入缓存
                vo = contractService.findbyContractPk("8888");
                vo.setCode("555545");
                contractService.update(vo);
                redisService.set("contract", vo, 2 * 60);
            }
//        }catch (Exception e){     //redis请求超时 则直接操作数据库  不考虑大数据问题
//            vo = contractService.findbyContractPk("8888");
//            vo.setCode("444");
//            contractService.update(vo);
//        }
        return "测试延时";
//            Thread.sleep(1000);
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    String requestid = UUID.randomUUID().toString();
//                    boolean haskey = redisService.hasKey("contract");
//                    if(haskey){   //有数据则从缓存中获取数据更改
//                        ContractVO vo =redisService.get("contract",ContractVO.class);
//                        Jedis jedis = jedisPool.getResource();
//                        boolean lockStatus = RedisLock.Lock(jedis, vo.getPk(), requestid, 100000);
//                        if(lockStatus){
//                            vo.setCode("4444");
//                            redisService.del("contract");
//                            redisService.set("contract",vo,2*60);
//                            System.out.println("线程2拿到锁了,所以更新");
////                            RedisLock.unLock(jedis, vo.getPk(), requestid);
//                        }else{
//                            System.out.println("线程2没拿到锁,同一时刻无法更新");
//                        }
//                    }else{   //无数据则从数据库中获取数据更改
//                        ContractVO vo =contractService.findbyContractPk("8888");
//                        vo.setCode("55555");
//                        contractService.update(vo);
//                        redisService.set("contract",vo,2*60);
//                    }
//                }
//            }).start();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }

    private void testRongduan(){
        System.out.println("进入熔断暂时方法");
        ContractVO vo =contractService.findbyContractPk("8888");
        vo.setCode("1234");
        contractService.update(vo);
        System.out.println("退出熔断暂时方法");
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