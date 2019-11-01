package com.leasing.customer.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.base.ResultUtils;
import com.leasing.customer.dao.query.CustContactQuery;
import com.leasing.customer.service.CustContactService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-10-31
 * @author:zhangzhhn@yonyou.com
 * @description: 其他联系人
 **/
@RestController
@RequestMapping("/customer/custContact")
public class CustContactController {

    @Resource
    private CustContactService service;


    /**
     * 分页查询
     *
     * @param query 查询条件
     * @return 分页列表
     */

    @PostMapping(value = "/list")
    public ResResult list(String query) {
        CustContactQuery contactQuery = JSON.parseObject(query, CustContactQuery.class);
        Pagination pagination = new Pagination(1, 50);
        return ResultUtils.successWithData(service.pageQuery(pagination, contactQuery));
    }
}