package com.leasing.communication.entity.dos;

import com.leasing.common.base.entity.BaseDTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @description 不良合同 DO
 * @author Yangjiajin
 * @date 2019/12/5 13:44
 */
@Entity
@Table(name="yc_overdue_contract")
public class CbOverdueContractDO extends BaseDTO {
    /**
     * 主键
     */
    @Id
    private String pkOverdueContract;

    /**
     * 付款交易批次号
     */
    private String paymentBatchNo;

    /**
     * 合同主键
     */
    private String pkContract;

    /**
     * 合同编号
     */
    private String contCode;

    /**
     * 合同名称
     */
    private String contName;

    /**
     * 客户主键
     */
    private String pkCustomer;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 单位名称
     */
    private String employerName;

    /**
     * 起租日期
     */
    private String leaseDate;

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
     * 逾期状态
     */
    private Integer overdueState;

    /**
     * 币种
     */
    private String pkCurrency;

    /**
     * 公司主体
     */
    private String companyBody;

    /**
     * 来源系统
     */
    private String pkSys;

    /**
     * 操作人
     */
    private String pkOperator;

    /**
     * 操作日期
     */
    private String operateDate;

    /**
     * 操作时间
     */
    private String operateTime;

    /**
     * 机构
     */
    private String pkOrg;

    /**
     * 部门主键
     */
    private String pkDept;

    /**
     * 单据状态
     */
    private BigDecimal billstatus;

    /**
     * 时间戳
     */
    private String ts;


    /**
     * 主键
     * @return PK_OVERDUE_CONTRACT 主键
     */
    public String getPkOverdueContract() {
        return pkOverdueContract;
    }

    /**
     * 主键
     * @param pkOverdueContract 主键
     */
    public void setPkOverdueContract(String pkOverdueContract) {
        this.pkOverdueContract = pkOverdueContract == null ? null : pkOverdueContract.trim();
    }

    /**
     * 付款交易批次号
     * @return PAYMENT_BATCH_NO 付款交易批次号
     */
    public String getPaymentBatchNo() {
        return paymentBatchNo;
    }

    /**
     * 付款交易批次号
     * @param paymentBatchNo 付款交易批次号
     */
    public void setPaymentBatchNo(String paymentBatchNo) {
        this.paymentBatchNo = paymentBatchNo == null ? null : paymentBatchNo.trim();
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
     * @return LEASE_DATE 起租日期
     */
    public String getLeaseDate() {
        return leaseDate;
    }

    /**
     * 起租日期
     * @param leaseDate 起租日期
     */
    public void setLeaseDate(String leaseDate) {
        this.leaseDate = leaseDate == null ? null : leaseDate.trim();
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
     * 逾期状态
     * @return OVERDUE_STATE 逾期状态
     */
    public Integer getOverdueState() {
        return overdueState;
    }

    /**
     * 逾期状态
     * @param overdueState 逾期状态
     */
    public void setOverdueState(Integer overdueState) {
        this.overdueState = overdueState;
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
        this.pkCurrency = pkCurrency == null ? null : pkCurrency.trim();
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

    /**
     * 来源系统
     * @return PK_SYS 来源系统
     */
    public String getPkSys() {
        return pkSys;
    }

    /**
     * 来源系统
     * @param pkSys 来源系统
     */
    public void setPkSys(String pkSys) {
        this.pkSys = pkSys == null ? null : pkSys.trim();
    }

    public String getPkOperator() {
        return pkOperator;
    }

    public void setPkOperator(String pkOperator) {
        this.pkOperator = pkOperator;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public String getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg;
    }

    public String getPkDept() {
        return pkDept;
    }

    public void setPkDept(String pkDept) {
        this.pkDept = pkDept;
    }

    public BigDecimal getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(BigDecimal billstatus) {
        this.billstatus = billstatus;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getPkContract() {
        return pkContract;
    }

    public void setPkContract(String pkContract) {
        this.pkContract = pkContract;
    }

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }
}