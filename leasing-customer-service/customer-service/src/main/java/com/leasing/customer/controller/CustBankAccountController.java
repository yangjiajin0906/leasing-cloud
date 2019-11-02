package com.leasing.customer.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.base.ResultUtils;
import com.leasing.customer.dao.query.CustBankAccountQuery;
import com.leasing.customer.service.CustBankAccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-10-31
 * @author:zhangzhhn@yonyou.com
 * @description: 客户银行账户
 **/
@RestController
@RequestMapping("/customer/custBankAccount")
public class CustBankAccountController {
    @Resource
    private CustBankAccountService service;

    /**
     * 分页查询列表
     *
     * @param query 查询条件
     * @return 分页
     */
    @PostMapping(value = "/list")
    public ResResult list(String query) {
        CustBankAccountQuery accountQuery = JSON.parseObject(query, CustBankAccountQuery.class);
        Pagination pagination = new Pagination(1, 50);
        return ResultUtils.successWithData(service.pageQuery(pagination, accountQuery));
    }


}