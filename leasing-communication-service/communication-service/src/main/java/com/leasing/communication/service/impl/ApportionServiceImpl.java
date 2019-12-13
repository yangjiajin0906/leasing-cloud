package com.leasing.communication.service.impl;

import com.leasing.common.entity.calculate.dos.InoutPlanPDO;
import com.leasing.common.entity.calculate.vo.base.CalculatorVO;
import com.leasing.common.entity.calculate.vo.base.InoutPlanVO;
import com.leasing.common.entity.calculate.vo.base.LeaseLoanPlanVO;
import com.leasing.common.entity.calculate.vo.base.LeasePlanVO;
import com.leasing.common.entity.calculate.vo.cal.CalBusinessParam;
import com.leasing.common.entity.calculate.vo.cal.LeasePlanSpVO;
import com.leasing.common.entity.calculate.vo.cal.ParamRentRule;
import com.leasing.common.entity.common.ref.EventTypeRefVO;
import com.leasing.common.enums.arithmetic.Prepay_Or_Not;
import com.leasing.common.enums.constant.PubEnumsConstant;
import com.leasing.common.enums.constant.SourcebillTypeConstant;
import com.leasing.common.enums.constant.TradeType;
import com.leasing.common.service.sys.PubRefService;
import com.leasing.common.utils.tools.DozerUtils;
import com.leasing.communication.entity.vo.AccrualVO;
import com.leasing.communication.service.arithmetic.ApportionService;
import com.leasing.common.utils.arithmetic.*;
import com.leasing.common.utils.base.BigDecimalUtils;
import com.leasing.common.utils.base.UFDate;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;

/**
 * @project:leasing-cloud
 * @date:2019/12/10
 * @author:wangjc@yonyou.com
 * @description:算法计算接口实现类
 **/
@Service("common.ApportionServiceImpl")
@Transactional
public class ApportionServiceImpl implements ApportionService {
    private final Log logger = LogFactory.getLog(ApportionServiceImpl.class);

    @Resource
    PubRefService pubRefService;


    /**
     * 生成中投会计分摊表算法  默认不同时间类别向同一收租日期合并
     * @param lease_fin  最终的租金计划表
     */
    @Override
    public List<InoutPlanVO> createAccount(List<LeasePlanVO> lease_fin){
        CalBusinessParam calBusi = new CalBusinessParam();
        buildPlanDate(lease_fin, calBusi);    //得到的租金计划表获取投放日期 租赁期限 计划收租日  租金税率
        buildCalBusinessParam(calBusi);       //封装初始化参数
        calBusi.setLease_plan_vat(lease_fin);  //默认生成的租金计划表(包含 投放 保证金 手续费 其他收支计划)
        logger.info("------------------------------------算法版本" + calBusi.getCal_version() + "------------------------------------");
        List<LeasePlanVO> list_account = constructAccountList(lease_fin,calBusi);  //构造使用的现金流
        printCashFlow(list_account);      //打印现金流
        calTaxDiff(list_account,calBusi); //计算进销税
        Map<String,Integer> irrEventMap = getIrrEventMap(calBusi);
        Map newMap = RestFulUtils.getInstance().getAccountShareTable(list_account,calBusi,irrEventMap); //计算会计分摊表
        List<InoutPlanVO> inout_plan_market = buildResultAccount(lease_fin, newMap, calBusi);  //封装系统生成的收支计划
        printResultList(inout_plan_market);  //打印生成的会计分摊表数据
        return inout_plan_market;
    }


    /**
     * 生成会计计提表算法
     * @param  inout_plan_market  会计计提表
     */
    @Override
    public List<AccrualVO> createAccrual(List<InoutPlanVO> inout_plan_market){
        CalculatorVO vo = buildCalculatorVO(inout_plan_market); //构造默认的报价参数
        Short accrualWay = PubEnumsConstant.IF_YES ;     //默认计提计算方式为 占比计提
        String source_billtype = SourcebillTypeConstant.BILLTYPE_CALCULATOR ;   //默认业务类型 此处取了报价测算
        HashMap<String, ArrayList> yearHm = new HashMap<>();        //服务费按年汇总信息计算此处不传空 会报空指针
        List oldAccrualList = new ArrayList<>();
        List<InoutPlanVO> flowCash = filterFlowCash(inout_plan_market);
        List resultmap = RestFulUtils.getInstance().getAccrual(vo, source_billtype, accrualWay, vo.getPkLeaseCalculator(), yearHm, flowCash, oldAccrualList);
        List<AccrualVO> returnlist = new ArrayList<>();
        for(Object map : resultmap){
            AccrualVO accrualVO = DozerUtils.convert(map,AccrualVO.class);
            returnlist.add(accrualVO);
        }
        return returnlist;
    }

