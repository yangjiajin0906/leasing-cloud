package com.leasing.common.entity.calculate.vo.cal;

import com.leasing.common.entity.calculate.vo.base.LeaseLoanPlanVO;
import com.leasing.common.entity.calculate.vo.base.LeasePlanVO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019/11/5
 * @author:Yjj@yonyou.com
 * @description: 核心算法和界面的接口参数类
 **/
public class CalBusinessParam {
    /**
     * 服务费参数封装，包括支出和收入
     */
    public ParamServiceRule serviceVO;

    /**
     * 正常收租参数封装
     */
    public ParamRentRule rentRuleVO;

    /**
     * 在建期参数封装
     */
    public ParamRentRuleC rentRuleCVO;

    /**
     * 保证金参数封装
     */
    public ParamDepositRule depositRuleVO;

    /**
     * 远期支付参数封装
     */
    public ParamForwardPayment forwardPaymentVO;

    /**
     * 不规则参数封装
     */
    public ParamIrregularVO irregularVO;
    /**
     * 业务类型
     */
    public Short trade_type;

    /**
     * 计划投放日期 -测算开始日期
     */
    public String plan_date_loan;

    /**
     * 计划投放金额
     */
    public BigDecimal plan_cash_loan;

    /**
     * 首付款的金额
     */
    public BigDecimal first_payment;

    /**
     * 计划收租日  - 1-31
     */
    public Short plan_lease_date;

    /**
     * 项目预计到期日,一般可以默认不填，系统自动计算
     * 项目执行过程中，必须填，与flag_final_date配合使用
     */
    public String final_date;

    /**
     * 项目到期日是否重新计算
     *  YES为重新计算,NO为不做任何处理
     */
    public Short flag_final_date;

    /**
     * 年计算天数
     */
    public Short year_days;

    /**
     * 计算精度  -针对收租有效
     */
    public Short cal_digit;

    /**
     * 保证金到期日
     */
    public String end_date_depos;

    /**
     * 调息类别
     */
    public Short interate_type_adj;

    /**
     * 利息补差期数 -针对提前收租的项目
     */
    public Integer interrate_term;

    /**
     * 利息补差金额 -针对提前收租的项目
     */
    public BigDecimal interrate_amount;

    /**
     * 是否保留现有收支计划true 保留,false不保留
     * 只是保留时间
     */
    public Short cal_plan;

    /**
     * irr计算方式 -使用计算日期还是计划日期
     */
    public Short irr_cal_type;

    /**
     * irr计算天数-使用360还是365
     */
    public Short irr_days;

    /**
     * irr年利率计算方式 - 是日*360还是日*365
     */
    public Short day_value;

    /**
     * 延迟期（月）
     */
    public Integer delay_month;

    /**
     * 延迟期（日）
     */
    public Integer delay_day;

    /**
     * 宽限期（月）
     */
    public Integer grace_month;
    /**
     * 错误信息
     */
    public Short errorMessage;
    /**
     * 商业折扣
     */
    public BigDecimal tradeDiscount;
    /**
     * 会计表是否重算
     * yes为重算，默认为yes
     */
    public Short table_yn;
    /**
     * 延迟日期
     */
    public String delay_date;

    /**
     * 特殊期类别
     */
    public Short special_type;

    /**
     * 是否老系统报价测算
     */
    public boolean if_old_sys_calc;

    /**
     * 老系统报价测算去税去租息是否给其它支出去税
     *
     */
    public boolean if_old_other_fax;
    /**
     * 报价投放计划
     */
    public List<LeaseLoanPlanVO> lease_loan_plan;
    /**
     * 报价投放计划(去除计息金额方式为‘无’的投放计划)
     */
    public List<LeaseLoanPlanVO> newLease_loan_plan;
    /**
     * 租金收取特殊设置
     */
    public List<LeasePlanSpVO>  lease_plan_sp;
    /**
     * 收支计划-系统生成的收支计划（包括收租，服务费，保证金等）  业务
     */
    public List<LeasePlanVO> lease_plan_vat;

//    /**
//     * 收支计划-系统生成的收支计划（包括收租，服务费，保证金等）  财务
//     */
//    public List<LeasePlanVO> lease_plan_vat_fin;

    /**
     * 收支计划(其他收支)
     * 如需要系统计算日期，期次必须填，日期自动计算
     */
    public List<LeasePlanVO> lease_plan_auto;

    /**
     * 服务费收支计划（收入）
     * 如需要系统计算日期，期次必须填，日期自动计算
     */
    public List<LeasePlanVO> lease_plan_srv;
    /**
     * 服务费收支计划（支出）
     * 如需要系统计算日期，期次必须填，日期自动计算
     */
    public List<LeasePlanVO> lease_plan_srv_out;

