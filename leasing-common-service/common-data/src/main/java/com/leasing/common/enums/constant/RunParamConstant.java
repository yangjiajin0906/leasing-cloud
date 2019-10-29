package com.leasing.common.enums.constant;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:运行参数类别常量类
 **/
public class RunParamConstant {
    /**
     * IRR年计算天数
     */
    public static final String YEAR_DAYS_IRR = "000001";

    /**
     * 现金流量年计算天数
     */
    public static final String YEAR_DAYS_FLOW = "000002";

    /**
     * 补差利息处理方式
     */
    public static final String REVERSE_INTEREST_METHOD = "000003";

    /**
     * 复利方式
     */
    public static final String INTERREST_METHOD = "000004";

    /**
     * 计算租金每期所占比例(半年)
     */
    public static final String RADIO_HYEAR = "000005";

    /**
     * 最后一期金额调整规则
     */
    public static final String LAST_TERM_RULE = "000006";

    /**
     * 首付款是否参与期次排序
     */
    public static final String FIRST_CASH_IFSORT = "000007";

    /**
     * 计算比例基数
     */
    public static final String CAL_RATIO_BASE = "000008";

    /**
     * 是否控制数据权限
     */
    public static final String IF_DATA_POWER = "000009";

    /**
     * 数据权限控制范围，对于一个用户多角色而言
     */
    public static final String DATA_POWER_SCOPE = "000010";

    /**
     * 租金计划表是显示会计表还是市场表
     */
    public static final String IF_FIN_MARKET = "000011";

    /**
     * 是否需要立项流程
     */
    public static final String NEED_APPROVAL = "000012";

    /**
     * 是否需要立项文档
     */
    public static final String NEED_APPROVAL_DOC = "000016";

    /**
     * 本金为负是否调整为0
     */
    public static final String CORPUS_ADJUST_ZERO = "000014";

    /**
     * 不规则测算本金法计算方式
     */
    public static final String CORPUS_WAY = "000015";
    /**
     * 是否生成授信报告
     */
    public static final String IF_LIMIT_REPORT="000017";
    /**
     * 供应商合作协议是否需要项目主办方
     */
    public static final String IF_SUPPLIER_APPROVAL_HOST = "000018";
    /**
     * 供应商合作协议是否需要厂商主要联系人
     */
    public static final String IF_SUPPLIER_APPROVAL_YES = "000019";
    /**
     * 银票贴现息
     */
    public static final String DISCOUNT_RATE = "000020";
    /**
     * 是否内扣
     */
    public static final String IF_INNER_DEDUCT = "000021";
    /**
     * 付款安排数据是否来源于付款审核
     */
    public static final String IF_FROM_LOAN_APPROVE = "000022";
    /**
     * 是否自动生成起租数据
     */
    public static final String IF_CREATE_BEGIN_RENT = "000023";
    /**
     * 起租日随首笔设备款日期
     */
    public static final String IF_FOLLOW_PLAN_DATE = "000024";

    /**
     * 日利息金额处理方式
     */
    public static final String DATE_INTEREST_TYPE = "000025";

    /**
     * 厂商作为承租人是否影响厂商授信额度
     */
    public static final String IF_MANUFACTURERS_LESSEE = "000026";
    /**
     * 中投会计表是否含保证金相关
     */
    public static final String IF_ACCOUNT_DEPOSIT_ZT = "000027";
    /**
     * 是否按照中投算法重新计算会计表
     */
    public static final String IF_ACCOUNT_ZT = "000028";
    /**
     * 是否生成客户号
     */
    public static final String IF_CUSTOMER_NO = "000029";
    /**
     * 系统标识
     */
    public static final String SYSTEM_FLAG = "000030";

    /**
     * 本金为负调整（江租）
     */
    public static final String CORPUS_ADJUST_ZERO_JZ = "000031";

    /**
     * 逾期记录是否跑日结
     */
    public static final String IF_REDUCE_PENALTY = "000032";
    /**
     * 是否根据收支计划交易类别生成账户（合同）
     */
    public static final String IF_CREATE_ACCOUNT = "000033";

    /**
     * 客户是否返写
     */
    public static final String IF_CUSTOMER_WRITE_BACK = "000034";
    /**
     * 会计表是否重算-江苏
     */
    public static final String IF_ACCOUNT_JZ = "000035";
    /**
     * 合同的调息渠道是否影响调息
     */
    public static final String IF_INFLUENCE_ADJUST="000036";
    /**合同修改（调息）*/
    public static final String CONT_MODIFI_ADJUST = "000038";

    /**
     * 生成罚息收支计划方式
     */
    public static final String IF_GENERATE_PENALTY="000037";

    /**
     * 计提表计算方式
     */
    public static final String ACCRUAL_WAY="000039";