    /**
     * 过滤参与计提的收支计划
     */
    public List<InoutPlanVO> filterFlowCash(List<InoutPlanVO> list){
        List<InoutPlanVO> resultlist = new ArrayList<>();
        for(InoutPlanVO inoutPlanVO : list){
            if(BigDecimalUtils.defaultIfNull(inoutPlanVO.getNoTaxInterest()).abs().compareTo(BigDecimal.ZERO) == 1
                    ||BigDecimalUtils.defaultIfNull(inoutPlanVO.getNoTaxSrvfee()).abs().compareTo(BigDecimal.ZERO) == 1
                    ||BigDecimalUtils.defaultIfNull(inoutPlanVO.getNoTaxOtherin()).abs().compareTo(BigDecimal.ZERO) == 1
                    ||BigDecimalUtils.defaultIfNull(inoutPlanVO.getNoTaxOtherout()).abs().compareTo(BigDecimal.ZERO) == 1){
                resultlist.add(inoutPlanVO);
            }
        }
        return resultlist;
    }

    /**
     * 报价参数初始化
     */
    public CalculatorVO buildCalculatorVO(List<InoutPlanVO> lease_fin){
        CalculatorVO vo = new CalculatorVO();
        List<LeaseLoanPlanVO> list = new ArrayList<>();
        for(InoutPlanVO inoutPlanVO : lease_fin) {
            if (inoutPlanVO.getTransType().getEventCode().equals(TradeType.TRADETYPE_PUTTING) ||
                    inoutPlanVO.getTransType().getEventCode().equals(TradeType.TRADETYPE_PUTTING_BANK)) {
                LeaseLoanPlanVO leaseLoanPlanVO = new LeaseLoanPlanVO();
                leaseLoanPlanVO.setIf_begin_plan(PubEnumsConstant.IF_YES);
                leaseLoanPlanVO.setPlan_date(inoutPlanVO.getPlanDate());
                list.add(leaseLoanPlanVO);
                vo.setLeaseLoanPlan(list);                       //默认的投放计划
                vo.setPlanDateLoan(inoutPlanVO.getPlanDate());   //默认投放日期
            }
        }
        vo.setPrepayOrNot(PubEnumsConstant.PREPAY_AFTERPAY);   //默认后付
        vo.setYearDaysFlow(PubEnumsConstant.CALDAY_360);       //现金流计算日期按360计算
        return vo;
    }

    /**
     * 计算接口参数初始化
     */
    public void buildCalBusinessParam(CalBusinessParam calBusi){
        calBusi.setDate_interest(Boolean.FALSE);                        //日利息金额处理方式默认为否 保留小数 不舍位
        calBusi.setCorpus_adjust_zero(PubEnumsConstant.IF_NO);          //本金为负时不会调整为0
        calBusi.setEndDate_type(Boolean.FALSE);                         //最后期收租日默认与收租日计算保持一致
        calBusi.setTrade_type(PubEnumsConstant.BUSITYPE_COMMON);        //默认业务类型为普通(无需厂商和在建期)
        calBusi.setCal_digit(Short.valueOf("2"));                       //计算精度默认保留两位小数
        calBusi.setYear_days(PubEnumsConstant.CALDAY_360);              //年计算天数默认为360
        calBusi.setIrr_days(PubEnumsConstant.CALDAY_360);               //irr计算天数默认为360
        calBusi.setDay_value(PubEnumsConstant.CALDAY_360);              //irr年利率计算天数默认为360
        calBusi.setCal_version(PubEnumsConstant.cal_independent_event); //默认算法版本
        calBusi.setTax_mode(PubEnumsConstant.TAX_MODEL_VALUE_ADDED);    //默认收税模式为增值税
        calBusi.setFinance_irr_method(PubEnumsConstant.IF_YES);         //会计IRR按最新算法计算
        calBusi.setCalinterest_amount_style(PubEnumsConstant.CALINTEREST_STLYE_ONE); //计息金额计算方式默认为 全额起息
        calBusi.setFinal_date(getSpeFinalDate(calBusi));                //需要根据传入参数计算项目到期日
    }

    /**
     * 获取收支计划中的投放日期置入计算接口
     */
    public void buildPlanDate(List<LeasePlanVO> lease_fin, CalBusinessParam calBusi){
        ParamRentRule rentRuleVO = new ParamRentRule();
        String lastDate = "";
        Short rent_tax_rate = 0;
        for(LeasePlanVO vo : lease_fin){
            if(vo.getTrans_type().equals(TradeType.TRADETYPE_PUTTING)||
                    vo.getTrans_type().equals(TradeType.TRADETYPE_PUTTING_BANK)){
                calBusi.setPlan_date_loan(vo.getPlan_date());
                calBusi.setFact_plan_loan_date(vo.getPlan_date());
            }
            if(vo.getTrans_type().equals(TradeType.TRADETYPE_RENT)||
                    vo.getTrans_type().equals(TradeType.TRADETYPE_RENT_C)||
                    vo.getTrans_type().equals(TradeType.TRADETYPE_RENT_BEFORE_INTEREST)){
                rent_tax_rate = vo.getTax_rate();
                if("".equals(lastDate)){
                    lastDate = vo.getPlan_date();
                } else {
                    if(lastDate.compareTo(vo.getPlan_date()) < 0){
                        lastDate = vo.getPlan_date();
                    }
                }
            }
        }
        calBusi.setRent_tax_rate(rent_tax_rate);   //租金税率 默认跟收支计划取
        Integer lease_time = UFDate.getMonthBetween(UFDate.getDate(calBusi.getPlan_date_loan()),UFDate.getDate(lastDate));
        //指定计划收租日随起租日计算
        calBusi.setPlan_lease_date(Short.valueOf(calBusi.getPlan_date_loan().substring(8, calBusi.getPlan_date_loan().length())));
        rentRuleVO.setLease_times(lease_time);    //总期数
        rentRuleVO.setPrepay_or_not(PubEnumsConstant.PREPAY_AFTERPAY);   //默认后付
        calBusi.setRentRuleVO(rentRuleVO);
    }

