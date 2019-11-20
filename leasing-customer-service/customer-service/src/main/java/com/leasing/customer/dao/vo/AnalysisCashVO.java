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
@Table(name = "YLS_ANALYSIS_CASH")
public class AnalysisCashVO extends BaseVO {

    /**
     * 主键
     */
    @Id
    private String pkAnalysisCash;
    /**
     * 主表主键
     */
    @ManyToOne
    @JoinColumn(name = "pkIndexAnalysis")
    private IndexAnalysisVO pkIndexAnalysis; //主表主键
    /**
     * 户名
     */
    private String accountName;
    /**
     * 余额
     */
    private BigDecimal accountCash;
    /**
     * 备注
     */
    private String memo;
    /**
     * 款项类型
     */
    private Short accountType;

    public String getPkAnalysisCash() {
        return pkAnalysisCash;
    }

    public void setPkAnalysisCash(String pkAnalysisCash) {
        this.pkAnalysisCash = pkAnalysisCash;
    }

    public IndexAnalysisVO getPkIndexAnalysis() {
        return pkIndexAnalysis;
    }

    public void setPkIndexAnalysis(IndexAnalysisVO pkIndexAnalysis) {
        this.pkIndexAnalysis = pkIndexAnalysis;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public BigDecimal getAccountCash() {
        return accountCash;
    }

    public void setAccountCash(BigDecimal accountCash) {
        this.accountCash = accountCash;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Short getAccountType() {
        return accountType;
    }

    public void setAccountType(Short accountType) {
        this.accountType = accountType;
    }

    @Override
    public String getPk() {
        return pkAnalysisCash;
    }

    @Override
    public void setPk(String pk) {
        this.pkAnalysisCash = pk;
    }
}