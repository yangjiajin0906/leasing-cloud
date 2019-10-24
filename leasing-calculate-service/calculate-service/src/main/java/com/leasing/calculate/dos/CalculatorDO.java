package com.leasing.calculate.dos;

import com.leasing.common.base.entity.BaseBusinessDO;
import com.leasing.common.base.entity.BaseDO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/9/23
 * @author:Yjj@yonyou.com
 * @description: 报价VO
 **/

@Entity
@Table(name="yls_lease_calculator")
public class CalculatorDO extends BaseBusinessDO {
    /**
     * 主键
     */
    @Id
    public String pkLeaseCalculator;

    /**
     * 关联编号
     */
    public String pkInitial;


    /**
     * 测算方案编号
     */
    public String quotCode;


    /**
     * 测算方案名称
     */
    public String quotName;


    /**
     * 限额方案
     */
    public String pkLimitPlan;

    /**
     * 计息金额计算方式
     */
    public Short calinterestAmountStyle;


    /**
     * 投放日期
     */
    public String planDateLoan;

    /**
     * 实际投放日期，用于处理起租变更对于已付款的投放金额投放日期 null
     */
    @Transient
    public String factPlanDateLoan;

    /**
     * 币种
     */
    @Transient
    public String pkCurrtype;

    /**
     * 汇率
     */
    public BigDecimal pkExchgRate;


    /**
     * 起租日
     */
    public String leaseCommencementDate;


    /**
     * 租赁方式
     */
    public Short leaseMethod;


    /**
     * 设备总金额
     */
    public BigDecimal totalAmountEquipment;


    /**
     * 首付款比例
     */
    public BigDecimal downPaymentRatio;


    /**
     * 首付款金额
     */
    public BigDecimal downPayment;


    /**
     * 商业折扣
     */
    public BigDecimal tradeDiscount;


    /**
     * 计划投放金额
     */
    public BigDecimal planCashLoan;


    /**
     * 实际投放金额
     */
    public BigDecimal factCashLoan;


    /**
     * 名义货价（留购价）
     */
    public BigDecimal nominalPrice;


    /**
     * 资产余值
     */
    public BigDecimal assetsMargin;


    /**
     * 保证金比例
     */
    public BigDecimal depositRatio;


    /**
     * 保证金金额
     */
    public BigDecimal depositCash;


    /**
     * 保证金收取方式
     */
    public Short depositMethod;


    /**
     * 服务费收入方式
     */
    public Short srvfeeMethodIn;


    /**
     * 服务费收入基数
     */
    public Short srvfeeBase;


    /**
     * 服务费收入比例
     */
    public BigDecimal srvfeeRatioIn;


    /**
     * 每期服务费收入金额
     */
    public BigDecimal srvfeeCashInFt;


    /**
     * 服务费收入税率
     */
    public Short srvfeeTaxrateIn;


    /**
     * 服务费收入总金额
     */
    public BigDecimal srvfeeCashIn;


    /**
     * 服务费支出方式
     */
    public Short srvfeeMethodOut;


    /**
     * 服务费支出基数
     */
    @Transient
    public Short srvfeeBaseOut;


    /**
     * 服务费支出比例
     */
    public BigDecimal srvfeeRatioOut;

    /**
     * 每期服务费支出金额
     */
    public BigDecimal srvfeeCashOutFt;

    /**
     * 服务费支出总金额
     */
    public BigDecimal srvfeeCashOut;

    /**
     * 首期服务费支出时间
     */
    public String srvfeeDateOutFt;

    /**
     * 服务费支出税率
     */
    public Short srvfeeTaxrateOut;

    /**
     * 厂商保证金比例
     */
    public BigDecimal vendorDepositRatio;

    /**
     * 厂商保证金金额
     */
    public BigDecimal vendorDepositCash;

    /**
     * 净融资额
     */
    public BigDecimal netFinanceCash;

    /**
     * 净融资比例
     */
    public BigDecimal netFinanceRatio;


    /**
     * 是否作为标准模板
     */
    public Short if4basic;

    /**
     * 收税模式
     */
    public Short taxMode;

    /**
     * 备注
     */
    public String memo;

    /**
     * 计算比例基数(运行参数中取值) null
     */
    @Transient
    public Short calRatioBase;

    /**
     * 租金表类型
     */
    public Short rentTableType;


    /**
     * 补差利息处理方式
     */
    public Short reverseInterestMethod;


    /**
     * 延迟期（日）
     */
    public Integer delayPeriod;


    /**
     * 宽限期（月）
     */
    public Integer gracePeriod;


    /**
     * 特殊期类别
     */
    public Short specialType;

    /**
     * 远期支付期限
     */
    @Transient
    public Integer limitT;

    /**
     * 远期支付频率
     */
    public Short timePayPeriod;

    /**
     * 远期支付金额
     */
    public BigDecimal timePayCash;

    /**
     * 远期支付日期
     */
    public String timePayDate;

    /**
     * 远期是否收首付款
     */
    @Transient
    public Short ifDownPaymentT;

    /**
     * 在建期还本金额
     */
    @Transient
    public BigDecimal repaymentCorpusCashC;

    /**
     * 在建期期限
     */
    @Transient
    public Integer limitC;

    /**
     * 在建期支付频率
     */
    @Transient
    public Short leasePeriodC;

    /**
     * 在建期还本周期
     */
    @Transient
    public Short repaymentCorpusPeriodC;

    /**
     * 在建期利率档次
     */
    @Transient
    public Short interrateLevelC;

    /**
     * 在建期基准利率
     */
    @Transient
    public BigDecimal interrateC;

    /**
     * 在建期利率浮动值
     */
    @Transient
    public BigDecimal floatValueC;

    /**
     * 在建期利率
     */
    @Transient
    public BigDecimal finalRateC;

