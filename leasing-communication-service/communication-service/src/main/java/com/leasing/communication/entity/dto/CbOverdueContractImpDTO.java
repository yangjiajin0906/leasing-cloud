package com.leasing.communication.entity.dto;

import com.leasing.common.base.annotation.Excel;
import com.leasing.common.base.entity.BaseDTO;

import java.math.BigDecimal;
/**
 * @description 逾期合同 2C业务 导入文件实体类，只用于导入，不参与前后端业务处理
 * @author Yangjiajin
 * @date 2019/12/5 13:44
 */
public class CbOverdueContractImpDTO extends BaseDTO {

    /**
     * 付款交易批次号
     */
    @Excel(titleName = "付款交易批次号",orderNum = 0)
    private String paymentBatchNo;

    /**
     * 合同编号
     */
    @Excel(titleName = "合同编号",orderNum = 1)
    private String contCode;

    /**
     * 合同名称
     */
    @Excel(titleName = "合同名称",orderNum = 2)
    private String contName;

    /**
     * 客户名称
     */
    @Excel(titleName = "客户名称",orderNum = 3)
    private String customerName;

    /**
     * 单位名称
     */
    @Excel(titleName = "单位名称",orderNum = 4)
    private String employerName;

    /**
     * 起租日期
     */
    @Excel(titleName = "起租日期",orderNum = 5)
    private String leaseDate;

    /**
     * 期次
     */
    @Excel(titleName = "期次",orderNum = 6)
    private Integer periodTime;

    /**
     * 应收日期
     */
    @Excel(titleName = "应收日期",orderNum = 7)
    private String receivableDate;

    /**
     * 应收金额
     */
    @Excel(titleName = "应收金额",orderNum = 8)
    private BigDecimal receivableAmount;

    /**
     * 逾期状态
     */
    @Excel(titleName = "逾期状态",orderNum = 9)
    private Integer overdueState;

    /**
     * 币种
     */
    @Excel(titleName = "币种",orderNum = 10)
    private String pkCurrency;

    /**
     * 公司主体
     */
    @Excel(titleName = "公司主体",orderNum = 11)
    private String companyBody;

    /**
     * 来源系统
     */
    @Excel(titleName = "来源系统",orderNum = 12)
    private String pkSys;

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
}