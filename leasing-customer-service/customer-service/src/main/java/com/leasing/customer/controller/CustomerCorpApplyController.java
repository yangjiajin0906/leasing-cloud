package com.leasing.customer.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.exception.BaseException;
import com.leasing.common.utils.base.ResultUtils;
import com.leasing.customer.dao.vo.CustomerCorpAllVO;
import com.leasing.customer.dao.vo.CustomerVO;
import com.leasing.customer.service.CustomerCorpService;
import com.leasing.customer.service.CustomerService;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-11-01
 * @author:zhangzhhn@yonyou.com
 * @description: 单位客户新增
 **/
@RestController
@RequestMapping("customer/customerCorpApply")
public class CustomerCorpApplyController {
    @Resource
    private CustomerCorpService service;
    @Resource
    private CustomerService customerService;

    /**
     * 保存客户
     *
     * @param data 客户数据
     * @return 客户信息
     */
    @PostMapping(value = "/save")
    public ResResult save(String data) {
        CustomerCorpAllVO vo = JSON.parseObject(data, CustomerCorpAllVO.class);

        //1.校验客户 税务登记证号(国税)、税务登记证号(地税)与 营业执照号码 唯一
        String exception = service.checkUnique(vo);

        //2.如果违反唯一性校验 抛出信息
        if (StringUtils.isNotBlank(exception)) {
            throw new BaseException(exception);
        }

        //3. 初始化相关的操作信息，如果是修改 如果是保存客户，
        CustomerCorpAllVO resVO = service.save(vo);
        return ResultUtils.successWithData(resVO);
    }

    /**
     * 删除单位客户 （只有生效才可以删除）
     *
     * @param data 单位客户
     * @return 删除成功
     */
    @PostMapping(value = "/delete")
    public ResResult delete(String data) {
        CustomerCorpAllVO vo = JSON.parseObject(data, CustomerCorpAllVO.class);
        //删除
        Boolean flag = service.delete(vo);
        return flag ? ResultUtils.success("删除成功!") : ResultUtils.failure("客户已生效，不能删除！");
    }


    /**
     * 客户生效
     *
     * @param data 客户信息
     */
    @PostMapping(value = "/effect")
    public ResResult effect(String data) {
        CustomerVO vo = JSON.parseObject(data, CustomerVO.class);
        //调用客户生效方法
        customerService.effect(vo);
        return ResultUtils.success("操作成功！");
    }
}