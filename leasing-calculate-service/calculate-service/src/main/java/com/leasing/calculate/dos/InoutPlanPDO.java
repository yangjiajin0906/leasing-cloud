package com.leasing.calculate.dos;

import com.leasing.common.base.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @project:leasing-cloud 规则测算器（收支计划子表）VO类
 * @date:2019/9/26
 * @author:Yjj@yonyou.com
 * @description:
 **/

@Entity
@Table(name="yls_inout_plan")
public class InoutPlanPDO extends BaseEntity {
    /**
     * 主键
     */
    @Id
    public String pkInoutPlan;
    /**
     * 主表主键
     */
    public String sourceBill;

    /**
     * 收取期次
     */
    public String leaseTime;
    /**
     * 计算日期
     */
    public String calDate;
    /**
     * 计划收取日期
     */
    public String planDate;
    /**
     * 交易类别
     */
//    @transient
//    public eventtyperefvo transType;
    /**
     * 收支方向
     */
    public Short direction;
    /**
     * 租金
     */
    public BigDecimal leaseCash;
    public BigDecimal factCash;
    /**
     * 租金税额
     */
    public BigDecimal leaseCashTax;

    /**
     * 租金(不含税)
     */
    //public bigdecimal leaseCashCorpus;

    /**
     * 利息
     */
    public BigDecimal leaseInterest;
    /**
     * 利息税额
     */
    public BigDecimal leaseInterestTax;

    /**
     * 利息去税
     */
    //public bigdecimal leaseInterestNotax;
    /**
     * 利息去税(会计)
     */
    //public bigdecimal leaseInterestNotaxFin;
    /**
     * 本金
     */
    public BigDecimal leaseCorpus;
    /**
     * 本金税额
     */
    public BigDecimal leaseCorpusTax;
    /**
     * 本金去税
     */
    //public bigdecimal leaseCorpusNotax;
    /**
     * 本金去税(会计)
     */
    //public bigdecimal leaseCorpusNotaxFin;
    /**
     * 租金去税
     */
    //public bigdecimal leaseCashNotax;
    /**
     * 租金去税(会计)
     */
    //public bigdecimal leaseCashNotaxFin;
    /**
     * 剩余本金
     */
    public BigDecimal corpusBalance;
    /**
     * 剩余租金
     */
    public BigDecimal leaseBalance;
    /**
     * 手续费分摊金额
     */
    public BigDecimal srvfeeShare;

    /**
     * 租金浮动比例
     */
    public BigDecimal rentFloatRatio;

    /**
     * 利率上浮
     */
    public BigDecimal rateUp;

    /**
     * 备注
     */
    public String memo;

    /**
     * 生成方式
     */
    public Short makeMethod;

    /**
     * 租金表类型
     */
    public Short rentType;

    public String pkCustomer;

    /**
     * 数据类型
     */
    public String sourceBilltype;
    /**
     * 合同信息
     */
//    @manytoone()
//    @joincolumn(name = "pkContract", referencedcolumnname = "pkContract")
//    public contractrefvo pkContract;

    /**
     * 租赁收入
     */
    public BigDecimal leaseCashIn;
    /**
     * 其中:去税租息
     */
    public BigDecimal noTaxInterest;
    /**
     * 其中:去税手续费收入
     */
    public BigDecimal noTaxSrvfee;
    /**
     * 其中:去税其它支出
     */
    public BigDecimal noTaxOtherout;
    /**
     * 其中:去税其它收入
     */
    public BigDecimal noTaxOtherin;
    /**
     * 税金
     */
    public BigDecimal sumTax;

    /**
     * 商业折扣
     */
    public BigDecimal tradeDiscount;

    /**
     * 税率
     */
    public Short taxRate;

    /**
     * 新去税租息
     */
    public BigDecimal inputTax;

    /**
     * 进项税
     */
    public BigDecimal inputTaxDiff;

