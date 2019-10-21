package com.leasing.rentearly.rentearlyservice.projectInfo.controller;

import com.leasing.rentearly.rentearlyservice.projectInfo.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/10/21
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    TestService testService;


    @RequestMapping("/test")
    public List test(){
        return testService.queryForList();
    }

    @RequestMapping("/testLock")
    public void testLock(){
        testService.testLock();
    }

}
