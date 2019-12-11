package com.leasing.communication.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.sys.ResultUtils;
import com.leasing.communication.entity.query.CbWithdrawDetailQuery;
import com.leasing.communication.entity.query.CbWithdrawQuery;
import com.leasing.communication.entity.vo.CbWithdrawDetailVO;
import com.leasing.communication.service.CbWithdrawService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-11-20
 * @author:zhangzhhn@yonyou.com
 * @description: 付款处理
 **/
@RestController
@RequestMapping("/leasing/communication/cbWithdraw")
public class CbWithdrawController {


    @Resource
    private CbWithdrawService withdrawService;
    /**
     * 分页查询
     *
     * @param data     数据
     * @return 分页列表
     */
    @PostMapping(value = "/list")
    public ResResult list(@RequestBody  String data) {

        CbWithdrawQuery queryVO = JSON.parseObject(data, CbWithdrawQuery.class);
        Pagination pagination = JSON.parseObject(data, Pagination.class);
        PageQueryData pageQueryData = withdrawService.pageQuery(pagination, queryVO);
        return ResultUtils.successWithData(pageQueryData);

    }


    @PostMapping(value = "/subList")
    public ResResult subList(@RequestBody String data) {
        CbWithdrawDetailQuery query = JSON.parseObject(data, CbWithdrawDetailQuery.class);
        List<CbWithdrawDetailVO> list = withdrawService.queryDetailByPkWithdraw(query.getPkWithdraw());
        return ResultUtils.successWithData(list);
    }


//    @PostMapping(value = "/gatherWithdraw")
//    public ResResult gatherWithdraw() {
//        withdrawService.gatherWithdraw("0000000000000001");
//        return ResultUtils.successWithData(null);
//    }

}