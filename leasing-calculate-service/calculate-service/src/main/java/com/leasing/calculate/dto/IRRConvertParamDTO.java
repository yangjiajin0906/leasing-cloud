package com.leasing.calculate.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud 用于IRR倒算
 * @date:2019/10/10
 * @author:Yjj@yonyou.com
 * @description:
 **/
public class IRRConvertParamDTO implements Serializable {
    /**
     * 是否保存计算结果(主要用于IRR倒算)
     */
    public Boolean isSaveResult;

    /**
     * “是否”判断结果集(主要用于IRR倒算)
     */
    public Integer resultInt;

    /**
     * 计算结果类(主要用于IRR倒算)
     */
    //public CalBusinessParam calBusi;

    /**
     * 当前租息率(主要用于IRR倒算)
     */
    public BigDecimal curFinal_rate;

    /**
     * 弹出框提示信息
     */
    public StringBuffer sbinfo;

    /**
     * 当前浮动值(主要用于IRR倒算)
     */
    public BigDecimal curFloat_value;

    /**
     * 保证金
     */
    public BigDecimal deposit_cash;

    /**
     * 服务费金额
     */
    public BigDecimal srvin_cash;

    /**
     * 首付款比例
     */
    public BigDecimal curDown_payment_ratio;

    // 每期租金原始值
    public BigDecimal lease_cash;
    // 总租金原始值
    public BigDecimal lease_cash_sum;
    // 利率
    public BigDecimal interest_rate;
    // 费率
    public BigDecimal plan_rate;

    public Boolean getIsSaveResult() {
        return isSaveResult;
    }

    public void setIsSaveResult(Boolean isSaveResult) {
        this.isSaveResult = isSaveResult;
    }

    public Integer getResultInt() {
        return resultInt;
    }

    public void setResultInt(Integer resultInt) {
        this.resultInt = resultInt;
    }

//    public CalBusinessParam getCalBusi() {
//        return calBusi;
//    }
//
//    public void setCalBusi(CalBusinessParam calBusi) {
//        this.calBusi = calBusi;
//    }

    public BigDecimal getCurFinal_rate() {
        return curFinal_rate;
    }

    public void setCurFinal_rate(BigDecimal curFinal_rate) {
        this.curFinal_rate = curFinal_rate;
    }

    public StringBuffer getSbinfo() {
        return sbinfo;
    }

    public void setSbinfo(StringBuffer sbinfo) {
        this.sbinfo = sbinfo;
    }

    public BigDecimal getCurFloat_value() {
        return curFloat_value;
    }

    public void setCurFloat_value(BigDecimal curFloat_value) {
        this.curFloat_value = curFloat_value;
    }

    public BigDecimal getDeposit_cash() {
        return deposit_cash;
    }

    public void setDeposit_cash(BigDecimal deposit_cash) {
        this.deposit_cash = deposit_cash;
    }

    public BigDecimal getSrvin_cash() {
        return srvin_cash;
    }

    public void setSrvin_cash(BigDecimal srvin_cash) {
        this.srvin_cash = srvin_cash;
    }

    public BigDecimal getCurDown_payment_ratio() {
        return curDown_payment_ratio;
    }

    public void setCurDown_payment_ratio(BigDecimal curDown_payment_ratio) {
        this.curDown_payment_ratio = curDown_payment_ratio;
    }

    /**
     * @return the lease_cash
     */
    public BigDecimal getLease_cash() {
        return lease_cash;
    }

    /**
     * @param lease_cash the lease_cash to set
     */
    public void setLease_cash(BigDecimal lease_cash) {
        this.lease_cash = lease_cash;
    }

    /**
     * @return the lease_cash_sum
     */
    public BigDecimal getLease_cash_sum() {
        return lease_cash_sum;
    }

    /**
     * @param lease_cash_sum the lease_cash_sum to set
     */
    public void setLease_cash_sum(BigDecimal lease_cash_sum) {
        this.lease_cash_sum = lease_cash_sum;
    }

    /**
     * @return the interest_rate
     */
    public BigDecimal getInterest_rate() {
        return interest_rate;
    }

    /**
     * @param interest_rate the interest_rate to set
     */
    public void setInterest_rate(BigDecimal interest_rate) {
        this.interest_rate = interest_rate;
    }

    /**
     * @return the plan_rate
     */
    public BigDecimal getPlan_rate() {
        return plan_rate;
    }

    /**
     * @param plan_rate the plan_rate to set
     */
    public void setPlan_rate(BigDecimal plan_rate) {
        this.plan_rate = plan_rate;
    }
}