package com.leasing.communication.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.communication.entity.dos.LeaseAccruedDO;
import com.leasing.communication.entity.query.LeaseAccruedQuery;
import com.leasing.communication.repository.LeaseAccruedRepo;
import com.leasing.communication.service.LeaseAccruedService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * @project:leasing-cloud
 * @date:2019/11/21
 * @author:Yjj@yonyou.com
 * @description:
 **/
@Transactional
@Service("communication.LeaseAccruedServiceImpl")
public class LeaseAccruedServiceImpl implements LeaseAccruedService{
    @Resource
    LeaseAccruedRepo leaseAccruedRepo;

    @Override
    public PageQueryData<LeaseAccruedDO> pageQuery(Pagination pagination, LeaseAccruedQuery leaseAccruedQuery, String queryName) {
        return leaseAccruedRepo.pageQuery(pagination, leaseAccruedQuery, queryName);
    }
}