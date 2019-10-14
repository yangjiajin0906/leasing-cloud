package com.leasing.calculate.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.leasing.calculate.vo.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @project:leasing-cloud 报价VO
 * @date:2019/9/23
 * @author:Yjj@yonyou.com
 * @description:
 **/

@Entity
@Table(name="yls_lease_calculator")
public class CalculatorVO implements Serializable {
    /**
     * 主键
     */
    @Id    //主键id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)//主键生成策略
    //@Column(name="pk_lease_calculator")//数据库字段名
    public String pk_lease_calculator;

    /**
     * 关联编号
     */
    public String pk_initial;


    /**
     * 测算方案编号
     */
    public String quot_code;


    /**
     * 测算方案名称
     */
    public String quot_name;


    /**
     * 限额方案
     */
    @ManyToOne()
    @JoinColumn(name = "pk_limit_plan", referencedColumnName = "pk_limit_plan")
    public LimitPlanRefVO pk_limit_plan;

    /**
     * 计息金额计算方式
     */
    public Short calinterest_amount_style;


    /**
     * 投放日期
     */
    public String plan_date_loan;

    /**
     * 实际投放日期，用于处理起租变更对于已付款的投放金额投放日期 null
     */
    //public String fact_plan_date_loan;


    /**
     * 币种
     */
    @Transient
    public CurrtypeRefVO pk_currtype;




    /**
     * 汇率
     */
    public BigDecimal pk_exchg_rate;


    /**
     * 起租日
     */
    public String lease_commencement_date;


    /**
     * 租赁方式
     */
    public Short lease_method;


    /**
     * 设备总金额
     */
    public BigDecimal total_amount_equipment;


    /**
     * 首付款比例
     */
    public BigDecimal down_payment_ratio;


    /**
     * 首付款金额
     */
    public BigDecimal down_payment;


    /**
     * 商业折扣
     */
    public BigDecimal trade_discount;


    /**
     * 计划投放金额
     */
    public BigDecimal plan_cash_loan;


    /**
     * 实际投放金额
     */
    public BigDecimal fact_cash_loan;


    /**
     * 名义货价（留购价）
     */
    public BigDecimal nominal_price;


    /**
     * 资产余值
     */
    public BigDecimal assets_margin;


    /**
     * 保证金比例
     */
    public BigDecimal deposit_ratio;


    /**
     * 保证金金额
     */
    public BigDecimal deposit_cash;


    /**
     * 保证金收取方式
     */
    public Short deposit_method;


    /**
     * 服务费收入方式
     */
    public Short srvfee_method_in;


    /**
     * 服务费收入基数
     */
    public Short srvfee_base;


    /**
     * 服务费收入比例
     */
    public BigDecimal srvfee_ratio_in;


    /**
     * 每期服务费收入金额
     */
    public BigDecimal srvfee_cash_in_ft;


    /**
     * 服务费收入税率
     */
    public Short srvfee_taxrate_in;


    /**
     * 服务费收入总金额
     */
    public BigDecimal srvfee_cash_in;


    /**
     * 服务费支出方式
     */
    public Short srvfee_method_out;


    /**
     * 服务费支出基数
     */
    @Transient
    public Short srvfee_base_out;


    /**
     * 服务费支出比例
     */
    public BigDecimal srvfee_ratio_out;

    /**
     * 每期服务费支出金额
     */
    public BigDecimal srvfee_cash_out_ft;

    /**
     * 服务费支出总金额
     */
    public BigDecimal srvfee_cash_out;

    /**
     * 首期服务费支出时间
     */
    public String srvfee_date_out_ft;


    /**
     * 服务费支出税率
     */
    public Short srvfee_taxrate_out;


    /**
     * 厂商保证金比例
     */
    public BigDecimal vendor_deposit_ratio;


    /**
     * 厂商保证金金额
     */
    public BigDecimal vendor_deposit_cash;


    /**
     * 净融资额
     */
    public BigDecimal net_finance_cash;


    /**
     * 净融资比例
     */
    public BigDecimal net_finance_ratio;


    /**
     * 是否作为标准模板
     */
    public Short if4basic;


    /**
     * 收税模式
     */
    public Short tax_mode;


    /**
     * 备注
     */
    public String memo;

    /**
     * 计算比例基数(运行参数中取值) null
     */
    @Transient
    public Short cal_ratio_base;

    /**
     * 租金表类型
     */
    public Short rent_table_type;


    /**
     * 补差利息处理方式
     */
    public Short reverse_interest_method;


    /**
     * 延迟期（日）
     */
    public Integer delay_period;


    /**
     * 宽限期（月）
     */
    public Integer grace_period;


    /**
     * 特殊期类别
     */
    public Short special_type;


    /**
     * 远期支付期限
     */
    public Integer limit_t;


    /**
     * 远期支付频率
     */
    public Short time_pay_period;


    /**
     * 远期支付金额
     */
    public BigDecimal time_pay_cash;

    /**
     * 远期支付日期
     */
    public String time_pay_date;

    /**
     * 远期是否收首付款
     */
    public Short if_down_payment_t;

    /**
     * 在建期还本金额
     */
    public BigDecimal repayment_corpus_cash_c;


    /**
     * 在建期期限
     */
    public Integer limit_c;


    /**
     * 在建期支付频率
     */
    public Short lease_period_c;


    /**
     * 在建期还本周期
     */
    public Short repayment_corpus_period_c;

    /**
     * 在建期利率档次
     */
    public Short interrate_level_c;

    /**
     * 在建期基准利率
     */
    public BigDecimal interrate_c;

    /**
     * 在建期利率浮动值
     */
    public BigDecimal float_value_c;

    /**
     * 在建期利率
     */
    public BigDecimal final_rate_c;

    /**
     * 在建期利率类型
     */
    public Short interrate_type_c;

    /**
     * 在建期利率浮动方式
     */
    public Short float_method_c;

    /**
     * 在建期利率生效日期
     */
    @ManyToOne()
    @JoinColumn(name = "pk_interrate_c", referencedColumnName = "pk_interrate")
    public InterrateRefVO pk_interrate_c;

    /**
     * 建设期利息处理方式
     */
    public Short interest_method_c;


    /**
     * 预计转经营期日期
     */
    public String plan2operating_date;


    /**
     * 计划收租日
     */
    public Short plan_lease_date;


    /**
     * 租赁期限（月）
     */
    public Integer lease_times;


    /**
     * 收租规则周期
     */
    public Short lease_period_rule;


    /**
     * 特殊算法设置
     */
    public Short cal_method_spec;


    /**
     * 先付后付标志
     */
    public Short prepay_or_not;


    /**
     * 是否指定首期收租日
     */
    public Short has_first_lease_date;


