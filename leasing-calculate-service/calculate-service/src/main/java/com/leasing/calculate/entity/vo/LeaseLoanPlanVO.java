package com.leasing.calculate.entity.vo;

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
public class LeaseLoanPlanVO {

    /**
     * 主键
     */
    @Id
    public String pk_lease_loan_plan;

    /**
     * 报价主键
     */
    public CalculatorVO source_bill;
    /**
     * 计划投放日期
     */
    public String plan_date;
    /**
     * 投放金额
     */
    public BigDecimal plan_cash;
    /**
     * 投放付款方式
     */
    public Short pay_method;
    /**
     * 银票开票日期
     */
    public String make_date_draft;
    /**
     * 银票到期日期
     */
    public String end_date_draft;
    /**
     * 银票保证金比例
     */
    public BigDecimal deposit_ratio4draft;
    /**
     * 银票保证金利率
     */
    public BigDecimal interrate_depos4draft;

    /**
     * 银票金额
     */
    public BigDecimal bank_amount;
    /**
     * 索引编号
     */
    public Integer index_code;

    /**
     * 商业折扣
     */
    public BigDecimal trade_discount;

    public String getRight_date() {
        return right_date;
    }

    public void setRight_date(String right_date) {
        this.right_date = right_date;
    }

    /**
     * 因为开发初期没有想到
     * 投放的计划是计算日期会不同
     * 所以 后台使用了plan_date做算法的日期
     * 现在只好用right_date 存放 plan_date（计划日期）
     * 的过滤字段
     */
    public String right_date;

    /**
     * 是否分配起始
     */
    public Short if_begin_plan;

//    /**
//     * 客户主键
//     */
//    public CustomerRefVO pk_customer;

    /**
     * 税率
     */
    public Short tax_rate;

    /**
     * 批次
     */
    public Integer loan_batch;

    /**
     * 计息金额计算方式
     */
    public Short calinterest_amount_style;

    public LeaseLoanPlanVO() {
    }

    public String getPk_lease_loan_plan() {
        return pk_lease_loan_plan;
    }

    public void setPk_lease_loan_plan(String pk_lease_loan_plan) {
        this.pk_lease_loan_plan = pk_lease_loan_plan;
    }

    public CalculatorVO getSource_bill() {
        return source_bill;
    }

    public void setSource_bill(CalculatorVO source_bill) {
        this.source_bill = source_bill;
    }

    public String getPlan_date() {
        return plan_date;
    }

    public void setPlan_date(String plan_date) {
        this.plan_date = plan_date;
    }

    public BigDecimal getPlan_cash() {
        return plan_cash;
    }

    public void setPlan_cash(BigDecimal plan_cash) {
        this.plan_cash = plan_cash;
    }

    public Short getPay_method() {
        return pay_method;
    }

    public void setPay_method(Short pay_method) {
        this.pay_method = pay_method;
    }

    public String getMake_date_draft() {
        return make_date_draft;
    }

    public void setMake_date_draft(String make_date_draft) {
        this.make_date_draft = make_date_draft;
    }

    public String getEnd_date_draft() {
        return end_date_draft;
    }

    public void setEnd_date_draft(String end_date_draft) {
        this.end_date_draft = end_date_draft;
    }

    public BigDecimal getDeposit_ratio4draft() {
        return deposit_ratio4draft;
    }

    public void setDeposit_ratio4draft(BigDecimal deposit_ratio4draft) {
        this.deposit_ratio4draft = deposit_ratio4draft;
    }

    public BigDecimal getInterrate_depos4draft() {
        return interrate_depos4draft;
    }

    public void setInterrate_depos4draft(BigDecimal interrate_depos4draft) {
        this.interrate_depos4draft = interrate_depos4draft;
    }

    public BigDecimal getBank_amount() {
        return bank_amount;
    }

    public void setBank_amount(BigDecimal bank_amount) {
        this.bank_amount = bank_amount;
    }

    public Integer getIndex_code() {
        return index_code;
    }

    public void setIndex_code(Integer index_code) {
        this.index_code = index_code;
    }

    public BigDecimal getTrade_discount() {
        return trade_discount;
    }

    public void setTrade_discount(BigDecimal trade_discount) {
        this.trade_discount = trade_discount;
    }

    public Short getIf_begin_plan() {
        return if_begin_plan;
    }

    public void setIf_begin_plan(Short if_begin_plan) {
        this.if_begin_plan = if_begin_plan;
    }

    public Short getTax_rate() {
        return tax_rate;
    }

    public void setTax_rate(Short tax_rate) {
        this.tax_rate = tax_rate;
    }

    public Integer getLoan_batch() {
        return loan_batch;
    }

    public void setLoan_batch(Integer loan_batch) {
        this.loan_batch = loan_batch;
    }

    public Short getCalinterest_amount_style() {
        return calinterest_amount_style;
    }

    public void setCalinterest_amount_style(Short calinterest_amount_style) {
        this.calinterest_amount_style = calinterest_amount_style;
    }
}