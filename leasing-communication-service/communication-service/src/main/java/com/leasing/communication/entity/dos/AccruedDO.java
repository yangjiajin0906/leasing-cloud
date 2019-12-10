package com.leasing.communication.entity.dos;


import com.leasing.common.base.entity.BaseBusinessDO;
import com.leasing.common.base.entity.BaseDO;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
/**
 * Title: 租赁账户管理系统<br>
 * Description: 计提主表(中投)类<br>
 * Copyright: Copyright (c) 2010<br>
 * Company: UFIDA<br>
 *
 * @author
 * @version
 */
@Entity
@Table(name="yls_lease_accrued")
public class AccruedDO extends BaseDO {

    /**
     * 主键
     */
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_id")
//    @SequenceGenerator(name="seq_id", sequenceName="CB_OID_SEQ")
    public String pkLeaseAccrued;


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
    @JoinColumn(name="pkLeaseAccrued")
    public List<AccruedBDO> leaseAccruedB;

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
        return pkLeaseAccrued;
    }

    @Override
    public void setPk(String pk) {
        this.pkLeaseAccrued = pk;
    }

    public String getPkLeaseAccrued() {
        return pkLeaseAccrued;
    }

    public void setPkLeaseAccrued(String pkLeaseAccrued) {
        this.pkLeaseAccrued = pkLeaseAccrued;
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

    public List<AccruedBDO> getLeaseAccruedB() {
        return leaseAccruedB;
    }

    public void setLeaseAccruedB(List<AccruedBDO> leaseAccruedB) {
        this.leaseAccruedB = leaseAccruedB;
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

