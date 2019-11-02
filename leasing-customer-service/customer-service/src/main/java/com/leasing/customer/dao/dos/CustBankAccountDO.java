package com.leasing.customer.dao.dos;

import com.leasing.common.base.entity.BaseDO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019-10-31
 * @author:zhangzhhn@yonyou.com
 * @description: 银行账户
 **/
@Entity
@Table(name = "yls_cust_bank_account")
public class CustBankAccountDO extends BaseDO {

    @Id
    private String pkCustBankAccount;

    private String grantTime;

    private String accountName;

    private Short accountUse;

    private String operateTime;

    private String mdbCode;

    private String memo;

    private String pkCustomer;

    private Short accountStatus;

    private String accountBank;

    private String accountNo;

    private String bankNo;

    private String bankProvince;

    private String agreeEndDate;

    private Short billstatus;

    private Short accountType;

    private String grantDate;

    private String checkDate;

    private String bankAddress;

    private String bankCity;

    private String checkTime;

    private String pkOrg;

    private Short ifAgreementAccount;

    private String initialPk;

    private String operateDate;

    private String pkOperator;

    private String pkChecker;

    private String pkGrantor;

    @Override
    public String getPk() {
        return pkCustBankAccount;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustBankAccount = pk;
    }

    public String getPkCustBankAccount() {
        return pkCustBankAccount;
    }

    public void setPkCustBankAccount(String pkCustBankAccount) {
        this.pkCustBankAccount = pkCustBankAccount;
    }

    public String getGrantTime() {
        return grantTime;
    }

    public void setGrantTime(String grantTime) {
        this.grantTime = grantTime;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Short getAccountUse() {
        return accountUse;
    }

    public void setAccountUse(Short accountUse) {
        this.accountUse = accountUse;
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

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public Short getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Short accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getAccountBank() {
        return accountBank;
    }

    public void setAccountBank(String accountBank) {
        this.accountBank = accountBank;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getBankProvince() {
        return bankProvince;
    }

    public void setBankProvince(String bankProvince) {
        this.bankProvince = bankProvince;
    }

    public String getAgreeEndDate() {
        return agreeEndDate;
    }

    public void setAgreeEndDate(String agreeEndDate) {
        this.agreeEndDate = agreeEndDate;
    }

    public Short getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
    }

    public Short getAccountType() {
        return accountType;
    }

    public void setAccountType(Short accountType) {
        this.accountType = accountType;
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

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public String getBankCity() {
        return bankCity;
    }

    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
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

    public Short getIfAgreementAccount() {
        return ifAgreementAccount;
    }

    public void setIfAgreementAccount(Short ifAgreementAccount) {
        this.ifAgreementAccount = ifAgreementAccount;
    }

    public String getInitialPk() {
        return initialPk;
    }

    public void setInitialPk(String initialPk) {
        this.initialPk = initialPk;
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