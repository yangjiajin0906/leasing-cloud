package com.leasing.common.entity.calculate.vo.cal;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/11/5
 * @author:Yjj@yonyou.com
 * @description: 远期支付参数封装
 **/
public class ParamForwardPayment implements Serializable {
    /**
     * 远期支付期限
     */
    public Integer forward_times;

    /**
     * 远期支付频率
     */
    public Short forward_frequency;

    /**
     * 远期支付每期金额
     */
    public BigDecimal lease_cash;

    /**
     * 远期投放时间
     */
    public String putting_date;

    /**
     * 远期是否收收付款
     */
    public Short cash_if_first;

    /**
     * 远期支付期限
     * @return
     */
    public Integer getForward_times() {
        return forward_times;
    }

    /**
     * 远期支付期限
     * @param forward_times
     */
    public void setForward_times(Integer forward_times) {
        this.forward_times = forward_times;
    }

    /**
     * 远期支付频率
     * @return
     */
    public Short getForward_frequency() {
        return forward_frequency;
    }

    /**
     * 远期支付频率
     * @param forward_frequency
     */
    public void setForward_frequency(Short forward_frequency) {
        this.forward_frequency = forward_frequency;
    }

    /**
     * 远期支付每期金额
     * @return
     */
    public BigDecimal getLease_cash() {
        return lease_cash;
    }

    /**
     * 远期支付每期金额
     * @param lease_cash
     */
    public void setLease_cash(BigDecimal lease_cash) {
        this.lease_cash = lease_cash;
    }

    /**
     * 远期投放时间
     * @return
     */
    public String getPutting_date() {
        return putting_date;
    }

    /**
     * 远期投放时间
     * @param putting_date
     */
    public void setPutting_date(String putting_date) {
        this.putting_date = putting_date;
    }

    /**
     *  远期是否收收付款
     * @return
     */
    public Short getCash_if_first() {
        return cash_if_first;
    }

    /**
     *  远期是否收收付款
     * @param cash_if_first
     */
    public void setCash_if_first(Short cash_if_first) {
        this.cash_if_first = cash_if_first;
    }
}