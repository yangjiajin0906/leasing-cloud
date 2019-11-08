package com.leasing.customer.dao.vo;

import com.leasing.common.base.entity.BaseBusinessVO;
import com.leasing.common.dto.customer.CustomerDTO;
import com.leasing.common.vo.foundation.UserVO;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "pkCustomer")
    private CustomerDTO pkCustomer;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserVO userId;

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