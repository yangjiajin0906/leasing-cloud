package com.leasing.calculate.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * @project:leasing-cloud 报价VO
 * @date:2019/9/23
 * @author:Yjj@yonyou.com
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="yls_lease_calculator")
public class CalculatorVO {
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
    //public LimitPlanRefVO pk_limit_plan;

    /**
     * 计息金额计算方式
     */
    public Short calinterest_amount_style;


    /**
     * 合同编号
     */
    //public ContractRefVO pk_contract;

    /**
     * 投放日期
     */
    public String plan_date_loan;

    /**
     * 实际投放日期，用于处理起租变更对于已付款的投放金额投放日期
     */
    //public String fact_plan_date_loan;


    /**
     * 币种
     */
    //public CurrtypeRefVO pk_currtype;




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
    //public Short srvfee_base_out;


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
     * 计算比例基数(运行参数中取值)
     */
    //public Short cal_ratio_base;

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
    //public InterrateRefVO pk_interrate_c;

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
    //public InterrateRefVO pk_interrate;


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
    //public InterrateRefVO pk_interrate_depos;

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
    //public Short irr_object;

    /**
     * IRR倒算期望IRR
     */
    //public BigDecimal expect_nominal_irr;

    /**
     * 项目平息率
     */
    //public BigDecimal project_average_interrate;

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
    //public UserRefVO pk_operator;

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
    //public UserRefVO pk_checker;

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
    //public UserRefVO pk_grantor;

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
    //public OrgRefVO pk_org;

    /**
     * 部门
     */
    //public DeptdocRefVO  pk_dept;
    /**
     * 投放计划（子表）
     */
    //public Set lease_loan_plan;
    /**
     * 规则设置（子表）
     */
//    public Set lease_rule;
//    /**
//     * 风险金计划（子表）
//     */
//    public Set inout_plan_deposit;
    /**
     * 服务费收入（子表） --展现
     */
    //public Set inout_plan_srvin;
    /**
     * 服务费支出（子表） --展现
     */
    //public Set inout_plan_srvot;
    /**
     * 其他收支计划（子表） --展现
     */
    //public Set inout_plan_other;
    /**
     * 租金计划表（子表） --展现
     */
    //public Set inout_plan;

    /**
     * 收支计划（子表）市场  --存储
     */
    //public Set inout_plan_market;

    /**
     * 本次投放之前的租金计划表
     */
    //public List inout_plan_beforeLoan;



    //public IRRConvertParamVO irrParamVO;

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
    //public ContractRefVO pk_contract;


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
    //public CustomerRefVO pk_customer;

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
    //public InterrateRefVO pk_special_interrate;

    /**
     * 客户实际期初金额占比
     */
    public BigDecimal fact_initial_ratio;

    /**
     * 是否固定收租日
     */
    //public Short if_fixday;

}