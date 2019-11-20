package com.leasing.customer.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.query.CustPledgeQuery;
import com.leasing.customer.dao.repository.CustPledgeRepo;
import com.leasing.customer.dao.vo.CustPledgeVO;
import com.leasing.customer.service.CustPledgeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Service("customer.CustPledgeService")
public class CustPledgeServiceImpl implements CustPledgeService {
    @Resource
    private CustPledgeRepo repo;
    @Override
    public PageQueryData<CustPledgeVO> pageQuery(Pagination pagination, CustPledgeQuery query) {
        return repo.pageQuery(pagination, query, "custPledgePageQuery");
    }
}