package com.leasing.communication.calculate.utils;

import com.leasing.communication.common.entity.calculate.vo.base.AdjInoutPlanVO;
import com.leasing.communication.common.entity.calculate.vo.base.CalculatorVO;
import com.leasing.communication.common.entity.calculate.vo.base.InoutPlanVO;
import com.leasing.communication.common.entity.calculate.vo.base.LeasePlanVO;
import com.leasing.communication.common.entity.calculate.vo.cal.CalBusinessParam;
import com.leasing.communication.common.enums.constant.PubEnumsConstant;
import com.leasing.communication.common.enums.constant.TradeType;
import com.leasing.communication.common.exception.BaseException;
import com.leasing.communication.common.utils.base.BigDecimalUtils;
import com.leasing.communication.common.utils.base.Days360;
import com.leasing.communication.common.utils.base.UFDate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;

/**
 * @project:leasing-cloud
 * @date:2019/10/30
 * @author:Yjj@yonyou.com
 * @description: 计算IRR公共类
 **/
public class CalIRRUtils {

    /**
     * Description: 计算IRR公共方法(日IRR)<br>
     * 针对不同IRR类别有特殊处理的方法
     * 收支计划信息
     * @param vatList
     * 计算IRR的类别：市场IRR、会计IRR、增值税IRR、租金IRR、项目IRR、项目去税IRR、手续费分配IRR等
     * @param irr_type
     * @return
     * @author: ROVER<br>
     * @Date：2013-5-26
     */
    public static BigDecimal calDayIRR(Short rentType,List<InoutPlanVO> vatList,
                                       Map<String, Integer>  irrEventMap,
                                       Short irr_type,
                                       Short irr_days,
                                       Short day_value) {
        // 项目去税IRR
        List<InoutPlanVO> newVatList = new ArrayList<InoutPlanVO>();
        if (irr_type.intValue() == PubEnumsConstant.IRRTYPE_PRG_NOTAX.intValue()) {
            for (InoutPlanVO oldvo : vatList) {
                InoutPlanVO newvo = new InoutPlanVO();
                BeanUtils.copyProperties(oldvo, newvo);
                BigDecimal lease_cash_tax = newvo.getLeaseCashTax();
                lease_cash_tax = BigDecimalUtils.defaultIfNull(lease_cash_tax);
                newvo.setLeaseCash(newvo.getLeaseCash().subtract(lease_cash_tax));
                // 使用会计数据计算
                if(rentType.compareTo(PubEnumsConstant.RENTTYPE_ACCOUNT)==0){
                    lease_cash_tax = BigDecimalUtils.defaultIfNull(newvo.getLeaseCashTaxFin());
                    newvo.setLeaseCashFin(newvo.getLeaseCashFin().subtract(lease_cash_tax));
                }

                newVatList.add(newvo);
            }
        } else {
            newVatList.addAll(vatList);
        }
        return calDayIRR(rentType , newVatList, irrEventMap, irr_days, day_value);
    }

    /**
     * Description: 计算IRR公共方法(日IRR)<br>
     * 收支计划信息
     * @param vatList
     * 计算IRR的类别：市场IRR、会计IRR、增值税IRR、租金IRR、项目IRR、项目去税IRR、手续费分配IRR等
     * @param irr_type
     * @return
     * @author: ROVER<br>
     * @Date：2013-5-26
     */
    public static BigDecimal calDayIRR(Short rentType,List<InoutPlanVO> vatList,
                                       Map<String, Integer> irrEventMap,
                                       Short irr_days,
                                       Short day_value) {
        BigDecimal irr = null;
        /**[会计IRR算法调整] @2016年10月28日 @wangjj start*/
        //该算法是用于计算分摊表的会计IRR，如果影响会计IRR的因素中包含保证金，则保证金收取金额  = 保证金冲抵,如果不包含，则过滤。
        //如果保证金收取方式为：手工维护，保证金计划表中有保证金冲抵，也有保证金退回，现金流中的保证金保证金冲抵和保证金退回的的金额之和。需要过滤保证金退回的，在
        BigDecimal deposit_amount_sum = BigDecimal.ZERO;//保证金冲抵金额之和
        for (int i = 0; i < vatList.size(); i++) {
            InoutPlanVO inout = vatList.get(i);
            if(inout.getTransType() != null && irrEventMap.get(inout.getTransType().getCode()) != null
                    && (TradeType.TRADETYPE_DEPOSIT_RENT.equals(inout.getTransType().getCode())
                    || TradeType.TRADETYPE_DEPOSIT_BACK.equals(inout.getTransType().getCode()) )){//保证金冲抵
                deposit_amount_sum = deposit_amount_sum.add(BigDecimalUtils.defaultIfNull(inout.getLeaseCash()));
            }
        }
        /**[会计IRR算法调整] @2016年10月28日 @wangjj end*/

        if (irrEventMap != null) {
            TreeMap<String, BigDecimal> cashFlowMap = new TreeMap<String, BigDecimal>();
            for (InoutPlanVO vo : vatList) {
                BigDecimal cash = vo.getLeaseCash();
                // 使用会计数据计算
                if(rentType.compareTo(PubEnumsConstant.RENTTYPE_ACCOUNT) == 0){
                    cash = vo.getLeaseCashFin();
                }

                Integer direction = irrEventMap.get(vo.getTransType().getCode());

                // 只有配置了的才算进现金流
                if (direction != null) {
                    /**[会计IRR算法调整] @2016年10月28日 @wangjj start*/
                    //如果保证金加入会计IRR的计算，则保证金收取金额 = 保证金冲抵金额
                    if(TradeType.TRADETYPE_DEPOSIT_INCOME.equals(vo.getTransType().getCode())){//收取保证金
                        cash = deposit_amount_sum;
                    }
                    /**[会计IRR算法调整] @2016年10月28日 @wangjj end*/

                    // 减少
                    if (direction == 1) {
                        cash = cash.negate();
                    }
                    // 相同日期，金额累加
                    String plan_date = vo.getPlanDate();
                    if (cashFlowMap.containsKey(plan_date)) {
                        BigDecimal oldCash = cashFlowMap.get(plan_date);
                        cash = cash.add(oldCash);
                    }
                    cashFlowMap.put(plan_date, cash);
                }
            }
            irr = CountIrr.countDayIrr(cashFlowMap, irr_days, day_value);
            irr = irr.setScale(6, BigDecimal.ROUND_HALF_UP);
//            Log lg = LogFactory.getLog(PublicCalAllIRR.class);
//            lg.info(irr+" 现金流："+cashFlowMap);
        }

        return irr;
    }

