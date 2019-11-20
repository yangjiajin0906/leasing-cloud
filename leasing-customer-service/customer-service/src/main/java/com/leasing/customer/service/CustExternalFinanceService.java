package com.leasing.customer.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.query.CustExternalFinanceQuery;
import com.leasing.customer.dao.vo.CustExternalFinanceVO;

/**
 * @project:leasing-cloud
 * @date:2019-11-12
 * @author:zhangzhhn@yonyou.com
 * @description: 其他融资服务接口
 **/
public interface CustExternalFinanceService {

    /**
     * 分页查询
     *
     * @param pagination 分页
     * @return 分页列表
     */
    PageQueryData<CustExternalFinanceVO> pageQuery(Pagination pagination, CustExternalFinanceQuery query);
}