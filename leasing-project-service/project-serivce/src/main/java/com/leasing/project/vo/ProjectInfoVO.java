package com.leasing.project.vo;

//import javax.persistence.Entity;
//import javax.persistence.Table;


import com.leasing.project.refVO.DeptdocRefVO;
import com.leasing.project.refVO.OrgRefVO;
import com.leasing.project.refVO.ProjectApprovalRefVO;
import com.leasing.project.refVO.UserRefVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OptimisticLock;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/9/25
 * @author:jiaoshy@yonyou.com
 * @description: 项目审批
 **/


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "yls_project_info")
public class ProjectInfoVO {

    public final static String PK_PROJECT_APPROVAL = "pk_project_approval";
    /**
     * 主键
     */
    @Id    //主键id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="SEQ_PROJECT_INFO")
//    @SequenceGenerator(name="SEQ_PROJECT_INFO", sequenceName="SEQ_PROJECT_INFO")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "project-id")
    @GenericGenerator(name = "project-id", strategy = "com.leasing.project.utils.IDGenerator")
    @Column(name = "pk_project_info", unique = true, nullable = false, length = 20)
    public String primaryKey;


    /**
     * 立项主键
     */
    @ManyToOne(fetch = FetchType.LAZY) //JPA注释： 一对一 关系
    @JoinColumn(name = "pk_project_approval", referencedColumnName = "pk_project_approval", nullable = false)
    public ProjectApprovalRefVO pk_project_approval;
    /**
     * 符合公司风险政策及准入标准
     */
    public Short is_fit_admittance;
    /**
     * 项目部门
     */
    @ManyToOne(fetch = FetchType.LAZY) //JPA注释： 一对一 关系
    @JoinColumn(name = "project_dept", referencedColumnName = "pk_deptdoc")
    public DeptdocRefVO project_dept;
    /**
     * 是否有共同承租人
     */
    public Short if_co_lessee;
    /**
     * 项目编号
     */
    public String project_code;
    /**
     * 项目名称
     */
    public String project_name;
    /**
     * 项目批次
     */
    public Integer project_batch;
    /**
     * 项目经理
     */
    @ManyToOne(fetch = FetchType.LAZY) //JPA注释： 一对一 关系
    @JoinColumn(name = "pkPrjManager", referencedColumnName = "pk_user")
    public UserVO pkPrjManager;
    /**
     * 项目类型
     */
    public Short project_type;
    /**
     * 项目来源
     */
    public Short project_source;
    /**
     * 回租类别
     */
    public Short leaseback_type;
    /**
     * 租赁类别
     */
    public Short lease_categry;
    /**
     * 是否投保
     */
    public Short is_insure;
    /**
     * 租赁方式
     */
    public Short lease_type;
    /**
     * 项目税种
     */
    public Short project_tax_type;
    /**
     * 预计投放日期
     */
    public String plan_release_date;
    /**
     * 项目金额
     */
    public BigDecimal release_amount;
    /**
     * 授信起始日期
     */
    public String granting_start_date;
    /**
     * 授信截止日期
     */
    public String granting_end_date;
    /**
     * 授信期限
     */
    public Integer granting_times;
    /**
     * 原授信额度(元)
     */
    public BigDecimal granting_original_limit;
    /**
     * 已用额度(元)
     */
    public BigDecimal granting_used_limit;
    /**
     * 新增额度(元)
     */
    public BigDecimal granting_add_limit;
    /**
     * 可用额度(元)
     */
    public BigDecimal granting_surplus_limit;

//    public String pk_project_approval;
    /**
     * 授信币种
     */
//    public CurrtypeRefVO granting_currency;
    /**
     * 授信类型
     */
    public Short granting_type;
    /**
     * 客户评级
     */
//    public RatingMaintainBRefVO client_rating;
    /**
     * 客户主键
     */
//    public CustomerRefVO pk_consumer;
    /**
     * 供应商框架协议主键
     */
//    public ProviderConferRefVO pk_framework_agreem;
    /**
     * 供应商限额方案主键
     */
//    public LimitPlanRefVO pk_quota_scheme;
    /**
     * 供应商限额结果
     */
    public String quota_result;
    /**
     * 设备金额
     */
    public BigDecimal purchase_total_amount;
    /**
     * 客户财务相关
     */
    public String finance_note;
    /**
     * 设备相关
     */
    public String device_note;
    /**
     * 客户其他部门
     */
    public String cus_other_dept_note;
    /**
     * 政府相关
     */
    public String gov_note;
    /**
     * 政府财政相关
     */
    public String gov_finance_note;
    /**
     * 政府其他部门
     */
    public String gov_other_dept_note;
    /**
     * 保险费
     */
    public BigDecimal premium;
    /**
     * 公证费比例
     */
    public BigDecimal notarial_fees_rate;
    /**
     * 审批文档生成规则
     */
//    public ContractRuleRefVO pk_contract_rule;
    /**
     * 保证方式
     */
    public Short assure_type;
    /**
     * 项目审批审批结果
     */
    public Short project_approve_result;
    /**
     * 项目审批审批日期
     */
    public String project_approve_date;
    /**
     * 审批结果描述
     */
    public String project_approve_note;

