package com.leasing.common.enums.constant;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:节点编码常量类
 **/
public class FuncCodeConstant {
    /**
     * 不规则测算器0001AA100000000092E3  830217
     */
    public static final String LEASECAL_IRREGULAR = "82H3";
    /**
     * 不规则测算器(聚信)0001AA1000000001WFQK
     */
    public static final String LEASECAL_IRREGULAR_JX = "83H107";

    /**
     * 合同模板功能结点编号0001AA1000000000H7LP
     */
    public static final String DOC_TPL_FUNCODE = "80H300";

    /**
     * 格式文档功能结点编号
     */
    public static final String FORMATDOC_FUNCODE = "80H30301";

    /**
     * 单位客户基本信息节点编号0001AA1000000001FXQ2
     */
    public static final String CUS_CORP_FUNCODE = "86H000";
    /**
     * 自然人客户基本信息节点编号0001AA1000000001G2DC
     */
    public static final String CUS_PERSON_FUNCODE = "86H001";

    /**
     * 单位客户维护基本信息节点编号 0001AA100000000AJXGY
     */
    public static final String CUS_CORPMOD_FUNCODE = "86H600";


    /**
     * 自然人客户维护基本信息节点编号 0001AA100000000AKBCY
     */
    public static final String CUS_PERSONMOD_FUNCODE = "86H601";

    /**
     * 承租人授信管理0001AA100000000143OD
     */
    public static final String LIMIT_LESSEE="87H000";

    /**
     * 供应商合作协议审批节点编号0001AA1000000001N9HQ
     */
    public static final String SUPP_APPR_FUNCODE = "92H002";
    /**
     * 供应商合作协议制作节点编号0001AA100000000212FL
     */
    public static final String SUPP_MAKE_FUNCODE = "88H104";
    /**
     *合同节点编号 0001AA1000000001QRAC
     */
    public static final String CONTRACT="88H105";
    /**
     * 客户关系查询节点0001AA1000000001D9X7
     */
    public static final String RELEVANCE="86H3";
    /**
     * 客户关联查询节点0001AA1000000001H06L
     */
    public static final String RELATION="86H4";

    /**
     * 普通项目审批0001AA1000000001WIU0
     */
    public static final String PROJECT_INFO="87H10101";
    /**
     * 融资格式文本法审0001AA1000000002JO5S
     */
    public static final String CAPITAL_CONT_LAW="85H10301";
    /**
     * 资金合同审批0001AA1000000002JO5T
     */
    public static final String CAPITAL_CONT_APPROVE="85H10303";
    /**
     * 融资成本测算（项目保理）0001AA1000000002JO5V
     */
    public static final String PRJ_FINA_QUOT_CODE="85H10501";

    /**
     * 融资成本测算（流动资金）0001AA1000000002JO5W
     */
    public static final String LOAN_APPROVE_CODE="85H10503";

    /**
     * 提款管理（项目保理）0001AA1000000002JO63
     */
    public static final String PRJ_WITHDRAW_MANAGER_CODE="85H10903";

    /**
     * 提款管理（流动资金）0001AA1000000002JO62
     */
    public static final String FLOW_WITHDRAW_MANAGER_CODE="85H10901";

    /**
     * 资金划拨
     */
    public static final String CAPITAL_ALLOCATION = "85H11101";

    /**
     * 精算0001AA1000000001BPLE
     */
    public static final String LEASECAL_FULL = "82H2";

    /**
     * 快速0001AA1000000000Y2UQ
     */
    public static final String LEASECAL_NORM = "82H1";

    /**
     * 精算 （中投）0001AA1000000001N4VL
     */
    public static final String LEASECAL_FULL_ZT = "82H5";

    /**
     * 快速 （中投）0001AA1000000001N4V5
     */
    public static final String LEASECAL_NORM_ZT = "82H4";

    /**
     * 精算 （原型）0001AA10000000003RT0
     */
    public static final String LEASECAL_FULL_YX = "82H8";

    /**
     * 快速 （原型）0001AA1000000000FSOA
     */
    public static final String LEASECAL_NORM_YX = "82H7";


    /**
     * 收款核销0001AA1000000003D4CT
     */
    public static final String GATHER_ACCOUNT="89H10300";
    /**
     * 提醒规则设置0001AA10000000053985
     */
    public static final String REMIND_RULE_CODE="91H104";

    /**
     * 收款提醒(短信)0001AA10000000058VDV
     */
    public static final String GATHER_REMIND = "91H10000";

    /**
     * 收款提醒(通知函)0001AA10000000058VDW
     */
    public static final String GATHER_REMIND_NOTICE = "91H10001";

