package com.leasing.communication.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.communication.entity.dos.LeaseAccruedDO;
import com.leasing.communication.entity.query.LeaseAccruedQuery;

/**
 * @project:leasing-cloud
 * @date:2019/11/21
 * @author:Yjj@yonyou.com
 * @description: 2c月末计提
 **/
public interface LeaseAccruedService {
    /**
     * 客户列表分页信息查询
     * @param pagination 分页条件
     * @param customerQuery 查询条件
     * @param queryName JPQL名称
     * @return
     */
    PageQueryData<LeaseAccruedDO> pageQuery(Pagination pagination, LeaseAccruedQuery leaseAccruedQuery, String queryName);
}