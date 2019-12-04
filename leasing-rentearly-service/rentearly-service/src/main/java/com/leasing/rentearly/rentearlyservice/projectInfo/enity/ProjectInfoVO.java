package com.leasing.rentearly.rentearlyservice.projectInfo.enity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.entity.foundation.vo.DeptVO;
import com.leasing.common.entity.foundation.vo.UserVO;
import com.leasing.rentearly.rentearlyservice.projectInfo.enity.dto.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/10/21
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yls_project_info")
@JsonIgnoreProperties(value = { "hibernateEAGERInitializer","handler"})
public class ProjectInfoVO extends BaseVO {

    /**
     * 类ProjectInfoVO的构造方法
     */
    public ProjectInfoVO() {

    }

    @Id    //主键id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "project-id")
    @GenericGenerator(name = "project-id", strategy = "com.leasing.rentearly.rentearlyservice.projectInfo.utils.IDGenerator")
    public String pkProjectInfo;

    /**
     * 项目编号
     */
    public String projectCode;

    /**
     * 项目名称
     */
    public String projectName;

    /**
     * 立项主键
     */
    @ManyToOne(fetch = FetchType.EAGER) //JPA注释： 一对一 关系
    @JoinColumn(name = "pkProjectApproval")
    public ProjectApprovalDTO pkProjectApproval;
    /**
     * 符合公司风险政策及准入标准
     */
    public Short isFitAdmittance;
    /**
     * 项目部门
     */
    @ManyToOne(fetch = FetchType.EAGER) //JPA注释： 一对一 关系
    @JoinColumn(name = "projectDept")
    public DeptVO projectDept;
    /**
     * 是否有共同承租人
     */
    public Short ifCoLessee;
    /**
     * 项目批次
     */
    public Integer projectBatch;
    /**
     * 项目经理
     */
    @ManyToOne(fetch = FetchType.EAGER) //JPA注释： 一对一 关系
    @JoinColumn(name = "pkPrjManager")
    public UserVO pkPrjManager;
    /**
     * 项目类型
     */
    public Short projectType;
    /**
     * 项目来源
     */
    public Short projectSource;
    /**
     * 回租类别
     */
    public Short leasebackType;
    /**
     * 租赁类别
     */
    public Short leaseCategry;
    /**
     * 是否投保
     */
    public Short isInsure;
    /**
     * 租赁方式
     */
    public Short leaseType;
    /**
     * 项目税种
     */
    public Short projectTaxType;
    /**
     * 预计投放日期
     */
    public String planReleaseDate;
    /**
     * 项目金额
     */
    public BigDecimal releaseAmount;
    /**
     * 授信起始日期
     */
    public String grantingStartDate;
    /**
     * 授信截止日期
     */
    public String grantingEndDate;
    /**
     * 授信期限
     */
    public Integer grantingTimes;
    /**
     * 原授信额度(元)
     */
    public BigDecimal grantingOriginalLimit;
    /**
     * 已用额度(元)
     */
    public BigDecimal grantingUsedLimit;
    /**
     * 新增额度(元)
     */
    public BigDecimal grantingAddLimit;
    /**
     * 可用额度(元)
     */
    public BigDecimal grantingSurplusLimit;
    /**
     * 授信币种
     */
    @ManyToOne(fetch = FetchType.EAGER) //JPA注释： 一对一 关系
    @JoinColumn(name = "grantingCurrency")
    public CurrtypeDTO grantingCurrency;
    /**
     * 授信类型
     */
    public Short grantingType;
    /**
     * 客户评级
     */
    @ManyToOne(fetch = FetchType.EAGER) //JPA注释： 一对一 关系
    @JoinColumn(name = "clientRating")
    public RatingMaintainBDTO clientRating;
    /**
     * 客户主键
     */
    @ManyToOne(fetch = FetchType.EAGER) //JPA注释： 一对一 关系
    @JoinColumn(name = "pkConsumer")
    public CustomerDTO pkConsumer;
    /**
     * 供应商框架协议主键
     */
    @ManyToOne(fetch = FetchType.EAGER) //JPA注释： 一对一 关系
    @JoinColumn(name = "pkFrameworkAgreem")
    public ProviderConferDTO pkFrameworkAgreem;
    /**
     * 供应商限额方案主键
     */
    @ManyToOne(fetch = FetchType.EAGER) //JPA注释： 一对一 关系
    @JoinColumn(name = "pkQuotaScheme")
    public LimitPlanDTO pkQuotaScheme;
    /**
     * 供应商限额结果
     */