    /**
     * 构建参与会计分摊的现金流
     * @param list
     * @return
     */
    public List<LeasePlanVO> constructAccountList(List<LeasePlanVO> list,CalBusinessParam calBusi){
        String loanDate = StringUtils.isBlank(calBusi.getFact_plan_loan_date()) ? calBusi.getPlan_date_loan() : calBusi.getFact_plan_loan_date();
        UFDate loanDateUF = new UFDate(loanDate);
        List<LeasePlanVO> returnList = new ArrayList<LeasePlanVO>();
        if(list != null && list.size() > 0) {
            for(LeasePlanVO vo : list) {
                LeasePlanVO newVo = new LeasePlanVO();
                BeanUtils.copyProperties(vo, newVo);
                UFDate planDateUF = new UFDate(vo.getPlan_date());
                if(planDateUF.before(loanDateUF) && (vo.getTrans_type().equals(TradeType.TRADETYPE_RENT) ||
                        vo.getTrans_type().equals(TradeType.TRADETYPE_RENT_C) ||
                        vo.getTrans_type().equals(TradeType.TRADETYPE_RENT_BEFORE_INTEREST))) {
                    newVo.setPlan_date(loanDate);
                    newVo.setCal_date(loanDate);
                }
                returnList.add(newVo);
            }
        }
        return returnList;
    }

    /**
     * 打印现金流日志
     */
    public void printCashFlow(List list){
        logger.info("开始打印现金流---------------------------------------------------------");
        logger.info("-----日期---|---租金---|---本金---|---利息---|---税率---|------------------------");
        for(Object obj : list){
            if(obj instanceof LeasePlanVO){
                LeasePlanVO vo = (LeasePlanVO)obj;
                String date = vo.getPlan_date();
                BigDecimal lease_cash = vo.getLease_cash();
                BigDecimal lease_interest = vo.getLease_interest();
                BigDecimal lease_corpus = vo.getLease_corpus();
                Short tax_rate = vo.getTax_rate();
                String transType = vo.getTrans_type();
                logger.info("-----" + date + "   |   " + transType + "   |   " + lease_cash +"   |   " + lease_corpus +"   |   " + lease_interest + "   |   " + tax_rate + "------------------------------");
            }
        }
        logger.info("-----------|---------|---------|---------|------------------------------------");
    }


    /**
     * 计算进项税和销项税
     * @param list_fin
     * @param calBusi
     */
    public void calTaxDiff(List<LeasePlanVO> list_fin, CalBusinessParam calBusi){
        BigDecimal loan_tax = BigDecimal.ZERO;
        BigDecimal rent_tax = BigDecimal.ZERO;
        for(LeasePlanVO vo : list_fin){
            String transType = vo.getTrans_type();
            if(transType.equals(TradeType.TRADETYPE_PUTTING)
                    || transType.equals(TradeType.TRADETYPE_PUTTING_BANK)){
                BigDecimal tax_rate = CalTaxUtil.enum2Rate(vo.getTax_rate());
                BigDecimal cash = vo.getLease_cash() == null ? BigDecimal.ZERO : vo.getLease_cash();
                loan_tax = loan_tax.add(cash.divide(BigDecimal.ONE.add(tax_rate),14,BigDecimal.ROUND_HALF_EVEN)
                        .multiply(tax_rate).setScale(6, BigDecimal.ROUND_HALF_EVEN));
            } else if(transType.equals(TradeType.TRADETYPE_RENT)
                    || transType.equals(TradeType.TRADETYPE_RENT_C)
                    ||transType.equals(TradeType.TRADETYPE_RENT_BEFORE_INTEREST)){
                BigDecimal tax_rate = CalTaxUtil.enum2Rate(vo.getTax_rate());
                BigDecimal cash = vo.getLease_corpus() == null ? BigDecimal.ZERO : vo.getLease_corpus();
                rent_tax = rent_tax.add(cash.divide(BigDecimal.ONE.add(tax_rate),14,BigDecimal.ROUND_HALF_EVEN)
                        .multiply(tax_rate).setScale(6, BigDecimal.ROUND_HALF_EVEN));
            }
        }
        calBusi.setLoan_tax(loan_tax.setScale(2, BigDecimal.ROUND_HALF_EVEN));
        calBusi.setRent_tax(rent_tax.setScale(2, BigDecimal.ROUND_HALF_EVEN));
    }