    /**
     * 保证金收支计划
     * 如需要系统计算日期，期次必须填，日期自动计算
     * 如果是冲抵最后几期租金，必须传入
     */
    public List<LeasePlanVO> lease_plan_deposit;

    /**
     * 租金调息设置
     */
    public List<LeaseInterestAdjVO> lease_interest_adj;

    /**
     * 倒算结果IRR
     */
    public BigDecimal final_irr;

    /**
     * 手续费IRR
     */
    public BigDecimal srvfee_irr;

    /**
     * 租赁方式
     */
    public Short lease_method;

    /**
     * 本金是否开票
     */
    public Short if_corpus_tickets;
    /**
     * 税种
     */
    public Short tax_mode;

    /**
     * 计算比例基数
     */
    public Short cal_ratio_base;

    /**
     * 不规则-本金为负是否调整为0
     */
    public Short corpus_adjust_zero;

    /**
     * 本金为负调整（江租）
     */
    public Short corpus_adjust_zero_jz;

    /**
     * 不规则-单利法、复利法
     */
    public Short corpus_way;

    /**
     * 是否全为指定租金
     */
    public Boolean isAllRentSpe;

    /**
     * 日利息金额处理方式
     */
    public Boolean date_interest;

    /**
     * 税率(服务费收入税率)
     */
    public BigDecimal tax_rate_srvin;
    /**
     * 税率(服务费支出税率)
     */
    public BigDecimal tax_rate_srvout;

    /**
     * 留购价
     */
    public BigDecimal tax_rate_srvin_remain;


    public BigDecimal getTax_rate_srvin_remain() {
        return tax_rate_srvin_remain;
    }

    public void setTax_rate_srvin_remain(BigDecimal tax_rate_srvin_remain) {
        this.tax_rate_srvin_remain = tax_rate_srvin_remain;
    }

    /**
     * 会计irr(中投使用)
     */
    public BigDecimal finance_irr;
    /**
     * 利息是否放在下一期
     */
    public boolean if_adj_next_interest;

    /**
     *
     * 是否自动生成名义货价
     *
     */
    public Boolean if_nominal_price;

    /**
     * 风险金起始收取日期
     */
    public String deposit_start_date;

    /**
     * 最后期收租日计算方式
     */
    public Boolean endDate_type;


    /**
     * 租金表类型
     */
    public Short rent_table_type;

    /**
     * 本次投放之前的租金计划表
     */
    public List inout_plan_beforeLoan;


    /**
     * 收支计划计划日期
     */
    public List planDateList;

    /**
     * 计划投放日期的getter方法
     *
     * @return String
     */
    public String getPlan_date_loan() {
        return plan_date_loan;
    }

    /**
     * 计划投放日期的setter方法
     *
     * @param plan_date_loan 计划投放日期
     */
    public void setPlan_date_loan(String plan_date_loan) {
        this.plan_date_loan = plan_date_loan;
    }

    /**
     * 计划投放金额的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getPlan_cash_loan() {
        return plan_cash_loan;
    }

    /**
     * 计划投放金额的setter方法
     *
     * @param plan_cash_loan 计划投放金额
     */
    public void setPlan_cash_loan(BigDecimal plan_cash_loan) {
        this.plan_cash_loan = plan_cash_loan;
    }

    /**
     * 项目预计到期日,一般可以默认不填，系统自动计算
     * 项目执行过程中，必须填，与flag_final_date配合使用
     *
     * @return String
     */
    public String getFinal_date() {
        return final_date;
    }

    /**
     * 项目预计到期日,一般可以默认不填，系统自动计算
     * 项目执行过程中，必须填，与flag_final_date配合使用
     *
     * @param final_date 项目预计到期日
     */
    public void setFinal_date(String final_date) {
        this.final_date = final_date;
    }



    /**
     * 计划收租日
     * @return
     */
    public Short getPlan_lease_date() {
        return plan_lease_date;
    }

    /**
     * 计划收租日
     * @param plan_lease_date
     */
    public void setPlan_lease_date(Short plan_lease_date) {
        this.plan_lease_date = plan_lease_date;
    }


    /**
     * 年计算天数的getter方法
     *
     * @return Short
     */
    public Short getYear_days() {
        return year_days;
    }

    /**
     * 年计算天数的setter方法
     *
     * @param year_days 年计算天数
     */
    public void setYear_days(Short year_days) {
        this.year_days = year_days;
    }

    /**
     * 计算精度的getter方法
     *
     * @return Short
     */
    public Short getCal_digit() {
        return cal_digit;
    }

