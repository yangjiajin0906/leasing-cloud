package com.leasing.customer.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.base.ResultUtils;
import com.leasing.customer.dao.query.CustRelatedCompanyQuery;
import com.leasing.customer.dao.vo.CustRelatedCompanyVO;
import com.leasing.customer.service.CustRelatedCompanyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-29
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping("/customer/customerSource")
public class CustomerSourceController {

    @Resource
    private CustRelatedCompanyService service;


    @PostMapping("/querySourceByCustomer")
    public ResResult querySourceByCustomer(String query) {
        CustRelatedCompanyQuery companyQuery = JSON.parseObject(query, CustRelatedCompanyQuery.class);
        Pagination pagination = new Pagination(1, 50);
        PageQueryData<CustRelatedCompanyVO> list = service.pageQuery(pagination, companyQuery);
        return ResultUtils.successWithData(list);
    }

}