package com.leasing.customer.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.query.CustEquityInvestmentQuery;
import com.leasing.customer.dao.repository.CustEquityInvestmentRepo;
import com.leasing.customer.dao.vo.CustEquityInvestmentVO;
import com.leasing.customer.service.CustEquityInvestmentService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-10-30
 * @author:zhangzhhn@yonyou.com
 * @description: 股权投资服务接口
 **/
@Repository("customer.CustEquityInvestmentService")
public class CustEquityInvestmentServiceImpl implements CustEquityInvestmentService {
    @Resource
    private CustEquityInvestmentRepo repo;

    @Override
    public PageQueryData<CustEquityInvestmentVO> pageData(Pagination pagination, CustEquityInvestmentQuery query) {
        query = new CustEquityInvestmentQuery();
        query.setPkCustomer("0001MG00000000030104");
        return repo.pageQuery(pagination, query, "custEquityInvestmentPageQuery");
    }
}