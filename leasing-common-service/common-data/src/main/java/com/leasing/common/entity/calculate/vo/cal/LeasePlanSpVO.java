package com.leasing.common.entity.calculate.vo.cal;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/11/5
 * @author:Yjj@yonyou.com
 * @description: 收租规则设置
 **/
public class LeasePlanSpVO implements Serializable{
    /**
     * 支付期次
     */
    public Integer lease_time;
    /**
     * 支付频率
     */
    public Short lease_freq;
    /**
     * 计算方式
     */
    public Short lease_cal_method;
    /**
     * 租金金额
     */
    public BigDecimal lease_cash;


    /**
     * 支付期次的getter方法
     *
     * @return Integer
     */
    public Integer getLease_time() {
        return lease_time;
    }

    /**
     * 支付期次的setter方法
     *
     * @param lease_time 支付期次
     */
    public void setLease_time(Integer lease_time) {
        this.lease_time = lease_time;
    }

    /**
     * 支付频率的getter方法
     *
     * @return Short
     */
    public Short getLease_freq() {
        return lease_freq;
    }

    /**
     * 支付频率的setter方法
     *
     * @param lease_freq 支付频率
     */
    public void setLease_freq(Short lease_freq) {
        this.lease_freq = lease_freq;
    }

    /**
     * 计算方式的getter方法
     *
     * @return Short
     */
    public Short getLease_cal_method() {
        return lease_cal_method;
    }

    /**
     * 计算方式的setter方法
     *
     * @param lease_cal_method 计算方式
     */
    public void setLease_cal_method(Short lease_cal_method) {
        this.lease_cal_method = lease_cal_method;
    }

    /**
     * 租金金额的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getLease_cash() {
        return lease_cash;
    }

    /**
     * 租金金额的setter方法
     *
     * @param lease_cash 租金金额
     */
    public void setLease_cash(BigDecimal lease_cash) {
        this.lease_cash = lease_cash;
    }

}