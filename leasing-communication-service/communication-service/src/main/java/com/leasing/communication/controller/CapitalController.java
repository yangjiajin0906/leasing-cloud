package com.leasing.communication.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.base.ResultUtils;
import com.leasing.communication.entity.query.CapitalQueryVO;
import com.leasing.communication.service.CapitalService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-11-20
 * @author:zhangzhhn@yonyou.com
 * @description: 收款处理
 **/
@RestController
@RequestMapping("/leasing/communication/capital")
public class CapitalController {
    @Resource
    private CapitalService service;

    /**
     * 分页列表
     *
     * @param page     分页
     * @param pageSize 分页大小
     * @param data     分页数据
     * @return 分页列表
     */
    @PostMapping(value = "/list")
    public ResResult list(@RequestParam(required = false, defaultValue = "1", name = "page") Integer page,
                          @RequestParam(required = false, defaultValue = "20", name = "pageSize") Integer pageSize,
                          @RequestParam(required = false, name = "data") String data) {

        CapitalQueryVO queryVO = JSON.parseObject(data, CapitalQueryVO.class);
        Pagination pagination = new Pagination(page, pageSize);
        PageQueryData pageQueryData = service.pageQuery(pagination, queryVO);
        return ResultUtils.successWithData(pageQueryData);

    }

}