package com.leasing.communication.entity.dos;

import com.leasing.common.base.annotation.Excel;
import com.leasing.communication.entity.base.FileBaseBusinessDO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019-12-03
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name="yc_capital_detail")
public class CbCapitalDetailDO extends FileBaseBusinessDO {

    /**
     * 主键
     */
    @Id
    private String pkCapitalDetail;

    /**
     * 主表主键
     */
    private String pkCapital;

    /**
     * 收款批次号
     */
    private String capitalBatchNo;

    /**
     * 合同编号
     */
    private String contCode;

    /**
     * 合同名称
     */
    private String contName;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 客户编号
     */
    @Transient
    private String customerCode;

    /**
     * 单位名称
     */
    private String employerName;

    /**
     * 起租日期
     */
    private String rentDate;

    /**
     * 租赁方式
     */
    private Integer leaseType;

    /**
     * 事件类别
     */
    private Integer eventType;

    /**
     * 期次
     */
    private Integer periodTime;

    /**
     * 应收日期
     */
    private String receivableDate;

    /**
     * 应收金额
     */
    private BigDecimal receivableAmount;

    /**
     * 应收本金
     */
    private BigDecimal receivableCorpus;

    /**
     * 应收利息
     */
    private BigDecimal receivableInterest;

    /**
     * 剩余本金
     */
    private BigDecimal surplusCorpus;

    /**
     * 到账金额
     */
    private BigDecimal intoAccountAmount;

    /**
     * 到账日期
     */
    private String intoAccountDate;

    /**
     * 核销状态
     */
    private Integer verificationState;

    /**
     * 核销日期
     */
    private String verificationDate;

    /**
     * 收款银行
     */
    private String gatherBank;

    /**
     * 收款账号
     */
    private String gatherAccount;

    /**
     * 核销金额
     */
    private BigDecimal gatherBalance;

    /**
     * 应收余额
     */
    private BigDecimal receivableBalance;

    /**
     * 实收本金
     */
    private BigDecimal paidinCorpus;

    /**
     * 实收利息
     */
    private BigDecimal paidinInterest;

    /**
     * 是否逾期
     */
    private Integer ifOverdue;

    /**
     * 币种
     */
    private String pkCurrency;

    /**
     * 抵扣状态
     */
    private Integer deductionStatus;

    /**
     * 抵扣日期
     */
    private String deductionDate;
    /**
     * 公司主体
     */
    private String companyBody;

    @Transient
    private String currtypecode;

    public String getCurrtypecode() {
        return currtypecode;
    }

    public void setCurrtypecode(String currtypecode) {
        this.currtypecode = currtypecode;
    }



    @Override
    public String getPk() {
        return pkCapitalDetail;
    }

    @Override
    public void setPk(String pk) {
        this.pkCapitalDetail = pk;
    }


    public String getPkCapitalDetail() {
        return pkCapitalDetail;
    }

    public void setPkCapitalDetail(String pkCapitalDetail) {
        this.pkCapitalDetail = pkCapitalDetail;
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

    public String getContCode() {
        return contCode;
    }

    public void setContCode(String contCode) {
        this.contCode = contCode;
    }

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public Integer getLeaseType() {
        return leaseType;
    }

    public void setLeaseType(Integer leaseType) {
        this.leaseType = leaseType;
    }

    public Integer getEventType() {
        return eventType;
    }

    public void setEventType(Integer eventType) {
        this.eventType = eventType;
    }

    public Integer getPeriodTime() {
        return periodTime;
    }

    public void setPeriodTime(Integer periodTime) {
        this.periodTime = periodTime;
    }

    public String getReceivableDate() {
        return receivableDate;
    }

    public void setReceivableDate(String receivableDate) {
        this.receivableDate = receivableDate;
    }

    public BigDecimal getReceivableAmount() {
        return receivableAmount;
    }

    public void setReceivableAmount(BigDecimal receivableAmount) {
        this.receivableAmount = receivableAmount;
    }

    public BigDecimal getReceivableCorpus() {
        return receivableCorpus;
    }

    public void setReceivableCorpus(BigDecimal receivableCorpus) {
        this.receivableCorpus = receivableCorpus;
    }

    public BigDecimal getReceivableInterest() {
        return receivableInterest;
    }

    public void setReceivableInterest(BigDecimal receivableInterest) {
        this.receivableInterest = receivableInterest;
    }

    public BigDecimal getSurplusCorpus() {
        return surplusCorpus;
    }

    public void setSurplusCorpus(BigDecimal surplusCorpus) {
        this.surplusCorpus = surplusCorpus;
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

    public Integer getVerificationState() {
        return verificationState;
    }

    public void setVerificationState(Integer verificationState) {
        this.verificationState = verificationState;
    }

    public String getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(String verificationDate) {
        this.verificationDate = verificationDate;
    }

    public String getGatherBank() {
        return gatherBank;
    }

    public void setGatherBank(String gatherBank) {
        this.gatherBank = gatherBank;
    }

    public String getGatherAccount() {
        return gatherAccount;
    }

    public void setGatherAccount(String gatherAccount) {
        this.gatherAccount = gatherAccount;
    }

    public BigDecimal getGatherBalance() {
        return gatherBalance;
    }

    public void setGatherBalance(BigDecimal gatherBalance) {
        this.gatherBalance = gatherBalance;
    }

    public BigDecimal getReceivableBalance() {
        return receivableBalance;
    }

    public void setReceivableBalance(BigDecimal receivableBalance) {
        this.receivableBalance = receivableBalance;
    }

    public BigDecimal getPaidinCorpus() {
        return paidinCorpus;
    }

    public void setPaidinCorpus(BigDecimal paidinCorpus) {
        this.paidinCorpus = paidinCorpus;
    }

    public BigDecimal getPaidinInterest() {
        return paidinInterest;
    }

    public void setPaidinInterest(BigDecimal paidinInterest) {
        this.paidinInterest = paidinInterest;
    }

    public Integer getIfOverdue() {
        return ifOverdue;
    }

    public void setIfOverdue(Integer ifOverdue) {
        this.ifOverdue = ifOverdue;
    }

    public String getPkCurrency() {
        return pkCurrency;
    }

    public void setPkCurrency(String pkCurrency) {
        this.pkCurrency = pkCurrency;
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

    public String getCompanyBody() {
        return companyBody;
    }

    public void setCompanyBody(String companyBody) {
        this.companyBody = companyBody;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }
}