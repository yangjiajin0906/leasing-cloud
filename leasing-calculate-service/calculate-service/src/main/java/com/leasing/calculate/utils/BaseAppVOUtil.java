package com.leasing.calculate.utils;

import com.leasing.calculate.entity.param.ArithmeticCoreDayParam;
import com.leasing.common.enums.arithmetic.Payment_Frequency;
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
public class BaseAppVOUtil {
    /**
     * 获取日的净现值系数
     *
     * @param days
     *            发生天数
     * @param dayRate
     *            日利率
     * @param radio
     *            系数比例 公式 = 系数比例/(1+日利率)的days次方
     * @return
     */
    public static BigDecimal getNetDayRadio(int days, BigDecimal dayRate, BigDecimal radio) {
        BigDecimal dayRadio = BigDecimal.ZERO;
        BigDecimal common = (BigDecimal.ONE.add(dayRate)).pow(days);
        dayRadio = BigDecimal.ONE.divide(common, MathContext.DECIMAL64);
        dayRadio = dayRadio.multiply(radio, MathContext.DECIMAL64);
        return dayRadio;
    }
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
        dayParam.setNet_radio(BaseAppVOUtil.getNetDayRadio(factDay, dayRate, radio));
        dayParam.setCal_date(calDate);
        dayParam.setBegin_date(beginDate);
        return dayParam;
    }

    /**
     * 获取频率对应的月数
     * @param paymentFrequency
     *            支付频率
     * @return
     */
    public static int getPaymentFrequency(Short paymentFrequency) {
        if (Payment_Frequency.MONTH.getShort().equals(paymentFrequency)) {
            return 1;
        } else if (Payment_Frequency.TWIN_MONTH.getShort().equals(paymentFrequency)) {
            return 2;
        } else if (Payment_Frequency.SEASON.getShort().equals(paymentFrequency)) {
            return 3;
        } else if (Payment_Frequency.FOUR_MONTH.getShort().equals(paymentFrequency)) {
            return 4;
        } else if (Payment_Frequency.HALF_YEAR.getShort().equals(paymentFrequency)) {
            return 6;
        } else if (Payment_Frequency.YEAR.getShort().equals(paymentFrequency)) {
            return 12;
        } else {
            return 0;
        }
    }

    /**
     * 获取频率对应的期利率计算
     * @param paymentFrequency
     *            支付频率
     * @return
     */
    public static int getBaseFrequency(Short paymentFrequency) {
        if (Payment_Frequency.MONTH.getShort().equals(paymentFrequency)) {
            return 12;
        } else if (Payment_Frequency.TWIN_MONTH.getShort().equals(paymentFrequency)) {
            return 6;
        } else if (Payment_Frequency.SEASON.getShort().equals(paymentFrequency)) {
            return 4;
        } else if (Payment_Frequency.FOUR_MONTH.getShort().equals(paymentFrequency)) {
            return 3;
        } else if (Payment_Frequency.HALF_YEAR.getShort().equals(paymentFrequency)) {
            return 2;
        } else if (Payment_Frequency.YEAR.getShort().equals(paymentFrequency)) {
            return 1;
        } else {
            return 0;
        }
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
        int step = BaseAppVOUtil.getBaseFrequency(payment_frequency);
        if (Year_Days.YEAR_360.getShort().equals(year_days)&&step!=0) {
            termRate = yearRate.divide(BigDecimal.valueOf(step), MathContext.DECIMAL64);
        } else if(step!=0){
            /** UPDATE  【 wangjj】 【2016年12月5日】 【BUG修改】年化天数 365 期利率计算 {[1+ (年利率*365/(360*12))]^支付频率对应的月数}-1*/
            int step_365 = BaseAppVOUtil.getPaymentFrequency(payment_frequency);
            termRate = BaseAppVOUtil.getTerm365Rate(yearRate, step_365);
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