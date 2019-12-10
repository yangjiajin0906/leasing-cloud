package com.leasing.communication.entity.vo;

import com.leasing.common.entity.foundation.vo.CurrtypeVO;
import com.leasing.communication.entity.dto.SourceSystemDTO;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @description 提前结清 DO
 * @author Yangjiajin
 * @date 2019/12/5 13:44
 */
@Entity
@Table(name="yc_early_settlement")
public class CbEarlySettlementVO {
    /**
     * 主键
     */
    @Id
    private String pkEarlySettlement;

    /**
     * 合同主键
     */
    @Transient
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
    @Transient
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
    private String rentDate;

    /**
     * 租赁方式
     */
    private BigDecimal leaseType;

    /**
     * 剩余应还租金
     */
    private BigDecimal payableRentBalance;

    /**
     * 剩余本金
     */
    private BigDecimal corpusBalance;

    /**
     * 币种
     */
    @ManyToOne()
    @JoinColumn(name="pkCurrency")
    //@NotFound(action= NotFoundAction.IGNORE)
    public CurrtypeVO pkCurrency;

    /**
     * 公司主体
     */
    private String companyBody;

    /**
     * 来源系统
     */
    @ManyToOne
    @JoinColumn(name = "pkSys")
    //@NotFound(action= NotFoundAction.IGNORE)
    private SourceSystemDTO pkSys;

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
     * @return PK_EARLY_SETTLEMENT 主键
     */
    public String getPkEarlySettlement() {
        return pkEarlySettlement;
    }

    /**
     * 主键
     * @param pkEarlySettlement 主键
     */
    public void setPkEarlySettlement(String pkEarlySettlement) {
        this.pkEarlySettlement = pkEarlySettlement == null ? null : pkEarlySettlement.trim();
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
    public BigDecimal getLeaseType() {
        return leaseType;
    }

    /**
     * 租赁方式
     * @param leaseType 租赁方式
     */
    public void setLeaseType(BigDecimal leaseType) {
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

    public CurrtypeVO getPkCurrency() {
        return pkCurrency;
    }

    public void setPkCurrency(CurrtypeVO pkCurrency) {
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

    public SourceSystemDTO getPkSys() {
        return pkSys;
    }

    public void setPkSys(SourceSystemDTO pkSys) {
        this.pkSys = pkSys;
    }

    /**
     * 操作人
     * @return PK_OPERATOR 操作人
     */
    public String getPkOperator() {
        return pkOperator;
    }

    /**
     * 操作人
     * @param pkOperator 操作人
     */
    public void setPkOperator(String pkOperator) {
        this.pkOperator = pkOperator == null ? null : pkOperator.trim();
    }

    /**
     * 操作日期
     * @return OPERATE_DATE 操作日期
     */
    public String getOperateDate() {
        return operateDate;
    }

    /**
     * 操作日期
     * @param operateDate 操作日期
     */
    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate == null ? null : operateDate.trim();
    }

    /**
     * 操作时间
     * @return OPERATE_TIME 操作时间
     */
    public String getOperateTime() {
        return operateTime;
    }

    /**
     * 操作时间
     * @param operateTime 操作时间
     */
    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime == null ? null : operateTime.trim();
    }

    /**
     * 机构
     * @return PK_ORG 机构
     */
    public String getPkOrg() {
        return pkOrg;
    }

    /**
     * 机构
     * @param pkOrg 机构
     */
    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg == null ? null : pkOrg.trim();
    }

    /**
     * 部门主键
     * @return PK_DEPT 部门主键
     */
    public String getPkDept() {
        return pkDept;
    }

    /**
     * 部门主键
     * @param pkDept 部门主键
     */
    public void setPkDept(String pkDept) {
        this.pkDept = pkDept == null ? null : pkDept.trim();
    }

    /**
     * 单据状态
     * @return BILLSTATUS 单据状态
     */
    public BigDecimal getBillstatus() {
        return billstatus;
    }

    /**
     * 单据状态
     * @param billstatus 单据状态
     */
    public void setBillstatus(BigDecimal billstatus) {
        this.billstatus = billstatus;
    }

    /**
     * 时间戳
     * @return TS 时间戳
     */
    public String getTs() {
        return ts;
    }

    /**
     * 时间戳
     * @param ts 时间戳
     */
    public void setTs(String ts) {
        this.ts = ts == null ? null : ts.trim();
    }
}