package com.leasing.customer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.ResultUtils;
import com.leasing.customer.dao.vo.CustomerCorpAllVO;
import com.leasing.customer.service.CustomerCorpService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-21
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "/customer")
public class CustomerCorpController {

    @Resource
    private CustomerCorpService customerCorpService;


    /**
     * 根据客户主键查询客户详细信息
     * @param pkCustomer 客户主键
     * @return ResResult
     */
    @PostMapping(value = "/corpFindOne")
    public ResResult corpFindOne(String pkCustomer) {
        CustomerCorpAllVO vo = customerCorpService.findOneAllByPkCustomer(pkCustomer);
        return ResultUtils.successWithData(vo);
    }

    /**
     * 根据查询条件查询单位客户列表
     * @param conditions 客户查询条件
     * @return ResResult
     */
    @PostMapping(value = "/corpList")
    public ResResult corpList (String conditions) {
        JSONObject params = JSON.parseObject(conditions);
        List<CustomerCorpAllVO> vo = customerCorpService.findListByConditions(params);
        return ResultUtils.successWithData(vo);
    }


    /**
     * 根据查询条件查询单位客户列表
     * @param data 客户查询条件
     * @return ResResult
     */
    @PostMapping(value = "/saveOrUpdate")
    public ResResult saveOrUpdate (String data) {
        CustomerCorpAllVO vo = JSON.parseObject(data, CustomerCorpAllVO.class);

        CustomerCorpAllVO allVO = customerCorpService.findOneAllByPkCustomer("0001AA100000000R0E92");
        allVO.setBillstatus(Short.valueOf("204"));
        customerCorpService.saveOrUpdate(allVO);
        return ResultUtils.successWithData(vo);
    }



}