    /**
     * 计算精度的setter方法
     *
     * @param cal_digit 计算精度
     */
    public void setCal_digit(Short cal_digit) {
        this.cal_digit = cal_digit;
    }

    /**
     * 保证金到期日的getter方法
     *
     * @return String
     */
    public String getEnd_date_depos() {
        return end_date_depos;
    }

    /**
     * 保证金到期日的setter方法
     *
     * @param end_date_depos 保证金到期日
     */
    public void setEnd_date_depos(String end_date_depos) {
        this.end_date_depos = end_date_depos;
    }
    /**
     * 报价投放计划
     * @return
     */
    public List<LeaseLoanPlanVO> getLease_loan_plan() {
        return lease_loan_plan;
    }
    /**
     * 报价投放计划
     * @param lease_loan_plan
     */
    public void setLease_loan_plan(List<LeaseLoanPlanVO> lease_loan_plan) {
        this.lease_loan_plan = lease_loan_plan;
    }
    /**
     * 租金收取特殊设置
     * @return
     */
    public List<LeasePlanSpVO> getLease_plan_sp() {
        return lease_plan_sp;
    }
    /**
     * 租金收取特殊设置
     * @param lease_plan_sp
     */
    public void setLease_plan_sp(List<LeasePlanSpVO> lease_plan_sp) {
        this.lease_plan_sp = lease_plan_sp;
    }
    /**
     * 收支计划-系统生成的收支计划（包括收租，服务费，保证金等）
     * @return
     */
    public List<LeasePlanVO> getLease_plan_vat() {
        return lease_plan_vat;
    }
    /**
     * 收支计划-系统生成的收支计划（包括收租，服务费，保证金等）
     * @param lease_plan_vat
     */
    public void setLease_plan_vat(List<LeasePlanVO> lease_plan_vat) {
        this.lease_plan_vat = lease_plan_vat;
    }
    /**
     * 收支计划(其他收支)
     * 如需要系统计算日期，期次必须填，日期自动计算
     * @return
     */
    public List<LeasePlanVO> getLease_plan_auto() {
        return lease_plan_auto;
    }
    /**
     * 收支计划(其他收支)
     * 如需要系统计算日期，期次必须填，日期自动计算
     * @param lease_plan_auto
     */
    public void setLease_plan_auto(List<LeasePlanVO> lease_plan_auto) {
        this.lease_plan_auto = lease_plan_auto;
    }
    /**
     * 租金调息设置
     * @return
     */
    public List<LeaseInterestAdjVO> getLease_interest_adj() {
        return lease_interest_adj;
    }
    /**
     * 租金调息设置
     * @param lease_interest_adj
     */
    public void setLease_interest_adj(List<LeaseInterestAdjVO> lease_interest_adj) {
        this.lease_interest_adj = lease_interest_adj;
    }
    /**
     * 调息类别
     * @return
     */
    public Short getInterate_type_adj() {
        return interate_type_adj;
    }
    /**
     * 调息类别
     * @param interate_type_adj
     */
    public void setInterate_type_adj(Short interate_type_adj) {
        this.interate_type_adj = interate_type_adj;
    }

    /**
     * 是否保留现有收支计划yes 保留,no不保留
     * @return
     */
    public Short getCal_plan() {
        return cal_plan;
    }
    /**
     * 是否保留现有收支计划yes 保留,no不保留
     * @param cal_plan
     */
    public void setCal_plan(Short cal_plan) {
        this.cal_plan = cal_plan;
    }
    /**
     * 服务费收支计划
     * 如需要系统计算日期，期次必须填，日期自动计算
     * @return
     */
    public List<LeasePlanVO> getLease_plan_srv() {
        return lease_plan_srv;
    }
    /**
     * 服务费收支计划
     * 如需要系统计算日期，期次必须填，日期自动计算
     * @param lease_plan_srv
     */
    public void setLease_plan_srv(List<LeasePlanVO> lease_plan_srv) {
        this.lease_plan_srv = lease_plan_srv;
    }
    /**
     * 利息补差期数
     * @return
     */
    public Integer getInterrate_term() {
        return interrate_term;
    }
    /**
     * 利息补差期数
     * @param interrate_term
     */
    public void setInterrate_term(Integer interrate_term) {
        this.interrate_term = interrate_term;
    }
    /**
     * 利息补差金额
     * @return
     */
    public BigDecimal getInterrate_amount() {
        return interrate_amount;
    }
    /**
     * 利息补差金额
     * @param interrate_amount
     */
    public void setInterrate_amount(BigDecimal interrate_amount) {
        this.interrate_amount = interrate_amount;
    }

