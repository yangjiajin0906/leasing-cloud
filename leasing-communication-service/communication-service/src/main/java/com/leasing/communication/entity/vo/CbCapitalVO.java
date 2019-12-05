package com.leasing.communication.entity.vo;

import com.leasing.common.base.entity.BaseBusinessVO;
import com.leasing.common.entity.foundation.vo.CurrtypeVO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-12-04
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yc_capital")
public class CbCapitalVO extends BaseBusinessVO {
    /**
     * 主键
     */
    @Id
    private String pkCapital;


    /**
     * 收款批次号
     */
    private String capitalBatchNo;

    /**
     * 应收金额
     */
    private BigDecimal receivableAmount;

    /**
     * 到账金额
     */
    private BigDecimal intoAccountAmount;

    /**
     * 到账日期
     */
    private String intoAccountDate;

    /**
     * 是否逾期
     */
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
    @ManyToOne
    @JoinColumn(name = "pkCurrency")
    private CurrtypeVO pkCurrency;

    /**
     * 公司主体
     */
    private String companyBody;

    /**
     * 收款子表
     */
    @OneToMany(orphanRemoval=true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="pkCapital")
    private List<CbCapitalDetailVO> pkCapitalDetail;

    private String pkSys;

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

    public CurrtypeVO getPkCurrency() {
        return pkCurrency;
    }

    public void setPkCurrency(CurrtypeVO pkCurrency) {
        this.pkCurrency = pkCurrency;
    }

    public List<CbCapitalDetailVO> getPkCapitalDetail() {
        return pkCapitalDetail;
    }

    public void setPkCapitalDetail(List<CbCapitalDetailVO> pkCapitalDetail) {
        this.pkCapitalDetail = pkCapitalDetail;
    }

    public String getCompanyBody() {
        return companyBody;
    }

    public void setCompanyBody(String companyBody) {
        this.companyBody = companyBody;
    }

    public String getPkSys() {
        return pkSys;
    }

    public void setPkSys(String pkSys) {
        this.pkSys = pkSys;
    }
}