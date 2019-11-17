package com.leasing.customer.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.base.ResultUtils;
import com.leasing.customer.dao.query.CustomerAuthQuery;
import com.leasing.customer.dao.query.CustomerCorpQuery;
import com.leasing.customer.dao.vo.CustomerAuthVO;
import com.leasing.customer.service.CustomerAuthService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-11-07
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "/customer/customerAuth")
public class CustomerAuthController {

    @Resource
    private CustomerAuthService service;


    /**
     * 查询客户授权给了哪些用户
     *
     * @param query 客户主键
     * @return 已授权用户列表List<CustomerAuthVO>
     */
    @PostMapping(value = "/list")
    public ResResult queryAuth(String query) {
        CustomerAuthQuery customerCorpQuery = JSON.parseObject(query, CustomerAuthQuery.class);
        Pagination pagination = new Pagination(1, 50);
        return ResultUtils.successWithData(service.pageQuery(pagination, customerCorpQuery));
    }


    /**
     * 收回授权
     *
     * @param data data为List<CustomerAuthVO>  在查询页面可以多选已经授权的用户
     * @return
     */
    @PostMapping(value = "/recoverAuth")
    public ResResult recoverAuth(String data) {
        CustomerAuthVO authVO = JSON.parseObject(data, CustomerAuthVO.class);
        service.recoverAuth(authVO);
        return ResultUtils.success();
    }

    /**
     * 授权（可为多人开通权限）
     *
     * @param data 申请信息  data为List<CustomerAuthVO>
     * @return
     */
    @PostMapping(value = "/doAuth")
    public ResResult doAuth(String data) {
        List<CustomerAuthVO> list = JSON.parseArray(data, CustomerAuthVO.class);
        service.doAuth(list);
        return ResultUtils.success();
    }


}