package com.leasing.communication.entity.dto;

import com.leasing.common.vo.foundation.DeptVO;
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
@Table(name = "yls_customer")
@SecondaryTable(name = "yls_customer_corp", pkJoinColumns =
        {@PrimaryKeyJoinColumn(name = "pkCustomer", referencedColumnName = "pkCustomer")})
public class CustomerDTO {

    @Id
    private String pkCustomer;

    private String customerName;

    private String customerCode;

    /**
     * 证件类型
     */
    private Short identityType;

    /**
     * 证件号码
     */
    private String identityNo;

    /**
     * 公司邮箱
     */
    @Column(table = "yls_customer_corp")
    private String companyMailbox;

    /**
     * 电话
     */
    @Column(table = "yls_customer_corp")
    private String phone;


    /**
     * 传真
     */
    @Column(table = "yls_customer_corp")
    private String fax;

    private String pkDept;

    public CustomerDTO(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }
    public CustomerDTO() {

    }

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
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

    public String getCompanyMailbox() {
        return companyMailbox;
    }

    public void setCompanyMailbox(String companyMailbox) {
        this.companyMailbox = companyMailbox;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPkDept() {
        return pkDept;
    }

    public void setPkDept(String pkDept) {
        this.pkDept = pkDept;
    }
}