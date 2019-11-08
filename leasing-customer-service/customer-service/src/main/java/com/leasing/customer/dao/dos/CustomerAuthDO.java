package com.leasing.customer.dao.dos;

import com.leasing.common.base.entity.BaseBusinessDO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019-11-07
 * @author:zhangzhhn@yonyou.com
 * @description: 客户权限
 **/
@Entity
@Table(name = "yls_customer_auth")
public class CustomerAuthDO extends BaseBusinessDO {

    @Id
    private String pkCustomerAuth;

    private String pkCustomer;

    private String userId;

    public String getPkCustomerAuth() {
        return pkCustomerAuth;
    }

    public void setPkCustomerAuth(String pkCustomerAuth) {
        this.pkCustomerAuth = pkCustomerAuth;
    }

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getPk() {
        return pkCustomerAuth;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustomerAuth = pk;
    }
}