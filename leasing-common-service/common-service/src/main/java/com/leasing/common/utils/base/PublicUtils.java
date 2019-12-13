package com.leasing.common.utils.base;

/**
 * @project:leasing-cloud
 * @date:2019/12/11
 * @author:wangjc@yonyou.com
 * @description: 公共计算接口
 **/

import com.leasing.common.entity.calculate.vo.cal.ArithmeticCoreDayParam;
import com.leasing.common.enums.arithmetic.Year_Days_Irr;
import com.leasing.common.enums.constant.ParamValueConstant;
import com.leasing.common.enums.constant.PubEnumsConstant;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * 公用类
 *
 */
public class PublicUtils {
    /**
     * 日复利，利息计算
     *
     * @param dayParam
     * @param diag
     * @return
     */
    public static BigDecimal getTermInterestAmount(ArithmeticCoreDayParam dayParam, BigDecimal balanceAmount, int diag,
                                                   Short irr_days, String puttingDate) {
        // 每期利息
        BigDecimal termInterest = BigDecimal.ZERO;
        int TermDay = 0;
        if (irr_days.intValue() == Year_Days_Irr.IRR_365.getShort().intValue()) {
            TermDay = UFDate.getDaysBetween(UFDate.getDate(dayParam.getBegin_date()),
                    UFDate.getDate(dayParam.getCal_date()));
        } else {
            // 为了解决 days360 存在2月28时 的问题
            int beginNum = Days360.days360(puttingDate, dayParam.getBegin_date());
            int calNum = Days360.days360(puttingDate, dayParam.getCal_date());
            TermDay = calNum - beginNum;
        }
        for (int i = 0; i < TermDay; i++) {
            BigDecimal comoon = (BigDecimal.ONE.add(dayParam.getRate_day())).pow(i);
            BigDecimal dayInterest = balanceAmount.multiply(dayParam.getRate_day()).multiply(comoon);
            termInterest = termInterest.add(dayInterest);
        }
        return termInterest.setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * 枚举型的年化天数转化成实际天数
     * @param enums
     * author:田春勇
     * @return
     */
    public static int getYeardays(Short enums) {
        int yeardays = 0;
        if (PubEnumsConstant.CALDAY_360.compareTo(enums) == 0) {
            yeardays = ParamValueConstant.DAYS_360;
        } else {
            yeardays = ParamValueConstant.DAYS_365;
        }

        return yeardays;
    }

}