    /**
     * 首期收租日期
     */
    public String first_lease_date;


    /**
     * 项目预计到期日
     */
    public String final_date;

    /**
     * 最后一期提前天数
     */
    public Integer last_term_days;

    /**
     * 租金表调整对象
     */
    public Short lease_adjust_type;

    /**
     * 支付频率
     */
    public Short lease_freq;

    /**
     * 计算方式
     */
    public Short lease_cal_method;


    /**
     * 提前间隔（月）
     */
    public Integer interval_in_advance;


    /**
     * 总投放金额的计息方式
     */
    public Short interest_method_total_loan;

    /**
     * 年计算天数
     */
    public Short year_days;


    /**
     * IRR年计算天数
     */
    public Short year_days_irr;


    /**
     * 现金流年计算天数
     */
    public Short year_days_flow;


    /**
     * 计算精度
     */
    public Short cal_digit;


    /**
     * 利率类型
     */
    public Short interrate_type;


    /**
     * 固定利率（平息率）
     */
    public BigDecimal fixed_interrate;


    /**
     * 利率浮动方式
     */
    public Short float_method;


    /**
     * 利率生效日期
     */
    @ManyToOne()
    @JoinColumn(name = "pk_interrate", referencedColumnName = "pk_interrate")
    public InterrateRefVO pk_interrate;


    /**
     * 利率档次
     */
    public Short interrate_level;


    /**
     * 基准利率
     */
    public BigDecimal interrate;


    /**
     * 利率浮动值
     */
    public BigDecimal float_value;


    /**
     * 租息年利率
     */
    public BigDecimal final_rate;


    /**
     * 保证金退回方式
     */
    public Short return_method_depos;


    /**
     * 保证金是否计息
     */
    public Short if_interest_depos;


    /**
     * 保证金年利率类型
     */
    public Short interrate_type_depos;


    /**
     * 保证金年利率档次
     */
    public Short interrate_level_depos;


    /**
     * 保证金基准年利率
     */
    public BigDecimal interrate_depos;


    /**
     * 保证金浮动方式
     */
    public Short float_method_depos;

    /**
     * 保证金年利率生效日期
     */
    @ManyToOne()
    @JoinColumn(name = "pk_interrate_depos", referencedColumnName = "pk_interrate")
    public InterrateRefVO pk_interrate_depos;

    /**
     * 保证金浮动比例
     */
    public BigDecimal float_value_depos;


    /**
     * 保证金利率
     */
    public BigDecimal final_rate_depos;


    /**
     * 保证金收取说明
     */
    public String memo_depos;

    /**
     * 利息计算方式
     */
    public Short interrest_method;

    /**
     * 日复利每期所占比例
     */
    public BigDecimal radio_hyear;

    /**
     * 最后一期计算规则
     */
    public Short last_term_rule;

    /**
     * 市场IRR
     */
    public BigDecimal commercial_irr;


    /**
     * 增值税下IRR
     */
    public BigDecimal vat_irr;


    /**
     * 会计IRR
     */
    public BigDecimal finance_irr;

    /**
     * 会计去税IRR
     */
    public BigDecimal finance_notax_irr;


    /**
     * 租金IRR
     */
    public BigDecimal rent_irr;


    /**
     * 项目IRR
     */
    public BigDecimal project_irr;


    /**
     * 项目去税IRR
     */
    public BigDecimal project_notax_irr;

    /**
     * add by jiaoshy 2017-10-09  咨询费合同
     */
    /**
     * 不含咨询费市场IRR
     */
    public BigDecimal project_irr_consult;


    /**
     * 不含咨询费市场去税IRR
     */
    public BigDecimal project_notax_irr_consult;
    /* add end*/

    /**
     * 手续费分配IRR
     */
    public BigDecimal fee_distr_irr;

    /**
     * IRR倒算对象
     */
    @Transient
    public Short irr_object;

    /**
     * IRR倒算期望IRR
     */
    @Transient
    public BigDecimal expect_nominal_irr;

    /**
     * 项目平息率
     */
    @Transient
    public BigDecimal project_average_interrate;

    /**
     * 本金是否开票
     */
    public Short if_corpus_tickets;


    /**
     * 单据状态
     */
    public Short billstatus;


    /**
     * 操作员主键
     */
    @ManyToOne()
    @JoinColumn(name = "pk_operator", referencedColumnName = "pk_user")
    public UserRefVO pk_operator;

    /**
     * 操作日期
     */
    public String operate_date;


    /**
     * 操作时间
     */
    public String operate_time;


    /**
     * 复核员主键
     */
    @ManyToOne()
    @JoinColumn(name = "pk_checker", referencedColumnName = "pk_user")
    public UserRefVO pk_checker;

    /**
     * 复核日期
     */
    public String check_date;


    /**
     * 复核时间
     */
    public String check_time;


    /**
     * 授权人主键
     */
    @ManyToOne()
    @JoinColumn(name = "pk_grantor", referencedColumnName = "pk_user")
    public UserRefVO pk_grantor;

    /**
     * 授权日期
     */
    public String grant_date;


    /**
     * 授权时间
     */
    public String grant_time;


    /**
     * 机构
     */
    @ManyToOne()
    @JoinColumn(name = "pk_org", referencedColumnName = "pk_org")
    public OrgRefVO pk_org;

    /**
     * 部门
     */
    @ManyToOne()
    @JoinColumn(name = "pk_dept", referencedColumnName = "pk_deptdoc")
    public DeptdocRefVO  pk_dept;
    /**
     * 投放计划（子表）
     */
//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "source_bill")
//    @JsonManagedReference  //少的一方管理映射，将在测试结果中看出
//    @OrderBy("plan_date_loan asc")

    @Transient
    public List<LeaseLoanPlanVO> lease_loan_plan;
    /**
     * 规则设置（子表）
     */
//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "pk_lease_calculator" )
//    @JsonManagedReference  //少的一方管理映射，将在测试结果中看出

    @Transient
    public List<LeaseRulePVO> lease_rule;
//    /**
//     * 风险金计划（子表）
//     */

    @Transient
    public List<InoutPlanPVO>  inout_plan_deposit;
    /**
     * 服务费收入（子表） --展现
     */

    @Transient
    public List<InoutPlanPVO>  inout_plan_srvin;
    /**
     * 服务费支出（子表） --展现
     */

    @Transient
    public List<InoutPlanPVO>  inout_plan_srvot;
    /**
     * 其他收支计划（子表） --展现
     */

    @Transient
    public List<InoutPlanPVO>  inout_plan_other;
    /**
     * 租金计划表（子表） --展现
     */

    @Transient
    public List<InoutPlanPVO>  inout_plan;

