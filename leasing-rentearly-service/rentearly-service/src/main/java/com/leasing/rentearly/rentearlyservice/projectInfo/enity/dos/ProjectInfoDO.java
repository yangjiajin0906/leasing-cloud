package com.leasing.rentearly.rentearlyservice.projectInfo.enity.dos;

import com.leasing.common.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseDO;
import com.leasing.common.enums.MatchType;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.*;
import javax.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/10/21
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@Entity
@Table(name="yls_project_info")
public class ProjectInfoDO extends BaseDO {

    private Short increaseCreditTypeDetail;

    private Short isNewCompany;

    private BigDecimal srvfeeCash;

    private BigDecimal projectIrr;

    private Short isCanrefund;

    private String fundsUse;

    private String operateTime;

    private Short projectType;

    private String mdbCode;

    private String memo;

    private String projectDept;

    private BigDecimal grantingOriginalLimit;

    private BigDecimal depositCash;

    private String govNote;

    private BigDecimal notarialFeesRate;

    private Short assureType;

    private Short leaseFreq;

    private Short leaseClassification;

    private Short tradingSchemes;

    private String regionManager;

    private BigDecimal initialPaymentRatio;

    private Short isInsure;

    private Short areaResult;

    private BigDecimal areaUsableTotal;

    private BigDecimal lesseeWeight;

    private BigDecimal finalLimit;

    private String leaseTimeRange;

    private String pkProjectApproval;

    private BigDecimal purchaseTotalAmount;

    private Short auditOrg;

    private String grantingEndDate;

    private Short interestAdjustments;

    private Short grantingType;

    private BigDecimal totalCustCash;

    private String pkCustFinance;

    private BigDecimal srvoutRatio;

    private Short adjustTime;

    private String grantingCurrency;

    private String checkTime;

    private BigDecimal adjustLimit;

    private Short fundingSources;

    private String operateDate;

    private String capitalUse;

    private BigDecimal grantingAddLimit;

    private String grantTime;

    private Short refundStructure;

    private String projectApproveDate;

    private BigDecimal initialPaymentCash;

    private String pkVenderPrjsAudit;

    private Short grantingTimes;

    private Short projectTaxType;

    private Short limitClass;

    private String planDatePredict;

    private Short ifrelation;

    private Short leaseType;

    private BigDecimal premium;

    private String projectCode;

    private BigDecimal customerWeight;

    private Short isFitAdmittance;

    private Short ifCriterionFinal;

    private Short ifcrossborder;

    private Short ifCoLessee;

    private String crmCode;

    private Short operateHours;

    private Short industryResult;

    private Short hospitalGrade;

    private String financeNote;

    private BigDecimal limitAmt;

    private Short leaseCategry;

    private String otherMemo;

    private String checkDate;

    private String pkProOrg;

    private String pkCustMain;

    private BigDecimal leaseCash;

    private BigDecimal projectCashBalance;

    private Short leasebackType;

    private String appointRentDate;

    private BigDecimal refundRate;

    private String businessDomain;

    private String pkOperator;

    private String pkGrantor;

    private Short ifMedicalInfo;

    private BigDecimal appointDeductAmt;

    private String specOther;

    private Short graceDays;

    private Short versionNum;

    private BigDecimal financeIrr;

    private String custResult;

    private String projectApproveNote;

    private BigDecimal srvfeeRatio;

    private String quotaResult;

    private String clientRating;

    private Short isOnetoone;

    @Id
    private String pkProjectInfo;

    private Short meetingNper;

    private String govFinanceNote;

    private String financeAnalysis;

    private String cusOtherDeptNote;

    private BigDecimal grantingSurplusLimit;

    private String orgScene;

    private Short billstatus;

    private Short adjustType;

    private Short ifMedicalStructure;

    private String pkAccount;

    private BigDecimal depositRatio;

    private String grantDate;

    private Short adjustMethod;

    private BigDecimal consultRatio;

    private Short ifinnovate;

    private BigDecimal divideRate;

    private Short projectSort;

    private Short allNper;

    private String pkConsumer;

    private Short ifNew;

    private String pkOrg;

    private Short leaseEquipment;

    private Short ifAdjust;

    private String pkPrjManager;

    private String govOtherDeptNote;

    private String projectName;

//    private Short allnper;

    private String pkChecker;