    /**
     * 收款提醒(邮件)0001AA10000000058VDX
     */
    public static final String GATHER_REMIND_MAIL = "91H10002";

    /**
     * 逾期催收(短信)0001AA1000000005IA4A
     */
    public static final String OVERDUE_REMIND = "91H10200";

    /**
     * 逾期催收(通知函)0001AA1000000005IA4B
     */
    public static final String OVERDUE_REMIND_NOTICE = "91H10201";

    /**
     * 逾期催收(邮件)0001AA1000000005IA4C
     */
    public static final String OVERDUE_REMIND_MAIL = "91H10202";

    /***************提醒、催收(江租)*******************/
    /**
     * 短信催收(7天)0001AA1000000005PEAM
     */
    public static final String GATHER_REMIND_NOTE_7 = "91H10500";

    /**
     * 短信催收(30天)0001AA1000000005PEAN
     */
    public static final String GATHER_REMIND_NOTE_30 = "91H10501";

    /**
     * 通知书催收(7天)0001AA1000000005PEAO
     */
    public static final String GATHER_REMIND_NOTICE_7 = "91H10502";

    /**
     * 重要催收(15天)0001AA1000000005PEAP
     */
    public static final String GATHER_REMIND_NOTICE_15 = "91H10503";

    /**
     * 逾期催缴(4天)0001AA1000000005PEAR
     */
    public static final String OVERDUE_REMIND_NOTE_4 = "91H10600";

    /**
     * 逾期催缴(30天)0001AA1000000005PEAS
     */
    public static final String OVERDUE_REMIND_NOTICE_30 = "91H10601";

    /**
     * 逾期催缴(60天)0001AA1000000005PEAT
     */
    public static final String OVERDUE_REMIND_NOTICE_60 = "91H10602";

    /**
     * 逾期催缴(90天)0001AA1000000005PEAU
     */
    public static final String OVERDUE_REMIND_NOTICE_90 = "91H10603";

    /**
     * 核销审核0001AA1000000003D4CU
     */
    public static final String GATHER_AUDIT = "89H10302";

    /**
     * 付款核销0001AA1000000004VVSI
     */
    public static final String LOAN_DEAL_FUNCODE = "89H005";

    /**
     * 付款申请0001AA1000000003D4CL
     */
    public static final String LOAN_APPLY_FUNCODE = "89H003";

    /**
     * 罚息规则设置0001AA1000000006DT5E
     */
    public static final String PENALTY_RULE_CODE = "80H002";
    /**
     * 转出项目0001AA1000000006TLTN
     */
    public static final String ROLL_OUT_CODE = "91H200";
    /**
     * 转回项目0001AA1000000006XOFF
     */
    public static final String ROLL_IN_CODE = "91H201";
    /**
     * 付款审核节点0001AA1000000003D4CK
     */
    public static final String APPROVE_CODE = "89H002";
    /**
     * 付款处理节点0001AA1000000003D4CM
     */
    public static final String LOAN_DEAL_CODE = "89H004";

    /**
     * 开票申请单
     */
    public static final String INVOICE_APPLY_BILL = "93H106";

    /**
     * 限额方案节点0001AA10000000005UNE
     */
    public static final String LIMIT_PLAN = "80H7";

    /**
     * 总承租人协议节点0001AA1000000001QSSY
     */
    public static final String LESSEE_PROTOCOL = "88H100";

    /**
     * 投放申请0001AA1000000003D4CJ
     */
    public static final String LOAN_PLAN = "89H001";

    /**
     * 定期组合资产风险分类评定0001AA1000000007GJFV
     */
    public static final String RISK_EVALUATE = "91H303";

    /**
     * 不定期资产风险分类评定
     */
    public static final String RISK_EVALUATE_NO_FIXED = "91H304";

    /**
     * 定期单个资产风险分类评定0001AA1000000007GJFU
     */
    public static final String RISK_EVALUATE_SINGLE = "91H302";

    /**
     * 资产风险分类评定申请0001AA1000000007G05E
     */
    public static final String RISK_EVALUATE_APP = "91H301";

    /**
     * 资产风险分类评定最终审批
     */
    public static final String RISK_EVALUATE_FINAL = "91H305";

    /**
     * 精算报价(聚信)0001AA1000000001WFQI
     */
    public static final String  LEASECAL_ACTUARY_JX= "83H106";


    /**
     * 总承租人合作协议子承租人导入0001AA1000000007QVCQ
     */
    public static final String  LESSEE_SUB_INPUT= "86H503";

