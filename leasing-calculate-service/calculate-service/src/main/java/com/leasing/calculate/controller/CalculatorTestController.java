package com.leasing.calculate.controller;

import com.leasing.calculate.service.CalculateService;
import com.leasing.calculate.vo.CalculatorVO;
import com.leasing.common.api.feign.calculate.CalculatorTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lvcn on 2019-9-18.
 */
@RestController
@RequestMapping(value = "/leasing/calculate")
public class CalculatorTestController implements CalculatorTest {

    @Resource
    CalculateService calculateService;

    @Override
    @RequestMapping(value = "/testFeign")
    public String TestFeign(String str) {
        List<CalculatorVO> list = calculateService.query();
        return "Test my fiegn interface "+ str;
    }



}
