package com.leasing.custom.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jws.WebResult;

/**
 * Created by lvcn on 2019-9-20.
 */
@RestController
@RequestMapping(value = "/leasing/custom")
public class CustomTestController {

    @Resource
    FeignCalculatorTest feignCalculatorTest;
    @RequestMapping(value = "/test")
    public String CustomTest(){
        return feignCalculatorTest.TestFeign(" this is feignTest");
    }
}
