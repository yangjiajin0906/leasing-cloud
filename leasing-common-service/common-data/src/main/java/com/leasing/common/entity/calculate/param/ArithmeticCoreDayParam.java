package com.leasing.common.entity.calculate.param;

import java.math.BigDecimal;

/**
 * @project:leasing-cloud 日复利 计算参数类
 * @date:2019/10/11
 * @author:Yjj@yonyou.com
 * @description:
 **/
public class ArithmeticCoreDayParam {
    /**
     * 实际天数
     */
    public BigDecimal fact_day;
    /**
     * 系数比例
     */
    public BigDecimal radio;
    /**
     * 日利率
     */
    public BigDecimal rate_day;
    /**
     * 净现值系数
     */
    public BigDecimal net_radio;
    /**
     * 计算日期 --本期截至期日
     */
    public String cal_date;
    /**
     * 开始日期 --本期开始日期
     */
    public String begin_date;
    /**
     * 每期租金
     */
    public BigDecimal rent_amount;

    /**
     * 日利息金额处理方式
     */
    public Boolean date_interest;

    /**
     * 投放日期
     */
    public String puttingDate;
    /**
     * 实际天数
     * @return
     */
    public BigDecimal getFact_day() {
        return fact_day;
    }
    /**
     * 实际天数
     * @param fact_day
     */
    public void setFact_day(BigDecimal fact_day) {
        this.fact_day = fact_day;
    }
    /**
     * 系数比例
     * @return
     */
    public BigDecimal getRadio() {
        return radio;
    }
    /**
     * 系数比例
     * @param radio
     */
    public void setRadio(BigDecimal radio) {
        this.radio = radio;
    }
    /**
     * 日利率
     * @return
     */
    public BigDecimal getRate_day() {
        return rate_day;
    }
    /**
     * 日利率
     * @param rate_day
     */
    public void setRate_day(BigDecimal rate_day) {
        this.rate_day = rate_day;
    }
    /**
     * 净现值系数
     * @return
     */
    public BigDecimal getNet_radio() {
        return net_radio;
    }
    /**
     * 净现值系数
     * @param net_radio
     */
    public void setNet_radio(BigDecimal net_radio) {
        this.net_radio = net_radio;
    }
    /**
     * 计算日期
     * @return
     */
    public String getCal_date() {
        return cal_date;
    }
    /**
     * 计算日期
     * @param cal_date
     */
    public void setCal_date(String cal_date) {
        this.cal_date = cal_date;
    }
    /**
     * 租金发生额
     * @return
     */
    public BigDecimal getRent_amount() {
        return rent_amount;
    }
    /**
     * 租金发生额
     * @param rent_amount
     */
    public void setRent_amount(BigDecimal rent_amount) {
        this.rent_amount = rent_amount;
    }
    /**
     * 开始日期 --本期开始日期
     * @return
     */
    public String getBegin_date() {
        return begin_date;
    }
    /**
     * 开始日期 --本期开始日期
     * @param begin_date
     */
    public void setBegin_date(String begin_date) {
        this.begin_date = begin_date;
    }
    /**
     * @return the date_interest
     */
    public Boolean getDate_interest() {
        return date_interest;
    }
    /**
     * @param date_interest the date_interest to set
     */
    public void setDate_interest(Boolean date_interest) {
        this.date_interest = date_interest;
    }
    /**
     * @return the puttingDate
     */
    public String getPuttingDate() {
        return puttingDate;
    }
    /**
     * @param puttingDate the puttingDate to set
     */
    public void setPuttingDate(String puttingDate) {
        this.puttingDate = puttingDate;
    }
}