    /**
     * 收支计划（子表）市场  --存储
     */
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval=true,fetch = FetchType.LAZY)
    @JoinColumn(name="source_bill")
    @JsonManagedReference  //少的一方管理映射，将在测试结果中看出
    @Where(clause="rent_type = 1")
    @OrderBy("plan_date asc")
    public List<InoutPlanPVO> inout_plan_market = new ArrayList<InoutPlanPVO>();

    /**
     * 本次投放之前的租金计划表
     */

    @Transient
    public List<InoutPlanPVO>  inout_plan_beforeLoan;


    @Transient
    public IRRConvertParamVO irrParamVO;

    /**
     * 租赁合同IRR
     */
    public BigDecimal contract_irr;

    /**
     * 审计IRR
     */
    public BigDecimal audit_irr;

    /**
     * 承租人IRR
     */
    public BigDecimal lessee_irr;

    /**
     * 首付款是否参与期次排序
     */
    //public Short first_cash_ifsort;

    /**
     * 来源单据主键
     */
    //public ProjectInfoRefVO pk_project_info;


    /**
     * 合同信息
     */
    @ManyToOne()
    @JoinColumn(name = "pk_contract", referencedColumnName = "pk_contract")
    public ContractRefVO pk_contract;


    /**
     * 固定收租日规则
     */
    //public FixedChoseRefVO pk_fixed_chose;

//    public FixedChoseRefVO getPk_fixed_chose() {
//        return pk_fixed_chose;
//    }
//    public void setPk_fixed_chose(FixedChoseRefVO pk_fixed_chose) {
//        this.pk_fixed_chose = pk_fixed_chose;
//    }

    /**
     * 客户实际期初金额
     */
    public BigDecimal fact_initial_cash;

    /**
     * 客户实际期初金额占比
     */
    //public BigDecimal fact_initial_atio;

    /**
     * 租金合计值
     */
    public BigDecimal lease_cash_sum;

    /**
     * 利息合计值
     */
    public BigDecimal lease_interest_sum;


    /**
     * 测算方案状态
     */
    public Short quot_status;


    /**
     * 是否不规则测算
     */
    //public Boolean if_irregular_cal;


    /**
     * 报价有效期
     */
    public Integer quot_valid;

    /**
     * 报价有效开始日期
     */
    public String quot_start_date;

    /**
     * 报价有效截止日期
     */
    public String quot_end_date;

    /**
     * 年还款次数
     */
    public Integer year_times;
    /**
     * 是否被合同引用
     */
    public Short if_cont_quote;
    /**
     * 数据来源单据主键
     */
    public String data_source_bill;
    /**
     * 数据来源单据类型
     */
    public String data_source_billtype;


    /**
     * 佣金收入
     */
    public BigDecimal brokerage_in;

    /**聚信用的字段*/
    /**
     * 承租人支出
     */
