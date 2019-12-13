package com.leasing.communication.entity.dos;


import com.leasing.common.base.entity.BaseDO;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Description: 计提子表
 */
@Entity
@Table(name="yc_accrued_detail")
public class AccruedDetailDO extends BaseDO {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "yl_oid")
    @GenericGenerator(name = "yl_oid", strategy = "com.leasing.common.utils.frame.OIDGenerator")
    public String pkAccruedDetail;
    /**
     * 计提表主键
     */
    public String pkAccrual;
    /**
     * 主表主键
     */
    public String pkAccrued; //主表主键
    /**
     * 客户
     */
    public String pkCustomer;
    /**
     * 客户code
     */
    @Transient
    public String customerCode;
    /**
     * 合同
     */
    public String pkContract;
    /**
     * 合同code
     */
    @Transient
    public String contractCode;
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
     * 币种code
     */
    @Transient
    public String currtypecode;
    /**
     * 汇率
     */
    public BigDecimal exchgRate;
    /**
     * 核算主体
     */
    public String pkGlorgbook;

    public AccruedDetailDO(String customerCode, String contractCode, String assetStatus, Short assetsClassify, String accruedMonth, BigDecimal interestAmount, BigDecimal feeAmount, BigDecimal otherIncomeAmount, BigDecimal otherExpensesAmount, String currtypecode, BigDecimal exchgRate, String pkGlorgbook) {
        this.customerCode = customerCode;
        this.contractCode = contractCode;
        this.assetStatus = assetStatus;
        this.assetsClassify = assetsClassify;
        this.accruedMonth = accruedMonth;
        this.interestAmount = interestAmount;
        this.feeAmount = feeAmount;
        this.otherIncomeAmount = otherIncomeAmount;
        this.otherExpensesAmount = otherExpensesAmount;
        this.currtypecode = currtypecode;
        this.exchgRate = exchgRate;
        this.pkGlorgbook = pkGlorgbook;
    }

    /**
     * 类LeaseAccruedBVO的构造方法
     */
    public AccruedDetailDO() {
    }

    public String getPkAccruedDetail() {
        return pkAccruedDetail;
    }

    public void setPkAccruedDetail(String pkAccruedDetail) {
        this.pkAccruedDetail = pkAccruedDetail;
    }

    public String getPkAccrual() {
        return pkAccrual;
    }

    public void setPkAccrual(String pkAccrual) {
        this.pkAccrual = pkAccrual;
    }

    public String getPkAccrued() {
        return pkAccrued;
    }

    public void setPkAccrued(String pkAccrued) {
        this.pkAccrued = pkAccrued;
    }

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public String getPkContract() {
        return pkContract;
    }

    public void setPkContract(String pkContract) {
        this.pkContract = pkContract;
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
        return pkAccruedDetail;
    }

    @Override
    public void setPk(String pk) {
        this.pkAccruedDetail = pk;
    }
}

