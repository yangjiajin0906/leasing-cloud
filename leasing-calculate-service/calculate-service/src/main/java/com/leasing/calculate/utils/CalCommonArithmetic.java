package com.leasing.calculate.utils;

import com.leasing.calculate.Enum.*;
import com.leasing.calculate.Exception.BusinessException;
import com.leasing.calculate.entity.LeaseLoanPlanVO;
import com.leasing.calculate.vo.ArithmeticCoreDayParam;
import com.leasing.calculate.vo.ArithmeticCoreParam;
import com.leasing.calculate.vo.CalArithmeticVO;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * @project:leasing-cloud 核心算法封装类
 * @date:2019/10/11
 * @author:Yjj@yonyou.com
 * @description:
 **/
public class CalCommonArithmetic {
    /**
     * 等额租金--日复利
     *
     * 按照天计算利息
     *
     * 本金 = 租金 - 利息
     *
     * @param arithmeticParm
     * @return
     */
    public static List<CalArithmeticVO> getRentDayEQPlan(ArithmeticCoreParam arithmeticParm) {
        List<CalArithmeticVO> list = new ArrayList<CalArithmeticVO>();
        Short prepay_or_not = arithmeticParm.getPrepay_or_not(); //先付后付
        int diag = arithmeticParm.getCal_digit();//计算精度
        Integer term = arithmeticParm.getTerm();// 期数
        BigDecimal puttingAmount = arithmeticParm.getPuttingAmount();// 投放金额
        String puttingDate =  arithmeticParm.getPuttingDate();//投放日期
        List<ArithmeticCoreDayParam> dayParamList = BaseApp.getDayParam(arithmeticParm); //日复利参数封装
        List<ArithmeticCoreDayParam> caldayParamList = new ArrayList<ArithmeticCoreDayParam>(dayParamList);;
        String termBeginDate ="";
        String termEndDate ="";
        LeaseLoanPlanVO leaseLoanPlanVO = null;
        LeaseLoanPlanVO oldleaseLoanPlanVO = null;
        LeaseLoanPlanVO calLeaseLoanPlanVO = null;//用于计算租期之内的投放金额总和
        BigDecimal oldbalanceAmount = BigDecimal.ZERO;//投放本金之和
        Boolean breakFalg = false;
        Boolean calCashAgainFalg = false;//是否重算过租金
        BigDecimal termInterest =BigDecimal.ZERO;
        BigDecimal termCash =BigDecimal.ZERO;//每期租金
        List loanPlanList = arithmeticParm.getLease_loan_plan();//投放计划
        // 租金计算
        getTermRentAmount(dayParamList, puttingAmount);
        BigDecimal balanceAmount = puttingAmount;// 剩余本金
        for (int i = 1; i <= dayParamList.size() && i <= term; i++) {
            ArithmeticCoreDayParam dayParam = dayParamList.get(i - 1);
            if(i>1){
                caldayParamList.remove(0);
            }
            CalArithmeticVO vo = new CalArithmeticVO();

            if(i==1){
                termBeginDate = arithmeticParm.getLastDay();
                termEndDate = dayParam.getCal_date();
            }else{
                termBeginDate = dayParamList.get(i - 2).getCal_date();
                termEndDate = dayParamList.get(i - 1).getCal_date();
            }
            termInterest = getTermInterestAmount(dayParam, balanceAmount, diag,arithmeticParm.getIrr_days(),arithmeticParm.getDate_interest(),puttingDate).setScale(diag, RoundingMode.HALF_UP);
            //判断此租期内是否存在投放计划，若存在，则剩余本金 = 剩余本金+投放金额
            if(loanPlanList!=null){
                for(int j=0;j<loanPlanList.size();j++){
                    leaseLoanPlanVO = (LeaseLoanPlanVO) loanPlanList.get(j);
                    //若在此租期内存在投放计划
                    if((UFDate.getDate(leaseLoanPlanVO.getPlan_date()).after(UFDate.getDate(termBeginDate))
                            ||UFDate.getDate(leaseLoanPlanVO.getPlan_date()).equals(UFDate.getDate(termBeginDate)))
                            &&UFDate.getDate(leaseLoanPlanVO.getPlan_date()).before(UFDate.getDate(termEndDate))){
                        //若此次投放计划计息金额计算方式不是‘无’
                        if(leaseLoanPlanVO.getCalinterest_amount_style().compareTo(PubEnumsConstant.CALINTEREST_STLYE_TWO)!=0){
                            if(leaseLoanPlanVO.getCalinterest_amount_style().compareTo(PubEnumsConstant.CALINTEREST_STLYE_ZERO)==0){
                                for(int k =0;k<loanPlanList.size();k++){
                                    calLeaseLoanPlanVO =(LeaseLoanPlanVO) loanPlanList.get(k);
                                    oldbalanceAmount =oldbalanceAmount.add(calLeaseLoanPlanVO.getPlan_cash());
                                }
                                balanceAmount = balanceAmount.add(oldbalanceAmount);
                                getTermRentAmount(caldayParamList, balanceAmount);
                                calCashAgainFalg = true;
                                termInterest = getTermInterestAmount(dayParam, balanceAmount, diag,arithmeticParm.getIrr_days(),arithmeticParm.getDate_interest(),puttingDate).setScale(diag, RoundingMode.HALF_UP);
                                break;
                            }else{//按本次投放金额计息
                                for(int m=0;m<j;m++){
                                    oldleaseLoanPlanVO =(LeaseLoanPlanVO) loanPlanList.get(m);
                                    if(oldleaseLoanPlanVO.getCalinterest_amount_style().compareTo(PubEnumsConstant.CALINTEREST_STLYE_ZERO)==0){
                                        breakFalg =true;
                                        break;
                                    }
                                }
                                if(breakFalg){
                                    break;
                                }
                                BigDecimal timeCash =BigDecimal.ZERO;
                                BigDecimal tempBalance = BigDecimal.ZERO;//临时剩余本金，用于计算多次投放之间的分段利息
                                for(int n= j;n<loanPlanList.size();n++){
                                    calLeaseLoanPlanVO =(LeaseLoanPlanVO) loanPlanList.get(n);
                                    if((UFDate.getDate(calLeaseLoanPlanVO.getPlan_date()).after(UFDate.getDate(termBeginDate))
                                            ||UFDate.getDate(calLeaseLoanPlanVO.getPlan_date()).equals(UFDate.getDate(termBeginDate)))
                                            &&UFDate.getDate(calLeaseLoanPlanVO.getPlan_date()).before(UFDate.getDate(termEndDate))){
                                        dayParam.setCal_date(calLeaseLoanPlanVO.getPlan_date());
                                        dayParam.setBegin_date(termBeginDate);
                                        termBeginDate = calLeaseLoanPlanVO.getPlan_date();
                                        //计算本期开始到本次投放之间的利息
                                        BigDecimal tempCash = getTermInterestAmount(dayParam, balanceAmount, diag,arithmeticParm.getIrr_days(),arithmeticParm.getDate_interest(),puttingDate);
                                        timeCash = timeCash.add(tempCash);
                                        tempBalance = balanceAmount;
                                        tempBalance = tempBalance.add(tempCash);
                                        oldbalanceAmount = BigDecimal.ZERO;
                                        oldbalanceAmount = oldbalanceAmount.add(calLeaseLoanPlanVO.getPlan_cash());
                                        balanceAmount = balanceAmount.add(oldbalanceAmount);
                                        tempBalance = tempBalance.add(oldbalanceAmount);
                                        dayParam.setCal_date(termEndDate);
                                        dayParam.setBegin_date(calLeaseLoanPlanVO.getPlan_date());
                                        getTermRentAmount(caldayParamList, balanceAmount);
                                        calCashAgainFalg = true;

                                    }
                                }
                                BigDecimal timeCash2 =getTermInterestAmount(dayParam, tempBalance, diag,arithmeticParm.getIrr_days(),arithmeticParm.getDate_interest(),puttingDate);
                                termInterest = timeCash.add(timeCash2);
                                break;
                            }
                        }else{//‘无’

                        }
                    }
                }
            }
            vo.setLease_interest(termInterest);
            // 处理先付项目，第一期利息为0
            if (i == 1 && prepay_or_not.intValue() == Prepay_Or_Not.PREPAY.getShort().intValue()) {
                vo.setLease_interest(BigDecimal.ZERO);
            }
            vo.setCal_date(dayParam.getCal_date());
            vo.setPlan_date(dayParam.getCal_date());
            if(calCashAgainFalg){
                vo.setLease_cash(caldayParamList.get(0).getRent_amount().setScale(diag, RoundingMode.HALF_UP));
            }else{
                vo.setLease_cash(dayParam.getRent_amount().setScale(diag, RoundingMode.HALF_UP));

            }
            vo.setLease_corpus(vo.getLease_cash().subtract(vo.getLease_interest()));
            balanceAmount = balanceAmount.subtract(vo.getLease_corpus());
            vo.setCorpus_balance(balanceAmount);
            vo.setDirection(Direction.INCOME.getShort());
            list.add(vo);
        }
//        if(arithmeticParm.getRentList() == null) {
//            arithmeticParm.setRentList(list);
//        } else {
//            arithmeticParm.getRentList().addAll(list);
//        }
//        //财务表
//        arithmeticParm.setRentListFin(getIrregularRentAccount(arithmeticParm));
        return list;
    }

