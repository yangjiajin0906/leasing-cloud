package com.leasing.rentearly.rentearlyservice.projectInfo.enity.dto;

import com.leasing.common.base.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/10/30
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "(" +
        "WITH VLC AS" +
        " (SELECT DECODE(LC_CNT.CNT," +
        "                1," +
        "                LC.QUOT_NAME," +
        "                '因有多个报价方案，请到子页签“报价方案”查看详情！') QUOT_NAME," +
        "         DECODE(LC_CNT.CNT, 1, LC.QUOT_CODE, NULL) QUOT_CODE," +
        "         DECODE(LC_CNT.CNT, 1, LC.PK_LIMIT_PLAN, NULL) PK_LIMIT_PLAN," +
        "         DECODE(LC_CNT.CNT, 1, LC.LEASE_METHOD, NULL) LEASE_METHOD," +
        "         DECODE(LC_CNT.CNT, 1, LC.TAX_MODE, NULL) TAX_MODE," +
        "         DECODE(LC_CNT.CNT, 1, LC.LEASE_TIMES, NULL) LEASE_TIMES," +
        "         DECODE(LC_CNT.CNT," +
        "                1," +
        "                DECODE(LC.RENT_TABLE_TYPE," +
        "                       0," +
        "                       CLR.LEASE_CAL_METHOD," +
        "                       LC.LEASE_CAL_METHOD)," +
        "                NULL) LEASE_CAL_METHOD," +
        "         DECODE(LC_CNT.CNT," +
        "                1," +
        "                DECODE(LC.RENT_TABLE_TYPE, 0, CLR.LEASE_FREQ, LC.LEASE_FREQ)," +
        "                NULL) LEASE_FREQ," +
        "         DECODE(LC_CNT.CNT, 1, LC.FINAL_RATE, NULL) FINAL_RATE," +
        "         LC.TOTAL_AMOUNT_EQUIPMENT TOTAL_AMOUNT_EQUIPMENT," +
        "         LC.NET_FINANCE_CASH NET_FINANCE_CASH," +
        "         LC.TRADE_DISCOUNT TRADE_DISCOUNT," +
        "         LC.PLAN_CASH_LOAN PLAN_CASH_LOAN," +
        "         LC.FACT_CASH_LOAN FACT_CASH_LOAN," +
        "         LC.DOWN_PAYMENT DOWN_PAYMENT," +
        "         LC.DEPOSIT_CASH DEPOSIT_CASH," +
        "         LC.SRVFEE_CASH_IN SRVFEE_CASH_IN," +
        "         LC.SRVFEE_CASH_OUT SRVFEE_CASH_OUT," +
        "         DECODE(LC_CNT.CNT, 1, LC.COMMERCIAL_IRR, NULL) COMMERCIAL_IRR," +
        "         DECODE(LC_CNT.CNT, 1, LC.VAT_IRR, NULL) VAT_IRR," +
        "         DECODE(LC_CNT.CNT, 1, LC.FINANCE_IRR, NULL) FINANCE_IRR," +
        "         DECODE(LC_CNT.CNT, 1, LC.RENT_IRR, NULL) RENT_IRR," +
        "         DECODE(LC_CNT.CNT, 1, LC.PROJECT_IRR, NULL) PROJECT_IRR," +
        "         DECODE(LC_CNT.CNT, 1, LC.PROJECT_NOTAX_IRR, NULL) PROJECT_NOTAX_IRR," +
        "         DECODE(LC_CNT.CNT, 1, LC.FEE_DISTR_IRR, NULL) FEE_DISTR_IRR," +
        "         DECODE(LC_CNT.CNT, 1, LC.CONTRACT_IRR, NULL) CONTRACT_IRR," +
        "         DECODE(LC_CNT.CNT, 1, LC.AUDIT_IRR, NULL) AUDIT_IRR," +
        "         DECODE(LC_CNT.CNT, 1, LC.LESSEE_IRR, NULL) LESSEE_IRR," +
        "         DECODE(LC_CNT.CNT, 1, LC.FINANCE_NOTAX_IRR, NULL) FINANCE_NOTAX_IRR," +
        "         " +
        " /* [会计IRR算法调整]　wangjj 2016/10/28 */           " +
        "         DECODE(LC_CNT.CNT,1,LC.FINANCE_IRR_METHOD,NULL) FINANCE_IRR_METHOD,                         /*会计IRR按最新算法*/" +
        "         DECODE(LC_CNT.CNT,1,LC.FINANCE_IRR_YEAR,NULL) FINANCE_IRR_YEAR,                  /*会计IRR启用年份*/" +
        " /* [会计IRR算法调整]　wangjj 2016/10/28 end */           " +
        "         " +
        "         LC.PK_PROJECT_INFO PK_PROJECT_INFO" +
        "    FROM YLS_LEASE_CALCULATOR LC" +
        "   INNER JOIN (SELECT COUNT(LC.PK_LEASE_CALCULATOR) CNT, PK_PROJECT_INFO" +
        "                FROM YLS_LEASE_CALCULATOR LC" +
        "               WHERE PK_CONTRACT IS NULL" +
        "               GROUP BY LC.PK_PROJECT_INFO) LC_CNT" +
        "      ON LC.PK_PROJECT_INFO = LC_CNT.PK_PROJECT_INFO" +
        "    LEFT JOIN (SELECT DECODE(LRC.CNT, 1, LR.LEASE_FREQ, NULL) LEASE_FREQ," +
        "                     DECODE(LRC.CNT, 1, LR.LEASE_CAL_METHOD, NULL) LEASE_CAL_METHOD," +
        "                     LR.SOURCE_BILL SOURCE_BILL" +
        "                FROM YLS_LEASE_RULE LR" +
        "               INNER JOIN (SELECT COUNT(1) CNT, T.SOURCE_BILL SOURCE_BILL" +
        "                            FROM YLS_LEASE_RULE T" +
        "                           GROUP BY T.SOURCE_BILL) LRC" +
        "                  ON LRC.SOURCE_BILL = LR.SOURCE_BILL) CLR" +
        "      ON CLR.SOURCE_BILL = LC.PK_LEASE_CALCULATOR" +
        "   WHERE LC.PK_CONTRACT IS NULL)," +
        "VIP AS" +
        " (SELECT SUM(IP.LEASE_CASH) LEASE_CASH," +
        "         SUM(IP.LEASE_INTEREST) LEASE_INTEREST," +
        "         SUM(IP.LEASE_CORPUS) LEASE_CORPUS," +
        "         LC.PK_PROJECT_INFO PK_PROJECT_INFO" +
        "    FROM YLS_INOUT_PLAN IP, YLS_LEASE_CALCULATOR LC, YLS_EVENT_TYPE ET" +
        "   WHERE IP.SOURCE_BILL = LC.PK_LEASE_CALCULATOR" +
        "     AND IP.TRANS_TYPE = ET.PK_EVENT_TYPE" +
        "     AND ET.EVENT_CODE IN ('10201', '10202', '10203')" +
        "     AND IP.RENT_TYPE = 1" +
        "     AND LC.PK_CONTRACT IS NULL" +
        "   GROUP BY LC.PK_PROJECT_INFO)" +
        "SELECT A.PK_PROJECT_INFO," +
        "       A.QUOT_NAME," +
        "       A.QUOT_CODE," +
        "       LP.LIMIT_NAME," +
        "       A.LEASE_METHOD," +
        "       A.TAX_MODE," +
        "       A.LEASE_TIMES," +
        "       A.LEASE_FREQ," +
        "       A.LEASE_CAL_METHOD," +
        "       A.FINAL_RATE," +
        "       NVL(SUM(A.TOTAL_AMOUNT_EQUIPMENT), 0) TOTAL_AMOUNT_EQUIPMENT," +
        "       NVL(SUM(A.NET_FINANCE_CASH), 0) NET_FINANCE_CASH," +
        "       NVL(SUM(A.TRADE_DISCOUNT), 0) TRADE_DISCOUNT," +
        "       NVL(SUM(A.PLAN_CASH_LOAN), 0) PLAN_CASH_LOAN," +
        "       NVL(SUM(A.FACT_CASH_LOAN), 0) FACT_CASH_LOAN," +
        "       NVL(SUM(A.DOWN_PAYMENT), 0) DOWN_PAYMENT," +
        "       NVL(SUM(A.DEPOSIT_CASH), 0) DEPOSIT_CASH," +
        "       NVL(SUM(A.SRVFEE_CASH_IN), 0) SRVFEE_CASH_IN," +
        "       NVL(SUM(A.SRVFEE_CASH_OUT), 0) SRVFEE_CASH_OUT," +
        "       IP.LEASE_CASH," +
        "       IP.LEASE_INTEREST," +
        "       IP.LEASE_CORPUS," +
        "       A.COMMERCIAL_IRR," +
        "       A.VAT_IRR," +
        "       A.FINANCE_IRR," +
        "       A.RENT_IRR," +
        "       A.PROJECT_IRR," +
        "       A.PROJECT_NOTAX_IRR," +
        "       A.FEE_DISTR_IRR," +
        "       A.CONTRACT_IRR," +
        "       A.AUDIT_IRR," +
        "       A.LESSEE_IRR," +
        "       A.FINANCE_NOTAX_IRR," +
        "       " +
        "       /* [会计IRR算法调整] add wangjj 2016/10/28 */        " +
        "       A.FINANCE_IRR_METHOD,/*会计IRR按最新算法*/" +
        "       A.FINANCE_IRR_YEAR /*会计IRR启用年份*/" +
        "       /* [会计IRR算法调整] add wangjj 2016/10/28 end*/" +
        "       " +
        "  FROM VLC A" +
        "  LEFT JOIN YLS_LIMIT_PLAN LP" +
        "    ON LP.PK_LIMIT_PLAN = A.PK_LIMIT_PLAN" +
        "  LEFT JOIN VIP IP" +
        "    ON IP.PK_PROJECT_INFO = A.PK_PROJECT_INFO" +
        " GROUP BY A.PK_PROJECT_INFO," +
        "          A.QUOT_NAME," +
        "          A.QUOT_CODE," +
        "          LP.LIMIT_NAME," +
        "          A.LEASE_METHOD," +
        "          A.TAX_MODE," +
        "          A.LEASE_TIMES," +
        "          A.LEASE_FREQ," +
        "          A.LEASE_CAL_METHOD," +
        "          A.FINAL_RATE," +
        "          IP.LEASE_CASH," +
        "          IP.LEASE_INTEREST," +
        "          IP.LEASE_CORPUS," +
        "          A.COMMERCIAL_IRR," +
        "          A.VAT_IRR," +
        "          A.FINANCE_IRR," +
        "          A.RENT_IRR," +
        "          A.PROJECT_IRR," +
        "          A.PROJECT_NOTAX_IRR," +
        "          A.FEE_DISTR_IRR," +
        "          A.CONTRACT_IRR," +
        "          A.AUDIT_IRR," +
        "          A.LESSEE_IRR," +
        "          A.FINANCE_NOTAX_IRR," +
        "          /* [会计IRR算法调整] add wangjj 2016/10/28 */" +
        "          A.FINANCE_IRR_METHOD," +
        "          A.FINANCE_IRR_YEAR" +
        "          /* [会计IRR算法调整] add wangjj 2016/10/28 end */" +
        "        )")
