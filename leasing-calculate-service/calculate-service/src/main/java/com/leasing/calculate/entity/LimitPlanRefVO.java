package com.leasing.calculate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud 限额方案RefVO
 * @date:2019/9/23
 * @author:Yjj@yonyou.com
 * @description:
 **/
@AllArgsConstructor
@Entity
@Table(name="yls_limit_plan")
public class LimitPlanRefVO {

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
     * 备注
     */
    public String memo;

    public LimitPlanRefVO (){

    }

    /**
     * 限额方案名称的getter方法
     *
     * @return String
     */
    public String getLimit_name() {
        return limit_name;
    }

    /**
     * 限额方案名称的setter方法
     *
     * @param limit_name 限额方案名称
     */
    public void setLimit_name(String limit_name) {
        this.limit_name = limit_name;
    }

    /**
     * 限额方案编号的getter方法
     *
     * @return String
     */
    public String getLimit_code() {
        return limit_code;
    }

    /**
     * 限额方案编号的setter方法
     *
     * @param limit_code 限额方案编号
     */
    public void setLimit_code(String limit_code) {
        this.limit_code = limit_code;
    }

    /**
     * 备注的getter方法
     *
     * @return String
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 备注的setter方法
     *
     * @param memo 备注
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

}