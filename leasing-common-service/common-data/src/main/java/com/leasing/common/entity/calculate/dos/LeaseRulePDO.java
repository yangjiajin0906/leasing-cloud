package com.leasing.common.entity.calculate.dos;

import com.leasing.common.base.entity.BaseDO;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud 规则测算器（规则设置子表）VO类
 * @date:2019/9/26
 * @author:Yjj@yonyou.com
 * @description:
 **/

@Entity
@Table(name="yls_lease_rule")
public class LeaseRulePDO extends BaseDO {

    /**
     * 主键
     */
    @Id
    public String pkLeaseRule;
    /**
     * 主表主键
     */
    public String sourceBill; //主表主键
    /**
     * 支付期次
     */
    public Integer leaseTime;
    /**
     * 支付频率
     */
    public Short leaseFreq;
    /**
     * 计算方式
     */
    public Short leaseCalMethod;
    /**
     * 金额/比例
     */
    public BigDecimal leaseCash;
    /**
     * 比例
     */
    public BigDecimal leaseRatio;
    /**
     * 数据类型
     */
    public String sourceBilltype;

    public LeaseRulePDO() {
    }

    @Override
    public String getPk() {
        return pkLeaseRule;
    }

    @Override
    public void setPk(String pk) {
        this.pkLeaseRule = pk;
    }

    public String getPkLeaseRule() {
        return pkLeaseRule;
    }

    public void setPkLeaseRule(String pkLeaseRule) {
        this.pkLeaseRule = pkLeaseRule;
    }

    public String getSourceBill() {
        return sourceBill;
    }

    public void setSourceBill(String sourceBill) {
        this.sourceBill = sourceBill;
    }

    public Integer getLeaseTime() {
        return leaseTime;
    }

    public void setLeaseTime(Integer leaseTime) {
        this.leaseTime = leaseTime;
    }

    public Short getLeaseFreq() {
        return leaseFreq;
    }

    public void setLeaseFreq(Short leaseFreq) {
        this.leaseFreq = leaseFreq;
    }

    public Short getLeaseCalMethod() {
        return leaseCalMethod;
    }

    public void setLeaseCalMethod(Short leaseCalMethod) {
        this.leaseCalMethod = leaseCalMethod;
    }

    public BigDecimal getLeaseCash() {
        return leaseCash;
    }

    public void setLeaseCash(BigDecimal leaseCash) {
        this.leaseCash = leaseCash;
    }

    public BigDecimal getLeaseRatio() {
        return leaseRatio;
    }

    public void setLeaseRatio(BigDecimal leaseRatio) {
        this.leaseRatio = leaseRatio;
    }

    public String getSourceBilltype() {
        return sourceBilltype;
    }

    public void setSourceBilltype(String sourceBilltype) {
        this.sourceBilltype = sourceBilltype;
    }
}