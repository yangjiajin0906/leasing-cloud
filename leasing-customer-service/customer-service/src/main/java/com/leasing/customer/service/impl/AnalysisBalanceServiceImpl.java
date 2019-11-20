package com.leasing.customer.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.query.AnalysisBalanceQuery;
import com.leasing.customer.dao.repository.AnalysisBalanceRepo;
import com.leasing.customer.dao.vo.AnalysisBalanceVO;
import com.leasing.customer.service.AnalysisBalanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Service("customer.AnalysisBalanceService")
public class AnalysisBalanceServiceImpl implements AnalysisBalanceService {

    @Resource
    private AnalysisBalanceRepo repo;

    @Override
    public PageQueryData<AnalysisBalanceVO> pageQuery(Pagination pagination, AnalysisBalanceQuery query) {
        return repo.pageQuery(pagination, query, "analysisBalancePageQuery");
    }
}