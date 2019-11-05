package com.leasing.calculate.utils;

import com.leasing.common.entity.calculate.vo.cal.ArithmeticCoreDayParam;
import com.leasing.common.enums.arithmetic.Year_Days;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @project:leasing-cloud 算法vo基本数据 工具类
 * @date:2019/10/28
 * @author:Yjj@yonyou.com
 * @description:
 **/
public class BaseAppVO {

    /**
     * 获取日复利的计算参数(不计算净现值net_radio)
     * @param factDay 实际发生天数
     * @param radio   计算系数
     * @param dayRate 日利率
     * @param calDate 计算日期
     * @return
     */
    public static ArithmeticCoreDayParam getCoreDayParamNotNet(int factDay, BigDecimal radio, BigDecimal dayRate,
                                                               String calDate, String beginDate ) {
        ArithmeticCoreDayParam dayParam = new ArithmeticCoreDayParam();
        dayParam.setFact_day(BigDecimal.valueOf(factDay));
        dayParam.setRadio(radio);
        dayParam.setRate_day(dayRate);
        dayParam.setCal_date(calDate);
        dayParam.setBegin_date(beginDate);
        return dayParam;
    }

    /**
     * 获取日复利的计算参数
     * @param factDay 实际发生天数
     * @param radio   计算系数
     * @param dayRate 日利率
     * @param calDate 计算日期
     * @return
     */
    public static ArithmeticCoreDayParam getCoreDayParam(int factDay, BigDecimal radio, BigDecimal dayRate,
                                                         String calDate, String beginDate ) {
        ArithmeticCoreDayParam dayParam = new ArithmeticCoreDayParam();
        dayParam.setFact_day(BigDecimal.valueOf(factDay));
        dayParam.setRadio(radio);
        dayParam.setRate_day(dayRate);
        dayParam.setNet_radio(BaseApp.getNetDayRadio(factDay, dayRate, radio));
        dayParam.setCal_date(calDate);
        dayParam.setBegin_date(beginDate);
        return dayParam;
    }

    /**
     * 获取年计算天数为365的期息率
     *
     * @param yearRate
     * @param term
     * @return
     */
    public static BigDecimal getTerm365Rate(BigDecimal yearRate, int term) {
        BigDecimal term365Rate = ((BigDecimal.ONE.add((yearRate.multiply(BigDecimal.valueOf(365)).divide(BigDecimal
                .valueOf(360), MathContext.DECIMAL64)).divide(BigDecimal.valueOf(12), MathContext.DECIMAL64)))
                .pow(term).setScale(10, RoundingMode.HALF_UP)).subtract(BigDecimal.ONE);
        /** DELETE  【 wangjj】 【2016年12月5日】 【BUG修改】年化天数 365 期利率计算 {[1+ (年利率*365/(360*12))]^支付频率对应的月数}-1 期利率不舍位*/
//        term365Rate = term365Rate.multiply(BigDecimal.valueOf(12 / term), MathContext.DECIMAL64).setScale(6,
//                RoundingMode.HALF_UP).divide(BigDecimal.valueOf(12 / term), MathContext.DECIMAL64);
        /** DELETE  END */

        return term365Rate;
    }

    /**
     * 期利率计算
     *
     * @param year_days
     *            年华天数
     * @param yearRate
     *            年利率
     * @param payment_frequency
     *            支付频率
     * @return
     */
    public static BigDecimal getTermRate(Short year_days, BigDecimal yearRate, Short payment_frequency) {

        BigDecimal termRate = new BigDecimal("0.0");
        int step = BaseApp.getBaseFrequency(payment_frequency);
        if (Year_Days.YEAR_360.getShort().equals(year_days)&&step!=0) {
            termRate = yearRate.divide(BigDecimal.valueOf(step), MathContext.DECIMAL64);
        } else if(step!=0){
            /** UPDATE  【 wangjj】 【2016年12月5日】 【BUG修改】年化天数 365 期利率计算 {[1+ (年利率*365/(360*12))]^支付频率对应的月数}-1*/
            int step_365 = BaseApp.getPaymentFrequency(payment_frequency);
            termRate = BaseAppVO.getTerm365Rate(yearRate, step_365);
            /** UPDATE  END */

        }
        return termRate;
    }

    /**
     * 计算日利率 目前交银计算用的是360，不管年计算天数
     *
     * @param yearRate
     * @param year_days
     * @return
     */
    public static BigDecimal getDayRate(BigDecimal yearRate, Short year_days) {
        BigDecimal dayDate = new BigDecimal("0.00");
        if (year_days.intValue() == Year_Days.YEAR_360.getShort().intValue()) {
            dayDate = yearRate.divide(BigDecimal.valueOf(360), MathContext.DECIMAL64);
        } else {
            dayDate = yearRate.divide(BigDecimal.valueOf(365), MathContext.DECIMAL64);
        }
        return dayDate;
    }

}