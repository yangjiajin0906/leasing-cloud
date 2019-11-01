package com.leasing.customer.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.query.CustExecutiveInformationQuery;
import com.leasing.customer.dao.repository.CustExecutiveInformationRepo;
import com.leasing.customer.service.CustExecutiveInformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-10-30
 * @author:zhangzhhn@yonyou.com
 * @description: 高管信息服务接口实现
 **/
@Service("customer.CustExecutiveInformationService")
public class CustExecutiveInformationServiceImpl implements CustExecutiveInformationService {
    @Resource
    private CustExecutiveInformationRepo repo;

    @Override
    public PageQueryData pageQuery(Pagination pagination, CustExecutiveInformationQuery query) {
        query = new CustExecutiveInformationQuery();
        query.setPkCustomer("0001MG00000000030104");
        return repo.pageQuery(pagination, query, "custExecutiveInformationPageQuery");
    }
}