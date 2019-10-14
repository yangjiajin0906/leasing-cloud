package com.leasing.calculate.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud 实际投放计划VO
 * @date:2019/9/26
 * @author:Yjj@yonyou.com
 * @description:
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="yls_lease_loan_plan")
public class LeaseLoanPlanVO {

    /**
     * 主键
     */
    @Id
    public String pk_lease_loan_plan;

    /**
     * 报价主键
     */
    @ManyToOne
    @JoinColumn(name="source_bill")
    @JsonBackReference //少的一方管理映射，将在测试结果中看出
    public CalculatorVO source_bill;
    /**
     * 计划投放日期
     */
    @Column(name="plan_date_loan")
    public String plan_date;
    /**
     * 投放金额
     */
    @Column(name="plan_cash_loan")
    public BigDecimal plan_cash;
    /**
     * 投放付款方式
     */
    @Column(name="pay_method_loan")
    public Short pay_method;
    /**
     * 银票开票日期
     */
    public String make_date_draft;
    /**
     * 银票到期日期
     */
    public String end_date_draft;
    /**
     * 银票保证金比例
     */
    public BigDecimal deposit_ratio4draft;
    /**
     * 银票保证金利率
     */
    public BigDecimal interrate_depos4draft;

    /**
     * 银票金额
     */
    //public BigDecimal bank_amount;
    /**
     * 索引编号
     */
    public Integer index_code;

    /**
     * 商业折扣
     */
    public BigDecimal trade_discount;
    /**
     * 因为开发初期没有想到
     * 投放的计划是计算日期会不同
     * 所以 后台使用了plan_date做算法的日期
     * 现在只好用right_date 存放 plan_date（计划日期）
     * 的过滤字段
     */
    //public String right_date;

    /**
     * 是否分配起始
     */
    public Short if_begin_plan;

    /**
     * 客户主键
     */
    @ManyToOne()
    @JoinColumn(name = "pk_customer", referencedColumnName = "pk_customer")
    public CustomerRefVO pk_customer;

    /**
     * 税率
     */
    public Short tax_rate;

    /**
     * 批次
     */
    public Integer loan_batch;

    /**
     * 计息金额计算方式
     */
    public Short calinterest_amount_style;

}