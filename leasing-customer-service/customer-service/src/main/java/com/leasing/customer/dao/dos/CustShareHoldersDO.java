package com.leasing.customer.dao.dos;

import com.leasing.common.base.entity.BaseDO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019-10-29
 * @author:zhangzhhn@yonyou.com
 * @description: 股东情况
 **/
@Entity
@Table(name = "yls_cust_shareholders")
public class CustShareHoldersDO extends BaseDO {


    @Id
    private String pkCustShareholders;

    private Short contributeMethod;

    private String grantTime;

    private String planCash;

    private String pkCustomerRef;

    private String relationRole;

    private String memo;

    private String grantDate;

    private String checkDate;

    private String pkCustomer;

    private String pkCurrtype;

    private String checkTime;

    private Short relationClass;

    private Short shareholderRole;

    private String sharesRatio;

    private String factDate;

    private String pkChecker;

    private String pkGrantor;

    /**
     * 单据状态
     */
    private Short billstatus;
    /**
     * 操作人
     */
    private String pkOperator;
    /**
     * 操作日期
     */
    private String operateDate;
    /**
     * 操作时间
     */
    private String operateTime;
    /**
     * 机构
     */
    private String pkOrg;

    @Override
    public String getPk() {
        return this.pkCustShareholders;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustShareholders = pk;
    }

    public Short getContributeMethod() {
        return contributeMethod;
    }

    public void setContributeMethod(Short contributeMethod) {
        this.contributeMethod = contributeMethod;
    }

    public String getGrantTime() {
        return grantTime;
    }

    public void setGrantTime(String grantTime) {
        this.grantTime = grantTime;
    }

    public String getPlanCash() {
        return planCash;
    }

    public void setPlanCash(String planCash) {
        this.planCash = planCash;
    }

    public String getPkCustomerRef() {
        return pkCustomerRef;
    }

    public void setPkCustomerRef(String pkCustomerRef) {
        this.pkCustomerRef = pkCustomerRef;
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

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public String getPkCurrtype() {
        return pkCurrtype;
    }

    public void setPkCurrtype(String pkCurrtype) {
        this.pkCurrtype = pkCurrtype;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getPkCustShareholders() {
        return pkCustShareholders;
    }

    public void setPkCustShareholders(String pkCustShareholders) {
        this.pkCustShareholders = pkCustShareholders;
    }

    public Short getRelationClass() {
        return relationClass;
    }

    public void setRelationClass(Short relationClass) {
        this.relationClass = relationClass;
    }

    public Short getShareholderRole() {
        return shareholderRole;
    }

    public void setShareholderRole(Short shareholderRole) {
        this.shareholderRole = shareholderRole;
    }

    public String getSharesRatio() {
        return sharesRatio;
    }

    public void setSharesRatio(String sharesRatio) {
        this.sharesRatio = sharesRatio;
    }

    public String getFactDate() {
        return factDate;
    }

    public void setFactDate(String factDate) {
        this.factDate = factDate;
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

    public Short getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
    }

    public String getPkOperator() {
        return pkOperator;
    }

    public void setPkOperator(String pkOperator) {
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

    public String getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg;
    }
}