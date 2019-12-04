package com.leasing.customer.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.sys.ResultUtils;
import com.leasing.customer.dao.query.CustQualificationQuery;
import com.leasing.customer.service.CustQualificationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-10-30
 * @author:zhangzhhn@yonyou.com
 * @description: 资质认证
 **/
@RestController
@RequestMapping(value = "/customer/custQualification")
public class CustQualificationController {
    @Resource
    private CustQualificationService service;

    /**
     * 分页查询
     *
     * @param query 查询条件
     * @return com.leasing.common.base.web.ResResult
     */
    @PostMapping(value = "list")
    public ResResult list(String query) {
        CustQualificationQuery qualificationQuery = JSON.parseObject(query, CustQualificationQuery.class);
        Pagination pagination = new Pagination(1, 50);
        return ResultUtils.successWithData(service.pageQuery(pagination, qualificationQuery));
    }
}