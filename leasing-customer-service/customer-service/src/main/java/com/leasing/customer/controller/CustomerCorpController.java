package com.leasing.customer.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.ResultUtils;
import com.leasing.customer.dao.query.CustomerCorpQuery;
import com.leasing.customer.dao.vo.CustomerAuthApplyVO;
import com.leasing.customer.dao.vo.CustomerAuthVO;
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
 * @description: 单位客户管理
 **/
@RestController
@RequestMapping(value = "/customer")
public class CustomerCorpController {

    @Resource
    private CustomerCorpService customerCorpService;


    /**
     * 根据客户主键查询客户详细信息
     *
     * @param pkCustomer 客户主键
     * @return com.leasing.common.base.web.ResResult
     */
    @PostMapping(value = "/corpFindOne")
    public ResResult corpFindOne(String pkCustomer) {
        CustomerCorpAllVO vo = customerCorpService.findOneAllByPkCustomer(pkCustomer);
        return ResultUtils.successWithData(vo);
    }

    /**
     * 根据查询条件查询单位客户分页查询
     *
     * @param conditions 客户查询条件
     * @return com.leasing.common.base.web.ResResult
     */
    @PostMapping(value = "/corpList")
    public ResResult corpList(String conditions) {
        CustomerCorpQuery query = JSON.parseObject(conditions, CustomerCorpQuery.class);
        Pagination pagination = new Pagination(1, 50);
        List<CustomerCorpAllVO> vo = customerCorpService.pageQuery(pagination, query);
        return ResultUtils.successWithData(vo);
    }


    /**
     * 校验客户名称是否重复
     *
     * @param customerName 客户名称
     * @return com.leasing.common.base.web.ResResult
     * 中如果data 是0则没有重复，否则有重复
     */
    @PostMapping(value = "/validateCustomerName")
    public ResResult validateCustomerName(String customerName) {
        return customerCorpService.validateCustomerName(customerName);
    }


    /**
     * 校验客户证件号码是否重复
     *
     * @param identityNo 客户名称
     * @return com.leasing.common.base.web.ResResult
     * 中如果data 是0则没有重复，否则有重复
     */
    @PostMapping(value = "/validateIdentityNo")
    public ResResult validateIdentityNo(String identityNo) {
        return customerCorpService.validateIdentityNo(identityNo);
    }


    /**
     * 保存、修改
     *
     * @param data 客户信息
     * @return com.leasing.common.base.web.ResResult
     */
    @PostMapping(value = "/save")
    public ResResult save(String data) {
        CustomerCorpAllVO vo = customerCorpService.findOneAllByPkCustomer("0001MG00000000030425");
        String ddd = JSON.toJSONString(vo);
//        CustomerCorpAllVO vo = JSON.parseObject(data, CustomerCorpAllVO.class);
        CustomerCorpAllVO fff = JSON.parseObject(ddd, CustomerCorpAllVO.class);
        fff.setPkCustomer("22222222222222222223");
        fff.setPkCustomerCorp("11111111111111111111");

        customerCorpService.save(fff);
        return ResultUtils.successWithData(vo);
    }

    /**
     * 删除单位客户
     *
     * @param data 客户主键
     * @return com.leasing.common.base.web.ResResult
     */
    @PostMapping(value = "/corpDelete")
    public ResResult corpDelete(String data) {
        CustomerCorpAllVO vo = JSON.parseObject(data, CustomerCorpAllVO.class);
        customerCorpService.delete(vo);
        return ResultUtils.successWithData("");
    }

    /**
     * 提交申请
     *
     * @param data 提交申请
     * @return
     */
    @PostMapping(value = "/submit")
    public ResResult submit(String data) {
        return null;
    }

    /**
     * 申请授权
     *
     * @param data 申请信息 CustomerAuthApplyVO
     * @return
     */
    @PostMapping(value = "/applyAuth")
    public ResResult applyAuth(String data) {
        CustomerAuthApplyVO vo = JSON.parseObject(data, CustomerAuthApplyVO.class);
        return customerCorpService.applyAuth(vo);
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
        return customerCorpService.doApplyAuth(list);
    }


    /**
     * 查询客户授权给了哪些用户
     *
     * @param pkCustomer 客户主键
     * @return 已授权用户列表List<CustomerAuthVO>
     */
    @PostMapping(value = "/queryAuth")
    public ResResult queryAuth(String pkCustomer) {

        return customerCorpService.queryAuth(pkCustomer);
    }

    /**
     * 收回授权
     *
     * @param data data为List<CustomerAuthVO>  在查询页面可以多选已经授权的用户
     * @return
     */
    @PostMapping(value = "/recoverAuth")
    public ResResult recoverAuth(String data) {
        List<CustomerAuthVO> list = JSON.parseArray(data, CustomerAuthVO.class);
        return customerCorpService.recoverAuth(list);
    }


}