    /**
     * 日复息租金计算
     *
     * @param paramList
     * @param PuttingAmount
     */
    public static void getTermRentAmount(List<ArithmeticCoreDayParam> paramList, BigDecimal puttingAmount) {
        // 净现值系数之和
        BigDecimal sumNetRadio = BigDecimal.ZERO;
        for (ArithmeticCoreDayParam dayParam : paramList) {
            sumNetRadio = sumNetRadio.add(dayParam.getNet_radio());
        }
        // 总租金
        BigDecimal sumRentAmount = puttingAmount.divide(sumNetRadio, MathContext.DECIMAL64);
        // 每期租金开始计算
        for (ArithmeticCoreDayParam dayParam : paramList) {
            dayParam.setRent_amount(sumRentAmount.multiply(dayParam.getRadio(), MathContext.DECIMAL64));
        }
    }

    /**
     * 日复利，利息计算
     *
     * @param dayParam
     * @param balanceAmout
     * @param diag
     * @param truncationTime 舍位时点
     * @return
     */
    public static BigDecimal getTermInterestAmount(ArithmeticCoreDayParam dayParam, BigDecimal balanceAmount, int diag,Short irr_days,Boolean truncationTime , String puttingDate ) {
        // 每期利息
        BigDecimal termInterest = BigDecimal.ZERO;
        int TermDay = UFDate.getDaysBetween(UFDate.getDate(dayParam.getBegin_date()), UFDate.getDate(dayParam.getCal_date()));
        if(irr_days != null && irr_days.intValue() == Year_Days_Irr.IRR_360.getShort().intValue()){
            // 为了解决 days360 存在2月28时 的问题
            int beginNum = Days360.days360(puttingDate,dayParam.getBegin_date());
            int calNum = Days360.days360(puttingDate,dayParam.getCal_date());
            TermDay = calNum - beginNum;
        }
        for (int i = 0; i < TermDay; i++) {
            BigDecimal comoon = (BigDecimal.ONE.add(dayParam.getRate_day())).pow(i);
            BigDecimal dayInterest = balanceAmount.multiply(dayParam.getRate_day()).multiply(comoon);
            if(truncationTime){
                dayInterest = dayInterest.setScale(diag,RoundingMode.HALF_UP);
            }
            termInterest = termInterest.add(dayInterest);
        }
        if(truncationTime){
            return termInterest;
        } else {
            return termInterest.setScale(diag,RoundingMode.HALF_UP);
        }
    }

