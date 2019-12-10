package com.leasing.communication.entity.dos;


import com.leasing.common.base.annotation.Excel;
import com.leasing.communication.entity.base.FileBaseBusinessDO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author Yangjiajin
 * @description 2c收款DO
 * @date 2019/11/12 11:07
 */
@Entity
@Table(name = "yc_capital")
public class CbCapitalDO extends FileBaseBusinessDO {
    /**
     * 主键
     */
    @Id
    @Excel(titleName = "主键", orderNum = 10)
    private String pkCapital;


    /**
     * 收款批次号
     */
    private String capitalBatchNo;

    /**
     * 应收金额
     */
    @Excel(titleName = "应收金额", orderNum = 20)
    private BigDecimal receivableAmount;

    /**
     * 到账金额
     */
    @Excel(titleName = "到账金额", orderNum = 24)
    private BigDecimal intoAccountAmount;

    /**
     * 到账日期
     */
    @Excel(titleName = "到账日期", orderNum = 25)
    private String intoAccountDate;

    /**
     * 是否逾期
     */
    @Excel(titleName = "是否逾期", orderNum = 34)
    private Integer ifOverdue;

    /**
     * 抵扣状态
     */
    private Integer deductionStatus;

    /**
     * 抵扣日期
     */
    private String deductionDate;

    /**
     * 币种
     */
    @Excel(titleName = "币种", orderNum = 35)
    private String pkCurrency;

    /**
     * 公司主体
     */
    @Excel(titleName = "公司主体", orderNum = 36)
    private String companyBody;

    @Override
    public String getPk() {
        return pkCapital;
    }

    @Override
    public void setPk(String pk) {
        this.pkCapital = pk;
    }

    public String getPkCapital() {
        return pkCapital;
    }

    public void setPkCapital(String pkCapital) {
        this.pkCapital = pkCapital;
    }

    public String getCapitalBatchNo() {
        return capitalBatchNo;
    }

    public void setCapitalBatchNo(String capitalBatchNo) {
        this.capitalBatchNo = capitalBatchNo;
    }

    public BigDecimal getReceivableAmount() {
        return receivableAmount;
    }

    public void setReceivableAmount(BigDecimal receivableAmount) {
        this.receivableAmount = receivableAmount;
    }

    public BigDecimal getIntoAccountAmount() {
        return intoAccountAmount;
    }

    public void setIntoAccountAmount(BigDecimal intoAccountAmount) {
        this.intoAccountAmount = intoAccountAmount;
    }

    public String getIntoAccountDate() {
        return intoAccountDate;
    }

    public void setIntoAccountDate(String intoAccountDate) {
        this.intoAccountDate = intoAccountDate;
    }

    public Integer getIfOverdue() {
        return ifOverdue;
    }

    public void setIfOverdue(Integer ifOverdue) {
        this.ifOverdue = ifOverdue;
    }

    public Integer getDeductionStatus() {
        return deductionStatus;
    }

    public void setDeductionStatus(Integer deductionStatus) {
        this.deductionStatus = deductionStatus;
    }

    public String getDeductionDate() {
        return deductionDate;
    }

    public void setDeductionDate(String deductionDate) {
        this.deductionDate = deductionDate;
    }

    public String getPkCurrency() {
        return pkCurrency;
    }

    public void setPkCurrency(String pkCurrency) {
        this.pkCurrency = pkCurrency;
    }

    public String getCompanyBody() {
        return companyBody;
    }

    public void setCompanyBody(String companyBody) {
        this.companyBody = companyBody;
    }
}