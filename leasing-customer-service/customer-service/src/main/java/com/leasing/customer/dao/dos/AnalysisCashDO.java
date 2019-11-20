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
@Table(name = "YLS_ANALYSIS_CASH")
public class AnalysisCashDO extends BaseDO {

    /**
     * 主键
     */
    @Id
    private String pkAnalysisCash;

    private String pkIndexAnalysis;

    private String accountName;

    private Short accountType;

    private BigDecimal accountCash;

    private String memo;

    public String getPkAnalysisCash() {
        return pkAnalysisCash;
    }

    public void setPkAnalysisCash(String pkAnalysisCash) {
        this.pkAnalysisCash = pkAnalysisCash;
    }

    public String getPkIndexAnalysis() {
        return pkIndexAnalysis;
    }

    public void setPkIndexAnalysis(String pkIndexAnalysis) {
        this.pkIndexAnalysis = pkIndexAnalysis;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Short getAccountType() {
        return accountType;
    }

    public void setAccountType(Short accountType) {
        this.accountType = accountType;
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

    @Override
    public String getPk() {
        return pkAnalysisCash;
    }

    @Override
    public void setPk(String pk) {
        this.pkAnalysisCash = pk;
    }
}