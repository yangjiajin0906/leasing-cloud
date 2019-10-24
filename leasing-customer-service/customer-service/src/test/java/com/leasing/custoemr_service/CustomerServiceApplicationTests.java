package com.leasing.custoemr_service;


import com.leasing.customer.CustomerServiceApplication;
import com.leasing.customer.service.CustomerService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * @project:leasing-cloud
 * @date:2019-09-26
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/

@RunWith(SpringRunner.class)              //就是指用SpringJUnit4ClassRunner来运行
@WebAppConfiguration                                    //申明这是一个测试
@SpringBootTest(classes= CustomerServiceApplication.class)//引入springboot的入口
@Transactional
public class CustomerServiceApplicationTests {

    @Resource
    private CustomerService customerService;

//    @Test
//    public void getList () {
//        customerService.getList();
//        System.out.printf(customerService.getList().toString());
//    }
//
//    @Test
//    public void findOne () {
////        customerService.getList();
//        System.out.printf(customerService.queryByPK("0001MG00000000029248").toString());
//    }

//    @Test
//    public void insert() {
//        CustomerCorpVO vo = customerService.queryByPK("0001MG00000000029248");
//        vo.setPkCustomer("11111111111111111111");
//        vo.setPk_customer_corp("222222222222222222");
//        customerService.insert(vo);
//    }
}