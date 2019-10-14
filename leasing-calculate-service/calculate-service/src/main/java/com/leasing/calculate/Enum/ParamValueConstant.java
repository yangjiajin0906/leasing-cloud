package com.leasing.calculate.Enum;

import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/10/10
 * @author:Yjj@yonyou.com
 * @description:
 **/
public class ParamValueConstant {
    /** **********************参数字典************************** */
    /** 客户性质 */
    public static final int PARMS_CUST_TYPE = 2;

    /**
     * 参数定义，辅助核算项编号
     */
    public static final String FREE_PARAM_CODE = "000253";

    /**
     * 参数定义，省市县
     */
    public static final String PROVINCE_CITY = "000011";

    /**
     * 区域
     */
    public static final String PARAMS_REGION = "000016";

    /**
     * 区域划分：其他
     */
    public static final String PARAMS_REGION_ELSE = "7";

    /**
     * 区域划分国内的其他
     */
    public static final String PARAMS_CHINA_REGION_ELSE = "00";
    /**
     * 境外客户省市区专用：其他
     */
    public static final String PARAMS_CITY_ELSE = "04";

    /**
     * 行业领域
     */
    public static final String INDUSTRY_TYPE = "000017";


    /** **********************利率档次类型********************* */
    /** 人行存款利率档次类型 */
    public static final String GRADE_DEPOSITES_RATE = "1000118";
    /** 人行贷款利率档次类型 */
    public static final String GRADE_LOAN_RATE = "1000119";
    /** SHIBOR利率档次类型 */
    public static final String GRADE_SHIBOR_RATE = "11";
    /** LIBOR利率档次类型 */
    public static final String GRADE_LIBOR_RATE = "12";

    /** ***************************币种************************************ */
    /** 人民币 */
    public static final String CURRENCY_RMB_PK = "00010000000000000001";
    /** 人民币编号 */
    public static final String CURRENCY_RMB_CODE = "CNY";
    /** 人民币名称 */
    public static final String CURRENCY_RMB_NAME = "人民币";

    /** 多币种 */
    public static final String CURRENCY_DBZ_PK = "0001A91000000000MEEK";
    /** 人民币编号 */
    public static final String CURRENCY_DBZ_CODE = "DBZ";
    /** 人民币名称 */
    public static final String CURRENCY_DBZ_NAME = "多币种";
    /** *******************节点编号************************************ */

    /** ***************************保证金冲抵************************************ */
    /** 人民币 */
    public static final String DEPOST_CHARGE_PK = "0001AA10000000007NHT";
    /** 人民币编号 */
    public static final String DEPOST_CHARGE_CODE = "10302";
    /** 人民币名称 */
    public static final String DEPOST_CHARGE_NAME = "保证金冲抵";
    /** *******************节点编号************************************ */
    /** ***************************保证金退换************************************ */
    /** 人民币 */
    public static final String DEPOST_BACK_PK = "0001AA10000000007NHX";
    /** 人民币编号 */
    public static final String DEPOST_BACK_CODE = "10304";
    /** 人民币名称 */
    public static final String DEPOST_BACK_NAME = "退还保证金";
    /** *******************节点编号************************************ */

    /** 规则测算节点号 */
    public static final String LEASE_CALCULATOR = "8215";
    /** *********************计算税额利率*********************** */
    public static final BigDecimal MULTIPLY_TAX = new BigDecimal("0.17");
    public static final BigDecimal SIX_TAX = new BigDecimal("0.06");
    public static final BigDecimal THREE_TAX = new BigDecimal("0.03");
    public static final BigDecimal ZERO_TAX = new BigDecimal("0.00");

