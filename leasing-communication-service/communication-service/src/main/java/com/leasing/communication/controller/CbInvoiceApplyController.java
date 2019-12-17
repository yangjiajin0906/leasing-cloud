package com.leasing.communication.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.base.ObjectUtil;
import com.leasing.common.utils.sys.ResultUtils;
import com.leasing.communication.entity.dos.CbInvoiceApplyDetailDO;
import com.leasing.communication.entity.query.AccruedQuery;
import com.leasing.communication.entity.query.CbCapitalQuery;
import com.leasing.communication.entity.query.CbInvoiceApplyDetailQuery;
import com.leasing.communication.entity.query.CbInvoiceApplyQuery;
import com.leasing.communication.entity.vo.CbInvoiceApplyDetailVO;
import com.leasing.communication.entity.vo.CbInvoiceApplyVO;
import com.leasing.communication.service.CbInvoiceApplyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019/11/18
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "/leasing/communication/cbInvoiceApply")
public class CbInvoiceApplyController {

    @Resource
    CbInvoiceApplyService invoiceApplyService;


    /**
     * 全部查询
     *
     * @param data     前台数据
     * @return map 结果集封装
     */
    @RequestMapping(value = "/queryForGrid", method = RequestMethod.POST)
    public ResResult queryForGrid(@RequestBody(required = false) String data) {
        Map<String,Object> map = JSON.parseObject(data,Map.class);
        Pagination pagination = JSON.parseObject(data,Pagination.class);
        Object queryData = map.get("queryData");
        CbInvoiceApplyQuery queryVO = new CbInvoiceApplyQuery();
        if(!ObjectUtil.isEmpty(queryData)){
            queryVO = JSON.parseObject(map.get("queryData").toString(),CbInvoiceApplyQuery.class);
        }
        PageQueryData<CbInvoiceApplyVO> pageQueryData = invoiceApplyService.pageQuery(pagination,queryVO,"cbInvoiceApplyRepo.pageQuery");
        return ResultUtils.successWithData(pageQueryData);
    }

    /**
     * 查询子表
     * @param query
     * @return
     */
    @PostMapping(value = "/subList")
    public ResResult subList(@RequestBody CbInvoiceApplyDetailQuery query){
//        CbInvoiceApplyDetailQuery query = JSON.parseObject(data, CbInvoiceApplyDetailQuery.class);
        List<CbInvoiceApplyDetailVO> list = invoiceApplyService.querySub(query);
        return ResultUtils.successWithData(list);
    }

    /**
     * 查查询未开票子表
     * @return
     */
    @PostMapping(value = "/subNotInvoice")
    public ResResult subNotInvoice(){
//        CbInvoiceApplyDetailQuery query = JSON.parseObject(data, CbInvoiceApplyDetailQuery.class);
        List<CbInvoiceApplyDetailVO> list = invoiceApplyService.queryNotInvoiceSubList();
        return ResultUtils.successWithData(list);
    }

    @PostMapping(value = "/save")
    public ResResult save(@RequestBody String data){
        List<CbInvoiceApplyDetailVO> list = JSON.parseArray(data, CbInvoiceApplyDetailVO.class);
        invoiceApplyService.save(list);
        return ResultUtils.success();
    }
}
