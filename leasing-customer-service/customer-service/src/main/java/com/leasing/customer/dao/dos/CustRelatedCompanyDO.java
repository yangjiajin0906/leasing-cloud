package com.leasing.customer.dao.dos;

import com.leasing.common.base.entity.BaseDO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019-10-25
 * @author:zhangzhhn@yonyou.com
 * @description: 客户来源
 **/
@Entity
@Table(name = "yls_cust_related_company")
public class CustRelatedCompanyDO extends BaseDO {
    /**
     * 主键
     */
    @Id
    private String pkCustRelatedCompany;

    /**
     * 客户主键
     */
    private String pkCustomer;

    /**
     * 关联客户编号
     */
    private String pkCustomerRef;

    /**
     * 关系分类
     */
    private Short relationClass;


    /**
     * 客户关系
     */
    private String relationRole;

    /**
     * 备注
     */
    private String memo;

    /**
     * 复核人
     */
    private String pkChecker;


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
    private String pkGrantor;

    /**
     * 授权日期
     */
    private String grantDate;

    /**
     * 授权时间
     */
    private String grantTime;

    /**
     * 其他关系类型
     */
    private Short billtype;

    /**
     * 来源方式
     */
    private Short sourceMethod;

    /**
     * 合同主键
     */
    private String pkContract;


    private String executiveType;


    public String getPkCustRelatedCompany() {
        return pkCustRelatedCompany;
    }

    public void setPkCustRelatedCompany(String pkCustRelatedCompany) {
        this.pkCustRelatedCompany = pkCustRelatedCompany;
    }

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public String getPkCustomerRef() {
        return pkCustomerRef;
    }

    public void setPkCustomerRef(String pkCustomerRef) {
        this.pkCustomerRef = pkCustomerRef;
    }

    public Short getRelationClass() {
        return relationClass;
    }

    public void setRelationClass(Short relationClass) {
        this.relationClass = relationClass;
    }

    public String getRelationRole() {
        return relationRole;
    }

    public void setRelationRole(String relationRole) {
        this.relationRole = relationRole;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getPkChecker() {
        return pkChecker;
    }

    public void setPkChecker(String pkChecker) {
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

    public String getPkGrantor() {
        return pkGrantor;
    }

    public void setPkGrantor(String pkGrantor) {
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

    public Short getBilltype() {
        return billtype;
    }

    public void setBilltype(Short billtype) {
        this.billtype = billtype;
    }

    public Short getSourceMethod() {
        return sourceMethod;
    }

    public void setSourceMethod(Short sourceMethod) {
        this.sourceMethod = sourceMethod;
    }

    public String getPkContract() {
        return pkContract;
    }

    public void setPkContract(String pkContract) {
        this.pkContract = pkContract;
    }

    public String getExecutiveType() {
        return executiveType;
    }

    public void setExecutiveType(String executiveType) {
        this.executiveType = executiveType;
    }

    @Override
    public String getPk() {
        return this.pkCustRelatedCompany;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustRelatedCompany = pk;
    }
}