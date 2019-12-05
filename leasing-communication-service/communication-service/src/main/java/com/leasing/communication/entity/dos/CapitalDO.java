package com.leasing.communication.entity.dos;


import com.leasing.communication.entity.base.FileBaseBusinessDO;
import com.leasing.common.base.annotation.Excel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @description 2c收款DO
 * @author Yangjiajin
 * @date 2019/11/12 11:07
 */
@Entity
@Table(name="yc_capital")
public class CapitalDO extends FileBaseBusinessDO {
    /**
     * 主键
     */
    @Id
    @Excel(titleName = "主键", orderNum = 10)
    private String pkCapitalGatherAccount;

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
     * 公司主体
     */
    @Excel(titleName = "公司主体", orderNum = 36)
    private String companyBody;

    @Override
    public String getPk() {
        return pkCapitalGatherAccount;
    }

    @Override
    public void setPk(String pk) {
        this.pkCapitalGatherAccount = pk;
    }

    /**
     * 主键
     * @return PK_CAPITAL_GATHER_ACCOUNT 主键
     */
    public String getPkCapitalGatherAccount() {
        return pkCapitalGatherAccount;
    }

    /**
     * 主键
     * @param pkCapitalGatherAccount 主键
     */
    public void setPkCapitalGatherAccount(String pkCapitalGatherAccount) {
        this.pkCapitalGatherAccount = pkCapitalGatherAccount == null ? null : pkCapitalGatherAccount.trim();
    }

    /**
     * 合同编号
     * @return CONT_CODE 合同编号
     */
    public String getContCode() {
        return contCode;
    }

    /**
     * 合同编号
     * @param contCode 合同编号
     */
    public void setContCode(String contCode) {
        this.contCode = contCode == null ? null : contCode.trim();
    }

    /**
     * 合同名称
     * @return CONT_NAME 合同名称
     */
    public String getContName() {
        return contName;
    }

    /**
     * 合同名称
     * @param contName 合同名称
     */
    public void setContName(String contName) {
        this.contName = contName == null ? null : contName.trim();
    }

    /**
     * 客户名称
     * @return CUSTOMER_NAME 客户名称
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 客户名称
     * @param customerName 客户名称
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    /**
     * 单位名称
     * @return EMPLOYER_NAME 单位名称
     */
    public String getEmployerName() {
        return employerName;
    }

    /**
     * 单位名称
     * @param employerName 单位名称
     */
    public void setEmployerName(String employerName) {
        this.employerName = employerName == null ? null : employerName.trim();
    }

    /**
     * 起租日期
     * @return RENT_DATE 起租日期
     */
    public String getRentDate() {
        return rentDate;
    }

    /**
     * 起租日期
     * @param rentDate 起租日期
     */
    public void setRentDate(String rentDate) {
        this.rentDate = rentDate == null ? null : rentDate.trim();
    }

    /**
     * 租赁方式
     * @return LEASE_TYPE 租赁方式
     */
    public Integer getLeaseType() {
        return leaseType;
    }

    /**
     * 租赁方式
     * @param leaseType 租赁方式
     */
    public void setLeaseType(Integer leaseType) {
        this.leaseType = leaseType;
    }

    /**
     * 事件类别
     * @return EVENT_TYPE 事件类别
     */
    public Integer getEventType() {
        return eventType;
    }

    /**
     * 事件类别
     * @param eventType 事件类别
     */
    public void setEventType(Integer eventType) {
        this.eventType = eventType;
    }

    /**
     * 期次
     * @return PERIOD_TIME 期次
     */
    public Integer getPeriodTime() {
        return periodTime;
    }

    /**
     * 期次
     * @param periodTime 期次
     */
    public void setPeriodTime(Integer periodTime) {
        this.periodTime = periodTime;
    }

    /**
     * 应收日期
     * @return RECEIVABLE_DATE 应收日期
     */
    public String getReceivableDate() {
        return receivableDate;
    }

    /**
     * 应收日期
     * @param receivableDate 应收日期
     */
    public void setReceivableDate(String receivableDate) {
        this.receivableDate = receivableDate == null ? null : receivableDate.trim();
    }