    /**
     * 获取IRR 事件类别
     * @param calBusi
     * @return
     */
    public Map<String, Integer> getIrrEventMap(CalBusinessParam calBusi){
        Map<String, Integer> irrEventMap =null;
        /*
         * 中投调息过程中发现老合同计算会计拆分是只考虑到租金、留购价等事件类别
         * 所以此处在调息测算过程发现是移植过来的报价测算做以下特殊处理
         */
        if(calBusi.isIf_old_sys_calc()){
            irrEventMap=new HashMap<String, Integer>();
            //租金
            irrEventMap.put(TradeType.TRADETYPE_RENT, 0);
            //留购价款
            irrEventMap.put(TradeType.TRADETYPE_PRICE, 0);
            //投放(银票)
            irrEventMap.put(TradeType.TRADETYPE_PUTTING_BANK, 1);
            //投放（现金）
            irrEventMap.put(TradeType.TRADETYPE_PUTTING, 1);
        }else{
            Short if_deposit = Short.valueOf("1");   // 中投会计表是否含保证金相关 默认为否  未取运行参数 此处先写死
            Short accountIRR = PubEnumsConstant.RRTYPE_ACC_DEPOSIT_ZT;
            if ((calBusi.getFinance_irr_method() == null || PubEnumsConstant.IF_NO.intValue() == calBusi.getFinance_irr_method())
                    && PubEnumsConstant.IF_NO.intValue() == if_deposit.intValue()) {
                accountIRR = PubEnumsConstant.RRTYPE_ACC_ZT;
            }
            if (PubEnumsConstant.RRTYPE_ACC_DEPOSIT_ZT.intValue() == accountIRR) {
                irrEventMap = CalIRRUtils.getIrrEventInfo().get(accountIRR);
                irrEventMap.remove(TradeType.TRADETYPE_DEPOSIT_BACK);      //保证金退回不参与会计IRR的计算
            } else {
                irrEventMap = CalIRRUtils.getIrrEventInfo().get(accountIRR);
            }
        }
        return irrEventMap;
    }

    /**
     * 事件类别分类处理
     */
    public Map handleEventType(Map<String, Map> dataMap){
        Map resultMap = new HashMap();
        for (Map.Entry<String, Map> entry : dataMap.entrySet()) {
            Map pList = entry.getValue();
            if (pList.containsKey(TradeType.TRADETYPE_RENT)) {
                resultMap.put(entry.getKey(), TradeType.TRADETYPE_RENT);
                continue;
            } else if (pList.containsKey(TradeType.TRADETYPE_PUTTING)) {
                resultMap.put(entry.getKey(), TradeType.TRADETYPE_PUTTING);
                continue;
            } else if (pList.containsKey(TradeType.TRADETYPE_DEPOSIT_INCOME)) {
                //保证金
                resultMap.put(entry.getKey(), TradeType.TRADETYPE_DEPOSIT_INCOME);
                continue;
            } else if (pList.containsKey(TradeType.TRADETYPE_DEPOSIT_RENT)){
                //保证金冲抵
                resultMap.put(entry.getKey(), TradeType.TRADETYPE_DEPOSIT_RENT);
                continue;
            } else if (pList.containsKey(TradeType.TRADETYPE_SRV_PAY)){
                //租赁服务费支出
                resultMap.put(entry.getKey(), TradeType.TRADETYPE_SRV_PAY);
                continue;
            } else if (pList.containsKey(TradeType.TRADETYPE_SRV_INCOME)){
                //租赁服务费收入
                resultMap.put(entry.getKey(), TradeType.TRADETYPE_SRV_INCOME);
                continue;
            } else if (!pList.containsKey(TradeType.TRADETYPE_DEPOSIT_INCOME) &&
                    pList.containsKey(TradeType.TRADETYPE_SRV_INCOME)) {
                //不包含保证金 包含手续费
                resultMap.put(entry.getKey(), TradeType.TRADETYPE_SRV_INCOME);
                continue;
            } else if (!pList.containsKey(TradeType.TRADETYPE_DEPOSIT_INCOME) &&
                    !pList.containsKey(TradeType.TRADETYPE_SRV_INCOME)) {
                resultMap.put(entry.getKey(), TradeType.TRADETYPE_BUSINESS_INCOME);
                continue;
            }
        }
        return resultMap;
    }

