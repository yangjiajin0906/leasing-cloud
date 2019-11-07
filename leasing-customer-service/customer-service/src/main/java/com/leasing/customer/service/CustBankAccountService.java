package com.leasing.customer.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.query.CustBankAccountQuery;
import com.leasing.customer.dao.vo.CustBankAccountVO;

/**
 * @project:leasing-cloud
 * @date:2019-10-31
 * @author:zhangzhhn@yonyou.com
 * @description: 银行帐号
 **/
public interface CustBankAccountService {

    /**
     * 银行账户分页查询
     *
     * @param pagination 分页
     * @param query      查询条件
     * @return 分页列表
     */
    PageQueryData<CustBankAccountVO> pageQuery(Pagination pagination, CustBankAccountQuery query);
}