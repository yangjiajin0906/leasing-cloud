package com.leasing.communication.controller;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.base.ResultUtils;
import com.leasing.communication.entity.dos.LeaseAccruedDO;
import com.leasing.communication.entity.query.LeaseAccruedQuery;
import com.leasing.communication.service.LeaseAccruedService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019/11/21
 * @author:Yjj@yonyou.com
 * @description: 月末计提Controller
 **/
@RestController
@RequestMapping(value = "/leasing/communication/accrued")
public class LeaseAccruedController {
    @Resource
    LeaseAccruedService leaseAccruedService;

    @RequestMapping(value = "/queryForGrid")
    public ResResult pageQuery(@RequestBody(required = false) String data){
        LeaseAccruedQuery leaseAccruedQuery = new LeaseAccruedQuery();
        Pagination pagination = new Pagination(1, 100);
        PageQueryData<LeaseAccruedDO> pageQueryData = leaseAccruedService.pageQuery(pagination,leaseAccruedQuery,"leaseAccruedRepo.pageQuery");
        return ResultUtils.successWithData(pageQueryData);
    }
}