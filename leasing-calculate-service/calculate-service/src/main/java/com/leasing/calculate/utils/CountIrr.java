package com.leasing.calculate.utils;

import com.leasing.common.enums.arithmetic.Year_Days_Irr;
import com.leasing.common.enums.arithmetic.Year_Days_Value;
import com.leasing.common.enums.constant.ParamConst;
import com.leasing.common.exception.BaseException;
import com.leasing.common.utils.base.Days360;
import com.leasing.common.utils.base.UFDate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * 年IRR计算公式
 * @param cashFlowMap
 * @param irr_days  如果为空默认为使用365
 * @param day_value 如果为空默认为360
 * @return
 */
public class CountIrr {
    /**
     * 年IRR计算公式
     * @param cashFlowMap
     * @param irr_days  如果为空默认为使用365
     * @param day_value 如果为空默认为360
     * @return
     */
    public static BigDecimal countDayIrr(TreeMap<String, BigDecimal> cashFlowMap,
                                         Short irr_days, Short day_value) {
        if (irr_days == null) {
            irr_days = Year_Days_Irr.IRR_360.getShort();
        }
        if (day_value == null) {
            day_value = Year_Days_Value.VALUE_360.getShort();
        }
        TreeMap<Integer, BigDecimal> daysCashMap = convertMap(cashFlowMap, irr_days);// 转换后的MAP
        int maxKey = daysCashMap.lastKey();// 最大间隔
        // IRR计算步长，精确化步长，避免IRR计算时出现偏差
        double begin = 0;
        double end = 1;
//      double begin = -0.125;
//      double end = 0.125;
        int flag = 1;

        if (maxKey <= 32) {
            flag = 1;
        } else if (maxKey <= 64) {
            flag = 2;
        } else if (maxKey <= 128) {
            flag = 4;
        } else if (maxKey <= 256) {
            flag = 8;
        } else if (maxKey <= 512) {
            flag = 16;
        } else if (maxKey <= 1024) {
            flag = 32;
        } else if (maxKey <= 2048) {
            flag = 64;
        } else if (maxKey <= 4096) {
            flag = 128;
        } else if (maxKey <= 8192) {
            flag = 256;
        } else if (maxKey <= 16384) {
            flag = 512;
        } else {
            throw new BaseException("超出irr计算范围");
        }
        begin = begin / flag;
        end = end / flag;
        BigDecimal day_irr = countDayIrr(daysCashMap, begin, end);
        BigDecimal year_irr = BigDecimal.ZERO;
        if (day_value.intValue() == Year_Days_Value.VALUE_360.getShort().intValue()) {
            year_irr = day_irr.multiply(BigDecimal.valueOf(360)).setScale(ParamConst.CAL_DIAG, RoundingMode.HALF_EVEN);
        } else {
            year_irr = day_irr.multiply(BigDecimal.valueOf(365)).setScale(ParamConst.CAL_DIAG, RoundingMode.HALF_EVEN);
        }
        return year_irr;
    }

    /**
     *@des：计算日irr-计提用
     * @param cashFlowMap
     * @param irr_days
     * @param day_value
     * @return
     *@date 2014-10-1111:18:56
     *@author 田春勇
     */
    public static BigDecimal countDayIrr4accrual(TreeMap<String, BigDecimal> cashFlowMap,
                                                 Short irr_days, Short day_value) {
        if (irr_days == null) {
            irr_days = Year_Days_Irr.IRR_360.getShort();
        }
        if (day_value == null) {
            day_value = Year_Days_Value.VALUE_360.getShort();
        }
        TreeMap<Integer, BigDecimal> daysCashMap = convertMap(cashFlowMap, irr_days);// 转换后的MAP
        int maxKey = daysCashMap.lastKey();// 最大间隔
        // IRR计算步长，精确化步长，避免IRR计算时出现偏差
        double begin = 0;
        double end = 1;
//      double begin = -0.125;
//      double end = 0.125;
        int flag = 1;


        if (maxKey <= 32) {
            flag = 1;
        } else if (maxKey <= 64) {
            flag = 2;
        } else if (maxKey <= 128) {
            flag = 4;
        } else if (maxKey <= 256) {
            flag = 8;
        } else if (maxKey <= 512) {
            flag = 16;
        } else if (maxKey <= 1024) {
            flag = 32;
        } else if (maxKey <= 2048) {
            flag = 64;
        } else if (maxKey <= 4096) {
            flag = 128;
        } else if (maxKey <= 8192) {
            flag = 256;
        } else if (maxKey <= 16384) {
            flag = 512;
        } else {
            throw new BaseException("超出irr计算范围");
        }
        begin = begin / flag;
        end = end / flag;
        BigDecimal day_irr = countDayIrr(daysCashMap, begin, end);
        return day_irr;
    }


