package com.leasing.common.enums.constant;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:来源单据类型常量类
 **/
public class SourcebillTypeConstant {
    /**
     * 项目申请
     */
    public final static String PROJECT_APPROVAL = "lease/ProjectApproval";

    /**
     * 项目审批
     */
    public final static String PROJECT_INFO = "lease/ProjectInfo";

    /**
     * 项目合同
     */
    public final static String PROJECT_CONTRACT = "lease/Contract";

    /**
     * 合同台账查询
     */
    public final static String PROJECT_CONTRACTC = "lease/ContractC";
    /**
     * 项目来源
     */
    public final static String PROJECT_SOURCE = "lease/ProjectSource";
    /**
     * 总承租人项目审批
     */
    public final static String PROJECT_GROUP ="lease/GroupProjectInfo";
    /**
     * 总承租人子合同制作
     */
    public final static String PROJECT_LESSEESUBCONTRACTOR="lease/LesseeContract";
    /**
     * 供应商合作协议审批
     */
    public final static String PROJECT_SUPPLIERAPPROVA="lease/SupplierPrjInfo";
    /**
     * 供应商合作协议审批(子表:厂方负责人)
     */
    public final static String PROJECT_SUPPAPPRLEASEELEADER="lease/SuppApprLeaseeLeader";
    /**
     * 供应商合作协议审批(子表:项目负责人)
     */
    public final static String PROJECT_SUPPAPPRPROJECTLEADER = "lease/SuppApprProjectLeader";
    /**
     * 联系人负责人类型,项目负责人.
     */
    public final static String PROJECT_LEADER = "PROJECT_LEADER";

    /**
     * 联系人负责人类型,承租方负责人.
     */
    public final static String LEASE_LEADER = "LEASE_LEADER";

    /**
     * 供应商合作协议制作(合同模块)
     */
    public final static String PROVIDER_CONFER="lease/ContractSupplier";

    /**
     * 共同承租人
     */
    public final static String BOTH_LESSEE="lease/ProjectBothLessee";

    /**
     * 供应商
     */
    public final static String PROVIDER_ABSTRACT = "lease/ProviderAbstract";
    /**
     * 承租人授信
     */
    public final static String LIMIT_LESSEE="lease/LimitLessee";

    /**
     * 报价测算（规则）
     */
    public final static String BILLTYPE_CALCULATOR = "lease/LeaseCalculator";
    /**
     * 报价测算（快速）
     */
    public final static String BILLTYPE_CALCULATORNORMAL = "lease/LeaseCalculatorNormal";
    /**
     * 不规则测算
     */
    public final static String BILLTYPE_CALCULATORIRREGULAR = "lease/LeaseCalculatorIrregular";
    /**
     * 综合测算
     */
    public final static String BILLTYPE_CALCULATORCOMPLEX = "lease/LeaseCalculatorComplex";

    /**
     * 费率测算
     */
    public final static String BILLTYPE_RATECALCULATOR = "lease/RateCalculator";

    /**
     * 资金成本测算（流动资金）
     */
    public final static String BILLTYPE_FLOWCAPITALCALCULATOR = "lease/FlowCapitalCalculator";

    /**
     * 资金成本测算（项目保理）
     */
    public final static String BILLTYPE_PRJCAPITALCALCULATOR = "lease/PrjCapitalCalculator";

    /**
     * 提款管理（流动资金）
     */
    public final static String BILLTYPE_FLOWWITHDRAWMANAGER = "lease/FlowWithdrawManager";

    /**
     * 提款管理（项目保理）
     */
    public final static String BILLTYPE_PRJWITHDRAWMANAGER = "lease/PrjWithdrawManager";

    /**
     * 起租变更（付款管理）
     */
    public final static String BILLTYPE_BEGINRENT_ALTER = "lease/BeginRentAlter";

    /**
     * 付款处理核销
     */
    public final static String BILLTYPE_LOANDEAL = "lease/LoanDeal";

    /**
     * 提醒设置
     */
    public final static String BILLTYPE_REMINDSET = "lease/RemindSet";