    /**
     * 供应商导入0001AA1000000007S9IA
     */
    public static final String  PROVIDER_INPUT= "86H504";

    /**
     * 平台企业导入0001AA1000000007UZI3
     */
    public static final String  PLATFORMCORP_INPUT= "86H604";
    /**
     * 资金付款核销0001AA1000000006JPCE
     */
    public static final String  CAPITAL_GATHER= "85H10703";

    /**
     * 资金提款款核销0001AA1000000006OQO7
     */
    public static final String  CAPITAL_GATHER_= "85H10902";
    /**
     * 总承认项目审批0001AA1000000001WIU2
     */
    public static final String  GROUP_PROJECT= "87H10201";
    /**
     * 子合同制作(付款条件)(树形结构中)
     */
    public static final String  LESSEE_CONTRACT_PAYMENTCD = "8306080410";

    /**
     * 子合同制作(费率方案)(树形结构中)
     */
    public static final String  LESSEE_CONTRACT_RATE = "8306080402";

    /**
     * 子合同制作(供应商)(树形结构中)
     */
    public static final String LESSEE_CONTRACT_PROVIDER = "8306080403";
    /**
     * 船舶行业  0001AA1000000006VRR8
     */
    public static final String INDUSTRY_INFO_WATERCRAFT="86H700";

    /**
     * 教育行业 0001AA1000000006VRR9
     */
    public static final String NDUSTRYINFOEDU="86H701";

    /**
     * 医疗行业 0001AA1000000006VRRA
     */
    public static final String INDUSTRY_INFO_HOSPITAL="86H702";

    /**
     * 印刷行业 0001AA1000000006VRRB
     */
    public static final String INDUSTRY_INFO_PRINT="86H703";

    /**
     * 单位客户-合作历史(树形结构中)
     */
    public static final String  CUSTCOOPHISTORYCOR="83010102";

    /**
     * 单位客户-客户附件(树形结构中)
     */
    public static final String  CUST_ACCESSORY="8301010901";

    /**
     * 聚新(报价测算综合版)
     */
    public static final String LEASE_CALCULATOR_COMPLEX ="82H6";


    /**
     * 中投 通知书提醒
     */
    public static final String GATHER_REMIND_NOTICEZT ="91H107";

    /**
     * 中投 通知书催收
     */
    public static final String OVERDUE_REMIND_NOTICEZT ="91H108";

    /**
     * 起租变更
     */
    public static final String RENT_BEGIN_ALTER ="89H013";

    /**
     * 合同台账查询(树形结构中)
     */
    public static final String CONTRACT_QUERY ="88H00000";

    /**
     * 合同变更对比
     */
    public static final String CONTRACT_COMPARE = "109904";
    /**
     * 项目台账查询
     */
    public static final String PROJECT_QUERY ="88H00007";

    /**
     * 租赁物查询
     */
    public static final String LEASE_QUERY ="91H400";

    /**
     * 合同变更
     */
    public static final String CONTRACT_CHANGE ="88H201";

    /**
     * 合同历史
     */
    public static final String CONTRACT_H ="88H301";

    /**
     * 外币租金表重算
     */
    public static final String CONTRACT_FOREIGN ="88H202";

    /**
     * 资金回收
     */
    public static final String GATHER_PLAN ="89H10301";

    /**
     * 系统调息
     */
    public static final String ADJUST_APPLY_SYS_NAME="系统调息";

    public static final String ADJUST_APPLY_SYS="98H000";
    /**
     * 手工调息
     */
    public static final String ADJUST_APPLY_HAND_NAME="手工调息";

    public static final String ADJUST_APPLY_HAND="98H001";

    /**
     * 免调息
     */
    public static final String ADJUST_APPLY_SPARE_NAME="免调息";

    public static final String ADJUST_APPLY_SPARE="98H002";

    /**
     * 费率调息
     */
    public static final String ADJUST_APPLY_RATE="98H1";

    /**
     * 子合同制作
     */
    public static final String  LESSEE_CONTRACT = "88H101";

    /**
     * 合同撤销
     */
    public static final String  CONTRACT_REVOKE = "88H106";
    /**
     * 承租人台账
     */
    public static final String LESSEE_LEDGER ="88H00002";

    /**
     * 项目台账
     */
    public static final String PROJECT_LEDGER="88H00001";


    /**
     * 过审普通项目查询
     */
    public static final String PROJECT_INFOQUERY="87H10100";

    /**
     * 过审总承租人项目查询
     */
    public static final String PROJECT_GROUPINFOQUERY="87H10200";