    public static final BigDecimal DIVIDE_TAX = new BigDecimal("1.17");
    /** **********************国民经济行业分类******************************* */
    /** 农、林、牧、渔业 */
    public static final String INDUSTRY_CATEGORY_A = "1009BB10000000AA1001";
    /** 采矿业 */
    public static final String INDUSTRY_CATEGORY_B = "1009BB10000000AA1090";
    /** 制造业 */
    public static final String INDUSTRY_CATEGORY_C = "1009BB10000000AA1154";
    /** 电力、热力、燃气及水生产和供应业 */
    public static final String INDUSTRY_CATEGORY_D = "1009BB10000000AA1893";
    /** 建筑业 */
    public static final String INDUSTRY_CATEGORY_E = "1009BB10000000AA1916";
    /** 批发和零售业 */
    public static final String INDUSTRY_CATEGORY_F = "1009BB10000000AA1956";
    /** 批发业 */
    public static final String INDUSTRY_CATEGORY_WHOLESALE = "1009BB10000000AA1957";
    /** 零售业 */
    public static final String INDUSTRY_CATEGORY_RETAIL = "1009BB10000000AA2024";
    /** 交通运输、仓储和邮政业 */
    public static final String INDUSTRY_CATEGORY_G = "1009BB10000000AA2090";
    /** 仓储业 */
    public static final String INDUSTRY_CATEGORY_WAREHOUSE = "1009BB10000000AA2147";
    /** 邮政业 */
    public static final String INDUSTRY_CATEGORY_POSTAL = "1009BB10000000AA2154";
    /** 道路运输业 */
    public static final String INDUSTRY_CATEGORY_ROAD = "1009BB10000000AA2100";
    /** 水上运输业 */
    public static final String INDUSTRY_CATEGORY_WATER = "1009BB10000000AA2114";
    /** 管道运输业 */
    public static final String INDUSTRY_CATEGORY_PIPELINE = "1009BB10000000AA2137";
    /** 航空运输业 */
    public static final String INDUSTRY_CATEGORY_AIR = "1009BB10000000AA2127";
    /** 铁路运输业 */
    public static final String INDUSTRY_CATEGORY_RAILWAY = "1009BB10000000AA2091";
    /** 装卸搬运和运输代理业 */
    public static final String INDUSTRY_CATEGORY_LOAD = "1009BB10000000AA2140";
    /** 住宿和餐饮业 */
    public static final String INDUSTRY_CATEGORY_H = "1009BB10000000AA2159";
    /** 住宿业 */
    public static final String INDUSTRY_CATEGORY_LODGING = "1009BB10000000AA2160";
    /** 餐饮业 */
    public static final String INDUSTRY_CATEGORY_RESTAURANT = "1009BB10000000AA2167";
    /** 信息传输、软件和信息技术服务业 */
    public static final String INDUSTRY_CATEGORY_I = "1009BB10000000AA2181";
    /** 电信、广播电视和卫星传输服务 */
    public static final String INDUSTRY_CATEGORY_TRANSPORT = "1009BB10000000AA2182";
    /** 互联网和相关服务 */
    public static final String INDUSTRY_CATEGORY_INTERNET = "1009BB10000000AA2192";
    /** 软件和信息技术服务业 */
    public static final String INDUSTRY_CATEGORY_INFORMATION = "1009BB10000000AA2199";
    /** 金融业 */
    public static final String INDUSTRY_CATEGORY_J = "1009BB10000000AA2214";
    /** 房地产业 */
    public static final String INDUSTRY_CATEGORY_K = "1009BB10000000AA2269";
    /** 房地产开发经营(中类) */
    public static final String INDUSTRY_CATEGORY_REAL_ESTATE = "1009BB10000000AA2271";
    /** 物业管理(中类) */
    public static final String INDUSTRY_CATEGORY_PROPERTY_MANAGE = "1009BB10000000AA2273";
    /** 房地产中介服务(中类) */
    public static final String INDUSTRY_CATEGORY_INTERMEDIARY_SERVICE = "1009BB10000000AA2273";
    /** 其他房地产业(中类) */
    public static final String INDUSTRY_CATEGORY_OTHER_ESTATE = "1009BB10000000AA2273";
    /** 自有房地产经营活动(中类) */
    public static final String INDUSTRY_CATEGORY_OWN_ESTATE = "1009BB10000000AA2273";
    /** 租赁和商务服务业 */
    public static final String INDUSTRY_CATEGORY_L = "1009BB10000000AA2281";
    /** 科学研究和技术服务业 */
    public static final String INDUSTRY_CATEGORY_M = "1009BB10000000AA2334";
    /** 水利、环境和公共设施管理业 */
    public static final String INDUSTRY_CATEGORY_N = "1009BB10000000AA2386";
    /** 居民服务、修理和其他服务业 */
    public static final String INDUSTRY_CATEGORY_O = "1009BB10000000AA2423";
    /** 教育 */
    public static final String INDUSTRY_CATEGORY_P = "1009BB10000000AA2465";
    /** 教育(大类) */
    public static final String INDUSTRY_CATEGORY_EDUCATION = "1009BB10000000AA2466";
    /** 卫生和社会工作 */
    public static final String INDUSTRY_CATEGORY_Q = "1009BB10000000AA2490";
    /** 卫生 */
    public static final String INDUSTRY_CATEGORY_HEALTH = "1009BB10000000AA2491";
    /** 社会工作 */
    public static final String INDUSTRY_CATEGORY_SOCIALWORK = "1009BB10000000AA2515";
    /** 文化、体育和娱乐业 */
    public static final String INDUSTRY_CATEGORY_R = "1009BB10000000AA2526";
    /** 公共管理、社会保障和社会组织 */
    public static final String INDUSTRY_CATEGORY_S = "1009BB10000000AA2593";
    /** 国际组织 */
    public static final String INDUSTRY_CATEGORY_T = "1009BB10000000AA2639";
    /**印刷和记录媒介复制业*/
    public static final String INDUSTRY_BIG_PRINT="1009BB10000000AA1343";
    /**铁路、船舶、航空航天和其他运输设备制造业*/
    public static final String INDUSTRY_BIG_RAILWAY="1009BB10000000AA1734";
    /** 其他未列明行业 */
    public static final String INDUSTRY_OTHER="INDUSTRYOTHER";
    /** ***************************客户关系参照************************************ */
    /**股东*/
    public static final String SHAREHOLDER_CODE = "0";
    /**被投资方*/
    public static final String BE_INVESTORS_CODE = "1";
    /**出资方*/
    public static final String INVESTOR_CODE = "2";
    /**关联公司*/
    public static final String AFFILIATE_COMPANY_CODE = "3";
    /**实际控制人*/
    public static final String ACTUAL_CONTROL_CODE = "4";
    /**实际控制企业*/
    public static final String BE_CONTROL_ENTERPRISE_CODE = "5";
    /**中介人*/
    public static final String AGENT_CODE = "6";
    /**被介绍客户*/
    public static final String BE_INTRODUCTION_CUSTOMER_CODE = "7";
    /**亲属*/
    public static final String RELATIVES_CODE = "8";
    /**配偶*/
    public static final String SPOUSE_CODE = "9";
    /**法定代表人*/
    public static final String LEGAL_REPRESENTATIVE_CODE = "10";
    /**所属企业*/
    public static final String COMPANY_CODE = "11";
    /**供货商*/
    public static final String SALES_SIDE_CODE = "12";
    /**采购方*/
    public static final String BUY_SIDE_CODE = "13";
    /**高级管理层*/
    public static final String EXECUTIVES_CODE = "14";
    /**债权人*/
    public static final String CREDITOR_CODE = "15";
    /**债务方*/
    public static final String DEBTOR_CODE = "16";
    /**保证人*/
    public static final String GUARANTOR_CODE = "17";
    /**债务人*/
    public static final String DEBTORS_CODE = "18";
    /**质押人*/
    public static final String PLEDGOR_CODE = "19";
    /**质押权人*/
    public static final String PLEDGEE_CODE = "20";
    /**出质人*/
    public static final String MORTGAGOR_CODE = "21";
    /**质权人*/
    public static final String MORTGAGEE_CODE = "22";
    /**承租人*/
    public static final String LESSEE_CODE = "23";
    /**出租人*/
    public static final String LETTER_CODE = "24";
    /**担保人*/
    public static final String CAUTIONER_CODE = "25";
    /**被担保人*/
    public static final String BE_CAUTIONER_CODE = "26";
    /**介绍人*/
    public static final String REFERENCES_CODE = "27";
    /**被介绍人*/
    public static final String BE_REFERENCES_CODE = "28";
    /**厂商*/
    public static final String MANUFACTURER_CODE = "29";
    /**准承租人*/
    public static final String CANDIDATE_LESSEE_CODE = "30";
    /**准出租人*/
    public static final String CANDIDATE_LETTER_CODE = "31";
    /**准担保人*/
    public static final String CANDIDATE_CAUTIONER_CODE = "32";
    /**准被担保人*/
    public static final String CANDIDATE_BE_CAUTIONER_CODE = "33";
    /**准供货商*/
    public static final String CANDIDATE_SALES_SIDE_CODE = "34";
    /**准采购方*/
    public static final String CANDIDATE_BUY_SIDE_CODE = "35";
    /**准介绍人*/
    public static final String CANDIDATE_REFERENCES_CODE = "36";
    /**准被介绍人*/
    public static final String CANDIDATE_BE_REFERENCES_CODE = "37";
    /**准厂商*/
    public static final String CANDIDATE_MANUFACTURER_CODE = "38";
    /**管理企业*/
    public static final String MANAGE_ENTERPRISE_CODE = "39";
    /**抵押权人*/
    public static final String THE_MORTGAGEE_CODE = "40";
    /**抵押人*/
    public static final String THE_MORTGAGOR_CODE = "41";
    /**回购人*/
    public static final String THE_BACKGAGOR_CODE = "42";
    /**
     * 客户关系,‘其他’
     */
    public static final String OTHER_RELATIONS = "43";


