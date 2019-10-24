package com.leasing.calculate.dos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.leasing.calculate.vo.CalculatorVO;
import com.leasing.common.base.entity.BaseDO;
import com.leasing.common.base.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud 实际投放计划VO
 * @date:2019/9/26
 * @author:Yjj@yonyou.com
 * @description:
 **/
@Entity
@Table(name="yls_lease_loan_plan")
public class LeaseLoanPlanDO extends BaseDO {

    /**
     * 主键
     */
    @Id
    public String pkLeaseLoanPlan;

    /**
     * 报价主键
     */
    public String sourceBill;
    /**
     * 计划投放日期
     */
    @Column(name="plan_date_loan")
    public String planDate;
    /**
     * 投放金额
     */
    @Column(name="plan_cash_loan")
    public BigDecimal planCash;
    /**
     * 投放付款方式
     */
    @Column(name="pay_method_loan")
    public Short payMethod;
    /**
     * 银票开票日期
     */
    public String makeDateDraft;
    /**
     * 银票到期日期
     */
    public String endDateDraft;
    /**
     * 银票保证金比例
     */
    public BigDecimal depositRatio4draft;
    /**
     * 银票保证金利率
     */
    public BigDecimal interrateDepos4draft;

    /**
     * 银票金额
     */
    @Transient
    public BigDecimal bankAmount;
    /**
     * 索引编号
     */
    public Integer indexCode;

    /**
     * 商业折扣
     */
    public BigDecimal tradeDiscount;


    /**
     * 因为开发初期没有想到
     * 投放的计划是计算日期会不同
     * 所以 后台使用了planDate做算法的日期
     * 现在只好用rightDate 存放 planDate（计划日期）
     * 的过滤字段
     */
    @Transient
    public String rightDate;

    /**
     * 是否分配起始
     */
    public Short ifBeginPlan;

    /**
     * 客户主键
     */
    public String pkCustomer;

    /**
     * 税率
     */
    public Short taxRate;

    /**
     * 批次
     */
    public Integer loanBatch;

    /**
     * 计息金额计算方式
     */
    public Short calinterestAmountStyle;

    public LeaseLoanPlanDO() {
    }

    public String getPkLeaseLoanPlan() {
        return pkLeaseLoanPlan;
    }

    public void setPkLeaseLoanPlan(String pkLeaseLoanPlan) {
        this.pkLeaseLoanPlan = pkLeaseLoanPlan;
    }

    public String getSourceBill() {
        return sourceBill;
    }

    public void setSourceBill(String sourceBill) {
        this.sourceBill = sourceBill;
    }

    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }

    public BigDecimal getPlanCash() {
        return planCash;
    }

    public void setPlanCash(BigDecimal planCash) {
        this.planCash = planCash;
    }

    public Short getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Short payMethod) {
        this.payMethod = payMethod;
    }

    public String getMakeDateDraft() {
        return makeDateDraft;
    }

    public void setMakeDateDraft(String makeDateDraft) {
        this.makeDateDraft = makeDateDraft;
    }

    public String getEndDateDraft() {
        return endDateDraft;
    }

    public void setEndDateDraft(String endDateDraft) {
        this.endDateDraft = endDateDraft;
    }

    public BigDecimal getDepositRatio4draft() {
        return depositRatio4draft;
    }

    public void setDepositRatio4draft(BigDecimal depositRatio4draft) {
        this.depositRatio4draft = depositRatio4draft;
    }

    public BigDecimal getInterrateDepos4draft() {
        return interrateDepos4draft;
    }

    public void setInterrateDepos4draft(BigDecimal interrateDepos4draft) {
        this.interrateDepos4draft = interrateDepos4draft;
    }

    public BigDecimal getBankAmount() {
        return bankAmount;
    }

    public void setBankAmount(BigDecimal bankAmount) {
        this.bankAmount = bankAmount;
    }

    public Integer getIndexCode() {
        return indexCode;
    }

    public void setIndexCode(Integer indexCode) {
        this.indexCode = indexCode;
    }

    public BigDecimal getTradeDiscount() {
        return tradeDiscount;
    }

    public void setTradeDiscount(BigDecimal tradeDiscount) {
        this.tradeDiscount = tradeDiscount;
    }

    public String getRightDate() {
        return rightDate;
    }

    public void setRightDate(String rightDate) {
        this.rightDate = rightDate;
    }

    public Short getIfBeginPlan() {
        return ifBeginPlan;
    }

    public void setIfBeginPlan(Short ifBeginPlan) {
        this.ifBeginPlan = ifBeginPlan;
    }

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public Short getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Short taxRate) {
        this.taxRate = taxRate;
    }

    public Integer getLoanBatch() {
        return loanBatch;
    }

    public void setLoanBatch(Integer loanBatch) {
        this.loanBatch = loanBatch;
    }

    public Short getCalinterestAmountStyle() {
        return calinterestAmountStyle;
    }

    public void setCalinterestAmountStyle(Short calinterestAmountStyle) {
        this.calinterestAmountStyle = calinterestAmountStyle;
    }

    @Override
    public String getPk() {
        return null;
    }

    @Override
    public void setPk(String pk) {

    }
}