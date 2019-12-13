package com.leasing.communication.entity.dos;


import com.leasing.common.base.entity.BaseDO;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Description: 计提主表
 */
@Entity
@Table(name="yc_accrued")
public class AccruedDO extends BaseDO {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "yl_oid")
    @GenericGenerator(name = "yl_oid", strategy = "com.leasing.common.utils.frame.OIDGenerator")
    public String pkAccrued;


    /**
     * 计提月份
     */
    public String accrualMonth;


    /**
     * 租赁利息计提
     */
    public BigDecimal interestAmount;


    /**
     * 手续费收入计提总额
     */
    public BigDecimal feeAmount;


    /**
     * 其他收入计提总额
     */
    public BigDecimal otherIncomeAmount;


    /**
     * 其他支出计提总额
     */
    public BigDecimal otherExpensesAmount;


    /**
     * 合同类型
     */
    public Short contractType;

    /**
     * 计提单位
     */
    public String pkCorp;

    /**
     * 复核员主键
     */
    public String pkChecker;

    /**
     * 复核日期
     */
    public String checkDate;

    /**
     * 复核时间
     */
    public String checkTime;

    /**
     * 授权人主键
     */
    public String pkGrantor;

    /**
     * 授权日期
     */
    public String grantDate;


    /**
     * 授权时间
     */
    public String grantTime;

    /**
     * 计提子表(中投)
     */
    @OneToMany(orphanRemoval=true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="pkAccrued")
    public List<AccruedDetailDO> pkAccruedDetail;

    /**
     * 单据状态
     */
    public Short billstatus;
    /**
     * 操作人
     */
    public String pkOperator;
    /**
     * 操作日期
     */
    public String operateDate;
    /**
     * 操作时间
     */
    public String operateTime;
    /**
     * 机构
     */
    public String pkOrg;

    /**
     * 类LeaseAccruedVO的构造方法
     */
    public AccruedDO() {
    }

    @Override
    public String getPk() {
        return pkAccrued;
    }

    @Override
    public void setPk(String pk) {
        this.pkAccrued = pk;
    }

    public String getPkAccrued() {
        return pkAccrued;
    }

    public void setPkAccrued(String pkAccrued) {
        this.pkAccrued = pkAccrued;
    }

    public String getAccrualMonth() {
        return accrualMonth;
    }

    public void setAccrualMonth(String accrualMonth) {
        this.accrualMonth = accrualMonth;
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

    public Short getContractType() {
        return contractType;
    }

    public void setContractType(Short contractType) {
        this.contractType = contractType;
    }

    public String getPkCorp() {
        return pkCorp;
    }

    public void setPkCorp(String pkCorp) {
        this.pkCorp = pkCorp;
    }

    public String getPkChecker() {
        return pkChecker;
    }

    public void setPkChecker(String pkChecker) {
        this.pkChecker = pkChecker;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getPkGrantor() {
        return pkGrantor;
    }

    public void setPkGrantor(String pkGrantor) {
        this.pkGrantor = pkGrantor;
    }

    public String getGrantDate() {
        return grantDate;
    }

    public void setGrantDate(String grantDate) {
        this.grantDate = grantDate;
    }

    public String getGrantTime() {
        return grantTime;
    }

    public void setGrantTime(String grantTime) {
        this.grantTime = grantTime;
    }

    public List<AccruedDetailDO> getPkAccruedDetail() {
        return pkAccruedDetail;
    }

    public void setPkAccruedDetail(List<AccruedDetailDO> pkAccruedDetail) {
        this.pkAccruedDetail = pkAccruedDetail;
    }

    public Short getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
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
}

