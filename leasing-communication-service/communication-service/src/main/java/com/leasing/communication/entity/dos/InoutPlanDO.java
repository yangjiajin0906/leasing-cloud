package com.leasing.communication.entity.dos;

import com.leasing.communication.entity.base.FileBaseBusinessDO;
import com.leasing.common.base.annotation.Excel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @description 2c租金计划DO
 * @author Yangjiajin
 * @date 2019/11/12 10:56
 */
@Entity
@Table(name="yc_inout_plan")
public class InoutPlanDO extends FileBaseBusinessDO {
    /**
     * 租金计划主键
     */
    @Id
    @Excel(titleName = "主键", orderNum = 10)
    private String pkInoutPlan;

    /**
     * 合同编号
     */
    @Excel(titleName = "合同编号", orderNum = 11)
    private String contCode;

    /**
     * 租赁方式
     */
    @Excel(titleName = "租赁方式",orderNum = 12)
    private Integer leaseType;

    /**
     * 事件类别
     */
    @Excel(titleName = "事件类别",orderNum = 13)
    private Integer rentEventType;

    /**
     * 计划期次
     */
    @Excel(titleName = "计划期次", orderNum = 14)
    private Integer planLeaseTime;

    /**
     * 计划日期
     */
    @Excel(titleName = "计划日期", orderNum = 15)
    private String planDate;

    /**
     * 计划金额
     */
    @Excel(titleName = "计划金额", orderNum = 16)
    private BigDecimal planAmount;

    /**
     * 计划本金
     */
    @Excel(titleName = "计划本金", orderNum = 17)
    private BigDecimal planLeaseCorpus;

    /**
     * 计划利息
     */
    @Excel(titleName = "计划利息", orderNum = 18)
    private BigDecimal planInterest;

    /**
     * 实收日期
     */
    @Excel(titleName = "实收日期", orderNum = 19)
    private String datePaidin;

    /**
     * 实收金额
     */
    @Excel(titleName = "实收金额", orderNum = 20)
    private BigDecimal amountPaidin;

    /**
     * 实收本金
     */
    @Excel(titleName = "实收本金", orderNum = 21)
    private BigDecimal corpusPaidin;

    /**
     * 实收利息
     */
    @Excel(titleName = "实收利息", orderNum = 22)
    private BigDecimal interestPaidin;

    /**
     * 剩余金额
     */
    @Excel(titleName = "剩余金额", orderNum = 23)
    private BigDecimal amountBalance;

    /**
     * 剩余本金
     */
    @Excel(titleName = "剩余本金", orderNum = 24)
    private BigDecimal corpusBalance;

    /**
     * 币种(参照)
     */
    @Excel(titleName = "币种",orderNum = 25)
    private String pkCurrency;

    @Override
    public String getPk() {
        return pkInoutPlan;
    }

    @Override
    public void setPk(String pk) {
        this.pkInoutPlan = pk;
    }

    /**
     * 租金计划主键
     * @return PK_INOUT_PLAN 租金计划主键
     */
    public String getPkInoutPlan() {
        return pkInoutPlan;
    }

    /**
     * 租金计划主键
     * @param pkInoutPlan 租金计划主键
     */
    public void setPkInoutPlan(String pkInoutPlan) {
        this.pkInoutPlan = pkInoutPlan == null ? null : pkInoutPlan.trim();
    }

    /**
     * 合同编号
     * @return CONT_CODE 合同编号
     */
    public String getContCode() {
        return contCode;
    }

    /**
     * 合同编号
     * @param contCode 合同编号
     */
    public void setContCode(String contCode) {
        this.contCode = contCode == null ? null : contCode.trim();
    }

    /**
     * 租赁方式
     * @return LEASE_TYPE 租赁方式
     */
    public Integer getLeaseType() {
        return leaseType;
    }

    /**
     * 租赁方式
     * @param leaseType 租赁方式
     */
    public void setLeaseType(Integer leaseType) {
        this.leaseType = leaseType;
    }

    /**
     * 事件类别
     * @return RENT_EVENT_TYPE 事件类别
     */
    public Integer getRentEventType() {
        return rentEventType;
    }

    /**
     * 事件类别
     * @param rentEventType 事件类别
     */
    public void setRentEventType(Integer rentEventType) {
        this.rentEventType = rentEventType;
    }

    /**
     * 计划期次
     * @return PLAN_LEASE_TIME 计划期次
     */
    public Integer getPlanLeaseTime() {
        return planLeaseTime;
    }

    /**
     * 计划期次
     * @param planLeaseTime 计划期次
     */
    public void setPlanLeaseTime(Integer planLeaseTime) {
        this.planLeaseTime = planLeaseTime;
    }

    /**
     * 计划日期
     * @return PLAN_DATE 计划日期
     */
    public String getPlanDate() {
        return planDate;
    }

    /**
     * 计划日期
     * @param planDate 计划日期
     */
    public void setPlanDate(String planDate) {
        this.planDate = planDate == null ? null : planDate.trim();
    }

