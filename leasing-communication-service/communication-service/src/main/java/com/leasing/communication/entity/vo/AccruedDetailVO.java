package com.leasing.communication.entity.vo;


import com.leasing.common.base.entity.BaseDO;
import com.leasing.common.entity.foundation.vo.CurrtypeVO;
import com.leasing.communication.entity.dto.CustomerDTO;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Description: 计提子表
 */
@Entity
@Table(name="yc_accrued_detail")
public class AccruedDetailVO extends BaseDO {

    /**
     * 主键
     */
    @Id
    public String pkAccruedDetail;
    /**
     * 计提表主键
     */
    public String pkAccrual;
    /**
     * 主表主键
     */
    public String pkAccrued; //主表主键
    /**
     * 客户
     */
    @ManyToOne
    @JoinColumn(name="pkCustomer")
    public CustomerDTO pkCustomer;

    /**
     * 客户编码
     */
    public String customerCode;

    public String customerName;

    /**
     * 合同
     */
    @ManyToOne
    @JoinColumn(name = "pkContract")
    @NotFound(action= NotFoundAction.IGNORE)
    public ContractDTO pkContract;

    /**
     * 资产状态
     */
    public String assetStatus;

    /**
     * 起租流程
     */
    public Short leaseFlow;

    /**
     * 资产五级分类
     */
    public Short assetsClassify;
    /**
     * 计提月份
     */
    public String accruedMonth;
    /**
     * 租赁利息计提金额
     */
    public BigDecimal interestAmount;
    /**
     * 手续费收入计提金额
     */
    public BigDecimal feeAmount;
    /**
     * 其他收入计提金额
     */
    public BigDecimal otherIncomeAmount;
    /**
     * 其他支出计提金额
     */
    public BigDecimal otherExpensesAmount;
    /**
     * 币种
     */
    @ManyToOne()
    @JoinColumn(name="pkCurrtype")
    public CurrtypeVO pkCurrtype;
    /**
     * 汇率
     */
    public BigDecimal exchgRate;
    /**
     * 核算主体
     */
    public String pkGlorgbook;

    /**
     * 类LeaseAccruedBVO的构造方法
     */
    public AccruedDetailVO() {
    }

    public Short getLeaseFlow() {
        return leaseFlow;
    }

    public void setLeaseFlow(Short leaseFlow) {
        this.leaseFlow = leaseFlow;
    }

    public String getPkAccruedDetail() {
        return pkAccruedDetail;
    }

    public void setPkAccruedDetail(String pkAccruedDetail) {
        this.pkAccruedDetail = pkAccruedDetail;
    }

    public String getPkAccrual() {
        return pkAccrual;
    }

    public void setPkAccrual(String pkAccrual) {
        this.pkAccrual = pkAccrual;
    }

    public String getPkAccrued() {
        return pkAccrued;
    }

    public void setPkAccrued(String pkAccrued) {
        this.pkAccrued = pkAccrued;
    }

    public CustomerDTO getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(CustomerDTO pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public ContractDTO getPkContract() {
        return pkContract;
    }

    public void setPkContract(ContractDTO pkContract) {
        this.pkContract = pkContract;
    }

    public String getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(String assetStatus) {
        this.assetStatus = assetStatus;
    }

    public Short getAssetsClassify() {
        return assetsClassify;
    }

    public void setAssetsClassify(Short assetsClassify) {
        this.assetsClassify = assetsClassify;
    }

    public String getAccruedMonth() {
        return accruedMonth;
    }

    public void setAccruedMonth(String accruedMonth) {
        this.accruedMonth = accruedMonth;
    }

    public BigDecimal getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(BigDecimal interestAmount) {
        this.interestAmount = interestAmount;
    }

    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }

    public BigDecimal getOtherIncomeAmount() {
        return otherIncomeAmount;
    }

    public void setOtherIncomeAmount(BigDecimal otherIncomeAmount) {
        this.otherIncomeAmount = otherIncomeAmount;
    }

    public BigDecimal getOtherExpensesAmount() {
        return otherExpensesAmount;
    }

    public void setOtherExpensesAmount(BigDecimal otherExpensesAmount) {
        this.otherExpensesAmount = otherExpensesAmount;
    }

    public CurrtypeVO getPkCurrtype() {
        return pkCurrtype;
    }

    public void setPkCurrtype(CurrtypeVO pkCurrtype) {
        this.pkCurrtype = pkCurrtype;
    }

    public BigDecimal getExchgRate() {
        return exchgRate;
    }

    public void setExchgRate(BigDecimal exchgRate) {
        this.exchgRate = exchgRate;
    }

    public String getPkGlorgbook() {
        return pkGlorgbook;
    }

    public void setPkGlorgbook(String pkGlorgbook) {
        this.pkGlorgbook = pkGlorgbook;
    }

    @Override
    public String getPk() {
        return pkAccruedDetail;
    }

    @Override
    public void setPk(String pk) {
        this.pkAccruedDetail = pk;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }
}