    /**
     * 结果集赋值
     */
    public void handleLeasePlan(List<LeasePlanVO> lease_plan_vat, Map resultMap, Map<String,LeasePlanVO> newMap){
        for(LeasePlanVO vatVO : lease_plan_vat){
            String code = vatVO.getTrans_type();
            String plan_Date = vatVO.getPlan_date();
            if (resultMap.containsKey(plan_Date)) {
                if (resultMap.get(plan_Date).equals(code)) {
                    LeasePlanVO finVO = newMap.get(plan_Date);
                    if (finVO != null){
                        vatVO.setDivide_cash(finVO.getLease_cash());
                        vatVO.setDivide_interest(finVO.getLease_interest());
                        vatVO.setDivide_corpus(finVO.getLease_corpus());
                        vatVO.setLease_cash_in(finVO.getLease_cash_in());
                        vatVO.setNo_tax_interest(finVO.getNo_tax_interest());
                        vatVO.setNo_tax_otherin(finVO.getNo_tax_otherin());
                        vatVO.setNo_tax_otherout(finVO.getNo_tax_otherout());
                        vatVO.setNo_tax_srvfee(finVO.getNo_tax_srvfee());
                        vatVO.setInput_tax(finVO.getInput_tax());
                        vatVO.setInput_tax_diff(finVO.getInput_tax_diff());
                        vatVO.setSum_tax(finVO.getSum_tax());
                        vatVO.setTax_mode(finVO.getTax_mode());
                        newMap.remove(plan_Date);
                    } else {
                        vatVO.setDivide_cash(BigDecimal.ZERO);
                        vatVO.setDivide_interest(BigDecimal.ZERO);
                        vatVO.setDivide_corpus(BigDecimal.ZERO);
                        vatVO.setLease_cash_in(BigDecimal.ZERO);
                        vatVO.setNo_tax_interest(BigDecimal.ZERO);
                        vatVO.setNo_tax_otherin(BigDecimal.ZERO);
                        vatVO.setNo_tax_otherout(BigDecimal.ZERO);
                        vatVO.setNo_tax_srvfee(BigDecimal.ZERO);
                        vatVO.setInput_tax(BigDecimal.ZERO);
                        vatVO.setInput_tax_diff(BigDecimal.ZERO);
                        vatVO.setSum_tax(BigDecimal.ZERO);
                        vatVO.setTax_mode(PubEnumsConstant.TAX_MODEL_VALUE_ADDED);
                    }
                }
            }
        }
    }

    /**
     * 会计分摊结果集封装
     */
    public List<InoutPlanVO> buildResultAccount(List<LeasePlanVO> lease_plan_vat, Map<String,LeasePlanVO> newMap, CalBusinessParam calBusi){
        //中投市场表   处理相同日期合并问题
        Map<String, Map> dataMap = new HashMap<String, Map>();
        for (LeasePlanVO planvo : lease_plan_vat) {
            if (dataMap.containsKey(planvo.getPlan_date())) {
                Map lists = dataMap.get(planvo.getPlan_date());
                lists.put(planvo.getTrans_type(), planvo);
                dataMap.put(planvo.getPlan_date(), lists);
            } else {
                Map newList = new HashMap();
                newList.put(planvo.getTrans_type(), planvo);
                dataMap.put(planvo.getPlan_date(), newList);
            }
        }
        //事件类别分类处理
        Map resultMap = handleEventType(dataMap);
        //结果集赋值
        handleLeasePlan(lease_plan_vat,resultMap, newMap);
        // 取出收支计划的事件类别
        Map<String, EventTypeRefVO> eventMap = getEventTypeMap();
        //封装收支计划
        List<InoutPlanVO> inout_plan_market = packageInout(lease_plan_vat,PubEnumsConstant.RENTTYPE_ACCOUNT,
                eventMap, PubEnumsConstant.MAKE_METHOD_SYS,calBusi.getPlan_date_loan());
        packageRentInoutPlan(inout_plan_market,calBusi.getPlan_date_loan());
        return inout_plan_market;
    }

