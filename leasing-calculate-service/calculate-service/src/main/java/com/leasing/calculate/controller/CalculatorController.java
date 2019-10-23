package com.leasing.calculate.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.calculate.dos.CalculatorDO;
import com.leasing.calculate.vo.CalculatorVO;
import com.leasing.calculate.service.CalculateService;
import com.leasing.common.api.feign.calculate.CalculatorTest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/9/23
 * @author:Yjj@yonyou.comlist
 * @description: 报价接口
 **/
@Api(value="报价接口", description = "报价接口")
@RestController
@RequestMapping(value = "/leasing/calculate")
public class CalculatorController {

    @Resource
    CalculateService calculateService;

//    @Override implements CalculatorTest
//    @RequestMapping(value = "/testFeign")
//    public String TestFeign(String str) {
//        return "Test my fiegn interface "+ str;
//    }

    @ApiOperation("获得报价列表")
    @ApiImplicitParam(name = "data", value = "分页JSON串 + 报价VO JSON串", dataType = "String")
    @RequestMapping(value = "/pageQuery")
    public List<CalculatorVO> pageQuery(String data){
        CalculatorDO vo = JSON.parseObject(data,CalculatorDO.class);
        return calculateService.pageQuery(null,vo);
    }

    @ApiOperation("获得字表数据")
    @ApiImplicitParam(name = "data", value = "报价VO JSON串", dataType = "String")
    @RequestMapping(value = "/getChildList")
    public List<CalculatorVO> getChildList(String data){
        CalculatorVO vo = null;
        return null;
    }

    @ApiOperation("通过主键查询报价数据")
    @ApiImplicitParam(name = "id", value = "报价主键", dataType = "String")
    @RequestMapping(value = "/findOne")
    public CalculatorVO findById(String id) {
        CalculatorVO vo = calculateService.findOne("0001MG00000000036711");
        return vo;
    }

    @ApiOperation("保存")
    @ApiImplicitParam(name = "data", value = "报价VO JSON串", dataType = "String")
    @RequestMapping(value = "/save")
    public CalculatorDO save(String data){
        CalculatorDO vo = JSON.parseObject(data,CalculatorDO.class);
        return calculateService.save(vo);
    }

    @ApiOperation("更新报价")
    @ApiImplicitParam(name = "data", value = "报价VO JSON串", dataType = "String")
    @RequestMapping(value = "/update")
    public CalculatorDO update(String data){
        CalculatorDO vo = JSON.parseObject(data,CalculatorDO.class);
        return calculateService.update(vo);
    }

    @ApiOperation("删除报价")
    @ApiImplicitParam(name = "data", value = "报价VO JSON串", dataType = "String")
    @RequestMapping(value = "/delete")
    public void delete(String data){
        CalculatorDO vo = JSON.parseObject(data,CalculatorDO.class);
        calculateService.delete(vo);
    }

}
