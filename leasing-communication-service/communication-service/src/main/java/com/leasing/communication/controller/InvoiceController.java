package com.leasing.communication.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.base.ResultUtils;
import com.leasing.communication.entity.queryVO.ContractQueryVO;
import com.leasing.communication.entity.queryVO.InvoiceQueryVO;
import com.leasing.communication.service.InvoiceApplyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019/11/18
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "/leasing/communication/invoice")
public class InvoiceController {

    @Resource
    InvoiceApplyService invoiceApplyService;


    /**
     * 全部查询
     *
     * @param page     当前页
     * @param pageSize 页数
     * @param data     前台数据
     * @return map 结果集封装
     */
    @RequestMapping(value = "/queryForGrid", method = RequestMethod.POST)
    public ResResult queryForGrid(@RequestParam(required = false, defaultValue = "1", name = "page") Integer page,
                                  @RequestParam(required = false, defaultValue = "20", name = "pageSize") Integer pageSize,
                                  @RequestParam(required = false, name = "data") String data) {
        InvoiceQueryVO projectQueryVO = JSON.parseObject(data, InvoiceQueryVO.class);
        Pagination pagination = new Pagination(page, pageSize);
        PageQueryData pageQueryData = invoiceApplyService.pageData(projectQueryVO, pagination);
        return ResultUtils.successWithData(pageQueryData);
    }
}
