package com.leasing.customer.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.query.CustBondIssueQuery;
import com.leasing.customer.dao.repository.CustBondIssueRepo;
import com.leasing.customer.dao.vo.CustBondIssueVO;
import com.leasing.customer.service.CustBondIssueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description: 债券发行服务接口实现类
 **/
@Service("customer.CustBondIssueService")
public class CustBondIssueServiceImpl implements CustBondIssueService {
    @Resource
    private CustBondIssueRepo repo;

    @Override
    public PageQueryData<CustBondIssueVO> pageQuery(Pagination pagination, CustBondIssueQuery query) {
        return repo.pageQuery(pagination, query, "custBondIssuePageQuery");
    }
}