package com.leasing.customer.dao.dos;

import com.leasing.common.base.entity.BaseDO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yls_analysis_balance")
public class AnalysisBalanceDO extends BaseDO {


    /**
     * 主键
     */
    @Id
    private String pkAnalysisBalance;

    private String pkIndexAnalysis;

    private BigDecimal balanceCash;

    private Short balanceClass;

    private String balanceQuality;

    private String memo;

    public String getPkAnalysisBalance() {
        return pkAnalysisBalance;
    }

    public void setPkAnalysisBalance(String pkAnalysisBalance) {
        this.pkAnalysisBalance = pkAnalysisBalance;
    }

    public String getPkIndexAnalysis() {
        return pkIndexAnalysis;
    }

    public void setPkIndexAnalysis(String pkIndexAnalysis) {
        this.pkIndexAnalysis = pkIndexAnalysis;
    }

    public BigDecimal getBalanceCash() {
        return balanceCash;
    }

    public void setBalanceCash(BigDecimal balanceCash) {
        this.balanceCash = balanceCash;
    }

    public Short getBalanceClass() {
        return balanceClass;
    }

    public void setBalanceClass(Short balanceClass) {
        this.balanceClass = balanceClass;
    }

    public String getBalanceQuality() {
        return balanceQuality;
    }

    public void setBalanceQuality(String balanceQuality) {
        this.balanceQuality = balanceQuality;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String getPk() {
        return pkAnalysisBalance;
    }

    @Override
    public void setPk(String pk) {
        this.pkAnalysisBalance = pk;
    }
}