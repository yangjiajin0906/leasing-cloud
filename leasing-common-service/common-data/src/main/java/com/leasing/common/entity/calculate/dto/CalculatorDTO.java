package com.leasing.common.entity.calculate.dto;

import com.leasing.common.base.entity.BaseDTO;
import com.leasing.common.entity.calculate.dos.InoutPlanPDO;
import com.leasing.common.entity.calculate.dos.LeaseLoanPlanDO;
import com.leasing.common.entity.calculate.dos.LeaseRulePDO;

import javax.persistence.*;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/10/18
 * @author:Yjj@yonyou.com
 * @description: 报价查询字表DTO
 **/
@Entity
@Table(name="yls_lease_calculator")
public class CalculatorDTO extends BaseDTO{

    @Id
    public String pkLeaseCalculator;

    /**
     * 投放计划（子表）
     */
    @OneToMany(orphanRemoval=true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="sourceBill")
    public List<LeaseLoanPlanDO> leaseLoanPlan;

    /**
     * 收支计划（子表）市场  --存储
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, fetch = FetchType.LAZY)
    @JoinColumn(name="sourceBill")
    public List<InoutPlanPDO> inoutPlanMarket;

    /**
     * 规则设置（子表）
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, fetch = FetchType.LAZY)
    @JoinColumn(name="sourceBill")
    public List<LeaseRulePDO> leaseRule;

    /**
     * 风险金计划（子表）
     */
    @Transient
    public List<InoutPlanPDO> inoutPlanDeposit;

    /**
     * 服务费收入（子表） --展现
     */
    @Transient
    public List<InoutPlanPDO> inoutPlanSrvin;

    /**
     * 服务费支出（子表） --展现
     */
    @Transient
    public List<InoutPlanPDO>  inoutPlanSrvot;
    /**
     * 其他收支计划（子表） --展现
     */

    @Transient
    public List<InoutPlanPDO>  inoutPlanOther;

    /**
     * 租金计划表（子表） --展现
     */
    @Transient
    public List<InoutPlanPDO>  inoutPlan;

    /**
     * 本次投放之前的租金计划表
     */
    @Transient
    public List<InoutPlanPDO>  inoutPlanBeforeLoan;


    public String getPkLeaseCalculator() {
        return pkLeaseCalculator;
    }

    public void setPkLeaseCalculator(String pkLeaseCalculator) {
        this.pkLeaseCalculator = pkLeaseCalculator;
    }

    public List<LeaseLoanPlanDO> getLeaseLoanPlan() {
        return leaseLoanPlan;
    }

    public void setLeaseLoanPlan(List<LeaseLoanPlanDO> leaseLoanPlan) {
        this.leaseLoanPlan = leaseLoanPlan;
    }

    public List<InoutPlanPDO> getInoutPlanMarket() {
        return inoutPlanMarket;
    }

    public void setInoutPlanMarket(List<InoutPlanPDO> inoutPlanMarket) {
        this.inoutPlanMarket = inoutPlanMarket;
    }

    public List<LeaseRulePDO> getLeaseRule() {
        return leaseRule;
    }

    public void setLeaseRule(List<LeaseRulePDO> leaseRule) {
        this.leaseRule = leaseRule;
    }

    public List<InoutPlanPDO> getInoutPlanDeposit() {
        return inoutPlanDeposit;
    }

    public void setInoutPlanDeposit(List<InoutPlanPDO> inoutPlanDeposit) {
        this.inoutPlanDeposit = inoutPlanDeposit;
    }

    public List<InoutPlanPDO> getInoutPlanSrvin() {
        return inoutPlanSrvin;
    }

    public void setInoutPlanSrvin(List<InoutPlanPDO> inoutPlanSrvin) {
        this.inoutPlanSrvin = inoutPlanSrvin;
    }

    public List<InoutPlanPDO> getInoutPlanSrvot() {
        return inoutPlanSrvot;
    }

    public void setInoutPlanSrvot(List<InoutPlanPDO> inoutPlanSrvot) {
        this.inoutPlanSrvot = inoutPlanSrvot;
    }

    public List<InoutPlanPDO> getInoutPlanOther() {
        return inoutPlanOther;
    }

    public void setInoutPlanOther(List<InoutPlanPDO> inoutPlanOther) {
        this.inoutPlanOther = inoutPlanOther;
    }

    public List<InoutPlanPDO> getInoutPlan() {
        return inoutPlan;
    }

    public void setInoutPlan(List<InoutPlanPDO> inoutPlan) {
        this.inoutPlan = inoutPlan;
    }

    public List<InoutPlanPDO> getInoutPlanBeforeLoan() {
        return inoutPlanBeforeLoan;
    }

    public void setInoutPlanBeforeLoan(List<InoutPlanPDO> inoutPlanBeforeLoan) {
        this.inoutPlanBeforeLoan = inoutPlanBeforeLoan;
    }
}