    /** *********************所在国家(地区)   暂用************************* */
    /** 中国*/
    public static final String COUNTRY_CHINA = "0001AA1000000001BE0S";

    /** *********************费率测算默认值************************* */
    /** 投放时间 */
    public static final String PLAN_DATE_LOAN = "2013-01-01";
    /** 付款日 */
    public static final Short PLAN_LEASE_DATE = 1;
    /** 一年几个月 */
    public static final BigDecimal YEAR_FOR_MONTH = new BigDecimal("12");
    /** 投放日收取的收支计划的前缀*/
    public static final String PLAN_TIME_NAME = "投放日";

    /** ************************功能注册节点编码**************************** */


    /** ************************数据权限**************************** */
    /**  是否控制数据权限-(是) */
    public static final String IF_DATA_POWER_YES = "0";
    /** 数据权限控制范围，取最小集合 */
    public static final String DATA_POWER_SCOPE_MIN = "0";

    /** ************************客户评级**************************** */
    /** 客户级别 */
    public static final String CUSTOMER_RATING = "0001AA1000000002URUQ";

    /** ************************年化天数**************************** */
    /** 年化天数：360 */
    public static final Integer DAYS_360 = 360;
    /** 年化天数：365 */
    public static final Integer DAYS_365 = 365;

    /** ************************计提表**************************** */
    /** 计提表类型 */
    public static final String ACCRUAL_TYPE = "1";