    /**
     * Description: 计算IRR公共方法(日IRR)<br>
     * 收支计划信息
     * @param vatList
     * 计算IRR的类别：市场IRR、会计IRR、增值税IRR、租金IRR、项目IRR、项目去税IRR、手续费分配IRR等
     * @param irr_type
     * @return
     * @author: ROVER<br>
     * @Date：2013-5-26
     */
    public static BigDecimal calDayIRRCalPlan(Short rentType , List<InoutPlanVO> vatList,
                                              Map<String, Integer> irrEventMap,
                                              Short irr_days,
                                              Short day_value ) {
        BigDecimal irr = null;

        if (irrEventMap != null) {
            TreeMap<String, BigDecimal> cashFlowMap = new TreeMap<String, BigDecimal>();
            for (InoutPlanVO vo : vatList) {
                BigDecimal cash = vo.getLeaseCash();
                // 使用会计数据
                if(rentType.compareTo(PubEnumsConstant.RENTTYPE_ACCOUNT) == 0){
                    cash = BigDecimalUtils.defaultIfNull( vo.getLeaseCashFin());
                }

                Integer direction = irrEventMap.get(vo.getTransType().getCode());

                // 只有配置了的才算进现金流
                if (direction != null) {
                    // 减少
                    if (direction == 1) {
                        cash = cash.negate();
                    }
                    // 相同日期，金额累加
                    String plan_date = vo.getCalDate();
                    if (cashFlowMap.containsKey(plan_date)) {
                        BigDecimal oldCash = cashFlowMap.get(plan_date);
                        cash = cash.add(oldCash);
                    }
                    cashFlowMap.put(plan_date, cash);
                }
            }
            irr = CountIrr.countDayIrr(cashFlowMap, irr_days, day_value);
            irr = irr.setScale(6, BigDecimal.ROUND_HALF_UP);
        }

        return irr;
    }
    /**
     * Description: 计算IRR公共方法(日IRR)<br>
     * 收支计划信息
     * @param vatList
     * 计算IRR的类别：市场IRR、会计IRR、增值税IRR、租金IRR、项目IRR、项目去税IRR、手续费分配IRR等
     * @param irr_type
     * @return
     * @author: ROVER<br>
     * @Date：2013-5-26
     */
    public static BigDecimal calDayIRRAdjust(List<AdjInoutPlanVO> vatList,
                                             Map<String, Integer> irrEventMap,
                                             Short irr_days,
                                             Short day_value) {
        BigDecimal irr = null;

        if (irrEventMap != null) {
            TreeMap<String, BigDecimal> cashFlowMap = new TreeMap<String, BigDecimal>();
            for (AdjInoutPlanVO vo : vatList) {
                BigDecimal cash = vo.getLease_cash();

                Integer direction = irrEventMap.get(vo.getTrans_type().getCode());

                // 只有配置了的才算进现金流
                if (direction != null) {
                    // 减少
                    if (direction == 1) {
                        cash = cash.negate();
                    }
                    // 相同日期，金额累加
                    String plan_date = vo.getPlan_date();
                    if (cashFlowMap.containsKey(plan_date)) {
                        BigDecimal oldCash = cashFlowMap.get(plan_date);
                        cash = cash.add(oldCash);
                    }
                    cashFlowMap.put(plan_date, cash);
                }
            }
            irr = CountIrr.countDayIrr(cashFlowMap, irr_days, day_value);
            irr = irr.setScale(6, BigDecimal.ROUND_HALF_UP);
        }

        return irr;
    }