    /**
     * 应收金额
     * @return RECEIVABLE_AMOUNT 应收金额
     */
    public BigDecimal getReceivableAmount() {
        return receivableAmount;
    }

    /**
     * 应收金额
     * @param receivableAmount 应收金额
     */
    public void setReceivableAmount(BigDecimal receivableAmount) {
        this.receivableAmount = receivableAmount;
    }

    /**
     * 应收本金
     * @return RECEIVABLE_CORPUS 应收本金
     */
    public BigDecimal getReceivableCorpus() {
        return receivableCorpus;
    }

    /**
     * 应收本金
     * @param receivableCorpus 应收本金
     */
    public void setReceivableCorpus(BigDecimal receivableCorpus) {
        this.receivableCorpus = receivableCorpus;
    }

    /**
     * 应收利息
     * @return RECEIVABLE_INTEREST 应收利息
     */
    public BigDecimal getReceivableInterest() {
        return receivableInterest;
    }

    /**
     * 应收利息
     * @param receivableInterest 应收利息
     */
    public void setReceivableInterest(BigDecimal receivableInterest) {
        this.receivableInterest = receivableInterest;
    }

    /**
     * 剩余本金
     * @return SURPLUS_CORPUS 剩余本金
     */
    public BigDecimal getSurplusCorpus() {
        return surplusCorpus;
    }

    /**
     * 剩余本金
     * @param surplusCorpus 剩余本金
     */
    public void setSurplusCorpus(BigDecimal surplusCorpus) {
        this.surplusCorpus = surplusCorpus;
    }

    /**
     * 到账金额
     * @return INTO_ACCOUNT_AMOUNT 到账金额
     */
    public BigDecimal getIntoAccountAmount() {
        return intoAccountAmount;
    }

    /**
     * 到账金额
     * @param intoAccountAmount 到账金额
     */
    public void setIntoAccountAmount(BigDecimal intoAccountAmount) {
        this.intoAccountAmount = intoAccountAmount;
    }

    /**
     * 到账日期
     * @return INTO_ACCOUNT_DATE 到账日期
     */
    public String getIntoAccountDate() {
        return intoAccountDate;
    }

    /**
     * 到账日期
     * @param intoAccountDate 到账日期
     */
    public void setIntoAccountDate(String intoAccountDate) {
        this.intoAccountDate = intoAccountDate == null ? null : intoAccountDate.trim();
    }

    /**
     * 核销状态
     * @return VERIFICATION_STATE 核销状态
     */
    public Integer getVerificationState() {
        return verificationState;
    }

    /**
     * 核销状态
     * @param verificationState 核销状态
     */
    public void setVerificationState(Integer verificationState) {
        this.verificationState = verificationState;
    }

    /**
     * 核销日期
     * @return VERIFICATION_DATE 核销日期
     */
    public String getVerificationDate() {
        return verificationDate;
    }

    /**
     * 核销日期
     * @param verificationDate 核销日期
     */
    public void setVerificationDate(String verificationDate) {
        this.verificationDate = verificationDate == null ? null : verificationDate.trim();
    }

    /**
     * 收款银行
     * @return GATHER_BANK 收款银行
     */
    public String getGatherBank() {
        return gatherBank;
    }

    /**
     * 收款银行
     * @param gatherBank 收款银行
     */
    public void setGatherBank(String gatherBank) {
        this.gatherBank = gatherBank == null ? null : gatherBank.trim();
    }

    /**
     * 收款账号
     * @return GATHER_ACCOUNT 收款账号
     */
    public String getGatherAccount() {
        return gatherAccount;
    }

    /**
     * 收款账号
     * @param gatherAccount 收款账号
     */
    public void setGatherAccount(String gatherAccount) {
        this.gatherAccount = gatherAccount == null ? null : gatherAccount.trim();
    }

    /**
     * 核销金额
     * @return GATHER_BALANCE 核销金额
     */
    public BigDecimal getGatherBalance() {
        return gatherBalance;
    }

    /**
     * 核销金额
     * @param gatherBalance 核销金额
     */
    public void setGatherBalance(BigDecimal gatherBalance) {
        this.gatherBalance = gatherBalance;
    }

