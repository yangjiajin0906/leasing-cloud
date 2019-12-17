package com.leasing.communication.entity.dos;

import com.leasing.communication.entity.base.FileBaseBusinessDO;
import com.leasing.common.base.annotation.Excel;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
public class CbInoutPlanDO extends FileBaseBusinessDO {
    /**
     * 租金计划主键
     */
    @Id
    @GeneratedValue(generator = "yl_oid")
    @GenericGenerator(name = "yl_oid", strategy = "com.leasing.common.utils.frame.OIDGenerator")
    private String pkInoutPlan;

    /**
     * 合同编号
     */
    private String contCode;

    /**
     * 租赁方式
     */
    private BigDecimal leaseType;

    /**
     * 事件类别
     */
    private String pkEventType;

    /**
     * 计划期次
     */
    private String planLeaseTime;

    /**
     * 计划日期
     */
    private String planDate;

    /**
     * 计划金额
     */
    private BigDecimal planAmount;

    /**
     * 计划本金
     */
    private BigDecimal planLeaseCorpus;

    /**
     * 计划利息
     */
    private BigDecimal planInterest;

    /**
     * 实收日期
     */
    private String datePaidin;

    /**
     * 实收金额
     */
    private BigDecimal amountPaidin;

    /**
     * 实收本金
     */
    private BigDecimal corpusPaidin;

    /**
     * 实收利息
     */
    private BigDecimal interestPaidin;

    /**
     * 剩余金额
     */
    private BigDecimal amountBalance;

    /**
     * 剩余本金
     */
    private BigDecimal corpusBalance;

    /**
     * 币种
     */
    private String pkCurrency;

    /**
     * 预留字段1
     */
    private String def1;

    /**
     * 预留字段2
     */
    private String def2;

    /**
     * 预留字段3
     */
    private String def3;

    /**
     * 预留字段4
     */
    private String def4;

    /**
     * 预留字段5
     */
    private String def5;

    /**
     * 分拆租金（中投）
     */
    public BigDecimal divideCash;
    /**
     * 分拆本金（中投）
     */
    public BigDecimal divideCorpus;
    /**
     * 分拆利息（中投）
     */
    public BigDecimal divideInterest;

    /**
     * 租赁收入
     */
    private BigDecimal leaseCashIn;

    /**
     * 去税租息
     */
    private BigDecimal noTaxInterest;

    /**
     * 去税其它收入
     */
    private BigDecimal noTaxOtherin;

    /**
     * 去税其它支出
     */
    private BigDecimal noTaxOtherout;

    /**
     * 去税手续费收入
     */
    private BigDecimal noTaxSrvfee;

    /**
     * 进项税差额
     */
    private BigDecimal inputTaxDiff;

    /**
     * 进项税
     */
    private BigDecimal inputTax;

    /**
     * 税金
     */
    private BigDecimal sumTax;

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
    public BigDecimal getLeaseType() {
        return leaseType;
    }

    /**
     * 租赁方式
     * @param leaseType 租赁方式
     */
    public void setLeaseType(BigDecimal leaseType) {
        this.leaseType = leaseType;
    }

    /**
     * 事件类别
     * @return PK_EVENT_TYPE 事件类别
     */
    public String getPkEventType() {
        return pkEventType;
    }

    /**
     * 事件类别
     * @param pkEventType 事件类别
     */
    public void setPkEventType(String pkEventType) {
        this.pkEventType = pkEventType == null ? null : pkEventType.trim();
    }

    /**
     * 计划期次
     * @return PLAN_LEASE_TIME 计划期次
     */
    public String getPlanLeaseTime() {
        return planLeaseTime;
    }

    /**
     * 计划期次
     * @param planLeaseTime 计划期次
     */
    public void setPlanLeaseTime(String planLeaseTime) {
        this.planLeaseTime = planLeaseTime == null ? null : planLeaseTime.trim();
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
        this.pkCurrency = pkCurrency == null ? null : pkCurrency.trim();
    }

    /**
     * 来源系统
     * @return PK_SYS 来源系统
     */
    public String getPkSys() {
        return pkSys;
    }

    /**
     * 来源系统
     * @param pkSys 来源系统
     */
    public void setPkSys(String pkSys) {
        this.pkSys = pkSys == null ? null : pkSys.trim();
    }

    /**
     * 操作人
     * @return PK_OPERATOR 操作人
     */
    public String getPkOperator() {
        return pkOperator;
    }

    /**
     * 操作人
     * @param pkOperator 操作人
     */
    public void setPkOperator(String pkOperator) {
        this.pkOperator = pkOperator == null ? null : pkOperator.trim();
    }

    /**
     * 操作日期
     * @return OPERATE_DATE 操作日期
     */
    public String getOperateDate() {
        return operateDate;
    }