    /**
     * 封装系统生成的收支计划
     * @return
     */
    public List<InoutPlanVO> packageInout(List<LeasePlanVO> lease_plan, Short RentType, Map<String, EventTypeRefVO> eventMap , Short MakeMethod , String begin_Date){
        List<InoutPlanVO> inout_plan = new ArrayList<InoutPlanVO>();
        // 本金是否开票
        Short if_corpus_tickets = Short.valueOf("0");
        for (LeasePlanVO planvo : lease_plan) {
            String code = planvo.getTrans_type();
            InoutPlanVO inoutplanvo = new InoutPlanVO();
            // 税种
            Short tax_mode = planvo.getTax_mode()!=null ? planvo.getTax_mode() : Short.valueOf("0");
            inoutplanvo.setTaxMode(tax_mode);
            inoutplanvo.setLeaseCash(BigDecimalUtils.defaultIfNull(planvo.getLease_cash()));
            inoutplanvo.setLeaseBalance(BigDecimalUtils.defaultIfNull(planvo.getLease_cash()));
            inoutplanvo.setCalDate(planvo.getCal_date());
            inoutplanvo.setPlanDate(planvo.getPlan_date());
            inoutplanvo.setDirection(planvo.getDirection());
            inoutplanvo.setCorpusBalance(BigDecimalUtils.defaultIfNull(planvo.getCorpus_balance()));
            inoutplanvo.setLeaseInterest(BigDecimalUtils.defaultIfNull(planvo.getLease_interest()));
            inoutplanvo.setLeaseCorpus(BigDecimalUtils.defaultIfNull(planvo.getLease_corpus()));
            inoutplanvo.setLeaseTime(planvo.getLease_time());
            EventTypeRefVO tradeRefVO = eventMap.get(code);
            inoutplanvo.setTransType(tradeRefVO);
            inoutplanvo.setDivideCash(planvo.getDivide_cash());
            inoutplanvo.setDivideInterest(planvo.getDivide_interest());
            inoutplanvo.setDivideCorpus(planvo.getDivide_corpus());
            inoutplanvo.setLeaseCashIn(planvo.getLease_cash_in());
            inoutplanvo.setNoTaxInterest(planvo.getNo_tax_interest());
            inoutplanvo.setNoTaxOtherin(planvo.getNo_tax_otherin());
            inoutplanvo.setNoTaxOtherout(planvo.getNo_tax_otherout());
            inoutplanvo.setNoTaxSrvfee(planvo.getNo_tax_srvfee());
            inoutplanvo.setInputTax(planvo.getInput_tax());
            inoutplanvo.setInputTaxDiff(planvo.getInput_tax_diff());
            inoutplanvo.setSumTax(planvo.getSum_tax());
            inoutplanvo.setLeaseCashFin(planvo.getLease_cash_fin());
            inoutplanvo.setLeaseInterestFin(planvo.getLease_interest_fin());
            inoutplanvo.setLeaseCorpusFin(planvo.getLease_corpus_fin());
            inoutplanvo.setCorpusBalanceFin(planvo.getCorpus_balance_fin());
            inoutplanvo.setLeaseCashTaxFin(BigDecimalUtils.defaultIfNull(planvo.getLease_cash_tax_fin()));
            inoutplanvo.setLeaseCorpusTaxFin(BigDecimalUtils.defaultIfNull(planvo.getLease_corpus_tax_fin()));
            inoutplanvo.setLeaseInterestTaxFin(BigDecimalUtils.defaultIfNull(planvo.getLease_interest_tax_fin()));

            if(MakeMethod == null){
                MakeMethod = PubEnumsConstant.MAKE_METHOD_HAND;
            }
            if(planvo.getMake_method() != null){
                inoutplanvo.setMakeMethod(planvo.getMake_method());
            } else {
                inoutplanvo.setMakeMethod(MakeMethod);
            }
            inoutplanvo.setRentType(RentType);
            inoutplanvo.setSrvfeeShare(BigDecimalUtils.defaultIfNull(planvo.getSrvfee_share()));
            inoutplanvo.setLeaseCashTax(BigDecimalUtils.defaultIfNull(planvo.getLease_cash_tax()));
            inoutplanvo.setLeaseCorpusTax(BigDecimalUtils.defaultIfNull(planvo.getLease_corpus_tax()));
            inoutplanvo.setLeaseInterestTax(BigDecimalUtils.defaultIfNull(planvo.getLease_interest_tax()));

            // 自动生成，如果计划日期为打标记的投放日期
            // 应该改为 主表投放日期
            if(begin_Date.equals(inoutplanvo.getPlanDate())
                    && MakeMethod.intValue() != PubEnumsConstant.MAKE_METHOD_HAND.intValue()
                    && !code.equals(TradeType.TRADETYPE_PUTTING)
                    && !code.equals(TradeType.TRADETYPE_PUTTING_BANK)
                    && !code.equals(TradeType.TRADETYPE_RENT)
                    && !code.equals(TradeType.TRADETYPE_NOTE_BANK)
                    && !code.equals(TradeType.TRADETYPE_DEPOSIT_BACK_BANK)
                    && !code.equals(TradeType.TRADETYPE_DEPOSIT_INTEREST_BANK)
                    && !code.equals(TradeType.TRADETYPE_DEPOSIT_INCOME_BANK)){
                inoutplanvo.setPlanDate(begin_Date);
            }

            if(UFDate.getDate(begin_Date).after(UFDate.getDate(planvo.getCal_date()))
                    && !code.equals(TradeType.TRADETYPE_PRICE)
                    && !code.equals(TradeType.BROKERAGE_IN)
                    && !code.equals(TradeType.INQUIRY_FEE)
            ){
                inoutplanvo.setCalDate(begin_Date);
            }
            inout_plan.add(inoutplanvo);

            if(planvo.getRight_date()!=null){
                inoutplanvo.setPlanDate(planvo.getRight_date());
            }

            if(planvo.getTrade_discount() != null ){
                inoutplanvo.setTradeDiscount(planvo.getTrade_discount());
            }

            if (planvo.getMake_method() != null
                    && planvo.getMake_method().compareTo(PubEnumsConstant.MAKE_METHOD_HAND) == 0) {
                inoutplanvo.setTaxRate(planvo.getTax_rate());
            } else {
                // 营业税税率为0
                if (tax_mode.compareTo(PubEnumsConstant.TAX_MODEL_SALES) == 0) {
                    inoutplanvo.setTaxRate(PubEnumsConstant.SRV_TAX_0);
                } else {
                    // 本金是否扣税为否时收付款税率为0 投放现金、商业折扣已通过 投放规则控制税率为0
                    // 租金暂时处理为17%
                    if (if_corpus_tickets.compareTo(PubEnumsConstant.IF_NO) == 0
                            && (code.equals(TradeType.TRADETYPE_FIRST)
                            || code.equals(TradeType.TRADETYPE_PUTTING)
                            || code.equals(TradeType.TRADETYPE_PUTTING_BANK))) {
                        //[营改增] wangjj@2016/05/24 UPD START 首付款按照 租金税率计算 和 投放金额按照投放计划上的税率计算
                        inoutplanvo.setTaxRate(planvo.getTax_rate());
                        //[营改增] wangjj@2016/05/24 UPD END
                    } else {
                        if (planvo.getTax_rate() == null) {
                            inoutplanvo.setTaxRate(PubEnumsConstant.SRV_TAX_17);
                        } else {
                            inoutplanvo.setTaxRate(planvo.getTax_rate());
                        }
                    }
                }
            }
            planvo.setTax_rate(inoutplanvo.getTaxRate());
        }

        return inout_plan;
    }

