package com.leasing.communication.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.sys.ResultUtils;
import com.leasing.common.utils.base.ResultUtils;
import com.leasing.communication.entity.query.WithdrawQueryVO;
import com.leasing.communication.service.WithdrawService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-11-20
 * @author:zhangzhhn@yonyou.com
 * @description: 付款处理
 **/
@RestController
@RequestMapping("/leasing/communication/withdraw")
public class WithdrawController {


    @Resource
    private WithdrawService withdrawService;
    /**
     * 分页查询
     *
     * @param page     当前页
     * @param pageSize 页面
     * @param data     数据
     * @return 分页列表
     */
    @PostMapping(value = "/list")
    public ResResult list(@RequestParam(required = false, defaultValue = "1", name = "page") Integer page,
                          @RequestParam(required = false, defaultValue = "20", name = "pageSize") Integer pageSize,
                          @RequestParam(required = false, name = "data") String data) {

        WithdrawQueryVO queryVO = JSON.parseObject(data, WithdrawQueryVO.class);
        Pagination pagination = new Pagination(page, pageSize);
        PageQueryData pageQueryData = withdrawService.pageQuery(pagination, queryVO);
        return ResultUtils.successWithData(pageQueryData);

    }


    @PostMapping(value = "/gatherWithdraw")
    public ResResult gatherWithdraw() {
        withdrawService.gatherWithdraw("0000000000000001");
        return ResultUtils.successWithData(null);
    }

}