    /**
     * 业务类型
     * @return
     */
    public Short getTrade_type() {
        return trade_type;
    }
    /**
     * 业务类型
     * @param trade_type
     */
    public void setTrade_type(Short trade_type) {
        this.trade_type = trade_type;
    }

    /**
     * irr计算方式
     * @return
     */
    public Short getIrr_cal_type() {
        return irr_cal_type;
    }
    /**
     * irr计算方式
     * @param irr_cal_type
     */
    public void setIrr_cal_type(Short irr_cal_type) {
        this.irr_cal_type = irr_cal_type;
    }

    /**
     * 项目到期日是否重新计算
     *  TRUE为重新计算,FALSE为不做任何处理
     * @return
     */
    public Short getFlag_final_date() {
        return flag_final_date;
    }
    /**
     * 项目到期日是否重新计算
     *  TRUE为重新计算,FALSE为不做任何处理
     * @return
     */
    public void setFlag_final_date(Short flag_final_date) {
        this.flag_final_date = flag_final_date;
    }
    /**
     * irr计算天数-使用360还是365
     * @return
     */
    public Short getIrr_days() {
        return irr_days;
    }
    /**
     * irr计算天数-使用360还是365
     * @param irr_days
     */
    public void setIrr_days(Short irr_days) {
        this.irr_days = irr_days;
    }
    /**
     * irr年利率计算方式 - 是日*360还是日*365
     * @return
     */
    public Short getDay_value() {
        return day_value;
    }
    /**
     * irr年利率计算方式 - 是日*360还是日*365
     * @param day_value
     */
    public void setDay_value(Short day_value) {
        this.day_value = day_value;
    }
    /**
     * 错误信息
     * @return
     */
    public Short getErrorMessage() {
        return errorMessage;
    }
    /**
     * 错误信息
     * @param errorMessage
     */
    public void setErrorMessage(Short errorMessage) {
        this.errorMessage = errorMessage;
    }
    /**
     * 服务费参数封装，包括支出和收入
     * @return
     */
    public ParamServiceRule getServiceVO() {
        return serviceVO;
    }
    /**
     * 服务费参数封装，包括支出和收入
     * @param serviceVO
     */
    public void setServiceVO(ParamServiceRule serviceVO) {
        this.serviceVO = serviceVO;
    }
    /**
     * 正常收租参数封装
     * @return
     */
    public ParamRentRule getRentRuleVO() {
        return rentRuleVO;
    }
    /**
     * 正常收租参数封装
     * @param rentRuleVO
     */
    public void setRentRuleVO(ParamRentRule rentRuleVO) {
        this.rentRuleVO = rentRuleVO;
    }
    /**
     * 在建期参数封装
     * @return
     */
    public ParamRentRuleC getRentRuleCVO() {
        return rentRuleCVO;
    }
    /**
     * 在建期参数封装
     * @param rentRuleCVO
     */
    public void setRentRuleCVO(ParamRentRuleC rentRuleCVO) {
        this.rentRuleCVO = rentRuleCVO;
    }
    /**
     * 保证金参数封装
     * @return
     */
    public ParamDepositRule getDepositRuleVO() {
        return depositRuleVO;
    }
    /**
     * 保证金参数封装
     * @param depositRuleVO
     */
    public void setDepositRuleVO(ParamDepositRule depositRuleVO) {
        this.depositRuleVO = depositRuleVO;
    }

    /**
     * 延迟期（月）
     * @return
     */
    public Integer getDelay_month() {
        return delay_month;
    }

    /**
     * 延迟期（月）
     * @param delay_month
     */
    public void setDelay_month(Integer delay_month) {
        this.delay_month = delay_month;
    }

    /**
     * 宽限期（月）
     * @return
     */
    public Integer getGrace_month() {
        return grace_month;
    }

    /**
     * 宽限期（月）
     * @param grace_month
     */
    public void setGrace_month(Integer grace_month) {
        this.grace_month = grace_month;
    }

    /**
     * 远期支付
     * @return
     */
    public ParamForwardPayment getForwardPaymentVO() {
        return forwardPaymentVO;
    }

    /**
     * 远期支付
     * @param forwardPaymentVO
     */
    public void setForwardPaymentVO(ParamForwardPayment forwardPaymentVO) {
        this.forwardPaymentVO = forwardPaymentVO;
    }
    /**
     * 保证金收支计划
     * 如需要系统计算日期，期次必须填，日期自动计算
     * 如果是冲抵最后几期租金，必须传入
     * @return
     */
    public List<LeasePlanVO> getLease_plan_deposit() {
        return lease_plan_deposit;
    }
    /**
     * 保证金收支计划
     * 如需要系统计算日期，期次必须填，日期自动计算
     * 如果是冲抵最后几期租金，必须传入
     * @param lease_plan_deposit
     */
    public void setLease_plan_deposit(List<LeasePlanVO> lease_plan_deposit) {
        this.lease_plan_deposit = lease_plan_deposit;
    }

