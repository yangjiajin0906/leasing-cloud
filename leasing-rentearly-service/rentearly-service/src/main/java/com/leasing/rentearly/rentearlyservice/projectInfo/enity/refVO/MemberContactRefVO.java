package com.leasing.rentearly.rentearlyservice.projectInfo.enity.refVO;

import com.leasing.common.base.entity.BaseRefVO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "v_member_contact")
public class MemberContactRefVO extends BaseRefVO {

    /**
     * 客户
     */
    @Id
    private String pkCustomer;

    public String customerName;
    /**
     * 是否开票的人
     */
    public Short ifInvoiceMan;
    /**
     * 部门
     */
    private String department;
    /**
     * 职务
     */
    private String duty;
    /**
     * 手机
     */
    private String mobile;
    /**
     * email
     */
    private String email;
    /**
     * 电话
     */
    private String officePhone;
    /**
     * 传真
     */
    private String fax;

    /**
     * 客户类型.
     */
    private Integer custType;

    /**
     * 初始主键
     */
    public String initialPk;


//    public MemberContactRefVO(String pkCustomer, String customerName, Short ifInvoiceMan, String department, String duty, String mobile, String email, String officePhone, String fax, Integer custType, String initialPk) {
//        this.pkCustomer = pkCustomer;
//        this.customerName = customerName;
//        this.ifInvoiceMan = ifInvoiceMan;
//        this.department = department;
//        this.duty = duty;
//        this.mobile = mobile;
//        this.email = email;
//        this.officePhone = officePhone;
//        this.fax = fax;
//        this.custType = custType;
//        this.initialPk = initialPk;
//        this.setName(customerName);
//        this.setPk(pkCustomer);
//    }

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

    public Short getIfInvoiceMan() {
        return ifInvoiceMan;
    }

    public void setIfInvoiceMan(Short ifInvoiceMan) {
        this.ifInvoiceMan = ifInvoiceMan;
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

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Integer getCustType() {
        return custType;
    }

    public void setCustType(Integer custType) {
        this.custType = custType;
    }

    public String getInitialPk() {
        return initialPk;
    }

    public void setInitialPk(String initialPk) {
        this.initialPk = initialPk;
    }
}
