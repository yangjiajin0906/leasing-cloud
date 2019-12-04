package com.leasing.communication.entity.query;

import com.leasing.common.base.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.enums.base.MatchType;

/**
 * @project:leasing-cloud
 * @date:2019/11/17
 * @author:wangjc@yonyou.com
 * @description: 2c客户信息查询VO
 **/
public class CustomerQuery extends BaseQuery {
    @QueryCondition(func = MatchType.like, field = "c.customerCode")
    private String customerCode;

    @QueryCondition(func = MatchType.like, field = "c.customerName")
    private String customerName;

    public CustomerQuery(){}

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