public class ProjectCalculatorDTO extends BaseEntity {

    @Id
    public String pkProjectInfo;

    public String quotName;

    public String quotCode;

    /**
     * 限额方案
     */
    private String limitName;
    /**
     * 租赁方式
     */
    private Short leaseMethod;
    /**
     * 税种
     */
    private Short taxMode;
    /**
     * 租赁期限（月）
     */
    private Integer leaseTimes;
    /**
     * 支付频率
     */
    private Short leaseFreq;
    /**
     * 计算方式
     */
    private Short leaseCalMethod;
    /**
     * 报价利率
     */
    private BigDecimal finalRate;
    /**
     * 合同金额
     */
    private BigDecimal totalAmountEquipment;
    /**
     * 净融资额
     */
    private BigDecimal netFinanceCash;
    /**
     * 商业折扣
     */
    private BigDecimal tradeDiscount;
    /**
     * 计划投放金额
     */
    private BigDecimal planCashLoan;
    /**
     * 实际投放金额
     */
    private BigDecimal factCashLoan;
    /**
     * 首付款金额
     */
    private BigDecimal downPayment;
    /**
     * 保证金风险金金额
     */
    private BigDecimal depositCash;
    /**
     * 服务费收入金额
     */
    private BigDecimal srvfeeCashIn;
    /**
     * 服务费支出金额
     */
    private BigDecimal srvfeeCashOut;
    /**
     * 租金
     */
    private BigDecimal leaseCash;
    /**
     * 利息
     */
    private BigDecimal leaseInterest;
    /**
     * 本金
     */
    private BigDecimal leaseCorpus;
    /**
     * 市场IRR
     */
    private BigDecimal commercialIrr;
    /**
     * 增值税下IRR
     */
    private BigDecimal vatIrr;
    /**
     * 会计IRR
     */
    private BigDecimal financeIrr;
    /**
     * 租金IRR
     */
    private BigDecimal rentIrr;
    /**
     * 项目IRR
     */
    private BigDecimal projectIrr;
    /**
     * 项目去税IRR
     */
    private BigDecimal projectNotaxIrr;
    /**
     * 手续费分配IRR
     */
    private BigDecimal feeDistrIrr;
    /**
     * 租赁合同IRR
     */
    private BigDecimal contractIrr;
    /**
     * 审计IRR
     */
    private BigDecimal auditIrr;
    /**
     * 承租人IRR
     */
    private BigDecimal lesseeIrr;
    /**
     * 会计去税IRR
     */
    private BigDecimal financeNotaxIrr;


