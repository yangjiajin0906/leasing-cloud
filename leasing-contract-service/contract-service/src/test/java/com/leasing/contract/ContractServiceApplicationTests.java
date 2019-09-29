package com.leasing.contract;

//import com.leasing.contract.service.RedisService;
import com.leasing.contract.entity.ContractVO;
import com.leasing.contract.repository.ContractRepository;
import com.leasing.common.service.RedisService;
import com.leasing.contract.service.contractService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContractServiceApplication.class)
@WebAppConfiguration
public class ContractServiceApplicationTests {

    @Resource
    RedisService redisService;
    @Resource
    contractService contractService;

    @Resource
    ContractRepository contractRepository;

//    @Bean
//    public AuditorAware<String> auditorAware() {
//        return new AuditorAwareImpl();
//    }

    @Test
    public void contextLoads() {
    }

//    public static void main(String[] args) {
//        SpringApplication.run(ContractServiceApplicationTests.class, args);
//    }
    @Test
    public void TestSave(){
        System.out.println("修改合同数据");
        contractService.updateContractNamebyCode("sadada","2011-00005-015-237");
        ContractVO vo =contractService.findContractbyCode("2011-00005-015-237");
        System.out.println(vo.toString());
    }


    @Test
    public void TestContractsave(){


//        boolean haskey = redisService.hasKey("contract");
        ContractVO user = new ContractVO();
        user.setPk("777");
        user.setCode("222");
        user.setName("张三");
        boolean flag = redisService.set("sd",user,60*2);
//        if(haskey){  //存在则删除缓存中数据  保存后重新置入缓存
//            redisService.del("contract");
//        }
        contractRepository.save(user);
//        redisService.set("contract",user,60*2);
        System.out.println("保存业务对象实体数据");
    }

    @Test
    public void TestRedisget(){
//        Boolean haskey = redisService.hasKey("contract");
        ContractVO vo =new ContractVO();
//        if(haskey){  //存在即从缓存中获取指定数据
//            vo = redisService.get("contract",ContractVO.class);
//        }else {   //不存在则从数据库中获取指定数据
//            vo = contractService.findbyContractPk("11022");
//        }
        System.out.println("redis数据获取");
        long start = System.currentTimeMillis();
        vo = redisService.get("contract",ContractVO.class);
        System.out.println("==========从缓存中获得数据=========");
        System.out.println(vo.getContent());
        System.out.println("==============================");
        long end = System.currentTimeMillis();
        System.out.println("缓存查询redis花费的时间是:" + (end - start)+"ms");

        long start2 = System.currentTimeMillis();
        vo =  contractService.findbyContractPk("777");
        System.out.println("==========从数据库中获得数据=========");
        System.out.println(vo.getContent());
        System.out.println("==============================");
        long end2 = System.currentTimeMillis();
        System.out.println("数据库查询花费的时间是:" + (end2 - start2)+"ms");
    }


    @Test
    public void TestUpdate(){
        Optional<ContractVO> opt = contractService.findByPk("11022");
        opt.ifPresent(contractVO -> {
            contractVO.setCode("521521512");
            contractRepository.save(contractVO);
        });
        System.out.println("更改业务对象实体数据");
    }

    @Test
    public void TestOptimisticLock() {
        try {
            ContractVO vo = contractService.findbyContractPk("11022");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ContractVO vo = contractService.findbyContractPk("11022");
                    vo.setCode("4444");
                    contractRepository.save(vo);
                }
            }).start();
            Thread.sleep(1000);
            vo.setCode("66666");
            contractRepository.save(vo);
            System.out.println("测试乐观锁与独立事务");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
