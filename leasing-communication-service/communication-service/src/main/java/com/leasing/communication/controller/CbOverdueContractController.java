package com.leasing.communication.controller;

import antlr.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.base.ObjectUtil;
import com.leasing.common.utils.sys.ResultUtils;
import com.leasing.communication.entity.query.AccruedQuery;
import com.leasing.communication.entity.query.CbOverdueContractQuery;
import com.leasing.communication.entity.vo.CbEarlySettlementVO;
import com.leasing.communication.entity.vo.CbOverdueContractVO;
import com.leasing.communication.service.CbEarlySettlementService;
import com.leasing.communication.service.CbOverdueContractService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019/11/21
 * @author:Yjj@yonyou.com
 * @description: 逾期合同Controller
 **/
@RestController
@RequestMapping(value = "/leasing/communication/cbOverdueContract")
public class CbOverdueContractController {
    @Resource
    CbOverdueContractService cbOverdueContractService;

    @RequestMapping(value = "/queryForGrid")
    public ResResult pageQuery(@RequestBody(required = false) String data){
        Map<String,Object> map = JSON.parseObject(data,Map.class);
        Object queryData = map.get("queryData");
        CbOverdueContractQuery baseQuery = new CbOverdueContractQuery();
        if(!ObjectUtil.isEmpty(queryData)){
            baseQuery = JSON.parseObject(map.get("queryData").toString(),CbOverdueContractQuery.class);
        }
        Pagination pagination = new Pagination(Integer.valueOf(map.get("pageIndex").toString()), Integer.valueOf(map.get("pageSize").toString()));
        PageQueryData<CbOverdueContractVO> pageQueryData = cbOverdueContractService.pageQuery(pagination,baseQuery,"cbOverdueContractRepo.pageQuery");
        return ResultUtils.successWithData(pageQueryData);
    }
}