    //    public ProjectCalculatorRefVO(String pkProjectInfo, String quotName, String quotCode, String limitName, Short leaseMethod, Short taxMode, Integer leaseTimes, Short leaseFreq, Short leaseCalMethod, BigDecimal finalRate, BigDecimal totalAmountEquipment, BigDecimal netFinanceCash, BigDecimal tradeDiscount, BigDecimal planCashLoan, BigDecimal factCashLoan, BigDecimal downPayment, BigDecimal depositCash, BigDecimal srvfeeCashIn, BigDecimal srvfeeCashOut, BigDecimal leaseCash, BigDecimal leaseInterest, BigDecimal leaseCorpus, BigDecimal commercialIrr, BigDecimal vatIrr, BigDecimal financeIrr, BigDecimal rentIrr, BigDecimal projectIrr, BigDecimal projectNotaxIrr, BigDecimal feeDistrIrr, BigDecimal contractIrr, BigDecimal auditIrr, BigDecimal lesseeIrr, BigDecimal financeNotaxIrr) {
    //        this.pkProjectInfo = pkProjectInfo;
    //        this.quotName = quotName;
    //        this.quotCode = quotCode;
    //        this.limitName = limitName;
    //        this.leaseMethod = leaseMethod;
    //        this.taxMode = taxMode;
    //        this.leaseTimes = leaseTimes;
    //        this.leaseFreq = leaseFreq;
    //        this.leaseCalMethod = leaseCalMethod;
    //        this.finalRate = finalRate;
    //        this.totalAmountEquipment = totalAmountEquipment;
    //        this.netFinanceCash = netFinanceCash;
    //        this.tradeDiscount = tradeDiscount;
    //        this.planCashLoan = planCashLoan;
    //        this.factCashLoan = factCashLoan;
    //        this.downPayment = downPayment;
    //        this.depositCash = depositCash;
    //        this.srvfeeCashIn = srvfeeCashIn;
    //        this.srvfeeCashOut = srvfeeCashOut;
    //        this.leaseCash = leaseCash;
    //        this.leaseInterest = leaseInterest;
    //        this.leaseCorpus = leaseCorpus;
    //        this.commercialIrr = commercialIrr;
    //        this.vatIrr = vatIrr;
    //        this.financeIrr = financeIrr;
    //        this.rentIrr = rentIrr;
    //        this.projectIrr = projectIrr;
    //        this.projectNotaxIrr = projectNotaxIrr;
    //        this.feeDistrIrr = feeDistrIrr;
    //        this.contractIrr = contractIrr;
    //        this.auditIrr = auditIrr;
    //        this.lesseeIrr = lesseeIrr;
    //        this.financeNotaxIrr = financeNotaxIrr;
    //        this.setPk(pkProjectInfo);
    //        this.setName(quotName);
    //        this.setCode(quotCode);
    //    }


