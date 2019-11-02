package com.leasing.customer.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.query.CustQualificationQuery;
import com.leasing.customer.dao.repository.CustQualificationRepo;
import com.leasing.customer.dao.vo.CustQualificationVO;
import com.leasing.customer.service.CustQualificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-10-30
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Service("customer.CustQualificationService")
public class CustQualificationServiceImpl implements CustQualificationService {

    @Resource
    private CustQualificationRepo repo;

    @Override
    public PageQueryData<CustQualificationVO> pageQuery(Pagination pagination, CustQualificationQuery query) {
        if (query == null) {
            query = new CustQualificationQuery();
        }
        query.setPkCustomer("0001MG00000000031290");
        return repo.pageQuery(pagination, query, "custQualificationPageQuery");
    }
}