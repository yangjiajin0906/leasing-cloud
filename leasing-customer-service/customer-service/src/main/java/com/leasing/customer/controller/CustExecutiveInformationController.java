package com.leasing.customer.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.sys.ResultUtils;
import com.leasing.customer.dao.query.CustExecutiveInformationQuery;
import com.leasing.customer.service.CustExecutiveInformationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-10-30
 * @author:zhangzhhn@yonyou.com
 * @description: 高管信息
 **/
@RestController
@RequestMapping(value = "/customer/custExecutiveInformation")
public class CustExecutiveInformationController {

    @Resource
    private CustExecutiveInformationService service;

    /**
     * 高管信息分页查询
     *
     * @param query 查询条件
     * @return 分页列表
     */
    @PostMapping(value = "/list")
    public ResResult list(String query) {
        CustExecutiveInformationQuery informationQuery = JSON.parseObject(query, CustExecutiveInformationQuery.class);
        Pagination pagination = new Pagination(1, 50);
        return ResultUtils.successWithData(service.pageQuery(pagination, informationQuery));
    }

}