    /** INSERT  【 sunlk】 【2018年7月12日】 【BUG修改】<BUG号-ZJTSIQI-14> 普通项目审批/普通项目审批变更/普通项目审批复议/过审项目审批查询节点，添加 是否跨境业务，是否孵化及创新业务，是否关联交易方三个字段，枚举值是，否*/
    /**
     * 是否跨境业务
     */
    public Short ifCrossborder;
    /**
     * 是否孵化及创新业务
     */
    public Short ifInnovate;
    /**
     * 是否关联交易方
     */
    public Short ifRelation;
    /**END*/

    /**
     * 变更类型
     */
    public Short change_type;
    /**
     * 变更原因
     */
    public String change_reason;
    /**
     * 调息对象
     */
    public Short interest_adjustments;
    /**
     * 项目状态
     */
    public Short project_status;
    /**
     * 资金渠道
     */
    public Short funding_sources;
    /**
     * 交易框架
     */
    public Short trading_schemes;
    /**
     * 大区经理
     */
//    public UserRefVO region_manager;
    /**
     * 所属片区
     */
//    public DeptdocRefVO belongs_area;
    /**
     * 片区经理
     */
//    public UserRefVO area_manager;
    /**
     * 版本号
     */
    @Column(name = "version_num")
    public Integer version_num;
    /**
     * 是否最新
     */
    public Short if_new;
    /**
     * 租赁最大期限
     */
    public Integer max_deadline;
    /**
     * 项目分类
     */
    public Short project_sort;

    /*
     * =========================================================
     * 2014年改版增加的字段,需求陈秀丽
     * =========================================================
     */
    /**
     * 确认业务领域
     */
//    public ParmsRefVO industry_type;
    /**
     * 客户号
     */
    public String customer_no;
    /**
     * 资金用途
     */
    public String capital_use;
    /**
     * 是否项目合同一一对应
     */
    public Short is_onetoone;
    /**
     * 实际融资客户
     */
//    public CustomerRefVO pk_cust_finance;
    /**
     * 是否预约资金
     */
    public Short is_precapital;
    /**
     * 项目主办人
     */
//    public MemberContactRefVO pk_cust_main;
    /**
     * 项目协办人
     */
//    public MemberContactRefVO pk_cust_help;
    /**
     * 项目主账户
     */
//    public BankAccountRefVO pk_account;
    /**
     * 授信分类
     */
    public Short limit_class;
    /**
     * 本次授信额度
     */
    public BigDecimal limit_amt;
    /**
     * 是否调息
     */
    public Short if_adjust;
    /**
     * 调息类别 0-系统 1-手工
     */
    public Short adjust_type;
    /**
     * 调息时点
     */
    public Short adjust_time;
    /**
     * 调息相应方式
     */
    public Short adjust_method;
    /**
     * 调息起始日
     */
    public String adjust_start_date;
    /**
     * 承租人权重
     */
    public BigDecimal lessee_weight;
    /**
     * 客户权限
     */
    public BigDecimal customer_weight;
    /**
     * 是否允许提前还款
     */
    public Short is_canrefund;
    /**
     * 提前还款期限
     */
    public Integer refund_times;
    /**
     * 提前还款手续费率(%)
     */
    public BigDecimal refund_rate;

