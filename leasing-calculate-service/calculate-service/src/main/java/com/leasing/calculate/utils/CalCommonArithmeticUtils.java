package com.leasing.calculate.utils;
import com.leasing.common.enums.arithmetic.*;
import com.leasing.common.enums.base.Direction;
import com.leasing.common.enums.constant.PubEnumsConstant;
import com.leasing.common.utils.base.BigDecimalUtils;
import com.leasing.common.utils.base.Days360;
import com.leasing.common.utils.base.UFDate;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/10/25
 * @author:Yjj@yonyou.com
 * @description: 核心算法封装类工具类
 **/
public class CalCommonArithmeticUtils {

    /**
     * @description 租金计划表
     * @author Yangjiajin
     * @date 2019/10/25 16:09
     * @param arithmeticParm 算法参数
     * @return java.util.List<CalArithmeticVO>
     */
    public static List<CalArithmeticVO> getRentPlan(ArithmeticCoreParam arithmeticParm) {
        List<CalArithmeticVO> list = new ArrayList<CalArithmeticVO>();
        Short lease_cal_method = arithmeticParm.getLease_cal_method();
        Short interest_method = arithmeticParm.getOccur_interest_method();
        /*
         * 等额租金，分为期复率，日复率
         * 本金 = 租金 - 利息
         * 日复率（默认使用一个租息所占比例，用来参与净现值计算和租金按照比例分配，其实只有半年才有可能出现租金按比例分配的情况）
         */
        if (lease_cal_method.intValue() == Lease_Cal_Method.RENT_EQ.getShort().intValue()) {
            //期复息
            if (interest_method.intValue() == Occur_Interest_Method.INTEREST_TERM.getShort().intValue()) {
                list = getRentTermEQPlan(arithmeticParm);
            } else {
                //日复息
                list = getRentDayEQPlan(arithmeticParm);
            }
        }
        /**
         * 根据租金计算内部收益率（包括平息法，无明示）
         *
         * 利息根据新的利率计算
         *
         * 本金 = 租金 - 利息
         */
        if (lease_cal_method.intValue() == Lease_Cal_Method.CALRATE_SPE.getShort().intValue()) {
            list = getRentFixEQPlan(arithmeticParm);
        }
        /**
         * 等额本金
         */
        if (lease_cal_method.intValue() == Lease_Cal_Method.PRINCIPAL_EQ.getShort().intValue()) {
            // if (interest_method.intValue() ==
            // Occur_Interest_Method.INTEREST_TERM.getShort().intValue()) {
            list = getPrincipalEQPlan(arithmeticParm);
            // } else {
//             list = getDayPrincipalEQPlan(arithmeticParm);
            //            }
        }
        /**
         * 等差租金
         */
        if (lease_cal_method.intValue() == Lease_Cal_Method.RENT_DIF.getShort().intValue()) {
            list = getRentDifPlan(arithmeticParm);
        }
        /**
         * 指定租金
         */
        if (lease_cal_method.intValue() == Lease_Cal_Method.RENT_SPE.getShort().intValue()) {
            list = getRentSpePlan(arithmeticParm);
        }
        /**
         * 指定本金
         */
        if (lease_cal_method.intValue() == Lease_Cal_Method.PRINCIPAL_SPE.getShort().intValue()) {
            list = getPrincipalSpePlan(arithmeticParm);
        }
        /**
         * 表名利率法是由客户指定收取本金的期数
         */
        if (lease_cal_method.intValue() == Lease_Cal_Method.SURFACE.getShort().intValue()) {
            list = getPrincipalSurfacePlan(arithmeticParm);
        }
        /**
         * 不规则测算租金法
         *
         * 根据日复利算法计算
         *
         * 本金 = 租金 - 利息
         */
        if (lease_cal_method.intValue() == Lease_Cal_Method.IRREGULAR_RENT.getShort().intValue()) {
            list = getIrregularRentDayEQPlan(arithmeticParm);
        }
        /**
         * 不规则测算本金法
         *
         * 根据单息利算法计算
         *
         * 本金 = 租金 - 利息
         */
        if (lease_cal_method.intValue() == Lease_Cal_Method.IRREGULAR_CORPUS.getShort().intValue()) {
            // 单利法计算本金
            if(arithmeticParm.getCorpus_way().intValue() == Corpus_Way.SIMPLE_WAY.getShort().intValue()){
                list = getIrregularCorpusDayEQPlanS(arithmeticParm);
            }else {
                list = getIrregularCorpusDayEQPlan(arithmeticParm);
            }
        }
        return list;
    }

