package com.leasing.common.entity.calculate.vo.cal;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/11/5
 * @author:Yjj@yonyou.com
 * @description: 在建期参数封装
 **/
public class ParamRentRuleC implements Serializable {
    /**
     * 预计转经营期日期
     */
    public String plan2operating_date;
    /**
     * 租息年利率
     */
    public BigDecimal final_rate;

    /**
     * 利率差
     */
    public BigDecimal rate_multiple;

    /**
     * 在建期利息处理方式 - 利息是否作为本金
     */
    public Short inter_method;
    /**
     * 在建期还本频率
     */
    public Short payment_frequency_corpus;
    /**
     * 在建期还本金额
     */
    public BigDecimal payment_corpus;

    /**
     * 在建期付息频率
     */
    public Short payment_frequency_interrate;

    /**
     * 总投放金额的计息方式
     */
    public Short interest_beginning;

    /**
     * 在建期利率按照期利率计算还是日利率
     */
    public Short interest_term;
    /**
     * interest_term为日时，使用360还是365
     */
    public Short interest_days;

    /**
     * 预计转经营期日期的getter方法
     *
     * @return String
     */
    public String getPlan2operating_date() {
        return plan2operating_date;
    }

    /**
     * 预计转经营期日期的setter方法
     *
     * @param plan2operating_date 预计转经营期日期
     */
    public void setPlan2operating_date(String plan2operating_date) {
        this.plan2operating_date = plan2operating_date;
    }

    /**
     * 租息年利率的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getFinal_rate() {
        return final_rate;
    }

    /**
     * 租息年利率的setter方法
     *
     * @param final_rate_c 租息年利率_C
     */
    public void setFinal_rate(BigDecimal final_rate) {
        this.final_rate = final_rate;
    }


    /**
     * 在建期利息处理方式的getter方法
     *
     * @return Short
     */
    public Short getInter_method() {
        return inter_method;
    }

    /**
     * 在建期利息处理方式的setter方法
     *
     * @param inter_method 在建期利息处理方式
     */
    public void setInter_method(Short inter_method) {
        this.inter_method = inter_method;
    }
    /**
     * 在建期还本频率
     * @return
     */
    public Short getPayment_frequency_corpus() {
        return payment_frequency_corpus;
    }
    /**
     * 在建期还本频率
     * @param payment_frequency_corpus
     */
    public void setPayment_frequency_corpus(Short payment_frequency_corpus) {
        this.payment_frequency_corpus = payment_frequency_corpus;
    }
    /**
     * 在建期还本金额
     * @return
     */
    public BigDecimal getPayment_corpus() {
        return payment_corpus;
    }
    /**
     * 在建期还本金额
     * @param payment_corpus
     */
    public void setPayment_corpus(BigDecimal payment_corpus) {
        this.payment_corpus = payment_corpus;
    }
    /**
     * 在建期付息频率
     * @return
     */
    public Short getPayment_frequency_interrate() {
        return payment_frequency_interrate;
    }
    /**
     * 在建期付息频率
     * @param payment_frequency_interrate
     */
    public void setPayment_frequency_interrate(Short payment_frequency_interrate) {
        this.payment_frequency_interrate = payment_frequency_interrate;
    }

    /**
     * 总投放金额的计息方式
     * @return
     */
    public Short getInterest_beginning() {
        return interest_beginning;
    }

    /**
     * 总投放金额的计息方式
     * @param interest_beginning
     */
    public void setInterest_beginning(Short interest_beginning) {
        this.interest_beginning = interest_beginning;
    }

    /**
     * 在建期利率按照期利率计算还是日利率
     * @return
     */
    public Short getInterest_term() {
        return interest_term;
    }

    /**
     * 在建期利率按照期利率计算还是日利率
     * @param interest_term
     */
    public void setInterest_term(Short interest_term) {
        this.interest_term = interest_term;
    }

    /**
     * interest_term为日时，使用360还是365
     * @return
     */
    public Short getInterest_days() {
        return interest_days;
    }

    /**
     * interest_term为日时，使用360还是365
     * @param interest_days
     */
    public void setInterest_days(Short interest_days) {
        this.interest_days = interest_days;
    }
    /**
     * 利率差
     */
    public BigDecimal getRate_multiple() {
        return rate_multiple;
    }
    /**
     * 利率差
     */
    public void setRate_multiple(BigDecimal rate_multiple) {
        this.rate_multiple = rate_multiple;
    }

}