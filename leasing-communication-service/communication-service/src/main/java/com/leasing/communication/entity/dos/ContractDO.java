package com.leasing.communication.entity.dos;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.leasing.communication.entity.base.FileBaseBusinessDO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
/**
 * @description 2c合同DO
 * @author Yangjiajin
 * @date 2019/11/12 11:04
 */
@Entity
@Table(name="yc_contract")
public class ContractDO extends FileBaseBusinessDO {
    /**
     * 主键
     */
	@Excel(name = "主键", orderNum = "10")
    @Id
    private String pkContract;

    /**
     * 合同状态
     */
    @Excel(name = "合同状态",orderNum = "11")
    private Integer contStatus;

    /**
     * 业务名称
     */
    @Excel(name = "业务名称",orderNum = "12")
    private Integer businessName;

    /**
     * 集团名称
     */
    @Excel(name = "集团名称", orderNum = "13")
    private String groupName;

    /**
     * 合同编号
     */
    @Excel(name = "合同编号", orderNum = "14")
    private String contCode;

    /**
     * 客户名称
     */
    @Excel(name = "客户名称", orderNum = "15")
    private String customerName;

    /**
     * 客户身份证号
     */
    @Excel(name = "客户身份证号", orderNum = "16")
    private String identityNo;

    /**
     * 起租流程
     */
    @Excel(name = "起租流程",  orderNum = "17")
    private Integer leaseFlow;

    /**
     * 合同签订日
     */
    @Excel(name = "合同签订日", orderNum = "18")
    private String contSignedDate;

    /**
     * 合同投放日
     */
    @Excel(name = "合同投放日", orderNum = "19")
    private String contLoan;

    /**
     * 合同实际起租日
     */
    @Excel(name = "合同实际起租日",orderNum = "20")
    private String leaseDateFact;

    /**
     * 合同结束日期
     */
    @Excel(name = "合同结束日期",orderNum = "21")
    private String contEndDate;

    /**
     * 还款频率
     */
    @Excel(name = "还款频率",orderNum = "22")
    private Integer refundFrequency;

    /**
     * 还款结构
     */
    @Excel(name = "还款结构",orderNum = "23")
    private Integer refundStructure;

    /**
     * 租金总计
     */
    @Excel(name = "租金总计",orderNum = "24")
    private BigDecimal leaseCashSum;

    /**
     * 本金金额
     */
    @Excel(name = "本金金额",orderNum = "25")
    private BigDecimal corpusAmount;

    /**
     * 利息金额
     */
    @Excel(name = "利息金额",orderNum = "26")
    private BigDecimal interestAmount;

    /**
     * 租赁方式
     */
    @Excel(name = "租赁方式", orderNum = "27")
    private Integer leaseType;

    /**
     * 市场IRR
     */
    @Excel(name = "市场IRR",orderNum = "28")
    private BigDecimal marketIrr;

    /**
     * 会计IRR
     */
    @Excel(name = "会计IRR",orderNum = "29")
    private BigDecimal financeIrr;

    /**
     * 客户所属地区
     */
    @Excel(name = "客户所属地区", orderNum = "30")
    private Integer customerRegion;

    /**
     * 收票类型
     */
    @Excel(name = "收票类型", orderNum = "31")
    private Integer ticketType;

    /**
     * 供应商名称
     */
    @Excel(name = "供应商名称",orderNum = "32")
    private String supplierName;

    /**
     * 供应商银行账号
     */
    @Excel(name = "供应商银行账号",orderNum = "33")
    private String supplierBankAccount;

    /**
     * 出租人名称
     */
    @Excel(name = "出租人名称",orderNum = "34")
    private String lessorName;

    /**
     * 租金回收方式
     */
    @Excel(name = "租金回收方式",orderNum = "35")
    private Integer leaseRecycling;

    /**
     * 收款银行账号
     */
    @Excel(name = "收款银行账号",orderNum = "36")
    private String gatherBankAccount;

    /**
     * 收款银行开户行
     */
    @Excel(name = "收款银行开户行",orderNum = "37")
    private String gatherOpenBank;

    /**
     * 是否有平台方保证金增信
     */
    @Excel(name = "是否有平台方保证金增信",orderNum = "38")
    private Integer ifDepositCredit;

