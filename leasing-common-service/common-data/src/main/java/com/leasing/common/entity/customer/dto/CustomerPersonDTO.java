package com.leasing.common.entity.customer.dto;

import com.leasing.common.base.entity.BaseBusinessVO;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019-11-06
 * @author:zhangzhhn@yonyou.com
 * @description: 联系人
 **/
@Entity
@Table(name = "yls_customer")
@SecondaryTable(name = "yls_customer_person", pkJoinColumns =
        {@PrimaryKeyJoinColumn(name = "pkCustomer", referencedColumnName = "pkCustomer")})
public class CustomerPersonDTO {

    @Id
    private String pkCustomer;

    private String customerName;

    private String customerCode;

    private String customerType;

    /**
     * 证件类型
     */
    private Short identityType;

    private String identityNo;

    @Column(table = "yls_customer_person")
    private String fax;

    @Column(table = "yls_customer_person")
    private String department;

    @Column(table = "yls_customer_person")
    private String duty;

    /**
     * 手机号码
     */
    @Column(table = "yls_customer_person")
    private String mobile;

    /**
     * 电子邮箱
     */
    @Column(table = "yls_customer_person")
    private String email;

    /**
     * 单位电话
     */
    @Column(table = "yls_customer_person")
    private String employerTel;


    /**
     * 住宅电话
     */
    @Column(table = "yls_customer_person")
    private String homePhone;

    @Column(table = "yls_customer_person")
    private String pkCustomerPerson;

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public String getPkCustomerPerson() {
        return pkCustomerPerson;
    }

    public void setPkCustomerPerson(String pkCustomerPerson) {
        this.pkCustomerPerson = pkCustomerPerson;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public Short getIdentityType() {
        return identityType;
    }

    public void setIdentityType(Short identityType) {
        this.identityType = identityType;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployerTel() {
        return employerTel;
    }

    public void setEmployerTel(String employerTel) {
        this.employerTel = employerTel;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }
}