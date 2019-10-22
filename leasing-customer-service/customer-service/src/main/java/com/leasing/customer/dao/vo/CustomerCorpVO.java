package com.leasing.customer.dao.vo;


import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.dto.sys.ParameterDTO;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019-10-21
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/

@Entity
@Table(name = "yls_customer_corp")
public class CustomerCorpVO extends BaseVO {

    /**
     * 客户主键
     */
    @Id
    private String pkCustomerCorp;

    private String pkCustomer;

    /**
     * 客户性质
     */
    @ManyToOne
    @JoinColumn(name="customerProperty")
    @Fetch(FetchMode.JOIN)
    public ParameterDTO customerProperty;


    /**
     * 客户性质
     */
    @ManyToOne
    @JoinColumn(name="customerPropertyIn")
    @Fetch(FetchMode.JOIN)
    public ParameterDTO customerPropertyIn;

    public CustomerCorpVO(){}

    public String getPkCustomerCorp() {
        return pkCustomerCorp;
    }

    public void setPkCustomerCorp(String pkCustomerCorp) {
        this.pkCustomerCorp = pkCustomerCorp;
    }

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    @Override
    public String getPk() {
        return this.pkCustomerCorp;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustomerCorp=pk;
    }

    public ParameterDTO getCustomerProperty() {
        return customerProperty;
    }

    public void setCustomerProperty(ParameterDTO customerProperty) {
        this.customerProperty = customerProperty;
    }

    public ParameterDTO getCustomerPropertyIn() {
        return customerPropertyIn;
    }

    public void setCustomerPropertyIn(ParameterDTO customerPropertyIn) {
        this.customerPropertyIn = customerPropertyIn;
    }
}