    private BigDecimal leasePrice;

    private BigDecimal leaseRate;

    private String grantingStartDate;

    private Short benefitMethod;

    private String pkDept;

    private String pkSupplierRelation;

    private BigDecimal annualIncome;

    private BigDecimal leaseRatePboc;

    private Short projectSource;

    private String pkContractRule;

    private Short refundTimes;

//    private Short meetingnper;

    private String planReleaseDate;

    private String pkFrameworkAgreem;

    private String areaManager;

    private Short ifMedicalQualify;

    private BigDecimal releaseAmount;

    private Short reviewConsultion;

    private String transStructure;

    private String industryType;

    private Short projectApproveResult;

    private BigDecimal netFinanceRateCash;

    private String adjustStartDate;

    private String finalApproveSuggestion;

    private BigDecimal grantingUsedLimit;

    private BigDecimal consultCash;

    private String changeReason;

    private BigDecimal netFinanceRateRatio;

    private String deviceNote;

    private Short changeType;

    private BigDecimal drugIncomeRatio;

    private Short isPrecapital;

    private String belongsArea;

    private String pkCustHelp;

    private Short projectStatus;

    private Short ifMedicalLimit;

    private String pkQuotaScheme;

    private BigDecimal srvoutCash;

    private Short maxDeadline;

    private Short increaseCreditType;

    private Short projectBatch;

    private String customerNo;

    private BigDecimal suggestDeductAmt;

    @Override
    public String getPk() {
        return this.pkProjectInfo;
    }

    @Override
    public void setPk(String pk) {
        this.pkProjectInfo = pk;
    }

    public Short getIncreaseCreditTypeDetail() {
        return increaseCreditTypeDetail;
    }

    public void setIncreaseCreditTypeDetail(Short increaseCreditTypeDetail) {
        this.increaseCreditTypeDetail = increaseCreditTypeDetail;
    }

    public Short getIsNewCompany() {
        return isNewCompany;
    }

    public void setIsNewCompany(Short isNewCompany) {
        this.isNewCompany = isNewCompany;
    }

    public BigDecimal getSrvfeeCash() {
        return srvfeeCash;
    }

    public void setSrvfeeCash(BigDecimal srvfeeCash) {
        this.srvfeeCash = srvfeeCash;
    }

    public BigDecimal getProjectIrr() {
        return projectIrr;
    }

    public void setProjectIrr(BigDecimal projectIrr) {
        this.projectIrr = projectIrr;
    }

    public Short getIsCanrefund() {
        return isCanrefund;
    }

    public void setIsCanrefund(Short isCanrefund) {
        this.isCanrefund = isCanrefund;
    }

    public String getFundsUse() {
        return fundsUse;
    }

