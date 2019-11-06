package com.leasing.common.entity.calculate.vo.cal;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/11/5
 * @author:Yjj@yonyou.com
 * @description: 计算IRR
 **/
public class CalIrrVO implements Serializable {
    /**
     * 计划合同IRR
     */
    public BigDecimal cont_plan_irr;

    /**
     * 会计去税irr
     */
    public BigDecimal finance_notax_irr;

    /**
     * 会计分配irr
     */
    public BigDecimal finance_allot_irr;
    /**
     * 手续费分配irr
     */
    public BigDecimal fee_distr_irr;
    /**
     * 合同irr
     */
    public BigDecimal project_irr;
    /**
     * 合同去税irr
     */
    public BigDecimal pro_notax_irr;
    /**
     * 剩余租金分配irr
     */
    public BigDecimal rent_balance_irr;
    /**
     * 租金irr
     */
    public BigDecimal rent_irr;
    /**
     * 租赁合同irr
     */
    public BigDecimal contract_irr;
    /**
     * 审计irr
     */
    public BigDecimal audit_irr;
    /**
     * 承租人irr
     */
    public BigDecimal lessee_irr;
    /**
     * 会计IRR
     */
    public BigDecimal finance_irr;


    /**
     * 计划合同去税IRR
     */
    public BigDecimal plan_con_notax_irr;

    /**
     * @return the cont_plan_irr
     */
    public BigDecimal getCont_plan_irr() {
        return cont_plan_irr;
    }
    /**
     * @param cont_plan_irr the cont_plan_irr to set
     */
    public void setCont_plan_irr(BigDecimal cont_plan_irr) {
        this.cont_plan_irr = cont_plan_irr;
    }
    /**
     * @return the finance_notax_irr
     */
    public BigDecimal getFinance_notax_irr() {
        return finance_notax_irr;
    }
    /**
     * @param finance_notax_irr the finance_notax_irr to set
     */
    public void setFinance_notax_irr(BigDecimal finance_notax_irr) {
        this.finance_notax_irr = finance_notax_irr;
    }
    /**
     * @return the finance_allot_irr
     */
    public BigDecimal getFinance_allot_irr() {
        return finance_allot_irr;
    }
    /**
     * @param finance_allot_irr the finance_allot_irr to set
     */
    public void setFinance_allot_irr(BigDecimal finance_allot_irr) {
        this.finance_allot_irr = finance_allot_irr;
    }
    /**
     * @return the fee_distr_irr
     */
    public BigDecimal getFee_distr_irr() {
        return fee_distr_irr;
    }
    /**
     * @param fee_distr_irr the fee_distr_irr to set
     */
    public void setFee_distr_irr(BigDecimal fee_distr_irr) {
        this.fee_distr_irr = fee_distr_irr;
    }
    /**
     * @return the project_irr
     */
    public BigDecimal getProject_irr() {
        return project_irr;
    }
    /**
     * @param project_irr the project_irr to set
     */
    public void setProject_irr(BigDecimal project_irr) {
        this.project_irr = project_irr;
    }
    /**
     * @return the pro_notax_irr
     */
    public BigDecimal getPro_notax_irr() {
        return pro_notax_irr;
    }
    /**
     * @param pro_notax_irr the pro_notax_irr to set
     */
    public void setPro_notax_irr(BigDecimal pro_notax_irr) {
        this.pro_notax_irr = pro_notax_irr;
    }
    /**
     * @return the rent_balance_irr
     */
    public BigDecimal getRent_balance_irr() {
        return rent_balance_irr;
    }
    /**
     * @param rent_balance_irr the rent_balance_irr to set
     */
    public void setRent_balance_irr(BigDecimal rent_balance_irr) {
        this.rent_balance_irr = rent_balance_irr;
    }
    /**
     * @return the rent_irr
     */
    public BigDecimal getRent_irr() {
        return rent_irr;
    }
    /**
     * @param rent_irr the rent_irr to set
     */
    public void setRent_irr(BigDecimal rent_irr) {
        this.rent_irr = rent_irr;
    }
    /**
     * @return the contract_irr
     */
    public BigDecimal getContract_irr() {
        return contract_irr;
    }
    /**
     * @param contract_irr the contract_irr to set
     */
    public void setContract_irr(BigDecimal contract_irr) {
        this.contract_irr = contract_irr;
    }
    /**
     * @return the audit_irr
     */
    public BigDecimal getAudit_irr() {
        return audit_irr;
    }
    /**
     * @param audit_irr the audit_irr to set
     */
    public void setAudit_irr(BigDecimal audit_irr) {
        this.audit_irr = audit_irr;
    }
    /**
     * @return the lessee_irr
     */
    public BigDecimal getLessee_irr() {
        return lessee_irr;
    }
    /**
     * @param lessee_irr the lessee_irr to set
     */
    public void setLessee_irr(BigDecimal lessee_irr) {
        this.lessee_irr = lessee_irr;
    }
    /**
     * @return the finance_irr
     */
    public BigDecimal getFinance_irr() {
        return finance_irr;
    }
    /**
     * @param finance_irr the finance_irr to set
     */
    public void setFinance_irr(BigDecimal finance_irr) {
        this.finance_irr = finance_irr;
    }
    /**
     * @return the plan_con_notax_irr
     */
    public BigDecimal getPlan_con_notax_irr() {
        return plan_con_notax_irr;
    }
    /**
     * @param plan_con_notax_irr the plan_con_notax_irr to set
     */
    public void setPlan_con_notax_irr(BigDecimal plan_con_notax_irr) {
        this.plan_con_notax_irr = plan_con_notax_irr;
    }
}