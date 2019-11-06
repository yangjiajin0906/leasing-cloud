package com.leasing.common.entity.calculate.vo.cal;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/11/5
 * @author:Yjj@yonyou.com
 * @description: 保证金参数封装
 **/
public class ParamDepositRule implements Serializable {
    /**
     * 保证金金额
     */
    public BigDecimal deposit_cash;

    /**
     * 保证金是否计息
     */
    public Short if_interest_depos;
    /**
     * 保证金比例
     */
    public BigDecimal deposit_ratio;

    /**
     * 保证金利率
     */
    public BigDecimal final_rate;

    /**
     * 保证金收取方式
     */
    public Short deposit_method;

    /**
     * 保证金退回方式
     */
    public Short deposit_back_method;

    /**
     * 保证金利息
     */
    public BigDecimal deposit_interest;

    /**
     * 保证金金额的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getDeposit_cash() {
        return deposit_cash;
    }

    /**
     * 保证金金额的setter方法
     *
     * @param deposit_cash 保证金金额
     */
    public void setDeposit_cash(BigDecimal deposit_cash) {
        this.deposit_cash = deposit_cash;
    }

    /**
     * 保证金是否计息的getter方法
     *
     * @return Boolean
     */
    public Short getIf_interest_depos() {
        return if_interest_depos;
    }

    /**
     * 保证金是否计息的setter方法
     *
     * @param if_interest_depos 保证金是否计息
     */
    public void setIf_interest_depos(Short if_interest_depos) {
        this.if_interest_depos = if_interest_depos;
    }

    /**
     * 保证金利率的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getFinal_rate() {
        return final_rate;
    }

    /**
     * 保证金利率的setter方法
     *
     * @param final_rate_d 保证金利率
     */
    public void setFinal_rate(BigDecimal final_rate) {
        this.final_rate = final_rate;
    }

    /**
     * 保证金收取方式的getter方法
     *
     * @return Short
     */
    public Short getDeposit_method() {
        return deposit_method;
    }

    /**
     * 保证金收取方式的setter方法
     *
     * @param deposit_method 保证金收取方式
     */
    public void setDeposit_method(Short deposit_method) {
        this.deposit_method = deposit_method;
    }

    /**
     * 保证金比例
     * @return
     */
    public BigDecimal getDeposit_ratio() {
        return deposit_ratio;
    }
    /**
     * 保证金比例
     * @param deposit_ratio
     */
    public void setDeposit_ratio(BigDecimal deposit_ratio) {
        this.deposit_ratio = deposit_ratio;
    }
    /**
     * 保证金退回方式
     * @return
     */
    public Short getDeposit_back_method() {
        return deposit_back_method;
    }

    /**
     * 保证金退回方式
     * @param deposit_back_method
     */
    public void setDeposit_back_method(Short deposit_back_method) {
        this.deposit_back_method = deposit_back_method;
    }

    /**
     * @return the deposit_interest
     */
    public BigDecimal getDeposit_interest() {
        return deposit_interest;
    }

    /**
     * @param deposit_interest the deposit_interest to set
     */
    public void setDeposit_interest(BigDecimal deposit_interest) {
        this.deposit_interest = deposit_interest;
    }

    /**Bug修改  保证金  已核销保证金冲抵 金额  在自动冲抵 时，生成保证金冲抵记录时，用的是全部的保证金 金额 ， 应该 使用 未核销的剩余保证金金额*/
    /**
     * 已核销的保证金冲抵金额
     */
    public BigDecimal deposit_cash_has;

    public BigDecimal getDeposit_cash_has() {
        return deposit_cash_has;
    }

    public void setDeposit_cash_has(BigDecimal deposit_cash_has) {
        this.deposit_cash_has = deposit_cash_has;
    }

    /***/
}