    /*************************rule公式****************************/
    /**公式规则*/
    public static final String LIMIT_FORMULA = "limit_formula";
    /***********************付款安排 安排类型****************************/
    /**按合同合并**/
    public static final Short ARRANGE_CONTRACT = 0;
    /**按银行账户合并**/
    public static final Short ARRANGE_BANK = 1;
    /**单一付款**/
    public static final Short ARRANGE_ONLY = 2;


    /*************************批处理***************************/
    /**日终批处理*/
    public static final String SYSTEMSTATUSDAY = "80H601";
    /**月结处理*/
    public static final String SYSTEMSTATUSMONTH = "80H602";
    /**年结处理*/
    public static final String SYSTEMSTATUSYEAR = "80H603";

    public static final String DAYENDLOCKKEY = "DAYEND11111111111111";

    public static final String DAYENDLOCKKEY_SIMPLE = "11111111111111111111";

    /*************************行业类别***************************/
    /**教育*/
    public static final String EDUCATION = "0001AA1000000002QXQL";
    /**医疗*/
    public static final String MEDICAL = "0001AA1000000002QXR3";
    /*************************客户类型***************************/
    /**承租人*/
    public static final String CUST_CLASS_LESSEE = "0001AA1000000004YE4A";
    /**渠道商*/
    public static final String CUST_CLASS_DISTRIBUTOR="0001AA1000000004YE4D";

    /*************************资产五级分类标准***************************/
    public static final String ASSETS_CLASSIFY_NORMAL = "000258";