    /**
     * 操作日期
     * @param operateDate 操作日期
     */
    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate == null ? null : operateDate.trim();
    }

    /**
     * 操作时间
     * @return OPERATE_TIME 操作时间
     */
    public String getOperateTime() {
        return operateTime;
    }

    /**
     * 操作时间
     * @param operateTime 操作时间
     */
    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime == null ? null : operateTime.trim();
    }

    /**
     * 部门
     * @return PK_DEPT 部门
     */
    public String getPkDept() {
        return pkDept;
    }

    /**
     * 部门
     * @param pkDept 部门
     */
    public void setPkDept(String pkDept) {
        this.pkDept = pkDept == null ? null : pkDept.trim();
    }

    /**
     * 机构
     * @return PK_ORG 机构
     */
    public String getPkOrg() {
        return pkOrg;
    }

    /**
     * 机构
     * @param pkOrg 机构
     */
    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg == null ? null : pkOrg.trim();
    }

    /**
     * 预留字段1
     * @return DEF1 预留字段1
     */
    public String getDef1() {
        return def1;
    }

    /**
     * 预留字段1
     * @param def1 预留字段1
     */
    public void setDef1(String def1) {
        this.def1 = def1 == null ? null : def1.trim();
    }

    /**
     * 预留字段2
     * @return DEF2 预留字段2
     */
    public String getDef2() {
        return def2;
    }

    /**
     * 预留字段2
     * @param def2 预留字段2
     */
    public void setDef2(String def2) {
        this.def2 = def2 == null ? null : def2.trim();
    }

    /**
     * 预留字段3
     * @return DEF3 预留字段3
     */
    public String getDef3() {
        return def3;
    }

    /**
     * 预留字段3
     * @param def3 预留字段3
     */
    public void setDef3(String def3) {
        this.def3 = def3 == null ? null : def3.trim();
    }

    /**
     * 预留字段4
     * @return DEF4 预留字段4
     */
    public String getDef4() {
        return def4;
    }

    /**
     * 预留字段4
     * @param def4 预留字段4
     */
    public void setDef4(String def4) {
        this.def4 = def4 == null ? null : def4.trim();
    }

    /**
     * 预留字段5
     * @return DEF5 预留字段5
     */
    public String getDef5() {
        return def5;
    }

    /**
     * 预留字段5
     * @param def5 预留字段5
     */
    public void setDef5(String def5) {
        this.def5 = def5 == null ? null : def5.trim();
    }

    public BigDecimal getDivideCash() {
        return divideCash;
    }

    public void setDivideCash(BigDecimal divideCash) {
        this.divideCash = divideCash;
    }

    public BigDecimal getDivideCorpus() {
        return divideCorpus;
    }

    public void setDivideCorpus(BigDecimal divideCorpus) {
        this.divideCorpus = divideCorpus;
    }

    public BigDecimal getDivideInterest() {
        return divideInterest;
    }

    public void setDivideInterest(BigDecimal divideInterest) {
        this.divideInterest = divideInterest;
    }

    /**
     * 租赁收入
     * @return LEASE_CASH_IN 租赁收入
     */
    public BigDecimal getLeaseCashIn() {
        return leaseCashIn;
    }

    /**
     * 租赁收入
     * @param leaseCashIn 租赁收入
     */
    public void setLeaseCashIn(BigDecimal leaseCashIn) {
        this.leaseCashIn = leaseCashIn;
    }

    /**
     * 去税租息
     * @return NO_TAX_INTEREST 去税租息
     */
    public BigDecimal getNoTaxInterest() {
        return noTaxInterest;
    }

    /**
     * 去税租息
     * @param noTaxInterest 去税租息
     */
    public void setNoTaxInterest(BigDecimal noTaxInterest) {
        this.noTaxInterest = noTaxInterest;
    }

    /**
     * 去税其它收入
     * @return NO_TAX_OTHERIN 去税其它收入
     */
    public BigDecimal getNoTaxOtherin() {
        return noTaxOtherin;
    }

    /**
     * 去税其它收入
     * @param noTaxOtherin 去税其它收入
     */
    public void setNoTaxOtherin(BigDecimal noTaxOtherin) {
        this.noTaxOtherin = noTaxOtherin;
    }

    /**
     * 去税其它支出
     * @return NO_TAX_OTHEROUT 去税其它支出
     */
    public BigDecimal getNoTaxOtherout() {
        return noTaxOtherout;
    }

    /**
     * 去税其它支出
     * @param noTaxOtherout 去税其它支出
     */
    public void setNoTaxOtherout(BigDecimal noTaxOtherout) {
        this.noTaxOtherout = noTaxOtherout;
    }

    /**
     * 去税手续费收入
     * @return NO_TAX_SRVFEE 去税手续费收入
     */
    public BigDecimal getNoTaxSrvfee() {
        return noTaxSrvfee;
    }

    /**
     * 去税手续费收入
     * @param noTaxSrvfee 去税手续费收入
     */
    public void setNoTaxSrvfee(BigDecimal noTaxSrvfee) {
        this.noTaxSrvfee = noTaxSrvfee;
    }

    /**
     * 进项税差额
     * @return INPUT_TAX_DIFF 进项税差额
     */
    public BigDecimal getInputTaxDiff() {
        return inputTaxDiff;
    }

    /**
     * 进项税差额
     * @param inputTaxDiff 进项税差额
     */
    public void setInputTaxDiff(BigDecimal inputTaxDiff) {
        this.inputTaxDiff = inputTaxDiff;
    }

    /**
     * 进项税
     * @return INPUT_TAX 进项税
     */
    public BigDecimal getInputTax() {
        return inputTax;
    }

    /**
     * 进项税
     * @param inputTax 进项税
     */
    public void setInputTax(BigDecimal inputTax) {
        this.inputTax = inputTax;
    }

    /**
     * 税金
     * @return SUM_TAX 税金
     */
    public BigDecimal getSumTax() {
        return sumTax;
    }

    /**
     * 税金
     * @param sumTax 税金
     */
    public void setSumTax(BigDecimal sumTax) {
        this.sumTax = sumTax;
    }

    @Override
    public String getPk() {
        return pkInoutPlan;
    }

    @Override
    public void setPk(String pk) {
        this.pkInoutPlan = pk;
    }
}