    public String quotaResult;
    /**
     * 设备金额
     */
    public BigDecimal purchaseTotalAmount;
    /**
     * 客户财务相关
     */
    public String financeNote;
    /**
     * 设备相关
     */
    public String deviceNote;
    /**
     * 客户其他部门
     */
    public String cusOtherDeptNote;
    /**
     * 政府相关
     */
    public String govNote;
    /**
     * 政府财政相关
     */
    public String govFinanceNote;
    /**
     * 政府其他部门
     */
    public String govOtherDeptNote;
    /**
     * 保险费
     */
    public BigDecimal premium;
    /**
     * 公证费比例
     */
    public BigDecimal notarialFeesRate;
    /**
     * 审批文档生成规则
     */
    @ManyToOne(fetch = FetchType.EAGER) //JPA注释： 一对一 关系
    @JoinColumn(name = "pkContractRule")
    public ContractRuleDTO pkContractRule;
    /**
     * 保证方式ProjectCalculatorRefVO
     */
    public Short assureType;
    /**
     * 项目审批审批结果
     */
    public Short projectApproveResult;
    /**
     * 项目审批审批日期
     */
    public String projectApproveDate;
    /**
     * 审批结果描述
     */
    public String projectApproveNote;

    /** INSERT  【 sunlk】 【2018年7月12日】 【BUG修改】<BUG号-ZJTSIQI-14> 普通项目审批/普通项目审批变更/普通项目审批复议/过审项目审批查询节点，添加 是否跨境业务，是否孵化及创新业务，是否关联交易方三个字段，枚举值是，否*/
    /**
     * 是否跨境业务
     */
    public Short ifcrossborder;
    /**
     * 是否孵化及创新业务
     */
    public Short ifinnovate;
    /**
     * 是否关联交易方
     */
    public Short ifrelation;
    /**END*/

    /**
     * 变更类型
     */
    public Short changeType;
    /**
     * 变更原因
     */
    public String changeReason;
    /**
     * 调息对象
     */
    public Short interestAdjustments;
    /**
     * 项目状态
     */
    public Short projectStatus;
    /**
     * 资金渠道
     */
    public Short fundingSources;
    /**
     * 交易框架
     */
    public Short tradingSchemes;
    /**
     * 大区经理
     */
    @ManyToOne(fetch = FetchType.EAGER) //JPA注释： 一对一 关系
    @JoinColumn(name = "regionManager")
    public UserVO regionManager;
    /**
     * 所属片区
     */
    @ManyToOne(fetch = FetchType.EAGER) //JPA注释： 一对一 关系
    @JoinColumn(name = "belongsArea")
    public DeptVO belongsArea;
    /**
     * 片区经理
     */
    @ManyToOne(fetch = FetchType.EAGER) //JPA注释： 一对一 关系
    @JoinColumn(name = "areaManager")
    public UserVO areaManager;
    /**
     * 版本号
     */
    @Transient
    public Integer versionNum;
    /**
     * 是否最新
     */
    public Short ifNew;
    /**
     * 租赁最大期限
     */
    public Integer maxDeadline;
    /**
     * 项目分类
     */
    public Short projectSort;

