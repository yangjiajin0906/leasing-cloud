package com.leasing.customer.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.base.ResultUtils;
import com.leasing.customer.dao.query.CustMedicalQualifyQuery;
import com.leasing.customer.service.CustMedicalQualifyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-10-31
 * @author:zhangzhhn@yonyou.com
 * @description: 医院资质
 **/
@RestController
@RequestMapping("/customer/custMedicalQualify")
public class CustMedicalQualifyController {

    @Resource
    private CustMedicalQualifyService service;

    /**
     * 医院资质信息分页查询
     *
     * @param query 查询条件
     * @return 分页列表
     */
    @PostMapping("/list")
    public ResResult list(String query) {
        CustMedicalQualifyQuery qualifyQuery = JSON.parseObject(query, CustMedicalQualifyQuery.class);
        Pagination pagination = new Pagination(1, 50);
        return ResultUtils.successWithData(service.pageQuery(pagination, qualifyQuery));
    }
}