    /*************************事件类别***************************/
    /**贷款-收取贷款(贷款-贷款到帐)*/
    public static final String LOAN_ACCOUNT = "20101";
    /**贷款-支付本金*/
    public static final String PAYMENT_PRINCIPAL = "20201";
    /**贷款-支付利息*/
    public static final String PAYMENT_INTEREST = "20202";

    /*************************区域默认值（同步客户辅助核算时用）***************************/
    public static final String PK_AREACL = "0001INI0000000008888";
    /*********************付款/起租条件start*************************/
    // 合同主键
    public static final String CONDITION_PK_CONTRACT = "PK_CONTRACT";
    // 条件参数类型
    public static final String CONDITION_PARAM_TYPE = "PARAM_TYPE";
    /**
     * 首笔保证金已收
     */
    public static final String CONDITION_PARAM_VALUE_1 = "1";
    /**
     * 首付款已收
     */
    public static final String CONDITION_PARAM_VALUE_2 = "2";
    /**
     * 首笔手续费已收
     */
    public static final String CONDITION_PARAM_VALUE_3 = "3";
    // 参数值4
    public static final String CONDITION_PARAM_VALUE_4 = "4";
    // 参数值5
    public static final String CONDITION_PARAM_VALUE_5 = "5";
    // 参数值6
    public static final String CONDITION_PARAM_VALUE_6 = "6";
    // 参数值7
    public static final String CONDITION_PARAM_VALUE_7 = "7";
    // 参数值8
    public static final String CONDITION_PARAM_VALUE_8 = "8";
    // 参数值9
    public static final String CONDITION_PARAM_VALUE_9 = "9";
    // 参数值10
    public static final String CONDITION_PARAM_VALUE_10 = "10";
    // 参数值11
    public static final String CONDITION_PARAM_VALUE_11 = "11";
    // 参数值12
    public static final String CONDITION_PARAM_VALUE_12 = "12";
    // 参数值13
    public static final String CONDITION_PARAM_VALUE_13 = "13";
    // 参数值14
    public static final String CONDITION_PARAM_VALUE_14 = "14";
    // 参数值15
    public static final String CONDITION_PARAM_VALUE_15 = "15";
    // 参数值16
    public static final String CONDITION_PARAM_VALUE_16 = "16";
    // 参数值17
    public static final String CONDITION_PARAM_VALUE_17 = "17";
    // 参数值18
    public static final String CONDITION_PARAM_VALUE_18 = "18";
    // 参数值19
    public static final String CONDITION_PARAM_VALUE_19 = "19";

    /*********************付款/起租条件end***************************/

    /*************************集团机构（批处理记账等用）***************************/
    public static final String PK_ORG_GROUP = "0001";

    public static final String PK_ORG_BJ = "1003";
    public static final String PK_ORG_SH = "1010";
    public static final String PK_ORG_TJ = "1011";

    /*************************自动柜员（批处理记账等用）***************************/
    // sys2
    public static final String PK_AUTO_USER1 = "0001A21000000005A8S3";

    /*************************短信插件ID名称（JFL用）***************************/
    public static final String SMS_INTERFACE_PARAMETER = "000263";

    /*************************国民经济行业分类  参数值 value***************************/
    /** 行业门类为‘教育’*/
    public static final String V_CATEGORY_EDUCATION = "P";
    /** 行业门类（大类）‘教育’*/
    public static final String V_CATEGORY_EDUCATION_BIG = "P82";
    /** 行业门类为‘卫生和社会工作’*/
    public static final String V_CATEGORY_HYGIENE = "Q";
    /** 行业门类（大类）‘卫生’*/
    public static final String V_CATEGORY_HYGIENE_BIG = "Q83";
    /** 行业门类为‘制造业’*/
    public static final String V_CATEGORY_MANUFACTURE = "C";
    /** 行业门类（大类）‘印刷和记录媒介复制品’*/
    public static final String V_CATEGORY_PRINTING_BIG = "C23";
    /** 行业门类（大类）‘铁路、船舶、航空航天和其他运输设备制造业’*/
    public static final String V_CATEGORY_RAILWAY = "C37";
    /** 行业门类为‘交通运输、仓储和邮政业’*/
    public static final String V_CATEGORY_TRANSPORTATION = "G";
    /** 行业门类（大类）‘水上运输业’*/
    public static final String V_CATEGORY_WATER_TRANSPORT = "G55";

