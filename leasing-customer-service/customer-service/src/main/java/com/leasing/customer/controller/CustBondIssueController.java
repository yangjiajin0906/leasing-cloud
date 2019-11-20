package com.leasing.customer.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.base.ResultUtils;
import com.leasing.customer.dao.query.CustBondIssueQuery;
import com.leasing.customer.service.CustBondIssueService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description: 债券发行
 **/
@RestController
@RequestMapping("/customer/custBondIssue")
public class CustBondIssueController {

    @Resource
    private CustBondIssueService service;


    /**
     * 债券发行分页查询
     *
     * @param query 查询条件
     * @return 分页列表
     */
    @PostMapping("/list")
    public ResResult list(String query) {
        CustBondIssueQuery issueVO = JSON.parseObject(query, CustBondIssueQuery.class);
        Pagination pagination = new Pagination(1, 50);
        return ResultUtils.successWithData(service.pageQuery(pagination, issueVO));

    }
}