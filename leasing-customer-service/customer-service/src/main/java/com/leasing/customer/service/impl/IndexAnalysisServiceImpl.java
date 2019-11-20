package com.leasing.customer.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.query.IndexAnalysisQuery;
import com.leasing.customer.dao.repository.IndexAnalysisRepo;
import com.leasing.customer.dao.vo.IndexAnalysisVO;
import com.leasing.customer.service.IndexAnalysisService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Service("customer.IndexAnalysisService")
public class IndexAnalysisServiceImpl implements IndexAnalysisService {
    @Resource
    private IndexAnalysisRepo repo;
    @Override
    public PageQueryData<IndexAnalysisVO> pageQuery(Pagination pagination, IndexAnalysisQuery query) {
        return repo.pageQuery(pagination, query, "indexAnalysisPageQuery");
    }
}