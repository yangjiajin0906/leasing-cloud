package com.leasing.rentearly.rentearlyservice.projectInfo.enity.dto;

import com.leasing.common.base.entity.BaseEntity;
import com.leasing.common.base.entity.BaseRefVO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:jiaoshy@yonyou.com
 * @description: 限额方案参照
 **/
@Entity
@Table(name = "yls_limit_plan")
public class LimitPlanDTO extends BaseEntity {

    @Id
    public String pkLimitPlan;

    public String limitCode;

    public String limitName;

//    public LimitPlanDTO(String pkLimitPlan, String limitCode, String limitName) {
//        this.pkLimitPlan = pkLimitPlan;
//        this.limitCode = limitCode;
//        this.limitName = limitName;
//        this.setPk(pkLimitPlan);
//        this.setCode(limitCode);
//        this.setName(limitName);
//    }

    public String getPkLimitPlan() {
        return pkLimitPlan;
    }

    public void setPkLimitPlan(String pkLimitPlan) {
        this.pkLimitPlan = pkLimitPlan;
    }

    public String getLimitCode() {
        return limitCode;
    }

    public void setLimitCode(String limitCode) {
        this.limitCode = limitCode;
    }

    public String getLimitName() {
        return limitName;
    }

    public void setLimitName(String limitName) {
        this.limitName = limitName;
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
