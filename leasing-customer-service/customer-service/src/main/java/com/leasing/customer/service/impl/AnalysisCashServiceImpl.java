package com.leasing.customer.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.query.AnalysisCashQuery;
import com.leasing.customer.dao.repository.AnalysisCashRepo;
import com.leasing.customer.dao.vo.AnalysisCashVO;
import com.leasing.customer.service.AnalysisCashService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Service("customer.AnalysisCashService")
public class AnalysisCashServiceImpl implements AnalysisCashService {
    @Resource
    private AnalysisCashRepo repo;

    @Override
    public PageQueryData<AnalysisCashVO> pageQuery(Pagination pagination, AnalysisCashQuery query) {
        return repo.pageQuery(pagination, query, "analysisCashPageQuery");
    }
}