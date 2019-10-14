package com.leasing.customer_service.controller;

import com.alibaba.fastjson.JSONObject;
import com.leasing.common_service.utils.Result;
import com.leasing.customer_service.pojo.CustRelatedCompanyVO;
import com.leasing.customer_service.service.CustRelatedCompanyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-10-11
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping("/leasing/customer")
public class CustomerSourceController {

    @Resource
    private CustRelatedCompanyService custRelatedCompanyService;

    @PostMapping("/customerSourceList")
    public Result customerSourceList(String data) {

        CustRelatedCompanyVO vo = JSONObject.parseObject(data, CustRelatedCompanyVO.class);

        Result result = new Result();
        result.setData(custRelatedCompanyService.queryForGrid(vo));
        return result;

    }


}