    /**
     * 等额租金--期复利
     *
     * 租金不变
     *
     * 本金 = 租金 - 利息
     *
     * @param arithmeticParm
     * @return
     */
    public static List<CalArithmeticVO> getRentTermEQPlan(ArithmeticCoreParam arithmeticParm) {
        List<CalArithmeticVO> list = new ArrayList<CalArithmeticVO>();
        List<String> calDateList = arithmeticParm.getCalDateList();
        Short year_days = arithmeticParm.getYear_days();
        BigDecimal yearRate = arithmeticParm.getYearRate();
        Short payment_frequency = arithmeticParm.getPayment_frequency();
        Short prepay_or_not = arithmeticParm.getPrepay_or_not();
        int diag = arithmeticParm.getCal_digit();
        Integer term = arithmeticParm.getTerm();// 期数
        BigDecimal puttingAmount = arithmeticParm.getPuttingAmount();// 投放金额
        List loanPlanList = arithmeticParm.getLease_loan_plan();//投放计划
        //计算期利率
        BigDecimal termRate = BaseAppVOUtil.getTermRate(year_days, yearRate, payment_frequency);
        //计算日利率
        BigDecimal dayRate = BaseAppVOUtil.getDayRate(yearRate, year_days);
        BigDecimal assets_margin = BigDecimalUtils.defaultIfNull(arithmeticParm.getAssets_margin());
        BigDecimal assets_temp = assets_margin.divide((BigDecimal.ONE.add(termRate)).pow(calDateList.size(),
                MathContext.DECIMAL64), diag, RoundingMode.HALF_UP);
        // 每期租金
        BigDecimal termRentAmount = getTermRentAmount(puttingAmount.subtract(assets_temp), termRate,
                calDateList.size(), prepay_or_not, diag);
        BigDecimal balanceAmount = puttingAmount;// 剩余本金
        BigDecimal oldbalanceAmount = BigDecimal.ZERO;// 上期剩余本金
        BigDecimal termInterest = BigDecimal.ZERO;//每期利息
        BigDecimal termCorpus = BigDecimal.ZERO;//每期本金
        //期次累计
        int lease_time = 0;
        if(arithmeticParm.getRentList() != null) {
            lease_time = arithmeticParm.getRentList().size();
        }
        LeaseLoanPlanVO leaseLoanPlanVO = null;
        LeaseLoanPlanVO oldleaseLoanPlanVO = null;
        LeaseLoanPlanVO calLeaseLoanPlanVO = null;
        String termBeginDate ="";
        String termEndDate ="";
        Boolean breakFalg = false;
        //是否重算过剩余本金
        Boolean calAgainFalg = false;
        int day = 0;//两日期间隔天数
        for (int i = 1; i <= calDateList.size() && i <= term; i++) {
            calAgainFalg = false;
            CalArithmeticVO vo = new CalArithmeticVO();
            vo.setTax_rate(arithmeticParm.getRent_tax_rate());
            vo.setLease_time(i+lease_time);
            vo.setCal_date(calDateList.get(i - 1));
            vo.setPlan_date(calDateList.get(i - 1));
            //
            if(i==1){
                termBeginDate = arithmeticParm.getLastDay();
                termEndDate = calDateList.get(i - 1);
            }else{
                termBeginDate = calDateList.get(i - 2);
                termEndDate = calDateList.get(i - 1);
            }
            //termInterest = balanceAmount.multiply(termRate).setScale(diag, RoundingMode.HALF_UP);
            //计算每期利息yjj
            termInterest = getTermInterestAmount(balanceAmount,termRate,diag);
            vo.setLease_cash(termRentAmount);
            vo.setLease_interest(termInterest);
            // 处理先付项目，第一期利息为0
            if (i == 1 && prepay_or_not.intValue() == Prepay_Or_Not.PREPAY.getShort().intValue()) {
                vo.setLease_interest(BigDecimal.ZERO);
            }

            vo.setLease_corpus(termRentAmount.subtract(vo.getLease_interest()));
            if(loanPlanList!=null){
                for(int j=0;j<loanPlanList.size();j++){
                    oldbalanceAmount = BigDecimal.ZERO;
                    leaseLoanPlanVO = (LeaseLoanPlanVO) loanPlanList.get(j);
                    if((UFDate.getDate(leaseLoanPlanVO.getPlan_date()).after(UFDate.getDate(termBeginDate))
                            ||UFDate.getDate(leaseLoanPlanVO.getPlan_date()).equals(UFDate.getDate(termBeginDate)))
                            &&UFDate.getDate(leaseLoanPlanVO.getPlan_date()).before(UFDate.getDate(termEndDate))){
                        if(leaseLoanPlanVO.getCalinterest_amount_style()!=null){


                            //若此次投放的计息金额计算方式不是‘无’
                            if(leaseLoanPlanVO.getCalinterest_amount_style().compareTo(PubEnumsConstant.CALINTEREST_STLYE_TWO)!=0){
                                //若此次投放的计息金额计算方式为：全额起息，则继续循环剩余投放计划，直到将所有的投放金额相加为止
                                if(leaseLoanPlanVO.getCalinterest_amount_style().compareTo(PubEnumsConstant.CALINTEREST_STLYE_ZERO)==0){
                                    day = Days360.days360(termBeginDate,leaseLoanPlanVO.getPlan_date() );
                                    for(int k=j;k<loanPlanList.size();k++){
                                        calLeaseLoanPlanVO =(LeaseLoanPlanVO) loanPlanList.get(k);
                                        oldbalanceAmount = oldbalanceAmount.add(calLeaseLoanPlanVO.getPlan_cash());
                                    }
                                    balanceAmount = balanceAmount.add(oldbalanceAmount);
                                    //利用新计算的剩余本金重新计算每期租金
                                    termRentAmount  = getTermRentAmount(balanceAmount.subtract(assets_temp), termRate,
                                            calDateList.size()-(i-1), prepay_or_not, diag);

                                    //重算本期本金yjj
                                    //termCorpus = termRentAmount.subtract(balanceAmount.multiply(termRate).setScale(diag, RoundingMode.HALF_UP));
                                    termCorpus = termRentAmount.subtract(getTermInterestAmount(balanceAmount,termRate,diag));
                                    //重算利息yjj
                                    //termInterest = (balanceAmount.multiply(termRate).setScale(diag, RoundingMode.HALF_UP)).subtract(oldbalanceAmount.multiply(dayRate).multiply(new BigDecimal(day))).setScale(diag, RoundingMode.HALF_UP);
                                    termInterest = getTermInterestAmount(balanceAmount, termRate, diag).subtract(getTermInterestAmount(oldbalanceAmount,dayRate,day,diag));
                                    //租金=本金+利息
                                    BigDecimal newTermRentAmount = termCorpus.add(termInterest);
                                    vo.setLease_cash(newTermRentAmount);
                                    vo.setLease_interest(termInterest);
                                    vo.setLease_corpus(vo.getLease_cash().subtract(vo.getLease_interest()));
                                    balanceAmount = balanceAmount.subtract(vo.getLease_corpus());
                                    calAgainFalg = true;
                                    break;
                                }else{//此次投放的计息金额计算方式为：按本次投放金额
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
                                    BigDecimal partInterest = BigDecimal.ZERO;
                                    for(int n =j;n<loanPlanList.size();n++){
                                        calLeaseLoanPlanVO =(LeaseLoanPlanVO) loanPlanList.get(n);
                                        if((UFDate.getDate(calLeaseLoanPlanVO.getPlan_date()).after(UFDate.getDate(termBeginDate))
                                                ||UFDate.getDate(calLeaseLoanPlanVO.getPlan_date()).equals(UFDate.getDate(termBeginDate)))
                                                &&UFDate.getDate(calLeaseLoanPlanVO.getPlan_date()).before(UFDate.getDate(termEndDate))){
                                            oldbalanceAmount = BigDecimal.ZERO;
                                            oldbalanceAmount = oldbalanceAmount.add(calLeaseLoanPlanVO.getPlan_cash());
                                            balanceAmount = balanceAmount.add(oldbalanceAmount);
                                            //利用新计算的剩余本金重新计算每期租金
                                            termRentAmount = getTermRentAmount(balanceAmount.subtract(assets_temp), termRate,
                                                    calDateList.size()-(i-1), prepay_or_not, diag);
                                            // day = Days360.days360(termBeginDate,leaseLoanPlanVO.getPlan_date() );
                                            day = Days360.days360(termBeginDate,calLeaseLoanPlanVO.getPlan_date() );
                                            //重算本期本金
                                            termCorpus = termRentAmount.subtract(balanceAmount.multiply(termRate)).setScale(diag, RoundingMode.HALF_UP);
                                            //重算利息
                                            partInterest = partInterest.add(oldbalanceAmount.multiply(dayRate).multiply(new BigDecimal(day)).setScale(diag, RoundingMode.HALF_UP));
                                            //termInterest = (balanceAmount.multiply(termRate).setScale(diag, RoundingMode.HALF_UP)).subtract(partInterest).setScale(diag, RoundingMode.HALF_UP);
                                            termInterest = (getTermInterestAmount(balanceAmount, termRate, diag)).subtract(partInterest).setScale(diag, RoundingMode.HALF_UP);
                                            //租金=本金+利息
                                            BigDecimal newTermRentAmount  = termCorpus.add(termInterest);

                                            vo.setLease_cash(newTermRentAmount);
                                            vo.setLease_interest(termInterest);
                                            vo.setLease_corpus(vo.getLease_cash().subtract(vo.getLease_interest()));
                                            //balanceAmount = balanceAmount.subtract(vo.getLease_corpus());
                                            calAgainFalg  =true;
                                            //breakFalg =true;
                                            //continue;
                                        }

                                    }
                                    balanceAmount = balanceAmount.subtract(vo.getLease_corpus());
                                    break;

                                }
                            }
                        }
                    }
                }
            }

            if(!calAgainFalg){
                balanceAmount = balanceAmount.subtract(vo.getLease_corpus());
            }

            vo.setCorpus_balance(balanceAmount);
            vo.setDirection(Direction.INCOME.getShort());
            list.add(vo);
        }
        // 业务表处理完成
//        if(arithmeticParm.getRentList() == null) {
//            arithmeticParm.setRentList(list);
//        } else {
//            arithmeticParm.getRentList().addAll(list);
//        }
        // 财务表处理
        //getRentEQFinPlan(arithmeticParm);
        return list;
    }

