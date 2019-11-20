package com.leasing.customer.dao.vo;

import com.leasing.common.base.entity.BaseVO;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "Yls_Analysis_Balance")
public class AnalysisBalanceVO extends BaseVO {

    /**
     * 主键
     */
    @Id
    private String pkAnalysisBalance;
    /**
     * 主表主键
     */
    @ManyToOne
    @JoinColumn(name = "pkIndexAnalysis")
    private IndexAnalysisVO pkIndexAnalysis; //主表主键
    /**
     * 种类
     */
    private Short balanceClass;
    /**
     * 余额
     */
    private BigDecimal balanceCash;
    /**
     * 质量状况
     */
    private String balanceQuality;
    /**
     * 备注
     */
    private String memo;

    public String getPkAnalysisBalance() {
        return pkAnalysisBalance;
    }

    public void setPkAnalysisBalance(String pkAnalysisBalance) {
        this.pkAnalysisBalance = pkAnalysisBalance;
    }

    public IndexAnalysisVO getPkIndexAnalysis() {
        return pkIndexAnalysis;
    }

    public void setPkIndexAnalysis(IndexAnalysisVO pkIndexAnalysis) {
        this.pkIndexAnalysis = pkIndexAnalysis;
    }

    public Short getBalanceClass() {
        return balanceClass;
    }

    public void setBalanceClass(Short balanceClass) {
        this.balanceClass = balanceClass;
    }

    public BigDecimal getBalanceCash() {
        return balanceCash;
    }

    public void setBalanceCash(BigDecimal balanceCash) {
        this.balanceCash = balanceCash;
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