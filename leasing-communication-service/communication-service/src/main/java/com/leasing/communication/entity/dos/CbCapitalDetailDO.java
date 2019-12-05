package com.leasing.communication.entity.dos;

import com.leasing.common.base.annotation.Excel;
import com.leasing.communication.entity.base.FileBaseBusinessDO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    @Excel(titleName = "主键", orderNum = 10)
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
    @Excel(titleName = "合同编号", orderNum = 11)
    private String contCode;

    /**
     * 合同名称
     */
    @Excel(titleName = "合同名称", orderNum = 12)
    private String contName;

    /**
     * 客户名称
     */
    @Excel(titleName = "客户名称", orderNum = 13)
    private String customerName;

    /**
     * 单位名称
     */
    @Excel(titleName = "单位名称", orderNum = 14)
    private String employerName;

    /**
     * 起租日期
     */
    @Excel(titleName = "起租日期", orderNum = 15)
    private String rentDate;

    /**
     * 租赁方式
     */
    @Excel(titleName = "租赁方式", orderNum = 16)
    private Integer leaseType;

    /**
     * 事件类别
     */
    @Excel(titleName = "事件类别", orderNum = 17)
    private Integer eventType;

    /**
     * 期次
     */
    @Excel(titleName = "期次", orderNum = 18)
    private Integer periodTime;

    /**
     * 应收日期
     */
    @Excel(titleName = "应收日期", orderNum = 19)
    private String receivableDate;

    /**
     * 应收金额
     */
    @Excel(titleName = "应收金额", orderNum = 20)
    private BigDecimal receivableAmount;

    /**
     * 应收本金
     */
    @Excel(titleName = "应收本金", orderNum = 21)
    private BigDecimal receivableCorpus;

    /**
     * 应收利息
     */
    @Excel(titleName = "应收利息", orderNum = 22)
    private BigDecimal receivableInterest;

    /**
     * 剩余本金
     */
    @Excel(titleName = "剩余本金", orderNum = 23)
    private BigDecimal surplusCorpus;

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
     * 核销状态
     */
    @Excel(titleName = "核销状态", orderNum = 26)
    private Integer verificationState;

    /**
     * 核销日期
     */
    @Excel(titleName = "核销日期", orderNum = 27)
    private String verificationDate;

    /**
     * 收款银行
     */
    @Excel(titleName = "收款银行", orderNum = 28)
    private String gatherBank;

    /**
     * 收款账号
     */
    @Excel(titleName = "收款账号", orderNum = 29)
    private String gatherAccount;

    /**
     * 核销金额
     */
    @Excel(titleName = "核销金额", orderNum = 30)
    private BigDecimal gatherBalance;

    /**
     * 应收余额
     */
    @Excel(titleName = "应收余额", orderNum = 31)
    private BigDecimal receivableBalance;

    /**
     * 实收本金
     */
    @Excel(titleName = "实收本金", orderNum = 32)
    private BigDecimal paidinCorpus;

    /**
     * 实收利息
     */
    @Excel(titleName = "实收利息", orderNum = 33)
    private BigDecimal paidinInterest;

    /**
     * 是否逾期
     */@Excel(titleName = "是否逾期", orderNum = 34)
    private Integer ifOverdue;

    /**
     * 币种
     */
    @Excel(titleName = "币种", orderNum = 35)
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
    @Excel(titleName = "公司主体", orderNum = 36)
    private String companyBody;

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
}