    /**
     * 等额租金--日复利
     *
     * 租金不变
     *
     * 本金 = 租金 - 利息
     *
     * @param arithmeticParm
     * @return
     */
    public static List<CalArithmeticVO> getRentDayEQPlan(ArithmeticCoreParam arithmeticParm) {
        List<CalArithmeticVO> list = new ArrayList<CalArithmeticVO>();
        Short prepay_or_not = arithmeticParm.getPrepay_or_not();
        int diag = arithmeticParm.getCal_digit();
        Integer term = arithmeticParm.getTerm();// 期数
        BigDecimal puttingAmount = arithmeticParm.getPuttingAmount();// 投放金额
        String puttingDate =  arithmeticParm.getPuttingDate();//投放日期
        List<ArithmeticCoreDayParam> dayParamList = BaseAppUtils.getDayParam(arithmeticParm);
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
        return null;
    }

    /**
     * 等额本金，本金不变， 租金 = 利息+本金 期复息
     */
    public static List<CalArithmeticVO> getPrincipalEQPlan(ArithmeticCoreParam arithmeticParm) {
        List<CalArithmeticVO> list = new ArrayList<CalArithmeticVO>();
        List<String> calDateList = arithmeticParm.getCalDateList();
        BigDecimal yearRate = arithmeticParm.getYearRate();
        int diag = arithmeticParm.getCal_digit();
        Integer term = arithmeticParm.getTerm();// 期数
        Short prepay_or_not = arithmeticParm.getPrepay_or_not();
        BigDecimal puttingAmount = arithmeticParm.getPuttingAmount();// 投放金额
        List loanPlanList = arithmeticParm.getLease_loan_plan();//投放计划

        BigDecimal value  = BigDecimal.valueOf(360);
        if(arithmeticParm.getYear_days().intValue() == Year_Days_Value.VALUE_365.getShort().intValue()){
            value  = BigDecimal.valueOf(365);
        }
        BigDecimal dayRate = arithmeticParm.getYearRate().divide(value, MathContext.DECIMAL64);//日利率
        BigDecimal assets_margin = BigDecimalUtils.defaultIfNull(arithmeticParm.getAssets_margin());
        BigDecimal assets_temp = assets_margin;
        // 每期本金yjj
        //BigDecimal termPrincipalAmount = (puttingAmount.subtract(assets_temp)).divide(BigDecimal.valueOf(calDateList.size()), MathContext.DECIMAL64).setScale(diag, RoundingMode.HALF_UP);
        BigDecimal termPrincipalAmount = getTermPrincipalAmount(puttingAmount.subtract(assets_temp),calDateList.size(),diag);
        BigDecimal balanceAmount = puttingAmount;// 剩余本金
        //期次累计
        int lease_time = 0;
        if(arithmeticParm.getRentList() != null) {
            lease_time = arithmeticParm.getRentList().size();
        }

        Short irr_days = arithmeticParm.getIrr_days();
        if (irr_days == null) {
            irr_days = Year_Days_Irr.IRR_360.getShort();
        }

        UFDate beginDay = UFDate.getDate(arithmeticParm.getLastDay());//投放日期
        String termBeginDate ="";
        String termEndDate ="";
        int calday = 0;//两日期间隔天数
        BigDecimal oldbalanceAmount = BigDecimal.ZERO;//投放本金之和
        BigDecimal termInterest = BigDecimal.ZERO;//每期利息
        BigDecimal termCorpus = BigDecimal.ZERO;//每期本金
        LeaseLoanPlanVO leaseLoanPlanVO = null;
        LeaseLoanPlanVO oldleaseLoanPlanVO = null;
        LeaseLoanPlanVO calLeaseLoanPlanVO = null;//用于计算租期之内的投放金额总和
        BigDecimal partInterest = BigDecimal.ZERO;
        Boolean breakFalg = false;
        for (int i = 1; i <= calDateList.size() && i <= term; i++) {
            partInterest = BigDecimal.ZERO;
            CalArithmeticVO vo = new CalArithmeticVO();
            vo.setLease_time(i+lease_time);
            vo.setCal_date(calDateList.get(i - 1));
            vo.setPlan_date(calDateList.get(i - 1));
            if(i==1){
                termBeginDate = arithmeticParm.getLastDay();
                termEndDate = calDateList.get(i - 1);
            }else{
                termBeginDate = calDateList.get(i - 2);
                termEndDate = calDateList.get(i - 1);
            }

            UFDate endDay = UFDate.getDate(vo.getCal_date());//收款日期

            int day = UFDate.getDaysBetween(beginDay, endDay);
            if (irr_days.intValue() == Year_Days_Irr.IRR_360.getShort().intValue()) {
                day = Days360.days360(beginDay.toString(), endDay.toString());
            }

            // 单利法 利息 = 剩余本金*日利率*两期金额天数
            BigDecimal dayInterest = BigDecimal.ZERO;
            if(arithmeticParm.getDate_interest()){
                dayInterest = balanceAmount.multiply(dayRate).setScale(diag,RoundingMode.HALF_UP);
            } else {
                dayInterest = balanceAmount.multiply(dayRate);
            }
            termInterest = dayInterest.multiply(new BigDecimal(day)).setScale(diag, RoundingMode.HALF_UP);
            if(loanPlanList!=null){
                for(int j=0;j<loanPlanList.size();j++){
                    leaseLoanPlanVO = (LeaseLoanPlanVO) loanPlanList.get(j);
                    //若第一次投放计划的计息方式为：全额起租，则跳出循环
//            	 if(j==0&&leaseLoanPlanVO.getCalinterest_amount_style().compareTo(PubEnumsConstant.CALINTEREST_STLYE_ZERO)==0){
//            		 break;
//            	 }
                    //若在此租期内存在投放计划
                    if((UFDate.getDate(leaseLoanPlanVO.getPlan_date()).after(UFDate.getDate(termBeginDate))
                            ||UFDate.getDate(leaseLoanPlanVO.getPlan_date()).equals(UFDate.getDate(termBeginDate)))
                            &&UFDate.getDate(leaseLoanPlanVO.getPlan_date()).before(UFDate.getDate(termEndDate))){
                        //若此次投放计划计息金额计算方式不是‘无’
                        if(leaseLoanPlanVO.getCalinterest_amount_style().compareTo(PubEnumsConstant.CALINTEREST_STLYE_TWO)!=0){
                            //全额起息
                            if(leaseLoanPlanVO.getCalinterest_amount_style().compareTo(PubEnumsConstant.CALINTEREST_STLYE_ZERO)==0){
                                oldbalanceAmount = BigDecimal.ZERO;
                                for(int k =j;k<loanPlanList.size();k++){
                                    calLeaseLoanPlanVO =(LeaseLoanPlanVO) loanPlanList.get(k);
                                    oldbalanceAmount =oldbalanceAmount.add(calLeaseLoanPlanVO.getPlan_cash());
                                }
                                balanceAmount = balanceAmount.add(oldbalanceAmount);
                                //根据新的剩余本金重新计算每期本金yjj
                                //termPrincipalAmount = (balanceAmount.subtract(assets_temp)).divide(BigDecimal.valueOf(calDateList.size()-(i-1)), MathContext.DECIMAL64).setScale(diag, RoundingMode.HALF_UP);
                                termPrincipalAmount = getTermPrincipalAmount(balanceAmount.subtract(assets_temp),calDateList.size()-(i-1),diag);
                                //重算利息
                                day = UFDate.getDaysBetween(beginDay, UFDate.getDate(vo.getCal_date()));
                                calday = UFDate.getDaysBetween(UFDate.getDate(termBeginDate),UFDate.getDate(calLeaseLoanPlanVO.getPlan_date()));
                                if (irr_days.intValue() == Year_Days_Irr.IRR_360.getShort().intValue()) {
                                    day = Days360.days360(termBeginDate, termEndDate);
                                    // calday = Days360.days360(termBeginDate,calLeaseLoanPlanVO.getPlan_date());
                                    calday = Days360.days360(termBeginDate,leaseLoanPlanVO.getPlan_date());
                                }
                                //yjj
                                //partInterest = oldbalanceAmount.multiply(dayRate).multiply(new BigDecimal(calday)).setScale(diag, RoundingMode.HALF_UP);
                                partInterest = getTermInterestAmount(oldbalanceAmount,dayRate,calday,diag);
                                //termInterest = (balanceAmount.multiply(dayRate).multiply(new BigDecimal(day)).setScale(diag, RoundingMode.HALF_UP)).subtract(partInterest);
                                termInterest = getTermInterestAmount(balanceAmount, dayRate, day, diag).subtract(partInterest);
                                vo.setLease_interest(termInterest);
                                break;
                            }else{//按投放金额计息
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
                                for(int n= j;n<loanPlanList.size();n++){
                                    calLeaseLoanPlanVO =(LeaseLoanPlanVO) loanPlanList.get(n);
                                    if((UFDate.getDate(calLeaseLoanPlanVO.getPlan_date()).after(UFDate.getDate(termBeginDate))
                                            ||UFDate.getDate(calLeaseLoanPlanVO.getPlan_date()).equals(UFDate.getDate(termBeginDate)))
                                            &&UFDate.getDate(calLeaseLoanPlanVO.getPlan_date()).before(UFDate.getDate(termEndDate))){
                                        oldbalanceAmount = BigDecimal.ZERO;
                                        oldbalanceAmount = oldbalanceAmount.add(calLeaseLoanPlanVO.getPlan_cash());
                                        balanceAmount = balanceAmount.add(oldbalanceAmount);
                                        //根据新的剩余本金重新计算每期本金yjj
                                        //termPrincipalAmount = (balanceAmount.subtract(assets_temp)).divide(BigDecimal.valueOf(calDateList.size()-(i+lease_time-1)), MathContext.DECIMAL64).setScale(diag, RoundingMode.HALF_UP);
                                        termPrincipalAmount = getTermPrincipalAmount(balanceAmount.subtract(assets_temp),calDateList.size()-(i+lease_time-1),diag);

                                        //重算利息
                                        day = UFDate.getDaysBetween(beginDay, UFDate.getDate(vo.getCal_date()));
                                        calday = UFDate.getDaysBetween(UFDate.getDate(termBeginDate),UFDate.getDate(calLeaseLoanPlanVO.getPlan_date()));
                                        if (irr_days.intValue() == Year_Days_Irr.IRR_360.getShort().intValue()) {
                                            day = Days360.days360(termBeginDate, termEndDate);
                                            calday = Days360.days360(termBeginDate,calLeaseLoanPlanVO.getPlan_date() );
                                        }
                                        //yjj
                                        //partInterest = partInterest.add(oldbalanceAmount.multiply(dayRate).multiply(new BigDecimal(calday)).setScale(diag, RoundingMode.HALF_UP));
                                        //termInterest = (balanceAmount.multiply(dayRate).multiply(new BigDecimal(day)).setScale(diag, RoundingMode.HALF_UP)).subtract(partInterest).setScale(diag, RoundingMode.HALF_UP);
                                        partInterest = getTermInterestAmount(oldbalanceAmount, dayRate, calday, diag);
                                        termInterest = getTermInterestAmount(balanceAmount, dayRate, day, diag).subtract(partInterest).setScale(diag, RoundingMode.HALF_UP);
                                    }
                                }
                                break;
                            }

                        }else{//计息金额计算方式为‘无’

                        }
                    }
                }
            }
            // 每次计算的时间为本次收取时间与上期收取时间的天数
            beginDay = endDay;
            vo.setLease_corpus(termPrincipalAmount);

            vo.setLease_interest(termInterest);

            if (i == 1 && prepay_or_not.intValue() == Prepay_Or_Not.PREPAY.getShort().intValue()) {
                vo.setLease_interest(BigDecimal.ZERO);
            }
            vo.setLease_cash(vo.getLease_corpus().add(vo.getLease_interest()));
            balanceAmount = balanceAmount.subtract(vo.getLease_corpus());
            vo.setCorpus_balance(balanceAmount);
            vo.setRateValue(yearRate);
            vo.setDirection(Direction.INCOME.getShort());
            list.add(vo);
        }
//        if(arithmeticParm.getRentList() == null) {
//            arithmeticParm.setRentList(list);
//        } else {
//            arithmeticParm.getRentList().addAll(list);
//        }
//        getRentEQFinPlan(arithmeticParm);
        return list;
    }

