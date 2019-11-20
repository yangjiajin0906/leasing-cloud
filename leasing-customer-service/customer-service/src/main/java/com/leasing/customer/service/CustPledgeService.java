package com.leasing.customer.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.query.CustPledgeQuery;
import com.leasing.customer.dao.vo.CustPledgeVO;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description: 保证情况服务接口
 **/
public interface CustPledgeService {

    /**
     * 分页查询
     *
     * @param pagination 分页
     * @param query      查询条件
     * @return 分页列表
     */
    PageQueryData<CustPledgeVO> pageQuery(Pagination pagination, CustPledgeQuery query);
}