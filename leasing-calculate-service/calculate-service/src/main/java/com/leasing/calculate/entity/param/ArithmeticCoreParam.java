package com.leasing.calculate.entity.param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @project:leasing-cloud 计算参数类
 * @date:2019/10/11
 * @author:Yjj@yonyou.com
 * @description:
 **/
public class ArithmeticCoreParam {
    /**
     * 计算日期
     */
    public List<String> calDateList;

    /**
     * 投放日期
     */
    public String puttingDate;

    /**
     * 年利率
     */
    public BigDecimal yearRate;

    /**
     * 投放金额
     */
    public BigDecimal puttingAmount;

    /**
     * 计算方式
     */
    public Short lease_cal_method;

    /**
     * 计算公式金额
     */
    public BigDecimal cal_amount;

    /**
     * 支付频率
     */
    public Short payment_frequency;
    /**
     * 计算期数
     */
    public Integer term;
    /**
     * 先付后付
     */
    public Short prepay_or_not;
    /**
     * 年计算天数
     */
    public Short year_days;
    /**
     * irr计算天数-使用360还是365
     */
    public Short irr_days;
    /**
     * irr年利率计算方式 - 是日*360还是日*365
     */
    public Short day_value;
    /**
     * 间隔天数
     */
    public Integer lease_interval;
    /**
     * 小数精度
     */
    public int cal_digit;

    /**
     * 资产余值
     */
    public BigDecimal assets_margin;
    /**
     * 特殊算法设置
     */
    public Short special_arithmetic_settings;
    /**
     * 利息计算方式
     */
    public Short occur_interest_method;
    /**
     * 日复利每期所占比例
     * 默认为1
     */
    public BigDecimal radio_hyear;
    /**
     * 是否按照实际天数计算
     */
    public boolean factDay;
    /**
     * 是否指定首期收租日
     */
    public Boolean has_first_lease_date;
    /**
     * 根据现金流计算利率,按照期（月）和按照日
     */
    public Short fix_method;
    /**
     * 收租计划列表-业务
     * 与客户间的约定
     */
    public List<CalArithmeticVO> rentList;
    /**
     * 商业折扣
     */
    public BigDecimal tradeDiscount;

    /**
     * 不规则-本金为负是否调整为0
     */
    public Short corpus_adjust_zero;

    /**
     * 不规则-单利法、复利法
     */
    public Short corpus_way;
    /**
     * 日利息金额处理方式
     */
    public Boolean date_interest;
    /**
     * 是否全为指定租金
     */
    public Boolean isAllRentSpe;

    /**
     * 上一期分摊结束日期
     */
    public String lastDay;

    /**
     * 报价投放计划
     */
    public List<LeaseLoanPlanVO> lease_loan_plan;

