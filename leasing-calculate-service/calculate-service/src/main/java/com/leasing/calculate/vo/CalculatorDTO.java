//package com.leasing.calculate.vo;
//
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import lombok.*;
//import org.hibernate.annotations.Where;
//import org.springframework.beans.BeanUtils;
//
//import javax.persistence.CascadeType;
//import javax.persistence.FetchType;
//import javax.persistence.OneToMany;
//import javax.persistence.OrderBy;
//import java.util.List;
//import java.util.Set;
//
///**
// * @project:leasing-cloud
// * @date:2019/9/27
// * @author:Yjj@yonyou.com
// * @description:
// **/
//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@EqualsAndHashCode(callSuper = true)
//public class CalculatorDTO extends CalculatorVO {
//    /**
//     * 投放计划（子表）
//     */
//    public List<LeaseLoanPlanVO> lease_loan_plan;
//    /**
//     * 规则设置（子表）
//     */
//    public List<LeaseRulePVO> lease_rule;
//    /**
//     * 风险金计划（子表）
//     */
//    public List<LeaseRulePVO> inout_plan_deposit;
//    /**
//     * 服务费收入（子表） --展现
//     */
//    public List<LeaseRulePVO> inout_plan_srvin;
//    /**
//     * 服务费支出（子表） --展现
//     */
//    public List<LeaseRulePVO> inout_plan_srvot;
//    /**
//     * 其他收支计划（子表） --展现
//     */
//    public List<LeaseRulePVO> inout_plan_other;
//    /**
//     * 租金计划表（子表） --展现
//     */
//    public List<InoutPlanPVO> inout_plan;
//
//    /**
//     * 收支计划（子表）市场  --存储
//     */
//    public List<InoutPlanPVO> inout_plan_market;
//
//    /**
//     * 本次投放之前的租金计划表
//     */
//    public List<InoutPlanPVO> inout_plan_beforeLoan;
//
//    public static CalculatorDTO entityToDTO(CalculatorVO calculatorVO){
//        CalculatorDTO calculatorDTO = new CalculatorDTO();
//        BeanUtils.copyProperties(calculatorVO,calculatorDTO);
//        return calculatorDTO;
//    }
//
//}