    public void setFundsUse(String fundsUse) {
        this.fundsUse = fundsUse;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public Short getProjectType() {
        return projectType;
    }

    public void setProjectType(Short projectType) {
        this.projectType = projectType;
    }

    public String getMdbCode() {
        return mdbCode;
    }

    public void setMdbCode(String mdbCode) {
        this.mdbCode = mdbCode;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getProjectDept() {
        return projectDept;
    }

    public void setProjectDept(String projectDept) {
        this.projectDept = projectDept;
    }

    public BigDecimal getGrantingOriginalLimit() {
        return grantingOriginalLimit;
    }

    public void setGrantingOriginalLimit(BigDecimal grantingOriginalLimit) {
        this.grantingOriginalLimit = grantingOriginalLimit;
    }

    public BigDecimal getDepositCash() {
        return depositCash;
    }

    public void setDepositCash(BigDecimal depositCash) {
        this.depositCash = depositCash;
    }

    public String getGovNote() {
        return govNote;
    }

    public void setGovNote(String govNote) {
        this.govNote = govNote;
    }

    public BigDecimal getNotarialFeesRate() {
        return notarialFeesRate;
    }

    public void setNotarialFeesRate(BigDecimal notarialFeesRate) {
        this.notarialFeesRate = notarialFeesRate;
    }

    public Short getAssureType() {
        return assureType;
    }

    public void setAssureType(Short assureType) {
        this.assureType = assureType;
    }

    public Short getLeaseFreq() {
        return leaseFreq;
    }

    public void setLeaseFreq(Short leaseFreq) {
        this.leaseFreq = leaseFreq;
    }

    public Short getLeaseClassification() {
        return leaseClassification;
    }

    public void setLeaseClassification(Short leaseClassification) {
        this.leaseClassification = leaseClassification;
    }

    public Short getTradingSchemes() {
        return tradingSchemes;
    }

    public void setTradingSchemes(Short tradingSchemes) {
        this.tradingSchemes = tradingSchemes;
    }

    public String getRegionManager() {
        return regionManager;
    }

    public void setRegionManager(String regionManager) {
        this.regionManager = regionManager;
    }

    public BigDecimal getInitialPaymentRatio() {
        return initialPaymentRatio;
    }

    public void setInitialPaymentRatio(BigDecimal initialPaymentRatio) {
        this.initialPaymentRatio = initialPaymentRatio;
    }

    public Short getIsInsure() {
        return isInsure;
    }

    public void setIsInsure(Short isInsure) {
        this.isInsure = isInsure;
    }

    public Short getAreaResult() {
        return areaResult;
    }

    public void setAreaResult(Short areaResult) {
        this.areaResult = areaResult;
    }

    public BigDecimal getAreaUsableTotal() {
        return areaUsableTotal;
    }

    public void setAreaUsableTotal(BigDecimal areaUsableTotal) {
        this.areaUsableTotal = areaUsableTotal;
    }

    public BigDecimal getLesseeWeight() {
        return lesseeWeight;
    }

    public void setLesseeWeight(BigDecimal lesseeWeight) {
        this.lesseeWeight = lesseeWeight;
    }

    public BigDecimal getFinalLimit() {
        return finalLimit;
    }

    public void setFinalLimit(BigDecimal finalLimit) {
        this.finalLimit = finalLimit;
    }

    public String getLeaseTimeRange() {
        return leaseTimeRange;
    }

    public void setLeaseTimeRange(String leaseTimeRange) {
        this.leaseTimeRange = leaseTimeRange;
    }

    public String getPkProjectApproval() {
        return pkProjectApproval;
    }

    public void setPkProjectApproval(String pkProjectApproval) {
        this.pkProjectApproval = pkProjectApproval;
    }

    public BigDecimal getPurchaseTotalAmount() {
        return purchaseTotalAmount;
    }

    public void setPurchaseTotalAmount(BigDecimal purchaseTotalAmount) {
        this.purchaseTotalAmount = purchaseTotalAmount;
    }

    public Short getAuditOrg() {
        return auditOrg;
    }

    public void setAuditOrg(Short auditOrg) {
        this.auditOrg = auditOrg;
    }

    public String getGrantingEndDate() {
        return grantingEndDate;
    }

    public void setGrantingEndDate(String grantingEndDate) {
        this.grantingEndDate = grantingEndDate;
    }

    public Short getInterestAdjustments() {
        return interestAdjustments;
    }

    public void setInterestAdjustments(Short interestAdjustments) {
        this.interestAdjustments = interestAdjustments;
    }

    public Short getGrantingType() {
        return grantingType;
    }

    public void setGrantingType(Short grantingType) {
        this.grantingType = grantingType;
    }

    public BigDecimal getTotalCustCash() {
        return totalCustCash;
    }

    public void setTotalCustCash(BigDecimal totalCustCash) {
        this.totalCustCash = totalCustCash;
    }

    public String getPkCustFinance() {
        return pkCustFinance;
    }

    public void setPkCustFinance(String pkCustFinance) {
        this.pkCustFinance = pkCustFinance;
    }

    public BigDecimal getSrvoutRatio() {
        return srvoutRatio;
    }

    public void setSrvoutRatio(BigDecimal srvoutRatio) {
        this.srvoutRatio = srvoutRatio;
    }

    public Short getAdjustTime() {
        return adjustTime;
    }

    public void setAdjustTime(Short adjustTime) {
        this.adjustTime = adjustTime;
    }

    public String getGrantingCurrency() {
        return grantingCurrency;
    }

    public void setGrantingCurrency(String grantingCurrency) {
        this.grantingCurrency = grantingCurrency;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public BigDecimal getAdjustLimit() {
        return adjustLimit;
    }

    public void setAdjustLimit(BigDecimal adjustLimit) {
        this.adjustLimit = adjustLimit;
    }

    public Short getFundingSources() {
        return fundingSources;
    }

    public void setFundingSources(Short fundingSources) {
        this.fundingSources = fundingSources;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public String getCapitalUse() {
        return capitalUse;
    }

    public void setCapitalUse(String capitalUse) {
        this.capitalUse = capitalUse;
    }

    public BigDecimal getGrantingAddLimit() {
        return grantingAddLimit;
    }

    public void setGrantingAddLimit(BigDecimal grantingAddLimit) {
        this.grantingAddLimit = grantingAddLimit;
    }

    public String getGrantTime() {
        return grantTime;
    }

    public void setGrantTime(String grantTime) {
        this.grantTime = grantTime;
    }

    public Short getRefundStructure() {
        return refundStructure;
    }

    public void setRefundStructure(Short refundStructure) {
        this.refundStructure = refundStructure;
    }

    public String getProjectApproveDate() {
        return projectApproveDate;
    }

    public void setProjectApproveDate(String projectApproveDate) {
        this.projectApproveDate = projectApproveDate;
    }

    public BigDecimal getInitialPaymentCash() {
        return initialPaymentCash;
    }

    public void setInitialPaymentCash(BigDecimal initialPaymentCash) {
        this.initialPaymentCash = initialPaymentCash;
    }

    public String getPkVenderPrjsAudit() {
        return pkVenderPrjsAudit;
    }

    public void setPkVenderPrjsAudit(String pkVenderPrjsAudit) {
        this.pkVenderPrjsAudit = pkVenderPrjsAudit;
    }

    public Short getGrantingTimes() {
        return grantingTimes;
    }

    public void setGrantingTimes(Short grantingTimes) {
        this.grantingTimes = grantingTimes;
    }

    public Short getProjectTaxType() {
        return projectTaxType;
    }

    public void setProjectTaxType(Short projectTaxType) {
        this.projectTaxType = projectTaxType;
    }

    public Short getLimitClass() {
        return limitClass;
    }

    public void setLimitClass(Short limitClass) {
        this.limitClass = limitClass;
    }

    public String getPlanDatePredict() {
        return planDatePredict;
    }

    public void setPlanDatePredict(String planDatePredict) {
        this.planDatePredict = planDatePredict;
    }

    public Short getIfrelation() {
        return ifrelation;
    }

    public void setIfrelation(Short ifrelation) {
        this.ifrelation = ifrelation;
    }

    public Short getLeaseType() {
        return leaseType;
    }

    public void setLeaseType(Short leaseType) {
        this.leaseType = leaseType;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public BigDecimal getCustomerWeight() {
        return customerWeight;
    }

    public void setCustomerWeight(BigDecimal customerWeight) {
        this.customerWeight = customerWeight;
    }

    public Short getIsFitAdmittance() {
        return isFitAdmittance;
    }

    public void setIsFitAdmittance(Short isFitAdmittance) {
        this.isFitAdmittance = isFitAdmittance;
    }

    public Short getIfCriterionFinal() {
        return ifCriterionFinal;
    }

    public void setIfCriterionFinal(Short ifCriterionFinal) {
        this.ifCriterionFinal = ifCriterionFinal;
    }

    public Short getIfcrossborder() {
        return ifcrossborder;
    }

    public void setIfcrossborder(Short ifcrossborder) {
        this.ifcrossborder = ifcrossborder;
    }

    public Short getIfCoLessee() {
        return ifCoLessee;
    }

    public void setIfCoLessee(Short ifCoLessee) {
        this.ifCoLessee = ifCoLessee;
    }

    public String getCrmCode() {
        return crmCode;
    }

    public void setCrmCode(String crmCode) {
        this.crmCode = crmCode;
    }

    public Short getOperateHours() {
        return operateHours;
    }

    public void setOperateHours(Short operateHours) {
        this.operateHours = operateHours;
    }

    public Short getIndustryResult() {
        return industryResult;
    }

    public void setIndustryResult(Short industryResult) {
        this.industryResult = industryResult;
    }

    public Short getHospitalGrade() {
        return hospitalGrade;
    }

    public void setHospitalGrade(Short hospitalGrade) {
        this.hospitalGrade = hospitalGrade;
    }

    public String getFinanceNote() {
        return financeNote;
    }

    public void setFinanceNote(String financeNote) {
        this.financeNote = financeNote;
    }

    public BigDecimal getLimitAmt() {
        return limitAmt;
    }

    public void setLimitAmt(BigDecimal limitAmt) {
        this.limitAmt = limitAmt;
    }

    public Short getLeaseCategry() {
        return leaseCategry;
    }

    public void setLeaseCategry(Short leaseCategry) {
        this.leaseCategry = leaseCategry;
    }

    public String getOtherMemo() {
        return otherMemo;
    }

    public void setOtherMemo(String otherMemo) {
        this.otherMemo = otherMemo;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getPkProOrg() {
        return pkProOrg;
    }

    public void setPkProOrg(String pkProOrg) {
        this.pkProOrg = pkProOrg;
    }

    public String getPkCustMain() {
        return pkCustMain;
    }

    public void setPkCustMain(String pkCustMain) {
        this.pkCustMain = pkCustMain;
    }

    public BigDecimal getLeaseCash() {
        return leaseCash;
    }

    public void setLeaseCash(BigDecimal leaseCash) {
        this.leaseCash = leaseCash;
    }

    public BigDecimal getProjectCashBalance() {
        return projectCashBalance;
    }

    public void setProjectCashBalance(BigDecimal projectCashBalance) {
        this.projectCashBalance = projectCashBalance;
    }

    public Short getLeasebackType() {
        return leasebackType;
    }

    public void setLeasebackType(Short leasebackType) {
        this.leasebackType = leasebackType;
    }

    public String getAppointRentDate() {
        return appointRentDate;
    }

    public void setAppointRentDate(String appointRentDate) {
        this.appointRentDate = appointRentDate;
    }

    public BigDecimal getRefundRate() {
        return refundRate;
    }

    public void setRefundRate(BigDecimal refundRate) {
        this.refundRate = refundRate;
    }

    public String getBusinessDomain() {
        return businessDomain;
    }

    public void setBusinessDomain(String businessDomain) {
        this.businessDomain = businessDomain;
    }

    public String getPkOperator() {
        return pkOperator;
    }

    public void setPkOperator(String pkOperator) {
        this.pkOperator = pkOperator;
    }

    public String getPkGrantor() {
        return pkGrantor;
    }

    public void setPkGrantor(String pkGrantor) {
        this.pkGrantor = pkGrantor;
    }


    public Short getIfMedicalInfo() {
        return ifMedicalInfo;
    }

    public void setIfMedicalInfo(Short ifMedicalInfo) {
        this.ifMedicalInfo = ifMedicalInfo;
    }

    public BigDecimal getAppointDeductAmt() {
        return appointDeductAmt;
    }

    public void setAppointDeductAmt(BigDecimal appointDeductAmt) {
        this.appointDeductAmt = appointDeductAmt;
    }

    public String getSpecOther() {
        return specOther;
    }

    public void setSpecOther(String specOther) {
        this.specOther = specOther;
    }

    public Short getGraceDays() {
        return graceDays;
    }

    public void setGraceDays(Short graceDays) {
        this.graceDays = graceDays;
    }

    public Short getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(Short versionNum) {
        this.versionNum = versionNum;
    }

    public BigDecimal getFinanceIrr() {
        return financeIrr;
    }

    public void setFinanceIrr(BigDecimal financeIrr) {
        this.financeIrr = financeIrr;
    }

    public String getCustResult() {
        return custResult;
    }

    public void setCustResult(String custResult) {
        this.custResult = custResult;
    }

    public String getProjectApproveNote() {
        return projectApproveNote;
    }

    public void setProjectApproveNote(String projectApproveNote) {
        this.projectApproveNote = projectApproveNote;
    }

    public BigDecimal getSrvfeeRatio() {
        return srvfeeRatio;
    }

    public void setSrvfeeRatio(BigDecimal srvfeeRatio) {
        this.srvfeeRatio = srvfeeRatio;
    }

    public String getQuotaResult() {
        return quotaResult;
    }

    public void setQuotaResult(String quotaResult) {
        this.quotaResult = quotaResult;
    }

    public String getClientRating() {
        return clientRating;
    }

    public void setClientRating(String clientRating) {
        this.clientRating = clientRating;
    }

    public Short getIsOnetoone() {
        return isOnetoone;
    }

    public void setIsOnetoone(Short isOnetoone) {
        this.isOnetoone = isOnetoone;
    }

    public String getPkProjectInfo() {
        return pkProjectInfo;
    }

    public void setPkProjectInfo(String pkProjectInfo) {
        this.pkProjectInfo = pkProjectInfo;
    }

    public Short getMeetingNper() {
        return meetingNper;
    }

    public void setMeetingNper(Short meetingNper) {
        this.meetingNper = meetingNper;
    }

    public String getGovFinanceNote() {
        return govFinanceNote;
    }

    public void setGovFinanceNote(String govFinanceNote) {
        this.govFinanceNote = govFinanceNote;
    }

    public String getFinanceAnalysis() {
        return financeAnalysis;
    }

    public void setFinanceAnalysis(String financeAnalysis) {
        this.financeAnalysis = financeAnalysis;
    }

    public String getCusOtherDeptNote() {
        return cusOtherDeptNote;
    }

    public void setCusOtherDeptNote(String cusOtherDeptNote) {
        this.cusOtherDeptNote = cusOtherDeptNote;
    }

    public BigDecimal getGrantingSurplusLimit() {
        return grantingSurplusLimit;
    }

    public void setGrantingSurplusLimit(BigDecimal grantingSurplusLimit) {
        this.grantingSurplusLimit = grantingSurplusLimit;
    }

    public String getOrgScene() {
        return orgScene;
    }

    public void setOrgScene(String orgScene) {
        this.orgScene = orgScene;
    }

    public Short getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
    }

    public Short getAdjustType() {
        return adjustType;
    }

    public void setAdjustType(Short adjustType) {
        this.adjustType = adjustType;
    }

    public Short getIfMedicalStructure() {
        return ifMedicalStructure;
    }

    public void setIfMedicalStructure(Short ifMedicalStructure) {
        this.ifMedicalStructure = ifMedicalStructure;
    }

    public String getPkAccount() {
        return pkAccount;
    }

    public void setPkAccount(String pkAccount) {
        this.pkAccount = pkAccount;
    }

    public BigDecimal getDepositRatio() {
        return depositRatio;
    }

    public void setDepositRatio(BigDecimal depositRatio) {
        this.depositRatio = depositRatio;
    }

    public String getGrantDate() {
        return grantDate;
    }

    public void setGrantDate(String grantDate) {
        this.grantDate = grantDate;
    }

    public Short getAdjustMethod() {
        return adjustMethod;
    }

    public void setAdjustMethod(Short adjustMethod) {
        this.adjustMethod = adjustMethod;
    }

    public BigDecimal getConsultRatio() {
        return consultRatio;
    }

    public void setConsultRatio(BigDecimal consultRatio) {
        this.consultRatio = consultRatio;
    }

    public Short getIfinnovate() {
        return ifinnovate;
    }

    public void setIfinnovate(Short ifinnovate) {
        this.ifinnovate = ifinnovate;
    }

    public BigDecimal getDivideRate() {
        return divideRate;
    }

    public void setDivideRate(BigDecimal divideRate) {
        this.divideRate = divideRate;
    }

    public Short getProjectSort() {
        return projectSort;
    }

    public void setProjectSort(Short projectSort) {
        this.projectSort = projectSort;
    }

    public Short getAllNper() {
        return allNper;
    }

    public void setAllNper(Short allNper) {
        this.allNper = allNper;
    }

    public String getPkConsumer() {
        return pkConsumer;
    }

    public void setPkConsumer(String pkConsumer) {
        this.pkConsumer = pkConsumer;
    }

    public Short getIfNew() {
        return ifNew;
    }

    public void setIfNew(Short ifNew) {
        this.ifNew = ifNew;
    }

    public String getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg;
    }

    public Short getLeaseEquipment() {
        return leaseEquipment;
    }

    public void setLeaseEquipment(Short leaseEquipment) {
        this.leaseEquipment = leaseEquipment;
    }

    public Short getIfAdjust() {
        return ifAdjust;
    }

    public void setIfAdjust(Short ifAdjust) {
        this.ifAdjust = ifAdjust;
    }

    public String getPkPrjManager() {
        return pkPrjManager;
    }

    public void setPkPrjManager(String pkPrjManager) {
        this.pkPrjManager = pkPrjManager;
    }

    public String getGovOtherDeptNote() {
        return govOtherDeptNote;
    }

    public void setGovOtherDeptNote(String govOtherDeptNote) {
        this.govOtherDeptNote = govOtherDeptNote;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

//    public Short getAllnper() {
//        return allnper;
//    }
//
//    public void setAllnper(Short allnper) {
//        this.allnper = allnper;
//    }

    public String getPkChecker() {
        return pkChecker;
    }

    public void setPkChecker(String pkChecker) {
        this.pkChecker = pkChecker;
    }

    public BigDecimal getLeasePrice() {
        return leasePrice;
    }

    public void setLeasePrice(BigDecimal leasePrice) {
        this.leasePrice = leasePrice;
    }

    public BigDecimal getLeaseRate() {
        return leaseRate;
    }

    public void setLeaseRate(BigDecimal leaseRate) {
        this.leaseRate = leaseRate;
    }

    public String getGrantingStartDate() {
        return grantingStartDate;
    }

    public void setGrantingStartDate(String grantingStartDate) {
        this.grantingStartDate = grantingStartDate;
    }

    public Short getBenefitMethod() {
        return benefitMethod;
    }

    public void setBenefitMethod(Short benefitMethod) {
        this.benefitMethod = benefitMethod;
    }

    public String getPkDept() {
        return pkDept;
    }

    public void setPkDept(String pkDept) {
        this.pkDept = pkDept;
    }

    public String getPkSupplierRelation() {
        return pkSupplierRelation;
    }

    public void setPkSupplierRelation(String pkSupplierRelation) {
        this.pkSupplierRelation = pkSupplierRelation;
    }

    public BigDecimal getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(BigDecimal annualIncome) {
        this.annualIncome = annualIncome;
    }

    public BigDecimal getLeaseRatePboc() {
        return leaseRatePboc;
    }

    public void setLeaseRatePboc(BigDecimal leaseRatePboc) {
        this.leaseRatePboc = leaseRatePboc;
    }

    public Short getProjectSource() {
        return projectSource;
    }

    public void setProjectSource(Short projectSource) {
        this.projectSource = projectSource;
    }

    public String getPkContractRule() {
        return pkContractRule;
    }

    public void setPkContractRule(String pkContractRule) {
        this.pkContractRule = pkContractRule;
    }

    public Short getRefundTimes() {
        return refundTimes;
    }

    public void setRefundTimes(Short refundTimes) {
        this.refundTimes = refundTimes;
    }


    public String getPlanReleaseDate() {
        return planReleaseDate;
    }

    public void setPlanReleaseDate(String planReleaseDate) {
        this.planReleaseDate = planReleaseDate;
    }

    public String getPkFrameworkAgreem() {
        return pkFrameworkAgreem;
    }

    public void setPkFrameworkAgreem(String pkFrameworkAgreem) {
        this.pkFrameworkAgreem = pkFrameworkAgreem;
    }

    public String getAreaManager() {
        return areaManager;
    }

    public void setAreaManager(String areaManager) {
        this.areaManager = areaManager;
    }

    public Short getIfMedicalQualify() {
        return ifMedicalQualify;
    }

    public void setIfMedicalQualify(Short ifMedicalQualify) {
        this.ifMedicalQualify = ifMedicalQualify;
    }

    public BigDecimal getReleaseAmount() {
        return releaseAmount;
    }

    public void setReleaseAmount(BigDecimal releaseAmount) {
        this.releaseAmount = releaseAmount;
    }

    public Short getReviewConsultion() {
        return reviewConsultion;
    }

    public void setReviewConsultion(Short reviewConsultion) {
        this.reviewConsultion = reviewConsultion;
    }

    public String getTransStructure() {
        return transStructure;
    }

    public void setTransStructure(String transStructure) {
        this.transStructure = transStructure;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public Short getProjectApproveResult() {
        return projectApproveResult;
    }

    public void setProjectApproveResult(Short projectApproveResult) {
        this.projectApproveResult = projectApproveResult;
    }

    public BigDecimal getNetFinanceRateCash() {
        return netFinanceRateCash;
    }

    public void setNetFinanceRateCash(BigDecimal netFinanceRateCash) {
        this.netFinanceRateCash = netFinanceRateCash;
    }

    public String getAdjustStartDate() {
        return adjustStartDate;
    }

    public void setAdjustStartDate(String adjustStartDate) {
        this.adjustStartDate = adjustStartDate;
    }

    public String getFinalApproveSuggestion() {
        return finalApproveSuggestion;
    }

    public void setFinalApproveSuggestion(String finalApproveSuggestion) {
        this.finalApproveSuggestion = finalApproveSuggestion;
    }

    public BigDecimal getGrantingUsedLimit() {
        return grantingUsedLimit;
    }

    public void setGrantingUsedLimit(BigDecimal grantingUsedLimit) {
        this.grantingUsedLimit = grantingUsedLimit;
    }

    public BigDecimal getConsultCash() {
        return consultCash;
    }

    public void setConsultCash(BigDecimal consultCash) {
        this.consultCash = consultCash;
    }

    public String getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }

    public BigDecimal getNetFinanceRateRatio() {
        return netFinanceRateRatio;
    }

    public void setNetFinanceRateRatio(BigDecimal netFinanceRateRatio) {
        this.netFinanceRateRatio = netFinanceRateRatio;
    }

    public String getDeviceNote() {
        return deviceNote;
    }

    public void setDeviceNote(String deviceNote) {
        this.deviceNote = deviceNote;
    }

    public Short getChangeType() {
        return changeType;
    }

    public void setChangeType(Short changeType) {
        this.changeType = changeType;
    }

    public BigDecimal getDrugIncomeRatio() {
        return drugIncomeRatio;
    }

    public void setDrugIncomeRatio(BigDecimal drugIncomeRatio) {
        this.drugIncomeRatio = drugIncomeRatio;
    }

    public Short getIsPrecapital() {
        return isPrecapital;
    }

    public void setIsPrecapital(Short isPrecapital) {
        this.isPrecapital = isPrecapital;
    }

    public String getBelongsArea() {
        return belongsArea;
    }

    public void setBelongsArea(String belongsArea) {
        this.belongsArea = belongsArea;
    }

    public String getPkCustHelp() {
        return pkCustHelp;
    }

    public void setPkCustHelp(String pkCustHelp) {
        this.pkCustHelp = pkCustHelp;
    }

    public Short getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Short projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Short getIfMedicalLimit() {
        return ifMedicalLimit;
    }

    public void setIfMedicalLimit(Short ifMedicalLimit) {
        this.ifMedicalLimit = ifMedicalLimit;
    }

    public String getPkQuotaScheme() {
        return pkQuotaScheme;
    }

    public void setPkQuotaScheme(String pkQuotaScheme) {
        this.pkQuotaScheme = pkQuotaScheme;
    }

    public BigDecimal getSrvoutCash() {
        return srvoutCash;
    }

    public void setSrvoutCash(BigDecimal srvoutCash) {
        this.srvoutCash = srvoutCash;
    }

    public Short getMaxDeadline() {
        return maxDeadline;
    }

    public void setMaxDeadline(Short maxDeadline) {
        this.maxDeadline = maxDeadline;
    }

    public Short getIncreaseCreditType() {
        return increaseCreditType;
    }

    public void setIncreaseCreditType(Short increaseCreditType) {
        this.increaseCreditType = increaseCreditType;
    }

    public Short getProjectBatch() {
        return projectBatch;
    }

    public void setProjectBatch(Short projectBatch) {
        this.projectBatch = projectBatch;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public BigDecimal getSuggestDeductAmt() {
        return suggestDeductAmt;
    }

    public void setSuggestDeductAmt(BigDecimal suggestDeductAmt) {
        this.suggestDeductAmt = suggestDeductAmt;
    }


    //    public Specification<ProjectInfoDO> toSpec() {
//
//        Specification<ProjectInfoDO> spec = super.toSpecWithAnd();
//        return ((root, criteriaQuery, criteriaBuilder) -> {
//            List<Predicate> predicatesList = new ArrayList<>();
//            predicatesList.add(spec.toPredicate(root, criteriaQuery, criteriaBuilder));
////            if (projectCode != null) {
////                predicatesList.add(
////                        criteriaBuilder.like(
////                                root.get("projectCode"),"%"+projectCode+"%"));
////            }
////            if (projectName != null) {
////                predicatesList.add(
////                        criteriaBuilder.like(
////                                root.get("projectName"),"%"+projectName+"%") );
////            }
//            return criteriaBuilder.and(predicatesList.toArray(new Predicate[predicatesList.size()]));
//        });
//    }
}