    /*
     * =========================================================
     * 2014年改版增加的字段,需求陈秀丽
     * =========================================================
     */
    /**
     * 确认业务领域
     */
    @ManyToOne(fetch = FetchType.EAGER) //JPA注释： 一对一 关系
    @JoinColumn(name = "industryType")
    public ParmsDTO industryType;
    /**
     * 客户号
     */
    public String customerNo;
    /**
     * 资金用途
     */
    public String capitalUse;
    /**
     * 是否项目合同一一对应
     */
    public Short isOnetoone;
    /**
     * 实际融资客户
     */
    @ManyToOne(fetch = FetchType.EAGER) //JPA注释： 一对一 关系
    @JoinColumn(name = "pkCustFinance")
    public CustomerDTO pkCustFinance;
    /**
     * 是否预约资金
     */
    public Short isPrecapital;
    /**
     * 项目主办人
     */
    @ManyToOne(fetch = FetchType.EAGER) //JPA注释： 一对一 关系
    @JoinColumn(name = "pkCustMain")
    public MemberContactDTO pkCustMain;
    /**
     * 项目协办人
     */
    @ManyToOne(fetch = FetchType.EAGER) //JPA注释： 一对一 关系
    @JoinColumn(name = "pkCustHelp")
    public MemberContactDTO pkCustHelp;
    /**
     * 项目主账户
     */
    @ManyToOne(fetch = FetchType.EAGER) //JPA注释： 一对一 关系
    @JoinColumn(name = "pkAccount")
    public BankAccountDTO pkAccount;
    /**
     * 授信分类
     */
    public Short limitClass;
    /**
     * 本次授信额度
     */
    public BigDecimal limitAmt;
    /**
     * 是否调息
     */
    public Short ifAdjust;
    /**
     * 调息类别 0-系统 1-手工
     */
    public Short adjustType;
    /**
     * 调息时点
     */
    public Short adjustTime;
    /**
     * 调息相应方式
     */
    public Short adjustMethod;
    /**
     * 调息起始日
     */
    public String adjustStartDate;
    /**
     * 承租人权重
     */
    public BigDecimal lesseeWeight;
    /**
     * 客户权限
     */
    public BigDecimal customerWeight;
    /**
     * 是否允许提前还款
     */
    public Short isCanrefund;
    /**
     * 提前还款期限
     */
    public Integer refundTimes;
    /**
     * 提前还款手续费率(%)
     */
    public BigDecimal refundRate;