    /**
     * 不规则参数封装
     * @return
     */
    public ParamIrregularVO getIrregularVO() {
        return irregularVO;
    }

    /**
     * 不规则参数封装
     * @param irregularVO
     */
    public void setIrregularVO(ParamIrregularVO irregularVO) {
        this.irregularVO = irregularVO;
    }

    /**
     * 首付款金额
     * @return
     */
    public BigDecimal getFirst_payment() {
        if(first_payment == null){
            return BigDecimal.ZERO;
        } else {
            return first_payment;
        }

    }

    /**
     * 首付款金额
     * @param first_payment
     */
    public void setFirst_payment(BigDecimal first_payment) {
        this.first_payment = first_payment;
    }

    /**
     * 倒算结果IRR
     * @return
     */
    public BigDecimal getFinal_irr() {
        return final_irr;
    }

    /**
     * 倒算结果IRR
     * @param final_irr
     */
    public void setFinal_irr(BigDecimal final_irr) {
        this.final_irr = final_irr;
    }
//    /**
//     * 收支计划-系统生成的收支计划（包括收租，服务费，保证金等）  财务
//     * @return
//     */
//    public List<LeasePlanVO> getLease_plan_vat_fin() {
//        return lease_plan_vat_fin;
//    }
//
//    /**
//     * 收支计划-系统生成的收支计划（包括收租，服务费，保证金等）  财务
//     * @param lease_plan_vat_fin
//     */
//    public void setLease_plan_vat_fin(List<LeasePlanVO> lease_plan_vat_fin) {
//        this.lease_plan_vat_fin = lease_plan_vat_fin;
//    }

    /**
     * 商业折扣
     * @return
     */
    public BigDecimal getTradeDiscount() {
        return tradeDiscount;
    }
    /**
     * 商业折扣
     * @param tradeDiscount
     */
    public void setTradeDiscount(BigDecimal tradeDiscount) {
        this.tradeDiscount = tradeDiscount;
    }

    /**
     * @return the lease_method
     */
    public Short getLease_method() {
        return lease_method;
    }

    /**
     * @param lease_method the lease_method to set
     */
    public void setLease_method(Short lease_method) {
        this.lease_method = lease_method;
    }


    /**
     * @return the srvfee_irr
     */
    public BigDecimal getSrvfee_irr() {
        return srvfee_irr;
    }

    /**
     * @param srvfee_irr the srvfee_irr to set
     */
    public void setSrvfee_irr(BigDecimal srvfee_irr) {
        this.srvfee_irr = srvfee_irr;
    }

    /**
     * @return the tax_mode
     */
    public Short getTax_mode() {
        return tax_mode;
    }

    /**
     * @param tax_mode the tax_mode to set
     */
    public void setTax_mode(Short tax_mode) {
        this.tax_mode = tax_mode;
    }

    public Short getCal_ratio_base() {
        return cal_ratio_base;
    }

    public void setCal_ratio_base(Short cal_ratio_base) {
        this.cal_ratio_base = cal_ratio_base;
    }

    /**
     * 会计表是否重算
     * yes为重算，默认为yes
     */
    public Short getTable_yn() {
        return table_yn;
    }

    /**
     * 会计表是否重算
     * yes为重算，默认为yes
     */
    public void setTable_yn(Short table_yn) {
        this.table_yn = table_yn;
    }

    /**
     * @return the corpus_adjust_zero
     */
    public Short getCorpus_adjust_zero() {
        return corpus_adjust_zero;
    }

    /**
     * @param corpus_adjust_zero the corpus_adjust_zero to set
     */
    public void setCorpus_adjust_zero(Short corpus_adjust_zero) {
        this.corpus_adjust_zero = corpus_adjust_zero;
    }

    /**
     * @return the corpus_way
     */
    public Short getCorpus_way() {
        return corpus_way;
    }

    /**
     * @param corpus_way the corpus_way to set
     */
    public void setCorpus_way(Short corpus_way) {
        this.corpus_way = corpus_way;
    }

    /**
     * @return the delay_day
     */
    public Integer getDelay_day() {
        if(delay_day != null){
            return delay_day;
        } else {
            return Integer.valueOf(0);
        }

    }

    /**
     * @param delay_day the delay_day to set
     */
    public void setDelay_day(Integer delay_day) {
        this.delay_day = delay_day;
    }