    /**
     * 期IRR计算，传出日期现金流
     * @param cashFlowMap
     */
    public static BigDecimal countTermIrr_date(TreeMap<String, BigDecimal> cashFlowMap) {
        TreeMap<Integer, BigDecimal> cashFlowMap_i =  new TreeMap<Integer, BigDecimal>();
        Integer leaseTime = 0;
        for (Iterator<String> it = cashFlowMap.keySet().iterator(); it.hasNext();) {
            cashFlowMap_i.put(leaseTime++, cashFlowMap.get(it.next()));
        }
        BigDecimal term_irr = countTermIrr(cashFlowMap_i);
        return term_irr;
    }
    /**
     * 期IRR计算公式
     *
     * @param cashFlowMap
     *            期IRR现金流封装
     * @return
     */
    public static BigDecimal countTermIrr(TreeMap<Integer, BigDecimal> cashFlowMap) {
        // IRR计算步长，精确化步长，避免IRR计算时出现偏差
        double begin = -0.25;
        double end = 0.25;
        BigDecimal term_irr = countDayIrr(cashFlowMap, begin, end);
        return term_irr;
    }

    /**
     * 日IRR计算过程
     * @param cashFlowMap <间隔天数,发生金额>
     * @param begin IRR可能開始值
     * @param end IRR可能結束值
     * @return
     */
    private static BigDecimal countDayIrr(TreeMap<Integer, BigDecimal> cashFlowMap,
                                          double begin, double end) {
        double IRR = 0;
        double IRR_S = begin;
        double IRR_E = end;
        double Cn = 0;
        double Cn_E = 0;
        while (IRR_E - IRR_S > 0.0000000000000001) { // 但步长差接近于0时就是IRR的真实值
            IRR = (IRR_S + IRR_E) / 2;
            Cn = countIRR(IRR, cashFlowMap);
            Cn_E = countIRR(IRR_E, cashFlowMap);
            if (Cn > 0) {
                if (Cn_E > 0) {
                    IRR_E = IRR_E - 0.000001;
                } else {
                    IRR_S = IRR;
                }
            } else {
                IRR_E = IRR;
            }
        }
        return BigDecimal.valueOf(IRR);
    }


    /**
     *@des：
     * @param flowcash
     * @param diffvalue
     * @return
     *@date 2014-10-1714:19:27
     *@author Administrator
     */
    public static BigDecimal calirr(BigDecimal flowcash,BigDecimal diffvalue) {

        BigDecimal  lastflow = new BigDecimal(200318986.6);
        TreeMap<String, BigDecimal> cashFlowMap = new TreeMap<String, BigDecimal>();
       /* 2032-9-21   -3561372.22
        2032-10-8   -200655538.9*/
        BigDecimal   currflowcash = flowcash.add(diffvalue);
        BigDecimal calflowcash = BigDecimal.ZERO;
        cashFlowMap.put("2032-6-30", currflowcash);
        cashFlowMap.put("2032-9-21", new BigDecimal(-3561372.22));
        cashFlowMap.put("2032-10-8", new BigDecimal(-200655538.9));

        BigDecimal dayirr = CountIrr.countDayIrr4accrual(cashFlowMap, Year_Days_Irr.IRR_365.getShort(), Year_Days_Irr.IRR_365.getShort());

        BigDecimal jt = lastflow.multiply( new BigDecimal(Math.pow(dayirr.add(BigDecimal.ONE).doubleValue(),1))).subtract(lastflow);
        calflowcash = lastflow.add(jt);
        if(currflowcash.subtract(calflowcash).abs().compareTo(new BigDecimal(String.valueOf(0.01)))>0){
            calirr(currflowcash,  diffvalue);
        }
        return dayirr;
    }

    /**
     * 将带发生日期的MAP转换成天数的MAP
     *
     * @param cashFlowMap
     * @param irr_days
     *            使用360转换还是365转换
     * @return
     */
    private static TreeMap<Integer, BigDecimal> convertMap(TreeMap<String, BigDecimal> cashFlowMap, Short irr_days) {
        TreeMap<Integer, BigDecimal> newMap = new TreeMap<Integer, BigDecimal>();
        String startDate = cashFlowMap.firstKey();// IRR计算的开始日期
        Integer days = Integer.valueOf(0);// 间隔天数
        BigDecimal cash = BigDecimal.ZERO;// 发现金额
        /**
         * 开始转换现金流格式
         */
        for (Iterator<String> it = cashFlowMap.keySet().iterator(); it.hasNext();) {
            String factDate = it.next();
            if (irr_days.intValue() == Year_Days_Irr.IRR_365.getShort().intValue()) {
                days = UFDate.getDaysBetween(new UFDate(startDate), new UFDate(factDate));
            } else {
                days = Days360.days360(startDate, factDate);
            }
            cash = cashFlowMap.get(factDate);
            newMap.put(days, cash);
        }
        return newMap;
    }

    /**
     * IRR底层计算公式
     * 1
     * @param IRR
     *            预计IRR
     * @param cashFlowMap
     *            现金流
     * @return 估计值（接近某值时，说明预计IRR就是真实IRR）
     */
    private static double countIRR(double IRR, TreeMap<Integer, BigDecimal> cashFlowMap) {
        double C0 = 0;//估计值
        // IRR公式
        for (Iterator<Integer> it = cashFlowMap.keySet().iterator(); it.hasNext();) {
            Integer days = it.next();
            double cash = cashFlowMap.get(days).doubleValue();
            C0 = C0 + cash / (Math.pow(1 + IRR, days.intValue()));
        }
        return C0;
    }
}