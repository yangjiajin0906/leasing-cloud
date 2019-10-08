package com.leasing.calculate.vo;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud 限额方案VO
 * @date:2019/9/23
 * @author:Yjj@yonyou.com
 * @description:
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="yls_limit_plan")
public class LimitPlanVO {

    /**
     * 主键
     */
    @Id    //主键id
    public String pk_limit_plan;


    /**
     * 限额方案名称
     */
    public String limit_name;


    /**
     * 限额方案编号
     */
    public String limit_code;

    /**
     * 启用日期
     */
    public String start_date;


    /**
     * 截止日期
     */
    public String end_date;

    /**
     * 统计起始日期
     */
    public String count_start_date;

    /**
     * 统计截止日期
     */
    public String count_end_date;

    /**
     * 限额方案类型
     */
    //public ParmsRefVO pk_funid;

    /**
     * 部门主键
     */
    //public DeptdocRefVO pk_dept;

    /**
     * 备注
     */
    public String memo;


    /**
     * 单据状态
     */
    public Short billstatus;


    /**
     * 操作人
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
     * 复核人
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
     * 机构
     */
    //public OrgRefVO pk_org;
    /**
     * 限额方案设置(子表)
     */
    //public Set limit_plan_b;
}