//    public BigDecimal customer_out_total = BigDecimal.ZERO;
//    /**
//     * 渠道支出
//     */
//    public BigDecimal srvfee_out_total = BigDecimal.ZERO;
//    /**
//     * 其他收支
//     */
//    public BigDecimal other_total = BigDecimal.ZERO;

    /**
     * 报价客户
     */
    @ManyToOne()
    @JoinColumn(name = "pk_customer", referencedColumnName = "pk_customer")
    public CustomerRefVO pk_customer;

    /**
     * 年化利率方式
     */
    public Short annualized_rate_method;

    /**
     * 年化利率
     */
    public BigDecimal annualized_rate;

    /**
     * 其他担保方式
     */
    public String other_assure_method;

    /**
     * 风险金起始收取日期
     */
    public String deposit_start_date;

    /**
     * 保证金利息
     */
    public BigDecimal deposit_interest;

    /**
     * 特殊期限
     */
    public Integer special_limit;

    /**
     * 特殊期利息支付频率
     */
    public Short repayment_interest_period;

    /**
     * 特殊期还本频率
     */
    public Short repayment_corpus_period;

    /**
     * 特殊期还本金额
     */
    public BigDecimal repayment_corpus_cash;

    /**
     * 特殊期利率
     */
    public BigDecimal special_final_rate;

    /**
     * 特殊期利率档次
     */
    public Short special_interrate_level;

    /**
     * 特殊期基准利率
     */
    public BigDecimal special_interrate;

    /**
     * 特殊期利率类型
     */
    public Short special_interrate_type;

    /**
     * 特殊期利率浮动方式
     */
    public Short special_float_method;

    /**
     * 特殊期利率浮动值
     */
    public BigDecimal special_float_value;

    /**
     * 特殊期利率生效日期
     */
    @ManyToOne()
    @JoinColumn(name = "pk_special_interrate", referencedColumnName = "pk_interrate")
    public InterrateRefVO pk_special_interrate;

    /**
     * 客户实际期初金额占比
     */
    public BigDecimal fact_initial_ratio;

    /**
     * 是否固定收租日
     */

    //--------假数据分割线--------------

    public String ts;

    /**
     * 算法版本 参照 PubEnumsConstant.cal_merge_event等
     */
    @Transient
    public Short cal_version;

    public Short getCal_version() {
        return cal_version;
    }
    public void setCal_version(Short cal_version) {
        this.cal_version = cal_version;
    }

    /**
     * 是否固定收租日
     */
    @Transient
    public Short if_fixday;

    public Short getIf_fixday() {
        return if_fixday;
    }
    public void setIf_fixday(Short if_fixday) {
        this.if_fixday = if_fixday;
    }

    /**
     * 报价类型(0：租赁；1：保理)
     */
    public Short cal_type;

    public Short getCal_type() {
        return cal_type;
    }
    public void setCal_type(Short cal_type) {
        this.cal_type = cal_type;
    }

    /**
     * 主键的getter方法
     * @return String
     */
    public String getPrimaryKey() {
        return pk_lease_calculator;
    }

    /**
     * 主键的setter方法
     * @param
     */
    public void setPrimaryKey(String key) {
        this.pk_lease_calculator = key;
    }

    public String getPk_lease_calculator() {
        return pk_lease_calculator;
    }

    public void setPk_lease_calculator(String pk_lease_calculator) {
        this.pk_lease_calculator = pk_lease_calculator;
    }

    public String getPk_initial() {
        return pk_initial;
    }

    public void setPk_initial(String pk_initial) {
        this.pk_initial = pk_initial;
    }

    public String getQuot_code() {
        return quot_code;
    }

    public void setQuot_code(String quot_code) {
        this.quot_code = quot_code;
    }

    public String getQuot_name() {
        return quot_name;
    }

    public void setQuot_name(String quot_name) {
        this.quot_name = quot_name;
    }

    public LimitPlanRefVO getPk_limit_plan() {
        return pk_limit_plan;
    }

    public void setPk_limit_plan(LimitPlanRefVO pk_limit_plan) {
        this.pk_limit_plan = pk_limit_plan;
    }

    public Short getCalinterest_amount_style() {
        return calinterest_amount_style;
    }

    public void setCalinterest_amount_style(Short calinterest_amount_style) {
        this.calinterest_amount_style = calinterest_amount_style;
    }

    public String getPlan_date_loan() {
        return plan_date_loan;
    }

    public void setPlan_date_loan(String plan_date_loan) {
        this.plan_date_loan = plan_date_loan;
    }

    public BigDecimal getPk_exchg_rate() {
        return pk_exchg_rate;
    }

    public void setPk_exchg_rate(BigDecimal pk_exchg_rate) {
        this.pk_exchg_rate = pk_exchg_rate;
    }

    public String getLease_commencement_date() {
        return lease_commencement_date;
    }

    public void setLease_commencement_date(String lease_commencement_date) {
        this.lease_commencement_date = lease_commencement_date;
    }

    public Short getLease_method() {
        return lease_method;
    }

    public void setLease_method(Short lease_method) {
        this.lease_method = lease_method;
    }

    public BigDecimal getTotal_amount_equipment() {
        return total_amount_equipment;
    }

    public void setTotal_amount_equipment(BigDecimal total_amount_equipment) {
        this.total_amount_equipment = total_amount_equipment;
    }

    public BigDecimal getDown_payment_ratio() {
        return down_payment_ratio;
    }

    public void setDown_payment_ratio(BigDecimal down_payment_ratio) {
        this.down_payment_ratio = down_payment_ratio;
    }

    public BigDecimal getDown_payment() {
        return down_payment;
    }

    public void setDown_payment(BigDecimal down_payment) {
        this.down_payment = down_payment;
    }

    public BigDecimal getTrade_discount() {
        return trade_discount;
    }

    public void setTrade_discount(BigDecimal trade_discount) {
        this.trade_discount = trade_discount;
    }

    public BigDecimal getPlan_cash_loan() {
        return plan_cash_loan;
    }

    public void setPlan_cash_loan(BigDecimal plan_cash_loan) {
        this.plan_cash_loan = plan_cash_loan;
    }

    public BigDecimal getFact_cash_loan() {
        return fact_cash_loan;
    }

    public void setFact_cash_loan(BigDecimal fact_cash_loan) {
        this.fact_cash_loan = fact_cash_loan;
    }

    public BigDecimal getNominal_price() {
        return nominal_price;
    }

    public void setNominal_price(BigDecimal nominal_price) {
        this.nominal_price = nominal_price;
    }

    public BigDecimal getAssets_margin() {
        return assets_margin;
    }

    public void setAssets_margin(BigDecimal assets_margin) {
        this.assets_margin = assets_margin;
    }

    public BigDecimal getDeposit_ratio() {
        return deposit_ratio;
    }

    public void setDeposit_ratio(BigDecimal deposit_ratio) {
        this.deposit_ratio = deposit_ratio;
    }

    public BigDecimal getDeposit_cash() {
        return deposit_cash;
    }

    public void setDeposit_cash(BigDecimal deposit_cash) {
        this.deposit_cash = deposit_cash;
    }

    public Short getDeposit_method() {
        return deposit_method;
    }

    public void setDeposit_method(Short deposit_method) {
        this.deposit_method = deposit_method;
    }

    public Short getSrvfee_method_in() {
        return srvfee_method_in;
    }

    public void setSrvfee_method_in(Short srvfee_method_in) {
        this.srvfee_method_in = srvfee_method_in;
    }

    public Short getSrvfee_base() {
        return srvfee_base;
    }

    public void setSrvfee_base(Short srvfee_base) {
        this.srvfee_base = srvfee_base;
    }

    public BigDecimal getSrvfee_ratio_in() {
        return srvfee_ratio_in;
    }

    public void setSrvfee_ratio_in(BigDecimal srvfee_ratio_in) {
        this.srvfee_ratio_in = srvfee_ratio_in;
    }

    public BigDecimal getSrvfee_cash_in_ft() {
        return srvfee_cash_in_ft;
    }

    public void setSrvfee_cash_in_ft(BigDecimal srvfee_cash_in_ft) {
        this.srvfee_cash_in_ft = srvfee_cash_in_ft;
    }

    public Short getSrvfee_taxrate_in() {
        return srvfee_taxrate_in;
    }

    public void setSrvfee_taxrate_in(Short srvfee_taxrate_in) {
        this.srvfee_taxrate_in = srvfee_taxrate_in;
    }

    public BigDecimal getSrvfee_cash_in() {
        return srvfee_cash_in;
    }

    public void setSrvfee_cash_in(BigDecimal srvfee_cash_in) {
        this.srvfee_cash_in = srvfee_cash_in;
    }

    public Short getSrvfee_method_out() {
        return srvfee_method_out;
    }

    public void setSrvfee_method_out(Short srvfee_method_out) {
        this.srvfee_method_out = srvfee_method_out;
    }

    public BigDecimal getSrvfee_ratio_out() {
        return srvfee_ratio_out;
    }

    public void setSrvfee_ratio_out(BigDecimal srvfee_ratio_out) {
        this.srvfee_ratio_out = srvfee_ratio_out;
    }

    public BigDecimal getSrvfee_cash_out_ft() {
        return srvfee_cash_out_ft;
    }

    public void setSrvfee_cash_out_ft(BigDecimal srvfee_cash_out_ft) {
        this.srvfee_cash_out_ft = srvfee_cash_out_ft;
    }

    public BigDecimal getSrvfee_cash_out() {
        return srvfee_cash_out;
    }

    public void setSrvfee_cash_out(BigDecimal srvfee_cash_out) {
        this.srvfee_cash_out = srvfee_cash_out;
    }

    public String getSrvfee_date_out_ft() {
        return srvfee_date_out_ft;
    }

    public void setSrvfee_date_out_ft(String srvfee_date_out_ft) {
        this.srvfee_date_out_ft = srvfee_date_out_ft;
    }

    public Short getSrvfee_taxrate_out() {
        return srvfee_taxrate_out;
    }

    public void setSrvfee_taxrate_out(Short srvfee_taxrate_out) {
        this.srvfee_taxrate_out = srvfee_taxrate_out;
    }

    public BigDecimal getVendor_deposit_ratio() {
        return vendor_deposit_ratio;
    }

    public void setVendor_deposit_ratio(BigDecimal vendor_deposit_ratio) {
        this.vendor_deposit_ratio = vendor_deposit_ratio;
    }

    public BigDecimal getVendor_deposit_cash() {
        return vendor_deposit_cash;
    }

    public void setVendor_deposit_cash(BigDecimal vendor_deposit_cash) {
        this.vendor_deposit_cash = vendor_deposit_cash;
    }

    public BigDecimal getNet_finance_cash() {
        return net_finance_cash;
    }

    public void setNet_finance_cash(BigDecimal net_finance_cash) {
        this.net_finance_cash = net_finance_cash;
    }

    public BigDecimal getNet_finance_ratio() {
        return net_finance_ratio;
    }

    public void setNet_finance_ratio(BigDecimal net_finance_ratio) {
        this.net_finance_ratio = net_finance_ratio;
    }

    public Short getIf4basic() {
        return if4basic;
    }

    public void setIf4basic(Short if4basic) {
        this.if4basic = if4basic;
    }

    public Short getTax_mode() {
        return tax_mode;
    }

    public void setTax_mode(Short tax_mode) {
        this.tax_mode = tax_mode;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Short getRent_table_type() {
        return rent_table_type;
    }

    public void setRent_table_type(Short rent_table_type) {
        this.rent_table_type = rent_table_type;
    }

    public Short getReverse_interest_method() {
        return reverse_interest_method;
    }

    public void setReverse_interest_method(Short reverse_interest_method) {
        this.reverse_interest_method = reverse_interest_method;
    }

    public Integer getDelay_period() {
        return delay_period;
    }

    public void setDelay_period(Integer delay_period) {
        this.delay_period = delay_period;
    }

    public Integer getGrace_period() {
        return grace_period;
    }

    public void setGrace_period(Integer grace_period) {
        this.grace_period = grace_period;
    }

    public Short getSpecial_type() {
        return special_type;
    }

    public void setSpecial_type(Short special_type) {
        this.special_type = special_type;
    }

    public Integer getLimit_t() {
        return limit_t;
    }

    public void setLimit_t(Integer limit_t) {
        this.limit_t = limit_t;
    }

    public Short getTime_pay_period() {
        return time_pay_period;
    }

    public void setTime_pay_period(Short time_pay_period) {
        this.time_pay_period = time_pay_period;
    }

    public BigDecimal getTime_pay_cash() {
        return time_pay_cash;
    }

    public void setTime_pay_cash(BigDecimal time_pay_cash) {
        this.time_pay_cash = time_pay_cash;
    }

    public String getTime_pay_date() {
        return time_pay_date;
    }

    public void setTime_pay_date(String time_pay_date) {
        this.time_pay_date = time_pay_date;
    }

    public Short getIf_down_payment_t() {
        return if_down_payment_t;
    }

    public void setIf_down_payment_t(Short if_down_payment_t) {
        this.if_down_payment_t = if_down_payment_t;
    }

    public BigDecimal getRepayment_corpus_cash_c() {
        return repayment_corpus_cash_c;
    }

    public void setRepayment_corpus_cash_c(BigDecimal repayment_corpus_cash_c) {
        this.repayment_corpus_cash_c = repayment_corpus_cash_c;
    }

    public Integer getLimit_c() {
        return limit_c;
    }

    public void setLimit_c(Integer limit_c) {
        this.limit_c = limit_c;
    }

    public Short getLease_period_c() {
        return lease_period_c;
    }

    public void setLease_period_c(Short lease_period_c) {
        this.lease_period_c = lease_period_c;
    }

    public Short getRepayment_corpus_period_c() {
        return repayment_corpus_period_c;
    }

    public void setRepayment_corpus_period_c(Short repayment_corpus_period_c) {
        this.repayment_corpus_period_c = repayment_corpus_period_c;
    }

    public Short getInterrate_level_c() {
        return interrate_level_c;
    }

    public void setInterrate_level_c(Short interrate_level_c) {
        this.interrate_level_c = interrate_level_c;
    }

    public BigDecimal getInterrate_c() {
        return interrate_c;
    }

    public void setInterrate_c(BigDecimal interrate_c) {
        this.interrate_c = interrate_c;
    }

    public BigDecimal getFloat_value_c() {
        return float_value_c;
    }

    public void setFloat_value_c(BigDecimal float_value_c) {
        this.float_value_c = float_value_c;
    }

    public BigDecimal getFinal_rate_c() {
        return final_rate_c;
    }

    public void setFinal_rate_c(BigDecimal final_rate_c) {
        this.final_rate_c = final_rate_c;
    }

    public Short getInterrate_type_c() {
        return interrate_type_c;
    }

    public void setInterrate_type_c(Short interrate_type_c) {
        this.interrate_type_c = interrate_type_c;
    }

    public Short getFloat_method_c() {
        return float_method_c;
    }

    public void setFloat_method_c(Short float_method_c) {
        this.float_method_c = float_method_c;
    }

    public InterrateRefVO getPk_interrate_c() {
        return pk_interrate_c;
    }

    public void setPk_interrate_c(InterrateRefVO pk_interrate_c) {
        this.pk_interrate_c = pk_interrate_c;
    }

    public Short getInterest_method_c() {
        return interest_method_c;
    }

    public void setInterest_method_c(Short interest_method_c) {
        this.interest_method_c = interest_method_c;
    }

    public String getPlan2operating_date() {
        return plan2operating_date;
    }

    public void setPlan2operating_date(String plan2operating_date) {
        this.plan2operating_date = plan2operating_date;
    }

    public Short getPlan_lease_date() {
        return plan_lease_date;
    }

    public void setPlan_lease_date(Short plan_lease_date) {
        this.plan_lease_date = plan_lease_date;
    }

    public Integer getLease_times() {
        return lease_times;
    }

    public void setLease_times(Integer lease_times) {
        this.lease_times = lease_times;
    }

    public Short getLease_period_rule() {
        return lease_period_rule;
    }

    public void setLease_period_rule(Short lease_period_rule) {
        this.lease_period_rule = lease_period_rule;
    }

    public Short getCal_method_spec() {
        return cal_method_spec;
    }

    public void setCal_method_spec(Short cal_method_spec) {
        this.cal_method_spec = cal_method_spec;
    }

    public Short getPrepay_or_not() {
        return prepay_or_not;
    }

    public void setPrepay_or_not(Short prepay_or_not) {
        this.prepay_or_not = prepay_or_not;
    }

    public Short getHas_first_lease_date() {
        return has_first_lease_date;
    }

    public void setHas_first_lease_date(Short has_first_lease_date) {
        this.has_first_lease_date = has_first_lease_date;
    }

    public String getFirst_lease_date() {
        return first_lease_date;
    }

    public void setFirst_lease_date(String first_lease_date) {
        this.first_lease_date = first_lease_date;
    }

    public String getFinal_date() {
        return final_date;
    }

    public void setFinal_date(String final_date) {
        this.final_date = final_date;
    }

    public Integer getLast_term_days() {
        return last_term_days;
    }

    public void setLast_term_days(Integer last_term_days) {
        this.last_term_days = last_term_days;
    }

    public Short getLease_adjust_type() {
        return lease_adjust_type;
    }

    public void setLease_adjust_type(Short lease_adjust_type) {
        this.lease_adjust_type = lease_adjust_type;
    }

    public Short getLease_freq() {
        return lease_freq;
    }

    public void setLease_freq(Short lease_freq) {
        this.lease_freq = lease_freq;
    }

    public Short getLease_cal_method() {
        return lease_cal_method;
    }

    public void setLease_cal_method(Short lease_cal_method) {
        this.lease_cal_method = lease_cal_method;
    }

    public Integer getInterval_in_advance() {
        return interval_in_advance;
    }

    public void setInterval_in_advance(Integer interval_in_advance) {
        this.interval_in_advance = interval_in_advance;
    }

    public Short getInterest_method_total_loan() {
        return interest_method_total_loan;
    }

    public void setInterest_method_total_loan(Short interest_method_total_loan) {
        this.interest_method_total_loan = interest_method_total_loan;
    }

    public Short getYear_days() {
        return year_days;
    }

    public void setYear_days(Short year_days) {
        this.year_days = year_days;
    }

    public Short getYear_days_irr() {
        return year_days_irr;
    }

    public void setYear_days_irr(Short year_days_irr) {
        this.year_days_irr = year_days_irr;
    }

    public Short getYear_days_flow() {
        return year_days_flow;
    }

    public void setYear_days_flow(Short year_days_flow) {
        this.year_days_flow = year_days_flow;
    }

    public Short getCal_digit() {
        return cal_digit;
    }

    public void setCal_digit(Short cal_digit) {
        this.cal_digit = cal_digit;
    }

    public Short getInterrate_type() {
        return interrate_type;
    }

    public void setInterrate_type(Short interrate_type) {
        this.interrate_type = interrate_type;
    }

    public BigDecimal getFixed_interrate() {
        return fixed_interrate;
    }

    public void setFixed_interrate(BigDecimal fixed_interrate) {
        this.fixed_interrate = fixed_interrate;
    }

    public Short getFloat_method() {
        return float_method;
    }

    public void setFloat_method(Short float_method) {
        this.float_method = float_method;
    }

    public InterrateRefVO getPk_interrate() {
        return pk_interrate;
    }

    public void setPk_interrate(InterrateRefVO pk_interrate) {
        this.pk_interrate = pk_interrate;
    }

    public Short getInterrate_level() {
        return interrate_level;
    }

    public void setInterrate_level(Short interrate_level) {
        this.interrate_level = interrate_level;
    }

    public BigDecimal getInterrate() {
        return interrate;
    }

    public void setInterrate(BigDecimal interrate) {
        this.interrate = interrate;
    }

    public BigDecimal getFloat_value() {
        return float_value;
    }

    public void setFloat_value(BigDecimal float_value) {
        this.float_value = float_value;
    }

    public BigDecimal getFinal_rate() {
        return final_rate;
    }

    public void setFinal_rate(BigDecimal final_rate) {
        this.final_rate = final_rate;
    }

    public Short getReturn_method_depos() {
        return return_method_depos;
    }

    public void setReturn_method_depos(Short return_method_depos) {
        this.return_method_depos = return_method_depos;
    }

    public Short getIf_interest_depos() {
        return if_interest_depos;
    }

    public void setIf_interest_depos(Short if_interest_depos) {
        this.if_interest_depos = if_interest_depos;
    }

    public Short getInterrate_type_depos() {
        return interrate_type_depos;
    }

    public void setInterrate_type_depos(Short interrate_type_depos) {
        this.interrate_type_depos = interrate_type_depos;
    }

    public Short getInterrate_level_depos() {
        return interrate_level_depos;
    }

    public void setInterrate_level_depos(Short interrate_level_depos) {
        this.interrate_level_depos = interrate_level_depos;
    }

    public BigDecimal getInterrate_depos() {
        return interrate_depos;
    }

    public void setInterrate_depos(BigDecimal interrate_depos) {
        this.interrate_depos = interrate_depos;
    }

    public Short getFloat_method_depos() {
        return float_method_depos;
    }

    public void setFloat_method_depos(Short float_method_depos) {
        this.float_method_depos = float_method_depos;
    }

    public InterrateRefVO getPk_interrate_depos() {
        return pk_interrate_depos;
    }

    public void setPk_interrate_depos(InterrateRefVO pk_interrate_depos) {
        this.pk_interrate_depos = pk_interrate_depos;
    }

    public BigDecimal getFloat_value_depos() {
        return float_value_depos;
    }

    public void setFloat_value_depos(BigDecimal float_value_depos) {
        this.float_value_depos = float_value_depos;
    }

    public BigDecimal getFinal_rate_depos() {
        return final_rate_depos;
    }

    public void setFinal_rate_depos(BigDecimal final_rate_depos) {
        this.final_rate_depos = final_rate_depos;
    }

    public String getMemo_depos() {
        return memo_depos;
    }

    public void setMemo_depos(String memo_depos) {
        this.memo_depos = memo_depos;
    }

    public Short getInterrest_method() {
        return interrest_method;
    }

    public void setInterrest_method(Short interrest_method) {
        this.interrest_method = interrest_method;
    }

    public BigDecimal getRadio_hyear() {
        return radio_hyear;
    }

    public void setRadio_hyear(BigDecimal radio_hyear) {
        this.radio_hyear = radio_hyear;
    }

    public Short getLast_term_rule() {
        return last_term_rule;
    }

    public void setLast_term_rule(Short last_term_rule) {
        this.last_term_rule = last_term_rule;
    }

    public BigDecimal getCommercial_irr() {
        return commercial_irr;
    }

    public void setCommercial_irr(BigDecimal commercial_irr) {
        this.commercial_irr = commercial_irr;
    }

    public BigDecimal getVat_irr() {
        return vat_irr;
    }

    public void setVat_irr(BigDecimal vat_irr) {
        this.vat_irr = vat_irr;
    }

    public BigDecimal getFinance_irr() {
        return finance_irr;
    }

    public void setFinance_irr(BigDecimal finance_irr) {
        this.finance_irr = finance_irr;
    }

    public BigDecimal getFinance_notax_irr() {
        return finance_notax_irr;
    }

    public void setFinance_notax_irr(BigDecimal finance_notax_irr) {
        this.finance_notax_irr = finance_notax_irr;
    }

    public BigDecimal getRent_irr() {
        return rent_irr;
    }

    public void setRent_irr(BigDecimal rent_irr) {
        this.rent_irr = rent_irr;
    }

    public BigDecimal getProject_irr() {
        return project_irr;
    }

    public void setProject_irr(BigDecimal project_irr) {
        this.project_irr = project_irr;
    }

    public BigDecimal getProject_notax_irr() {
        return project_notax_irr;
    }

    public void setProject_notax_irr(BigDecimal project_notax_irr) {
        this.project_notax_irr = project_notax_irr;
    }

    public BigDecimal getProject_irr_consult() {
        return project_irr_consult;
    }

    public void setProject_irr_consult(BigDecimal project_irr_consult) {
        this.project_irr_consult = project_irr_consult;
    }

    public BigDecimal getProject_notax_irr_consult() {
        return project_notax_irr_consult;
    }

    public void setProject_notax_irr_consult(BigDecimal project_notax_irr_consult) {
        this.project_notax_irr_consult = project_notax_irr_consult;
    }

    public BigDecimal getFee_distr_irr() {
        return fee_distr_irr;
    }

    public void setFee_distr_irr(BigDecimal fee_distr_irr) {
        this.fee_distr_irr = fee_distr_irr;
    }

    public Short getIf_corpus_tickets() {
        return if_corpus_tickets;
    }

    public void setIf_corpus_tickets(Short if_corpus_tickets) {
        this.if_corpus_tickets = if_corpus_tickets;
    }

    public Short getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
    }

    public String getOperate_date() {
        return operate_date;
    }

    public void setOperate_date(String operate_date) {
        this.operate_date = operate_date;
    }

    public String getOperate_time() {
        return operate_time;
    }

    public void setOperate_time(String operate_time) {
        this.operate_time = operate_time;
    }

    public String getCheck_date() {
        return check_date;
    }

    public void setCheck_date(String check_date) {
        this.check_date = check_date;
    }

    public String getCheck_time() {
        return check_time;
    }

    public void setCheck_time(String check_time) {
        this.check_time = check_time;
    }

    public UserRefVO getPk_grantor() {
        return pk_grantor;
    }

    public void setPk_grantor(UserRefVO pk_grantor) {
        this.pk_grantor = pk_grantor;
    }

    public String getGrant_date() {
        return grant_date;
    }

    public void setGrant_date(String grant_date) {
        this.grant_date = grant_date;
    }

    public String getGrant_time() {
        return grant_time;
    }

    public void setGrant_time(String grant_time) {
        this.grant_time = grant_time;
    }

    public OrgRefVO getPk_org() {
        return pk_org;
    }

    public void setPk_org(OrgRefVO pk_org) {
        this.pk_org = pk_org;
    }

    public DeptdocRefVO getPk_dept() {
        return pk_dept;
    }

    public void setPk_dept(DeptdocRefVO pk_dept) {
        this.pk_dept = pk_dept;
    }

    public List<LeaseLoanPlanVO> getLease_loan_plan() {
        return lease_loan_plan;
    }

    public void setLease_loan_plan(List<LeaseLoanPlanVO> lease_loan_plan) {
        this.lease_loan_plan = lease_loan_plan;
    }

    public List<LeaseRulePVO> getLease_rule() {
        return lease_rule;
    }

    public void setLease_rule(List<LeaseRulePVO> lease_rule) {
        this.lease_rule = lease_rule;
    }

    public List<InoutPlanPVO> getInout_plan_deposit() {
        return inout_plan_deposit;
    }

    public void setInout_plan_deposit(List<InoutPlanPVO> inout_plan_deposit) {
        this.inout_plan_deposit = inout_plan_deposit;
    }

    public List<InoutPlanPVO> getInout_plan_srvin() {
        return inout_plan_srvin;
    }

    public void setInout_plan_srvin(List<InoutPlanPVO> inout_plan_srvin) {
        this.inout_plan_srvin = inout_plan_srvin;
    }

    public List<InoutPlanPVO> getInout_plan_srvot() {
        return inout_plan_srvot;
    }

    public void setInout_plan_srvot(List<InoutPlanPVO> inout_plan_srvot) {
        this.inout_plan_srvot = inout_plan_srvot;
    }

    public List<InoutPlanPVO> getInout_plan_other() {
        return inout_plan_other;
    }

    public void setInout_plan_other(List<InoutPlanPVO> inout_plan_other) {
        this.inout_plan_other = inout_plan_other;
    }

    public List<InoutPlanPVO> getInout_plan() {
        return inout_plan;
    }

    public void setInout_plan(List<InoutPlanPVO> inout_plan) {
        this.inout_plan = inout_plan;
    }

    public List<InoutPlanPVO> getInout_plan_market() {
        return inout_plan_market;
    }

    public void setInout_plan_market(List<InoutPlanPVO> inout_plan_market) {
        this.inout_plan_market = inout_plan_market;
    }

    public List<InoutPlanPVO> getInout_plan_beforeLoan() {
        return inout_plan_beforeLoan;
    }

    public void setInout_plan_beforeLoan(List<InoutPlanPVO> inout_plan_beforeLoan) {
        this.inout_plan_beforeLoan = inout_plan_beforeLoan;
    }

    public BigDecimal getContract_irr() {
        return contract_irr;
    }

    public void setContract_irr(BigDecimal contract_irr) {
        this.contract_irr = contract_irr;
    }

    public BigDecimal getAudit_irr() {
        return audit_irr;
    }

    public void setAudit_irr(BigDecimal audit_irr) {
        this.audit_irr = audit_irr;
    }

    public BigDecimal getLessee_irr() {
        return lessee_irr;
    }

    public void setLessee_irr(BigDecimal lessee_irr) {
        this.lessee_irr = lessee_irr;
    }

    public ContractRefVO getPk_contract() {
        return pk_contract;
    }

    public void setPk_contract(ContractRefVO pk_contract) {
        this.pk_contract = pk_contract;
    }

    public BigDecimal getFact_initial_cash() {
        return fact_initial_cash;
    }

    public void setFact_initial_cash(BigDecimal fact_initial_cash) {
        this.fact_initial_cash = fact_initial_cash;
    }

    public BigDecimal getLease_cash_sum() {
        return lease_cash_sum;
    }

    public void setLease_cash_sum(BigDecimal lease_cash_sum) {
        this.lease_cash_sum = lease_cash_sum;
    }

    public BigDecimal getLease_interest_sum() {
        return lease_interest_sum;
    }

    public void setLease_interest_sum(BigDecimal lease_interest_sum) {
        this.lease_interest_sum = lease_interest_sum;
    }

    public Short getQuot_status() {
        return quot_status;
    }

    public void setQuot_status(Short quot_status) {
        this.quot_status = quot_status;
    }

    public Integer getQuot_valid() {
        return quot_valid;
    }

    public void setQuot_valid(Integer quot_valid) {
        this.quot_valid = quot_valid;
    }

    public String getQuot_start_date() {
        return quot_start_date;
    }

    public void setQuot_start_date(String quot_start_date) {
        this.quot_start_date = quot_start_date;
    }

    public String getQuot_end_date() {
        return quot_end_date;
    }

    public void setQuot_end_date(String quot_end_date) {
        this.quot_end_date = quot_end_date;
    }

    public Integer getYear_times() {
        return year_times;
    }

    public void setYear_times(Integer year_times) {
        this.year_times = year_times;
    }

    public Short getIf_cont_quote() {
        return if_cont_quote;
    }

    public void setIf_cont_quote(Short if_cont_quote) {
        this.if_cont_quote = if_cont_quote;
    }

    public String getData_source_bill() {
        return data_source_bill;
    }

    public void setData_source_bill(String data_source_bill) {
        this.data_source_bill = data_source_bill;
    }

    public String getData_source_billtype() {
        return data_source_billtype;
    }

    public void setData_source_billtype(String data_source_billtype) {
        this.data_source_billtype = data_source_billtype;
    }

    public BigDecimal getBrokerage_in() {
        return brokerage_in;
    }

    public void setBrokerage_in(BigDecimal brokerage_in) {
        this.brokerage_in = brokerage_in;
    }

    public CustomerRefVO getPk_customer() {
        return pk_customer;
    }

    public void setPk_customer(CustomerRefVO pk_customer) {
        this.pk_customer = pk_customer;
    }

    public Short getAnnualized_rate_method() {
        return annualized_rate_method;
    }

    public void setAnnualized_rate_method(Short annualized_rate_method) {
        this.annualized_rate_method = annualized_rate_method;
    }

    public BigDecimal getAnnualized_rate() {
        return annualized_rate;
    }

    public void setAnnualized_rate(BigDecimal annualized_rate) {
        this.annualized_rate = annualized_rate;
    }

    public String getOther_assure_method() {
        return other_assure_method;
    }

    public void setOther_assure_method(String other_assure_method) {
        this.other_assure_method = other_assure_method;
    }

    public String getDeposit_start_date() {
        return deposit_start_date;
    }

    public void setDeposit_start_date(String deposit_start_date) {
        this.deposit_start_date = deposit_start_date;
    }

    public BigDecimal getDeposit_interest() {
        return deposit_interest;
    }

    public void setDeposit_interest(BigDecimal deposit_interest) {
        this.deposit_interest = deposit_interest;
    }

    public Integer getSpecial_limit() {
        return special_limit;
    }

    public void setSpecial_limit(Integer special_limit) {
        this.special_limit = special_limit;
    }

    public Short getRepayment_interest_period() {
        return repayment_interest_period;
    }

    public void setRepayment_interest_period(Short repayment_interest_period) {
        this.repayment_interest_period = repayment_interest_period;
    }

    public Short getRepayment_corpus_period() {
        return repayment_corpus_period;
    }

    public void setRepayment_corpus_period(Short repayment_corpus_period) {
        this.repayment_corpus_period = repayment_corpus_period;
    }

    public BigDecimal getRepayment_corpus_cash() {
        return repayment_corpus_cash;
    }

    public void setRepayment_corpus_cash(BigDecimal repayment_corpus_cash) {
        this.repayment_corpus_cash = repayment_corpus_cash;
    }

    public BigDecimal getSpecial_final_rate() {
        return special_final_rate;
    }

    public void setSpecial_final_rate(BigDecimal special_final_rate) {
        this.special_final_rate = special_final_rate;
    }

    public Short getSpecial_interrate_level() {
        return special_interrate_level;
    }

    public void setSpecial_interrate_level(Short special_interrate_level) {
        this.special_interrate_level = special_interrate_level;
    }

    public BigDecimal getSpecial_interrate() {
        return special_interrate;
    }

    public void setSpecial_interrate(BigDecimal special_interrate) {
        this.special_interrate = special_interrate;
    }

    public Short getSpecial_interrate_type() {
        return special_interrate_type;
    }

    public void setSpecial_interrate_type(Short special_interrate_type) {
        this.special_interrate_type = special_interrate_type;
    }

    public Short getSpecial_float_method() {
        return special_float_method;
    }

    public void setSpecial_float_method(Short special_float_method) {
        this.special_float_method = special_float_method;
    }

    public BigDecimal getSpecial_float_value() {
        return special_float_value;
    }

    public void setSpecial_float_value(BigDecimal special_float_value) {
        this.special_float_value = special_float_value;
    }

    public InterrateRefVO getPk_special_interrate() {
        return pk_special_interrate;
    }

    public void setPk_special_interrate(InterrateRefVO pk_special_interrate) {
        this.pk_special_interrate = pk_special_interrate;
    }

    public BigDecimal getFact_initial_ratio() {
        return fact_initial_ratio;
    }

    public void setFact_initial_ratio(BigDecimal fact_initial_ratio) {
        this.fact_initial_ratio = fact_initial_ratio;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public CalculatorVO() {
    }

    public CurrtypeRefVO getPk_currtype() {
        return pk_currtype;
    }

    public void setPk_currtype(CurrtypeRefVO pk_currtype) {
        this.pk_currtype = pk_currtype;
    }

    public Short getSrvfee_base_out() {
        return srvfee_base_out;
    }

    public void setSrvfee_base_out(Short srvfee_base_out) {
        this.srvfee_base_out = srvfee_base_out;
    }

    public Short getCal_ratio_base() {
        return cal_ratio_base;
    }

    public void setCal_ratio_base(Short cal_ratio_base) {
        this.cal_ratio_base = cal_ratio_base;
    }

    public Short getIrr_object() {
        return irr_object;
    }

    public void setIrr_object(Short irr_object) {
        this.irr_object = irr_object;
    }

    public BigDecimal getExpect_nominal_irr() {
        return expect_nominal_irr;
    }

    public void setExpect_nominal_irr(BigDecimal expect_nominal_irr) {
        this.expect_nominal_irr = expect_nominal_irr;
    }

    public BigDecimal getProject_average_interrate() {
        return project_average_interrate;
    }

    public void setProject_average_interrate(BigDecimal project_average_interrate) {
        this.project_average_interrate = project_average_interrate;
    }

    public UserRefVO getPk_operator() {
        return pk_operator;
    }

    public void setPk_operator(UserRefVO pk_operator) {
        this.pk_operator = pk_operator;
    }

    public UserRefVO getPk_checker() {
        return pk_checker;
    }

    public void setPk_checker(UserRefVO pk_checker) {
        this.pk_checker = pk_checker;
    }

    public IRRConvertParamVO getIrrParamVO() {
        return irrParamVO;
    }

    public void setIrrParamVO(IRRConvertParamVO irrParamVO) {
        this.irrParamVO = irrParamVO;
    }
}