package com.leasing.calculate.vo;

import com.leasing.calculate.dto.LimitPlanRefVO;
import com.leasing.common.base.entity.BaseBusinessVO;
import com.leasing.common.vo.foundation.UserVO;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019/9/23
 * @author:Yjj@yonyou.com
 * @description: 报价VO
 **/

@Entity
@Table(name="yls_lease_calculator")
public class CalculatorVO extends BaseBusinessVO {

    /**
     * 主键
     */
    @Id
    public String pkLeaseCalculator;
    /**
     * 测算方案编号
     */
    public String quotCode;
    /**
     * 测算方案名称
     */
    public String quotName;
    /**
     * 复核员主键
     */
    @ManyToOne()
    @JoinColumn(name = "pkChecker")
    public UserVO pkChecker;

    /**
     * 限额方案
     */
    @ManyToOne()
    @JoinColumn(name = "pkLimitPlan")
    public LimitPlanRefVO pkLimitPlan;

    /**
     * 限额方案名称
     */
    public String limitName;

    /**
     * 是否不规则测算 -- (数据库没有该字段)
     */
    @Transient
    public Boolean ifIrregularCal;

    public String getPkLeaseCalculator() {
        return pkLeaseCalculator;
    }

    public void setPkLeaseCalculator(String pkLeaseCalculator) {
        this.pkLeaseCalculator = pkLeaseCalculator;
    }

//    public UserVO getPkChecker() {
//        return pkChecker;
//    }
//
//    public void setPkChecker(UserVO pkChecker) {
//        this.pkChecker = pkChecker;
//    }

    @Override
    public String getPk() {
        return this.pkLeaseCalculator;
    }

    @Override
    public void setPk(String pk) {
        this.pkLeaseCalculator = pk;
    }


    public CalculatorVO() {
    }

    public String getLimitName() {
        return limitName;
    }

    public void setLimitName(String limitName) {
        this.limitName = limitName;
    }

    public String getQuotCode() {
        return quotCode;
    }

    public void setQuotCode(String quotCode) {
        this.quotCode = quotCode;
    }

    public String getQuotName() {
        return quotName;
    }

    public void setQuotName(String quotName) {
        this.quotName = quotName;
    }

    public Boolean getIfIrregularCal() {
        return ifIrregularCal;
    }

    public void setIfIrregularCal(Boolean ifIrregularCal) {
        this.ifIrregularCal = ifIrregularCal;
    }

    public LimitPlanRefVO getPkLimitPlan() {
        return pkLimitPlan;
    }

    public void setPkLimitPlan(LimitPlanRefVO pkLimitPlan) {
        this.pkLimitPlan = pkLimitPlan;
    }


    @Override
    public String toString() {
        return "CalculatorVO{" +
                "pkLeaseCalculator='" + pkLeaseCalculator + '\'' +
                ", quotCode='" + quotCode + '\'' +
                ", quotName='" + quotName + '\'' +

                '}';
    }
}