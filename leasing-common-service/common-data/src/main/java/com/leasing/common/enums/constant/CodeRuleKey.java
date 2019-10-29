package com.leasing.common.enums.constant;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:编码规则常量
 **/
public class CodeRuleKey {
    /**
     * <b>变量名称</b>
     * <p>编码生成规则节点表头的【变量名称】字段</p>
     */
    public static final String VARIABLE_NAME  = "variableName";
    /**
     * <b>节点名称</b>
     */
    public static final String FUN_NAME = "funName";
    /**
     * <b>节点编号</b>
     */
    public static final String FUN_CODE = "funCode";
    /**
     * <b>参数分类首字符串</b>
     */
    public static final String INDEX_CODE = "indexCode";

    /**指定日期*/
    public static final String FIX_DATE = "FIXDATE";

    /**顺序号*/
    public static final String LIQUID = "LIQUID";

    /** 行业类别编码 */
    public static final String TRADE_TYPE_CODE = "TRADETYPECODE";
    /** 年份 */
    public static final String YEAR = "YEAR";
    /** 月份 */
    public static final String MONTH = "MONTH";
    /** 日期 */
    public static final String DATE = "DATE";
    /** 资金业务类型 */
    public static final String CAPITAL_BUSI_CODE = "CAPITALBUSICODE";
    /** 借入方简称 */
    public static final String BORROW_CUSTOMER_SHORT = "BORROWCUSTOMERSHORT";
    /** 合同编号*/
    public static final String CONTRACT_CODE = "CONTRACTCODE";
    /** 金融机构客户编号*/
    public static final String FINANCE_CUSTOMER_CODE = "FINANCECUSTOMERCODE";
    /** 柜员号*/
    public static final String  USER_CODE = "USERCODE";
    /** 操作员*/
    public static final String  OPERATOR = "OPERATOR";
    /** 客户编号*/
    public static final String  CUSTOMERCODE = "CUSTOMERCODE";
    /** 客户名称*/
    public static final String  CUSTOMERNAME = "CUSTOMERNAME";
    /**项目批次**/
    public static final String  BATCHPRJ="BATCHPRJ";
    /**合同年份**/
    public static final String  CONT_YEAR="CONT_YEAR";
    /**合同批次**/
    public static final String  CONT_BATCH="CONT_BATCH";
    /**融资品种简码**/
    public static final String  CAPITAL_FIN_JM="CAPITAL_FIN_JM";
    /**融资机构编号**/
    public static final String  CAPITALT_FIN_ORG="CAPITALT_FIN_ORG";
    /**审批通过年月日**/
    public static final String  CAPITAL_FIN_DATE="CAPITAL_FIN_DATE";
    /**短期借款信息登记 节点编号*/
    public static final String SHORT_LOAN_FUN_CODE = "660105";
    /**提款起始日*/
    public static final String CAPITAL_DATE="CAPITAL_DATE";
    /**行业类别参数值*/
    public static final String INDUSTRY_TYPE="INDUSTRY_TYPE";
    /**合同类型(资金)*/
    public static final String ZJ_CONT_TYPE="ZJ_CONT_TYPE";
    /**编码前缀*/
    public static final String PREFIX="PREFIX";
    /**原编码*/
    public static final String OLD_CODE="OLD_CODE";
    /**是否分次提款*/
    public static final String IF_DRAWINGS="IF_DRAWINGS";
    /**单据VO*/
    public static final String BILLVO="BILLVO";





    /******* 变量名称主键 *******/

