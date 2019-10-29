package com.leasing.customer.controller;

import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.ResultUtils;
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
     * @param pkCustomer 客户主键
     * @return 股东情况
     */
    @PostMapping("/queryHoldersByPkCustomer")
    public ResResult queryHoldersByPkCustomer(String pkCustomer) {
        return ResultUtils.successWithData(service.findByCustomer(pkCustomer));
    }
}