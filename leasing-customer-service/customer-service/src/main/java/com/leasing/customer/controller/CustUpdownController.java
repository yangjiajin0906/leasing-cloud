package com.leasing.customer.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.sys.ResultUtils;
import com.leasing.customer.dao.query.CustUpdownQuery;
import com.leasing.customer.service.CustUpdownService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description: 上下游客户
 **/
@RestController
@RequestMapping("/customer/custUpdown")
public class CustUpdownController {

    @Resource
    private CustUpdownService service;

    /**
     * 分页查询
     *
     * @param query 查询条件
     * @return 分页列表
     */
    @PostMapping(value = "/list")
    public ResResult list(String query) {
        CustUpdownQuery updownQuery = JSON.parseObject(query, CustUpdownQuery.class);
        Pagination pagination = new Pagination(1, 50);
        return ResultUtils.successWithData(service.pageQuery(pagination, updownQuery));
    }
}