    /**
     * @return the lease_plan_srv_out
     */
    public List<LeasePlanVO> getLease_plan_srv_out() {
        return lease_plan_srv_out;
    }

    /**
     * @param lease_plan_srv_out the lease_plan_srv_out to set
     */
    public void setLease_plan_srv_out(List<LeasePlanVO> lease_plan_srv_out) {
        this.lease_plan_srv_out = lease_plan_srv_out;
    }

    /**
     * @return the isAllRentSpe
     */
    public Boolean getIsAllRentSpe() {
        return isAllRentSpe;
    }

    /**
     * @param isAllRentSpe the isAllRentSpe to set
     */
    public void setIsAllRentSpe(Boolean isAllRentSpe) {
        this.isAllRentSpe = isAllRentSpe;
    }

    /**
     * @return the date_interest
     */
    public Boolean getDate_interest() {
        return date_interest;
    }

    /**
     * @param date_interest the date_interest to set
     */
    public void setDate_interest(Boolean date_interest) {
        this.date_interest = date_interest;
    }

    /**
     * @return the tax_rate_srvin
     */
    public BigDecimal getTax_rate_srvin() {
        return tax_rate_srvin;
    }

    /**
     * @param tax_rate_srvin the tax_rate_srvin to set
     */
    public void setTax_rate_srvin(BigDecimal tax_rate_srvin) {
        this.tax_rate_srvin = tax_rate_srvin;
    }

    /**
     * @return the tax_rate_srvout
     */
    public BigDecimal getTax_rate_srvout() {
        return tax_rate_srvout;
    }

    /**
     * @param tax_rate_srvout the tax_rate_srvout to set
     */
    public void setTax_rate_srvout(BigDecimal tax_rate_srvout) {
        this.tax_rate_srvout = tax_rate_srvout;
    }

    /**
     * @return the finance_irr
     */
    public BigDecimal getFinance_irr() {
        return finance_irr;
    }

    /**
     * @param finance_irr the finance_irr to set
     */
    public void setFinance_irr(BigDecimal finance_irr) {
        this.finance_irr = finance_irr;
    }

    /**
     * @return the if_corpus_tickets
     */
    public Short getIf_corpus_tickets() {
        return if_corpus_tickets;
    }

    /**
     * @param if_corpus_tickets the if_corpus_tickets to set
     */
    public void setIf_corpus_tickets(Short if_corpus_tickets) {
        this.if_corpus_tickets = if_corpus_tickets;
    }

    /**
     * @return the if_nominal_price
     */
    public Boolean getIf_nominal_price() {
        return if_nominal_price;
    }

    /**
     * @param if_nominal_price the if_nominal_price to set
     */
    public void setIf_nominal_price(Boolean if_nominal_price) {
        this.if_nominal_price = if_nominal_price;
    }
    /**
     * Description: 延迟日期<br>
     * @return
     * @author: xingxi<br>
     * @Date：2013-12-25
     */
    public String getDelay_date() {
        return delay_date;
    }
    /**
     * Description: 延迟日期<br>
     * @return
     * @author: xingxi<br>
     * @Date：2013-12-25
     */
    public void setDelay_date(String delay_date) {
        this.delay_date = delay_date;
    }
    /**
     * 利息是否放在下一期
     */
    public boolean isIf_adj_next_interest() {
        return if_adj_next_interest;
    }
    /**
     * 利息是否放在下一期
     */
    public void setIf_adj_next_interest(boolean if_adj_next_interest) {
        this.if_adj_next_interest = if_adj_next_interest;
    }

    /**
     * @return the deposit_start_date
     */
    public String getDeposit_start_date() {
        return deposit_start_date;
    }

    /**
     * @param deposit_start_date the deposit_start_date to set
     */
    public void setDeposit_start_date(String deposit_start_date) {
        this.deposit_start_date = deposit_start_date;
    }

    /**
     * @return the endDate_type
     */
    public Boolean getEndDate_type() {
        return endDate_type;
    }

    /**
     * @param endDate_type the endDate_type to set
     */
    public void setEndDate_type(Boolean endDate_type) {
        this.endDate_type = endDate_type;
    }

    /**
     * @return the corpus_adjust_zero_jz
     */
    public Short getCorpus_adjust_zero_jz() {
        return corpus_adjust_zero_jz;
    }

    /**
     * @param corpus_adjust_zero_jz the corpus_adjust_zero_jz to set
     */
    public void setCorpus_adjust_zero_jz(Short corpus_adjust_zero_jz) {
        this.corpus_adjust_zero_jz = corpus_adjust_zero_jz;
    }
    /**
     * 租金表类型
     */
    public Short getRent_table_type() {
        return rent_table_type;
    }
    /**
     * 租金表类型
     */
    public void setRent_table_type(Short rent_table_type) {
        this.rent_table_type = rent_table_type;
    }