    /**
     * 在建期利率类型
     */
    @Transient
    public Short interrateTypeC;

    /**
     * 在建期利率浮动方式
     */
    @Transient
    public Short floatMethodC;

    /**
     * 在建期利率生效日期
     */
    @Transient
    public String pkInterrateC;

    /**
     * 建设期利息处理方式
     */
    @Transient
    public Short interestMethodC;

    /**
     * 预计转经营期日期
     */
    public String plan2operatingDate;

    /**
     * 计划收租日
     */
    public Short planLeaseDate;

    /**
     * 租赁期限（月）
     */
    public Integer leaseTimes;

    /**
     * 收租规则周期
     */
    public Short leasePeriodRule;

    /**
     * 特殊算法设置
     */
    public Short calMethodSpec;

    /**
     * 先付后付标志
     */
    public Short prepayOrNot;

    /**
     * 是否指定首期收租日
     */
    public Short hasFirstLeaseDate;

    /**
     * 首期收租日期
     */
    public String firstLeaseDate;

    /**
     * 项目预计到期日
     */
    public String finalDate;

    /**
     * 最后一期提前天数
     */
    public Integer lastTermDays;

    /**
     * 租金表调整对象
     */
    public Short leaseAdjustType;

    /**
     * 支付频率
     */
    public Short leaseFreq;

    /**
     * 计算方式
     */
    public Short leaseCalMethod;

    /**
     * 提前间隔（月）
     */
    public Integer intervalInAdvance;

    /**
     * 总投放金额的计息方式
     */
    public Short interestMethodTotalLoan;

    /**
     * 年计算天数
     */
    public Short yearDays;

    /**
     * IRR年计算天数
     */
    public Short yearDaysIrr;

    /**
     * 现金流年计算天数
     */
    public Short yearDaysFlow;

    /**
     * 计算精度
     */
    public Short calDigit;

    /**
     * 利率类型
     */
    public Short interrateType;

    /**
     * 固定利率（平息率）
     */
    public BigDecimal fixedInterrate;

    /**
     * 利率浮动方式
     */
    public Short floatMethod;

    /**
     * 利率生效日期
     */
    public String pkInterrate;

    /**
     * 利率档次
     */
    public Short interrateLevel;

    /**
     * 基准利率
     */
    public BigDecimal interrate;

    /**
     * 利率浮动值
     */
    public BigDecimal floatValue;

    /**
     * 租息年利率
     */
    public BigDecimal finalRate;

    /**
     * 保证金退回方式
     */
    public Short returnMethodDepos;

    /**
     * 保证金是否计息
     */
    public Short ifInterestDepos;

    /**
     * 保证金年利率类型
     */
    public Short interrateTypeDepos;

    /**
     * 保证金年利率档次
     */
    public Short interrateLevelDepos;

    /**
     * 保证金基准年利率
     */
    public BigDecimal interrateDepos;

    /**
     * 保证金浮动方式
     */
    public Short floatMethodDepos;

    /**
     * 保证金年利率生效日期
     */
    public String pkInterrateDepos;

    /**
     * 保证金浮动比例
     */
    public BigDecimal floatValueDepos;

    /**
     * 保证金利率
     */
    public BigDecimal finalRateDepos;

    /**
     * 保证金收取说明
     */
    public String memoDepos;

    /**
     * 利息计算方式
     */
    public Short interrestMethod;

    /**
     * 日复利每期所占比例
     */
    public BigDecimal radioHyear;

    /**
     * 最后一期计算规则
     */
    public Short lastTermRule;

    /**
     * 市场IRR
     */
    public BigDecimal commercialIrr;

    /**
     * 增值税下IRR
     */
    public BigDecimal vatIrr;

    /**
     * 会计IRR
     */
    public BigDecimal financeIrr;

    /**
     * 会计去税IRR
     */
    public BigDecimal financeNotaxIrr;

    /**
     * 租金IRR
     */
    public BigDecimal rentIrr;

    /**
     * 项目IRR
     */
    public BigDecimal projectIrr;

    /**
     * 项目去税IRR
     */
    public BigDecimal projectNotaxIrr;

    /**
     * add by jiaoshy 2017-10-09  咨询费合同
     */
    /**
     * 不含咨询费市场IRR
     */
    public BigDecimal projectIrrConsult;

    /**
     * 不含咨询费市场去税IRR
     */
    public BigDecimal projectNotaxIrrConsult;
    /* add end*/

    /**
     * 手续费分配IRR
     */
    public BigDecimal feeDistrIrr;

    /**
     * IRR倒算对象
     */
    @Transient
    public Short irrObject;

    /**
     * IRR倒算期望IRR
     */
    @Transient
    public BigDecimal expectNominalIrr;

    /**
     * 项目平息率
     */
    @Transient
    public BigDecimal projectAverageInterrate;

    /**
     * 本金是否开票
     */
    public Short ifCorpusTickets;

//    /**
//     * 单据状态
//     */
//    public Short billstatus;
//
//    /**
//     * 操作员主键
//     */
//    public String pkOperator;
//
//    /**
//     * 操作日期
//     */
//    public String operateDate;
//
//    /**
//     * 操作时间
//     */
//    public String operateTime;

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
     * 投放计划（子表）
     */
    @OneToMany(orphanRemoval=true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="sourceBill")
    public List<LeaseLoanPlanDO> leaseLoanPlan;

    /**
     * 规则设置（子表）
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, fetch = FetchType.LAZY)
    @JoinColumn(name="sourceBill")
    public List<LeaseRulePDO> leaseRule;

    /**
     * 收支计划（子表）市场  --存储
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, fetch = FetchType.LAZY)
    @JoinColumn(name="sourceBill")
    public List<InoutPlanPDO> inoutPlanMarket;


    @Transient
    public String irrParamVO;

    /**
     * 租赁合同IRR
     */
    public BigDecimal contractIrr;

