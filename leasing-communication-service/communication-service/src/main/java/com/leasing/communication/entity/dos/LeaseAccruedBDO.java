package com.leasing.communication.entity.dos;


import com.leasing.common.base.entity.BaseDO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Title: 租赁账户管理系统<br>
 * Description: 计提主表(中投)VO类<br>
 * Copyright: Copyright (c) 2010<br>
 * Company: UFIDA<br>
 *
 * @author
 * @version 1.0
 */
@Entity
@Table(name="yls_lease_accrued_b")
public class LeaseAccruedBDO extends BaseDO {

    /**
     * 主键
     */
    @Id
    @Column(name = "PK_LEASE_ACCRUED_B")
    public String pkLeaseAccruedB;
    /**
     * 计提表主键
     */
    @Column(name = "PK_ACCRUAL_C")
    public String pkAccrualC;
    /**
     * 主表主键
     */
    public String pkLeaseAccrued; //主表主键
    /**
     * 客户
     */
    public String pkCustomer;
    /**
     * 合同
     */
    @Column(name = "PK_CONTRACT_C")
    public String pkContractC;
    /**
     * 资产状态
     */
    public String assetStatus;
    /**
     * 资产五级分类
     */
    public Short assetsClassify;
    /**
     * 计提月份
     */
    public String accruedMonth;
    /**
     * 租赁利息计提金额
     */
    public BigDecimal interestAmount;
    /**
     * 手续费收入计提金额
     */
    public BigDecimal feeAmount;
    /**
     * 其他收入计提金额
     */
    public BigDecimal otherIncomeAmount;
    /**
     * 其他支出计提金额
     */
    public BigDecimal otherExpensesAmount;
    /**
     * 币种
     */
    public String pkCurrtype;
    /**
     * 汇率
     */
    public BigDecimal exchgRate;
    /**
     * 核算主体
     */
    public String pkGlorgbook;

    /**
     * 类LeaseAccruedBVO的构造方法
     */
    public LeaseAccruedBDO() {
    }

    public String getPkLeaseAccruedB() {
        return pkLeaseAccruedB;
    }

    public void setPkLeaseAccruedB(String pkLeaseAccruedB) {
        this.pkLeaseAccruedB = pkLeaseAccruedB;
    }

    public String getPkAccrualC() {
        return pkAccrualC;
    }

    public void setPkAccrualC(String pkAccrualC) {
        this.pkAccrualC = pkAccrualC;
    }

    public String getPkLeaseAccrued() {
        return pkLeaseAccrued;
    }

    public void setPkLeaseAccrued(String pkLeaseAccrued) {
        this.pkLeaseAccrued = pkLeaseAccrued;
    }

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public String getPkContractC() {
        return pkContractC;
    }

    public void setPkContractC(String pkContractC) {
        this.pkContractC = pkContractC;
    }

    public String getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(String assetStatus) {
        this.assetStatus = assetStatus;
    }

    public Short getAssetsClassify() {
        return assetsClassify;
    }

    public void setAssetsClassify(Short assetsClassify) {
        this.assetsClassify = assetsClassify;
    }

    public String getAccruedMonth() {
        return accruedMonth;
    }

    public void setAccruedMonth(String accruedMonth) {
        this.accruedMonth = accruedMonth;
    }

    public BigDecimal getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(BigDecimal interestAmount) {
        this.interestAmount = interestAmount;
    }

    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }

    public BigDecimal getOtherIncomeAmount() {
        return otherIncomeAmount;
    }

    public void setOtherIncomeAmount(BigDecimal otherIncomeAmount) {
        this.otherIncomeAmount = otherIncomeAmount;
    }

    public BigDecimal getOtherExpensesAmount() {
        return otherExpensesAmount;
    }

    public void setOtherExpensesAmount(BigDecimal otherExpensesAmount) {
        this.otherExpensesAmount = otherExpensesAmount;
    }

    public String getPkCurrtype() {
        return pkCurrtype;
    }

    public void setPkCurrtype(String pkCurrtype) {
        this.pkCurrtype = pkCurrtype;
    }

    public BigDecimal getExchgRate() {
        return exchgRate;
    }

    public void setExchgRate(BigDecimal exchgRate) {
        this.exchgRate = exchgRate;
    }

    public String getPkGlorgbook() {
        return pkGlorgbook;
    }

    public void setPkGlorgbook(String pkGlorgbook) {
        this.pkGlorgbook = pkGlorgbook;
    }

    @Override
    public String getPk() {
        return pkLeaseAccruedB;
    }

    @Override
    public void setPk(String pk) {
        this.pkLeaseAccruedB = pk;
    }
}