    /**
     * 等差租金，先进行等额租金计算，根据步长计算每期租金
     *
     * 本金 = 租金 - 利息
     */
    public static List<CalArithmeticVO> getRentDifPlan(ArithmeticCoreParam arithmeticParm) {
        return null;
    }

    /**
     * 指定租金，租金由用户给定
     *
     * 本金 = 租金 - 利息
     */
    public static List<CalArithmeticVO> getRentSpePlan(ArithmeticCoreParam arithmeticParm) {
        return null;
    }

    /**
     * 指定本金 由用户指定本金 租金 = 本金+利息
     *
     * @param arithmeticParm
     * @return
     */
    public static List<CalArithmeticVO> getPrincipalSpePlan(ArithmeticCoreParam arithmeticParm) {
        return null;
    }

    /**
     * 表面利率法 不支持先付项目
     *
     * @param arithmeticParm
     * @return
     */
    public static List<CalArithmeticVO> getPrincipalSurfacePlan(ArithmeticCoreParam arithmeticParm) {
        return null;
    }

    /**
     * 市场表
     * 不规则测算租金法--日复利
     *
     * 按照天计算利息
     *
     * 本金 = 租金 - 利息
     *
     * @param arithmeticParm
     * @return
     */
    public static List<CalArithmeticVO> getIrregularRentDayEQPlan(ArithmeticCoreParam arithmeticParm) {
        return null;
    }

