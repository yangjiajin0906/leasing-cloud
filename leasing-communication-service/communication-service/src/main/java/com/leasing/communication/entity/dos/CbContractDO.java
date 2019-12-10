package com.leasing.communication.entity.dos;

import com.leasing.common.base.entity.BaseDO;
import com.leasing.common.entity.foundation.vo.AreaclVO;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019-11-27
 * @author:lvcna@yonyou.com
 * @description: 2C业务合同表
 **/
@Entity
@Table(name="yc_contract")
public class CbContractDO extends BaseDO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_id")
    @SequenceGenerator(name="seq_id", sequenceName="CB_OID_SEQ")
    private String pkContract;

    /**
     * 合同状态
     */
    private Integer contStatus;

    /**
     * 业务名称
     */
    private Integer businessName;

    /**
     * 集团名称
     */
    private String groupName;

    /**
     * 合同编号
     */
    private String contCode;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 客户身份证号
     */
    private String identityNo;

    /**
     * 起租流程
     */
    private Integer leaseFlow;

    /**
     * 合同签订日
     */
    private String contSignedDate;

    /**
     * 合同投放日
     */
    private String contLoan;

    /**
     * 合同实际起租日
     */
    private String leaseDateFact;

    /**
     * 合同结束日期
     */
    private String contEndDate;

    /**
     * 还款频率
     */
    private Integer refundFrequency;

    /**
     * 还款结构
     */
    private Integer refundStructure;

    /**
     * 租金总计
     */
    private BigDecimal leaseCashSum;

    /**
     * 本金金额
     */
    private BigDecimal corpusAmount;

    /**
     * 利息金额
     */
    private BigDecimal interestAmount;

    /**
     * 租赁方式
     */
    private Integer leaseType;

    /**
     * 市场IRR
     */
    private BigDecimal marketIrr;

    /**
     * 会计IRR
     */
    private BigDecimal financeIrr;

    /**
     * 客户所属省
     */
    private String customerProvince;

    /**
     * 客户所属城市
     */
    private String customerCity;

    /**
     * 客户所属地区
     */
    private String customerRegion;

    /**
     * 收票类型
     */
    private Integer ticketType;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 供应商银行账号
     */
    private String supplierBankAccount;

    /**
     * 出租人名称
     */
    private String lessorName;

    /**
     * 租金回收方式
     */
    private Integer leaseRecycling;

    /**
     * 收款银行账号
     */
    private String gatherBankAccount;

    /**
     * 收款银行开户行
     */
    private String gatherOpenBank;

    /**
     * 是否有平台方保证金增信
     */
    private Integer ifDepositCredit;

    /**
     * 合作平台方
     */
    private String cooperationPlatform;

    /**
     * 保证金额度/保证金比例
     */
    private BigDecimal depositRatio;

    /**
     * 运营商套餐金额
     */
    private BigDecimal operatorAmount;

    /**
     * 运营商套餐期限
     */
    private Integer operatorDeadline;

    /**
     * 终端名称
     */
    private String terminalName;

    /**
     * 终端型号
     */
    private String terminalType;

    /**
     * 附件地址
     */
    private String docUrl;

    /**
     * 资产五级分类
     */
    private String assetsClassify;

    /**
     * 来源系统
     */
    private String pkSystem;

    @Override
    public String getPk() {
        return pkContract;
    }

    @Override
    public void setPk(String pk) {
        this.pkContract = pk;
    }

    public String getPkContract() {
        return pkContract;
    }

    public void setPkContract(String pkContract) {
        this.pkContract = pkContract;
    }

    public Integer getContStatus() {
        return contStatus;
    }

    public void setContStatus(Integer contStatus) {
        this.contStatus = contStatus;
    }

    public Integer getBusinessName() {
        return businessName;
    }

    public void setBusinessName(Integer businessName) {
        this.businessName = businessName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getContCode() {
        return contCode;
    }

    public void setContCode(String contCode) {
        this.contCode = contCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public Integer getLeaseFlow() {
        return leaseFlow;
    }

    public void setLeaseFlow(Integer leaseFlow) {
        this.leaseFlow = leaseFlow;
    }

    public String getContSignedDate() {
        return contSignedDate;
    }

    public void setContSignedDate(String contSignedDate) {
        this.contSignedDate = contSignedDate;
    }

    public String getContLoan() {
        return contLoan;
    }

    public void setContLoan(String contLoan) {
        this.contLoan = contLoan;
    }

    public String getLeaseDateFact() {
        return leaseDateFact;
    }

    public void setLeaseDateFact(String leaseDateFact) {
        this.leaseDateFact = leaseDateFact;
    }

    public String getContEndDate() {
        return contEndDate;
    }

    public void setContEndDate(String contEndDate) {
        this.contEndDate = contEndDate;
    }

    public Integer getRefundFrequency() {
        return refundFrequency;
    }

    public void setRefundFrequency(Integer refundFrequency) {
        this.refundFrequency = refundFrequency;
    }

    public Integer getRefundStructure() {
        return refundStructure;
    }

    public void setRefundStructure(Integer refundStructure) {
        this.refundStructure = refundStructure;
    }

    public BigDecimal getLeaseCashSum() {
        return leaseCashSum;
    }

    public void setLeaseCashSum(BigDecimal leaseCashSum) {
        this.leaseCashSum = leaseCashSum;
    }

    public BigDecimal getCorpusAmount() {
        return corpusAmount;
    }

    public void setCorpusAmount(BigDecimal corpusAmount) {
        this.corpusAmount = corpusAmount;
    }

    public BigDecimal getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(BigDecimal interestAmount) {
        this.interestAmount = interestAmount;
    }

    public Integer getLeaseType() {
        return leaseType;
    }

    public void setLeaseType(Integer leaseType) {
        this.leaseType = leaseType;
    }

    public BigDecimal getMarketIrr() {
        return marketIrr;
    }

    public void setMarketIrr(BigDecimal marketIrr) {
        this.marketIrr = marketIrr;
    }

    public BigDecimal getFinanceIrr() {
        return financeIrr;
    }

    public void setFinanceIrr(BigDecimal financeIrr) {
        this.financeIrr = financeIrr;
    }

    public String getCustomerProvince() {
        return customerProvince;
    }

    public void setCustomerProvince(String customerProvince) {
        this.customerProvince = customerProvince;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerRegion() {
        return customerRegion;
    }

    public void setCustomerRegion(String customerRegion) {
        this.customerRegion = customerRegion;
    }

    public Integer getTicketType() {
        return ticketType;
    }

    public void setTicketType(Integer ticketType) {
        this.ticketType = ticketType;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierBankAccount() {
        return supplierBankAccount;
    }

    public void setSupplierBankAccount(String supplierBankAccount) {
        this.supplierBankAccount = supplierBankAccount;
    }

    public String getLessorName() {
        return lessorName;
    }

    public void setLessorName(String lessorName) {
        this.lessorName = lessorName;
    }

    public Integer getLeaseRecycling() {
        return leaseRecycling;
    }

    public void setLeaseRecycling(Integer leaseRecycling) {
        this.leaseRecycling = leaseRecycling;
    }

    public String getGatherBankAccount() {
        return gatherBankAccount;
    }

    public void setGatherBankAccount(String gatherBankAccount) {
        this.gatherBankAccount = gatherBankAccount;
    }

    public String getGatherOpenBank() {
        return gatherOpenBank;
    }

    public void setGatherOpenBank(String gatherOpenBank) {
        this.gatherOpenBank = gatherOpenBank;
    }

    public Integer getIfDepositCredit() {
        return ifDepositCredit;
    }

    public void setIfDepositCredit(Integer ifDepositCredit) {
        this.ifDepositCredit = ifDepositCredit;
    }

    public String getCooperationPlatform() {
        return cooperationPlatform;
    }

    public void setCooperationPlatform(String cooperationPlatform) {
        this.cooperationPlatform = cooperationPlatform;
    }

    public BigDecimal getDepositRatio() {
        return depositRatio;
    }

    public void setDepositRatio(BigDecimal depositRatio) {
        this.depositRatio = depositRatio;
    }

    public BigDecimal getOperatorAmount() {
        return operatorAmount;
    }

    public void setOperatorAmount(BigDecimal operatorAmount) {
        this.operatorAmount = operatorAmount;
    }

    public Integer getOperatorDeadline() {
        return operatorDeadline;
    }

    public void setOperatorDeadline(Integer operatorDeadline) {
        this.operatorDeadline = operatorDeadline;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    public String getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType;
    }

    public String getDocUrl() {
        return docUrl;
    }

    public void setDocUrl(String docUrl) {
        this.docUrl = docUrl;
    }

    public String getAssetsClassify() {
        return assetsClassify;
    }

    public void setAssetsClassify(String assetsClassify) {
        this.assetsClassify = assetsClassify;
    }

    public String getPkSystem() {
        return pkSystem;
    }

    public void setPkSystem(String pkSystem) {
        this.pkSystem = pkSystem;
    }
}
