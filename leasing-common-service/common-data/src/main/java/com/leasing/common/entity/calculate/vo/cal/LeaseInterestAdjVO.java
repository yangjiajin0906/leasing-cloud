package com.leasing.common.entity.calculate.vo.cal;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/11/5
 * @author:Yjj@yonyou.com
 * @description: 调息历史存储表
 **/
public class LeaseInterestAdjVO implements Serializable {

    /**
     * 响应日期
     */
    public String cal_date;
    /**
     * 在建期实际利率
     */
    public BigDecimal real_rate_c;
    /**
     * 实际利率
     */
    public BigDecimal real_rate;

    /**
     * 响应日期的getter方法
     *
     * @return String
     */
    public String getCal_date() {
        return cal_date;
    }

    /**
     * 响应日期的setter方法
     *
     * @param cal_date 响应日期
     */
    public void setCal_date(String cal_date) {
        this.cal_date = cal_date;
    }

    /**
     * 实际利率的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getReal_rate() {
        return real_rate;
    }

    /**
     * 实际利率的setter方法
     *
     * @param real_rate 实际利率
     */
    public void setReal_rate(BigDecimal real_rate) {
        this.real_rate = real_rate;
    }
    /**
     * 在建期实际利率
     * @return
     */
    public BigDecimal getReal_rate_c() {
        return real_rate_c;
    }
    /**
     * 在建期实际利率
     * @param real_rate_c
     */
    public void setReal_rate_c(BigDecimal real_rate_c) {
        this.real_rate_c = real_rate_c;
    }

}