package com.leasing.customer.dao.dos;

import com.leasing.common.base.entity.BaseDO;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
public class IndexAnalysisDO extends BaseDO {
    /**
     * 主键
     */
    private String pkIndexAnalysis;

    private String payableAccount;

    private String stockAnalysis;

    private String grantTime;

    private Short billstatus;

    private String operateTime;

    private String accountPayableOthers;

    private String memo;

    private String grantDate;

    private String checkDate;

    private String pkCustomer;

    private String pecuniaryResources;

    private String accountsReceivable;

    private String checkTime;

    private String pkOrg;

    private String pkCustReport;

    private String operateDate;

    private String otherReceivable;

    private String pkOperator;

    private String pkChecker;

    private String pkGrantor;

    public String getPkIndexAnalysis() {
        return pkIndexAnalysis;
    }

    public void setPkIndexAnalysis(String pkIndexAnalysis) {
        this.pkIndexAnalysis = pkIndexAnalysis;
    }

    public String getPayableAccount() {
        return payableAccount;
    }

    public void setPayableAccount(String payableAccount) {
        this.payableAccount = payableAccount;
    }

    public String getStockAnalysis() {
        return stockAnalysis;
    }

    public void setStockAnalysis(String stockAnalysis) {
        this.stockAnalysis = stockAnalysis;
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

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public String getAccountPayableOthers() {
        return accountPayableOthers;
    }

    public void setAccountPayableOthers(String accountPayableOthers) {
        this.accountPayableOthers = accountPayableOthers;
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

    public String getPecuniaryResources() {
        return pecuniaryResources;
    }

    public void setPecuniaryResources(String pecuniaryResources) {
        this.pecuniaryResources = pecuniaryResources;
    }

    public String getAccountsReceivable() {
        return accountsReceivable;
    }

    public void setAccountsReceivable(String accountsReceivable) {
        this.accountsReceivable = accountsReceivable;
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

    public String getPkCustReport() {
        return pkCustReport;
    }

    public void setPkCustReport(String pkCustReport) {
        this.pkCustReport = pkCustReport;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public String getOtherReceivable() {
        return otherReceivable;
    }

    public void setOtherReceivable(String otherReceivable) {
        this.otherReceivable = otherReceivable;
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

    @Override
    public String getPk() {
        return pkIndexAnalysis;
    }

    @Override
    public void setPk(String pk) {
        this.pkIndexAnalysis = pk;
    }
}