    /**
     * 合作平台方
     */
    @Excel(name = "合作平台方",orderNum = "39")
    private String cooperationPlatform;

    /**
     * 保证金额度/保证金比例
     */
    @Excel(name = "保证金额度/保证金比例",orderNum = "40")
    private BigDecimal depositRatio;

    /**
     * 运营商套餐金额
     */
    @Excel(name = "运营商套餐金额",orderNum = "41")
    private BigDecimal operatorAmount;

    /**
     * 运营商套餐期限
     */
    @Excel(name = "运营商套餐期限",orderNum = "42")
    private Integer operatorDeadline;

    /**
     * 终端名称
     */
    @Excel(name = "终端名称",orderNum = "43")
    private String terminalName;

    /**
     * 终端型号
     */
    @Excel(name = "终端型号",orderNum = "44")
    private String terminalType;

    @Override
    public String getPk() {
        return pkContract;
    }

    @Override
    public void setPk(String pk) {
        this.pkContract = pk;
    }

    /**
     * 主键
     * @return PK_CONTRACT 主键
     */
    public String getPkContract() {
        return pkContract;
    }

    /**
     * 主键
     * @param pkContract 主键
     */
    public void setPkContract(String pkContract) {
        this.pkContract = pkContract == null ? null : pkContract.trim();
    }

    /**
     * 合同状态
     * @return CONT_STATUS 合同状态
     */
    public Integer getContStatus() {
        return contStatus;
    }

    /**
     * 合同状态
     * @param contStatus 合同状态
     */
    public void setContStatus(Integer contStatus) {
        this.contStatus = contStatus;
    }

    /**
     * 业务名称
     * @return BUSINESS_NAME 业务名称
     */
    public Integer getBusinessName() {
        return businessName;
    }

    /**
     * 业务名称
     * @param businessName 业务名称
     */
    public void setBusinessName(Integer businessName) {
        this.businessName = businessName;
    }

    /**
     * 集团名称
     * @return GROUP_NAME 集团名称
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 集团名称
     * @param groupName 集团名称
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
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
     * 客户身份证号
     * @return IDENTITY_NO 客户身份证号
     */
    public String getIdentityNo() {
        return identityNo;
    }