    /**
     * 收款提醒(短信)
     */
    public final static String BILLTYPE_GAHTERREMIND = "lease/GatherRemind";

    /**
     * 收款提醒(通知函)
     */
    public final static String BILLTYPE_GAHTERREMIND_NOTICE = "lease/GatherRemindNotice";

    /**
     * 收款提醒(邮件)
     */
    public final static String BILLTYPE_GAHTERREMIND_MAIL = "lease/GatherRemindMail";
    /**
     * 融资格式文本法审(附件)
     */
    public final static String BILLTYPE_CONT_LAW = "CAPITAL_CONT";
    /**
     * 资金合同审批(附件)
     */
    public final static String BILLTYPE_CONT_APPROVE = "CAPITAL_APPROVE";


    /**
     * 逾期催收(短信)
     */
    public final static String BILLTYPE_OVERDUEREMIND = "lease/OverdueRemind";

    /**
     * 逾期催收(通知函)
     */
    public final static String BILLTYPE_OVERDUEREMIND_NOTICE = "lease/OverdueRemindNotice";

    /**
     * 逾期催收(邮件)
     */
    public final static String BILLTYPE_OVERDUEREMIND_MAIL = "lease/OverdueRemindMail";

    /**
     * 客户评级
     */
    public final static String BILLTYPE_CUST_RATING = "lease/CustomerRating";

    /**
     * 调息申请
     */
    public final static String BILLTYPE_ADJUSTAPPLY = "/rent/AdjustApply";

    /**
     * 罚息设置明细
     */
    public final static String PENALTY_RULE = "lease/PenaltyRule";
    /**
     * 费率测算器（主表）
     */
    public final static String RATECALCULATOR="calc/PateCalculator";

    /**
     * 费率调息
     */
    public final static String ADJUSTAPPLYRATE="rent/AdjustApplyRate";

    /**
     * 定期单个资产风险分类评定
     */
    public final static String RISK_EVALUATE_SINGLE="lease/RiskEvaluateSingle";

    /**
     * 定期单个资产风险分类评定
     */
    public final static String RISK_EVALUATE="lease/RiskEvaluate";

    /**
     * 定期单个资产风险分类评定
     */
    public final static String RISK_EVALUATE_NOFIXED="lease/RiskEvaluateNofixed";

    /**
     * 资产风险分类评定最终审批
     */
    public final static String RISK_EVALUATE_FINAL ="lease/RiskEvaluateFinal";

    /**
     * 租后报价测算
     */
    public final static String RENT_CALCULATOR = "lease/RentCalculator";

    /**
     * 租赁资产转移
     */
    public final static String LEASE_ATTACHMENT = "rent/LeaseAttachment";

    /**
     * 合同变更审核
     */
    public final static String CONTRACTCHANGE = "lease/ContractChange";

    //[合同变更-合同信息更正] wangjj@2016/05/12 ADD START
    /**
     * 合同信息更正
     */
    public final static String CONTRACTINFOCHANGE="lease/ContractInfoChange";
    //[合同变更-合同信息更正] wangjj@2016/05/12 ADD END


    /**
     * 外币租金表重算
     */
    public final static String CONTRACTFOREIGN = "lease/ContractForeign";

    /**
     * 提前还款
     */
    public final static String CONTRACTPREPAYMENT = "lease/ContractPrepayment";

    /**
     * 保证金变更
     */
    public final static String CONTRACTMARGIN = "lease/ContractMargin";

    /**
     * 合同撤销审核
     */
    public final static String CONTRACTREVOKE = "lease/ContractRevoke";

    /**
     * 租赁物管理-保险信息维护
     */
    public final static String RENT_PROJECTINSUREH = "rent/ProjectInsureH";

    /**
     * 逾期管理 - 逾期处理
     */
    public final static String RENT_PENALTYPROCESS = "rent/PenaltyProcess";

    /**
     * 逾期管理 - 逾期记录
     */
    public final static String RENT_OVERDUERECORD = "lease/OverdueRecord";

