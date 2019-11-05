package com.leasing.common.entity.calculate.vo.cal;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/11/5
 * @author:Yjj@yonyou.com
 * @description: 不规则参数封装
 **/
public class ParamIrregularVO implements Serializable {
    /**
     * 不规则计算方式
     */
    public static Short irregular_cal_method;

    /**
     * 计划投放金额
     */
    public static BigDecimal plan_cash_loan;

    /**
     * 计划投放日期
     */
    public static String plan_cash_date;

    /**
     * 商业折扣
     * */
    public static BigDecimal trade_discount;

    /**
     * 不规则计算方式
     * @return
     */
    public static Short getIrregular_cal_method() {
        return irregular_cal_method;
    }

    /**
     * 不规则计算方式
     * @param irregular_cal_method
     */
    public static void setIrregular_cal_method(Short irregular_cal_method) {
        ParamIrregularVO.irregular_cal_method = irregular_cal_method;
    }

    /**
     * 计划投放金额
     * @return
     */
    public static BigDecimal getPlan_cash_loan() {
        return plan_cash_loan;
    }

    /**
     * 计划投放金额
     * @param plan_cash_loan
     */
    public static void setPlan_cash_loan(BigDecimal plan_cash_loan) {
        ParamIrregularVO.plan_cash_loan = plan_cash_loan;
    }

    /**
     * 计划投放日期
     * @return the plan_cash_date
     */
    public static String getPlan_cash_date() {
        return plan_cash_date;
    }

    /**
     * 计划投放日期
     * @param plan_cash_date the plan_cash_date to set
     */
    public static void setPlan_cash_date(String plan_cash_date) {
        ParamIrregularVO.plan_cash_date = plan_cash_date;
    }

    /**
     * @return the trade_discount
     */
    public static BigDecimal getTrade_discount() {
        return trade_discount;
    }

    /**
     * @param trade_discount the trade_discount to set
     */
    public static void setTrade_discount(BigDecimal trade_discount) {
        ParamIrregularVO.trade_discount = trade_discount;
    }

}