    /**
     * 本金冻结金额(票)
     */
    public BigDecimal ticketFreezeCorpus;
    /**本金实际发生金额(票)*/
    public BigDecimal ticketFactCorpus;
    /**利息冻结金额(票)*/
    public BigDecimal ticketFreezeInterest;
    /**利息实际发生金额(票)*/
    public BigDecimal ticketFactInterest;
    /**财务逾期金额*/
    public BigDecimal fOverdueCash;
    /**财务预收租金冲抵金额*/
    public BigDecimal fAdvanceAgainstCash;
    /**存入保证金冲抵金额*/
    public BigDecimal fDepositAgainstCash;
    /**利息已确认金额*/
    public BigDecimal interestAffirmCash;
    /**减免罚息*/
    public BigDecimal delPenaltyCash;
    /**还款占比*/
    public BigDecimal repaymentRatio;
    /**冻结金额(款)*/
    public BigDecimal freezeCash;
    /**会计租金*/
    public BigDecimal leaseCashFin;
    /**会计本金*/
    public BigDecimal leaseCorpusFin;
    /**会计利息*/
    public BigDecimal leaseInterestFin;
    /**
     * 租金税额(重算)
     */
    public BigDecimal leaseCashTaxFin;
    /**
     * 利息税额(重算)
     */
    public BigDecimal leaseInterestTaxFin;
    /**
     * 本金税额(重算)
     */
    public BigDecimal leaseCorpusTaxFin;
    /**
     * 剩余本金(重算)
     */
    public BigDecimal corpusBalanceFin;
    /**
     * 分拆租金（中投）
     */
    public BigDecimal divideCash;
    /**
     * 分拆本金（中投）
     */
    public BigDecimal divideCorpus;
    /**
     * 分拆利息（中投）
     */
    public BigDecimal divideInterest;


    /**
     * 合同
     */
    //public contractcrefvo pkContractC;

    /**
     * 核销状态
     */
    public Short chargeOffStatus;

    /** add wjj 20160701 */
    public Short taxMode;

    public InoutPlanPDO() {
    }

    public String getPkInoutPlan() {
        return pkInoutPlan;
    }

    public void setPkInoutPlan(String pkInoutPlan) {
        this.pkInoutPlan = pkInoutPlan;
    }

    public String getSourceBill() {
        return sourceBill;
    }

    public void setSourceBill(String sourceBill) {
        this.sourceBill = sourceBill;
    }

    public String getLeaseTime() {
        return leaseTime;
    }

    public void setLeaseTime(String leaseTime) {
        this.leaseTime = leaseTime;
    }

    public String getCalDate() {
        return calDate;
    }