    public String getPkProjectInfo() {
        return pkProjectInfo;
    }

    public void setPkProjectInfo(String pkProjectInfo) {
        this.pkProjectInfo = pkProjectInfo;
    }

    public String getQuotName() {
        return quotName;
    }

    public void setQuotName(String quotName) {
        this.quotName = quotName;
    }

    public String getQuotCode() {
        return quotCode;
    }

    public void setQuotCode(String quotCode) {
        this.quotCode = quotCode;
    }

    public String getLimitName() {
        return limitName;
    }

    public void setLimitName(String limitName) {
        this.limitName = limitName;
    }

    public Short getLeaseMethod() {
        return leaseMethod;
    }

    public void setLeaseMethod(Short leaseMethod) {
        this.leaseMethod = leaseMethod;
    }

    public Short getTaxMode() {
        return taxMode;
    }

    public void setTaxMode(Short taxMode) {
        this.taxMode = taxMode;
    }

    public Integer getLeaseTimes() {
        return leaseTimes;
    }

    public void setLeaseTimes(Integer leaseTimes) {
        this.leaseTimes = leaseTimes;
    }

    public Short getLeaseFreq() {
        return leaseFreq;
    }

    public void setLeaseFreq(Short leaseFreq) {
        this.leaseFreq = leaseFreq;
    }

