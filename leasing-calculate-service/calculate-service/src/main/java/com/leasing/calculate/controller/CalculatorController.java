package com.leasing.calculate.controller;

import com.leasing.calculate.vo.CalculatorVO;
import com.leasing.calculate.service.CalculateService;
import com.leasing.common.api.feign.calculate.CalculatorTest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019/9/23
 * @author:Yjj@yonyou.comlist
 * @description:
 **/
@Api(value="报价接口", description = "报价接口")
@RestController
@RequestMapping(value = "/leasing/calculate")
public class CalculatorController implements CalculatorTest {

    @Resource
    CalculateService calculateService;

    @Override
    @RequestMapping(value = "/testFeign")
    public String TestFeign(String str) {
        return "Test my fiegn interface "+ str;
    }

    @ApiOperation("通过主键查询报价")
    @ApiImplicitParam(name = "id", value = "单个报价主键", dataType = "String")
    @RequestMapping(value = "/findOne")
    public CalculatorVO findById(String id) {
        CalculatorVO vo = calculateService.findOne("0001MG00000000036711");
        return vo;
    }

    @ApiOperation("更新报价")
    @ApiImplicitParam(name = "vo", value = "单个报价VO", dataType = "CalculatorVO")
    @RequestMapping(value = "/updateC")
    public void updateC(CalculatorVO vo){
        vo = calculateService.findOne("0001MG00000000038284");
        vo.setQuotName("yjj佳木斯电信-手机终端租赁");
        //vo.setPkLimitPlan(true);
        calculateService.update(vo);
    }

}
