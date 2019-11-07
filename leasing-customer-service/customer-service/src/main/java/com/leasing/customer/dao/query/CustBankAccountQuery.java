package com.leasing.customer.dao.query;

import com.leasing.common.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.entity.BaseVO;

/**
 * @project:leasing-cloud
 * @date:2019-10-31
 * @author:zhangzhhn@yonyou.com
 * @description: 银行帐号查询
 **/
public class CustBankAccountQuery extends BaseQuery {

    @QueryCondition(field = "a.pkCustomer.pkCustomer")
    private String pkCustomer;

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }
}