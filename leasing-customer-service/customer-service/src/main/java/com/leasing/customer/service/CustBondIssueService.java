package com.leasing.customer.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.query.CustBondIssueQuery;
import com.leasing.customer.dao.vo.CustBondIssueVO;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description: 债券发行服务接口
 **/
public interface CustBondIssueService {

    /**
     * 分页列表
     *
     * @param pagination 分页
     * @param query      查询条件
     * @return 分页列表
     */
    PageQueryData<CustBondIssueVO> pageQuery(Pagination pagination, CustBondIssueQuery query);
}