    public Short getLeaseCalMethod() {
        return leaseCalMethod;
    }

    public void setLeaseCalMethod(Short leaseCalMethod) {
        this.leaseCalMethod = leaseCalMethod;
    }

    public BigDecimal getFinalRate() {
        return finalRate;
    }

    public void setFinalRate(BigDecimal finalRate) {
        this.finalRate = finalRate;
    }

    public BigDecimal getTotalAmountEquipment() {
        return totalAmountEquipment;
    }

    public void setTotalAmountEquipment(BigDecimal totalAmountEquipment) {
        this.totalAmountEquipment = totalAmountEquipment;
    }

    public BigDecimal getNetFinanceCash() {
        return netFinanceCash;
    }

    public void setNetFinanceCash(BigDecimal netFinanceCash) {
        this.netFinanceCash = netFinanceCash;
    }

    public BigDecimal getTradeDiscount() {
        return tradeDiscount;
    }

    public void setTradeDiscount(BigDecimal tradeDiscount) {
        this.tradeDiscount = tradeDiscount;
    }

    public BigDecimal getPlanCashLoan() {
        return planCashLoan;
    }

    public void setPlanCashLoan(BigDecimal planCashLoan) {
        this.planCashLoan = planCashLoan;
    }

    public BigDecimal getFactCashLoan() {
        return factCashLoan;
    }

