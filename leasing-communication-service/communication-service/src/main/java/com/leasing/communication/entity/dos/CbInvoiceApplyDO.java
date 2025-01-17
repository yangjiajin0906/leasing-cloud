package com.leasing.communication.entity.dos;

import com.leasing.common.base.entity.BaseDO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @description 2c票据信息 主表DO
 * @author Yangjiajin
 * @date 2019/11/12 10:57
 */
@Entity
@Table(name="yc_invoice_apply")
public class CbInvoiceApplyDO extends BaseDO{
    /**
     * 票据信息主键
     */
    @Id
    private String pkInvoiceApply;

    /**
     * 单据状态
     */
    private Short billstatus;

    /**
     * 开票批次号
     */
    private String invoiceBatchNo;

    /**
     * 发票总额
     */
    private BigDecimal invoiceAmount;

    /**
     * 发票税额
     */
    private BigDecimal leaseCashTax;

    /**
     * 不含税金额
     */
    private BigDecimal excludingTax;

    /**
     * 开票状态
     */
    private Short billingStatus;

    /**
     * 开票日期
     */
    private String billingData;

    /**
     * 发票代码
     */
    private String invoiceCode;

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
     * 来源系统
     */
    private String pkSys;

    @OneToMany(orphanRemoval=true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="pkInvoiceApplyDetail")
    private List<CbInvoiceApplyDetailDO> pkInvoiceApplyDetail;

    public List<CbInvoiceApplyDetailDO> getPkInvoiceApplyDetail() {
        return pkInvoiceApplyDetail;
    }

    public void setPkInvoiceApplyDetail(List<CbInvoiceApplyDetailDO> pkInvoiceApplyDetail) {
        this.pkInvoiceApplyDetail = pkInvoiceApplyDetail;
    }

    @Override
    public String getPk() {
        return pkInvoiceApply;
    }

    @Override
    public void setPk(String pk) {
        this.pkInvoiceApply = pk;
    }

    /**
     * 票据信息主键
     * @return PK_INVOICE_APPLY 票据信息主键
     */
    public String getPkInvoiceApply() {
        return pkInvoiceApply;
    }

    /**
     * 票据信息主键
     * @param pkInvoiceApply 票据信息主键
     */
    public void setPkInvoiceApply(String pkInvoiceApply) {
        this.pkInvoiceApply = pkInvoiceApply == null ? null : pkInvoiceApply.trim();
    }

    /**
     * 单据状态
     * @return BILLSTATUS 单据状态
     */
    public Short getBillstatus() {
        return billstatus;
    }

    /**
     * 单据状态
     * @param billstatus 单据状态
     */
    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
    }

    /**
     * 开票批次号
     * @return INVOICE_BATCH_NO 开票批次号
     */
    public String getInvoiceBatchNo() {
        return invoiceBatchNo;
    }

    /**
     * 开票批次号
     * @param invoiceBatchNo 开票批次号
     */
    public void setInvoiceBatchNo(String invoiceBatchNo) {
        this.invoiceBatchNo = invoiceBatchNo == null ? null : invoiceBatchNo.trim();
    }

    /**
     * 发票总额
     * @return INVOICE_AMOUNT 发票总额
     */
    public BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    /**
     * 发票总额
     * @param invoiceAmount 发票总额
     */
    public void setInvoiceAmount(BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    /**
     * 发票税额
     * @return LEASE_CASH_TAX 发票税额
     */
    public BigDecimal getLeaseCashTax() {
        return leaseCashTax;
    }

    /**
     * 发票税额
     * @param leaseCashTax 发票税额
     */
    public void setLeaseCashTax(BigDecimal leaseCashTax) {
        this.leaseCashTax = leaseCashTax;
    }

    /**
     * 不含税金额
     * @return EXCLUDING_TAX 不含税金额
     */
    public BigDecimal getExcludingTax() {
        return excludingTax;
    }

    /**
     * 不含税金额
     * @param excludingTax 不含税金额
     */
    public void setExcludingTax(BigDecimal excludingTax) {
        this.excludingTax = excludingTax;
    }

    /**
     * 开票状态
     * @return BILLING_STATUS 开票状态
     */
    public Short getBillingStatus() {
        return billingStatus;
    }

    /**
     * 开票状态
     * @param billingStatus 开票状态
     */
    public void setBillingStatus(Short billingStatus) {
        this.billingStatus = billingStatus;
    }

    /**
     * 开票日期
     * @return BILLING_DATA 开票日期
     */
    public String getBillingData() {
        return billingData;
    }

    /**
     * 开票日期
     * @param billingData 开票日期
     */
    public void setBillingData(String billingData) {
        this.billingData = billingData == null ? null : billingData.trim();
    }

    /**
     * 发票代码
     * @return INVOICE_CODE 发票代码
     */
    public String getInvoiceCode() {
        return invoiceCode;
    }

    /**
     * 发票代码
     * @param invoiceCode 发票代码
     */
    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode == null ? null : invoiceCode.trim();
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