    /**
     * Description: 计算IRR公共方法(期IRR)<br>
     * 收支计划信息
     * @param vatList
     * 计算IRR的类别：市场IRR、会计IRR、增值税IRR、租金IRR、项目IRR、项目去税IRR、手续费分配IRR等
     * @param irr_type
     * @return
     * @author: ROVER<br>
     * @Date：2013-5-26
     */
    public static BigDecimal calTermIRR(List<InoutPlanVO> vatList, Map<String, Integer>  irrEventMap, Short period) {
        BigDecimal irr = null;

        if (irrEventMap != null) {
            TreeMap<String, BigDecimal> cashFlowMap = new TreeMap<String, BigDecimal>();
            for (InoutPlanVO vo : vatList) {
                BigDecimal cash = vo.getLeaseCash();

                Integer direction = irrEventMap.get(vo.getTransType().getCode());

                // 只有配置了的才算进现金流
                if (direction != null) {
                    // 减少
                    if (direction == 1) {
                        cash = cash.negate();
                    }
                    // 相同日期，金额累加
                    String cal_date = vo.getCalDate();
                    if (cashFlowMap.containsKey(cal_date)) {
                        BigDecimal oldCash = cashFlowMap.get(cal_date);
                        cash = cash.add(oldCash);
                    }
                    cashFlowMap.put(cal_date, cash);
                }
            }
            irr = CountIrr.countTermIrr_date(cashFlowMap);

            Integer times = getYearRepayTerms(period);

            irr = irr.multiply(BigDecimal.valueOf(times)).setScale(6, BigDecimal.ROUND_HALF_UP);
        }

        return irr;
    }

    /**
     * Description: 取得年还款次数<br>
     * @param period
     * @param lease_times
     * @return
     * @author: ROVER<br>
     * @Date：2013-6-19
     */
    private static Integer getYearRepayTerms(Short period){
        Integer freq = 1;
        switch (period) {
            // 双月
            case 1:
                freq = 2;
                break;
            // 季
            case 2:
                freq = 3;
                break;
            // 四月
            case 3:
                freq = 4;
                break;
            // 半年
            case 4:
                freq = 6;
                break;
            // 年
            case 5:
                freq = 12;
                break;
            default:
                freq = 1;
                break;
        }

        return 12 / freq;
    }