    /**变量名称主键：限额方案名称*/
    public static final String PK_LIMIT_NAME = "0001AA10000000005YI8";
    /**变量名称主键：限额方案编号*/
    public static final String PK_LIMIT_CODE = "0001AA10000000005YI9";
    /**变量名称主键：测算方案编号*/
    public static final String PK_LEASECAL_CODE = "0001AA10000000007RBR";
    /**变量名称主键：合同模板编号*/
    public static final String PK_DOCUMENT_TPL_CODE = "0001AA1000000000E94F";
    /**变量名称主键：单位客户基本信息表*/
    public static final String PK_CUSTOMER_CORP_CODE = "0001AA10000000004RC7";
    /**变量名称主键：自然人客户基本信息表*/
    public static final String PK_CUSTOMER_PERSON_CODE = "0001AA1000000000O6DC";
    /**变量名称主键: 承租人授信名称**/
    public static final String PK_LIMIT_LESSEE_NAME="0001AA100000000165R7";
    /**变量名称主键: 承租人授信编码**/
    public static final String PK_LIMIT_LESSEE_CODE="0001AA100000000165R6";
    /**变量名称主键: 承租人授信申请编号**/
    public static final String PK_LIMIT_LESSEE_APPLY_CODE="0001AA1000000009VUYG";
    /**变量名称主键: 会议名称**/
    public static final String MEETING_NAME="0001AA1000000009YU7N";
    /**变量名称主键: 会议编号**/
    public static final String MEETING_CODE="0001AA1000000009YU7O";
    /**变量名称主键：供应商合作协议审批编号*/
    public static final String APPROVAL_CODE = "0001AA1000000001P4M8";
    /**变量名称主键：供应商合作协议审批名称*/
    public static final String APPROVAL_NAME = "0001AA1000000001P4M9";
    /**变量名称主键：供应商合作协议制作编号*/
    public static final String APPROVAL_MAKE_CODE = "0001AA1000000005FLO0";
    /**变量名称主键：供应商合作协议制作名称*/
    public static final String APPROVAL_MAKE_NAME = "0001AA1000000005FLO1";
    /**变量名称主键：合同编号*/
    public static final String PK_CONT_CODE="0001AA1000000001ROFU";
    /**变量名称主键：合同名称*/
    public static final String PK_CONT_NAME="0001AA1000000001ROFV";
    /**变量名称主键：项目立项*/
    public static final String PK_PROJECT_APPROVAL="0001AA1000000002A9F4";
    /**变量名称主键：项目立项*/
    public static final String PROJECT_APPROVAL_NAME="0001AA1000000006JQ41";
    /**变量名称主键：项目审批*/
    public static final String PK_PROJECT_INFO="0001AA1000000002A9F5";
    /**变量名称主键：项目审批名称*/
    public static final String PROJECT_INFO_NAME="0001AA1000000006JQ40";
    /**变量名称主键：买卖合同编码*/
    public static final String PK_CONT_SALES="0001AA1000000002J1SK";
    /**变量名称主键：担保合同编码*/
    public static final String PK_CONT_GUARANTEE="0001AA1000000002J1SJ";
    /**提款格式文本编号**/
    public static final String  CAPITAL_CODE="0001AA1000000002VXIK";
    /**合同审批编号(授信)*/
    public static final String  CONT_CODE_SX="0001AA1000000002XA4K";
    /**合同审批编号(借款)*/
    public static final String  CONT_CODE_DK="0001AA1000000002XA4L";
    /**协议编号(合同)*/
    public static final String  CONT_CODE_SOURCE="0001AA10000000033H4D";
    /** 授信业务编号*/
    public static final String  FINACING_CODE ="0001AA10000000037DJS";
    /** 合并收租编号*/
    public static final String  MCONT_CODE ="0001AA1000000003DJRS";
    /**融资成本测算方案编号*/
    public static final String PRJ_FINA_QUOT_CODE="0001AA1000000003LBAE";
    /** 核销关联编号*/
    public static final String GATHER_CODE ="0001AA1000000003OL5C";
    /** 暂收款编号*/
    public static final String ADVANCES_RECEIVED_CODE ="0001AA1000000003QK4W";
    /** 客户号*/
    public static final String CUSOTMER_NO ="0001AA1000000004YO6E";
    /**付款申请付款申请单编号*/
    public static final String PAY_CASH = "0001AA10000000058C3C";
    /**业务资金付款申请编号*/
    public static final String BUSI_PAY_CASH = "0001AA1000000005CHS8";
    /**提款管理(流动资金)*/
    public static final String FLOW_WITHDRAW_MANAGER = "0001AA100000000655F4";
    /**提款管理(项目保理)*/
    public static final String PRJ_WITHDRAW_MANAGER = "0001AA100000000655F5";
    /**罚息规则设置*/
    public static final String PENALTY_RULE = "0001AA100000000165R6";
    /**转出项目*/
    public static final String ROLL_OUT = "0001AA1000000006VKT4";
    /**转回项目*/
    public static final String ROLL_IN = "0001AA1000000006VKT5";
    /** 开票编号 */
    public static final String INVOICE_CODE = "0001AA10000000077GA7";
    /** 申请开票编号 */
    public static final String INVOICE_APPLY_CODE = "0001AA10000000077GA8";