    /**
     * 等额本金，本金不变， 租金 = 利息+本金 日复息
     */
    public static List<CalArithmeticVO> getDayPrincipalEQPlan(ArithmeticCoreParam arithmeticParm) {
        List<CalArithmeticVO> list = new ArrayList<CalArithmeticVO>();
        List<String> calDateList = arithmeticParm.getCalDateList();
        int diag = arithmeticParm.getCal_digit();
        Integer term = arithmeticParm.getTerm();// 期数
        Short prepay_or_not = arithmeticParm.getPrepay_or_not();
        BigDecimal puttingAmount = arithmeticParm.getPuttingAmount();// 投放金额
        BigDecimal assets_margin = BigDecimalUtils.defaultIfNull(arithmeticParm.getAssets_margin());
        BigDecimal assets_temp = assets_margin;
        // 每期本金
        BigDecimal termPrincipalAmount = (puttingAmount.subtract(assets_temp)).divide(
                BigDecimal.valueOf(calDateList.size()), MathContext.DECIMAL64).setScale(diag, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(2));
        BigDecimal balanceAmount = puttingAmount;// 剩余本金
        // update 2013-06-22 rover
        int year_days = 360;
        if(arithmeticParm.getYear_days().intValue() == Year_Days.YEAR_365.getShort().intValue()) {
            year_days = 365;
        }
        BigDecimal dayRate  = arithmeticParm.getYearRate().divide(BigDecimal.valueOf(year_days),  MathContext.DECIMAL64);
        UFDate beginDate = UFDate.getDate(arithmeticParm.getPuttingDate());
        UFDate endDate = null;
        List<ArithmeticCoreDayParam> dayParamList = BaseApp.getDayPriParam(arithmeticParm);
        //期次累计
        int lease_time = 0;
        if(arithmeticParm.getRentList() != null) {
            lease_time = arithmeticParm.getRentList().size();
        }
        for(int i = 1; i <= calDateList.size() && i <= term; i++) {
            String calDate = calDateList.get(i-1);
            endDate = UFDate.getDate(calDate);
            int days = UFDate.getDaysBetween(beginDate, endDate);
            if(arithmeticParm.getIrr_days().intValue() == Year_Days_Irr.IRR_360.getShort().intValue()) {
                days = Days360.days360(beginDate.toString(), endDate.toString());
            }
            CalArithmeticVO vo = new CalArithmeticVO();
            vo.setLease_time(i+lease_time);
            vo.setCal_date(calDateList.get(i - 1));
            vo.setPlan_date(calDateList.get(i - 1));
            BigDecimal dayInterest = BigDecimal.ZERO;
            if(arithmeticParm.getDate_interest()){
                dayInterest = balanceAmount.multiply(dayRate).setScale(diag,RoundingMode.HALF_UP);
            } else {
                dayInterest = balanceAmount.multiply(dayRate);
            }
            vo.setLease_interest(dayInterest.multiply(BigDecimal.valueOf(days)).setScale(diag, RoundingMode.HALF_UP));
            if (i == 1 && prepay_or_not.intValue() == Prepay_Or_Not.PREPAY.getShort().intValue()) {
                vo.setLease_interest(BigDecimal.ZERO);
            }
            vo.setLease_corpus(termPrincipalAmount.multiply(dayParamList.get(i-1).getRadio()).setScale(diag, RoundingMode.HALF_UP));
            vo.setLease_cash(vo.getLease_corpus().add(vo.getLease_interest()));
            balanceAmount = balanceAmount.subtract(vo.getLease_corpus());
            vo.setCorpus_balance(balanceAmount);
            vo.setDirection(Direction.INCOME.getShort());
            list.add(vo);
            beginDate = endDate;
        }
//        if(arithmeticParm.getRentList() == null) {
//            arithmeticParm.setRentList(list);
//        } else {
//            arithmeticParm.getRentList().addAll(list);
//        }
//        //财务表
//        arithmeticParm.setRentListFin(getIrregularCorpusAccount(arithmeticParm));
        return list;
    }

