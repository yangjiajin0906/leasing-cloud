package com.leasing.calculate.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.calculate.service.CalculateService;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.entity.calculate.dos.CalculatorDO;
import com.leasing.common.entity.calculate.dto.CalculatorDTO;
import com.leasing.common.entity.calculate.query.CalculatorQuery;
import com.leasing.common.entity.calculate.vo.base.CalculatorVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
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


    @ApiOperation("获得报价列表")
    @ApiImplicitParam(name = "data", value = "分页JSON串", dataType = "String")
    @RequestMapping(value = "/pageQuery")
    public PageQueryData<CalculatorVO> pageQuery(String data){
        Pagination pagination = new Pagination();
        pagination.setCurPage(1);
        pagination.setPageSize(10);
        CalculatorQuery query = new CalculatorQuery();
        PageQueryData<CalculatorVO> pageQueryData = calculateService.pageQuery(pagination,query);
        return pageQueryData;
    }

    @ApiOperation("通过主表主键查询 多个字表列表 数据")
    @ApiImplicitParam(name = "id", value = "报价主键", dataType = "String")
    @RequestMapping(value = "/listChild")
    public CalculatorDTO listChild(String data) {
        CalculatorDTO vo = calculateService.listChild("0001MG00000000036711",CalculatorDTO.class);
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
    @ApiImplicitParam(name = "data", value = "报价主键PK", dataType = "String")
    @RequestMapping(value = "/delete")
    public void delete(String data){
        CalculatorDO vo = calculateService.findOne(data);
        calculateService.delete(vo);
    }

    @ApiOperation("计算租金计划表")
    @ApiImplicitParam(name = "vo", value = "报价VO", dataType = "CalculatorDO")
    @RequestMapping(value = "/calOperateLease")
    public List calOperateLease(CalculatorVO vo){
        return calculateService.calOperateLease(vo);
    }

    @ApiOperation("计算计提结果表")
    @ApiImplicitParam(name = "", value = "", dataType = "String")
    @RequestMapping(value = "/calMakeResults")
    public List calMakeResults(){
        return calculateService.calMakeResults();
    }

    @ApiOperation("计算会计分摊表")
    @ApiImplicitParam(name = "", value = "", dataType = "String")
    @RequestMapping(value = "/calAccountingShare")
    public List calAccountingShare(){
        return calculateService.calAccountingShare();
    }

    @ApiOperation("计算IRR")
    @ApiImplicitParam(name = "", value = "", dataType = "String")
    @RequestMapping(value = "/calDayIRR")
    public BigDecimal calDayIRR(){
        return calculateService.calDayIRR();
    }

    @ApiOperation("专门用于C端业务批量计算")
    @ApiImplicitParam(name = "", value = "", dataType = "String")
    @RequestMapping(value = "/calBatchBusinessC")
    public List calBatchBusinessC(){
        return calculateService.calBatchBusinessC();
    }

}
