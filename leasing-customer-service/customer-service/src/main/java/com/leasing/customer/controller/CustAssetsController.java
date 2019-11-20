package com.leasing.customer.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.base.ResultUtils;
import com.leasing.customer.dao.query.CustAssetsQuery;
import com.leasing.customer.dao.vo.CustAssetsVO;
import com.leasing.customer.service.CustAssetsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-11-12
 * @author:zhangzhhn@yonyou.com
 * @description: 客户资产
 **/
@RestController
@RequestMapping("/customer/custAssets")
public class CustAssetsController {

    @Resource
    private CustAssetsService service;

    /**
     * 分页查询
     *
     * @param query 查询条件
     * @return 查询列表
     */
    @PostMapping(value = "/list")
    public ResResult list(String query) {
        CustAssetsQuery assetsQuery = JSON.parseObject(query, CustAssetsQuery.class);
        Pagination pagination = new Pagination(1, 50);
        PageQueryData<CustAssetsVO> list = service.pageQuery(pagination, assetsQuery);
        return ResultUtils.successWithData(list);
    }
}