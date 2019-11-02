package com.leasing.customer.dao.dos;

import com.leasing.common.base.entity.BaseDO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019-10-31
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yls_cust_contact")
public class CustContactDO extends BaseDO {


    @Id
    private String pkCustContact;

    private String grantTime;

    private String operateTime;

    private String mdbCode;

    private String memo;

    private String customerCode;

    private Short contactType;

    private String pkCustomer;

    private String officePhone;

    private Short identityType;

    private String department;

    private String fax;

    private String email;

    private Short billstatus;

    private String homePhone;

    private String mobile;

    private Short ifInvoiceMan;

    private Short ifMajorContact;

    private String grantDate;

    private String checkDate;

    private String customerName;

    private String checkTime;

    private String pkOrg;

    private String identityCardNumb;

    private String initialPk;

    private String duty;

    private String operateDate;

    private String pkOperator;

    private String pkChecker;

    private String pkGrantor;

    @Override
    public String getPk() {
        return pkCustContact;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustContact = pk;
    }

    public String getPkCustContact() {
        return pkCustContact;
    }

    public void setPkCustContact(String pkCustContact) {
        this.pkCustContact = pkCustContact;
    }

    public String getGrantTime() {
        return grantTime;
    }

    public void setGrantTime(String grantTime) {
        this.grantTime = grantTime;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public String getMdbCode() {
        return mdbCode;
    }

    public void setMdbCode(String mdbCode) {
        this.mdbCode = mdbCode;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Short getContactType() {
        return contactType;
    }

    public void setContactType(Short contactType) {
        this.contactType = contactType;
    }

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public Short getIdentityType() {
        return identityType;
    }

    public void setIdentityType(Short identityType) {
        this.identityType = identityType;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Short getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Short getIfInvoiceMan() {
        return ifInvoiceMan;
    }

    public void setIfInvoiceMan(Short ifInvoiceMan) {
        this.ifInvoiceMan = ifInvoiceMan;
    }

    public Short getIfMajorContact() {
        return ifMajorContact;
    }

    public void setIfMajorContact(Short ifMajorContact) {
        this.ifMajorContact = ifMajorContact;
    }

    public String getGrantDate() {
        return grantDate;
    }

    public void setGrantDate(String grantDate) {
        this.grantDate = grantDate;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg;
    }

    public String getIdentityCardNumb() {
        return identityCardNumb;
    }

    public void setIdentityCardNumb(String identityCardNumb) {
        this.identityCardNumb = identityCardNumb;
    }

    public String getInitialPk() {
        return initialPk;
    }

    public void setInitialPk(String initialPk) {
        this.initialPk = initialPk;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public String getPkOperator() {
        return pkOperator;
    }

    public void setPkOperator(String pkOperator) {
        this.pkOperator = pkOperator;
    }

    public String getPkChecker() {
        return pkChecker;
    }

    public void setPkChecker(String pkChecker) {
        this.pkChecker = pkChecker;
    }

    public String getPkGrantor() {
        return pkGrantor;
    }

    public void setPkGrantor(String pkGrantor) {
        this.pkGrantor = pkGrantor;
    }
}