    /*************************国民经济行业分类  参数编码 code***************************/
    /** 行业门类为‘教育’ */
    public static final String C_CATEGORY_EDUCATION = "P";
    /** 行业门类（大类）‘教育’*/
    public static final String C_CATEGORY_EDUCATION_BIG = "82";
    /** 行业门类为‘卫生和社会工作’*/
    public static final String C_CATEGORY_HYGIENE = "Q";
    /** 行业门类（大类）‘卫生’*/
    public static final String C_CATEGORY_HYGIENE_BIG = "83";
    /** 行业门类为‘制造业’*/
    public static final String C_CATEGORY_MANUFACTURE = "C";
    /** 行业门类（大类）‘印刷和记录媒介复制品’*/
    public static final String C_CATEGORY_PRINTING_BIG = "23";
    /** 行业门类（大类）‘铁路、船舶、航空航天和其他运输设备制造业’*/
    public static final String C_CATEGORY_RAILWAY = "37";
    /** 行业门类为‘交通运输、仓储和邮政业’*/
    public static final String C_CATEGORY_TRANSPORTATION = "G";
    /** 行业门类（大类）‘水上运输业’*/
    public static final String C_CATEGORY_WATER_TRANSPORT = "55";
    /*************************国民经济行业分类  参数值 type***************************/
    public static final String CATEGORY_PARAM_TYPE = "5";
    /*************************文档规则设置 规则编号 ***************************/
    /** 租赁资产转移 */
    public static final String LEASE_ASSET_TRANSFER = "SYQ01";
    /** 预测罚息 -电信 */
    public static final String FORECAST_PENALTY_ONE = "YQZJ01";
    /** 预测罚息 -非电信 */
    public static final String FORECAST_PENALTY_TWO = "DXCS01";
    /** 承租人预测罚息 -电信 */
    public static final String FORECAST_PENALTYCUSR_ONE = "CZYCFX01";
    /*************************枚举字典 是否启用***************************/
    /** 启用 */
    public static final String YES = "Y";
    /** 不启用 */
    public static final String NO = "N";

    /************************* 文档类型 ***************************/
    /** 租赁明细表 */
    public static final String RENTDETAIL_DOCTYPE = "0001AA1000000001WBWL";

    /** 资产减值准备测算表 */
    public static final String ASSETS_PREPAR_CAL_DOCTYPE = "0001AA1000000000ICQX";

    /** 租赁物（国标） */
    public static final String RENT_THING_COUNTRY = "000250";

    /** 租赁物（银监会） */
    public static final String RENT_THING_FINAL = "000251";
    /************************* 文档分类  ***************************/
    /**文档分类*/
    public static final String DOCUMENT_TYPE = "000252";
    /** 票据 */
    public static final String DOCUMENT_CLASSIFICATION_BILL = "YX013";
    /**客户评级报告*/
    public static final String DOCUMENT_CODE_1 = "YX022001";
    /************************* 邮件分类  ***************************/
    /**邮件管理人编码*/
    public static final String MAIL_MANAGER_CODE = "EMAIL_AMIN";

    public static final String FLOW_HIDDEN_TYPE_H = "1";
    public static final String FLOW_HIDDEN_TYPE_S = "2";
    public static final String FLOW_HIDDEN_TYPE_N = "3";
    /**核算主体（香港分公司） */
    public static final String GLORG_BOOK_H_K = "0001A9100000000016L3";

    /** WJJ ADD 20160715 根据合同所属公司 和 角色名称 下的 获取所有人员 */
    /** 起租重算 发生待办 角色名称*/
    public static final String BEIGIN_ROLE = "YLS_QZ";
    /** ADD WJJ 20160719 待办提示销售 这俩节点 不要引用这个 主题消息 因为我会拿他做条件删除*/
    /** 起租重算待办 消息 */
    public static final String BEGIN_RENT_ALTER_TASK_MESSAGE = "起租重算通知";
    /** 项目起租待办 消息 */
    public static final String BEGIN_RENT_STATUS_TASK_MESSAGE = "项目起租通知";
    /** ADD END*/
    /** ADD WJJ 20160809 核销审核待办主体消息 */
    public static final String GATHER_AUDIT_TASK_MESSAGE = "核销审核撤销通知";
    /** ADD niul 20170607 未开票代办消息 */
    public static final String INVOICE_TASK_MESSAGE = "合同结清（电信）未开票合同信息";
    /** ADD END*/

