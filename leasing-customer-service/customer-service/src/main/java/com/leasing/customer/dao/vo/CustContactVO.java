package com.leasing.customer.dao.vo;

import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.dto.customer.CustomerDTO;
import com.leasing.common.vo.foundation.OrgVO;
import com.leasing.common.vo.foundation.UserVO;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019-10-31
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "YLS_CUST_CONTACT")
public class CustContactVO extends BaseVO {
    /**
     * 主键
     */
    @Id
    private String pkCustContact;


    /**
     * 客户主键
     */
    @ManyToOne
    @JoinColumn(name = "pkCustomer")
    private CustomerDTO pkCustomer;

    /**
     * 是否主要联系人
     */
    private Short ifMajorContact;
    /**
     * 是否开票的人
     */
    private Short ifInvoiceMan;

    /**
     * 联系人类型
     */
    private Short contactType;


    /**
     * 姓名
     */
    private String customerName;


    /**
     * 证件号码
     */
    private String identityCardNumb;

    /**
     * 证件类型
     */
    private Short identityType;

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
     * 邮箱
     */
    private String email;


    /**
     * 办公电话
     */
    private String officePhone;


    /**
     * 传真
     */
    private String fax;


    /**
     * 家庭电话
     */
    private String homePhone;


    /**
     * 备注
     */
    private String memo;


    /**
     * 初始主键
     */
    private String initialPk;


    /**
     * 单据状态
     */
    private Short billstatus;


    /**
     * 记账人
     */
    @ManyToOne
    @JoinColumn(name = "pkOperator")
    private UserVO pkOperator;

    /**
     * 记账日期
     */
    private String operateDate;


    /**
     * 记账时间
     */
    private String operateTime;


    /**
     * 复核人
     */
    @ManyToOne
    @JoinColumn(name = "pkChecker")
    private UserVO pkChecker;

    /**
     * 复核日期
     */
    private String checkDate;


    /**
     * 复核时间
     */
    private String checkTime;


    /**
     * 授权人
     */
    @ManyToOne
    @JoinColumn(name = "pkGrantor")
    private UserVO pkGrantor;

    /**
     * 授权日期
     */
    private String grantDate;


    /**
     * 授权时间
     */
    private String grantTime;


    /**
     * 机构
     */
    @ManyToOne
    @JoinColumn(name = "pkOrg")
    private OrgVO pkOrg;


    /**
     * @usage 201403聚信增加
     * @description 主数据编码
     */
    private String mdbCode;

    public String getPkCustContact() {
        return pkCustContact;
    }

    public void setPkCustContact(String pkCustContact) {
        this.pkCustContact = pkCustContact;
    }

    public CustomerDTO getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(CustomerDTO pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public Short getIfMajorContact() {
        return ifMajorContact;
    }

    public void setIfMajorContact(Short ifMajorContact) {
        this.ifMajorContact = ifMajorContact;
    }

    public Short getIfInvoiceMan() {
        return ifInvoiceMan;
    }

    public void setIfInvoiceMan(Short ifInvoiceMan) {
        this.ifInvoiceMan = ifInvoiceMan;
    }

    public Short getContactType() {
        return contactType;
    }

    public void setContactType(Short contactType) {
        this.contactType = contactType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIdentityCardNumb() {
        return identityCardNumb;
    }

    public void setIdentityCardNumb(String identityCardNumb) {
        this.identityCardNumb = identityCardNumb;
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

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getInitialPk() {
        return initialPk;
    }

    public void setInitialPk(String initialPk) {
        this.initialPk = initialPk;
    }

    public Short getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
    }

    public UserVO getPkOperator() {
        return pkOperator;
    }

    public void setPkOperator(UserVO pkOperator) {
        this.pkOperator = pkOperator;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public UserVO getPkChecker() {
        return pkChecker;
    }

    public void setPkChecker(UserVO pkChecker) {
        this.pkChecker = pkChecker;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public UserVO getPkGrantor() {
        return pkGrantor;
    }

    public void setPkGrantor(UserVO pkGrantor) {
        this.pkGrantor = pkGrantor;
    }

    public String getGrantDate() {
        return grantDate;
    }

    public void setGrantDate(String grantDate) {
        this.grantDate = grantDate;
    }

    public String getGrantTime() {
        return grantTime;
    }

    public void setGrantTime(String grantTime) {
        this.grantTime = grantTime;
    }

    public OrgVO getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(OrgVO pkOrg) {
        this.pkOrg = pkOrg;
    }

    public String getMdbCode() {
        return mdbCode;
    }

    public void setMdbCode(String mdbCode) {
        this.mdbCode = mdbCode;
    }

    @Override
    public String getPk() {
        return pkCustContact;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustContact = pk;
    }
}