    /**
     * @return the special_type
     */
    public Short getSpecial_type() {
        return special_type;
    }

    /**
     * @param special_type the special_type to set
     */
    public void setSpecial_type(Short special_type) {
        this.special_type = special_type;
    }
    /**
     * 是否老系统报价测算
     */
    public boolean isIf_old_sys_calc() {
        return if_old_sys_calc;
    }
    /**
     * 是否老系统报价测算
     */
    public void setIf_old_sys_calc(boolean if_old_sys_calc) {
        this.if_old_sys_calc = if_old_sys_calc;
    }
    /**
     * 老系统报价测算去税去租息是否给其它支出去税
     *
     */
    public boolean isIf_old_other_fax() {
        return if_old_other_fax;
    }
    /**
     * 老系统报价测算去税去租息是否给其它支出去税
     *
     */
    public void setIf_old_other_fax(boolean if_old_other_fax) {
        this.if_old_other_fax = if_old_other_fax;
    }

    public List<LeaseLoanPlanVO> getNewLease_loan_plan() {
        return newLease_loan_plan;
    }

    public void setNewLease_loan_plan(List<LeaseLoanPlanVO> newLease_loan_plan) {
        this.newLease_loan_plan = newLease_loan_plan;
    }

    public List getInout_plan_beforeLoan() {
        return inout_plan_beforeLoan;
    }

    public void setInout_plan_beforeLoan(List inout_plan_beforeLoan) {
        this.inout_plan_beforeLoan = inout_plan_beforeLoan;
    }

    public List getPlanDateList() {
        return planDateList;
    }

    public void setPlanDateList(List planDateList) {
        this.planDateList = planDateList;
    }

    /** add 20160702 新去税租息 */
    /**
     * 租金税率
     */
    public Short rent_tax_rate;
    /**
     * 投放总额
     */
    public BigDecimal plan_cash_loan_sum;
    /**
     * 进项税额 取投放计划的税额总和
     */
    public BigDecimal input_tax_cash;

    public Short getRent_tax_rate() {
        return rent_tax_rate;
    }

    public void setRent_tax_rate(Short rent_tax_rate) {
        this.rent_tax_rate = rent_tax_rate;
    }

    public BigDecimal getPlan_cash_loan_sum() {
        if(plan_cash_loan_sum == null){
            return  BigDecimal.ZERO;
        }
        return plan_cash_loan_sum;
    }

    public void setPlan_cash_loan_sum(BigDecimal plan_cash_loan_sum) {
        this.plan_cash_loan_sum = plan_cash_loan_sum;
    }

    public BigDecimal getInput_tax_cash() {
        if(input_tax_cash == null){
            return  BigDecimal.ZERO;
        }
        return input_tax_cash;
    }
    public void setInput_tax_cash(BigDecimal input_tax_cash) {
        this.input_tax_cash = input_tax_cash;
    }
    /** add end*/

    //by lihongjian 营改增 @2016/05/11 ADD START
    public BigDecimal sumInterest;

    public BigDecimal sumInterest_notax;

    public BigDecimal getSumInterest_notax() {
        return sumInterest_notax;
    }

    public void setSumInterest_notax(BigDecimal sumInterest_notax) {
        this.sumInterest_notax = sumInterest_notax;
    }

    public BigDecimal getSumInterest() {
        return sumInterest;
    }

    public void setSumInterest(BigDecimal sumInterest) {
        this.sumInterest = sumInterest;
    }

    public Map<String,Short> planDate_taxRateMap;

    public Map<String, Short> getPlanDate_taxRateMap() {
        return planDate_taxRateMap;
    }

    public void setPlanDate_taxRateMap(Map<String, Short> planDate_taxRateMap) {
        this.planDate_taxRateMap = planDate_taxRateMap;
    }

    public Map<String,Short> planDate_taxModeMap;

    public Map<String, Short> getPlanDate_taxModeMap() {
        return planDate_taxModeMap;
    }

    public void setPlanDate_taxModeMap(Map<String, Short> planDate_taxModeMap) {
        this.planDate_taxModeMap = planDate_taxModeMap;
    }

    // 租金-增值税
    public BigDecimal lease_cash_added;
    // 租金-营业税
    public BigDecimal lease_cash_sales;
    //增值税 本金
    public BigDecimal lease_corpus_added;
    //营业税 本金
    public BigDecimal lease_corpus_sales;
    //增值税 利息
    public BigDecimal lease_interest_added;
    //营业税 本金
    public BigDecimal lease_interest_sales;

