package com.leasing.calculate.utils;

import com.leasing.common.entity.calculate.vo.cal.ArithmeticCoreDayParam;
import com.leasing.common.entity.calculate.vo.cal.ArithmeticCoreParam;
import com.leasing.common.entity.calculate.vo.cal.CalArithmeticVO;
import com.leasing.common.entity.calculate.vo.base.LeaseLoanPlanVO;
import com.leasing.common.enums.arithmetic.Lease_Cal_Method;
import com.leasing.common.enums.arithmetic.Payment_Frequency;
import com.leasing.common.enums.arithmetic.Year_Days;
import com.leasing.common.enums.base.Direction;
import com.leasing.common.utils.base.UFDate;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @project:leasing-cloud 算法参数封装 工具类
 * @date:2019/10/25
 * @author:Yjj@yonyou.com
 * @description:
 **/
public class BaseApp {

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
     * 日复利参数封装
     *
     * @param arithmeticParm
     *            核心测算实体
     * @return
     */
    public static List<ArithmeticCoreDayParam> getDayParam(ArithmeticCoreParam arithmeticParm) {
        List<ArithmeticCoreDayParam> dayParamList = new ArrayList<ArithmeticCoreDayParam>();
        List<String> calDateList = arithmeticParm.getCalDateList();
        int days = 360;
        if(arithmeticParm.getYear_days().intValue() == Year_Days.YEAR_365.getShort().intValue()) {
            days = 365;
        }
        //日利率
        BigDecimal dayRate = arithmeticParm.getYearRate().divide(BigDecimal.valueOf(days), MathContext.DECIMAL64);
        Short payment_frequency = arithmeticParm.getPayment_frequency();
        String puttingDate = arithmeticParm.getPuttingDate();
        String beginDate = puttingDate;
        // 每期所占比例，只有支付频率为半年，每期所占比例才会不一致
        BigDecimal radio_hyear = arithmeticParm.getRadio_hyear();
        // 每期所占的比例
        BigDecimal term_radio = BigDecimal.ONE.divide(BigDecimal.valueOf(calDateList.size()), MathContext.DECIMAL64);
        // 计算方式
        Short lease_cal_method = arithmeticParm.getLease_cal_method();
        for (int i = 1; i <= calDateList.size(); i++) {
            String calDate = calDateList.get(i - 1);
            BigDecimal radio = term_radio;
            int factDay = UFDate.getDaysBetween(UFDate.getDate(puttingDate), UFDate.getDate(calDate));
            //TODO 聚信算法需要 需要加运行参数目前展示注释掉 等新文添加
            // 半年特殊处理，一年有两期收租才会特殊处理
            // arithmeticParm.getIsAllRentSpe()==null || !arithmeticParm.getIsAllRentSpe()
            // 全为指定租金时调用不规则租金发重算时不走此段代码
            if (payment_frequency.intValue() == Payment_Frequency.HALF_YEAR.getShort().intValue()
                    && (arithmeticParm.getIsAllRentSpe()==null || !arithmeticParm.getIsAllRentSpe())) {
                if (((i == 1 && UFDate.getDate(calDate).getMonth() > 6) || (i == calDateList.size()))) {
                    // 不规则测算时 不计算净现值系数(使用效率修改)
                    if (lease_cal_method.intValue() != Lease_Cal_Method.IRREGULAR_RENT.getShort().intValue()
                            && lease_cal_method.intValue() != Lease_Cal_Method.IRREGULAR_CORPUS.getShort().intValue()) {
                        dayParamList.add(BaseAppVO.getCoreDayParam(factDay, radio, dayRate, calDate, beginDate));
                    } else {
                        dayParamList.add(BaseAppVO.getCoreDayParamNotNet(factDay, radio, dayRate, calDate, beginDate));
                    }
                    beginDate = calDate;
                    continue;
                }
                // 正常是两个一起计算
                String calDate_2 = calDateList.get(i++);
                int factDay_2 = UFDate.getDaysBetween(UFDate.getDate(puttingDate), UFDate.getDate(calDate_2));
                radio = radio.multiply(BigDecimal.valueOf(2));
                BigDecimal radio_1 = radio.multiply(radio_hyear);
                BigDecimal radio_2 = radio.subtract(radio_1);
                // 不规则测算时 不计算净现值系数(使用效率修改)
                if(lease_cal_method.intValue() != Lease_Cal_Method.IRREGULAR_RENT.getShort().intValue()
                        && lease_cal_method.intValue() != Lease_Cal_Method.IRREGULAR_CORPUS.getShort().intValue()){
                    dayParamList.add(BaseAppVO.getCoreDayParam(factDay, radio_1, dayRate, calDate, beginDate));
                    dayParamList.add(BaseAppVO.getCoreDayParam(factDay_2, radio_2, dayRate, calDate_2, beginDate));
                }else{
                    dayParamList.add(BaseAppVO.getCoreDayParamNotNet(factDay, radio_1, dayRate, calDate, beginDate));
                    dayParamList.add(BaseAppVO.getCoreDayParamNotNet(factDay_2, radio_2, dayRate, calDate_2, beginDate));
                }


                beginDate = calDate;
                beginDate = calDate_2;
                continue;
            }
            // 其他支付频率
            // 不规则测算时 不计算净现值系数(使用效率修改)
            if (lease_cal_method.intValue() != Lease_Cal_Method.IRREGULAR_RENT.getShort().intValue()
                    && lease_cal_method.intValue() != Lease_Cal_Method.IRREGULAR_CORPUS.getShort().intValue()) {
                dayParamList.add(BaseAppVO.getCoreDayParam(factDay, radio, dayRate, calDate, beginDate));
            } else {
                dayParamList.add(BaseAppVO.getCoreDayParamNotNet(factDay, radio, dayRate, calDate, beginDate));
            }
            beginDate = calDate;
        }
        return dayParamList;
    }