    /**
     * @return the lastDay
     */
    public String getLastDay() {
        return lastDay;
    }
    /**
     * @param lastDay the lastDay to set
     */
    public void setLastDay(String lastDay) {
        this.lastDay = lastDay;
    }
    /**
     * 计算日期
     * @return
     */
    public List<String> getCalDateList() {
        return calDateList;
    }
    /*
     * 计算日期
     */
    public void setCalDateList(List<String> calDateList) {
        this.calDateList = calDateList;
    }
    /**
     * 年利率
     */
    public BigDecimal getYearRate() {
        return yearRate;
    }
    /**
     * 年利率
     */
    public void setYearRate(BigDecimal yearRate) {
        this.yearRate = yearRate;
    }
    /**
     * 投放金额
     */
    public BigDecimal getPuttingAmount() {
        return puttingAmount;
    }
    /**
     * 投放金额
     */
    public void setPuttingAmount(BigDecimal puttingAmount) {
        this.puttingAmount = puttingAmount;
    }
    /**
     * 计算方式
     */
    public Short getLease_cal_method() {
        return lease_cal_method;
    }
    /**
     * 计算方式
     */
    public void setLease_cal_method(Short lease_cal_method) {
        this.lease_cal_method = lease_cal_method;
    }
    /**
     * 计算公式金额
     */
    public BigDecimal getCal_amount() {
        return cal_amount;
    }
    /**
     * 计算公式金额
     */
    public void setCal_amount(BigDecimal cal_amount) {
        this.cal_amount = cal_amount;
    }
    /**
     * 期数
     * @return
     */
    public Integer getTerm() {
        return term;
    }
    /**
     * 期数
     * @param term
     */
    public void setTerm(Integer term) {
        this.term = term;
    }
    /**
     * 先付后付
     * @return
     */
    public Short getPrepay_or_not() {
        return prepay_or_not;
    }
    /**
     * 先付后付
     * @param prepay_or_not
     */
    public void setPrepay_or_not(Short prepay_or_not) {
        this.prepay_or_not = prepay_or_not;
    }
    /**
     * 年化天数
     * @return
     */
    public Short getYear_days() {
        return year_days;
    }
    /**
     * 年化天数
     * @param year_days
     */
    public void setYear_days(Short year_days) {
        this.year_days = year_days;
    }
    /**
     * 间隔天数
     * @return
     */
    public Integer getLease_interval() {
        return lease_interval;
    }
    /**
     * 间隔天数
     * @param lease_interval
     */
    public void setLease_interval(Integer lease_interval) {
        this.lease_interval = lease_interval;
    }
    /**
     * 计算精度
     * @return
     */
    public int getCal_digit() {
        return cal_digit;
    }
    /**
     * 计算精度
     * @param cal_digit
     */
    public void setCal_digit(int cal_digit) {
        this.cal_digit = cal_digit;
    }
    /**
     * 资产余值
     * @return
     */
    public BigDecimal getAssets_margin() {
        return assets_margin;
    }
    /**
     * 资产余值
     * @param assets_margin
     */
    public void setAssets_margin(BigDecimal assets_margin) {
        this.assets_margin = assets_margin;
    }
    /**
     * 是否按照实际天数计算
     * @return
     */
    public boolean getFactDay() {
        return factDay;
    }
    /**
     * 是否按照实际天数计算
     * @param factDay
     */
    public void setFactDay(boolean factDay) {
        this.factDay = factDay;
    }
    /**
     * 是否指定首期收租日
     * @return
     */
    public Boolean getHas_first_lease_date() {
        return has_first_lease_date;
    }
    /**
     * 是否指定首期收租日
     * @param has_first_lease_date
     */
    public void setHas_first_lease_date(Boolean has_first_lease_date) {
        this.has_first_lease_date = has_first_lease_date;
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
     * 特殊算法设置
     * @return
     */
    public Short getSpecial_arithmetic_settings() {
        return special_arithmetic_settings;
    }
    /**
     * 特殊算法设置
     * @param special_arithmetic_settings
     */
    public void setSpecial_arithmetic_settings(Short special_arithmetic_settings) {
        this.special_arithmetic_settings = special_arithmetic_settings;
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
     * 收租计划列表
     * @return
     */
    public List<CalArithmeticVO> getRentList() {
        return rentList;
    }
    /**
     * 收租计划列表
     * @param rentList
     */
    public void setRentList(List<CalArithmeticVO> rentList) {
        this.rentList = rentList;
    }
    /**
     * 投放日期
     * @return
     */
    public String getPuttingDate() {
        return puttingDate;
    }
    /**
     * 投放日期
     * @param puttingDate
     */
    public void setPuttingDate(String puttingDate) {
        this.puttingDate = puttingDate;
    }
    /**
     * 日复利每期所占比例
     * @return
     */
    public BigDecimal getRadio_hyear() {
        return radio_hyear;
    }
    /**
     * 日复利每期所占比例
     * @param radio_hyear
     */
    public void setRadio_hyear(BigDecimal radio_hyear) {
        this.radio_hyear = radio_hyear;
    }
    /**
     * 根据现金流计算利率,按照期（月）和按照日
     * @return
     */
    public Short getFix_method() {
        return fix_method;
    }
    /**
     * 根据现金流计算利率,按照期（月）和按照日
     * @param fix_method
     */
    public void setFix_method(Short fix_method) {
        this.fix_method = fix_method;
    }
    /**
     * 商业折扣
     * @return
     */
    public BigDecimal getTradeDiscount() {
        return tradeDiscount;
    }
    /**
     * 商业折扣
     * @param tradeDiscount
     */
    public void setTradeDiscount(BigDecimal tradeDiscount) {
        this.tradeDiscount = tradeDiscount;
    }

    /**
     * @return the irr_days
     */
    public Short getIrr_days() {
        return irr_days;
    }
    /**
     * @param irr_days the irr_days to set
     */
    public void setIrr_days(Short irr_days) {
        this.irr_days = irr_days;
    }
    /**
     * irr年利率计算方式 - 是日*360还是日*365
     * @return
     */
    public Short getDay_value() {
        return day_value;
    }
    /**
     * irr年利率计算方式 - 是日*360还是日*365
     * @param day_value
     */
    public void setDay_value(Short day_value) {
        this.day_value = day_value;
    }
    /**
     * @return the corpus_adjust_zero
     */
    public Short getCorpus_adjust_zero() {
        return corpus_adjust_zero;
    }
    /**
     * @param corpus_adjust_zero the corpus_adjust_zero to set
     */
    public void setCorpus_adjust_zero(Short corpus_adjust_zero) {
        this.corpus_adjust_zero = corpus_adjust_zero;
    }
    /**
     * @return the corpus_way
     */
    public Short getCorpus_way() {
        return corpus_way;
    }
    /**
     * @param corpus_way the corpus_way to set
     */
    public void setCorpus_way(Short corpus_way) {
        this.corpus_way = corpus_way;
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
     * 是否全为指定租金
     * @return the isAllRentSpe
     */
    public Boolean getIsAllRentSpe() {
        return isAllRentSpe;
    }
    /**
     * @param isAllRentSpe the isAllRentSpe to set
     */
    public void setIsAllRentSpe(Boolean isAllRentSpe) {
        this.isAllRentSpe = isAllRentSpe;
    }
    /**
     * 本金是否开票
     */
    public Short if_corpus_tickets;
    /**
     * 税种
     */
    public Short tax_mode;
    public Short getIf_corpus_tickets() {
        return if_corpus_tickets;
    }
    public void setIf_corpus_tickets(Short if_corpus_tickets) {
        this.if_corpus_tickets = if_corpus_tickets;
    }
    public Short getTax_mode() {
        return tax_mode;
    }
    public void setTax_mode(Short tax_mode) {
        this.tax_mode = tax_mode;
    }
    public List<LeaseLoanPlanVO> getLease_loan_plan() {
        return lease_loan_plan;
    }
    public void setLease_loan_plan(List<LeaseLoanPlanVO> lease_loan_plan) {
        this.lease_loan_plan = lease_loan_plan;
    }

    public Short rent_tax_rate;

    public Short getRent_tax_rate() {
        return rent_tax_rate;
    }
    public void setRent_tax_rate(Short rent_tax_rate) {
        this.rent_tax_rate = rent_tax_rate;
    }

}