    /**
     * 计划金额
     * @return PLAN_AMOUNT 计划金额
     */
    public BigDecimal getPlanAmount() {
        return planAmount;
    }

    /**
     * 计划金额
     * @param planAmount 计划金额
     */
    public void setPlanAmount(BigDecimal planAmount) {
        this.planAmount = planAmount;
    }

    /**
     * 计划本金
     * @return PLAN_LEASE_CORPUS 计划本金
     */
    public BigDecimal getPlanLeaseCorpus() {
        return planLeaseCorpus;
    }

    /**
     * 计划本金
     * @param planLeaseCorpus 计划本金
     */
    public void setPlanLeaseCorpus(BigDecimal planLeaseCorpus) {
        this.planLeaseCorpus = planLeaseCorpus;
    }

    /**
     * 计划利息
     * @return PLAN_INTEREST 计划利息
     */
    public BigDecimal getPlanInterest() {
        return planInterest;
    }

    /**
     * 计划利息
     * @param planInterest 计划利息
     */
    public void setPlanInterest(BigDecimal planInterest) {
        this.planInterest = planInterest;
    }

    /**
     * 实收日期
     * @return DATE_PAIDIN 实收日期
     */
    public String getDatePaidin() {
        return datePaidin;
    }

    /**
     * 实收日期
     * @param datePaidin 实收日期
     */
    public void setDatePaidin(String datePaidin) {
        this.datePaidin = datePaidin == null ? null : datePaidin.trim();
    }

    /**
     * 实收金额
     * @return AMOUNT_PAIDIN 实收金额
     */
    public BigDecimal getAmountPaidin() {
        return amountPaidin;
    }

    /**
     * 实收金额
     * @param amountPaidin 实收金额
     */
    public void setAmountPaidin(BigDecimal amountPaidin) {
        this.amountPaidin = amountPaidin;
    }

    /**
     * 实收本金
     * @return CORPUS_PAIDIN 实收本金
     */
    public BigDecimal getCorpusPaidin() {
        return corpusPaidin;
    }

    /**
     * 实收本金
     * @param corpusPaidin 实收本金
     */
    public void setCorpusPaidin(BigDecimal corpusPaidin) {
        this.corpusPaidin = corpusPaidin;
    }

    /**
     * 实收利息
     * @return INTEREST_PAIDIN 实收利息
     */
    public BigDecimal getInterestPaidin() {
        return interestPaidin;
    }

    /**
     * 实收利息
     * @param interestPaidin 实收利息
     */
    public void setInterestPaidin(BigDecimal interestPaidin) {
        this.interestPaidin = interestPaidin;
    }

    /**
     * 剩余金额
     * @return AMOUNT_BALANCE 剩余金额
     */
    public BigDecimal getAmountBalance() {
        return amountBalance;
    }

    /**
     * 剩余金额
     * @param amountBalance 剩余金额
     */
    public void setAmountBalance(BigDecimal amountBalance) {
        this.amountBalance = amountBalance;
    }

    /**
     * 剩余本金
     * @return CORPUS_BALANCE 剩余本金
     */
    public BigDecimal getCorpusBalance() {
        return corpusBalance;
    }

    /**
     * 剩余本金
     * @param corpusBalance 剩余本金
     */
    public void setCorpusBalance(BigDecimal corpusBalance) {
        this.corpusBalance = corpusBalance;
    }

    /**
     * 币种
     * @return PK_CURRENCY 币种
     */
    public String getPkCurrency() {
        return pkCurrency;
    }

    /**
     * 币种
     * @param pkCurrency 币种
     */
    public void setPkCurrency(String pkCurrency) {
        this.pkCurrency = pkCurrency;
    }

    public InoutPlanDO() {
    }

    public InoutPlanDO(String pkInoutPlan, String contCode, Integer leaseType, Integer rentEventType, Integer planLeaseTime, String planDate, BigDecimal planAmount, BigDecimal planLeaseCorpus, BigDecimal planInterest, String datePaidin, BigDecimal amountPaidin, BigDecimal corpusPaidin, BigDecimal interestPaidin, BigDecimal amountBalance, BigDecimal corpusBalance, String pkCurrency) {
        this.pkInoutPlan = pkInoutPlan;
        this.contCode = contCode;
        this.leaseType = leaseType;
        this.rentEventType = rentEventType;
        this.planLeaseTime = planLeaseTime;
        this.planDate = planDate;
        this.planAmount = planAmount;
        this.planLeaseCorpus = planLeaseCorpus;
        this.planInterest = planInterest;
        this.datePaidin = datePaidin;
        this.amountPaidin = amountPaidin;
        this.corpusPaidin = corpusPaidin;
        this.interestPaidin = interestPaidin;
        this.amountBalance = amountBalance;
        this.corpusBalance = corpusBalance;
        this.pkCurrency = pkCurrency;
    }
}