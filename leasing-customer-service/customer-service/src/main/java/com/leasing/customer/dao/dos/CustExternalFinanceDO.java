package com.leasing.customer.dao.dos;

import com.leasing.common.base.entity.BaseDO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019-11-12
 * @author:zhangzhhn@yonyou.com
 * @description: 其他融资
 **/
@Entity
@Table(name = "yls_cust_external_finance")
public class CustExternalFinanceDO extends BaseDO {
    /**
     * 主键
     */
    @Id
    private String pkCustExternalFinance;

    private String grantTime;

    private String endDate;

    private String pkCustomerRef;

    private Short repaymentPeriod;

    private String relationRole;

    private String operateTime;

    private String memo;

    private String pkCustomer;

    private Short creditType;

    private BigDecimal balance;

    private Short relationClass;

    private BigDecimal interestRate;

    private BigDecimal planCash;

    private Short billstatus;

    private String grantDate;

    private String checkDate;

    private String pkCurrtype;

    private String balanceDate;

    private String checkTime;

    private String pkOrg;

    private Short financeType;

    private BigDecimal deposit;

    private Short guaranteeMethod;

    private String operateDate;

    private String startDate;

    private String pkOperator;

    private String pkChecker;

    private String pkGrantor;

    public String getPkCustExternalFinance() {
        return pkCustExternalFinance;
    }

    public void setPkCustExternalFinance(String pkCustExternalFinance) {
        this.pkCustExternalFinance = pkCustExternalFinance;
    }

    public String getGrantTime() {
        return grantTime;
    }

    public void setGrantTime(String grantTime) {
        this.grantTime = grantTime;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getPkCustomerRef() {
        return pkCustomerRef;
    }

    public void setPkCustomerRef(String pkCustomerRef) {
        this.pkCustomerRef = pkCustomerRef;
    }

    public Short getRepaymentPeriod() {
        return repaymentPeriod;
    }

    public void setRepaymentPeriod(Short repaymentPeriod) {
        this.repaymentPeriod = repaymentPeriod;
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

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public Short getCreditType() {
        return creditType;
    }

    public void setCreditType(Short creditType) {
        this.creditType = creditType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Short getRelationClass() {
        return relationClass;
    }

    public void setRelationClass(Short relationClass) {
        this.relationClass = relationClass;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getPlanCash() {
        return planCash;
    }

    public void setPlanCash(BigDecimal planCash) {
        this.planCash = planCash;
    }

    public Short getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
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

    public String getPkCurrtype() {
        return pkCurrtype;
    }

    public void setPkCurrtype(String pkCurrtype) {
        this.pkCurrtype = pkCurrtype;
    }

    public String getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(String balanceDate) {
        this.balanceDate = balanceDate;
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

    public Short getFinanceType() {
        return financeType;
    }

    public void setFinanceType(Short financeType) {
        this.financeType = financeType;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public Short getGuaranteeMethod() {
        return guaranteeMethod;
    }

    public void setGuaranteeMethod(Short guaranteeMethod) {
        this.guaranteeMethod = guaranteeMethod;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
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
        return pkCustExternalFinance;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustExternalFinance = pk;
    }
}