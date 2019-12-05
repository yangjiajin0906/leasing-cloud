package com.leasing.communication.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.sys.ResultUtils;
import com.leasing.communication.entity.query.WithdrawDetailQuery;
import com.leasing.communication.entity.vo.WithdrawDetailVO;
import com.leasing.communication.service.WithdrawDetailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-12-02
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "communication.withdrawDetail")
public class WithdrawDetailController {

    @Resource
    private WithdrawDetailService service;


    /**
     * 分页查询
     *
     * @param query 查询条件
     * @return 分页列表
     */
    @RequestMapping(value = "/list")
    public ResResult list(String query) {
        Pagination pagination = new Pagination(1, 50);
        WithdrawDetailQuery detailQuery = JSON.parseObject(query, WithdrawDetailQuery.class);
        PageQueryData<WithdrawDetailVO> list = service.pageQuery(pagination, detailQuery);
        return ResultUtils.successWithData(list);
    }
}