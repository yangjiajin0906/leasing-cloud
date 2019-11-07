package com.leasing.customer.dao.dos;

import com.leasing.common.base.entity.BaseDO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019-10-30
 * @author:zhangzhhn@yonyou.com
 * @description: 股权投资
 **/
@Entity
@Table(name = "yls_cust_equity_investment")
public class CustEquityInvestmentDO extends BaseDO {


    private Short contributeMethod;

    private String grantTime;

    private Short billstatus;

    private String pkCustomerRef;

    private String relationRole;

    private String operateTime;

    private String memo;

    private String grantDate;

    private String checkDate;

    private String pkCustomer;

    private String pkCurrtype;

    @Id
    private String pkCustEquityInvestment;

    private String checkTime;

    private String pkOrg;

    private BigDecimal factCash;

    private Short relationClass;

    private BigDecimal sharesRatio;

    private String factDate;

    private String operateDate;

    private String pkOperator;

    private String pkChecker;

    private String pkGrantor;

    @Override
    public String getPk() {
        return this.pkCustEquityInvestment;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustEquityInvestment = pk;
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

    public Short getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
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

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
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

    public String getPkCustEquityInvestment() {
        return pkCustEquityInvestment;
    }

    public void setPkCustEquityInvestment(String pkCustEquityInvestment) {
        this.pkCustEquityInvestment = pkCustEquityInvestment;
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

    public BigDecimal getFactCash() {
        return factCash;
    }

    public void setFactCash(BigDecimal factCash) {
        this.factCash = factCash;
    }

    public Short getRelationClass() {
        return relationClass;
    }

    public void setRelationClass(Short relationClass) {
        this.relationClass = relationClass;
    }

    public BigDecimal getSharesRatio() {
        return sharesRatio;
    }

    public void setSharesRatio(BigDecimal sharesRatio) {
        this.sharesRatio = sharesRatio;
    }

    public String getFactDate() {
        return factDate;
    }

    public void setFactDate(String factDate) {
        this.factDate = factDate;
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