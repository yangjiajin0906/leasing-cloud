package com.leasing.customer_service.controller;

import com.alibaba.fastjson.JSONObject;
import com.leasing.common_service.utils.Result;
import com.leasing.customer_service.pojo.CustomerCorpVO;
import com.leasing.customer_service.service.CustomerCorpService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-09-27
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "/leasing/customer")
public class CustomerCorpController {
    @Resource
    private CustomerCorpService corpService;

    @PostMapping(value = "/corpForGrid")
    public Result corpForGrid(String data) {
        Result result = new Result();
        CustomerCorpVO vo = JSONObject.parseObject(data, CustomerCorpVO.class);
        result.setData(corpService.queryForGrid(vo));
        return result;
    }
}