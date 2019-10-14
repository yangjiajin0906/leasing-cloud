package com.leasing.calculate.vo;

import com.leasing.calculate.Enum.Direction;
import com.leasing.calculate.Enum.TradeType;
import com.leasing.calculate.utils.BaseApp;
import com.leasing.calculate.utils.UFDate;

import java.math.BigDecimal;
import java.util.List;

/**
 * @project:leasing-cloud vo基本封装类
 * @date:2019/10/11
 * @author:Yjj@yonyou.com
 * @description:
 **/
public class BaseAppVO {
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
     * 封装租金计划
     *
     * @param calList
     *            收租计划列表
     * @param resultList
     *            接受收租计划
     * @param plan2operating_date
     *            转经营期日期
     * @param term
     *            开始期次
     * @param map
     *            预留收租时间
     * @return
     */
    public static String getResultRentList(List<CalArithmeticVO> calList, List<LeasePlanVO> resultList,
                                           String plan2operating_date, int term, Short paymentFrequency) {
        String tempOperateDate = null;
        for (int i = 0; i < calList.size(); i++) {
            CalArithmeticVO vo = calList.get(i);
            LeasePlanVO varVO = new LeasePlanVO();
            varVO.setTax_rate(vo.getTax_rate());
            varVO.setLease_time((++term) + "");
            varVO.setCal_date(vo.getCal_date());
            if (plan2operating_date != null) {// 默认转经营期日期为小的
                int temp = UFDate.getDaysBetween(UFDate.getDate(plan2operating_date), UFDate.getDate(vo.getCal_date()));
                if (temp > 0 && i >= 1) {
                    int tempFirst = UFDate.getDaysBetween(UFDate.getDate(((CalArithmeticVO) calList.get(i - 1))
                            .getCal_date()), UFDate.getDate(plan2operating_date));
                    if (temp > tempFirst) {
                        tempOperateDate = ((CalArithmeticVO) calList.get(i - 1)).getCal_date();
                        break;
                    }
                }
            }
            varVO.setPlan_date(varVO.getCal_date());
            varVO.setTrans_type(TradeType.TRADETYPE_RENT);
            varVO.setDirection(Direction.INCOME.getShort());
            varVO.setLease_cash(vo.getLease_cash());
            varVO.setLease_corpus(vo.getLease_corpus());
            varVO.setLease_interest(vo.getLease_interest());
            varVO.setCorpus_balance(vo.getCorpus_balance());

            varVO.setLease_cash_fin(vo.getLease_cash_fin());
            varVO.setLease_corpus_fin(vo.getLease_corpus_fin());
            varVO.setLease_interest_fin(vo.getLease_interest_fin());
            varVO.setCorpus_balance_fin(vo.getCorpus_balance_fin());

            varVO.setRateValue(vo.getRateValue());
            varVO.setNewInterrateFlag(true);
            varVO.setPaymentFrequency(paymentFrequency);
            resultList.add(varVO);
            if (plan2operating_date != null) {// 默认转经营期日期为大的
                int temp = UFDate.getDaysBetween(UFDate.getDate(plan2operating_date), UFDate.getDate(vo.getCal_date()));
                if (temp >= 0 && i >= 1) {
                    int tempFirst = UFDate.getDaysBetween(UFDate.getDate(((CalArithmeticVO) calList.get(i - 1))
                            .getCal_date()), UFDate.getDate(plan2operating_date));
                    if (temp <= tempFirst) {
                        tempOperateDate = vo.getCal_date();
                        break;
                    }
                }
            }
            if (plan2operating_date != null) {// 处理i=0就是转经营期的情况
                if (plan2operating_date.compareTo(vo.getCal_date()) == 0) {
                    tempOperateDate = vo.getCal_date();
                    break;
                }
            }
        }
        return tempOperateDate;
    }

    /**
     * 除租金收支计划外处理
     *
     * @param calDate-计算日期
     * @param planDate -
     *            计划日期
     * @param taxMode
     * @param taxRate
     * @param tradeType-交易类别
     * @param direction-收支类别
     * @param planCash-发生金额
     * @param term-对应期次
     */
    public static LeasePlanVO otherPlan(String calDate,String planDate ,String tradeType, Short direction,BigDecimal planCash, String term, Short taxRate, Short taxMode) {
        LeasePlanVO vatVO = new LeasePlanVO();
        vatVO.setLease_time(term);
        vatVO.setCal_date(calDate);
        vatVO.setPlan_date(planDate);
        vatVO.setTrans_type(tradeType);
        vatVO.setDirection(direction);
        vatVO.setLease_cash(planCash);
        /** ADD WJJ 20160805 投放计划、保证金计划、手续费计划、中间费计划、其他支出计划 税种空问题*/
        vatVO.setTax_mode(taxMode);
        vatVO.setTax_rate(taxRate);
        /** ADD END */
        vatVO.setLease_corpus(BigDecimal.ZERO);
        vatVO.setLease_interest(BigDecimal.ZERO);
        vatVO.setCorpus_balance(BigDecimal.ZERO);
        vatVO.setLease_cash_fin(planCash);
        vatVO.setLease_corpus_fin(BigDecimal.ZERO);
        vatVO.setLease_interest_fin(BigDecimal.ZERO);
        vatVO.setCorpus_balance_fin(BigDecimal.ZERO);

        return vatVO;
    }

    /**
     * 除租金收支计划外处理
     *
     * @param calDate-计算日期
     * @param planDate -
     *            计划日期
     * @param tradeType-交易类别
     * @param direction-收支类别
     * @param planCash-发生金额
     * @param term-对应期次
     */
    public static LeasePlanVO otherPlan(String rightDate ,String calDate,String planDate ,String tradeType, Short direction,BigDecimal planCash, String term) {
        LeasePlanVO vatVO = new LeasePlanVO();
        vatVO.setLease_time(term);
        vatVO.setCal_date(calDate);
        vatVO.setPlan_date(planDate);
        vatVO.setTrans_type(tradeType);
        vatVO.setDirection(direction);
        vatVO.setLease_cash(planCash);
        vatVO.setLease_corpus(BigDecimal.ZERO);
        vatVO.setLease_interest(BigDecimal.ZERO);
        vatVO.setCorpus_balance(BigDecimal.ZERO);
        vatVO.setLease_cash_fin(planCash);
        vatVO.setLease_corpus_fin(BigDecimal.ZERO);
        vatVO.setLease_interest_fin(BigDecimal.ZERO);
        vatVO.setCorpus_balance_fin(BigDecimal.ZERO);
        vatVO.setRight_date(rightDate);
        return vatVO;
    }

    /**
     * 收支子表时间填充
     *
     * @param resultList
     *            结果集
     * @param otherList
     *            其他收支子表
     * @return
     */
    public static String writeCalPlanDate(List<LeasePlanVO> resultList, List<LeasePlanVO> otherList) {
        String valid = null;
        for (int i = 0; i < otherList.size(); i++) {
            LeasePlanVO srvVO = otherList.get(i);
            srvVO.setCal_date(null);
            srvVO.setPlan_date(null);
            for (int j = 0; j < resultList.size(); j++) {
                LeasePlanVO leaseVO = resultList.get(j);
                if (srvVO.getLease_time().equals(leaseVO.getLease_time())) {
                    srvVO.setCal_date(leaseVO.getCal_date());
                    srvVO.setPlan_date(leaseVO.getPlan_date());
                    break;
                }
                if (j == resultList.size() - 1) {
                    valid = srvVO.getLease_time();
                }
            }
            if (srvVO.getCal_date() == null) {
                valid = srvVO.getLease_time();
            }
        }
        return valid;
    }
}