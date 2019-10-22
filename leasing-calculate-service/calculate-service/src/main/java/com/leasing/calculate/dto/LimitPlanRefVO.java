package com.leasing.calculate.dto;

import com.leasing.common.base.entity.BaseVO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud 限额方案RefVO
 * @date:2019/9/23
 * @author:Yjj@yonyou.com
 * @description:
 **/
@Entity
@Table(name="yls_limit_plan")
public class LimitPlanRefVO extends BaseVO {

    @Id
    public String pkLimitPlan;
    /**
     * 限额方案名称
     */
    public String limitName;
    /**
     * 限额方案编号
     */
    public String limitCode;
    /**
     * 备注
     */
    public String memo;

    public LimitPlanRefVO (){

    }

    @Override
    public String getPk() {
        return pkLimitPlan;
    }

    @Override
    public void setPk(String pk) {
        this.pkLimitPlan = pk;
    }
}