    /**
     * 重新封装收支计划，使其适应新的会计分摊显示
     * @param inout_plan_market
     */
    public void packageRentInoutPlan(List<?> inout_plan_market,String dateLoan){
        Map<String,String> eventCashMap = new HashMap<String,String>();
        Map<String,String> eventNameMap = new HashMap<String,String>();
        //投放日期
        UFDate dateLoanUF = new UFDate(dateLoan);
        if(inout_plan_market != null && inout_plan_market.size() > 0){
            for(Object obj : inout_plan_market){
                String planDate = "";
                String eventName = "";
                String eventType = "";
                BigDecimal leaseCash = BigDecimal.ZERO;
                if(obj instanceof InoutPlanPDO){
                    InoutPlanPDO vo = (InoutPlanPDO)obj;
                    planDate = vo.getPlanDate();
                    eventName = vo.getTransType().getEventName();
                    leaseCash = vo.getLeaseCash();
                    eventType = vo.getTransType().getCode();
                }

                UFDate planDateUF = new UFDate(planDate);

                if(planDateUF.before(dateLoanUF) && (eventType.equals(TradeType.TRADETYPE_RENT) ||
                        eventType.equals(TradeType.TRADETYPE_RENT_C) ||
                        eventType.equals(TradeType.TRADETYPE_RENT_BEFORE_INTEREST))) {
                    if(eventCashMap != null && eventCashMap.containsKey(dateLoan)){
                        String eventCash = eventCashMap.get(dateLoan);
                        eventCashMap.put(dateLoan, eventCash.concat("/").concat(eventName).concat(leaseCash.toString()));
                    } else {
                        eventCashMap.put(dateLoan, eventName.concat(leaseCash.toString()));
                    }
                    continue;
                }
                if(eventCashMap != null && eventCashMap.containsKey(planDate)){
                    String eventCash = eventCashMap.get(planDate);
                    eventCashMap.put(planDate, eventCash.concat("/").concat(eventName).concat(leaseCash.toString()));
                } else {
                    eventCashMap.put(planDate, eventName.concat(leaseCash.toString()));
                }
                if(eventNameMap != null && eventNameMap.containsKey(planDate)){
                    String eventNameStr = eventNameMap.get(planDate);
                    eventNameMap.put(planDate, eventNameStr.concat("/").concat(eventName));
                } else {
                    eventNameMap.put(planDate, eventName);
                }
            }
        }

        for(Object obj : inout_plan_market){
            if(obj instanceof InoutPlanPDO){
                InoutPlanPDO vo = (InoutPlanPDO)obj;
                if(vo.getRentType().equals(PubEnumsConstant.RENTTYPE_ACCOUNT) && vo.getDivideCash() != null){
                    String planDate = vo.getPlanDate();
                    if(eventCashMap.containsKey(planDate)){
                        vo.setRentMemo(eventCashMap.get(planDate));
                    } else {
                        vo.setRentMemo(null);
                    }

                    if(eventNameMap.containsKey(planDate)){
                        vo.setRentEventType(eventNameMap.get(planDate));
                    } else {
                        vo.setRentEventType(null);
                    }
                } else {
                    vo.setRentMemo(null);
                    vo.setRentEventType(null);
                }
            }
        }

    }

    /**
     *  获取收支计划表事件类别
     */
    public Map<String, EventTypeRefVO> getEventTypeMap () {
        List<EventTypeRefVO> eventTypeList = pubRefService.listEventTypeRef("EventRefQuery");
        Map<String, EventTypeRefVO> resultMap = new HashMap<String, EventTypeRefVO>();
        for (EventTypeRefVO eventType : eventTypeList) {
            resultMap.put(eventType.getCode(), eventType);
        }
        return resultMap;
    }