    public BigDecimal getLease_cash_added() {
        return lease_cash_added;
    }

    public void setLease_cash_added(BigDecimal lease_cash_added) {
        this.lease_cash_added = lease_cash_added;
    }

    public BigDecimal getLease_cash_sales() {
        return lease_cash_sales;
    }

    public void setLease_cash_sales(BigDecimal lease_cash_sales) {
        this.lease_cash_sales = lease_cash_sales;
    }

    public BigDecimal getLease_corpus_added() {
        return lease_corpus_added;
    }

    public void setLease_corpus_added(BigDecimal lease_corpus_added) {
        this.lease_corpus_added = lease_corpus_added;
    }

    public BigDecimal getLease_corpus_sales() {
        return lease_corpus_sales;
    }

    public void setLease_corpus_sales(BigDecimal lease_corpus_sales) {
        this.lease_corpus_sales = lease_corpus_sales;
    }

    public BigDecimal getLease_interest_added() {
        return lease_interest_added;
    }

    public void setLease_interest_added(BigDecimal lease_interest_added) {
        this.lease_interest_added = lease_interest_added;
    }

    public BigDecimal getLease_interest_sales() {
        return lease_interest_sales;
    }

    public void setLease_interest_sales(BigDecimal lease_interest_sales) {
        this.lease_interest_sales = lease_interest_sales;
    }

    //by lihongjian 营改增 @2016/05/11 ADD END
    //[合同变更-合同信息更正] wangjj@2016/07/02 ADD START
    /**
     * 税率是否变更
     */
    public Short is_change_rate;


    public Short getIs_change_rate() {
        return is_change_rate;
    }

    public void setIs_change_rate(Short is_change_rate) {
        this.is_change_rate = is_change_rate;
    }

    //[合同变更-合同信息更正] wangjj@2016/07/02 ADD END

    /**[会计IRR算法调整] @2016年10月27日 @wangjj start*/

    /**
     * 会计IRR按最新算法
     */
    public Short finance_irr_method;

    /**
     * 会计IRR按最新算法
     * @return
     * WANGJJ
     * 2016年11月1日
     */
    public Short getFinance_irr_method() {
        return finance_irr_method;
    }
    /**
     * 会计IRR按最新算法
     * @param finance_irr_method
     * WANGJJ
     * 2016年11月1日
     */
    public void setFinance_irr_method(Short finance_irr_method) {
        this.finance_irr_method = finance_irr_method;
    }

    /**[会计IRR算法调整] @2016年10月27日 @wangjj end*/

    /** ADD【拆分投放】 【 wangjj】 【2017年5月25日】 STRAT*/
    /**
     * 计息金额计算方式 （拆分投放）
     */
    public Short calinterest_amount_style;


    public Short getCalinterest_amount_style() {
        return calinterest_amount_style;
    }

    public void setCalinterest_amount_style(Short calinterest_amount_style) {
        this.calinterest_amount_style = calinterest_amount_style;
    }


    /** ADD END*/

    /*
     * 中投会计分摊表算法版本
     * lvcn 20181113
     */

    public Short cal_version;


    public Short getCal_version() {
        return cal_version;
    }

    public void setCal_version(Short cal_version) {
        this.cal_version = cal_version;
    }

    //销项税
    public BigDecimal loan_tax;
    //进项税
    public BigDecimal rent_tax;


    public BigDecimal getLoan_tax() {
        return loan_tax;
    }

    public void setLoan_tax(BigDecimal loan_tax) {
        this.loan_tax = loan_tax;
    }

    public BigDecimal getRent_tax() {
        return rent_tax;
    }

    public void setRent_tax(BigDecimal rent_tax) {
        this.rent_tax = rent_tax;
    }

    public String fact_plan_loan_date;


    public String getFact_plan_loan_date() {
        return fact_plan_loan_date;
    }

    public void setFact_plan_loan_date(String fact_plan_loan_date) {
        this.fact_plan_loan_date = fact_plan_loan_date;
    }

    /**
     * 是否固定收租日
     */
    public boolean if_fixday;

    /**
     *固定收租日规则Pk
     */
    public String pk_fixed_chose;


    public boolean isIf_fixday() {
        return if_fixday;
    }

    public void setIf_fixday(boolean if_fixday) {
        this.if_fixday = if_fixday;
    }

    public String getPk_fixed_chose() {
        return pk_fixed_chose;
    }

    public void setPk_fixed_chose(String pk_fixed_chose) {
        this.pk_fixed_chose = pk_fixed_chose;
    }

}