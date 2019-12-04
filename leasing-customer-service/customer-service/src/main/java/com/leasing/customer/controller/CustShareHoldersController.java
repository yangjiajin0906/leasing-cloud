package com.leasing.customer.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.sys.ResultUtils;
import com.leasing.customer.dao.query.CustShareHoldersQuery;
import com.leasing.customer.service.CustShareHoldersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-10-29
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "/customer")
public class CustShareHoldersController {
    @Resource
    private CustShareHoldersService service;

    /**
     * 根据客户主键查询客户股东情况
     *
     * @param query 查询条件
     * @return 股东情况
     */
    @PostMapping("/queryHoldersByPkCustomer")
    public ResResult queryHoldersByPkCustomer(String query) {
        CustShareHoldersQuery holdersQuery = JSON.parseObject(query, CustShareHoldersQuery.class);
        Pagination pagination = new Pagination(1, 50);
        return ResultUtils.successWithData(service.pageQuery(pagination, holdersQuery));
    }
}