    /**
     * 项目主表参照的报价信息
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER) //JPA注释： 一对一 关系
    //@PrimaryKeyJoinColumn(name = "pkProjectInfo",referencedColumnName = "pkProjectInfo")
    @JoinColumn(name = "pkProjectInfo")
    public ProjectCalculatorDTO projectcalculatorrefvo;
    /**
     * 项目主表参照担保信息
     */
//    public ProjectPledgeRefVO projectPledgeRefVO;
    /**
     * 项目主表参照租赁物信息
     */
    //@ManyToOne(fetch = FetchType.EAGER) //JPA注释： 一对一 关系
    //@PrimaryKeyJoinColumn(name = "pkProjectInfo",referencedColumnName = "sourceBill")
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER) //JPA注释： 一对一 关系
    @JoinColumn(name = "pkProjectInfo")
    public ProjectRentThingDTO projectpledgerefvo;


    /**
     * 更新客户信息
     */
    @Transient
    public boolean updateCustomer;

    /**
     * 约定固定起租日
     */
    public String appointRentDate;

    /**
     * 让利方式
     */
    public Short benefitMethod;
    /**
     * 宽限天数
     */
    public Integer graceDays;
    /**
     * 建议日扣减金额
     */
    public BigDecimal suggestDeductAmt;
    /**
     * 约定日扣减金额
     */
    public BigDecimal appointDeductAmt;

    /**
     * @usage 201403聚信增加
     * @description 主数据编码
     */
    public String mdbCode;

    /**
     * @usage 201406聚信增加
     * @description 主数据编码
     */
    public String crmCode;

    /**
     * 租赁物分类
     */
    public Short increaseCreditType;

    /**
     * 增信措施类别
     */
    public Short leaseClassification;

    /**
     * 增信分类措施分类明细
     */
    public Short increaseCreditTypeDetail;

    /**
     * 20160128
     * add by lihongjian
     * 分成租赁
     * 分成比例
     */

    public BigDecimal divideRate;

    /**
     * 最终审批结果
     */
    public String finalApproveSuggestion;


    /** INSERT  【wangxy】 【2016-12-8】 【项目审批报告】<会议期数> */
    public Integer meetingNper;

    public Integer allNper;

    /**
     * add by jiaoshy
     * 当前客户未偿还租金总额
     * 2018-06-15
     * @return
     */
    public BigDecimal totalCustCash;
    /*add end*/

    /**
     * add by jiaoshy
     * 评审结论
     * 2018-06-15
     * @return
     */
    public Short reviewConsultion;
    /*add end*/

    public Short auditOrg;

    /**
     * 业务范围
     */
    @ManyToOne(fetch = FetchType.EAGER) //JPA注释： 一对一 关系
    @JoinColumn(name = "businessDomain")
    public BusinessDomainDTO businessDomain;


    /**
     * 是否准入政策
     * add by jiaoshy 自动审批
     */
    public Short ifCriterionFinal;

    public Short getIsFitAdmittance() {
        return isFitAdmittance;
    }

    public void setIsFitAdmittance(Short isFitAdmittance) {
        this.isFitAdmittance = isFitAdmittance;
    }

    public DeptVO getProjectDept() {
        return projectDept;
    }

    public void setProjectDept(DeptVO projectDept) {
        this.projectDept = projectDept;
    }

    public Short getIfCoLessee() {
        return ifCoLessee;
    }

    public void setIfCoLessee(Short ifCoLessee) {
        this.ifCoLessee = ifCoLessee;
    }

    public Integer getProjectBatch() {
        return projectBatch;
    }

    public void setProjectBatch(Integer projectBatch) {
        this.projectBatch = projectBatch;
    }

    public Short getProjectType() {
        return projectType;
    }

    public void setProjectType(Short projectType) {
        this.projectType = projectType;
    }

    public Short getProjectSource() {
        return projectSource;
    }

    public void setProjectSource(Short projectSource) {
        this.projectSource = projectSource;
    }

    public Short getLeasebackType() {
        return leasebackType;
    }

    public void setLeasebackType(Short leasebackType) {
        this.leasebackType = leasebackType;
    }

    public Short getLeaseCategry() {
        return leaseCategry;
    }

    public void setLeaseCategry(Short leaseCategry) {
        this.leaseCategry = leaseCategry;
    }

    public Short getIsInsure() {
        return isInsure;
    }

    public void setIsInsure(Short isInsure) {
        this.isInsure = isInsure;
    }

    public Short getLeaseType() {
        return leaseType;
    }

    public void setLeaseType(Short leaseType) {
        this.leaseType = leaseType;
    }

    public Short getProjectTaxType() {
        return projectTaxType;
    }

    public void setProjectTaxType(Short projectTaxType) {
        this.projectTaxType = projectTaxType;
    }

    public String getPlanReleaseDate() {
        return planReleaseDate;
    }

    public void setPlanReleaseDate(String planReleaseDate) {
        this.planReleaseDate = planReleaseDate;
    }

    public BigDecimal getReleaseAmount() {
        return releaseAmount;
    }

    public void setReleaseAmount(BigDecimal releaseAmount) {
        this.releaseAmount = releaseAmount;
    }

    public String getGrantingStartDate() {
        return grantingStartDate;
    }

    public void setGrantingStartDate(String grantingStartDate) {
        this.grantingStartDate = grantingStartDate;
    }

    public String getGrantingEndDate() {
        return grantingEndDate;
    }

    public void setGrantingEndDate(String grantingEndDate) {
        this.grantingEndDate = grantingEndDate;
    }

    public Integer getGrantingTimes() {
        return grantingTimes;
    }

    public void setGrantingTimes(Integer grantingTimes) {
        this.grantingTimes = grantingTimes;
    }

    public BigDecimal getGrantingOriginalLimit() {
        return grantingOriginalLimit;
    }

    public void setGrantingOriginalLimit(BigDecimal grantingOriginalLimit) {
        this.grantingOriginalLimit = grantingOriginalLimit;
    }

    public BigDecimal getGrantingUsedLimit() {
        return grantingUsedLimit;
    }

    public void setGrantingUsedLimit(BigDecimal grantingUsedLimit) {
        this.grantingUsedLimit = grantingUsedLimit;
    }

    public BigDecimal getGrantingAddLimit() {
        return grantingAddLimit;
    }

    public void setGrantingAddLimit(BigDecimal grantingAddLimit) {
        this.grantingAddLimit = grantingAddLimit;
    }

    public BigDecimal getGrantingSurplusLimit() {
        return grantingSurplusLimit;
    }

    public void setGrantingSurplusLimit(BigDecimal grantingSurplusLimit) {
        this.grantingSurplusLimit = grantingSurplusLimit;
    }

    public Short getGrantingType() {
        return grantingType;
    }

    public void setGrantingType(Short grantingType) {
        this.grantingType = grantingType;
    }

    public String getQuotaResult() {
        return quotaResult;
    }

    public void setQuotaResult(String quotaResult) {
        this.quotaResult = quotaResult;
    }

    public BigDecimal getPurchaseTotalAmount() {
        return purchaseTotalAmount;
    }

    public void setPurchaseTotalAmount(BigDecimal purchaseTotalAmount) {
        this.purchaseTotalAmount = purchaseTotalAmount;
    }

    public String getFinanceNote() {
        return financeNote;
    }

    public void setFinanceNote(String financeNote) {
        this.financeNote = financeNote;
    }

    public String getDeviceNote() {
        return deviceNote;
    }

    public void setDeviceNote(String deviceNote) {
        this.deviceNote = deviceNote;
    }

    public String getCusOtherDeptNote() {
        return cusOtherDeptNote;
    }

    public void setCusOtherDeptNote(String cusOtherDeptNote) {
        this.cusOtherDeptNote = cusOtherDeptNote;
    }

    public String getGovNote() {
        return govNote;
    }

    public void setGovNote(String govNote) {
        this.govNote = govNote;
    }

    public String getGovFinanceNote() {
        return govFinanceNote;
    }

    public void setGovFinanceNote(String govFinanceNote) {
        this.govFinanceNote = govFinanceNote;
    }

    public String getGovOtherDeptNote() {
        return govOtherDeptNote;
    }

    public void setGovOtherDeptNote(String govOtherDeptNote) {
        this.govOtherDeptNote = govOtherDeptNote;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
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

    public Short getProjectApproveResult() {
        return projectApproveResult;
    }

    public void setProjectApproveResult(Short projectApproveResult) {
        this.projectApproveResult = projectApproveResult;
    }

    public String getProjectApproveDate() {
        return projectApproveDate;
    }

    public void setProjectApproveDate(String projectApproveDate) {
        this.projectApproveDate = projectApproveDate;
    }

    public String getProjectApproveNote() {
        return projectApproveNote;
    }

    public void setProjectApproveNote(String projectApproveNote) {
        this.projectApproveNote = projectApproveNote;
    }

    public Short getIfcrossborder() {
        return ifcrossborder;
    }

    public void setIfcrossborder(Short ifcrossborder) {
        this.ifcrossborder = ifcrossborder;
    }

    public Short getIfinnovate() {
        return ifinnovate;
    }

    public void setIfInnovate(Short ifInnovate) {
        this.ifinnovate = ifInnovate;
    }

    public Short getIfrelation() {
        return ifrelation;
    }

    public void setIfrelation(Short ifrelation) {
        this.ifrelation = ifrelation;
    }

    public Short getChangeType() {
        return changeType;
    }

    public void setChangeType(Short changeType) {
        this.changeType = changeType;
    }

    public String getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }

    public Short getInterestAdjustments() {
        return interestAdjustments;
    }

    public void setInterestAdjustments(Short interestAdjustments) {
        this.interestAdjustments = interestAdjustments;
    }

    public Short getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Short projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Short getFundingSources() {
        return fundingSources;
    }

    public void setFundingSources(Short fundingSources) {
        this.fundingSources = fundingSources;
    }

    public Short getTradingSchemes() {
        return tradingSchemes;
    }

    public void setTradingSchemes(Short tradingSchemes) {
        this.tradingSchemes = tradingSchemes;
    }

    public Short getIfNew() {
        return ifNew;
    }

    public void setIfNew(Short ifNew) {
        this.ifNew = ifNew;
    }

    public Integer getMaxDeadline() {
        return maxDeadline;
    }

    public void setMaxDeadline(Integer maxDeadline) {
        this.maxDeadline = maxDeadline;
    }

    public Short getProjectSort() {
        return projectSort;
    }

    public void setProjectSort(Short projectSort) {
        this.projectSort = projectSort;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getCapitalUse() {
        return capitalUse;
    }

    public void setCapitalUse(String capitalUse) {
        this.capitalUse = capitalUse;
    }

    public Short getIsOnetoone() {
        return isOnetoone;
    }

    public void setIsOnetoone(Short isOnetoone) {
        this.isOnetoone = isOnetoone;
    }

    public Short getIsPrecapital() {
        return isPrecapital;
    }

    public void setIsPrecapital(Short isPrecapital) {
        this.isPrecapital = isPrecapital;
    }

    public Short getLimitClass() {
        return limitClass;
    }

    public void setLimitClass(Short limitClass) {
        this.limitClass = limitClass;
    }

    public BigDecimal getLimitAmt() {
        return limitAmt;
    }

    public void setLimitAmt(BigDecimal limitAmt) {
        this.limitAmt = limitAmt;
    }

    public Short getIfAdjust() {
        return ifAdjust;
    }

    public void setIfAdjust(Short ifAdjust) {
        this.ifAdjust = ifAdjust;
    }

    public Short getAdjustType() {
        return adjustType;
    }

    public void setAdjustType(Short adjustType) {
        this.adjustType = adjustType;
    }

    public Short getAdjustTime() {
        return adjustTime;
    }

    public void setAdjustTime(Short adjustTime) {
        this.adjustTime = adjustTime;
    }

    public Short getAdjustMethod() {
        return adjustMethod;
    }

    public void setAdjustMethod(Short adjustMethod) {
        this.adjustMethod = adjustMethod;
    }

    public String getAdjustStartDate() {
        return adjustStartDate;
    }

    public void setAdjustStartDate(String adjustStartDate) {
        this.adjustStartDate = adjustStartDate;
    }

    public BigDecimal getLesseeWeight() {
        return lesseeWeight;
    }

    public void setLesseeWeight(BigDecimal lesseeWeight) {
        this.lesseeWeight = lesseeWeight;
    }

    public BigDecimal getCustomerWeight() {
        return customerWeight;
    }

    public void setCustomerWeight(BigDecimal customerWeight) {
        this.customerWeight = customerWeight;
    }

    public Short getIsCanrefund() {
        return isCanrefund;
    }

    public void setIsCanrefund(Short isCanrefund) {
        this.isCanrefund = isCanrefund;
    }

    public Integer getRefundTimes() {
        return refundTimes;
    }

    public void setRefundTimes(Integer refundTimes) {
        this.refundTimes = refundTimes;
    }

    public BigDecimal getRefundRate() {
        return refundRate;
    }

    public void setRefundRate(BigDecimal refundRate) {
        this.refundRate = refundRate;
    }

    public boolean isUpdateCustomer() {
        return updateCustomer;
    }

    public void setUpdateCustomer(boolean updateCustomer) {
        this.updateCustomer = updateCustomer;
    }

    public String getAppointRentDate() {
        return appointRentDate;
    }

    public void setAppointRentDate(String appointRentDate) {
        this.appointRentDate = appointRentDate;
    }

    public Short getBenefitMethod() {
        return benefitMethod;
    }

    public void setBenefitMethod(Short benefitMethod) {
        this.benefitMethod = benefitMethod;
    }

    public Integer getGraceDays() {
        return graceDays;
    }

    public void setGraceDays(Integer graceDays) {
        this.graceDays = graceDays;
    }

    public BigDecimal getSuggestDeductAmt() {
        return suggestDeductAmt;
    }

    public void setSuggestDeductAmt(BigDecimal suggestDeductAmt) {
        this.suggestDeductAmt = suggestDeductAmt;
    }

    public BigDecimal getAppointDeductAmt() {
        return appointDeductAmt;
    }

    public void setAppointDeductAmt(BigDecimal appointDeductAmt) {
        this.appointDeductAmt = appointDeductAmt;
    }

    public String getMdbCode() {
        return mdbCode;
    }

    public void setMdbCode(String mdbCode) {
        this.mdbCode = mdbCode;
    }

    public String getCrmCode() {
        return crmCode;
    }

    public void setCrmCode(String crmCode) {
        this.crmCode = crmCode;
    }

    public Short getIncreaseCreditType() {
        return increaseCreditType;
    }

    public void setIncreaseCreditType(Short increaseCreditType) {
        this.increaseCreditType = increaseCreditType;
    }

    public Short getLeaseClassification() {
        return leaseClassification;
    }

    public void setLeaseClassification(Short leaseClassification) {
        this.leaseClassification = leaseClassification;
    }

    public Short getIncreaseCreditTypeDetail() {
        return increaseCreditTypeDetail;
    }

    public void setIncreaseCreditTypeDetail(Short increaseCreditTypeDetail) {
        this.increaseCreditTypeDetail = increaseCreditTypeDetail;
    }

    public BigDecimal getDivideRate() {
        return divideRate;
    }

    public void setDivideRate(BigDecimal divideRate) {
        this.divideRate = divideRate;
    }

    public String getFinalApproveSuggestion() {
        return finalApproveSuggestion;
    }

    public void setFinalApproveSuggestion(String finalApproveSuggestion) {
        this.finalApproveSuggestion = finalApproveSuggestion;
    }

    public Integer getMeetingNper() {
        return meetingNper;
    }

    public void setMeetingNper(Integer meetingNper) {
        this.meetingNper = meetingNper;
    }

    public Integer getAllNper() {
        return allNper;
    }

    public void setAllNper(Integer allNper) {
        this.allNper = allNper;
    }

    public BigDecimal getTotalCustCash() {
        return totalCustCash;
    }

    public void setTotalCustCash(BigDecimal totalCustCash) {
        this.totalCustCash = totalCustCash;
    }

    public Short getReviewConsultion() {
        return reviewConsultion;
    }

    public void setReviewConsultion(Short reviewConsultion) {
        this.reviewConsultion = reviewConsultion;
    }

    public Short getAuditOrg() {
        return auditOrg;
    }

    public void setAuditOrg(Short auditOrg) {
        this.auditOrg = auditOrg;
    }

    public Short getIfCriterionFinal() {
        return ifCriterionFinal;
    }

    public void setIfCriterionFinal(Short ifCriterionFinal) {
        this.ifCriterionFinal = ifCriterionFinal;
    }


    private Short billstatus;

    public Short getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
    }


    public String getPkProjectInfo() {
        return pkProjectInfo;
    }

    public void setPkProjectInfo(String pkProjectInfo) {
        this.pkProjectInfo = pkProjectInfo;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    public UserVO getPkPrjManager() {
        return pkPrjManager;
    }

    public void setPkPrjManager(UserVO pkPrjManager) {
        this.pkPrjManager = pkPrjManager;
    }

    public ProjectApprovalDTO getPkProjectApproval() {
        return pkProjectApproval;
    }

    public void setPkProjectApproval(ProjectApprovalDTO pkProjectApproval) {
        this.pkProjectApproval = pkProjectApproval;
    }

    public CurrtypeDTO getGrantingCurrency() {
        return grantingCurrency;
    }

    public void setGrantingCurrency(CurrtypeDTO grantingCurrency) {
        this.grantingCurrency = grantingCurrency;
    }

    public RatingMaintainBDTO getClientRating() {
        return clientRating;
    }

    public void setClientRating(RatingMaintainBDTO clientRating) {
        this.clientRating = clientRating;
    }

    public CustomerDTO getPkConsumer() {
        return pkConsumer;
    }

    public void setPkConsumer(CustomerDTO pkConsumer) {
        this.pkConsumer = pkConsumer;
    }

    public ProviderConferDTO getPkFrameworkAgreem() {
        return pkFrameworkAgreem;
    }

    public void setPkFrameworkAgreem(ProviderConferDTO pkFrameworkAgreem) {
        this.pkFrameworkAgreem = pkFrameworkAgreem;
    }

    public LimitPlanDTO getPkQuotaScheme() {
        return pkQuotaScheme;
    }

    public void setPkQuotaScheme(LimitPlanDTO pkQuotaScheme) {
        this.pkQuotaScheme = pkQuotaScheme;
    }

    public ContractRuleDTO getPkContractRule() {
        return pkContractRule;
    }

    public void setPkContractRule(ContractRuleDTO pkContractRule) {
        this.pkContractRule = pkContractRule;
    }

    public void setIfinnovate(Short ifinnovate) {
        this.ifinnovate = ifinnovate;
    }

    public UserVO getRegionManager() {
        return regionManager;
    }

    public void setRegionManager(UserVO regionManager) {
        this.regionManager = regionManager;
    }

    public DeptVO getBelongsArea() {
        return belongsArea;
    }

    public void setBelongsArea(DeptVO belongsArea) {
        this.belongsArea = belongsArea;
    }

    public UserVO getAreaManager() {
        return areaManager;
    }

    public void setAreaManager(UserVO areaManager) {
        this.areaManager = areaManager;
    }

    public Integer getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(Integer versionNum) {
        this.versionNum = versionNum;
    }

    public ParmsDTO getIndustryType() {
        return industryType;
    }

    public void setIndustryType(ParmsDTO industryType) {
        this.industryType = industryType;
    }

    public CustomerDTO getPkCustFinance() {
        return pkCustFinance;
    }

    public void setPkCustFinance(CustomerDTO pkCustFinance) {
        this.pkCustFinance = pkCustFinance;
    }

    public MemberContactDTO getPkCustMain() {
        return pkCustMain;
    }

    public void setPkCustMain(MemberContactDTO pkCustMain) {
        this.pkCustMain = pkCustMain;
    }

    public MemberContactDTO getPkCustHelp() {
        return pkCustHelp;
    }

    public void setPkCustHelp(MemberContactDTO pkCustHelp) {
        this.pkCustHelp = pkCustHelp;
    }

    public BankAccountDTO getPkAccount() {
        return pkAccount;
    }

    public void setPkAccount(BankAccountDTO pkAccount) {
        this.pkAccount = pkAccount;
    }


    public ProjectCalculatorDTO getProjectcalculatorrefvo() {
        return projectcalculatorrefvo;
    }

    public void setProjectcalculatorrefvo(ProjectCalculatorDTO projectcalculatorrefvo) {
        this.projectcalculatorrefvo = projectcalculatorrefvo;
    }

    public ProjectRentThingDTO getProjectpledgerefvo() {
        return projectpledgerefvo;
    }

    public void setProjectpledgerefvo(ProjectRentThingDTO projectpledgerefvo) {
        this.projectpledgerefvo = projectpledgerefvo;
    }

    public BusinessDomainDTO getBusinessDomain() {
        return businessDomain;
    }

    public void setBusinessDomain(BusinessDomainDTO businessDomain) {
        this.businessDomain = businessDomain;
    }

    @Override
    public String getPk() {
        return pkProjectInfo;
    }

    @Override
    public void setPk(String pk) {
        this.pkProjectInfo = pk;
    }
}
