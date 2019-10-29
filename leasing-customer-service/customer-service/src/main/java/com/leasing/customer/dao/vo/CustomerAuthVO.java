package com.leasing.customer.dao.vo;

import com.leasing.common.base.entity.BaseBusinessVO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019-10-28
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yls_customer_auth")
public class CustomerAuthVO extends BaseBusinessVO {

    @Id
    private String pkCustomerAuth;

    @Override
    public String getPk() {
        return pkCustomerAuth;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustomerAuth = pk;
    }

    public String getPkCustomerAuth() {
        return pkCustomerAuth;
    }

    public void setPkCustomerAuth(String pkCustomerAuth) {
        this.pkCustomerAuth = pkCustomerAuth;
    }
}