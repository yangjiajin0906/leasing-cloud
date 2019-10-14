package com.leasing.calculate.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud 规则测算器（收支计划子表）VO类
 * @date:2019/9/26
 * @author:Yjj@yonyou.com
 * @description:
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="yls_inout_plan")
public class InoutPlanPVO {
    /**
     * 主键
     */
    @Id
    public String pk_inout_plan;
    /**
     * 主表主键
     */
    @ManyToOne
    @JoinColumn(name="source_bill")
    @JsonBackReference //少的一方管理映射，将在测试结果中看出
    public CalculatorVO source_bill; //主表主键

    /**
     * 收取期次
     */
    public String lease_time;
    /**
     * 计算日期
     */
    public String cal_date;
    /**
     * 计划收取日期
     */
    public String plan_date;
    /**
     * 交易类别
     */
    //public EventTypeRefVO trans_type;
    /**
     * 收支方向
     */
    public Short direction;
    /**
     * 租金
     */
    public BigDecimal lease_cash;
    public BigDecimal fact_cash;
    /**
     * 租金税额
     */
    public BigDecimal lease_cash_tax;

    /**
     * 租金(不含税)
     */
    //public BigDecimal lease_cash_corpus;

    /**
     * 利息
     */
    public BigDecimal lease_interest;
    /**
     * 利息税额
     */
    public BigDecimal lease_interest_tax;

    /**
     * 利息去税
     */
    //public BigDecimal lease_interest_notax;
    /**
     * 利息去税(会计)
     */
    //public BigDecimal lease_interest_notax_fin;
    /**
     * 本金
     */
    public BigDecimal lease_corpus;
    /**
     * 本金税额
     */
    public BigDecimal lease_corpus_tax;
    /**
     * 本金去税
     */
    //public BigDecimal lease_corpus_notax;
    /**
     * 本金去税(会计)
     */
    //public BigDecimal lease_corpus_notax_fin;
    /**
     * 租金去税
     */
    //public BigDecimal lease_cash_notax;
    /**
     * 租金去税(会计)
     */
    //public BigDecimal lease_cash_notax_fin;
    /**
     * 剩余本金
     */
    public BigDecimal corpus_balance;
    /**
     * 剩余租金
     */
    public BigDecimal lease_balance;
    /**
     * 手续费分摊金额
     */
    public BigDecimal srvfee_share;

    /**
     * 租金浮动比例
     */
    public BigDecimal rent_float_ratio;

    /**
     * 利率上浮
     */
    public BigDecimal rate_up;

    /**
     * 备注
     */
    public String memo;

    /**
     * 生成方式
     */
    public Short make_method;

    /**
     * 租金表类型
     */
    public Short rent_type;

    @ManyToOne()
    @JoinColumn(name = "pk_customer", referencedColumnName = "pk_customer")
    public CustomerRefVO pk_customer;

    /**
     * 数据类型
     */
    public String source_billtype;
    /**
     * 合同信息
     */
    @ManyToOne()
    @JoinColumn(name = "pk_contract", referencedColumnName = "pk_contract")
    public ContractRefVO pk_contract;

    /**
     * 租赁收入
     */
    public BigDecimal lease_cash_in;
    /**
     * 其中:去税租息
     */
    public BigDecimal no_tax_interest;
    /**
     * 其中:去税手续费收入
     */
    public BigDecimal no_tax_srvfee;
    /**
     * 其中:去税其它支出
     */
    public BigDecimal no_tax_otherout;
    /**
     * 其中:去税其它收入
     */
    public BigDecimal no_tax_otherin;
    /**
     * 税金
     */
    public BigDecimal sum_tax;

    /**
     * 商业折扣
     */
    public BigDecimal trade_discount;

    /**
     * 税率
     */
    public Short tax_rate;

    /**
     * 新去税租息
     */
    public BigDecimal input_tax;

    /**
     * 进项税
     */
    public BigDecimal input_tax_diff;

    /**
     * 本金冻结金额(票)
     */
    public BigDecimal ticket_freeze_corpus;
    /**本金实际发生金额(票)*/
    public BigDecimal ticket_fact_corpus;
    /**利息冻结金额(票)*/
    public BigDecimal ticket_freeze_interest;
    /**利息实际发生金额(票)*/
    public BigDecimal ticket_fact_interest;
    /**财务逾期金额*/
    public BigDecimal f_overdue_cash;
    /**财务预收租金冲抵金额*/
    public BigDecimal f_advance_against_cash;
    /**存入保证金冲抵金额*/
    public BigDecimal f_deposit_against_cash;
    /**利息已确认金额*/
    public BigDecimal interest_affirm_cash;
    /**减免罚息*/
    public BigDecimal del_penalty_cash;
    /**还款占比*/
    public BigDecimal repayment_ratio;
    /**冻结金额(款)*/
    public BigDecimal freeze_cash;
    /**会计租金*/
    public BigDecimal lease_cash_fin;
    /**会计本金*/
    public BigDecimal lease_corpus_fin;
    /**会计利息*/
    public BigDecimal lease_interest_fin;
    /**
     * 租金税额(重算)
     */
    public BigDecimal lease_cash_tax_fin;
    /**
     * 利息税额(重算)
     */
    public BigDecimal lease_interest_tax_fin;
    /**
     * 本金税额(重算)
     */
    public BigDecimal lease_corpus_tax_fin;
    /**
     * 剩余本金(重算)
     */
    public BigDecimal corpus_balance_fin;


    /**
     * 分拆租金（中投）
     */
    public BigDecimal divide_cash;
    /**
     * 分拆本金（中投）
     */
    public BigDecimal divide_corpus;
    /**
     * 分拆利息（中投）
     */
    public BigDecimal divide_interest;


    /**
     * 合同
     */
    //public ContractCRefVO pk_contract_c;

    /**
     * 核销状态
     */
    public Short charge_off_status;

    /** ADD WJJ 20160701 */
    public Short tax_mode;
}