    /**
     * Description: 查找对IRR影响的事件类别信息<br>
     * @return
     * @author: ROVER<br>
     * @Date：2013-5-26
     */
    public static Map<Short, Map<String, Integer>> getIrrEventInfo() {
        Map<Short, Map<String, Integer>> resultMap = new TreeMap<Short, Map<String,Integer>>();

        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT DISTINCT M.IRR_TYPE_NAME, T.EVENT_CODE, SUB.VAL ");
        sql.append(" FROM YLS_IRR_EVENT_SET SUB ");
        sql.append(" INNER JOIN YLS_IRR_TYPE M ON M.PK_IRR_TYPE = SUB.PK_IRR_TYPE ");
        sql.append(" INNER JOIN YLS_EVENT_TYPE T ON SUB.PK_EVENT_TYPE = T.PK_EVENT_TYPE ");
        sql.append(" ORDER BY M.IRR_TYPE_NAME ");

        //List list = getJdbcTemplate().queryForList(sql.toString());yjj
        List list = null;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i ++) {
                Map map = (Map) list.get(i);
                Short type = ((BigDecimal) map.get("IRR_TYPE_NAME")).shortValue();
                String key = (String) map.get("EVENT_CODE");
                Integer value = ((BigDecimal) map.get("VAL")).intValue();

                if (!resultMap.containsKey(type)) {
                    resultMap.put(type, new TreeMap<String, Integer>());
                }

                Map<String, Integer> valueMap = resultMap.get(type);
                valueMap.put(key, value);
            }
        }

        return resultMap;
    }

    /**
     * Description: IRR倒算公共方法<br>
     * @param calBusinessParam
     * 计算IRR的类型如：租金IRR、项目IRR等
     * @param irr_type
     * @param vo
     * @return
     * @author: ROVER<br>
     * @Date：2013-5-28
     */
    public static CalBusinessParam getIRRReverseCount(CalBusinessParam calBusinessParam,
                                                      Short irr_type,
                                                      CalculatorVO vo) {
        BigDecimal expect_nominal_irr = vo.getExpectNominalIrr();
        BigDecimal expect_vat_irr = vo.getProjectIrr();
        BigDecimal irr = expect_nominal_irr == null ? expect_vat_irr : expect_nominal_irr;
        // IRR年计算天数
        Short irr_days = vo.getYearDaysIrr();
        if (irr_days.intValue() == PubEnumsConstant.CALDAY_360.intValue()) {
            irr = irr.divide(BigDecimal.valueOf(360), MathContext.DECIMAL64);
        } else {
            irr = irr.divide(BigDecimal.valueOf(365), MathContext.DECIMAL64);
        }
        String plan_date_loan = calBusinessParam.getPlan_date_loan();
        Short irr_object = vo.getIrrObject();
        BigDecimal puttingAmount = BigDecimal.ZERO;
        BigDecimal depostAmount_first = BigDecimal.ZERO;
        BigDecimal feesAmount_first = BigDecimal.ZERO;
        BigDecimal feesoutAmount_first = BigDecimal.ZERO;
        BigDecimal RentsAmount_first = BigDecimal.ZERO;
        BigDecimal nominal_price_first = BigDecimal.ZERO;
        BigDecimal assets_margin_first = BigDecimal.ZERO;
        BigDecimal depostBankAmount_first = BigDecimal.ZERO;
        BigDecimal otherAmount_first = BigDecimal.ZERO;
        BigDecimal firstAmount_first = BigDecimal.ZERO;
        BigDecimal discountAmount_first = BigDecimal.ZERO;
        List<LeasePlanVO> listVat = calBusinessParam.getLease_plan_vat();
        // 为了减少循环次数
        List<LeasePlanVO> srvinVatList = new ArrayList<LeasePlanVO>();
        List<LeasePlanVO> depositVatList = new ArrayList<LeasePlanVO>();
        List<LeasePlanVO> firstVatList = new ArrayList<LeasePlanVO>();
        int diag = calBusinessParam.getCal_digit().intValue() == 0 ? 2 : 0;
        // 预算IRR折现系数
        Map<String, Integer>  irrEventMap = getIrrEventInfo().get(irr_type);
        if (irrEventMap != null) {
            for (int i = 0; i < listVat.size(); i ++) {
                LeasePlanVO planVO = listVat.get(i);
                BigDecimal leaseCash = planVO.getLease_cash();
                Integer direction = irrEventMap.get(planVO.getTrans_type());

                // 只有配置了的才算进现金流(方向为负，则取负值金额)
                if (direction != null && direction == 1) {
                    leaseCash = leaseCash.negate();
                }

                BigDecimal irrXS = BigDecimal.ZERO;
                int days = 0;
                if (irr_days.intValue() == PubEnumsConstant.CALDAY_360.intValue()) {
                    days = Days360.days360(plan_date_loan, planVO.getPlan_date());
                } else {
                    days = UFDate.getDaysBetween(UFDate.getDate(plan_date_loan), UFDate.getDate(planVO.getPlan_date()));
                }
                irrXS = BigDecimal.ONE.divide((BigDecimal.ONE.add(irr)).pow(days, MathContext.DECIMAL64),MathContext.DECIMAL64);
                BigDecimal calCash = leaseCash.multiply(irrXS).setScale(diag, RoundingMode.HALF_UP);
                // 收租类型收支计划
                if (planVO.getTrans_type().equals(TradeType.TRADETYPE_RENT)) {
                    RentsAmount_first = RentsAmount_first.add(calCash);
                }
                // 服务费收入类型收支计划
                else if (planVO.getTrans_type().equals(TradeType.TRADETYPE_SRV_INCOME)
                        || planVO.getTrans_type().equals(TradeType.TRADETYPE_BUSINESS_INCOME)) {
                    calCash = leaseCash.multiply(irrXS).setScale(2, RoundingMode.HALF_UP);
                    feesAmount_first = feesAmount_first.add(calCash);

                    srvinVatList.add(planVO);
                }
                // 服务费支出类型收支计划
                else if (planVO.getTrans_type().equals(TradeType.TRADETYPE_SRV_PAY)) {
                    calCash = leaseCash.multiply(irrXS).setScale(2, RoundingMode.HALF_UP);
                    feesoutAmount_first = feesoutAmount_first.add(calCash);
                }
                // 保证金类型收支计划
                else if (planVO.getTrans_type().equals(TradeType.TRADETYPE_DEPOSIT_BACK)
                        || planVO.getTrans_type().equals(TradeType.TRADETYPE_DEPOSIT_INCOME)
                        || planVO.getTrans_type().equals(TradeType.TRADETYPE_DEPOSIT_INTEREST)
                        || planVO.getTrans_type().equals(TradeType.TRADETYPE_DEPOSIT_RENT)) {
                    calCash = leaseCash.multiply(irrXS).setScale(2, RoundingMode.HALF_UP);
                    depostAmount_first = depostAmount_first.add(calCash);

                    depositVatList.add(planVO);
                }
                // 资产余值
                else if (planVO.getTrans_type().equals(TradeType.TRADETYPE_BALANCE)) {
                    assets_margin_first = assets_margin_first.add(calCash);
                }
                // 名义货价
                else if (planVO.getTrans_type().equals(TradeType.TRADETYPE_PRICE)) {
                    nominal_price_first = nominal_price_first.add(calCash);
                }
                // 首付款
                else if (planVO.getTrans_type().equals(TradeType.TRADETYPE_FIRST)) {
                    calCash = leaseCash.multiply(irrXS).setScale(2, RoundingMode.HALF_UP);
                    firstAmount_first = firstAmount_first.add(calCash);

                    firstVatList.add(planVO);
                }
                // 投放
                else if (planVO.getTrans_type().equals(TradeType.TRADETYPE_PUTTING)
                        || planVO.getTrans_type().equals(TradeType.TRADETYPE_PUTTING_BANK)) {
                    puttingAmount = puttingAmount.add(calCash);
                }
                // 银票保证金
                else if (planVO.getTrans_type().equals(TradeType.TRADETYPE_DEPOSIT_BACK_BANK)
                        || planVO.getTrans_type().equals(TradeType.TRADETYPE_DEPOSIT_INCOME_BANK)
                        || planVO.getTrans_type().equals(TradeType.TRADETYPE_DEPOSIT_INTEREST_BANK)){
                    depostBankAmount_first = depostBankAmount_first.add(calCash);
                }
                // 其他收入、支出
                else if (planVO.getTrans_type().equals(TradeType.TRADETYPE_OTHER_INCOME)
                        || planVO.getTrans_type().equals(TradeType.TRADETYPE_OTHER_PAY)) {
                    otherAmount_first = otherAmount_first.add(calCash);
                }
                // 商业折扣
                else if (planVO.getTrans_type().equals(TradeType.BUSINESS_DISCOUNT)) {
                    discountAmount_first = discountAmount_first.add(calCash);
                }
            }
        } else {
            // 倒算IRR的影响事件类别为null，则给予提示，不进行后续操作
            throw new BaseException("倒算的IRR类别未设置IRR影响事件");
        }

        // 倒算服务费
        if (irr_object.shortValue() == PubEnumsConstant.IRRCONVERT_SRVIN.shortValue()) {
            if(feesAmount_first.compareTo(BigDecimal.ZERO) == 0){
                throw new BaseException("不存在服务费收支计划，无法倒算服务费！");
            }
            // 扣除服务费的现金流
            BigDecimal fees =  puttingAmount.add(RentsAmount_first).add(depostAmount_first).add(nominal_price_first)
                    .add(assets_margin_first).add(depostBankAmount_first).add(otherAmount_first)
                    .add(firstAmount_first).add(discountAmount_first).add(feesoutAmount_first);
            // 新服务费现金流系数
            BigDecimal curFeeXS = fees.divide(feesAmount_first, MathContext.DECIMAL64);
            if(BigDecimal.ZERO.compareTo(fees) >= 0 && feesAmount_first.compareTo(BigDecimal.ZERO) >= 0){
                curFeeXS = curFeeXS.abs();
            } else {
                throw new BaseException("预期IRR偏低，应收服务费小于0，请重新设置！");
            }

            for (int i = 0; i < srvinVatList.size(); i++) {
                LeasePlanVO planVO = srvinVatList.get(i);
                // 收支计划表中，交易类别为：中间业务收入、租赁服务费时，根据倒算算法修改值
                if (planVO.getTrans_type().equals(TradeType.TRADETYPE_SRV_INCOME)
                        || planVO.getTrans_type().equals(TradeType.TRADETYPE_BUSINESS_INCOME)) {
                    planVO.setLease_cash(curFeeXS.multiply(planVO.getLease_cash()).setScale(2,RoundingMode.HALF_UP));
                    //vo.setLeaseCash_tax(calTax(planVO.getLease_cash(), diag));
                }
            }
        }
        // 倒算保证金
        else if (irr_object.shortValue() == PubEnumsConstant.IRRCONVERT_DEPOSIT.shortValue()) {
            // 无保证金无法倒算
            if(depostAmount_first.compareTo(BigDecimal.ZERO) == 0){
                throw new BaseException("不存在保证金收支计划，无法倒算保证金！");
            }
            // 扣除保证金的现金流
            BigDecimal deposits =  puttingAmount.add(RentsAmount_first).add(feesAmount_first).add(nominal_price_first)
                    .add(assets_margin_first).add(depostBankAmount_first).add(otherAmount_first)
                    .add(firstAmount_first).add(discountAmount_first).add(feesoutAmount_first);
            // 新保证金现金流系数
            BigDecimal curDepositsXS = deposits.divide(depostAmount_first, MathContext.DECIMAL64);

            if(BigDecimal.ZERO.compareTo(deposits) >= 0 && depostAmount_first.compareTo(BigDecimal.ZERO) >= 0){
                curDepositsXS = curDepositsXS.abs();
            } else {
                throw new BaseException("预期IRR偏低，应收保证金小于0，请重新设置！");
            }

            for (int i = 0; i < depositVatList.size(); i++) {
                LeasePlanVO planVO = depositVatList.get(i);
                if (planVO.getTrans_type().equals(TradeType.TRADETYPE_DEPOSIT_BACK)
                        || planVO.getTrans_type().equals(TradeType.TRADETYPE_DEPOSIT_INCOME)
                        || planVO.getTrans_type().equals(TradeType.TRADETYPE_DEPOSIT_INTEREST)
                        || planVO.getTrans_type().equals(TradeType.TRADETYPE_DEPOSIT_RENT)) {
                    planVO.setLease_cash(curDepositsXS.multiply(planVO.getLease_cash()).setScale(2,RoundingMode.HALF_UP));
                }
            }
        }

        return calBusinessParam;
    }


    /**
     * Description: 计算IRR公共方法(日IRR)<br>
     * 收支计划信息 (租后报价测算使用)
     * @param vatList
     * 计算IRR的类别：市场IRR、会计IRR、增值税IRR、租金IRR、项目IRR、项目去税IRR、手续费分配IRR等
     * @param irr_type , vatList(全部报价信息收支计划信息),list (已核销明细收支计划信息)
     * @return
     * @author: sunjian<br>
     * @Date：2014-2-28
     */
