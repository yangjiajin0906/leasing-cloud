package com.leasing.customer.dao.query;

import com.leasing.common.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;
import org.springframework.data.jpa.repository.Query;

/**
 * @project:leasing-cloud
 * @date:2019-10-31
 * @author:zhangzhhn@yonyou.com
 * @description: 联系人
 **/
public class CustContactQuery extends BaseQuery {
    @QueryCondition(field = "a.pkCustomer.pkCustomer")
    private String pkCustomer;

    @QueryCondition
    private Short contactType;

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public Short getContactType() {
        return contactType;
    }

    public void setContactType(Short contactType) {
        this.contactType = contactType;
    }
}