    /**
     * 在线编辑URL上下文地址
     */
    public static final String EDIT_URL="000040";
    /**
     * 合同参与调息控制
     */
    public static final String CONT_ADJUST_TIME="000041";
    /**
     * 租金逾期金额大于等于总投资金额的比例
     */
    public static final String CASH_PROPORTION = "000042";
    /**
     * 租赁期限是否包含特殊期
     */
    public static final String LEASE_CONTAINS_SPECIAL = "000044";
    /**
     * 项目功能节点，子表信息必输控制
     */
    public static final String PROJECT_ISMUST_CTRL = "000045";

    /**
     * 罚息规则设置下罚息利率的数量
     */
    public static final String PENALTY_RATE_NUMBER = "000046";

    /**
     * 已收租金是否调息
     */
    public static final String RENT_PLAN_IF_ADJUST = "000047";
    /**
     * 最后期收租日计算方式
     */
    public static final String END_DATE_IF_RECAL = "000048";

    /**
     * 起租变更-变更规则为折让时是否扣减首付款
     */
    public static final String BEGIN_ALTER_IF_FIRST = "000049";
    /**
     * 是否控制合同在授信期间内
     */
    public static final String IF_CONTROL_DEADLINE="000051";

    /**
     * 是否控制项目在授信期间内
     */
    public static final String IF_PRJ_DEADLINE="000053";


    /**
     * 贷款卡号是否校验
     */
    public static final String IF_LOAN_CARD_NO = "000052";

    /**
     * 是否控制在授信额度内
     */
    public static final String IF_PRJ_GRANTING_LIMIT = "000054";

    /**
     * 区分用资金回收、收款核销
     */
    public static final String GATHER_TYPE = "000050";

    /**
     * 预测逾期是否展现未逾期的收支计划
     */
    public static final String IF_SHOW_NOT_OVERDUE_PLAN = "000055";

    /**
     * 营业税是否生成开票计划
     */
    public static final String IF_BUSINESS_TAX_INVOICE = "000056";

    /**
     * 营业税开票计划是否执行
     */
    public static final String IF_BUSINESS_TAX_INVOICE_EXECUTE = "000057";

    /**
     * 是否根据开票条件控制开票申请
     */
    public static final String IF_BUSINESS_TAX_INVOICE_CONTROL = "000059";
    /**
     * 自动核销时，根据校验规则
     * 0 :只用账户名
     * 1 :账户 + 账号
     */
    public static final String VERIFI_RULE = "000058";

    /**
     * 调息利息处理方式
     */
    public static final String ADJUST_INTEREST="000060";

    /**
     * 暂存凭证是否允许审核业务单据
     */
    public static final String VOUCHER_IF_CHECK = "000061";

    /**
     * 业务单据作废凭证是否删除
     */
    public static final String VOUCHERDISCRD_IF_DELETE = "000063";

    /**
     * 业务单据审核通过时凭证是否审核通过
     */
    public static final String VOUCHERAPPROVE_IF_APPROVE = "000064";

    /**
     * 手续费是否控制足额核销
     */
    public static final String SRVFEE_IF_ALLGATHER = "000065";

    /**
     * 是否根据开票条件控制后续业务
     */
    public static final String TICKETWHERE_IF_CHECK = "000066";

    /**
     * 合同提交是否校验起租条件
     */
    public static final String CONT_SUBMIT_RENT="000067";

    /**
     * 是否校验本方账户为合同约定账户
     */
    public static final String CONTACCOUNT_IF_CHECK = "000068";

    /**
     * 是否在付款核销时一起发起租凭证
     */
    public static final String IF_SAMETIME_SEND_BEGINVOUCHER = "000069";

    /**
     * 是否代付控制
     */
    public static final String IF_AGENT_PAY_CONTROL = "000070";

    /**
     * 税额调整算法
     */
    public static final String ADJUST_TAX_METHOD = "000071";

    /**
     * 收银票-贴现息是否开票
     */
    public static final String  IF_INVOICE= "000072";

    /**
     *
     */
    public static final String  FLOW_HIDDEN_TYPE = "000074";

    /**
     * 是否强性校验合同授信额度
     */
    public static final String IF_CONT_LIMIT ="000073";


    /**
     * 付款处理是否单独走审批流
     */
    public static final String IF_DEAL_FLOW ="000075";

    /**
     * 资金计提手续费类型
     */
    public static final String ACCRUALFEE_TYPE ="000080";


    /**
     * 资金计提手续费类型
     */
    public static final String INTERATE_STARTDATE ="000081";

    /**
     * 先锋特殊的合同自定义辅助核算
     */
    public static final String XIANFENG_SPEC ="000100";
    /**
     * 是否发凭证
     */
    public static final String IF_SEND_VOUCHER = "000082";

    /**
     * 是否向会计平台推送数据
     */
    public static final String IF_SEND_PLATFORM = "000085";

    /**
     * 资金 计提 名义利息 税率
     */
    public static final String ACCRUALFEE_RATE = "181030";
}