    /**
     * 市场表
     * 不规则测算本金法--单利
     *
     * 按照天计算利息
     *
     * 本金 = 租金 - 利息
     *
     * @param arithmeticParm
     * @return
     */
    public static List<CalArithmeticVO> getIrregularCorpusDayEQPlanS(ArithmeticCoreParam arithmeticParm) {
        return null;
    }

    /**
     * 市场表
     * 不规则测算本金法--复利
     *
     * 按照天计算利息
     *
     * 本金 = 租金 - 利息
     *
     * @param arithmeticParm
     * @return
     */
    public static List<CalArithmeticVO> getIrregularCorpusDayEQPlan(ArithmeticCoreParam arithmeticParm) {
        return null;
    }


    /**
     * 等额租金 (本金 = 租金 - 利息)
     * 计算每期租金 (期复利)
     *
     * @param puttingAmount
     *            投放金额
     * @param termRate
     *            期利率
     * @param term
     *            期数
     * @param prepay_or_not
     *            先付后付
     * @param diag
     *            计算精度
     * @return
     */
    public static BigDecimal getTermRentAmount(BigDecimal puttingAmount, BigDecimal termRate, Integer term,
                                               Short prepay_or_not, int diag) {
        BigDecimal termAmount = BigDecimal.ZERO;
        if (termRate.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal common = ((BigDecimal.ONE.add(termRate)).pow(term)).subtract(BigDecimal.ONE);
            //先付
            if (prepay_or_not.intValue() == Prepay_Or_Not.PREPAY.getShort().intValue()) {
                termAmount = termRate.multiply((BigDecimal.ONE.add(termRate)).pow(term - 1));
                termAmount = termAmount.divide(common, MathContext.DECIMAL64);
                termAmount = termAmount.multiply(puttingAmount, MathContext.DECIMAL64);
            } else {
                //后付
                termAmount = termRate.multiply(BigDecimal.valueOf(Math.pow(1 + termRate.doubleValue(), term)));
                termAmount = termAmount.divide(common, MathContext.DECIMAL64);
                termAmount = termAmount.multiply(puttingAmount, MathContext.DECIMAL64);
            }
        } else {
            termAmount = puttingAmount.divide(BigDecimal.valueOf(term), MathContext.DECIMAL64).setScale(diag, BigDecimal.ROUND_HALF_EVEN);
        }
        return termAmount.setScale(diag, RoundingMode.HALF_UP);
    }