    /**
     * 合同供应商
     */
    public final static String CONTPROVIDER = "lease/ContProvider";

    /**
     * 代付账户设置
     */
    public final static String AGENTPAYACCOUNTSET = "lease/AgentpayAccountSet";

    /**
     * 会议安排
     */
    public final static String MEETINGARRANGE = "lease/MeetingArrange";

    /**
     * 评审会议
     */
    public final static String MEETING_REVIEW ="lease/MeetingReview";

    /**
     * 代付账户设置(合同等功能的子表节点)
     */
    public final static String AGENTPAYACCOUNTSINGLESET = "lease/AgentpayAccountSingleSet";

    /**
     * 手工到账
     */
    public final static String GATHER_PLAN_HAND = "lease/GatherPlanHand";

    /**
     * 调息确认
     */
    public final static String BILLTYPE_PRAVOUCHER = "rent/praVoucher";

    /**
     * 单位客户
     */
    public final static String CUSTOMER_CORP = "lease/CustomerCorp";

    /**
     * 自然人客户
     */
    public final static String CUSTOMER_PERSON = "lease/CustomerPerson";
    /**
     * 授信信息维护
     */
    public final static String FINANCING_CREDIT = "rent/FinancingCredit";

    /**
     * 起租（付款管理）
     */
    public final static String BILLTYPE_BEGINRENT_STATUS = "lease/BeginRentStatus";

    /**
     * 核销审核(收款)
     */
    public final static String GATHERAUDIT = "lease/GatherAudit";

    /**
     * 付款核销
     */
    public final static String LOANVERIFICATION = "lease/LoanVerification";

    /**
     * 税额调整
     */
    public final static String ADJUST_TAX = "lease/AdjustTax";

    /**
     * 巡检报告制作
     */
    public final static String RENT_ROUTING_REPORT="lease/RentRoutingReport";

    /**
     * 协议变更
     */
    public final static String PROTOCOLCHANGE = "lease/ProtocolChange";

    /**
     * 提前结清
     */
    public final static String CONT_ADVANCE_END = "lease/ContractAdvanceEnd";

    /**
     * 总承租人合作协议
     */
    public final static String PROTOCOL = "lease/LesseeProtocol";

    /**
     * 追加收益合同变更
     */
    public final static String CONTRACTADDITIONALCHANGE = "lease/cont_change/contractAdditionalChange";

    /**
     * 追加收益合同变更
     */
    public final static String CONTRACTADDITIONAL = "lease/ContractAdditional";


    //[投资-购买] wangjj@2016/08/19 ADD START
    /**
     * 产品购买
     */
    public final static String INVEST_BUY = "lease/InvestBuy";
    //[投资-购买] wangjj@2016/08/19 ADD END


    /**[会计IRR重算] @2016年10月20日 @wangjj start*/

    /**
     * 会计IRR重算
     */
    public final static String FINANCE_IRR_RECAL="lease/FinanceIRRReCal";
    /**[会计IRR重算] @2016年10月20日 @wangjj end*/

    /**ADD WJJ 2016/11/08 ADD START*/
    /**
     * 提前还款
     */
    public final static String LEASE_REFUND = "lease/Refund";
    /**ADD END*/

    /** INSERT  【wangxy】 【2017-4-1】 【BUG修改】<批量合同结清> */
    public final static String CONTRACTBATCHSETTLE = "lease/ContractBatchSettle";
    /** INSERT  END */

    /** INSERT  【chenxc】 【2017年7月17日】 【保理逾期管理】<增加合同类型常量> */
    /**
     * 保理合同
     */
    public final static String FACTORING_CONTRACT = "factoring/FactoringContract";
    /** INSERT  END */

    /**
     * 资金 月末计提
     */
    public final static String BILL_CAPITALACCRUE = "lease/CapitalAccrueEomday";

    /**
     * 租赁 月末计提（电信）
     */
    public final static String BILL_TELACCRUE = "las/leaseAccrued";

    public final static String BILL_NONTELACCRUE = "las/leaseAccruedNonTele";
}