//    public static BigDecimal rentCalDayIRR(List<InoutPlanRentVO> vatList,List<InoutPlanRentVO> list,
//                                           Map<String, Integer> irrEventMap,
//                                           Short irr_days,
//                                           Short day_value) {
//        BigDecimal irr = null;
//
//        if (irrEventMap != null) {
//            TreeMap<String, BigDecimal> cashFlowMap = new TreeMap<String, BigDecimal>();
//            for (InoutPlanRentVO vo : vatList) {
//                Integer direction = irrEventMap.get(vo.getTrans_type().getCode());
//                // 未核销或者收支方向为付款的
//                if(vo.getCharge_off_status() == 0 || (direction != null && direction == -1) || vo.getTrans_type().getEvent_class_code().equals(ParamTransType.LOAN_TYPE)){
//                    BigDecimal cash = vo.getLease_cash();
//
//                    // 只有配置了的才算进现金流
//                    if (direction != null) {
//                        // 减少
//                        if (direction == 1) {
//                            cash = cash.negate();
//                        }
//                        // 相同日期，金额累加
//                        String plan_date = vo.getPlan_date();
//                        if (cashFlowMap.containsKey(plan_date)) {
//                            BigDecimal oldCash = cashFlowMap.get(plan_date);
//                            cash = cash.add(oldCash);
//                        }
//                        cashFlowMap.put(plan_date, cash);
//                    }
//                }
//            }
//
//            for(InoutPlanRentVO vo : list){
//                Integer direction = irrEventMap.get(vo.getTrans_type().getCode());
//                BigDecimal cash = vo.getLease_cash();
//
//
//                // 只有配置了的才算进现金流
//                if (direction != null) {
//                    // 减少
//                    if (direction == 1) {
//                        cash = cash.negate();
//                    }
//                    // 相同日期，金额累加
//                    String plan_date = vo.getPlan_date();
//                    if (cashFlowMap.containsKey(plan_date)) {
//                        BigDecimal oldCash = cashFlowMap.get(plan_date);
//                        cash = cash.add(oldCash);
//                    }
//                    cashFlowMap.put(plan_date, cash);
//                }
//            }
//            irr = CountIrr.countDayIrr(cashFlowMap, irr_days, day_value);
//            irr = irr.setScale(6, BigDecimal.ROUND_HALF_UP);
//        }
//
//        return irr;
//    }
    /**
     * Description: 计算IRR公共方法(日IRR)<br>
     * 收支计划信息 (租后报价测算使用)
     * @param vatList
     * 计算IRR的类别：市场IRR、会计IRR、增值税IRR、租金IRR、项目IRR、项目去税IRR、手续费分配IRR等
     * @param irr_type , vatList(全部报价信息收支计划信息),list (已核销明细收支计划信息)
     * @return
     * @author: sunjian<br>
     * @Date：2014-2-28
     */
