package com.leasing.common.entity.calculate.vo;

import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/10/11
 * @author:Yjj@yonyou.com
 * @description: 报价 计算租金计划表 中间VO
 **/
public class CalArithmeticVO {
    /**
     * 收取期次
     */
    public Integer lease_time;
    /**
     * 计算日期
     */
    public String cal_date;
    /**
     * 计划收取日期
     */
    public String plan_date;
    /**
     * 交易类别
     */
    public String trans_type;
    /**
     * 收支方向
     */
    public Short Direction;
    /**
     * 租金/发生额
     */
    public BigDecimal lease_cash;
    /**
     * 其中：本金
     */
    public BigDecimal lease_corpus;
    /**
     * 其中：利息
     */
    public BigDecimal lease_interest;
    /**
     * 租金/发生额(重算)
     */
    public BigDecimal lease_cash_fin;
    /**
     * 其中：本金(重算)
     */
    public BigDecimal lease_corpus_fin;
    /**
     * 其中：利息(重算)
     */
    public BigDecimal lease_interest_fin;
    /**
     * 剩余本金(重算)
     */
    public BigDecimal corpus_balance_fin;
    /**
     * 剩余本金
     */
    public BigDecimal corpus_balance;

    /**
     * 使用利率
     */
    public BigDecimal rateValue;

    /**
     * 客户信息 (yjj不知道干啥用 先注掉)
     */
//    public CustomerRefVO pk_customer;

    /**
     * 税率
     */
    public Short tax_rate;

    /**
     * 备注
     */
    public String memo;

    /**
     * 收取期次的getter方法
     *
     * @return Integer
     */
    public Integer getLease_time() {
        return lease_time;
    }

    /**
     * 收取期次的setter方法
     *
     * @param lease_time 收取期次
     */
    public void setLease_time(Integer lease_time) {
        this.lease_time = lease_time;
    }

    /**
     * 计算日期的getter方法
     *
     * @return String
     */
    public String getCal_date() {
        return cal_date;
    }

    /**
     * 计算日期的setter方法
     *
     * @param cal_date 计算日期
     */
    public void setCal_date(String cal_date) {
        this.cal_date = cal_date;
    }

    /**
     * 计划收取日期的getter方法
     *
     * @return String
     */
    public String getPlan_date() {
        return plan_date;
    }

    /**
     * 计划收取日期的setter方法
     *
     * @param plan_date 计划收取日期
     */
    public void setPlan_date(String plan_date) {
        this.plan_date = plan_date;
    }

    /**
     * 租金/发生额的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getLease_cash() {
        return lease_cash;
    }

    /**
     * 租金/发生额的setter方法
     *
     * @param lease_cash 租金/发生额
     */
    public void setLease_cash(BigDecimal lease_cash) {
        this.lease_cash = lease_cash;
    }

    /**
     * 其中：本金的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getLease_corpus() {
        return lease_corpus;
    }

    /**
     * 其中：本金的setter方法
     *
     * @param lease_corpus 其中：本金
     */
    public void setLease_corpus(BigDecimal lease_corpus) {
        this.lease_corpus = lease_corpus;
    }

    /**
     * 其中：利息的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getLease_interest() {
        return lease_interest;
    }

    /**
     * 其中：利息的setter方法
     *
     * @param lease_interest 其中：利息
     */
    public void setLease_interest(BigDecimal lease_interest) {
        this.lease_interest = lease_interest;
    }

    /**
     * 剩余本金的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getCorpus_balance() {
        return corpus_balance;
    }

    /**
     * 剩余本金的setter方法
     *
     * @param corpus_balance 剩余本金
     */
    public void setCorpus_balance(BigDecimal corpus_balance) {
        this.corpus_balance = corpus_balance;
    }
    /**
     * 交易类别
     * @return
     */
    public String getTrans_type() {
        return trans_type;
    }
    /**
     * 交易类别
     * @return
     */
    public void setTrans_type(String trans_type) {
        this.trans_type = trans_type;
    }
    /**
     * 收支方向
     * @return
     */
    public Short getDirection() {
        return Direction;
    }
    /**
     * 收支方向
     * @return
     */
    public void setDirection(Short direction) {
        Direction = direction;
    }

    /**
     * 使用利率
     * @return
     */
    public BigDecimal getRateValue() {
        return rateValue;
    }