    /**
     * 审计IRR
     */
    public BigDecimal auditIrr;

    /**
     * 承租人IRR
     */
    public BigDecimal lesseeIrr;

    /**
     * 首付款是否参与期次排序
     */
    @Transient
    public Short firstCashIfsort;

    /**
     * 来源单据主键
     */
    @Transient
    public String pkProjectInfo;

    /**
     * 合同信息
     */
    public String pkContract;

    /**
     * 客户实际期初金额
     */
    public BigDecimal factInitialCash;

    /**
     * 客户实际期初金额占比
     */
    @Transient
    public BigDecimal factInitialAtio;

    /**
     * 租金合计值
     */
    public BigDecimal leaseCashSum;

    /**
     * 利息合计值
     */
    public BigDecimal leaseInterestSum;

    /**
     * 测算方案状态
     */
    public Short quotStatus;

    /**
     * 是否不规则测算
     */
    @Transient
    public Boolean ifIrregularCal;

    /**
     * 报价有效期
     */
    public Integer quotValid;

    /**
     * 报价有效开始日期
     */
    public String quotStartDate;

    /**
     * 报价有效截止日期
     */
    public String quotEndDate;

    /**
     * 年还款次数
     */
    public Integer yearTimes;
    /**
     * 是否被合同引用
     */
    public Short ifContQuote;
    /**
     * 数据来源单据主键
     */
    public String dataSourceBill;
    /**
     * 数据来源单据类型
     */
    public String dataSourceBilltype;

    /**
     * 佣金收入
     */
    public BigDecimal brokerageIn;

    /**
     * 报价客户
     */
    public String pkCustomer;

    /**
     * 年化利率方式
     */
    public Short annualizedRateMethod;

    /**
     * 年化利率
     */
    public BigDecimal annualizedRate;

    /**
     * 其他担保方式
     */
    public String otherAssureMethod;

    /**
     * 风险金起始收取日期
     */
    public String depositStartDate;

    /**
     * 保证金利息
     */
    public BigDecimal depositInterest;

    /**
     * 特殊期限
     */
    public Integer specialLimit;

    /**
     * 特殊期利息支付频率
     */
    public Short repaymentInterestPeriod;

    /**
     * 特殊期还本频率
     */
    public Short repaymentCorpusPeriod;

    /**
     * 特殊期还本金额
     */
    public BigDecimal repaymentCorpusCash;

    /**
     * 特殊期利率
     */
    public BigDecimal specialFinalRate;

    /**
     * 特殊期利率档次
     */
    public Short specialInterrateLevel;

    /**
     * 特殊期基准利率
     */
    public BigDecimal specialInterrate;

    /**
     * 特殊期利率类型
     */
    public Short specialInterrateType;

    /**
     * 特殊期利率浮动方式
     */
    public Short specialFloatMethod;

    /**
     * 特殊期利率浮动值
     */
    public BigDecimal specialFloatValue;

    /**
     * 特殊期利率生效日期
     */
    public String pkSpecialInterrate;

    /**
     * 客户实际期初金额占比
     */
    public BigDecimal factInitialRatio;


    /**
     * 算法版本 参照 PubEnumsConstant.cal_merge_event等
     */
    @Transient
    public Short calVersion;

    /**
     * 会计IRR按最新算法
     */
    //@Transient
    public Short financeIrrMethod;

    //by lihongjian @2016/04/25 ADD START 营改增  租赁税率
    //改为枚举类型
    public Short rentTaxRate;

    /**
     * 是否固定收租日
     */
    @Transient
    public Short ifFixday;

    /**
     * 固定收租日规则
     */
    @Transient
    public String pkFixedChose;

    /**
     * 报价类型(0：租赁；1：保理)
     */
    public Short calType;

    public CalculatorDO() {
    }

    public String getPkLeaseCalculator() {
        return pkLeaseCalculator;
    }

    public void setPkLeaseCalculator(String pkLeaseCalculator) {
        this.pkLeaseCalculator = pkLeaseCalculator;
    }

    public String getPkInitial() {
        return pkInitial;
    }

    public void setPkInitial(String pkInitial) {
        this.pkInitial = pkInitial;
    }

    public String getQuotCode() {
        return quotCode;
    }

    public void setQuotCode(String quotCode) {
        this.quotCode = quotCode;
    }

    public String getQuotName() {
        return quotName;
    }

    public void setQuotName(String quotName) {
        this.quotName = quotName;
    }

    public String getPkLimitPlan() {
        return pkLimitPlan;
    }

    public void setPkLimitPlan(String pkLimitPlan) {
        this.pkLimitPlan = pkLimitPlan;
    }

    public Short getCalinterestAmountStyle() {
        return calinterestAmountStyle;
    }

    public void setCalinterestAmountStyle(Short calinterestAmountStyle) {
        this.calinterestAmountStyle = calinterestAmountStyle;
    }

    public String getPlanDateLoan() {
        return planDateLoan;
    }

    public void setPlanDateLoan(String planDateLoan) {
        this.planDateLoan = planDateLoan;
    }

    public String getFactPlanDateLoan() {
        return factPlanDateLoan;
    }

    public void setFactPlanDateLoan(String factPlanDateLoan) {
        this.factPlanDateLoan = factPlanDateLoan;
    }

    public String getPkCurrtype() {
        return pkCurrtype;
    }

    public void setPkCurrtype(String pkCurrtype) {
        this.pkCurrtype = pkCurrtype;
    }

    public BigDecimal getPkExchgRate() {
        return pkExchgRate;
    }

    public void setPkExchgRate(BigDecimal pkExchgRate) {
        this.pkExchgRate = pkExchgRate;
    }