//    public static BigDecimal rentCalDayIRR(List<InoutPlanRentVO> vatList,
//                                           Map<String, Integer> irrEventMap,
//                                           Short irr_days,
//                                           Short day_value) {
//        BigDecimal irr = null;
//
//        if (irrEventMap != null) {
//            TreeMap<String, BigDecimal> cashFlowMap = new TreeMap<String, BigDecimal>();
//            for (InoutPlanRentVO vo : vatList) {
//                Integer direction = irrEventMap.get(vo.getTrans_type().getCode());
//                if(direction != null){
//                    BigDecimal cash = vo.getLease_cash();
//
//                    // 只有配置了的才算进现金流
//                    if (direction != null) {
//                        // 减少
//                        if (direction == 1) {
//                            cash = cash.negate();
//                        }
//                        // 相同日期，金额累加
//                        String plan_date = vo.getPlan_date();
//                        if (cashFlowMap.containsKey(plan_date)) {
//                            BigDecimal oldCash = cashFlowMap.get(plan_date);
//                            cash = cash.add(oldCash);
//                        }
//                        cashFlowMap.put(plan_date, cash);
//                    }
//                }
//            }
//
//            irr = CountIrr.countDayIrr(cashFlowMap, irr_days, day_value);
//            irr = irr.setScale(6, BigDecimal.ROUND_HALF_UP);
//        }
//
//        return irr;
//    }



    /**
     * Description: 中投去税irr<br>
     * 针对不同IRR类别有特殊处理的方法
     * 收支计划信息
     * @param vatList
     * 计算IRR的类别：市场IRR、会计IRR、增值税IRR、租金IRR、项目IRR、项目去税IRR、手续费分配IRR等
     * @param irr_type
     * @return
     * @author: ROVER<br>
     * @Date：2013-5-26
     */
    public static BigDecimal calDayNoTaxZtIRR(Short rentType,List<InoutPlanVO> vatList,
                                              Map<String, Integer>  irrEventMap,
                                              Short irr_days,
                                              Short day_value) {

        BigDecimal irr = null;

        if (irrEventMap != null) {
            TreeMap<String, BigDecimal> cashFlowMap = new TreeMap<String, BigDecimal>();
            TreeMap<String, BigDecimal> cashTaxFlowMap = new TreeMap<String, BigDecimal>();

            /**[会计IRR算法调整] @2016年10月28日 @wangjj start*/
            //该方法用于计算市场去税IRR和会计去税IRR，
            //如果会计去税IRR的算法 包含 保证金，　则计算会计去税IRR的现金流　保证金收取金额　＝保证金冲抵金额（如果没有则为0）
            //市场去税IRR算法 包含保证金，则计算市场去税IRR的现金流 保证金收取金额 = 保证金冲抵金额+保证金退回金额 （如果没有则为0）
            BigDecimal deposit_amount_sum = BigDecimal.ZERO;//保证金冲抵（退回）总额
            /** UPDATE  【 wangjj】 【2017年2月27日】 【BUG修改】<BUG号 JICL-783号> */
            String loan_date = null;
            /** UPDATE  END */
            for (int i = 0; i < vatList.size(); i++) {
                InoutPlanVO inout = vatList.get(i);
                /** BUG JICL-783 wangjj 2017-02-27 去税IRR算法修订start*/
                if(TradeType.TRADETYPE_PUTTING.equals(inout.getTransType().getCode()) || TradeType.TRADETYPE_PUTTING_BANK.equals(inout.getTransType().getCode())){
                    if(loan_date == null || (loan_date != null && UFDate.getDate(loan_date).before(UFDate.getDate(inout.getPlanDate())) )){
                        loan_date = inout.getPlanDate();
                    }
                }
                /** BUG JICL-783 wangjj 2017-02-27 去税IRR算法修订 end*/
                Integer direction = irrEventMap.get(inout.getTransType().getCode());
                if(direction != null){
                    if(inout.getTransType() != null && (TradeType.TRADETYPE_DEPOSIT_RENT.equals(inout.getTransType().getCode()) || TradeType.TRADETYPE_DEPOSIT_BACK.equals(inout.getTransType().getCode()) )){
                        deposit_amount_sum = deposit_amount_sum.add(BigDecimalUtils.defaultIfNull(inout.getLeaseCash()));
                    }
                }
            }
            /**[会计IRR算法调整] @2016年10月28日 @wangjj end*/

            for (InoutPlanVO vo : vatList) {
                BigDecimal cash = vo.getLeaseCash();
                BigDecimal tax = BigDecimalUtils.defaultIfNull(vo.getLeaseCashTax());
                // 使用会计数据计算
                if(rentType.compareTo(PubEnumsConstant.RENTTYPE_ACCOUNT) == 0){
                    cash = vo.getLeaseCashFin();
                    tax = BigDecimalUtils.defaultIfNull(vo.getLeaseCashTaxFin());
                }

                Integer direction = irrEventMap.get(vo.getTransType().getCode());

                // 只有配置了的才算进现金流
                if (direction != null) {

                    /**[会计IRR算法调整] @2016年10月28日 @wangjj start*/
                    if(TradeType.TRADETYPE_DEPOSIT_INCOME.equals(vo.getTransType().getCode())){//保证金收取
                        cash = deposit_amount_sum;
                    }
                    /**[会计IRR算法调整] @2016年10月28日 @wangjj end*/

                    // 减少
                    if (direction == 1) {
                        cash = cash.negate();
                        tax = tax.negate();
                    }
                    // 相同日期，金额累加
                    String plan_date = vo.getPlanDate();
                    if (cashFlowMap.containsKey(plan_date)) {
                        BigDecimal oldCash = cashFlowMap.get(plan_date);
                        cash = cash.add(oldCash);
                    }

                    if (cashTaxFlowMap.containsKey(plan_date)) {
                        BigDecimal oldCash = cashTaxFlowMap.get(plan_date);
                        tax = tax.add(oldCash);
                    }
                    cashFlowMap.put(plan_date, cash);

                    cashTaxFlowMap.put(plan_date, tax);
                }
            }

            //如果该期增值税总和（销项-进项）<0,则该期应交税=0；
            //          如果该期增值税总和>0，且上期增值税总和<0；则该期应交税=该期增值税总和；
            //                               否则该期应交税=该期增值税总和-上期增值税总和
            BigDecimal sumCash = null;
            for (Iterator it = cashTaxFlowMap.keySet().iterator(); it.hasNext();) {
                String key = (String) it.next();
                if (sumCash == null) {
                    sumCash = cashTaxFlowMap.get(key);
                    //当为回租时，投放没有税额，当有其他增值税即增值税总和>0时需要减去
                    if (sumCash.compareTo(BigDecimal.ZERO) > 0) {
                        BigDecimal oldCash = cashFlowMap.get(key);
                        oldCash = oldCash.subtract(sumCash);
                        cashFlowMap.put(key, oldCash);
                    }
                } else {
                    BigDecimal cash = cashTaxFlowMap.get(key);
                    System.out.println(key+"-"+cash);
                    BigDecimal tempCash = sumCash;
                    /** BUG JICL-783 wangjj 2017-02-27 去税IRR算法修订start*/
//                    sumCash = sumCash.add(cash);
                    if(tempCash.compareTo(BigDecimal.ZERO) > 0 && key.equals(loan_date)){
                        sumCash = cash;
                    }else{
                        sumCash = sumCash.add(cash);
                    }
                    System.out.println(key+":"+sumCash);
                    /** BUG JICL-783 wangjj 2017-02-27 去税IRR算法修订end*/
                    if (sumCash.compareTo(BigDecimal.ZERO) > 0) {
                        if (tempCash.compareTo(BigDecimal.ZERO) < 0) {
                            BigDecimal oldCash = cashFlowMap.get(key);
                            oldCash = oldCash.subtract(sumCash);
                            cashFlowMap.put(key, oldCash);
                        } else {
                            BigDecimal oldCash = cashFlowMap.get(key);
                            oldCash = oldCash.subtract(sumCash.subtract(tempCash));
                            cashFlowMap.put(key, oldCash);
                        }
                    }

                }

            }
            irr = CountIrr.countDayIrr(cashFlowMap, irr_days, day_value);
            irr = irr.setScale(6, BigDecimal.ROUND_HALF_UP);
//            Log lg = LogFactory.getLog(PublicCalAllIRR.class);yjj
//            lg.info(irr+" 现金流："+cashFlowMap);
        }

        return irr;
    }

    /**
     * 报价起租测算计算Irr借口
     * @param lease_plan_vat
     * @param calhvo
     */
    public static List<String> CalIrrAllForCal(List<InoutPlanVO> lease_plan_vat, CalculatorVO calhvo) {
        Short dayValue = calhvo.getYearDaysIrr();
        Short irrDays = calhvo.getYearDaysFlow();
        //市场IRR 市场去税IRR
        BigDecimal project_irr = BigDecimal.ZERO;
        //会计IRR 会计去税IRR
        BigDecimal finance_irr  = BigDecimal.ZERO;
        //中投会计表IRR影响事件
        Map<String, Integer> accountEventType = CalIRRUtils.getIrrEventInfo().get(PubEnumsConstant.RRTYPE_ACC_DEPOSIT_ZT);
        //中投市场表IRR影响事件
        Map<String, Integer> projectEventType = CalIRRUtils.getIrrEventInfo().get(PubEnumsConstant.IRRTYPE_PRG);
        project_irr = CalIRRUtils.calDayIRR(PubEnumsConstant.RENTTYPE_MARKET,lease_plan_vat,projectEventType,irrDays,dayValue);
        finance_irr = CalIRRUtils.calDayIRR(PubEnumsConstant.RENTTYPE_ACCOUNT,lease_plan_vat,accountEventType,irrDays,dayValue);
        List<String> list =new ArrayList<String>();
        list.add(project_irr.toString());
        list.add(finance_irr.toString());
        return list;
    }

}