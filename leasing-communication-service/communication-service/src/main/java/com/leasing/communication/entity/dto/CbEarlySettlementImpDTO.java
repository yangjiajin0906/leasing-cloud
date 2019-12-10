package com.leasing.communication.entity.dto;

import com.leasing.common.base.annotation.Excel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @description 提前结清DTO
 * @author Yangjiajin
 * @date 2019/12/5 13:44
 */

public class CbEarlySettlementImpDTO {

    /**
     * 合同编号
     */
    @Excel(titleName = "合同编号",orderNum = 0)
    private String contCode;

    /**
     * 合同名称
     */
    @Excel(titleName = "合同名称",orderNum = 1)
    private String contName;

    /**
     * 客户名称
     */
    @Excel(titleName = "客户名称",orderNum = 2)
    private String customerName;

    /**
     * 单位名称
     */
    @Excel(titleName = "单位名称",orderNum = 3)
    private String employerName;

    /**
     * 起租日期
     */
    @Excel(titleName = "起租日期",orderNum = 4)
    private String rentDate;

    /**
     * 租赁方式
     */
    @Excel(titleName = "租赁方式",orderNum = 5)
    private Integer leaseType;

    /**
     * 剩余应还租金
     */
    @Excel(titleName = "剩余应还租金",orderNum = 6)
    private BigDecimal payableRentBalance;

    /**
     * 剩余本金
     */
    @Excel(titleName = "剩余本金",orderNum = 7)
    private BigDecimal corpusBalance;

    /**
     * 币种
     */
    @Excel(titleName = "币种",orderNum = 8)
    private String pkCurrency;

    /**
     * 公司主体
     */
    @Excel(titleName = "公司主体",orderNum = 9)
    private String companyBody;

    /**
     * 来源系统
     */
    @Excel(titleName = "来源系统",orderNum = 10)
    private String pkSys;


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
     * 剩余应还租金
     * @return PAYABLE_RENT_BALANCE 剩余应还租金
     */
    public BigDecimal getPayableRentBalance() {
        return payableRentBalance;
    }

    /**
     * 剩余应还租金
     * @param payableRentBalance 剩余应还租金
     */
    public void setPayableRentBalance(BigDecimal payableRentBalance) {
        this.payableRentBalance = payableRentBalance;
    }

    /**
     * 剩余本金
     * @return CORPUS_BALANCE 剩余本金
     */
    public BigDecimal getCorpusBalance() {
        return corpusBalance;
    }

    /**
     * 剩余本金
     * @param corpusBalance 剩余本金
     */
    public void setCorpusBalance(BigDecimal corpusBalance) {
        this.corpusBalance = corpusBalance;
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