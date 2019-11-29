package com.leasing.communication.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.base.ResultUtils;
import com.leasing.communication.entity.dos.AccruedDO;
import com.leasing.communication.entity.query.AccruedQuery;
import com.leasing.communication.entity.vo.AccruedVO;
import com.leasing.communication.service.AccruedService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/21
 * @author:Yjj@yonyou.com
 * @description: 月末计提Controller
 **/
@RestController
@RequestMapping(value = "/leasing/communication/accrued")
public class AccruedController {
    @Resource
    AccruedService leaseAccruedService;

    @RequestMapping(value = "/queryForGrid")
    public ResResult pageQuery(@RequestBody(required = false) String data){
        AccruedQuery leaseAccruedQuery = new AccruedQuery();
        Pagination pagination = new Pagination(1, 100);
        PageQueryData<AccruedDO> pageQueryData = leaseAccruedService.pageQuery(pagination,leaseAccruedQuery,"accruedRepo.pageQuery");
        return ResultUtils.successWithData(pageQueryData);
    }

    @RequestMapping(value = "/onAdd")
    public ResResult onAdd(@RequestBody(required = false) String data){
        AccruedVO vo = JSON.parseObject(data,AccruedVO.class);
        List<AccruedVO> list = null;
        vo = leaseAccruedService.onAdd("1003","2019-05", list);
        return ResultUtils.successWithData(vo);
    }
}