    public String getLeaseCommencementDate() {
        return leaseCommencementDate;
    }

    public void setLeaseCommencementDate(String leaseCommencementDate) {
        this.leaseCommencementDate = leaseCommencementDate;
    }

    public Short getLeaseMethod() {
        return leaseMethod;
    }

    public void setLeaseMethod(Short leaseMethod) {
        this.leaseMethod = leaseMethod;
    }

    public BigDecimal getTotalAmountEquipment() {
        return totalAmountEquipment;
    }

    public void setTotalAmountEquipment(BigDecimal totalAmountEquipment) {
        this.totalAmountEquipment = totalAmountEquipment;
    }

    public BigDecimal getDownPaymentRatio() {
        return downPaymentRatio;
    }

    public void setDownPaymentRatio(BigDecimal downPaymentRatio) {
        this.downPaymentRatio = downPaymentRatio;
    }

    public BigDecimal getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(BigDecimal downPayment) {
        this.downPayment = downPayment;
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

    public BigDecimal getNominalPrice() {
        return nominalPrice;
    }

    public void setNominalPrice(BigDecimal nominalPrice) {
        this.nominalPrice = nominalPrice;
    }

    public BigDecimal getAssetsMargin() {
        return assetsMargin;
    }

    public void setAssetsMargin(BigDecimal assetsMargin) {
        this.assetsMargin = assetsMargin;
    }

    public BigDecimal getDepositRatio() {
        return depositRatio;
    }

    public void setDepositRatio(BigDecimal depositRatio) {
        this.depositRatio = depositRatio;
    }

    public BigDecimal getDepositCash() {
        return depositCash;
    }

    public void setDepositCash(BigDecimal depositCash) {
        this.depositCash = depositCash;
    }

    public Short getDepositMethod() {
        return depositMethod;
    }

    public void setDepositMethod(Short depositMethod) {
        this.depositMethod = depositMethod;
    }

    public Short getSrvfeeMethodIn() {
        return srvfeeMethodIn;
    }

    public void setSrvfeeMethodIn(Short srvfeeMethodIn) {
        this.srvfeeMethodIn = srvfeeMethodIn;
    }

    public Short getSrvfeeBase() {
        return srvfeeBase;
    }

    public void setSrvfeeBase(Short srvfeeBase) {
        this.srvfeeBase = srvfeeBase;
    }

    public BigDecimal getSrvfeeRatioIn() {
        return srvfeeRatioIn;
    }

    public void setSrvfeeRatioIn(BigDecimal srvfeeRatioIn) {
        this.srvfeeRatioIn = srvfeeRatioIn;
    }

    public BigDecimal getSrvfeeCashInFt() {
        return srvfeeCashInFt;
    }

    public void setSrvfeeCashInFt(BigDecimal srvfeeCashInFt) {
        this.srvfeeCashInFt = srvfeeCashInFt;
    }

    public Short getSrvfeeTaxrateIn() {
        return srvfeeTaxrateIn;
    }

    public void setSrvfeeTaxrateIn(Short srvfeeTaxrateIn) {
        this.srvfeeTaxrateIn = srvfeeTaxrateIn;
    }

    public BigDecimal getSrvfeeCashIn() {
        return srvfeeCashIn;
    }

    public void setSrvfeeCashIn(BigDecimal srvfeeCashIn) {
        this.srvfeeCashIn = srvfeeCashIn;
    }

    public Short getSrvfeeMethodOut() {
        return srvfeeMethodOut;
    }

    public void setSrvfeeMethodOut(Short srvfeeMethodOut) {
        this.srvfeeMethodOut = srvfeeMethodOut;
    }

    public Short getSrvfeeBaseOut() {
        return srvfeeBaseOut;
    }

    public void setSrvfeeBaseOut(Short srvfeeBaseOut) {
        this.srvfeeBaseOut = srvfeeBaseOut;
    }

    public BigDecimal getSrvfeeRatioOut() {
        return srvfeeRatioOut;
    }

    public void setSrvfeeRatioOut(BigDecimal srvfeeRatioOut) {
        this.srvfeeRatioOut = srvfeeRatioOut;
    }

    public BigDecimal getSrvfeeCashOutFt() {
        return srvfeeCashOutFt;
    }

    public void setSrvfeeCashOutFt(BigDecimal srvfeeCashOutFt) {
        this.srvfeeCashOutFt = srvfeeCashOutFt;
    }

    public BigDecimal getSrvfeeCashOut() {
        return srvfeeCashOut;
    }

    public void setSrvfeeCashOut(BigDecimal srvfeeCashOut) {
        this.srvfeeCashOut = srvfeeCashOut;
    }

    public String getSrvfeeDateOutFt() {
        return srvfeeDateOutFt;
    }

    public void setSrvfeeDateOutFt(String srvfeeDateOutFt) {
        this.srvfeeDateOutFt = srvfeeDateOutFt;
    }

    public Short getSrvfeeTaxrateOut() {
        return srvfeeTaxrateOut;
    }

    public void setSrvfeeTaxrateOut(Short srvfeeTaxrateOut) {
        this.srvfeeTaxrateOut = srvfeeTaxrateOut;
    }

    public BigDecimal getVendorDepositRatio() {
        return vendorDepositRatio;
    }

    public void setVendorDepositRatio(BigDecimal vendorDepositRatio) {
        this.vendorDepositRatio = vendorDepositRatio;
    }

    public BigDecimal getVendorDepositCash() {
        return vendorDepositCash;
    }

    public void setVendorDepositCash(BigDecimal vendorDepositCash) {
        this.vendorDepositCash = vendorDepositCash;
    }

    public BigDecimal getNetFinanceCash() {
        return netFinanceCash;
    }

    public void setNetFinanceCash(BigDecimal netFinanceCash) {
        this.netFinanceCash = netFinanceCash;
    }

    public BigDecimal getNetFinanceRatio() {
        return netFinanceRatio;
    }

    public void setNetFinanceRatio(BigDecimal netFinanceRatio) {
        this.netFinanceRatio = netFinanceRatio;
    }

    public Short getIf4basic() {
        return if4basic;
    }

    public void setIf4basic(Short if4basic) {
        this.if4basic = if4basic;
    }

    public Short getTaxMode() {
        return taxMode;
    }

    public void setTaxMode(Short taxMode) {
        this.taxMode = taxMode;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Short getCalRatioBase() {
        return calRatioBase;
    }

    public void setCalRatioBase(Short calRatioBase) {
        this.calRatioBase = calRatioBase;
    }

    public Short getRentTableType() {
        return rentTableType;
    }

    public void setRentTableType(Short rentTableType) {
        this.rentTableType = rentTableType;
    }

    public Short getReverseInterestMethod() {
        return reverseInterestMethod;
    }

    public void setReverseInterestMethod(Short reverseInterestMethod) {
        this.reverseInterestMethod = reverseInterestMethod;
    }

    public Integer getDelayPeriod() {
        return delayPeriod;
    }

    public void setDelayPeriod(Integer delayPeriod) {
        this.delayPeriod = delayPeriod;
    }

    public Integer getGracePeriod() {
        return gracePeriod;
    }

    public void setGracePeriod(Integer gracePeriod) {
        this.gracePeriod = gracePeriod;
    }

    public Short getSpecialType() {
        return specialType;
    }

    public void setSpecialType(Short specialType) {
        this.specialType = specialType;
    }

    public Integer getLimitT() {
        return limitT;
    }

    public void setLimitT(Integer limitT) {
        this.limitT = limitT;
    }

    public Short getTimePayPeriod() {
        return timePayPeriod;
    }

    public void setTimePayPeriod(Short timePayPeriod) {
        this.timePayPeriod = timePayPeriod;
    }

    public BigDecimal getTimePayCash() {
        return timePayCash;
    }

    public void setTimePayCash(BigDecimal timePayCash) {
        this.timePayCash = timePayCash;
    }

    public String getTimePayDate() {
        return timePayDate;
    }

    public void setTimePayDate(String timePayDate) {
        this.timePayDate = timePayDate;
    }

    public Short getIfDownPaymentT() {
        return ifDownPaymentT;
    }

    public void setIfDownPaymentT(Short ifDownPaymentT) {
        this.ifDownPaymentT = ifDownPaymentT;
    }

    public BigDecimal getRepaymentCorpusCashC() {
        return repaymentCorpusCashC;
    }

    public void setRepaymentCorpusCashC(BigDecimal repaymentCorpusCashC) {
        this.repaymentCorpusCashC = repaymentCorpusCashC;
    }

    public Integer getLimitC() {
        return limitC;
    }

    public void setLimitC(Integer limitC) {
        this.limitC = limitC;
    }

    public Short getLeasePeriodC() {
        return leasePeriodC;
    }

    public void setLeasePeriodC(Short leasePeriodC) {
        this.leasePeriodC = leasePeriodC;
    }

    public Short getRepaymentCorpusPeriodC() {
        return repaymentCorpusPeriodC;
    }

    public void setRepaymentCorpusPeriodC(Short repaymentCorpusPeriodC) {
        this.repaymentCorpusPeriodC = repaymentCorpusPeriodC;
    }

    public Short getInterrateLevelC() {
        return interrateLevelC;
    }

    public void setInterrateLevelC(Short interrateLevelC) {
        this.interrateLevelC = interrateLevelC;
    }

    public BigDecimal getInterrateC() {
        return interrateC;
    }

    public void setInterrateC(BigDecimal interrateC) {
        this.interrateC = interrateC;
    }

    public BigDecimal getFloatValueC() {
        return floatValueC;
    }

    public void setFloatValueC(BigDecimal floatValueC) {
        this.floatValueC = floatValueC;
    }

    public BigDecimal getFinalRateC() {
        return finalRateC;
    }

    public void setFinalRateC(BigDecimal finalRateC) {
        this.finalRateC = finalRateC;
    }

    public Short getInterrateTypeC() {
        return interrateTypeC;
    }

    public void setInterrateTypeC(Short interrateTypeC) {
        this.interrateTypeC = interrateTypeC;
    }

    public Short getFloatMethodC() {
        return floatMethodC;
    }

    public void setFloatMethodC(Short floatMethodC) {
        this.floatMethodC = floatMethodC;
    }

    public String getPkInterrateC() {
        return pkInterrateC;
    }

    public void setPkInterrateC(String pkInterrateC) {
        this.pkInterrateC = pkInterrateC;
    }

    public Short getInterestMethodC() {
        return interestMethodC;
    }

    public void setInterestMethodC(Short interestMethodC) {
        this.interestMethodC = interestMethodC;
    }

    public String getPlan2operatingDate() {
        return plan2operatingDate;
    }

    public void setPlan2operatingDate(String plan2operatingDate) {
        this.plan2operatingDate = plan2operatingDate;
    }

    public Short getPlanLeaseDate() {
        return planLeaseDate;
    }

    public void setPlanLeaseDate(Short planLeaseDate) {
        this.planLeaseDate = planLeaseDate;
    }

    public Integer getLeaseTimes() {
        return leaseTimes;
    }

    public void setLeaseTimes(Integer leaseTimes) {
        this.leaseTimes = leaseTimes;
    }

    public Short getLeasePeriodRule() {
        return leasePeriodRule;
    }

    public void setLeasePeriodRule(Short leasePeriodRule) {
        this.leasePeriodRule = leasePeriodRule;
    }

    public Short getCalMethodSpec() {
        return calMethodSpec;
    }

    public void setCalMethodSpec(Short calMethodSpec) {
        this.calMethodSpec = calMethodSpec;
    }

    public Short getPrepayOrNot() {
        return prepayOrNot;
    }

    public void setPrepayOrNot(Short prepayOrNot) {
        this.prepayOrNot = prepayOrNot;
    }

    public Short getHasFirstLeaseDate() {
        return hasFirstLeaseDate;
    }

    public void setHasFirstLeaseDate(Short hasFirstLeaseDate) {
        this.hasFirstLeaseDate = hasFirstLeaseDate;
    }

    public String getFirstLeaseDate() {
        return firstLeaseDate;
    }

    public void setFirstLeaseDate(String firstLeaseDate) {
        this.firstLeaseDate = firstLeaseDate;
    }

    public String getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(String finalDate) {
        this.finalDate = finalDate;
    }

    public Integer getLastTermDays() {
        return lastTermDays;
    }

    public void setLastTermDays(Integer lastTermDays) {
        this.lastTermDays = lastTermDays;
    }

    public Short getLeaseAdjustType() {
        return leaseAdjustType;
    }

    public void setLeaseAdjustType(Short leaseAdjustType) {
        this.leaseAdjustType = leaseAdjustType;
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

    public Integer getIntervalInAdvance() {
        return intervalInAdvance;
    }

    public void setIntervalInAdvance(Integer intervalInAdvance) {
        this.intervalInAdvance = intervalInAdvance;
    }

    public Short getInterestMethodTotalLoan() {
        return interestMethodTotalLoan;
    }

    public void setInterestMethodTotalLoan(Short interestMethodTotalLoan) {
        this.interestMethodTotalLoan = interestMethodTotalLoan;
    }

    public Short getYearDays() {
        return yearDays;
    }

    public void setYearDays(Short yearDays) {
        this.yearDays = yearDays;
    }

    public Short getYearDaysIrr() {
        return yearDaysIrr;
    }

    public void setYearDaysIrr(Short yearDaysIrr) {
        this.yearDaysIrr = yearDaysIrr;
    }

    public Short getYearDaysFlow() {
        return yearDaysFlow;
    }

    public void setYearDaysFlow(Short yearDaysFlow) {
        this.yearDaysFlow = yearDaysFlow;
    }

    public Short getCalDigit() {
        return calDigit;
    }

    public void setCalDigit(Short calDigit) {
        this.calDigit = calDigit;
    }

    public Short getInterrateType() {
        return interrateType;
    }

    public void setInterrateType(Short interrateType) {
        this.interrateType = interrateType;
    }

    public BigDecimal getFixedInterrate() {
        return fixedInterrate;
    }

    public void setFixedInterrate(BigDecimal fixedInterrate) {
        this.fixedInterrate = fixedInterrate;
    }

    public Short getFloatMethod() {
        return floatMethod;
    }

    public void setFloatMethod(Short floatMethod) {
        this.floatMethod = floatMethod;
    }

    public String getPkInterrate() {
        return pkInterrate;
    }

    public void setPkInterrate(String pkInterrate) {
        this.pkInterrate = pkInterrate;
    }

    public Short getInterrateLevel() {
        return interrateLevel;
    }

    public void setInterrateLevel(Short interrateLevel) {
        this.interrateLevel = interrateLevel;
    }

    public BigDecimal getInterrate() {
        return interrate;
    }

    public void setInterrate(BigDecimal interrate) {
        this.interrate = interrate;
    }

    public BigDecimal getFloatValue() {
        return floatValue;
    }

    public void setFloatValue(BigDecimal floatValue) {
        this.floatValue = floatValue;
    }

    public BigDecimal getFinalRate() {
        return finalRate;
    }

    public void setFinalRate(BigDecimal finalRate) {
        this.finalRate = finalRate;
    }

    public Short getReturnMethodDepos() {
        return returnMethodDepos;
    }

    public void setReturnMethodDepos(Short returnMethodDepos) {
        this.returnMethodDepos = returnMethodDepos;
    }

    public Short getIfInterestDepos() {
        return ifInterestDepos;
    }

    public void setIfInterestDepos(Short ifInterestDepos) {
        this.ifInterestDepos = ifInterestDepos;
    }

    public Short getInterrateTypeDepos() {
        return interrateTypeDepos;
    }

    public void setInterrateTypeDepos(Short interrateTypeDepos) {
        this.interrateTypeDepos = interrateTypeDepos;
    }

    public Short getInterrateLevelDepos() {
        return interrateLevelDepos;
    }

    public void setInterrateLevelDepos(Short interrateLevelDepos) {
        this.interrateLevelDepos = interrateLevelDepos;
    }

    public BigDecimal getInterrateDepos() {
        return interrateDepos;
    }

    public void setInterrateDepos(BigDecimal interrateDepos) {
        this.interrateDepos = interrateDepos;
    }

    public Short getFloatMethodDepos() {
        return floatMethodDepos;
    }

    public void setFloatMethodDepos(Short floatMethodDepos) {
        this.floatMethodDepos = floatMethodDepos;
    }

    public String getPkInterrateDepos() {
        return pkInterrateDepos;
    }

    public void setPkInterrateDepos(String pkInterrateDepos) {
        this.pkInterrateDepos = pkInterrateDepos;
    }

    public BigDecimal getFloatValueDepos() {
        return floatValueDepos;
    }

    public void setFloatValueDepos(BigDecimal floatValueDepos) {
        this.floatValueDepos = floatValueDepos;
    }

    public BigDecimal getFinalRateDepos() {
        return finalRateDepos;
    }

    public void setFinalRateDepos(BigDecimal finalRateDepos) {
        this.finalRateDepos = finalRateDepos;
    }

    public String getMemoDepos() {
        return memoDepos;
    }

    public void setMemoDepos(String memoDepos) {
        this.memoDepos = memoDepos;
    }

    public Short getInterrestMethod() {
        return interrestMethod;
    }

    public void setInterrestMethod(Short interrestMethod) {
        this.interrestMethod = interrestMethod;
    }

    public BigDecimal getRadioHyear() {
        return radioHyear;
    }

    public void setRadioHyear(BigDecimal radioHyear) {
        this.radioHyear = radioHyear;
    }

    public Short getLastTermRule() {
        return lastTermRule;
    }

    public void setLastTermRule(Short lastTermRule) {
        this.lastTermRule = lastTermRule;
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

    public BigDecimal getFinanceNotaxIrr() {
        return financeNotaxIrr;
    }

    public void setFinanceNotaxIrr(BigDecimal financeNotaxIrr) {
        this.financeNotaxIrr = financeNotaxIrr;
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

    public BigDecimal getProjectIrrConsult() {
        return projectIrrConsult;
    }

    public void setProjectIrrConsult(BigDecimal projectIrrConsult) {
        this.projectIrrConsult = projectIrrConsult;
    }

    public BigDecimal getProjectNotaxIrrConsult() {
        return projectNotaxIrrConsult;
    }

    public void setProjectNotaxIrrConsult(BigDecimal projectNotaxIrrConsult) {
        this.projectNotaxIrrConsult = projectNotaxIrrConsult;
    }

    public BigDecimal getFeeDistrIrr() {
        return feeDistrIrr;
    }

    public void setFeeDistrIrr(BigDecimal feeDistrIrr) {
        this.feeDistrIrr = feeDistrIrr;
    }

    public Short getIrrObject() {
        return irrObject;
    }

    public void setIrrObject(Short irrObject) {
        this.irrObject = irrObject;
    }

    public BigDecimal getExpectNominalIrr() {
        return expectNominalIrr;
    }

    public void setExpectNominalIrr(BigDecimal expectNominalIrr) {
        this.expectNominalIrr = expectNominalIrr;
    }

    public BigDecimal getProjectAverageInterrate() {
        return projectAverageInterrate;
    }

    public void setProjectAverageInterrate(BigDecimal projectAverageInterrate) {
        this.projectAverageInterrate = projectAverageInterrate;
    }

    public Short getIfCorpusTickets() {
        return ifCorpusTickets;
    }

    public void setIfCorpusTickets(Short ifCorpusTickets) {
        this.ifCorpusTickets = ifCorpusTickets;
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

    public List<LeaseLoanPlanDO> getLeaseLoanPlan() {
        return leaseLoanPlan;
    }

    public void setLeaseLoanPlan(List<LeaseLoanPlanDO> leaseLoanPlan) {
        this.leaseLoanPlan = leaseLoanPlan;
    }

    public List<LeaseRulePDO> getLeaseRule() {
        return leaseRule;
    }

    public void setLeaseRule(List<LeaseRulePDO> leaseRule) {
        this.leaseRule = leaseRule;
    }


    public String getIrrParamVO() {
        return irrParamVO;
    }

    public void setIrrParamVO(String irrParamVO) {
        this.irrParamVO = irrParamVO;
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

    public Short getFirstCashIfsort() {
        return firstCashIfsort;
    }

    public void setFirstCashIfsort(Short firstCashIfsort) {
        this.firstCashIfsort = firstCashIfsort;
    }

    public String getPkProjectInfo() {
        return pkProjectInfo;
    }

    public void setPkProjectInfo(String pkProjectInfo) {
        this.pkProjectInfo = pkProjectInfo;
    }

    public String getPkContract() {
        return pkContract;
    }

    public void setPkContract(String pkContract) {
        this.pkContract = pkContract;
    }

    public BigDecimal getFactInitialCash() {
        return factInitialCash;
    }

    public void setFactInitialCash(BigDecimal factInitialCash) {
        this.factInitialCash = factInitialCash;
    }

    public BigDecimal getFactInitialAtio() {
        return factInitialAtio;
    }

    public void setFactInitialAtio(BigDecimal factInitialAtio) {
        this.factInitialAtio = factInitialAtio;
    }

    public BigDecimal getLeaseCashSum() {
        return leaseCashSum;
    }

    public void setLeaseCashSum(BigDecimal leaseCashSum) {
        this.leaseCashSum = leaseCashSum;
    }

    public BigDecimal getLeaseInterestSum() {
        return leaseInterestSum;
    }

    public void setLeaseInterestSum(BigDecimal leaseInterestSum) {
        this.leaseInterestSum = leaseInterestSum;
    }

    public Short getQuotStatus() {
        return quotStatus;
    }

    public void setQuotStatus(Short quotStatus) {
        this.quotStatus = quotStatus;
    }

    public Boolean getIfIrregularCal() {
        return ifIrregularCal;
    }

    public void setIfIrregularCal(Boolean ifIrregularCal) {
        this.ifIrregularCal = ifIrregularCal;
    }

    public Integer getQuotValid() {
        return quotValid;
    }

    public void setQuotValid(Integer quotValid) {
        this.quotValid = quotValid;
    }

    public String getQuotStartDate() {
        return quotStartDate;
    }

    public void setQuotStartDate(String quotStartDate) {
        this.quotStartDate = quotStartDate;
    }

    public String getQuotEndDate() {
        return quotEndDate;
    }

    public void setQuotEndDate(String quotEndDate) {
        this.quotEndDate = quotEndDate;
    }

    public Integer getYearTimes() {
        return yearTimes;
    }

    public void setYearTimes(Integer yearTimes) {
        this.yearTimes = yearTimes;
    }

    public Short getIfContQuote() {
        return ifContQuote;
    }

    public void setIfContQuote(Short ifContQuote) {
        this.ifContQuote = ifContQuote;
    }

    public String getDataSourceBill() {
        return dataSourceBill;
    }

    public void setDataSourceBill(String dataSourceBill) {
        this.dataSourceBill = dataSourceBill;
    }

    public String getDataSourceBilltype() {
        return dataSourceBilltype;
    }

    public void setDataSourceBilltype(String dataSourceBilltype) {
        this.dataSourceBilltype = dataSourceBilltype;
    }

    public BigDecimal getBrokerageIn() {
        return brokerageIn;
    }

    public void setBrokerageIn(BigDecimal brokerageIn) {
        this.brokerageIn = brokerageIn;
    }

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public Short getAnnualizedRateMethod() {
        return annualizedRateMethod;
    }

    public void setAnnualizedRateMethod(Short annualizedRateMethod) {
        this.annualizedRateMethod = annualizedRateMethod;
    }

    public BigDecimal getAnnualizedRate() {
        return annualizedRate;
    }

    public void setAnnualizedRate(BigDecimal annualizedRate) {
        this.annualizedRate = annualizedRate;
    }

    public String getOtherAssureMethod() {
        return otherAssureMethod;
    }

    public void setOtherAssureMethod(String otherAssureMethod) {
        this.otherAssureMethod = otherAssureMethod;
    }

    public String getDepositStartDate() {
        return depositStartDate;
    }

    public void setDepositStartDate(String depositStartDate) {
        this.depositStartDate = depositStartDate;
    }

    public BigDecimal getDepositInterest() {
        return depositInterest;
    }

    public void setDepositInterest(BigDecimal depositInterest) {
        this.depositInterest = depositInterest;
    }

    public Integer getSpecialLimit() {
        return specialLimit;
    }

    public void setSpecialLimit(Integer specialLimit) {
        this.specialLimit = specialLimit;
    }

    public Short getRepaymentInterestPeriod() {
        return repaymentInterestPeriod;
    }

    public void setRepaymentInterestPeriod(Short repaymentInterestPeriod) {
        this.repaymentInterestPeriod = repaymentInterestPeriod;
    }

    public Short getRepaymentCorpusPeriod() {
        return repaymentCorpusPeriod;
    }

    public void setRepaymentCorpusPeriod(Short repaymentCorpusPeriod) {
        this.repaymentCorpusPeriod = repaymentCorpusPeriod;
    }

    public BigDecimal getRepaymentCorpusCash() {
        return repaymentCorpusCash;
    }

    public void setRepaymentCorpusCash(BigDecimal repaymentCorpusCash) {
        this.repaymentCorpusCash = repaymentCorpusCash;
    }

    public BigDecimal getSpecialFinalRate() {
        return specialFinalRate;
    }

    public void setSpecialFinalRate(BigDecimal specialFinalRate) {
        this.specialFinalRate = specialFinalRate;
    }

    public Short getSpecialInterrateLevel() {
        return specialInterrateLevel;
    }

    public void setSpecialInterrateLevel(Short specialInterrateLevel) {
        this.specialInterrateLevel = specialInterrateLevel;
    }

    public BigDecimal getSpecialInterrate() {
        return specialInterrate;
    }

    public void setSpecialInterrate(BigDecimal specialInterrate) {
        this.specialInterrate = specialInterrate;
    }

    public Short getSpecialInterrateType() {
        return specialInterrateType;
    }

    public void setSpecialInterrateType(Short specialInterrateType) {
        this.specialInterrateType = specialInterrateType;
    }

    public Short getSpecialFloatMethod() {
        return specialFloatMethod;
    }

    public void setSpecialFloatMethod(Short specialFloatMethod) {
        this.specialFloatMethod = specialFloatMethod;
    }

    public BigDecimal getSpecialFloatValue() {
        return specialFloatValue;
    }

    public void setSpecialFloatValue(BigDecimal specialFloatValue) {
        this.specialFloatValue = specialFloatValue;
    }

    public String getPkSpecialInterrate() {
        return pkSpecialInterrate;
    }

    public void setPkSpecialInterrate(String pkSpecialInterrate) {
        this.pkSpecialInterrate = pkSpecialInterrate;
    }

    public BigDecimal getFactInitialRatio() {
        return factInitialRatio;
    }

    public void setFactInitialRatio(BigDecimal factInitialRatio) {
        this.factInitialRatio = factInitialRatio;
    }

    public Short getCalVersion() {
        return calVersion;
    }

    public void setCalVersion(Short calVersion) {
        this.calVersion = calVersion;
    }

    public Short getFinanceIrrMethod() {
        return financeIrrMethod;
    }

    public void setFinanceIrrMethod(Short financeIrrMethod) {
        this.financeIrrMethod = financeIrrMethod;
    }

    public Short getRentTaxRate() {
        return rentTaxRate;
    }

    public void setRentTaxRate(Short rentTaxRate) {
        this.rentTaxRate = rentTaxRate;
    }

    public Short getIfFixday() {
        return ifFixday;
    }

    public void setIfFixday(Short ifFixday) {
        this.ifFixday = ifFixday;
    }

    public String getPkFixedChose() {
        return pkFixedChose;
    }

    public void setPkFixedChose(String pkFixedChose) {
        this.pkFixedChose = pkFixedChose;
    }

    public Short getCalType() {
        return calType;
    }

    public void setCalType(Short calType) {
        this.calType = calType;
    }

    public List<InoutPlanPDO> getInoutPlanMarket() {
        return inoutPlanMarket;
    }

    public void setInoutPlanMarket(List<InoutPlanPDO> inoutPlanMarket) {
        this.inoutPlanMarket = inoutPlanMarket;
    }

    @Override
    public String getPk() {
        return pkLeaseCalculator;
    }

    @Override
    public void setPk(String pk) {
        this.pkLeaseCalculator = pk;
    }
}