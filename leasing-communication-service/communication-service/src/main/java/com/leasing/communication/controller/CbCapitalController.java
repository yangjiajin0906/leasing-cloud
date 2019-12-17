package com.leasing.communication.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.base.ObjectUtil;
import com.leasing.common.utils.sys.ResultUtils;
import com.leasing.communication.entity.query.AccruedQuery;
import com.leasing.communication.entity.query.CbCapitalQuery;
import com.leasing.communication.service.CbCapitalService;
import com.leasing.communication.service.CbFileOssService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019-11-20
 * @author:zhangzhhn@yonyou.com
 * @description: 收款处理
 **/
@RestController
@RequestMapping("/leasing/communication/capital")
public class CbCapitalController {
    @Resource
    private CbCapitalService service;
    @Resource
    CbFileOssService cbFileOssService;

    /**
     * 分页列表
     *
     * @param page     分页
     * @param pageSize 分页大小
     * @param data     分页数据
     * @return 分页列表
     */
    @PostMapping(value = "/list")
    public ResResult list(@RequestBody(required = false) String data) {
        Map<String,Object> map = JSON.parseObject(data,Map.class);
        Pagination pagination = JSON.parseObject(data,Pagination.class);
        Object queryData = map.get("queryData");
        CbCapitalQuery queryVO = new CbCapitalQuery();
        if(!ObjectUtil.isEmpty(queryData)){
            queryVO = JSON.parseObject(map.get("queryData").toString(),CbCapitalQuery.class);
        }
        PageQueryData pageQueryData = service.pageQuery(pagination, queryVO);
        return ResultUtils.successWithData(pageQueryData);
    }


    @PostMapping(value = "/totalCapital")
    public ResResult totalCapital() {
        cbFileOssService.fileImportByDate();
        return ResultUtils.successWithData(null);
    }

}