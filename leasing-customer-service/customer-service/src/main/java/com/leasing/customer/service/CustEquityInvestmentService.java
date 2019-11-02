package com.leasing.customer.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.query.CustEquityInvestmentQuery;
import com.leasing.customer.dao.vo.CustEquityInvestmentVO;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-10-30
 * @author:zhangzhhn@yonyou.com
 * @description: 股权投资服务接口
 **/
public interface CustEquityInvestmentService {

    /**
     * 股权投资分页查询
     *
     * @param pagination 分页
     * @param query      查询条件
     * @return 分页列表
     */
    PageQueryData<CustEquityInvestmentVO> pageData(Pagination pagination, CustEquityInvestmentQuery query);
}