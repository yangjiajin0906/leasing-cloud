package com.leasing.calculate.controller;

import com.leasing.common.api.feign.calculate.CalculatorTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lvcn on 2019-9-18.
 */
@RestController
@RequestMapping(value = "/leasing/calculate")
public class CalculatorTestController implements CalculatorTest {

    @Override
    @RequestMapping(value = "/testFeign")
    public String TestFeign() {
        return "Test my fiegn interface";
    }



}
