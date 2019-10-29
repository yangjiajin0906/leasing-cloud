package com.leasing.rentearly.rentearlyservice.projectInfo.enity.refVO;

import com.leasing.common.base.entity.BaseRefVO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:jiaoshy@yonyou.com
 * @description: 限额方案参照
 **/
@Entity
@Table(name = "yls_limit_plan")
public class LimitPlanRefVO extends BaseRefVO {

    @Id
    public String pkLimitPlan;

    public String limitCode;

    public String limitName;

//    public LimitPlanRefVO(String pkLimitPlan, String limitCode, String limitName) {
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
}
