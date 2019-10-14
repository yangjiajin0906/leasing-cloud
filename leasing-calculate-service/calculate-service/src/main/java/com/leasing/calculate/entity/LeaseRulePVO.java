package com.leasing.calculate.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.leasing.calculate.entity.CalculatorVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud 规则测算器（规则设置子表）VO类
 * @date:2019/9/26
 * @author:Yjj@yonyou.com
 * @description:
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="yls_lease_rule")
public class LeaseRulePVO {

    /**
     * 主键
     */
    @Id
    public String pk_lease_rule;
    /**
     * 主表主键
     */
    @ManyToOne
    @JoinColumn(name="source_bill")
    @JsonBackReference //少的一方管理映射，将在测试结果中看出
    public CalculatorVO pk_lease_calculator; //主表主键
    /**
     * 支付期次
     */
    public Integer lease_time;
    /**
     * 支付频率
     */
    public Short lease_freq;
    /**
     * 计算方式
     */
    public Short lease_cal_method;
    /**
     * 金额/比例
     */
    public BigDecimal lease_cash;
    /**
     * 比例
     */
    public BigDecimal lease_ratio;
    /**
     * 数据类型
     */
    public String source_billtype;

}