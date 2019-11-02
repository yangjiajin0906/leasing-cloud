package com.leasing.calculate.utils;

import com.leasing.calculate.entity.param.ArithmeticCoreDayParam;
import com.leasing.calculate.entity.param.ArithmeticCoreParam;
import com.leasing.common.enums.arithmetic.Lease_Cal_Method;
import com.leasing.common.enums.arithmetic.Payment_Frequency;
import com.leasing.common.enums.arithmetic.Year_Days;
import com.leasing.common.utils.base.UFDate;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @project:leasing-cloud 算法参数封装 工具类
 * @date:2019/10/25
 * @author:Yjj@yonyou.com
 * @description:
 **/
public class BaseAppUtils {

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
                        dayParamList.add(BaseAppVOUtil.getCoreDayParam(factDay, radio, dayRate, calDate, beginDate));
                    } else {
                        dayParamList.add(BaseAppVOUtil.getCoreDayParamNotNet(factDay, radio, dayRate, calDate, beginDate));
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
                    dayParamList.add(BaseAppVOUtil.getCoreDayParam(factDay, radio_1, dayRate, calDate, beginDate));
                    dayParamList.add(BaseAppVOUtil.getCoreDayParam(factDay_2, radio_2, dayRate, calDate_2, beginDate));
                }else{
                    dayParamList.add(BaseAppVOUtil.getCoreDayParamNotNet(factDay, radio_1, dayRate, calDate, beginDate));
                    dayParamList.add(BaseAppVOUtil.getCoreDayParamNotNet(factDay_2, radio_2, dayRate, calDate_2, beginDate));
                }


                beginDate = calDate;
                beginDate = calDate_2;
                continue;
            }
            // 其他支付频率
            // 不规则测算时 不计算净现值系数(使用效率修改)
            if (lease_cal_method.intValue() != Lease_Cal_Method.IRREGULAR_RENT.getShort().intValue()
                    && lease_cal_method.intValue() != Lease_Cal_Method.IRREGULAR_CORPUS.getShort().intValue()) {
                dayParamList.add(BaseAppVOUtil.getCoreDayParam(factDay, radio, dayRate, calDate, beginDate));
            } else {
                dayParamList.add(BaseAppVOUtil.getCoreDayParamNotNet(factDay, radio, dayRate, calDate, beginDate));
            }
            beginDate = calDate;
        }
        return dayParamList;
    }

}