    /**
     * 特殊到期日计算
     *
     * @param calBusinessParam
     *            外围参数封装
     * @return
     */
    public static String getSpeFinalDate(CalBusinessParam calBusinessParam) {
        String temp_final_date = "";
        String plan_date_loan = calBusinessParam.getPlan_date_loan();// 投放日期

        // 延迟期（月）费率测算使用
        if(calBusinessParam.getDelay_month() != null){
            plan_date_loan= UFDate.getDate(plan_date_loan).getMonthAfter(Integer.valueOf(calBusinessParam.getDelay_month())).toString();
        }
        String plan2operating_date = null;
        if(calBusinessParam.getRentRuleCVO() != null){
            plan2operating_date = calBusinessParam.getRentRuleCVO().getPlan2operating_date();//转经营期日期
        }
        int lease_times = calBusinessParam.getRentRuleVO().getLease_times();//租赁月数
        Short plan_lease_date = calBusinessParam.getPlan_lease_date();//付款日
        String first_lease_date = calBusinessParam.getRentRuleVO().getFirst_lease_date();//首期收租时间
        Short prepay_or_not = calBusinessParam.getRentRuleVO().getPrepay_or_not();//先付后付
        List<LeasePlanSpVO> listSp = calBusinessParam.getLease_plan_sp() == null ? new ArrayList<LeasePlanSpVO>() : calBusinessParam.getLease_plan_sp();//租金规则
        int plan_times = 0;//期数
        if (prepay_or_not.intValue() == Prepay_Or_Not.PREPAY.getShort().intValue()) {
            plan_times = plan_times + 1;
        }
        if (first_lease_date != null) {
            plan_times = plan_times + 1;
        }
        boolean judge = false;//判断是否最跳出外层循环
        //计算项目实际有多少个月
        int change_month = 0;//变动月数
        int tempSumMonth = 0;//根据支付频率累计月
        for (int i = 0; i < listSp.size(); i++) {
            LeasePlanSpVO spVO = listSp.get(i);
            int begin_lease_time = spVO.getLease_time();//开始期次
            Short lease_period = spVO.getLease_freq();//支付频率
            int end_lease_time = 10000;//设定最大期次为10000期
            if (i != listSp.size() - 1) {
                end_lease_time = listSp.get(i + 1).getLease_time() - 1;
            }
            int tempFlag = BaseApp.getPaymentFrequency(lease_period);
            if (end_lease_time == 10000) {
                change_month = change_month - tempFlag * plan_times;
                int sumMonth = lease_times + change_month;
                while (true) {
                    tempSumMonth = tempSumMonth + tempFlag;
                    if (tempSumMonth - sumMonth >= tempFlag) {
                        change_month = change_month + tempSumMonth - sumMonth - tempFlag;
                        break;
                    }
                }
            } else {
                if (plan_times > end_lease_time) {
                    plan_times = plan_times - (end_lease_time - begin_lease_time + 1);
                    change_month = change_month - tempFlag * (end_lease_time - begin_lease_time + 1);
                } else {
                    change_month = change_month - plan_times * tempFlag;
                    int sumMonth = lease_times + change_month;
                    for (int j = 0; j < (end_lease_time - begin_lease_time + 1 - plan_times); j++) {
                        tempSumMonth = tempSumMonth + tempFlag;
                        if (tempSumMonth - sumMonth >= tempFlag) {
                            change_month = change_month + tempSumMonth - sumMonth - tempFlag;
                            judge = true;
                            break;
                        }
                    }
                    if (judge) {
                        break;
                    }
                    plan_times = 0;
                }
            }
        }
        //计算第一期,指定收租时间
        temp_final_date = plan_date_loan;//默认规则开始计算前的日期为投放日期
        if (plan2operating_date != null) {
            temp_final_date = plan2operating_date;
        }
        if (first_lease_date != null) {
            temp_final_date = first_lease_date;
        }
        //计算得到一个最大的项目截止日期
        temp_final_date = UFDate.getDate(temp_final_date).getMonthAfter(lease_times + change_month).toString();
        int days = UFDate.getDate(temp_final_date).getDaysMonth();
        if (days < plan_lease_date.intValue()) {
            temp_final_date = temp_final_date.split("-")[0] + "-" + temp_final_date.split("-")[1] + "-" + days;
        } else {
            temp_final_date = temp_final_date.split("-")[0] + "-" + temp_final_date.split("-")[1] + "-" + plan_lease_date.intValue();
        }

        return temp_final_date;
    }


    /**
     * 打印会计分摊结果表
     */
    public void printResultList(List<InoutPlanVO> list){
        logger.info("开始打印会计分摊结果---------------------------------------------------------");
        logger.info("-----日期---|---租金---|---会计本金---|---利息---|---租赁收入---|---去税租息---|---去税其他收入|---税金---|------------------------");
        for(Object obj : list){
            if(obj instanceof InoutPlanVO){
                InoutPlanVO vo = (InoutPlanVO)obj;
                String date = vo.getPlanDate();
                BigDecimal lease_cash = vo.getDivideCash();
                BigDecimal lease_interest = vo.getDivideInterest();
                BigDecimal lease_corpus = vo.getDivideCorpus();
                BigDecimal leaseCashIn = vo.getLeaseCashIn();
                BigDecimal noTaxInterest = vo.getNoTaxInterest();
                BigDecimal noTaxOtherin = vo.getNoTaxOtherin();
                BigDecimal sumTax = vo.getSumTax();
                logger.info("-----" + date + "   |   " + lease_cash + "   |   " + lease_corpus +"   |" +
                        "   " + lease_interest +"   |   " + leaseCashIn + "   |   " + noTaxInterest +"   |" +
                        "   " + noTaxOtherin +"   |   " + sumTax + "   |   " +"------------------------------");
            }
        }
        logger.info("-----------|---------|---------|---------|------------------------------------");
    }



}