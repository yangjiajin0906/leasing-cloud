package com.leasing.communication.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.sys.ResultUtils;
import com.leasing.communication.entity.dos.AccruedDO;
import com.leasing.communication.entity.query.AccruedQuery;
import com.leasing.communication.entity.vo.AccruedVO;
import com.leasing.communication.entity.vo.CbBadContractVO;
import com.leasing.communication.service.AccruedService;
import com.leasing.communication.service.CbBadContractService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/21
 * @author:Yjj@yonyou.com
 * @description: 不良合同Controller
 **/
@RestController
@RequestMapping(value = "/leasing/communication/cbBadContract")
public class CbBadContractController {
    @Resource
    CbBadContractService cbBadContractService;

    @RequestMapping(value = "/queryForGrid")
    public ResResult pageQuery(@RequestBody(required = false) String data){
        BaseQuery baseQuery = new AccruedQuery();
        Pagination pagination = new Pagination(1, 100);
        PageQueryData<CbBadContractVO> pageQueryData = cbBadContractService.pageQuery(pagination,baseQuery,"cbBadContractRepo.pageQuery");
        return ResultUtils.successWithData(pageQueryData);
    }
}