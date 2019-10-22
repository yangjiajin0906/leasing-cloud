package com.leasing.calculate.dos;
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
public class CalculatorDO {
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
     * 复核员主键 UserVO外键
     */
    public String pkChecker;

    /**
     * 限额方案 LimitPlanRefVO外键
     */
    public String pkLimitPlan;


    public CalculatorDO() {
    }

    public String getPkLeaseCalculator() {
        return pkLeaseCalculator;
    }

    public void setPkLeaseCalculator(String pkLeaseCalculator) {
        this.pkLeaseCalculator = pkLeaseCalculator;
    }

    public String getPkChecker() {
        return pkChecker;
    }

    public void setPkChecker(String pkChecker) {
        this.pkChecker = pkChecker;
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

    public String getPkLimitPlan() {
        return pkLimitPlan;
    }

    public void setPkLimitPlan(String pkLimitPlan) {
        this.pkLimitPlan = pkLimitPlan;
    }

}