    /**
     * 封装日现金流
     *
     * @param list
     * @param puttingDate
     * @param puttingAmount
     * @param arithme
     * @return
     */
    public static TreeMap<String, BigDecimal> getDayFlowMap(List<CalArithmeticVO> list, String puttingDate,
                                                            BigDecimal puttingAmount, ArithmeticCoreParam arithme) {
        TreeMap<String, BigDecimal> dateFlowMap = new TreeMap<String, BigDecimal>();
        // 加入投放支出现金流
        dateFlowMap.put(puttingDate, puttingAmount.negate());
        List loanPlanList = arithme.getLease_loan_plan();
        if(loanPlanList!=null&&loanPlanList.size()>0){
            for(int i=0;i<loanPlanList.size();i++){
                LeaseLoanPlanVO loanPlanVO = (LeaseLoanPlanVO) loanPlanList.get(i);
                if(!UFDate.getDate(loanPlanVO.getPlan_date()).before(UFDate.getDate(puttingDate))){
                    dateFlowMap.put(loanPlanVO.getPlan_date(),loanPlanVO.getPlan_cash().negate());
                }
            }
        }
        for (CalArithmeticVO vo : list) {
            BigDecimal addValue = vo.getLease_cash();
            // 支出为负
            if (vo.getDirection().intValue() == Direction.PAY.getShort().intValue()) {
                addValue = addValue.negate();
            }
            if (dateFlowMap.containsKey(vo.getCal_date())) {
                BigDecimal initValue = dateFlowMap.get(vo.getCal_date());
                BigDecimal resultValue = initValue.add(addValue);
                dateFlowMap.put(vo.getCal_date(), resultValue);
            } else {
                dateFlowMap.put(vo.getCal_date(), addValue);
            }
        }
        return dateFlowMap;
    }

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
     * 封装日现金流
     *
     * @param list
     *            收支计划
     * @param puttingDate
     *            投放日期
     * @param puttingAmount
     *            投放金额
     * @return
     */
    public static TreeMap<String, BigDecimal> getDayFlowMap(List<CalArithmeticVO> list, String puttingDate,
                                                            BigDecimal puttingAmount) {
        TreeMap<String, BigDecimal> dateFlowMap = new TreeMap<String, BigDecimal>();
        // 加入投放支出现金流
        dateFlowMap.put(puttingDate, puttingAmount.negate());
        for (CalArithmeticVO vo : list) {
            BigDecimal addValue = vo.getLease_cash();
            // 支出为负
            if (vo.getDirection().intValue() == Direction.PAY.getShort().intValue()) {
                addValue = addValue.negate();
            }
            if (dateFlowMap.containsKey(vo.getCal_date())) {
                BigDecimal initValue = dateFlowMap.get(vo.getCal_date());
                BigDecimal resultValue = initValue.add(addValue);
                dateFlowMap.put(vo.getCal_date(), resultValue);
            } else {
                dateFlowMap.put(vo.getCal_date(), addValue);
            }
        }
        return dateFlowMap;
    }


}