    /**
     * 过审普通项目查询(医疗)
     */
    public static final String PROJECT_MEDICALQUERY = "87H10601";

    /**
     * 客户评级 0001AA1000000002JO9G
     */
    public static final String CUSTOMER_RATING="86HA03";

    /**
     * 承租人授信申请
     */
    public static final String LIMIT_LESSEE_APPLY="87H003";

    /**
     * 会议安排(树形结构中)
     */
    public static final String MEETING_ARRANGE="87H004";

    /**
     * 评审会议(树形结构中)
     */
    public static final String MEETING_REVIEW="87H005";


    /**
     * 代付账户设置
     */
    public static final String AGENTPAY_ACCOUNT_SET = "89H011";


    /**
     * 报价方案审核
     */
    public static final String LEASE_CALCULATOR_CHECK = "82HC";


    /**
     * 报价测算(客户)
     */
    public static final String LEASE_CALCULATOR_NO_PRJ = "82HA";

    /**
     * 手工到账
     */
    public static final String GATHER_PLAN_HAND = "89H10303";

    /**
     * 问题反馈
     */
    public static final String QUESTION_TICKLING = "87H00603";

    /**
     * 评估申请
     */
    public static final String APPRAISE_MANAGE = "87H00601";

    /**
     * 起租
     */
    public static final String RENT_BEGIN_STATUS ="89H006";

    /**
     *  调息分析查询
     */
    public static final String ADJUST_ANALYSIS ="98H004";

    /**
     *  预测罚息
     */
    public static final String FORECAST_PENALTY ="91H001";

    /**
     *  开票申请
     */
    public static final String INVOICE_APPLY ="93H102";

    /**
     *  逾期重算
     */
    public static final String OVERRECORD_AGAIN ="91H007";

    /**
     * 电话回访
     * YYL-3899
     */
    public static final String TEL_REVIEWINFO="91H502";

    /**
     * 实地回访
     * YYL-3899
     */
    public static final String FIELD_REVIEWINFO ="91H503";

    /**
     *  税额调整
     */
    public static final String ADJUST_TAX ="88H205";

    /**
     *  减免审核
     */
    public static final String REDUCE_CHECK="91H004";
    /**
     *  月末计提(电信)
     */
    public static final String TELE_LEASE_ACCRUED="89H303";
    /**
     *  月末计提(非电信)
     */
    public static final String NON_TELE_LEASE_ACCRUED="89H304";

    /**
     * 日终
     */
    public static final String  SYSTEM_STATUS_DAY = "80H601";

    /**
     * 保证金变更基本信息
     */
    public static final String LEASE_CONTRACT_MARGIN = "88H204";

    /**
     * 提前结清
     */
    public static final String CONT_ADVANCE_END = "88H207";

    /**
     * 合同信息基准表
     */
    public static final String DATAITEM_CONTRACT_MASTER = "91HA05";

    /**
     * 追加收益合同维护
     */
    public static final String CONTRACT_ADDITIONAL = "88H401";

    // 会计IRR重算  wangjj  2016/10/26

    /**
     * 会计IRR重算
     */
    public static final String FINANCE_IRR_RECAL="88H002";
    //end
    /**
     * 提前还款（新）
     */
    public static final String REFUND = "88H209";

    /** INSERT  【 wangjj】 【2017年9月18日】 【BUG修改】<BUG号 JICL-1244号> 拆分投放节点 加入业务锁校验*/
    /**
     * 拆分投放
     */
    public static final String LOAN_SPLIT = "88H210";
    /** INSERT  END */


    /**
     * 通知书提醒（中投） 保理
     */
    public static final String GATHER_REMIND_NOTICELF = "LF100202";

    /**
     * 通知书催收 （中投）保理
     */
    public static final String OVERDUE_REMIND_NOTICELF = "LF100203";

    /**
     * 项目起息-保理
     */
    public static final String FACTORING_RENT_BEGIN_STATUS ="LF040104";

    /**
     * web界面 凭证生成节点
     */
    public static final String VOUCHER_CODE = "LF0702";

    /**
     * add by jiaoshy
     * 咨询费合同制作 88H109 0001AA100000000HMHUL
     */
    public static final String CONSULT_CONTRACT = "88H109";


    /**
     * 资金模块 月末计提
     */
    public static final String CAPITAL_ACCRUE_EOMDAY = "85H11501";

    /**
     * 保理  月末计提
     */
    public static final String BL_LEASE_ACCRUAL = "LF040301";

    /**
     * 保理 收款核销
     */
    public static final String BL_FACTOR_GATHER_AUDIT = "LF040202";
}