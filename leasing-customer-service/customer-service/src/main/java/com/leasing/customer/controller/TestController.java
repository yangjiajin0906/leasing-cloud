package com.leasing.customer.controller;

import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.base.ResultUtils;
import com.leasing.customer.dao.dos.CustomerCorpDO;
import com.leasing.customer.dao.repository.CustomerCorpRepo;
import com.leasing.customer.dao.repository.CustomerRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-10-22
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping("/testCtrl")
public class TestController {

    @Resource
    private CustomerCorpRepo customerCorpRepo;
    @Resource
    private CustomerRepo customerRepo;

    @PostMapping("/test")
    ResResult test () {
        String pk = "0001AA100000000R0E93";
        CustomerCorpDO obj = customerCorpRepo.findOne(pk);
        return ResultUtils.successWithData(obj);
    }

//    @PostMapping("/test1")
//    ResResult test1(){
//        String pk = "0001AA100000000R0E92";
//        Object obj = customerCorpRepository.findTest(pk);
//        return ResultUtils.successWithData(obj);
//    }


//    @PostMapping("/test2")
//    ResResult test2(){
//        String pk = "0001AA100000000R0E92";
//        Object obj = customerCorpRepository.findTest1();
//        return ResultUtils.successWithData(obj);
//    }
//    @PostMapping("/test3")
//    ResResult test3(){
//        String pk = "0001AA100000000R0E92";
//        Object obj = customerRepository.findTest(pk);
//        return ResultUtils.successWithData(obj);
//    }

    @PostMapping("/test4")
    ResResult test4() {
        String pk = "0001AA100000000R0E92";
        Object obj = customerCorpRepo.findOneAllByPkCustomer(pk);
        return ResultUtils.successWithData(obj);
    }


}