    public void setCalDate(String calDate) {
        this.calDate = calDate;
    }

    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }

    public Short getDirection() {
        return direction;
    }

    public void setDirection(Short direction) {
        this.direction = direction;
    }

    public BigDecimal getLeaseCash() {
        return leaseCash;
    }

    public void setLeaseCash(BigDecimal leaseCash) {
        this.leaseCash = leaseCash;
    }

    public BigDecimal getFactCash() {
        return factCash;
    }

    public void setFactCash(BigDecimal factCash) {
        this.factCash = factCash;
    }

    public BigDecimal getLeaseCashTax() {
        return leaseCashTax;
    }

    public void setLeaseCashTax(BigDecimal leaseCashTax) {
        this.leaseCashTax = leaseCashTax;
    }

    public BigDecimal getLeaseInterest() {
        return leaseInterest;
    }

    public void setLeaseInterest(BigDecimal leaseInterest) {
        this.leaseInterest = leaseInterest;
    }

    public BigDecimal getLeaseInterestTax() {
        return leaseInterestTax;
    }

    public void setLeaseInterestTax(BigDecimal leaseInterestTax) {
        this.leaseInterestTax = leaseInterestTax;
    }

    public BigDecimal getLeaseCorpus() {
        return leaseCorpus;
    }

    public void setLeaseCorpus(BigDecimal leaseCorpus) {
        this.leaseCorpus = leaseCorpus;
    }

    public BigDecimal getLeaseCorpusTax() {
        return leaseCorpusTax;
    }

    public void setLeaseCorpusTax(BigDecimal leaseCorpusTax) {
        this.leaseCorpusTax = leaseCorpusTax;
    }

    public BigDecimal getCorpusBalance() {
        return corpusBalance;
    }

    public void setCorpusBalance(BigDecimal corpusBalance) {
        this.corpusBalance = corpusBalance;
    }

    public BigDecimal getLeaseBalance() {
        return leaseBalance;
    }

    public void setLeaseBalance(BigDecimal leaseBalance) {
        this.leaseBalance = leaseBalance;
    }

    public BigDecimal getSrvfeeShare() {
        return srvfeeShare;
    }

    public void setSrvfeeShare(BigDecimal srvfeeShare) {
        this.srvfeeShare = srvfeeShare;
    }

    public BigDecimal getRentFloatRatio() {
        return rentFloatRatio;
    }

    public void setRentFloatRatio(BigDecimal rentFloatRatio) {
        this.rentFloatRatio = rentFloatRatio;
    }

    public BigDecimal getRateUp() {
        return rateUp;
    }

    public void setRateUp(BigDecimal rateUp) {
        this.rateUp = rateUp;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Short getMakeMethod() {
        return makeMethod;
    }

    public void setMakeMethod(Short makeMethod) {
        this.makeMethod = makeMethod;
    }

    public Short getRentType() {
        return rentType;
    }

    public void setRentType(Short rentType) {
        this.rentType = rentType;
    }

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public String getSourceBilltype() {
        return sourceBilltype;
    }

    public void setSourceBilltype(String sourceBilltype) {
        this.sourceBilltype = sourceBilltype;
    }

    public BigDecimal getLeaseCashIn() {
        return leaseCashIn;
    }

    public void setLeaseCashIn(BigDecimal leaseCashIn) {
        this.leaseCashIn = leaseCashIn;
    }

    public BigDecimal getNoTaxInterest() {
        return noTaxInterest;
    }

    public void setNoTaxInterest(BigDecimal noTaxInterest) {
        this.noTaxInterest = noTaxInterest;
    }

    public BigDecimal getNoTaxSrvfee() {
        return noTaxSrvfee;
    }

    public void setNoTaxSrvfee(BigDecimal noTaxSrvfee) {
        this.noTaxSrvfee = noTaxSrvfee;
    }

    public BigDecimal getNoTaxOtherout() {
        return noTaxOtherout;
    }

    public void setNoTaxOtherout(BigDecimal noTaxOtherout) {
        this.noTaxOtherout = noTaxOtherout;
    }

    public BigDecimal getNoTaxOtherin() {
        return noTaxOtherin;
    }

    public void setNoTaxOtherin(BigDecimal noTaxOtherin) {
        this.noTaxOtherin = noTaxOtherin;
    }

    public BigDecimal getSumTax() {
        return sumTax;
    }

    public void setSumTax(BigDecimal sumTax) {
        this.sumTax = sumTax;
    }

    public BigDecimal getTradeDiscount() {
        return tradeDiscount;
    }

    public void setTradeDiscount(BigDecimal tradeDiscount) {
        this.tradeDiscount = tradeDiscount;
    }

    public Short getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Short taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getInputTax() {
        return inputTax;
    }

    public void setInputTax(BigDecimal inputTax) {
        this.inputTax = inputTax;
    }

    public BigDecimal getInputTaxDiff() {
        return inputTaxDiff;
    }

    public void setInputTaxDiff(BigDecimal inputTaxDiff) {
        this.inputTaxDiff = inputTaxDiff;
    }

    public BigDecimal getTicketFreezeCorpus() {
        return ticketFreezeCorpus;
    }

    public void setTicketFreezeCorpus(BigDecimal ticketFreezeCorpus) {
        this.ticketFreezeCorpus = ticketFreezeCorpus;
    }

    public BigDecimal getTicketFactCorpus() {
        return ticketFactCorpus;
    }

    public void setTicketFactCorpus(BigDecimal ticketFactCorpus) {
        this.ticketFactCorpus = ticketFactCorpus;
    }

    public BigDecimal getTicketFreezeInterest() {
        return ticketFreezeInterest;
    }

    public void setTicketFreezeInterest(BigDecimal ticketFreezeInterest) {
        this.ticketFreezeInterest = ticketFreezeInterest;
    }

    public BigDecimal getTicketFactInterest() {
        return ticketFactInterest;
    }

    public void setTicketFactInterest(BigDecimal ticketFactInterest) {
        this.ticketFactInterest = ticketFactInterest;
    }

    public BigDecimal getfOverdueCash() {
        return fOverdueCash;
    }

    public void setfOverdueCash(BigDecimal fOverdueCash) {
        this.fOverdueCash = fOverdueCash;
    }

    public BigDecimal getfAdvanceAgainstCash() {
        return fAdvanceAgainstCash;
    }

    public void setfAdvanceAgainstCash(BigDecimal fAdvanceAgainstCash) {
        this.fAdvanceAgainstCash = fAdvanceAgainstCash;
    }

    public BigDecimal getfDepositAgainstCash() {
        return fDepositAgainstCash;
    }

    public void setfDepositAgainstCash(BigDecimal fDepositAgainstCash) {
        this.fDepositAgainstCash = fDepositAgainstCash;
    }

    public BigDecimal getInterestAffirmCash() {
        return interestAffirmCash;
    }

    public void setInterestAffirmCash(BigDecimal interestAffirmCash) {
        this.interestAffirmCash = interestAffirmCash;
    }

    public BigDecimal getDelPenaltyCash() {
        return delPenaltyCash;
    }

    public void setDelPenaltyCash(BigDecimal delPenaltyCash) {
        this.delPenaltyCash = delPenaltyCash;
    }

    public BigDecimal getRepaymentRatio() {
        return repaymentRatio;
    }

    public void setRepaymentRatio(BigDecimal repaymentRatio) {
        this.repaymentRatio = repaymentRatio;
    }

    public BigDecimal getFreezeCash() {
        return freezeCash;
    }

    public void setFreezeCash(BigDecimal freezeCash) {
        this.freezeCash = freezeCash;
    }

    public BigDecimal getLeaseCashFin() {
        return leaseCashFin;
    }

    public void setLeaseCashFin(BigDecimal leaseCashFin) {
        this.leaseCashFin = leaseCashFin;
    }

    public BigDecimal getLeaseCorpusFin() {
        return leaseCorpusFin;
    }

    public void setLeaseCorpusFin(BigDecimal leaseCorpusFin) {
        this.leaseCorpusFin = leaseCorpusFin;
    }

    public BigDecimal getLeaseInterestFin() {
        return leaseInterestFin;
    }

    public void setLeaseInterestFin(BigDecimal leaseInterestFin) {
        this.leaseInterestFin = leaseInterestFin;
    }

    public BigDecimal getLeaseCashTaxFin() {
        return leaseCashTaxFin;
    }

    public void setLeaseCashTaxFin(BigDecimal leaseCashTaxFin) {
        this.leaseCashTaxFin = leaseCashTaxFin;
    }

    public BigDecimal getLeaseInterestTaxFin() {
        return leaseInterestTaxFin;
    }

    public void setLeaseInterestTaxFin(BigDecimal leaseInterestTaxFin) {
        this.leaseInterestTaxFin = leaseInterestTaxFin;
    }

    public BigDecimal getLeaseCorpusTaxFin() {
        return leaseCorpusTaxFin;
    }

    public void setLeaseCorpusTaxFin(BigDecimal leaseCorpusTaxFin) {
        this.leaseCorpusTaxFin = leaseCorpusTaxFin;
    }

    public BigDecimal getCorpusBalanceFin() {
        return corpusBalanceFin;
    }

    public void setCorpusBalanceFin(BigDecimal corpusBalanceFin) {
        this.corpusBalanceFin = corpusBalanceFin;
    }

    public BigDecimal getDivideCash() {
        return divideCash;
    }

    public void setDivideCash(BigDecimal divideCash) {
        this.divideCash = divideCash;
    }

    public BigDecimal getDivideCorpus() {
        return divideCorpus;
    }

    public void setDivideCorpus(BigDecimal divideCorpus) {
        this.divideCorpus = divideCorpus;
    }

    public BigDecimal getDivideInterest() {
        return divideInterest;
    }

    public void setDivideInterest(BigDecimal divideInterest) {
        this.divideInterest = divideInterest;
    }

    public Short getChargeOffStatus() {
        return chargeOffStatus;
    }

    public void setChargeOffStatus(Short chargeOffStatus) {
        this.chargeOffStatus = chargeOffStatus;
    }

    public Short getTaxMode() {
        return taxMode;
    }

    public void setTaxMode(Short taxMode) {
        this.taxMode = taxMode;
    }

    public int compareTo(Object o) {
        String pk = null;
        String oldpk = null;
        DecimalFormat df = new DecimalFormat("0000000000");
        if (pk == null) {
            pk = "Z" + df.format((long) this.hashCode());
        }

        if (oldpk == null) {
            oldpk = "Z" + df.format((long) o.hashCode());
        }

        return pk.compareTo(oldpk);
    }

    @Override
    public String getPk() {
        return pkInoutPlan;
    }

    @Override
    public void setPk(String pk) {
        this.pkInoutPlan = pk;
    }
}