    /**
     * 客户身份证号
     * @param identityNo 客户身份证号
     */
    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo == null ? null : identityNo.trim();
    }

    /**
     * 起租流程
     * @return LEASE_FLOW 起租流程
     */
    public Integer getLeaseFlow() {
        return leaseFlow;
    }

    /**
     * 起租流程
     * @param leaseFlow 起租流程
     */
    public void setLeaseFlow(Integer leaseFlow) {
        this.leaseFlow = leaseFlow;
    }

    /**
     * 合同签订日
     * @return CONT_SIGNED_DATE 合同签订日
     */
    public String getContSignedDate() {
        return contSignedDate;
    }

    /**
     * 合同签订日
     * @param contSignedDate 合同签订日
     */
    public void setContSignedDate(String contSignedDate) {
        this.contSignedDate = contSignedDate == null ? null : contSignedDate.trim();
    }

    /**
     * 合同投放日
     * @return CONT_LOAN 合同投放日
     */
    public String getContLoan() {
        return contLoan;
    }

    /**
     * 合同投放日
     * @param contLoan 合同投放日
     */
    public void setContLoan(String contLoan) {
        this.contLoan = contLoan == null ? null : contLoan.trim();
    }

    /**
     * 合同实际起租日
     * @return LEASE_DATE_FACT 合同实际起租日
     */
    public String getLeaseDateFact() {
        return leaseDateFact;
    }

    /**
     * 合同实际起租日
     * @param leaseDateFact 合同实际起租日
     */
    public void setLeaseDateFact(String leaseDateFact) {
        this.leaseDateFact = leaseDateFact == null ? null : leaseDateFact.trim();
    }

    /**
     * 合同结束日期
     * @return CONT_END_DATE 合同结束日期
     */
    public String getContEndDate() {
        return contEndDate;
    }

    /**
     * 合同结束日期
     * @param contEndDate 合同结束日期
     */
    public void setContEndDate(String contEndDate) {
        this.contEndDate = contEndDate == null ? null : contEndDate.trim();
    }

    /**
     * 还款频率
     * @return REFUND_FREQUENCY 还款频率
     */
    public Integer getRefundFrequency() {
        return refundFrequency;
    }

    /**
     * 还款频率
     * @param refundFrequency 还款频率
     */
    public void setRefundFrequency(Integer refundFrequency) {
        this.refundFrequency = refundFrequency;
    }

    /**
     * 还款结构
     * @return REFUND_STRUCTURE 还款结构
     */
    public Integer getRefundStructure() {
        return refundStructure;
    }

    /**
     * 还款结构
     * @param refundStructure 还款结构
     */
    public void setRefundStructure(Integer refundStructure) {
        this.refundStructure = refundStructure;
    }

    /**
     * 租金总计
     * @return LEASE_CASH_SUM 租金总计
     */
    public BigDecimal getLeaseCashSum() {
        return leaseCashSum;
    }

    /**
     * 租金总计
     * @param leaseCashSum 租金总计
     */
    public void setLeaseCashSum(BigDecimal leaseCashSum) {
        this.leaseCashSum = leaseCashSum;
    }

    /**
     * 本金金额
     * @return CORPUS_AMOUNT 本金金额
     */
    public BigDecimal getCorpusAmount() {
        return corpusAmount;
    }

    /**
     * 本金金额
     * @param corpusAmount 本金金额
     */
    public void setCorpusAmount(BigDecimal corpusAmount) {
        this.corpusAmount = corpusAmount;
    }

    /**
     * 利息金额
     * @return INTEREST_AMOUNT 利息金额
     */
    public BigDecimal getInterestAmount() {
        return interestAmount;
    }

    /**
     * 利息金额
     * @param interestAmount 利息金额
     */
    public void setInterestAmount(BigDecimal interestAmount) {
        this.interestAmount = interestAmount;
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
     * 市场IRR
     * @return MARKET_IRR 市场IRR
     */
    public BigDecimal getMarketIrr() {
        return marketIrr;
    }

    /**
     * 市场IRR
     * @param marketIrr 市场IRR
     */
    public void setMarketIrr(BigDecimal marketIrr) {
        this.marketIrr = marketIrr;
    }

    /**
     * 会计IRR
     * @return FINANCE_IRR 会计IRR
     */
    public BigDecimal getFinanceIrr() {
        return financeIrr;
    }

    /**
     * 会计IRR
     * @param financeIrr 会计IRR
     */
    public void setFinanceIrr(BigDecimal financeIrr) {
        this.financeIrr = financeIrr;
    }

    /**
     * 客户所属地区
     * @return CUSTOMER_REGION 客户所属地区
     */
    public Integer getCustomerRegion() {
        return customerRegion;
    }

    /**
     * 客户所属地区
     * @param customerRegion 客户所属地区
     */
    public void setCustomerRegion(Integer customerRegion) {
        this.customerRegion = customerRegion;
    }

    /**
     * 收票类型
     * @return TICKET_TYPE 收票类型
     */
    public Integer getTicketType() {
        return ticketType;
    }

    /**
     * 收票类型
     * @param ticketType 收票类型
     */
    public void setTicketType(Integer ticketType) {
        this.ticketType = ticketType;
    }

    /**
     * 供应商名称
     * @return SUPPLIER_NAME 供应商名称
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * 供应商名称
     * @param supplierName 供应商名称
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    /**
     * 供应商银行账号
     * @return SUPPLIER_BANK_ACCOUNT 供应商银行账号
     */
    public String getSupplierBankAccount() {
        return supplierBankAccount;
    }

    /**
     * 供应商银行账号
     * @param supplierBankAccount 供应商银行账号
     */
    public void setSupplierBankAccount(String supplierBankAccount) {
        this.supplierBankAccount = supplierBankAccount == null ? null : supplierBankAccount.trim();
    }

    /**
     * 出租人名称
     * @return LESSOR_NAME 出租人名称
     */
    public String getLessorName() {
        return lessorName;
    }

    /**
     * 出租人名称
     * @param lessorName 出租人名称
     */
    public void setLessorName(String lessorName) {
        this.lessorName = lessorName == null ? null : lessorName.trim();
    }

    /**
     * 租金回收方式
     * @return LEASE_RECYCLING 租金回收方式
     */
    public Integer getLeaseRecycling() {
        return leaseRecycling;
    }

    /**
     * 租金回收方式
     * @param leaseRecycling 租金回收方式
     */
    public void setLeaseRecycling(Integer leaseRecycling) {
        this.leaseRecycling = leaseRecycling;
    }

    /**
     * 收款银行账号
     * @return GATHER_BANK_ACCOUNT 收款银行账号
     */
    public String getGatherBankAccount() {
        return gatherBankAccount;
    }

    /**
     * 收款银行账号
     * @param gatherBankAccount 收款银行账号
     */
    public void setGatherBankAccount(String gatherBankAccount) {
        this.gatherBankAccount = gatherBankAccount == null ? null : gatherBankAccount.trim();
    }

    /**
     * 收款银行开户行
     * @return GATHER_OPEN_BANK 收款银行开户行
     */
    public String getGatherOpenBank() {
        return gatherOpenBank;
    }

    /**
     * 收款银行开户行
     * @param gatherOpenBank 收款银行开户行
     */
    public void setGatherOpenBank(String gatherOpenBank) {
        this.gatherOpenBank = gatherOpenBank == null ? null : gatherOpenBank.trim();
    }

    /**
     * 是否有平台方保证金增信
     * @return IF_DEPOSIT_CREDIT 是否有平台方保证金增信
     */
    public Integer getIfDepositCredit() {
        return ifDepositCredit;
    }

    /**
     * 是否有平台方保证金增信
     * @param ifDepositCredit 是否有平台方保证金增信
     */
    public void setIfDepositCredit(Integer ifDepositCredit) {
        this.ifDepositCredit = ifDepositCredit;
    }

    /**
     * 合作平台方
     * @return COOPERATION_PLATFORM 合作平台方
     */
    public String getCooperationPlatform() {
        return cooperationPlatform;
    }

    /**
     * 合作平台方
     * @param cooperationPlatform 合作平台方
     */
    public void setCooperationPlatform(String cooperationPlatform) {
        this.cooperationPlatform = cooperationPlatform == null ? null : cooperationPlatform.trim();
    }

    /**
     * 保证金额度/保证金比例
     * @return DEPOSIT_RATIO 保证金额度/保证金比例
     */
    public BigDecimal getDepositRatio() {
        return depositRatio;
    }

    /**
     * 保证金额度/保证金比例
     * @param depositRatio 保证金额度/保证金比例
     */
    public void setDepositRatio(BigDecimal depositRatio) {
        this.depositRatio = depositRatio;
    }

    /**
     * 运营商套餐金额
     * @return OPERATOR_AMOUNT 运营商套餐金额
     */
    public BigDecimal getOperatorAmount() {
        return operatorAmount;
    }

    /**
     * 运营商套餐金额
     * @param operatorAmount 运营商套餐金额
     */
    public void setOperatorAmount(BigDecimal operatorAmount) {
        this.operatorAmount = operatorAmount;
    }

    /**
     * 运营商套餐期限
     * @return OPERATOR_DEADLINE 运营商套餐期限
     */
    public Integer getOperatorDeadline() {
        return operatorDeadline;
    }

    /**
     * 运营商套餐期限
     * @param operatorDeadline 运营商套餐期限
     */
    public void setOperatorDeadline(Integer operatorDeadline) {
        this.operatorDeadline = operatorDeadline == null ? null : operatorDeadline;
    }

    /**
     * 终端名称
     * @return TERMINAL_NAME 终端名称
     */
    public String getTerminalName() {
        return terminalName;
    }

    /**
     * 终端名称
     * @param terminalName 终端名称
     */
    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName == null ? null : terminalName.trim();
    }

    /**
     * 终端型号
     * @return TERMINAL_TYPE 终端型号
     */
    public String getTerminalType() {
        return terminalType;
    }

    /**
     * 终端型号
     * @param terminalType 终端型号
     */
    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType == null ? null : terminalType.trim();
    }
}