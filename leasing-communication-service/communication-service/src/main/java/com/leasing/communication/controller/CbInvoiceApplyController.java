package com.leasing.communication.controller;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.sys.ResultUtils;
import com.leasing.communication.entity.dos.CbInvoiceApplyDetailDO;
import com.leasing.communication.entity.query.AccruedQuery;
import com.leasing.communication.entity.vo.CbInvoiceApplyDetailVO;
import com.leasing.communication.service.CbInvoiceApplyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
     * @param page     当前页
     * @param pageSize 页数
     * @param data     前台数据
     * @return map 结果集封装
     */
    @RequestMapping(value = "/queryForGrid", method = RequestMethod.POST)
    public ResResult queryForGrid(@RequestBody(required = false) String data) {
        BaseQuery baseQuery = new AccruedQuery();
        Pagination pagination = new Pagination(1, 100);
        PageQueryData<CbInvoiceApplyDetailVO> pageQueryData = invoiceApplyService.pageQuery(pagination,baseQuery,"cbInvoiceApplyRepo.pageQuery");
        return ResultUtils.successWithData(pageQueryData);
    }
}