    public void setFactCashLoan(BigDecimal factCashLoan) {
        this.factCashLoan = factCashLoan;
    }

    public BigDecimal getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(BigDecimal downPayment) {
        this.downPayment = downPayment;
    }

    public BigDecimal getDepositCash() {
        return depositCash;
    }

    public void setDepositCash(BigDecimal depositCash) {
        this.depositCash = depositCash;
    }

    public BigDecimal getSrvfeeCashIn() {
        return srvfeeCashIn;
    }

    public void setSrvfeeCashIn(BigDecimal srvfeeCashIn) {
        this.srvfeeCashIn = srvfeeCashIn;
    }

    public BigDecimal getSrvfeeCashOut() {
        return srvfeeCashOut;
    }

    public void setSrvfeeCashOut(BigDecimal srvfeeCashOut) {
        this.srvfeeCashOut = srvfeeCashOut;
    }

    public BigDecimal getLeaseCash() {
        return leaseCash;
    }

    public void setLeaseCash(BigDecimal leaseCash) {
        this.leaseCash = leaseCash;
    }

    public BigDecimal getLeaseInterest() {
        return leaseInterest;
    }

    public void setLeaseInterest(BigDecimal leaseInterest) {
        this.leaseInterest = leaseInterest;
    }

    public BigDecimal getLeaseCorpus() {
        return leaseCorpus;
    }

    public void setLeaseCorpus(BigDecimal leaseCorpus) {
        this.leaseCorpus = leaseCorpus;
    }

    public BigDecimal getCommercialIrr() {
        return commercialIrr;
    }

    public void setCommercialIrr(BigDecimal commercialIrr) {
        this.commercialIrr = commercialIrr;
    }

    public BigDecimal getVatIrr() {
        return vatIrr;
    }

    public void setVatIrr(BigDecimal vatIrr) {
        this.vatIrr = vatIrr;
    }

    public BigDecimal getFinanceIrr() {
        return financeIrr;
    }

    public void setFinanceIrr(BigDecimal financeIrr) {
        this.financeIrr = financeIrr;
    }

    public BigDecimal getRentIrr() {
        return rentIrr;
    }

    public void setRentIrr(BigDecimal rentIrr) {
        this.rentIrr = rentIrr;
    }

    public BigDecimal getProjectIrr() {
        return projectIrr;
    }

    public void setProjectIrr(BigDecimal projectIrr) {
        this.projectIrr = projectIrr;
    }

    public BigDecimal getProjectNotaxIrr() {
        return projectNotaxIrr;
    }

    public void setProjectNotaxIrr(BigDecimal projectNotaxIrr) {
        this.projectNotaxIrr = projectNotaxIrr;
    }

    public BigDecimal getFeeDistrIrr() {
        return feeDistrIrr;
    }

    public void setFeeDistrIrr(BigDecimal feeDistrIrr) {
        this.feeDistrIrr = feeDistrIrr;
    }

    public BigDecimal getContractIrr() {
        return contractIrr;
    }

    public void setContractIrr(BigDecimal contractIrr) {
        this.contractIrr = contractIrr;
    }

    public BigDecimal getAuditIrr() {
        return auditIrr;
    }

    public void setAuditIrr(BigDecimal auditIrr) {
        this.auditIrr = auditIrr;
    }

    public BigDecimal getLesseeIrr() {
        return lesseeIrr;
    }

    public void setLesseeIrr(BigDecimal lesseeIrr) {
        this.lesseeIrr = lesseeIrr;
    }

    public BigDecimal getFinanceNotaxIrr() {
        return financeNotaxIrr;
    }

    public void setFinanceNotaxIrr(BigDecimal financeNotaxIrr) {
        this.financeNotaxIrr = financeNotaxIrr;
    }


    @Override
    public String getPk() {
        return null;
    }

    @Override
    public void setPk(String pk) {

    }
}