    /**
     * 等额租金 (本金 = 租金 - 利息)
     * 计算每期利息 (期复利)
     *
     * @param puttingAmount
     *            剩余本金
     * @param termRate
     *            期利率
     * @param diag
     *            计算精度
     * @return
     */
    public static BigDecimal getTermInterestAmount(BigDecimal puttingAmount, BigDecimal termRate,int diag) {
        return puttingAmount.multiply(termRate).setScale(diag, RoundingMode.HALF_UP);
    }

    /**
     * 等额租金 (本金 = 租金 - 利息)
     * 计算每期租金 (日复利)
     *
     * @param paramList
     *            日利率 计算参数列表
     * @param puttingAmount
     *            投放金额
     * @return
     */
    public static List<ArithmeticCoreDayParam> getTermRentAmount(List<ArithmeticCoreDayParam> paramList, BigDecimal puttingAmount){
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
        return paramList;
    }

    /**
     * 等额租金 (本金 = 租金 - 利息)
     * 计算每期利息(日复利)
     *
     * @param dayParam
     *            日复利 计算参数类
     * @param balanceAmount
     *            剩余本金
     * @param diag
     *            计算精度
     * @param irr_days
     *            年化天数
     * @param truncationTime
     *            舍位时点
     * @param puttingDate
     *            投放日期
     * @return
     */
    public static BigDecimal getTermInterestAmount(ArithmeticCoreDayParam dayParam, BigDecimal balanceAmount, int diag, Short irr_days,
                                                   Boolean truncationTime , String puttingDate ) {
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
     * 等额租金 (本金 = 租金 - 利息)
     * 计算每期利息(日复利)
     *
     * @param balanceAmount
     *            剩余本金
     * @param days
     *            间隔天数
     * @param dayRate
     *            日利率
     * @param diag
     *            计算精度
     * @return
     */
    public static BigDecimal getTermInterestAmount(BigDecimal balanceAmount, int days, BigDecimal dayRate, int diag) {
        // 利息
        BigDecimal termInterest = BigDecimal.ZERO;
        termInterest = balanceAmount.multiply(dayRate).multiply(new BigDecimal(days)).setScale(diag, RoundingMode.HALF_UP);
        return termInterest;
    }

    /**
     * @description 等额本金 计算每期本金
     * 租金 = 本金 + 利息
     * @author Yangjiajin
     * @date 2019/10/29 9:40
     * @param puttingAmount 投放金额
     * @param term 期数
     * @param diag 计算精度
     * @return
     */
    public static BigDecimal getTermPrincipalAmount(BigDecimal puttingAmount,Integer term, int diag){
        // 每期本金
        BigDecimal termInterest = BigDecimal.ZERO;
        //每期本金
        termInterest = (puttingAmount).divide(BigDecimal.valueOf(term), MathContext.DECIMAL64).setScale(diag, RoundingMode.HALF_UP);
        return termInterest;
    }

    /**
     * @description 等额本金 计算每期利息
     * @author Yangjiajin
     * @date 2019/10/25 18:00
     * @param balanceAmount 剩余本金
     * @param dayRate 日利率
     * @param days 间隔天数
     * @param diag 计算精度
     * @return
     */
    public static BigDecimal getTermInterestAmount(BigDecimal balanceAmount,BigDecimal dayRate,int days,int diag){
        // 每期利息
        BigDecimal termInterest = BigDecimal.ZERO;
        termInterest = balanceAmount.multiply(new BigDecimal(days)).setScale(diag, RoundingMode.HALF_UP);
        return termInterest;
    }





    /**
     * @description 封装到租金计划表VO
     * @author Yangjiajin
     * @date 2019/10/25 16:11
     * @param calList 收租计划列表
     * @return java.util.List<LeasePlanVO>
     */
    public static List<LeasePlanVO> getResultRentList(List<CalArithmeticVO> calList) {
        return null;
    }

}