    /**
     * 应收余额
     * @return RECEIVABLE_BALANCE 应收余额
     */
    public BigDecimal getReceivableBalance() {
        return receivableBalance;
    }

    /**
     * 应收余额
     * @param receivableBalance 应收余额
     */
    public void setReceivableBalance(BigDecimal receivableBalance) {
        this.receivableBalance = receivableBalance;
    }

    /**
     * 实收本金
     * @return PAIDIN_CORPUS 实收本金
     */
    public BigDecimal getPaidinCorpus() {
        return paidinCorpus;
    }

    /**
     * 实收本金
     * @param paidinCorpus 实收本金
     */
    public void setPaidinCorpus(BigDecimal paidinCorpus) {
        this.paidinCorpus = paidinCorpus;
    }

    /**
     * 实收利息
     * @return PAIDIN_INTEREST 实收利息
     */
    public BigDecimal getPaidinInterest() {
        return paidinInterest;
    }

    /**
     * 实收利息
     * @param paidinInterest 实收利息
     */
    public void setPaidinInterest(BigDecimal paidinInterest) {
        this.paidinInterest = paidinInterest;
    }

    /**
     * 是否逾期
     * @return IF_OVERDUE 是否逾期
     */
    public Integer getIfOverdue() {
        return ifOverdue;
    }

    /**
     * 是否逾期
     * @param ifOverdue 是否逾期
     */
    public void setIfOverdue(Integer ifOverdue) {
        this.ifOverdue = ifOverdue;
    }

    /**
     * 币种
     * @return PK_CURRENCY 币种
     */
    public String getPkCurrency() {
        return pkCurrency;
    }

    /**
     * 币种
     * @param pkCurrency 币种
     */
    public void setPkCurrency(String pkCurrency) {
        this.pkCurrency = pkCurrency;
    }

    /**
     * 公司主体
     * @return COMPANY_BODY 公司主体
     */
    public String getCompanyBody() {
        return companyBody;
    }

    /**
     * 公司主体
     * @param companyBody 公司主体
     */
    public void setCompanyBody(String companyBody) {
        this.companyBody = companyBody == null ? null : companyBody.trim();
    }

    public CapitalDO() {
    }

    public CapitalDO(String pkCapitalGatherAccount, String contCode, String contName, String customerName, String employerName, String rentDate, Integer leaseType, Integer eventType, Integer periodTime, String receivableDate, BigDecimal receivableAmount, BigDecimal receivableCorpus, BigDecimal receivableInterest, BigDecimal surplusCorpus, BigDecimal intoAccountAmount, String intoAccountDate, Integer verificationState, String verificationDate, String gatherBank, String gatherAccount, BigDecimal gatherBalance, BigDecimal receivableBalance, BigDecimal paidinCorpus, BigDecimal paidinInterest, Integer ifOverdue, String pkCurrency, String companyBody) {
        this.pkCapitalGatherAccount = pkCapitalGatherAccount;
        this.contCode = contCode;
        this.contName = contName;
        this.customerName = customerName;
        this.employerName = employerName;
        this.rentDate = rentDate;
        this.leaseType = leaseType;
        this.eventType = eventType;
        this.periodTime = periodTime;
        this.receivableDate = receivableDate;
        this.receivableAmount = receivableAmount;
        this.receivableCorpus = receivableCorpus;
        this.receivableInterest = receivableInterest;
        this.surplusCorpus = surplusCorpus;
        this.intoAccountAmount = intoAccountAmount;
        this.intoAccountDate = intoAccountDate;
        this.verificationState = verificationState;
        this.verificationDate = verificationDate;
        this.gatherBank = gatherBank;
        this.gatherAccount = gatherAccount;
        this.gatherBalance = gatherBalance;
        this.receivableBalance = receivableBalance;
        this.paidinCorpus = paidinCorpus;
        this.paidinInterest = paidinInterest;
        this.ifOverdue = ifOverdue;
        this.pkCurrency = pkCurrency;
        this.companyBody = companyBody;
    }
}