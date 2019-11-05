package com.leasing.common.entity.calculate.vo.cal;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/11/5
 * @author:Yjj@yonyou.com
 * @description: 正常收租参数封装
 **/
public class ParamRentRule implements Serializable {
    /**
     * 名义货价（留购价）
     */
    public BigDecimal nominal_price;

    /**
     * 资产余值
     */
    public BigDecimal assets_margin;

    /**
     * 租赁期限 -已月为单位
     */
    public Integer lease_times;

    /**
     * 先付后付标志
     */
    public Short prepay_or_not;


    /**
     * 首期收租时间
     */
    public String first_lease_date;

    /**
     * 租息年利率_O
     */
    public BigDecimal final_rate_o;


    /**
     * 提前间隔 -计划收取日期提前月
     */
    public Integer interval_month;

    /**
     * 支付频率
     */
    public Short payment_frequency;

    /**
     * 利息计算方式
     */
    public Short occur_interest_method;
    /**
     * 特殊算法设置（平息法，表面利率法等）,与计算方式配合使用
     */
    public Short special_arithmetic_settings;
    /**
     * 日复利每期所占比例,主要是支付频率为半年使用，值是上半年比例
     * 默认为1
     */
    public BigDecimal radio_hyear;

    /**
     * 最后一期计算规则
     * 默认租金重算
     */
    public Short last_term_rule;

    /**
     * 利息补差方式
     */
    public Short reset_interrest_method;

    /**
     * 日复息-最后一期提前天数
     */
    public Integer last_term_days;

    /**
     * 首付款是否参与期次排序
     */
    public Short first_sort;

    /**
     * 现金流年计算天数
     */
    public Short year_days_flow;
    /**
     * 名义货价的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getNominal_price() {
        return nominal_price;
    }

    /**
     * 名义货价的setter方法
     *
     * @param nominal_price 名义货价
     */
    public void setNominal_price(BigDecimal nominal_price) {
        this.nominal_price = nominal_price;
    }

    /**
     * 资产余值的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getAssets_margin() {
        return assets_margin;
    }

    /**
     * 资产余值的setter方法
     *
     * @param assets_margin 资产余值
     */
    public void setAssets_margin(BigDecimal assets_margin) {
        this.assets_margin = assets_margin;
    }

    /**
     * 先付后付标志的getter方法
     *
     * @return Short
     */
    public Short getPrepay_or_not() {
        return prepay_or_not;
    }

    /**
     * 先付后付标志的setter方法
     *
     * @param prepay_or_not 先付后付标志
     */
    public void setPrepay_or_not(Short prepay_or_not) {
        this.prepay_or_not = prepay_or_not;
    }


    /**
     * 首期收租时间的getter方法
     *
     * @return String
     */
    public String getFirst_lease_date() {
        return first_lease_date;
    }

    /**
     * 首期收租时间的setter方法
     *
     * @param first_lease_date 首期收租时间
     */
    public void setFirst_lease_date(String first_lease_date) {
        this.first_lease_date = first_lease_date;
    }

    /**
     * 租息年利率_O的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getFinal_rate_o() {
        return final_rate_o;
    }

    /**
     * 租息年利率_O的setter方法
     *
     * @param final_rate_o 租息年利率_O
     */
    public void setFinal_rate_o(BigDecimal final_rate_o) {
        this.final_rate_o = final_rate_o;
    }
    /**
     * 租赁期限
     * @return
     */
    public Integer getLease_times() {
        return lease_times;
    }
    /**
     * 租赁期限
     * @param lease_times
     */
    public void setLease_times(Integer lease_times) {
        this.lease_times = lease_times;
    }
    /**
     * 提前间隔
     * @return
     */
    public Integer getInterval_month() {
        return interval_month;
    }
    /**
     * 提前间隔
     * @param interval_month
     */
    public void setInterval_month(Integer interval_month) {
        this.interval_month = interval_month;
    }

    /**
     * 特殊算法设置（平息法，表面利率法等）,与计算方式配合使用
     * @return
     */
    public Short getSpecial_arithmetic_settings() {
        return special_arithmetic_settings;
    }
    /**
     * 特殊算法设置（平息法，表面利率法等）,与计算方式配合使用
     * @param special_arithmetic_settings
     */
    public void setSpecial_arithmetic_settings(Short special_arithmetic_settings) {
        this.special_arithmetic_settings = special_arithmetic_settings;
    }
    /**
     * 日复利每期所占比例,主要是支付频率为半年使用，值是上半年比例
     * @return
     */
    public BigDecimal getRadio_hyear() {
        return radio_hyear;
    }
    /**
     * 日复利每期所占比例,主要是支付频率为半年使用，值是上半年比例
     * @param radio_hyear
     */
    public void setRadio_hyear(BigDecimal radio_hyear) {
        this.radio_hyear = radio_hyear;
    }
    /**
     * 支付频率
     * @return
     */
    public Short getPayment_frequency() {
        return payment_frequency;
    }
    /**
     * 支付频率
     * @param payment_frequency
     */
    public void setPayment_frequency(Short payment_frequency) {
        this.payment_frequency = payment_frequency;
    }
    /**
     * 利息计算方式
     * @return
     */
    public Short getOccur_interest_method() {
        return occur_interest_method;
    }

    /**
     * 利息计算方式
     * @param occur_interest_method
     */
    public void setOccur_interest_method(Short occur_interest_method) {
        this.occur_interest_method = occur_interest_method;
    }

    /**
     * 最后一期计算规则
     * @return
     */
    public Short getLast_term_rule() {
        return last_term_rule;
    }

    /**
     * 最后一期计算规则
     * @param last_term_rule
     */
    public void setLast_term_rule(Short last_term_rule) {
        this.last_term_rule = last_term_rule;
    }

    /**
     * 利息补差方式
     * @return
     */
    public Short getReset_interrest_method() {
        return reset_interrest_method;
    }

    /**
     * 利息补差方式
     * @param reset_interrest_method
     */
    public void setReset_interrest_method(Short reset_interrest_method) {
        this.reset_interrest_method = reset_interrest_method;
    }

    /**
     * 日复息-最后一期提前天数
     * @return
     */
    public Integer getLast_term_days() {
        return last_term_days;
    }

    /**
     * 日复息-最后一期提前天数
     * @param last_term_days
     */
    public void setLast_term_days(Integer last_term_days) {
        this.last_term_days = last_term_days;
    }

    /**
     * 首付款是否参与期次排序
     * @return
     */
    public Short getFirst_sort() {
        return first_sort;
    }

    /**
     * 首付款是否参与期次排序
     * @param first_sort
     */
    public void setFirst_sort(Short first_sort) {
        this.first_sort = first_sort;
    }

}