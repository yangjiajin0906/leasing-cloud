package com.leasing.common.entity.calculate.vo.cal;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/11/5
 * @author:Yjj@yonyou.com
 * @description: 服务费参数封装，包括支出和收入
 **/
public class ParamServiceRule implements Serializable{
    /**
     * 服务费类型-收入
     */
    public Short srvfee_type_income;


    /**
     * 服务费比例-收入
     */
    public BigDecimal srvfee_ratio_income;


    /**
     * 服务费金额-收入
     */
    public BigDecimal srvfee_cash_income;


    /**
     * 服务费收取方式-收入
     */
    public Short srvfee_method_income;

    /**
     * 服务费基数 - 收入
     */
    public Short srvfee_base_income;

    /**
     * 服务费类型-支出
     */
    public Short srvfee_type_pay;


    /**
     * 服务费比例-支出
     */
    public BigDecimal srvfee_ratio_pay;


    /**
     * 服务费金额-支出
     */
    public BigDecimal srvfee_cash_pay;


    /**
     * 服务费支出方式-支出
     */
    public Short srvfee_method_pay;

    /**
     * 服务费基数 - 支出
     */
    public Short srvfee_base_pay;

    /**
     * 服务费首期支出日期
     */
    public String srvfee_first_date;

    /**
     * 服务费是否按照整年收取
     */
    public Short srvfee_charge_times;
    /**
     * 服务费类型-收入
     * @return
     */
    public Short getSrvfee_type_income() {
        return srvfee_type_income;
    }
    /**
     * 服务费类型-收入
     * @param srvfee_type
     */
    public void setSrvfee_type_income(Short srvfee_type_income) {
        this.srvfee_type_income = srvfee_type_income;
    }
    /**
     * 服务费比例-收入
     * @return
     */
    public BigDecimal getSrvfee_ratio_income() {
        return srvfee_ratio_income;
    }
    /**
     * 服务费比例-收入
     * @param srvfee_ratio
     */
    public void setSrvfee_ratio_income(BigDecimal srvfee_ratio_income) {
        this.srvfee_ratio_income = srvfee_ratio_income;
    }
    /**
     * 服务费金额-收入
     * @return
     */
    public BigDecimal getSrvfee_cash_income() {
        return srvfee_cash_income;
    }
    /**
     * 服务费金额-收入
     * @param srvfee_cash
     */
    public void setSrvfee_cash_income(BigDecimal srvfee_cash_income) {
        this.srvfee_cash_income = srvfee_cash_income;
    }
    /**
     * 服务费收取方式-收入
     * @return
     */
    public Short getSrvfee_method_income() {
        return srvfee_method_income;
    }
    /**
     * 服务费收取方式-收入
     * @param srvfee_method
     */
    public void setSrvfee_method_income(Short srvfee_method_income) {
        this.srvfee_method_income = srvfee_method_income;
    }

    /**
     * 服务费类型-支出
     * @return
     */
    public Short getSrvfee_type_pay() {
        return srvfee_type_pay;
    }
    /**
     * 服务费类型-支出
     * @param srvfee_type_pay
     */
    public void setSrvfee_type_pay(Short srvfee_type_pay) {
        this.srvfee_type_pay = srvfee_type_pay;
    }
    /**
     * 服务费比例-支出
     * @return
     */
    public BigDecimal getSrvfee_ratio_pay() {
        return srvfee_ratio_pay;
    }
    /**
     * 服务费比例-支出
     * @param srvfee_ratio_pay
     */
    public void setSrvfee_ratio_pay(BigDecimal srvfee_ratio_pay) {
        this.srvfee_ratio_pay = srvfee_ratio_pay;
    }
    /**
     * 服务费金额-支出
     * @return
     */
    public BigDecimal getSrvfee_cash_pay() {
        return srvfee_cash_pay;
    }
    /**
     * 服务费金额-支出
     * @param srvfee_cash_pay
     */
    public void setSrvfee_cash_pay(BigDecimal srvfee_cash_pay) {
        this.srvfee_cash_pay = srvfee_cash_pay;
    }
    /**
     * 服务费收取方式-支出
     * @return
     */
    public Short getSrvfee_method_pay() {
        return srvfee_method_pay;
    }
    /**
     * 服务费收取方式-支出
     * @param srvfee_method_pay
     */
    public void setSrvfee_method_pay(Short srvfee_method_pay) {
        this.srvfee_method_pay = srvfee_method_pay;
    }
    /**
     * 服务费基数 - 收入
     * @return
     */
    public Short getSrvfee_base_income() {
        return srvfee_base_income;
    }
    /**
     * 服务费基数 - 收入
     * @param srvfee_base_income
     */
    public void setSrvfee_base_income(Short srvfee_base_income) {
        this.srvfee_base_income = srvfee_base_income;
    }
    /**
     * 服务费首期支出日期
     * @return
     */
    public String getSrvfee_first_date() {
        return srvfee_first_date;
    }
    /**
     * 服务费首期支出日期
     * @param srvfee_first_date
     */
    public void setSrvfee_first_date(String srvfee_first_date) {
        this.srvfee_first_date = srvfee_first_date;
    }
    /**
     * 服务费是否按照整年收取
     * @return
     */
    public Short getSrvfee_charge_times() {
        return srvfee_charge_times;
    }
    /**
     * 服务费是否按照整年收取
     * @param srvfee_charge_times
     */
    public void setSrvfee_charge_times(Short srvfee_charge_times) {
        this.srvfee_charge_times = srvfee_charge_times;
    }
    /**
     * @return the srvfee_base_pay
     */
    public Short getSrvfee_base_pay() {
        return srvfee_base_pay;
    }
    /**
     * @param srvfee_base_pay the srvfee_base_pay to set
     */
    public void setSrvfee_base_pay(Short srvfee_base_pay) {
        this.srvfee_base_pay = srvfee_base_pay;
    }

}