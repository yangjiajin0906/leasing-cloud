package com.leasing.calculate.vo;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud 客户基本信息表Ref类
 * @date:2019/9/25
 * @author:Yjj@yonyou.com
 * @description:
 **/

@Entity
@Table(name="yls_customer")
public class CustomerRefVO {
    /**
     * 客户主键
     */
    @Id
    public String pk_customer;

    /**
     * 客户编号
     */
    public String customer_code;

    /**
     * 客户名称
     */
    public String customer_name;


    public CustomerRefVO() {
    }

    public String getPk_customer() {

        return pk_customer;
    }

    public void setPk_customer(String pk_customer) {
        this.pk_customer = pk_customer;
    }

    public String getCustomer_code() {
        return customer_code;
    }

    public void setCustomer_code(String customer_code) {
        this.customer_code = customer_code;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }
}