    /** WJJ ADD END */

    /**ZTYW-257 ADD WANGJJ 20160907*/
    /**客户性质(内部)*/
    public static final int PARMS_CUST_TYPE_IN = 269;
    /**ZTYW-257 END*/
    /** INSERT  【wangxy】 【2016-12-8】 【项目审批报告】<会议期数、总期数号> */
    public static final String NODE_MEETINGNPER = "审批委秘书(会议准备)";
    /** INSERT  END */
    /** INSERT  【wangxy】 【2016-1-6】 【项目审批报告】<会议期数、总期数> */
    public static final String NODE_MEETINGNPER_START = "市场部负责人(审核)";
    public static final String NODE_MEETINGNPER_END = "审批委秘书（审核）";
    public static final String SCBYWY_SUBMIT = "市场部业务员(提交)";
    /** INSERT  END */
    /** INSERT  【wangxy】 【2017-3-8】 【集团接口后期需求】<批量审核待办> */
    /** 集团接口待办 消息 */
    public static final String PACKDATAITEM_TASK_MESSAGE = "集团指标数据采集通知";
    /** INSERT  END */
    /** ADD WJJ 20161108 事件类别 “收租” 主键 */
    public static final String TRANS_TYPE_RENT = "0001AA10000000007NGV";
    public static final String TRANS_TYPE_REFUND = "0001AA10000000007NHH";
    /** WJJ ADD END */
    /** INSERT  【wangxy】 【2017-4-14】 【批量合同结清】 */
    /** 批量合同结清 消息 */
    public static final String CONTRACTBATCHSETTLE_TASK_MESSAGE = "批量合同结清(电信)";
    /** INSERT  END */
    /** INSERT  【niul】 【2017年6月14日】 【BUG修改】<BUG号 JIRA-BUG号> */
    /** 批量合同结清 驳回修改消息 */
    public static final String CONTRACTBATCHSETTLE_TASK_DISMISS_MESSAGE = "结清合同（电信）被驳回";
    /** INSERT  END */



    public static final String ADJUSTAPPLYSYS_TASK_MESSAGE = "系统调息";

    public static final String ADJUSTAPPLYSYS_TASK_DISMISS_MESSAGE = "系统调息被驳回";



    /** INSERT  【lvcn】 【2017年6月1日】 【BUG修改】<BUG号 JIRA-BUG号> */
    /* 注册登记号类型 */
    //统一社会信用代码
    public static final Short REG_UNIFIED_NUM = 7;

    /** INSERT  END */

    /** INSERT  【lvcn】 【2017年6月7日】 【BUG修改】<BUG号 JIRA-BUG号> */
    /** 提醒方式*/
    /**短信*/
    public static final Short REIND_NOTE = 0;
    /**邮件*/
    public static final Short REIND_MAIL = 1;
    /**通知函*/
    public static final Short REIND_NOTIEC = 2;

    /** 提醒类别 */
    /**提前提醒*/
    public static final Short REMIND_CATEGORY_PRE = 0;
    /**逾期提醒*/
    public static final Short REMIND_CATEGORY_OVERDUE = 1;
    /** INSERT  END */

    /** ADD WJJ 20170819 BUG修改 ZTYW-827 START*/
    public static final String YLS_SP_YJ = "YLS_SP_YJ";

    public static final String YLS_SPW = "YLS_SPW";
    /** ADD WJJ 20170819 BUG修改 ZTYW-827 END*/

    /**add by jiaoshy 咨询费收入  事件类别 */
    public static final String CONSULT_YRANS_TYPE = "0001AA1000000000TT5M";

    public static final String CURRENT_VALUE = "db65e7e9-aa8e57b2a-1";
    /*add end*/

    /**add by mengxy 开票内容 咨询费*/
    public static final String INVOICE_PLAN_CONSULTING = "9";
}