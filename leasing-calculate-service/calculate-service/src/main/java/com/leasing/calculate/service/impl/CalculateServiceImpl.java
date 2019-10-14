package com.leasing.calculate.service.impl;

import com.leasing.calculate.repository.CalculatorRepository;
import com.leasing.calculate.service.CalculateService;
import com.leasing.calculate.entity.CalculatorVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lvcn on 2019-9-19.
 */
@Service("calculateService")
public class CalculateServiceImpl implements CalculateService {

    @Resource
    CalculatorRepository calculatorRepository;

    @Override
    public void save(CalculatorVO vo) {
//        if (vo.getPrimaryKey() == null) {
//            vo.setPk_lease_calculator(getOID());
//            //关联编号
//            vo.setPk_initial(getOID());
//            vo.setOperate_date(getCurDate());
//            vo.setOperate_time(getCurDateTime());
//            vo.setBillstatus(Billstatus.INITALIZE.getShort());// 初始
//            //vo.setPk_dept(getClientENV().getPk_dept()); //部门
//            if(StringUtils.isBlank(vo.getQuot_code())){
//                // 测算方案编码
//                CodeRuleUtil codeRuleUtil = new CodeRuleUtil();
//                Map map = new HashMap();
//                map.put(CodeRuleKey.FUN_CODE, getClientENV().getValue("funCode"));
//                map.put(CodeRuleKey.VARIABLE_NAME, CodeRuleKey.PK_LEASECAL_CODE);
//                map.put(CodeRuleKey.OPERATOR, getClientENV().getCurUser().getName());
//                String quot_code = codeRuleUtil.getCodeRule(map);
//                vo.setQuot_code(quot_code);
//            }
//            if(ObjectUtil.isEmpty(vo.getCal_type())){
//                vo.setCal_type(PubEnumsConstant.CAL_TYPE_RENT);
//            }
//            if(vo.getPk_currtype() == null){
//                // 币种 人民币
//                vo.setPk_currtype(YLSConstant.RMB);
//            }
//            if(vo.getPk_exchg_rate() == null){
//                // 汇率 1
//                vo.setPk_exchg_rate(BigDecimal.ONE);
//            }
//            /**
//             * lvcn 20181113 设置算法默认版本,新报价统一按此版本进行计算
//             */
//            vo.setCal_version(PubEnumsConstant.cal_independent_event);
//        }
//
//        if(vo.getIf_fixday().intValue()==PubEnumsConstant.IF_YES.intValue()) {
//            FixedChoseRefVO ref=vo.getPk_fixed_chose();
//            String plandate = vo.getPlan_date_loan();
//            String []splits=plandate.split("-");
//            String day=splits[2];
//            if(day.length()>1&&day.charAt(0)=='0') {
//                day=String.valueOf(day.charAt(1));
//            }
//            if(ref.getFixday_one().intValue()!=Integer.parseInt(day)&&ref.getFixday_two().intValue()!=Integer.parseInt(day)) {
//                throw new BusinessException("“固定收租日”报价信息的“投放日期”需落在固定的收租日上，请重新维护投放日期！");
//            }
//        }
//
//
//        if(StringUtils.isBlank(vo.getQuot_name())){
//            vo.setQuot_name(vo.getQuot_code());
//        }
//        if(vo.getCalinterest_amount_style() == null){
//            vo.setCalinterest_amount_style(PubEnumsConstant.CALINTEREST_STLYE_ZERO);
//        }
//
//        /**
//         * 目前算法不支持多次投放多次起息,前台屏蔽掉 "按已投放本金" 选项,之后再考虑这种算法。
//         */
//        if(PubEnumsConstant.CALINTEREST_STLYE_ONE.intValue() == vo.getCalinterest_amount_style().intValue()){
//            //getCalResultOne(vo,true,SourcebillTypeConstant.BILLTYPE_CALCULATOR);
//        }else{
//            getCalResult(vo,true);
//        }
//        /** INSERT  【sijd】 【Dec 6, 2017】 【BUG修改】<BUG号 ZTYW-1000号> */
//        List<LeaseLoanPlanVO> loanPlan = vo.getLease_loan_plan();
//        for(Iterator iter = loanPlan.iterator();iter.hasNext();){
//            LeaseLoanPlanPVO leaseLoanPlanPVO = (LeaseLoanPlanPVO)iter.next();
//            if(BigDecimal.ZERO.compareTo(leaseLoanPlanPVO.getPlan_cash_loan())==0
//                    &&BigDecimal.ZERO.compareTo(leaseLoanPlanPVO.getPlan_cash_corpus())==0
//                    &&BigDecimal.ZERO.compareTo(leaseLoanPlanPVO.getTax_cash())==0){
//                throw new BusinessException("不允许金额为0.00的收支计划中，请修改！");
//            }
//        }
//        Set depositPlan = vo.getInout_plan_deposit();
//        for(Iterator iter = depositPlan.iterator();iter.hasNext();){
//            InoutPlanVO inoutPlanVO = (InoutPlanVO)iter.next();
//            if(BigDecimal.ZERO.compareTo(BigDecimalUtils.defaultIfNull(inoutPlanVO.getLease_cash()))==0
//                    &&BigDecimal.ZERO.compareTo(BigDecimalUtils.defaultIfNull(inoutPlanVO.getLease_corpus()))==0
//                    &&BigDecimal.ZERO.compareTo(BigDecimalUtils.defaultIfNull(inoutPlanVO.getLease_interest()))==0){
//                throw new BusinessException("不允许金额为0.00的收支计划中，请修改！");
//            }
//        }
//        Set srvinPlan = vo.getInout_plan_srvin();
//        for(Iterator iter = srvinPlan.iterator();iter.hasNext();){
//            InoutPlanVO inoutPlanVO = (InoutPlanVO)iter.next();
//            if(BigDecimal.ZERO.compareTo(BigDecimalUtils.defaultIfNull(inoutPlanVO.getLease_cash()))==0
//                    &&BigDecimal.ZERO.compareTo(BigDecimalUtils.defaultIfNull(inoutPlanVO.getLease_corpus()))==0
//                    &&BigDecimal.ZERO.compareTo(BigDecimalUtils.defaultIfNull(inoutPlanVO.getLease_interest()))==0){
//                throw new BusinessException("不允许金额为0.00的收支计划中，请修改！");
//            }
//        }
//        Set srvoutPlan = vo.getInout_plan_srvot();
//        for(Iterator iter = srvoutPlan.iterator();iter.hasNext();){
//            InoutPlanVO inoutPlanVO = (InoutPlanVO)iter.next();
//            if(BigDecimal.ZERO.compareTo(BigDecimalUtils.defaultIfNull(inoutPlanVO.getLease_cash()))==0
//                    &&BigDecimal.ZERO.compareTo(BigDecimalUtils.defaultIfNull(inoutPlanVO.getLease_corpus()))==0
//                    &&BigDecimal.ZERO.compareTo(BigDecimalUtils.defaultIfNull(inoutPlanVO.getLease_interest()))==0){
//                throw new BusinessException("不允许金额为0.00的收支计划中，请修改！");
//            }
//        }
//        Set otherPlan = vo.getInout_plan_other();
//        for(Iterator iter = otherPlan.iterator();iter.hasNext();){
//            InoutPlanVO inoutPlanVO = (InoutPlanVO)iter.next();
//            if(BigDecimal.ZERO.compareTo(BigDecimalUtils.defaultIfNull(inoutPlanVO.getLease_cash()))==0
//                    &&BigDecimal.ZERO.compareTo(BigDecimalUtils.defaultIfNull(inoutPlanVO.getLease_corpus()))==0
//                    &&BigDecimal.ZERO.compareTo(BigDecimalUtils.defaultIfNull(inoutPlanVO.getLease_interest()))==0){
//                throw new BusinessException("不允许金额为0.00的收支计划中，请修改！");
//            }
//        }
//        Set inoutPlan = vo.getInout_plan();
//        for(Iterator iter = inoutPlan.iterator();iter.hasNext();){
//            InoutPlanVO inoutPlanVO = (InoutPlanVO)iter.next();
//            if(BigDecimal.ZERO.compareTo(BigDecimalUtils.defaultIfNull(inoutPlanVO.getLease_cash()))==0
//                    &&BigDecimal.ZERO.compareTo(BigDecimalUtils.defaultIfNull(inoutPlanVO.getLease_corpus()))==0
//                    &&BigDecimal.ZERO.compareTo(BigDecimalUtils.defaultIfNull(inoutPlanVO.getLease_interest()))==0){
//                throw new BusinessException("不允许金额为0.00的收支计划中，请修改！");
//            }
//        }
//        /** INSERT  END */
//
//
//        //重新加载vo
//        getHibernateTemplate().saveOrUpdate(vo);
//        getHibernateTemplate().flush();
//
//        InoutPlanUtils.reInoutplan(vo);
//        getHibernateTemplate().flush();
//        UpdateFactInitial(vo);
//        // 服务费按年汇总计算
//        if(PubEnumsConstant.CALINTEREST_STLYE_ONE.intValue() != vo.getCalinterest_amount_style().intValue()){
//            (new CountSrvfeeSumUtils()).getAccrual(vo,SourcebillTypeConstant.BILLTYPE_CALCULATOR,CommonAbstractBO.buildParamByRuuning(RunParamConstant.ACCRUAL_WAY));
//        }
//        //更新收支计划（除收租，投放外）中关联投放主键
//        updateInoutPlanLoan(vo);
//        String limitMessage = transferOgnlValue(vo,PubEnumsConstant.CONTROL_TYPE_HARD);
//        if (limitMessage != null && limitMessage.length() != 0) {
//            throw new BusinessException(limitMessage);
//        }
//        /*
//         * 报价变动是否影响账户变动，项目合同节点调用。
//         * 如果报价被项目或者合同关联，则调用该方法。
//         */
//        if (vo.getPk_project_info() != null || vo.getPk_contract() != null) {
//            // 收支计划表
//            if(vo.getPk_contract()!=null){
//                addPkContract(vo.getPk_contract().getPk(), vo.getPrimaryKey());
//                buildAccount(vo.getPk_lease_calculator(),vo.getPk_contract().getPk(), vo.getInout_plan_market());
//            }else{
//                buildAccount(vo.getPk_lease_calculator(),"", vo.getInout_plan_market());
//            }
//        }
//        /*add by jiaoshy 同步咨询费IRR 2017-11-28*/
//        synConsultIRR(vo);
//        /*add end*/
        calculatorRepository.save(vo);
    }

    @Override
    public List<CalculatorVO> query() {
        int pageIndex = 1;// 前台传过来的当前页
        int pageSize = 100;// 每页需要的记录数
        /**
         * 不带排序写法: Pageable pageable = new PageRequest(pageIndex, pageSize);
         */
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "ts");
        Sort sort = new Sort(order);
        Pageable pageable = new PageRequest(pageIndex - 1, pageSize, sort);
        Page<CalculatorVO> page = calculatorRepository.findAll(pageable);
        List<CalculatorVO> list = page.getContent();
        return list;
    }

    @Override
    public List<CalculatorVO> findAll(){ return calculatorRepository.findAll(); }

    @Override
    public CalculatorVO findById(String id){ return calculatorRepository.findById(id).get(); };

    @Override
    public void update(CalculatorVO vo) {
        calculatorRepository.saveAndFlush(vo);
    }

    @Override
    public void deleteById(String id) {
        calculatorRepository.deleteById(id);
    }

    @Override
    public List<CalculatorVO> findLike(String name) {
        return calculatorRepository.findLike(name);
    }

    @Override
    public List<CalculatorVO> findByTs(String ts) {
        return calculatorRepository.findByTs(ts);
    }
}
