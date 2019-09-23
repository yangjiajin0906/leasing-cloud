package com.leasing.customer.controller;

import com.leasing.customer.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-09-23
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@RequestMapping("/customer-service/customer")
@RestController
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @RequestMapping(value = "/list")
    public String getList() {
        return customerService.TestFeign("hello wrold1");
//        return "hello wrold";
    }
}