    /**
     * 等额租金--平息法 财务表
     *
     * 租金不变
     *
     * 利息根据内部收益率计算
     *
     * 本金 = 租金 -利息
     *
     * @param arithmeticParm
     * @return
     */
    public static List<CalArithmeticVO> getRentFixEQPlan(ArithmeticCoreParam arithmeticParm) {
        List<CalArithmeticVO> list = arithmeticParm.getRentList();
        String putting_date = arithmeticParm.getPuttingDate();
        Short payment_frequency = arithmeticParm.getPayment_frequency();
        Short prepay_or_not = arithmeticParm.getPrepay_or_not();
        Short year_days = arithmeticParm.getYear_days();
//        Short fix_method = arithmeticParm.getFix_method();
        int diag = arithmeticParm.getCal_digit();
        Integer term = arithmeticParm.getTerm();// 期数
        BigDecimal puttingAmount = arithmeticParm.getPuttingAmount();// 投放金额
        BigDecimal tradeDiscount = arithmeticParm.getTradeDiscount();// 商业折扣
        puttingAmount = puttingAmount.subtract(tradeDiscount);
        // 租金IRR计算，用来计算利息
        BigDecimal termRate = BigDecimal.ZERO;
        BigDecimal yearRate = BigDecimal.ZERO;
//        if (fix_method.intValue() == Fix_Method.DAYRATE.getShort().intValue()) {
        yearRate = CountIrr.countDayIrr(BaseApp.getDayFlowMap(list, putting_date, puttingAmount),arithmeticParm.getIrr_days(),arithmeticParm.getDay_value());
        termRate = getTermRate(year_days, yearRate, payment_frequency);
//        } else {
//            termRate = CountIrr.countTermIrr(BaseApp.getTermFlowMap(list, puttingAmount));
//            yearRate = termRate.multiply(BigDecimal.valueOf(BaseApp.getBaseFrequency(payment_frequency)));
//        }
        BigDecimal balanceAmount = puttingAmount;// 剩余本金
        for (int i = 1; i <= list.size() && i <= term; i++) {
            CalArithmeticVO vo = list.get(i - 1);
            vo.setLease_interest(balanceAmount.multiply(termRate).setScale(diag, RoundingMode.HALF_UP));
            // 处理先付项目，第一期利息为0
            if (i == 1 && prepay_or_not.intValue() == Prepay_Or_Not.PREPAY.getShort().intValue()) {
                vo.setLease_interest(BigDecimal.ZERO);
            }
            vo.setLease_corpus(vo.getLease_cash().subtract(vo.getLease_interest()));
            balanceAmount = balanceAmount.subtract(vo.getLease_corpus());
            vo.setCorpus_balance(balanceAmount);
            vo.setRateValue(yearRate);
            vo.setDirection(Direction.INCOME.getShort());

            vo.setLease_cash_fin(vo.getLease_cash());
            vo.setLease_corpus_fin(vo.getLease_corpus());
            vo.setLease_interest_fin(vo.getLease_interest());
            vo.setCorpus_balance_fin(vo.getCorpus_balance());
        }
        // 业务收支计划表
        getRentEQBusiPlan(arithmeticParm);
        return list;
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
        if(yearRate==null){
            throw new BusinessException("报价测算【租息年利率】是可空，请检查！");
        }
        BigDecimal termRate = new BigDecimal("0.0");
        int step = BaseApp.getBaseFrequency(payment_frequency);
        if (Year_Days.YEAR_360.getShort().equals(year_days)&&step!=0) {
            termRate = yearRate.divide(BigDecimal.valueOf(step), MathContext.DECIMAL64);
        } else if(step!=0){
            /** UPDATE  【 wangjj】 【2016年12月5日】 【BUG修改】年化天数 365 期利率计算 {[1+ (年利率*365/(360*12))]^支付频率对应的月数}-1*/
//            termRate = getTerm365Rate(yearRate, step);
            int step_365 = BaseApp.getPaymentFrequency(payment_frequency);
            termRate = getTerm365Rate(yearRate, step_365);
            /** UPDATE  END */

        }
        return termRate;
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
     * 平息法--期复利 业务表
     *
     * 租金不变
     *
     * 本金 = 租金 - 利息
     *
     * @param arithmeticParm
     * @return
     */
    public static void getRentEQBusiPlan(ArithmeticCoreParam arithmeticParm) {
        BigDecimal yearRate = arithmeticParm.getYearRate();
        int diag = arithmeticParm.getCal_digit();
        Integer term = arithmeticParm.getTerm();// 期数
        BigDecimal puttingAmount = arithmeticParm.getPuttingAmount();// 总本金
        BigDecimal sumRentAmount = BigDecimal.ZERO;//总租金
        BigDecimal sumInterrateAmount = BigDecimal.ZERO;//总利息
        List<CalArithmeticVO> listFin = arithmeticParm.getRentList();
        for(CalArithmeticVO finVO : listFin) {
            sumRentAmount = sumRentAmount.add(finVO.getLease_cash());
        }
        sumInterrateAmount = sumRentAmount.subtract(puttingAmount);
        //每期利息
        BigDecimal everyInterrateAmount = sumInterrateAmount.divide(BigDecimal.valueOf(listFin.size()), diag, RoundingMode.HALF_UP);
        BigDecimal termRentAmount = arithmeticParm.getRentList().get(0).getLease_cash();
        BigDecimal balanceAmount = puttingAmount;// 剩余本金
        for (int i = 1; i <= arithmeticParm.getRentList().size() && i <= term; i++) {
            CalArithmeticVO vo = arithmeticParm.getRentList().get(i-1);
            vo.setLease_time(i);
            vo.setLease_interest(everyInterrateAmount);
            vo.setLease_corpus(termRentAmount.subtract(vo.getLease_interest()));
            balanceAmount = balanceAmount.subtract(vo.getLease_corpus());
            vo.setCorpus_balance(balanceAmount);
            vo.setRateValue(yearRate);
            vo.setDirection(Direction.INCOME.getShort());
        }
    }

}