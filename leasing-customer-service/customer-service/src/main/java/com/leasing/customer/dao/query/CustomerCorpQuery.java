package com.leasing.customer.dao.query;

import com.leasing.common.base.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.enums.base.MatchType;

/**
 * @project:leasing-cloud
 * @date:2019-10-23
 * @author:zhangzhhn@yonyou.com
 * @description: 单位客户查询条件
 **/
public class CustomerCorpQuery extends BaseQuery {

    @QueryCondition
    private String customerCode;

    @QueryCondition(func = MatchType.like)
    private String customerName;


    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}