    /** 总承租人协议编号 */
    public static final String LESSEE_PROTOCOL_CODE = "0001AA1000000007B7IT";
    /** 总承租人协议名称 */
    public static final String LESSEE_PROTOCOL_NAME = "0001AA1000000007B7IU";
    /** 定期资产风险分类关联编号 */
    public static final String RISK_RELATION_CODE = "0001AA1000000007HCRC";

    /** 子承租人导入流水号 */
    public static final String SERIALNO = "0001AA1000000007RHQA";

    /** 供应商导入流水号 */
    public static final String PROVIDER_SERIALNO = "0001AA1000000007SB1U";

    /** 平台企业导入流水号 */
    public static final String PPLATFORMCORP_SERIALNO = "0001AA1000000007WIAF";


    /** 资金业务中收款核销关联流水号 */
    public static final String CAPITAL_GATHER_REC_CODE = "0001AA1000000006OQO7";
    /** 资金业务中付款核销关联流水号 */
    public static final String CAPITAL_GATHER_PAY_CODE = "0001AA1000000006OQOA";

    /** 回访安排流水号 */
    public static final String REVIEWPLAN_CODE = "0001AA1000000008H6VS";

    /** 回访安排流水号 */
    public static final String FORMATDOC_CODE = "0001AA100000000A0T74";

    /**变量名称主键：报价方案审批编号*/
    public static final String PK_LEASECAL_CHECK_CODE = "0001AA100000000DWHR2";

    /**变量名称主键：报价方案审批编号*/
    public static final String CAPITAL_ALLOCATION = "0001AA1000000001BKYQ";

    /**变量名称主键：评估申请编号*/
    public static final String APPRAISE_MANAGE_CODE = "0001AA100000000DWU3H";

    /**变量名称主键：操作员流水号*/
    public static final String OPERATOR_LIQUID = "0001AA10000000004RC6";
    /**变量名称主键：客户评级*/
    public static final String CUSTOMER_RATING = "0001AA1000000001GGW0";

    /**变量名称主键：代付设置名称*/
    public static final String AGENTPAY_NAME = "0001AA100000000AMIU0";


    /**变量名称主键：起租编号*/
    public static final String BEGIN_CODE = "0001AA100000000BBZIC";


    /**************************/
    /**
     * 追加收益合同管理
     */
    /** 追加收益合同维护：追加收益合同编码    **/
    public static final String CONT_CODE = "0001AA10000000059BL4";
    /** 追加收益合同维护：追加收益合同名称   **/
    public static final String CONT_NAME = "0001AA10000000059BL5";

    //[投资-购买] wangjj@2016/08/19 ADD START
    /** 投资管理-产品购买   */
    public static final String INVEST_CODE = "0001AA1000000006YIIV";

    /** 投资管理-产品赎回*/
    public static final String INVEST_RED_CODE = "0001AA10000000070PJO";
    //[投资-购买] wangjj@2016/08/19 ADD END

    /** web界面会计平台数据 会计平台单据编号*/
    public static final String VOUCHER_CODE = "0001AA100000000DJDIW";

    /**
     * add by jiaoshy
     * 咨询费合同编号 0001AA1000000001ROFU
     */
    public static final String CONSULT_CODE = "0001AA1000000001ROFU";

    /**
     * add by jiaoshy
     * 咨询费合同名称 0001AA1000000001ROFV
     */
    public static final String CONSULT_NAME = "0001AA1000000001ROFV";
}