    /**
     * 项目主表参照的报价信息
     */
//    public ProjectCalculatorRefVO projectCalculatorRefVO;
    /**
     * 项目主表参照担保信息
     */
//    public ProjectPledgeRefVO projectPledgeRefVO;
    /**
     * 项目主表参照租赁物信息
     */
//    public ProjectRentThingRefVO projectRentThingRefVO;

    public String ts;

    /**
     * 单据状态
     */
    public Short billstatus;
    /**
     * 操作人
     */
//    public UserRefVO pk_operator;
    /**
     * 操作日期
     */
    public String operate_date;
    /**
     * 操作时间
     */
    public String operate_time;
    /**
     * 复核人
     */
//    public UserRefVO pk_checker;
    /**
     * 复核日期
     */
    public String check_date;
    /**
     * 复核时间
     */
    public String check_time;
    /**
     * 授权人
     */
//    public UserRefVO pk_grantor;
    /**
     * 授权日期
     */
    public String grant_date;
    /**
     * 授权时间
     */
    public String grant_time;
    /**
     * 机构
     */
    @ManyToOne(fetch = FetchType.LAZY) //JPA注释： 一对一 关系
    @JoinColumn(name = "pk_org", referencedColumnName = "pk_org")
    public OrgRefVO pk_org;
    /**
     * 所属公司
     */
//    public OrgRefVO pk_pro_org;
    /**
     * 部门
     */
//    public DeptdocRefVO pk_dept;
    /**
     * 供应商信息
     */
//    public List<ProviderAbstractVO> provider;
    /**
     * 项目来源信息
     */
//    public List<ContSourceVO> source;
    /**
     * 共同承租人
     */
//    public List<ProjectBothLesseeVO> bothLessee;
    /**
     * 租赁物件
     */
//    public List<RentThingAbstractVO> rentThing;
    /**
     * 账户信息
     */
//    public List<ProjectAccountVO> account;
    /**
     * 起租条件
     */
//    public List<RentConditionVO> rentCondition;
    /**
     * 付款条件
     */
//    public List<PaymentConditionVO> paymentCondition;
    /**
     * 罚息规则设置
     */
//    public List<PenaltyRuleDetailPrjInfoVO> penaltyRuleDetai;

    /**
     * 更新客户信息
     */
    @Transient
    public boolean updateCustomer;

    /**
     * 约定固定起租日
     */
    public String appoint_rent_date;

    /**
     * 让利方式
     */
    public Short benefit_method;
    /**
     * 宽限天数
     */
    public Integer grace_days;
    /**
     * 建议日扣减金额
     */
    public BigDecimal suggest_deduct_amt;
    /**
     * 约定日扣减金额
     */
    public BigDecimal appoint_deduct_amt;

    /**
     * @usage 201403聚信增加
     * @description 主数据编码
     */
    public String mdb_code;

    /**
     * @usage 201406聚信增加
     * @description 主数据编码
     */
    public String crm_code;

    /**
     * 租赁物分类
     */
    public Short increase_credit_type;

    /**
     * 增信措施类别
     */
    public Short lease_classification;

    /**
     * 增信分类措施分类明细
     */
    public Short increase_credit_type_detail;

    /**
     * 20160128
     * add by lihongjian
     * 分成租赁
     * 分成比例
     */

    public BigDecimal divide_rate;

    /**
     * 最终审批结果
     */
    public String final_approve_suggestion;


    /**
     * INSERT  【wangxy】 【2016-12-8】 【项目审批报告】<会议期数>
     */
    public Integer meetingnper;

    public Integer allnper;

    /**
     * add by jiaoshy
     * 当前客户未偿还租金总额
     * 2018-06-15
     *
     * @return
     */
    public BigDecimal total_cust_cash;
    /*add end*/

    /**
     * add by jiaoshy
     * 评审结论
     * 2018-06-15
     *
     * @return
     */
    public Short review_consultion;
    /*add end*/

    public Short audit_org;


