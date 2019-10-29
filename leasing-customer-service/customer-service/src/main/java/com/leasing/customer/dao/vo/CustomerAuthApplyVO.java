package com.leasing.customer.dao.vo;

import com.leasing.common.base.entity.BaseBusinessVO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019-10-28
 * @author:zhangzhhn@yonyou.com
 * @description: 客户权限VO
 **/
@Entity
@Table(name = "yls_customer_auth_apply")
public class CustomerAuthApplyVO extends BaseBusinessVO {

    @Id
    private String pkCustomerAuthApply;

    @Override
    public String getPk() {
        return pkCustomerAuthApply;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustomerAuthApply = pk;
    }

    public String getPkCustomerAuthApply() {
        return pkCustomerAuthApply;
    }

    public void setPkCustomerAuthApply(String pkCustomerAuthApply) {
        this.pkCustomerAuthApply = pkCustomerAuthApply;
    }
}