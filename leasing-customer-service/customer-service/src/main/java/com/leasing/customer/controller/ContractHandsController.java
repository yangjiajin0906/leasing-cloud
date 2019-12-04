package com.leasing.customer.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.sys.ResultUtils;
import com.leasing.customer.dao.query.ContractHandsQuery;
import com.leasing.customer.service.ContractHandsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description: 在手合同
 **/
@RestController
@RequestMapping("/customer/contractHands")
public class ContractHandsController {
    @Resource
    private ContractHandsService service;


    /**
     * 分页查询
     *
     * @param query 查询条件
     * @return 查询列表
     */
    @PostMapping(value = "/list")
    public ResResult list(String query) {
        ContractHandsQuery handsQuery = JSON.parseObject(query, ContractHandsQuery.class);
        Pagination pagination = new Pagination(1, 50);
        return ResultUtils.successWithData(service.queryPage(pagination, handsQuery));
    }
}