    /**
     * 使用利率
     * @param rateValue
     */
    public void setRateValue(BigDecimal rateValue) {
        this.rateValue = rateValue;
    }

//    /**
//     * @return the pk_customer
//     */
//    public CustomerRefVO getPk_customer() {
//        return pk_customer;
//    }
//
//    /**
//     * @param pk_customer the pk_customer to set
//     */
//    public void setPk_customer(CustomerRefVO pk_customer) {
//        this.pk_customer = pk_customer;
//    }

    /**
     * @return the memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * @param memo the memo to set
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * @return the lease_cash_fin
     */
    public BigDecimal getLease_cash_fin() {
        return lease_cash_fin;
    }

    /**
     * @param lease_cash_fin the lease_cash_fin to set
     */
    public void setLease_cash_fin(BigDecimal lease_cash_fin) {
        this.lease_cash_fin = lease_cash_fin;
    }

    /**
     * @return the lease_corpus_fin
     */
    public BigDecimal getLease_corpus_fin() {
        return lease_corpus_fin;
    }

    /**
     * @param lease_corpus_fin the lease_corpus_fin to set
     */
    public void setLease_corpus_fin(BigDecimal lease_corpus_fin) {
        this.lease_corpus_fin = lease_corpus_fin;
    }

    /**
     * @return the lease_interest_fin
     */
    public BigDecimal getLease_interest_fin() {
        return lease_interest_fin;
    }

    /**
     * @param lease_interest_fin the lease_interest_fin to set
     */
    public void setLease_interest_fin(BigDecimal lease_interest_fin) {
        this.lease_interest_fin = lease_interest_fin;
    }

    /**
     * @return the corpus_balance_fin
     */
    public BigDecimal getCorpus_balance_fin() {
        return corpus_balance_fin;
    }

    /**
     * @param corpus_balance_fin the corpus_balance_fin to set
     */
    public void setCorpus_balance_fin(BigDecimal corpus_balance_fin) {
        this.corpus_balance_fin = corpus_balance_fin;
    }

    /**
     * @return the tax_rate
     */
    public Short getTax_rate() {
        return tax_rate;
    }

    /**
     * @param tax_rate the tax_rate to set
     */
    public void setTax_rate(Short tax_rate) {
        this.tax_rate = tax_rate;
    }
    //租金税额
    public BigDecimal lease_cash_tax;
    //租金税额(会计)
    public BigDecimal lease_cash_tax_fin;
    //本金税额
    public BigDecimal lease_corpus_tax;
    //本金税额(会计)
    public BigDecimal lease_corpus_tax_fin;
    //利息税额
    public BigDecimal lease_interest_tax;
    //利息税额(会计)
    public BigDecimal lease_interest_tax_fin;

    public BigDecimal getLease_cash_tax() {
        return lease_cash_tax;
    }

    public void setLease_cash_tax(BigDecimal lease_cash_tax) {
        this.lease_cash_tax = lease_cash_tax;
    }

    public BigDecimal getLease_cash_tax_fin() {
        return lease_cash_tax_fin;
    }

    public void setLease_cash_tax_fin(BigDecimal lease_cash_tax_fin) {
        this.lease_cash_tax_fin = lease_cash_tax_fin;
    }

    public BigDecimal getLease_corpus_tax() {
        return lease_corpus_tax;
    }

    public void setLease_corpus_tax(BigDecimal lease_corpus_tax) {
        this.lease_corpus_tax = lease_corpus_tax;
    }

    public BigDecimal getLease_corpus_tax_fin() {
        return lease_corpus_tax_fin;
    }

    public void setLease_corpus_tax_fin(BigDecimal lease_corpus_tax_fin) {
        this.lease_corpus_tax_fin = lease_corpus_tax_fin;
    }

    public BigDecimal getLease_interest_tax() {
        return lease_interest_tax;
    }

    public void setLease_interest_tax(BigDecimal lease_interest_tax) {
        this.lease_interest_tax = lease_interest_tax;
    }

    public BigDecimal getLease_interest_tax_fin() {
        return lease_interest_tax_fin;
    }

    public void setLease_interest_tax_fin(BigDecimal lease_interest_tax_fin) {
        this.lease_interest_tax_fin = lease_interest_tax_fin;
    }

    //by lihongjian @2016/05/05 ADD START
    /**
     * 税种
     */
    public Short tax_mode;

    public Short getTax_mode() {
        return tax_mode;
    }

    public void setTax_mode(Short tax_mode) {
        this.tax_mode = tax_mode;
    }

}