    /**
     * 是否准入政策
     * add by jiaoshy 自动审批
     */
    public Short if_criterion_final;

//    public String getPk_project_info() {
//        return pk_project_info;
//    }
//
//    public void setPk_project_info(String pk_project_info) {
//        this.pk_project_info = pk_project_info;
//    }

    public Short getIs_fit_admittance() {
        return is_fit_admittance;
    }

    public void setIs_fit_admittance(Short is_fit_admittance) {
        this.is_fit_admittance = is_fit_admittance;
    }

    public Short getIf_co_lessee() {
        return if_co_lessee;
    }

    public void setIf_co_lessee(Short if_co_lessee) {
        this.if_co_lessee = if_co_lessee;
    }

    public String getProject_code() {
        return project_code;
    }

    public void setProject_code(String project_code) {
        this.project_code = project_code;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public Integer getProject_batch() {
        return project_batch;
    }

    public void setProject_batch(Integer project_batch) {
        this.project_batch = project_batch;
    }

    public Short getProject_type() {
        return project_type;
    }

    public void setProject_type(Short project_type) {
        this.project_type = project_type;
    }

    public Short getProject_source() {
        return project_source;
    }

    public void setProject_source(Short project_source) {
        this.project_source = project_source;
    }

    public Short getLeaseback_type() {
        return leaseback_type;
    }

    public void setLeaseback_type(Short leaseback_type) {
        this.leaseback_type = leaseback_type;
    }

    public Short getLease_categry() {
        return lease_categry;
    }

    public void setLease_categry(Short lease_categry) {
        this.lease_categry = lease_categry;
    }

    public Short getIs_insure() {
        return is_insure;
    }

    public void setIs_insure(Short is_insure) {
        this.is_insure = is_insure;
    }

    public Short getLease_type() {
        return lease_type;
    }

    public void setLease_type(Short lease_type) {
        this.lease_type = lease_type;
    }

    public Short getProject_tax_type() {
        return project_tax_type;
    }

    public void setProject_tax_type(Short project_tax_type) {
        this.project_tax_type = project_tax_type;
    }

    public String getPlan_release_date() {
        return plan_release_date;
    }

    public void setPlan_release_date(String plan_release_date) {
        this.plan_release_date = plan_release_date;
    }

    public BigDecimal getRelease_amount() {
        return release_amount;
    }

    public void setRelease_amount(BigDecimal release_amount) {
        this.release_amount = release_amount;
    }

    public String getGranting_start_date() {
        return granting_start_date;
    }

    public void setGranting_start_date(String granting_start_date) {
        this.granting_start_date = granting_start_date;
    }

    public String getGranting_end_date() {
        return granting_end_date;
    }

    public void setGranting_end_date(String granting_end_date) {
        this.granting_end_date = granting_end_date;
    }

    public Integer getGranting_times() {
        return granting_times;
    }

    public void setGranting_times(Integer granting_times) {
        this.granting_times = granting_times;
    }

    public BigDecimal getGranting_original_limit() {
        return granting_original_limit;
    }

    public void setGranting_original_limit(BigDecimal granting_original_limit) {
        this.granting_original_limit = granting_original_limit;
    }

    public BigDecimal getGranting_used_limit() {
        return granting_used_limit;
    }

    public void setGranting_used_limit(BigDecimal granting_used_limit) {
        this.granting_used_limit = granting_used_limit;
    }

    public BigDecimal getGranting_add_limit() {
        return granting_add_limit;
    }

    public void setGranting_add_limit(BigDecimal granting_add_limit) {
        this.granting_add_limit = granting_add_limit;
    }

    public BigDecimal getGranting_surplus_limit() {
        return granting_surplus_limit;
    }

    public void setGranting_surplus_limit(BigDecimal granting_surplus_limit) {
        this.granting_surplus_limit = granting_surplus_limit;
    }

    public Short getGranting_type() {
        return granting_type;
    }

    public void setGranting_type(Short granting_type) {
        this.granting_type = granting_type;
    }

    public String getQuota_result() {
        return quota_result;
    }

    public void setQuota_result(String quota_result) {
        this.quota_result = quota_result;
    }

    public BigDecimal getPurchase_total_amount() {
        return purchase_total_amount;
    }

    public void setPurchase_total_amount(BigDecimal purchase_total_amount) {
        this.purchase_total_amount = purchase_total_amount;
    }

    public String getFinance_note() {
        return finance_note;
    }

    public void setFinance_note(String finance_note) {
        this.finance_note = finance_note;
    }

    public String getDevice_note() {
        return device_note;
    }

    public void setDevice_note(String device_note) {
        this.device_note = device_note;
    }

    public String getCus_other_dept_note() {
        return cus_other_dept_note;
    }

    public void setCus_other_dept_note(String cus_other_dept_note) {
        this.cus_other_dept_note = cus_other_dept_note;
    }

    public String getGov_note() {
        return gov_note;
    }

    public void setGov_note(String gov_note) {
        this.gov_note = gov_note;
    }

    public String getGov_finance_note() {
        return gov_finance_note;
    }

    public void setGov_finance_note(String gov_finance_note) {
        this.gov_finance_note = gov_finance_note;
    }

    public String getGov_other_dept_note() {
        return gov_other_dept_note;
    }

    public void setGov_other_dept_note(String gov_other_dept_note) {
        this.gov_other_dept_note = gov_other_dept_note;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public BigDecimal getNotarial_fees_rate() {
        return notarial_fees_rate;
    }

    public void setNotarial_fees_rate(BigDecimal notarial_fees_rate) {
        this.notarial_fees_rate = notarial_fees_rate;
    }

    public Short getAssure_type() {
        return assure_type;
    }

    public void setAssure_type(Short assure_type) {
        this.assure_type = assure_type;
    }

    public Short getProject_approve_result() {
        return project_approve_result;
    }

    public void setProject_approve_result(Short project_approve_result) {
        this.project_approve_result = project_approve_result;
    }

    public String getProject_approve_date() {
        return project_approve_date;
    }

    public void setProject_approve_date(String project_approve_date) {
        this.project_approve_date = project_approve_date;
    }

    public String getProject_approve_note() {
        return project_approve_note;
    }

    public void setProject_approve_note(String project_approve_note) {
        this.project_approve_note = project_approve_note;
    }

    public Short getIfCrossborder() {
        return ifCrossborder;
    }

    public void setIfCrossborder(Short ifCrossborder) {
        this.ifCrossborder = ifCrossborder;
    }

    public Short getIfInnovate() {
        return ifInnovate;
    }

    public void setIfInnovate(Short ifInnovate) {
        this.ifInnovate = ifInnovate;
    }

    public Short getIfRelation() {
        return ifRelation;
    }

    public void setIfRelation(Short ifRelation) {
        this.ifRelation = ifRelation;
    }

    public Short getChange_type() {
        return change_type;
    }

    public void setChange_type(Short change_type) {
        this.change_type = change_type;
    }

    public String getChange_reason() {
        return change_reason;
    }

    public void setChange_reason(String change_reason) {
        this.change_reason = change_reason;
    }

    public Short getInterest_adjustments() {
        return interest_adjustments;
    }

    public void setInterest_adjustments(Short interest_adjustments) {
        this.interest_adjustments = interest_adjustments;
    }

    public Short getProject_status() {
        return project_status;
    }

    public void setProject_status(Short project_status) {
        this.project_status = project_status;
    }

    public Short getFunding_sources() {
        return funding_sources;
    }

    public void setFunding_sources(Short funding_sources) {
        this.funding_sources = funding_sources;
    }

    public Short getTrading_schemes() {
        return trading_schemes;
    }

    public void setTrading_schemes(Short trading_schemes) {
        this.trading_schemes = trading_schemes;
    }

    public Integer getVersion_num() {
        return version_num;
    }

    public void setVersion_num(Integer version_num) {
        this.version_num = version_num;
    }

    public Short getIf_new() {
        return if_new;
    }

    public void setIf_new(Short if_new) {
        this.if_new = if_new;
    }

    public Integer getMax_deadline() {
        return max_deadline;
    }

    public void setMax_deadline(Integer max_deadline) {
        this.max_deadline = max_deadline;
    }

    public Short getProject_sort() {
        return project_sort;
    }

    public void setProject_sort(Short project_sort) {
        this.project_sort = project_sort;
    }

    public String getCustomer_no() {
        return customer_no;
    }

    public void setCustomer_no(String customer_no) {
        this.customer_no = customer_no;
    }

    public String getCapital_use() {
        return capital_use;
    }

    public void setCapital_use(String capital_use) {
        this.capital_use = capital_use;
    }

    public Short getIs_onetoone() {
        return is_onetoone;
    }

    public void setIs_onetoone(Short is_onetoone) {
        this.is_onetoone = is_onetoone;
    }

    public Short getIs_precapital() {
        return is_precapital;
    }

    public void setIs_precapital(Short is_precapital) {
        this.is_precapital = is_precapital;
    }

    public Short getLimit_class() {
        return limit_class;
    }

    public void setLimit_class(Short limit_class) {
        this.limit_class = limit_class;
    }

    public BigDecimal getLimit_amt() {
        return limit_amt;
    }

    public void setLimit_amt(BigDecimal limit_amt) {
        this.limit_amt = limit_amt;
    }

    public Short getIf_adjust() {
        return if_adjust;
    }

    public void setIf_adjust(Short if_adjust) {
        this.if_adjust = if_adjust;
    }

    public Short getAdjust_type() {
        return adjust_type;
    }

    public void setAdjust_type(Short adjust_type) {
        this.adjust_type = adjust_type;
    }

    public Short getAdjust_time() {
        return adjust_time;
    }

    public void setAdjust_time(Short adjust_time) {
        this.adjust_time = adjust_time;
    }

    public Short getAdjust_method() {
        return adjust_method;
    }

    public void setAdjust_method(Short adjust_method) {
        this.adjust_method = adjust_method;
    }

    public String getAdjust_start_date() {
        return adjust_start_date;
    }

    public void setAdjust_start_date(String adjust_start_date) {
        this.adjust_start_date = adjust_start_date;
    }

    public BigDecimal getLessee_weight() {
        return lessee_weight;
    }

    public void setLessee_weight(BigDecimal lessee_weight) {
        this.lessee_weight = lessee_weight;
    }

    public BigDecimal getCustomer_weight() {
        return customer_weight;
    }

    public void setCustomer_weight(BigDecimal customer_weight) {
        this.customer_weight = customer_weight;
    }

    public Short getIs_canrefund() {
        return is_canrefund;
    }

    public void setIs_canrefund(Short is_canrefund) {
        this.is_canrefund = is_canrefund;
    }

    public Integer getRefund_times() {
        return refund_times;
    }

    public void setRefund_times(Integer refund_times) {
        this.refund_times = refund_times;
    }

    public BigDecimal getRefund_rate() {
        return refund_rate;
    }

    public void setRefund_rate(BigDecimal refund_rate) {
        this.refund_rate = refund_rate;
    }

    public Short getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
    }

    public String getOperate_date() {
        return operate_date;
    }

    public void setOperate_date(String operate_date) {
        this.operate_date = operate_date;
    }

    public String getOperate_time() {
        return operate_time;
    }

    public void setOperate_time(String operate_time) {
        this.operate_time = operate_time;
    }

    public String getCheck_date() {
        return check_date;
    }

    public void setCheck_date(String check_date) {
        this.check_date = check_date;
    }

    public String getCheck_time() {
        return check_time;
    }

    public void setCheck_time(String check_time) {
        this.check_time = check_time;
    }

    public String getGrant_date() {
        return grant_date;
    }

    public void setGrant_date(String grant_date) {
        this.grant_date = grant_date;
    }

    public String getGrant_time() {
        return grant_time;
    }

    public void setGrant_time(String grant_time) {
        this.grant_time = grant_time;
    }

    public boolean isUpdateCustomer() {
        return updateCustomer;
    }

    public void setUpdateCustomer(boolean updateCustomer) {
        this.updateCustomer = updateCustomer;
    }

    public String getAppoint_rent_date() {
        return appoint_rent_date;
    }

    public void setAppoint_rent_date(String appoint_rent_date) {
        this.appoint_rent_date = appoint_rent_date;
    }

    public Short getBenefit_method() {
        return benefit_method;
    }

    public void setBenefit_method(Short benefit_method) {
        this.benefit_method = benefit_method;
    }

    public Integer getGrace_days() {
        return grace_days;
    }

    public void setGrace_days(Integer grace_days) {
        this.grace_days = grace_days;
    }

    public BigDecimal getSuggest_deduct_amt() {
        return suggest_deduct_amt;
    }

    public void setSuggest_deduct_amt(BigDecimal suggest_deduct_amt) {
        this.suggest_deduct_amt = suggest_deduct_amt;
    }

    public BigDecimal getAppoint_deduct_amt() {
        return appoint_deduct_amt;
    }

    public void setAppoint_deduct_amt(BigDecimal appoint_deduct_amt) {
        this.appoint_deduct_amt = appoint_deduct_amt;
    }

    public String getMdb_code() {
        return mdb_code;
    }

    public void setMdb_code(String mdb_code) {
        this.mdb_code = mdb_code;
    }

    public String getCrm_code() {
        return crm_code;
    }

    public void setCrm_code(String crm_code) {
        this.crm_code = crm_code;
    }

    public Short getIncrease_credit_type() {
        return increase_credit_type;
    }

    public void setIncrease_credit_type(Short increase_credit_type) {
        this.increase_credit_type = increase_credit_type;
    }

    public Short getLease_classification() {
        return lease_classification;
    }

    public void setLease_classification(Short lease_classification) {
        this.lease_classification = lease_classification;
    }

    public Short getIncrease_credit_type_detail() {
        return increase_credit_type_detail;
    }

    public void setIncrease_credit_type_detail(Short increase_credit_type_detail) {
        this.increase_credit_type_detail = increase_credit_type_detail;
    }

    public BigDecimal getDivide_rate() {
        return divide_rate;
    }

    public void setDivide_rate(BigDecimal divide_rate) {
        this.divide_rate = divide_rate;
    }

    public String getFinal_approve_suggestion() {
        return final_approve_suggestion;
    }

    public void setFinal_approve_suggestion(String final_approve_suggestion) {
        this.final_approve_suggestion = final_approve_suggestion;
    }

    public Integer getMeetingnper() {
        return meetingnper;
    }

    public void setMeetingnper(Integer meetingnper) {
        this.meetingnper = meetingnper;
    }

    public Integer getAllnper() {
        return allnper;
    }

    public void setAllnper(Integer allnper) {
        this.allnper = allnper;
    }

    public BigDecimal getTotal_cust_cash() {
        return total_cust_cash;
    }

    public void setTotal_cust_cash(BigDecimal total_cust_cash) {
        this.total_cust_cash = total_cust_cash;
    }

    public Short getReview_consultion() {
        return review_consultion;
    }

    public void setReview_consultion(Short review_consultion) {
        this.review_consultion = review_consultion;
    }

    public Short getAudit_org() {
        return audit_org;
    }

    public void setAudit_org(Short audit_org) {
        this.audit_org = audit_org;
    }

    public Short getIf_criterion_final() {
        return if_criterion_final;
    }

    public void setIf_criterion_final(Short if_criterion_final) {
        this.if_criterion_final = if_criterion_final;
    }

    public ProjectApprovalRefVO getPk_project_approval() {
        return pk_project_approval;
    }

    public void setPk_project_approval(ProjectApprovalRefVO pk_project_approval) {
        this.pk_project_approval = pk_project_approval;
    }

    public DeptdocRefVO getProject_dept() {
        return project_dept;
    }

    public void setProject_dept(DeptdocRefVO project_dept) {
        this.project_dept = project_dept;
    }

    public UserRefVO getPk_prj_manager() {
        return pk_prj_manager;
    }

    public void setPk_prj_manager(UserRefVO pk_prj_manager) {
        this.pk_prj_manager = pk_prj_manager;
    }


    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public OrgRefVO getPk_org() {
        return pk_org;
    }

    public void setPk_org(OrgRefVO pk_org) {
        this.pk_org = pk_org;
    }
}
