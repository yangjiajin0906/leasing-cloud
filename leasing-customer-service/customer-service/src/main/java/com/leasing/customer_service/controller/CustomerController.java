package com.leasing.customer_service.controller;

import com.leasing.customer_service.pojo.CustomerCorpVO;
import com.leasing.customer_service.pojo.CustomerVO;
import com.leasing.customer_service.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-09-23
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "/leasing/customer")
public class CustomerController {
//
    @Resource
    private CustomerService customerService;

    @RequestMapping(value = "/list")
    public List<CustomerCorpVO> getList() {

//        return customerService.queryAll();
        return null;
    }

//    @RequestMapping(value = "/findById")
//    public CustomerCorpVO findById() {
//        return customerService.queryByPK("0001MG00000000029122");
//    }
//
//    @RequestMapping(value = "/save")
//    public void save(CustomerCorpVO vo) {
//        CustomerCorpVO customerCorpVO = customerService.queryByPK("0001MG00000000029122");
//        vo.setPkOrg(customerCorpVO.getPkOrg());
//        vo.setPkCustomer("111111111111111");
//        customerService.insert(vo);
//    }

}