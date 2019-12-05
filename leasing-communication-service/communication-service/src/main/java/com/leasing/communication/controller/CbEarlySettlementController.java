package com.leasing.communication.controller;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.sys.ResultUtils;
import com.leasing.communication.entity.query.AccruedQuery;
import com.leasing.communication.entity.vo.CbBadContractVO;
import com.leasing.communication.entity.vo.CbEarlySettlementVO;
import com.leasing.communication.service.CbBadContractService;
import com.leasing.communication.service.CbEarlySettlementService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019/11/21
 * @author:Yjj@yonyou.com
 * @description: 提前结清Controller
 **/
@RestController
@RequestMapping(value = "/leasing/communication/cbEarlySettlement")
public class CbEarlySettlementController {
    @Resource
    CbEarlySettlementService cbEarlySettlementService;

    @RequestMapping(value = "/queryForGrid")
    public ResResult pageQuery(@RequestBody(required = false) String data){
        BaseQuery baseQuery = new AccruedQuery();
        Pagination pagination = new Pagination(1, 100);
        PageQueryData<CbEarlySettlementVO> pageQueryData = cbEarlySettlementService.pageQuery(pagination,baseQuery,"cbEarlySettlementRepo.pageQuery");
        return ResultUtils.successWithData(pageQueryData);
    }
}