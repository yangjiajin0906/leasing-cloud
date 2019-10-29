package com.leasing.common.enums.constant;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:枚举常量类
 **/
public class PubEnumsConstant {
    /**
     * 利率种类 枚举 人行存款利率
     */
    public static final Short RATE_CLASS_FUND = 0;
    /**
     * 利率种类 枚举 人行贷款利率
     */
    public static final Short RATE_CLASS_LEND = 1;

    /**
     * 抵质押状态   抵质押中
     */
    public static final Short COLLATERAL_YES  = 0;
    /**
     * 抵质押状态    已解押
     */
    public static final Short COLLATERAL_NO = 1;

    /**
     * 利率种类 枚举 SHIBOR利率
     */
    public static final Short RATE_CLASS_SHIBOR = 2;

    /**
     * 利率种类 枚举 LIBOR利率
     */
    public static final Short RATE_CLASS_LIBOR = 3;

    /**
     * 利率种类[1000117]<br>
     * 资金成本利率
     */
    public static final Short RATE_CLASS_FUNDS_COST = 4;
    /**
     * 利率种类[1000117]<br>
     * SWAP利率掉期利率
     */
    public static final Short RATE_CLASS_SWAP = 5;

    /**
     * 存款利率档次 枚举 活期
     */
    public static final Short LUMPRATE_LEVEL_CURRENT = 0;

    /**
     * 存款利率档次 枚举 3个月整存整取
     */
    public static final Short LUMPRATE_LEVEL_MONTH_3 = 1;

    /**
     * 存款利率档次 枚举 6个月整存整取
     */
    public static final Short LUMPRATE_LEVEL_MONTH_6 = 2;

    /**
     * 存款利率档次 枚举 1年整存整取
     */
    public static final Short LUMPRATE_LEVEL_YEAR_1 = 3;

    /**
     * 存款利率档次 枚举 2年整存整取
     */
    public static final Short LUMPRATE_LEVEL_YEAR_2 = 4;

    /**
     * 存款利率档次 枚举 3年整存整取
     */
    public static final Short LUMPRATE_LEVEL_YEAR_3 = 5;

    /**
     * 存款利率档次 枚举 5年整存整取
     */
    public static final Short LUMPRATE_LEVEL_YEAR_5 = 6;

    /**
     * 贷款利率档次 枚举 六个月以内（含六个月）
     */
    public static final Short LENDRATE_LEVEL_MONTH_1TO6 = 0;

    /**
     * 贷款利率档次 枚举 六个月至一年（含一年）
     */
    public static final Short LENDRATE_LEVEL_MONTH_6TO12 = 1;

    /**
     * 贷款利率档次 枚举 一至三年（含三年）
     */
    public static final Short LENDRATE_LEVEL_YEAR_1TO3 = 2;

    /**
     * 贷款利率档次 枚举 三至五年（含五年）
     */
    public static final Short LENDRATE_LEVEL_YEAR_3TO5 = 3;

    /**
     * 贷款利率档次 枚举 五年以上
     */
    public static final Short LENDRATE_LEVEL_UP_YEAR_5 = 4;

    /**
     * 租金表类型 枚举 完整规则
     */
    public static final Short RENT_TYPE_FULL = 0;

    /**
     * 租金表类型 枚举 不规则
     */
    public static final Short RENT_TYPE_NO = 2;

    /**
     * 租金表类型 枚举 标准规则
     */
    public static final Short RENT_TYPE_STANDARD = 1;

    /**
     * 高中低 枚举 高
     */
    public static final Short HEIGHT_HIGH = 0;

    /**
     * 高中低 枚举 中
     */
    public static final Short HEIGHT_CENTRE = 1;

    /**
     * 高中低 枚举 低
     */
    public static final Short HEIGHT_LOW = 2;

    /**
     * 数据采集表样分类 枚举 财务报表
     */
    public static final Short THE_FINANCIAL_STATEMENTS_THE_FINANCIAL_STATEMENTS = 0;

    /**
     * 数据采集表样分类 枚举 行业报表
     */
    public static final Short THE_FINANCIAL_STATEMENTS_INDUSTRY_REPORT = 1;

    /**
     * 数据采集表样分类 枚举 收支表
     */
    public static final Short THE_FINANCIAL_STATEMENTS_BALANCE_SHEET = 2;

    /**
     * 启用状态 枚举 启用
     */
    public static final Short START_OR_STOP_START = 0;

    /**
     * 启用状态 枚举 封存
     */
    public static final Short START_OR_STOP_STOP = 1;

    /**
     * 启用状态 枚举 未启用
     */
    public static final Short START_OR_STOP_NO_START = 2;

    /**
     * 频率 枚举 双月
     */
    public static final Short PERIOD_DOUBLE_MONTH = 1;

    /**
     * 频率 枚举 四月
     */
    public static final Short PERIOD_FOUR_MONTH = 3;

    /**
     * 数据采集表样分类 枚举 银行贷款表
     */
    public static final Short THE_FINANCIAL_STATEMENTS_BANK_LOAN_TABLE = 3;

    /**
     * 数据采集表样分类 枚举 融资租赁表
     */
    public static final Short THE_FINANCIAL_STATEMENTS_FINANCING_LEASE_TABLE = 4;

    /**
     * 数据采集表样分类 枚举 特殊行业基础数据
     */
    public static final Short THE_FINANCIAL_STATEMENTS_SPECIAL_INDUSTRY_BASED_DATA = 5;

    /**
     * 采样频率 枚举 月报
     */
    public static final Short REPORT_MONTHLY = 0;

    /**
     * 采样频率 枚举 季报
     */
    public static final Short REPORT_QUARTERLY = 1;

    /**
     * 采样频率 枚举 半年报
     */
    public static final Short REPORT_THE = 2;

    /**
     * 采样频率 枚举 年报
     */
    public static final Short REPORT_THE_ANNUAL = 3;

    /**
     * 影响IRR类别 枚举 对项目IRR影响
     */
    public static final Short IRRTYPE_PRG = 0;

    /**
     * 影响IRR类别 枚举 对手续费分配IRR影响
     */
    public static final Short IRRTYPE_SRVFEE = 1;

    /**
     * 影响IRR类别 枚举 对租金IRR影响
     */
    public static final Short IRRTYPE_LEASE = 2;

    /**
     * 影响IRR类别 枚举 对项目去税IRR影响
     */
    public static final Short IRRTYPE_PRG_NOTAX = 3;

    /**
     * 影响IRR类别 枚举 对承租人IRR影响
     */
    public static final Short IRRTYPE_PRG_LESSEE = 4;

    /**
     * 影响IRR类别 枚举 对租赁合同IRR影响
     */
    public static final Short IRRTYPE_PRG_CONTRACT = 5;

    /**
     * 影响IRR类别 枚举 对审计IRR影响
     */
    public static final Short IRRTYPE_PRG_AUDIT = 6;
    /**
     * 对中投会计表IRR影响(含保证金相关)
     */
    public static final Short RRTYPE_ACC_DEPOSIT_ZT = 7;
    /**
     * 对中投会计表IRR影响(不含保证金相关)
     */
    public static final Short RRTYPE_ACC_ZT = 8;

    /**
     * 出资方式 枚举 实物
     */
    public static final Short EQUITY_PART_MATERIAL = 0;

    /**
     * 出资方式 枚举 现金
     */
    public static final Short EQUITY_PART_MONEY = 1;

    /**
     * 出资方式 枚举 实物+现金
     */
    public static final Short EQUITY_PART_ALL = 2;

    /**
     * 科技型企业类型 枚举 初始期
     */
    public static final Short BUSINESS_ENTE_INIT = 0;

    /**
     * 科技型企业类型 枚举 发展期
     */
    public static final Short BUSINESS_ENTE_DEVE = 1;

    /**
     * 科技型企业类型 枚举 成熟期
     */
    public static final Short BUSINESS_ENTE_MATU = 2;

    /**
     * 收支方向 枚举 收入
     */
    public static final Short PAYINCOME_INCOME = 0;

    /**
     * 收支方向 枚举 支出
     */
    public static final Short PAYINCOME_PAY = 1;

    /**
     * 利息计算方式 枚举 期复息
     */
    public static final Short INTEREST_METHOD_TERM = 0;

    /**
     * 利息计算方式 枚举 日复息
     */
    public static final Short INTEREST_METHOD_DAY = 1;

    /**
     * 服务费收取方式 枚举 期初一次性收取
     */
    public static final Short SRVCHARGE_ONE = 0;

    /**
     * 服务费收取方式 枚举 每年收取
     */
    public static final Short SRVCHARGE_EVERY_YEAR = 2;

    /**
     * 服务费收取方式 枚举 手工维护
     */
    public static final Short SRVCHARGE_MANUAL = 3;

    /**
     * 合格、不合格 枚举 合格
     */
    public static final Short QUALIFIED_YES = 0;

    /**
     * 合格、不合格 枚举 不合格
     */
    public static final Short QUALIFIED_NO = 1;

    /**
     * 企业规模 枚举 大型
     */
    public static final Short ENTERPRISE_LARGE = 0;

    /**
     * 企业规模 枚举 中型
     */
    public static final Short ENTERPRISE_MEDIUM = 1;

    /**
     * 企业规模 枚举 小型
     */
    public static final Short ENTERPRISE_SMALL = 2;

    /**
     * 企业规模 枚举 微型
     */
    public static final Short ENTERPRISE_MINIATURE = 3;

    /**
     * 有无 枚举 有
     */
    public static final Short HAVE_YES = 0;

    /**
     * 有无 枚举 无
     */
    public static final Short HAVE_NO = 1;

    /**
     * 注册地隶属 枚举 区县属及以上
     */
    public static final Short DISTRICT_ABOVE = 0;

    /**
     * 注册地隶属 枚举 区县属及以下
     */
    public static final Short DISTRICT_FOLLOW = 1;

    /**
     * 所有权 枚举 自有
     */
    public static final Short OWNERSHIP_OWN = 0;

    /**
     * 所有权 枚举 租赁
     */
    public static final Short OWNERSHIP_LEASE = 1;

    /**
     * 还款周期 枚举 按月
     */
    public static final Short REPAY_PERIOD_PER_MENSEM = 0;

    /**
     * 股票类型 枚举 A股
     */
    public static final Short SHARE_A = 0;

    /**
     * 股票类型 枚举 B股
     */
    public static final Short SHARE_B = 1;

    /**
     * 股票类型 枚举 H股
     */
    public static final Short SHARE_H = 2;

    /**
     * 股票类型 枚举 N股
     */
    public static final Short SHARE_N = 3;

    /**
     * 股票类型 枚举 S股
     */
    public static final Short SHARE_S = 4;

    /**
     * 还款周期 枚举 按季
     */
    public static final Short REPAY_PERIOD_QUARTERLY = 1;

    /**
     * 还款周期 枚举 按半年
     */
    public static final Short REPAY_PERIOD_HALF_YEAR = 2;

    /**
     * 还款周期 枚举 按年
     */
    public static final Short REPAY_PERIOD_PER_ANNUM = 3;

    /**
     * 无 枚举 无
     */
    public static final Short NO_NOTHING = 0;

    /**
     * 交流方式 枚举 面谈
     */
    public static final Short COMM_INTERVIEW = 0;

    /**
     * 交流方式 枚举 电话
     */
    public static final Short COMM_TELEPHONE = 1;

    /**
     * 交流方式 枚举 网络会议
     */
    public static final Short COMM_NETWORK_CONFERENCE = 2;

    /**
     * 上下游类别 枚举 上游
     */
    public static final Short UPDOWNTYPE_UP = 0;

    /**
     * 上下游类别 枚举 下游
     */
    public static final Short UPDOWNTYPE_DOWN = 1;

    /**
     * 所有权 枚举 其他
     */
    public static final Short OWNERSHIP_OTHER = 2;

    /**
     * 关系分类 枚举 股权关系
     */
    public static final Short RELATION_EQUITY = 0;

    /**
     * 关系分类 枚举 关联关系
     */
    public static final Short RELATION_INCIDENCE = 1;

    /**
     * 关系分类 枚举 债权关系
     */
    public static final Short RELATION_CREDITOR = 2;

    /**
     * 关系分类 枚举 担保关系
     */
    public static final Short RELATION_SECURITY = 3;

    /**
     * 关系分类 枚举 业务关系
     */
    public static final Short RELATION_BUSINESS = 4;

    /**
     * 是否 枚举 是
     */
    public static final Short IF_YES = 0;

    /**
     * 是否 枚举 否
     */
    public static final Short IF_NO = 1;

    /**
     * 现金流方向 枚举 付款
     */
    public static final Short CASH_PAY = 1;

    /**
     * 现金流方向 枚举 收款
     */
    public static final Short CASH_GATHING = 0;

    /**
     * 编辑状态 枚举 编辑
     */
    public static final Short EDIT_STATUS_EDIT = 0;

    /**
     * 编辑状态 枚举 禁止
     */
    public static final Short EDIT_STATUS_PROHIBIT = 1;

    /**
     * IRR倒算对象 枚举 租息率
     */
    public static final Short IRRCONVERT_REST_RATE = 0;

    /**
     * IRR倒算对象 枚举 手续费
     */
    public static final Short IRRCONVERT_SRVIN = 1;

    /**
     * IRR倒算对象 枚举 风险金
     */
    public static final Short IRRCONVERT_DEPOSIT = 2;

    /**
     * IRR倒算对象 枚举 首付款
     */
    public static final Short IRRCONVERT_FIRST_CASH = 3;

    /**
     * 数据权限类型 枚举 全部数据
     */
    public static final Short DATA_POWER_ALL = 0;

    /**
     * 数据权限类型 枚举 机构
     */
    public static final Short DATA_POWER_ORG = 1;

    /**
     * 数据权限类型 枚举 部门
     */
    public static final Short DATA_POWER_DEPT = 2;

    /**
     * 数据权限类型 枚举 个人
     */
    public static final Short DATA_POWER_PERSONAL = 3;

    /**
     * 数据权限类型 枚举 本机构
     */
    public static final Short CURR_ORG = 4;

    /**
     * 数据权限类型 枚举 本部门
     */
    public static final Short CURR_DEPT = 5;

    /**
     * 数据权限类型 枚举 本人
     */
    public static final Short CURR_PER = 6;

    /**
     * 资产类型 枚举 无
     */
    public static final Short ASSETS_TYPE_NO_CAPITAL_TYPE = 0;

    /**
     * 资产类型 枚举 资产不动产
     */
    public static final Short ASSETS_TYPE_THE_REAL_ESTATE = 1;

    /**
     * 资产类型 枚举 资产动产
     */
    public static final Short ASSETS_TYPE_PERSONAL_PROPERTY = 2;

    /**
     * 资产类型 枚举 抵押物件不动产
     */
    public static final Short ASSETS_TYPE_MORTGAGE_ESTATE = 3;

    /**
     * 资产类型 枚举 抵押物件动产
     */
    public static final Short ASSETS_TYPE_MORTGAGE_PROPERTY = 4;

    /**
     * 资产类型 枚举 质押物件权利
     */
    public static final Short ASSETS_TYPE_PLEDGE_WARRANT = 5;

    /**
     * 资产类型 枚举 质押物件动产
     */
    public static final Short ASSETS_TYPE_PLEDGE_PROPERTY = 6;

    /**
     * 资产类型 枚举 厂商回购
     */
    public static final Short ASSETS_TYPE_PLEDGE_BUSINESS_BACK = 7;


    /**
     * 有无抵押 枚举 有
     */
    public static final Short PLEDGE_THERE_ARE = 0;

    /**
     * 有无抵押 枚举 无
     */
    public static final Short PLEDGE_NO_IMPAWN = 1;

    /**
     * 附件分类 枚举 证照复印件
     */
    public static final Short ATTACHMENT_COPY = 0;

    /**
     * 附件分类 枚举 财务报告
     */
    public static final Short ATTACHMENT_FINANCIAL = 1;

    /**
     * 附件分类 枚举 其他
     */
    public static final Short ATTACHMENT_OTHER = 2;

    /**
     * 授信品种 枚举 流动资金贷款
     */
    public static final Short CAPITAL_VARIETY_FLOW = 0;

    /**
     * 授信品种 枚举 有追索保理
     */
    public static final Short CAPITAL_VARIETY_HAVE = 1;

    /**
     * 授信品种 枚举 无追索保理
     */
    public static final Short CAPITAL_VARIETY_NOT= 2;

    /**
     * 授信品种 枚举 银信理财
     */
    public static final Short CAPITAL_VARIETY_BANK = 3;

    /**
     * 授信品种 枚举 银证资管
     */
    public static final Short CAPITAL_VARIETY_INFO= 4;
    /**
     * 授信品种 枚举 其他
     */
    public static final Short CAPITAL_VARIETY_OTHER= 5;
    /**
     * 授信品种 枚举 其他
     */
    public static final Short CAPITAL_VARIETY_GUARANTEE= 6;
    /**
     * 授信品种 枚举 其他
     */
    public static final Short CAPITAL_VARIETY_BILL= 7;
    /**
     * 授信品种 枚举 其他
     */
    public static final Short CAPITAL_VARIETY_LETTER= 8;
    /**
     * 授信品种 枚举 全部
     */
    public static final Short CAPITAL_VARIETY_FULL= 9;
    /**
     * 内部调拨
     */
    public static final Short CAPITAL_VARIETY_IN= 19;
    /**
     * 融资品种 枚举 银行贷款
     */
    public static final Short FINANCING_TYPE_A_BANK_LOAN = 0;

    /**
     * 融资品种 枚举 信托贷款
     */
    public static final Short FINANCING_TYPE_TRUST_LOANS = 1;

    /**
     * 融资品种 枚举 融资租赁
     */
    public static final Short FINANCING_TYPE_FINANCING_LEASE = 2;

    /**
     * 融资品种 枚举 民间贷款
     */
    public static final Short FINANCING_TYPE_THE_FOLK_LENDING = 3;

    /**
     * 融资品种 枚举 承兑汇票
     */
    public static final Short FINANCING_TYPE_ACCEPTANCE_OF_DRAFT = 4;

    /**
     * 担保方式 枚举 个人担保
     */
    public static final Short GUARANTEE_PERSONAL = 0;

    /**
     * 担保方式 枚举 单位担保
     */
    public static final Short GUARANTEE_THE_UNIT = 1;

    /**
     * 担保方式 枚举 全额担保
     */
    public static final Short GUARANTEE_A_FULL = 2;

    /**
     * 担保方式 枚举 无担保
     */
    public static final Short GUARANTEE_NOT = 3;

    /**
     * 医院等级 枚举 三级特等
     */
    public static final Short HOSPITAL_THREE_SPECIAL = 0;

    /**
     * 医院等级 枚举 三级甲等
     */
    public static final Short HOSPITAL_THREE_FIRST = 1;

    /**
     * 医院等级 枚举 三级乙等
     */
    public static final Short HOSPITAL_THREE_SECOND = 2;

    /**
     * 医院等级 枚举 三级丙等
     */
    public static final Short HOSPITAL_THREE_THIRD = 3;

    /**
     * 医院等级 枚举 二级甲等
     */
    public static final Short HOSPITAL_TWO_FIRST = 4;

    /**
     * 医院等级 枚举 二级乙等
     */
    public static final Short HOSPITAL_TWO_SECOND = 5;

    /**
     * 医院等级 枚举 二级丙等
     */
    public static final Short HOSPITAL_TWO_THIRD = 6;

    /**
     * 医院等级 枚举 一级甲等
     */
    public static final Short HOSPITAL_ONE_FIRST = 7;

    /**
     * 医院等级 枚举 一级乙等
     */
    public static final Short HOSPITAL_ONE_SECOND = 8;

    /**
     * 医院等级 枚举 一级丙等
     */
    public static final Short HOSPITAL_ONE_THIRD = 9;

    /**
     * 医院等级 枚举 无
     */
    public static final Short HOSPITAL_HOSPITAL_NOTHING = 10;

    /**
     * 学校等级 枚举 普通教育
     */
    public static final Short SCHOOL_GENERAL = 0;

    /**
     * 学校等级 枚举 职业高中
     */
    public static final Short SCHOOL_VOCATIONAL = 1;

    /**
     * 学校等级 枚举 大学专科
     */
    public static final Short SCHOOL_COLLEGE = 2;

    /**
     * 学校等级 枚举 本科三本
     */
    public static final Short SCHOOL_UNDE_THREE = 3;

    /**
     * 学校等级 枚举 本科二本
     */
    public static final Short SCHOOL_UNDE_TWO = 4;

    /**
     * 学校等级 枚举 本科一本
     */
    public static final Short SCHOOL_UNDE_ONE = 5;

    /**
     * 客户类别 枚举 单位客户
     */
    public static final Short CUSTOMER_TYPE_CORP = 0;

    /**
     * 客户类别 枚举 自然人客户
     */
    public static final Short CUSTOMER_TYPE_PERSON = 1;

    /**
     * 证件类型 枚举 组织机构代码
     */
    public static final Short IDENTITY_TYPE_ORGANIZATION_CODE = 0;

    /**
     * 证件类型 枚举 身份证
     */
    public static final Short IDENTITY_TYPE_IDENTITY = 1;

    /**
     * 证件类型 枚举 执照
     */
    public static final Short IDENTITY_TYPE_LICENSE = 2;

    /**
     * 证件类型 枚举 驾照
     */
    public static final Short IDENTITY_TYPE_DRIVING_LICENSE = 3;

    /**
     * 性别 枚举 未知的性别
     */
    public static final Short SEX_UNKNOWN_SEX = 0;

    /**
     * 性别 枚举 男性
     */
    public static final Short SEX_MAN = 1;

    /**
     * 性别 枚举 女性
     */
    public static final Short SEX_WOMEN = 2;

    /**
     * 性别 枚举 未说明性别
     */
    public static final Short SEX_NO_DECLARE_SEX = 3;

    /**
     * 民族 枚举 未知
     */
    public static final Short RACE_UNKNOWN = 0;

    /**
     * 民族 枚举 汉族
     */
    public static final Short RACE_HAN_RACE = 1;

    /**
     * 民族 枚举 满足
     */
    public static final Short RACE_MAN_RACE = 2;

    /**
     * 民族 枚举 维吾尔族
     */
    public static final Short RACE_WEIWUER_RACE = 3;

    /**
     * 政治面貌 枚举 中共党员
     */
    public static final Short POLITICAL_PARTY_MEMBER = 0;

    /**
     * 政治面貌 枚举 中共预备党员
     */
    public static final Short POLITICAL_PREPARE_PARTY_MEMBER = 1;

    /**
     * 政治面貌 枚举 共青团员
     */
    public static final Short POLITICAL_MEMBER = 2;

    /**
     * 政治面貌 枚举 民革党员
     */
    public static final Short POLITICAL_MINGE_PARTY_MEMBER = 3;

    /**
     * 政治面貌 枚举 民盟盟员
     */
    public static final Short POLITICAL_MINMNEG_ALLIANCE = 4;

    /**
     * 政治面貌 枚举 民建会员
     */
    public static final Short POLITICAL_MINJIAN_MEMBER = 5;

    /**
     * 政治面貌 枚举 民进会员
     */
    public static final Short POLITICAL_MINJIN_MEMBER = 6;

    /**
     * 政治面貌 枚举 农工党党员
     */
    public static final Short POLITICAL_PEASANT_PARTY_MEMBER = 7;

    /**
     * 政治面貌 枚举 致公党党员
     */
    public static final Short POLITICAL_ZHIGONG_PARTY_MEMBER = 8;

    /**
     * 政治面貌 枚举 九三学社社员
     */
    public static final Short POLITICAL_JIUSANXUESHE_COMMUNE = 9;

    /**
     * 政治面貌 枚举 台盟盟员
     */
    public static final Short POLITICAL_TAIMENG_ALLIANCE = 10;

    /**
     * 政治面貌 枚举 无党派民主党
     */
    public static final Short POLITICAL_NONPARTY = 11;

    /**
     * 政治面貌 枚举 群众
     */
    public static final Short POLITICAL_THE_MASSES = 12;

    /**
     * 婚姻状态 枚举 已婚
     */
    public static final Short MARRIAGE_MARRIED = 0;

    /**
     * 婚姻状态 枚举 未婚
     */
    public static final Short MARRIAGE_SPINSTERHOOD = 1;

    /**
     * 婚姻状态 枚举 离异
     */
    public static final Short MARRIAGE_DIVORCED = 2;

    /**
     * 婚姻状态 枚举 丧偶
     */
    public static final Short MARRIAGE_LOSE_SPOUSE = 3;

    /**
     * 婚姻状态 枚举 无配偶
     */
    public static final Short MARRIAGE_MATELESS = 4;

    /**
     * 婚姻状态 枚举 同居
     */
    public static final Short MARRIAGE_LIVE_TOGETHER = 5;

    /**
     * 最高学历 枚举 研究生
     */
    public static final Short EDUCATION_GRADUATE_STUDENT = 0;

    /**
     * 最高学历 枚举 大学本科
     */
    public static final Short EDUCATION_UNIVERSITY_UNDERGRADUATE_COURSE = 1;

    /**
     * 最高学历 枚举 大学专科和专科学校
     */
    public static final Short EDUCATION_COLLEGE_AND_SCHOOL = 2;

    /**
     * 最高学历 枚举 中等专业学校和中等技术学校
     */
    public static final Short EDUCATION_SECONDARY_SPECIALIZED = 3;

    /**
     * 最高学历 枚举 高中
     */
    public static final Short EDUCATION_SENIOR_HIGH_SCHOOL = 4;

    /**
     * 最高学历 枚举 初中
     */
    public static final Short EDUCATION_JUNIOR_HIGH_SCHOOL = 5;

    /**
     * 最高学历 枚举 小学
     */
    public static final Short EDUCATION_GRADE_SCHOOL = 6;

    /**
     * 最高学历 枚举 文盲或半文盲
     */
    public static final Short EDUCATION_ILLITERATE_OR_SEMI_LITERATE = 7;

    /**
     * 最高学历 枚举 未知
     */
    public static final Short EDUCATION_THE_UNKNOWN = 8;

    /**
     * 最高学位 枚举 无
     */
    public static final Short DEGREE_NO_DEGREE = 0;

    /**
     * 最高学位 枚举 学士
     */
    public static final Short DEGREE_BACHELORS_DEGREE = 1;

    /**
     * 最高学位 枚举 硕士
     */
    public static final Short DEGREE_MASTERS_DEGREE = 2;

    /**
     * 最高学位 枚举 博士
     */
    public static final Short DEGREE_DOCTOR = 3;

    /**
     * 最高学位 枚举 博士后
     */
    public static final Short DEGREE_POSTDOCTORAL = 4;

    /**
     * 居住状态 枚举 自己
     */
    public static final Short LIVE_STATUS_ONESELF = 0;

    /**
     * 居住状态 枚举 租赁
     */
    public static final Short LIVE_STATUS_LEASE = 1;

    /**
     * 居住状态 枚举 其他
     */
    public static final Short LIVE_STATUS_OTHER = 2;

    /**
     * 投放金额取值范围 枚举 500万以下
     */
    public static final Short PLANCASH_FMIL_DOWN = 0;

    /**
     * 投放金额取值范围 枚举 500万~2000万
     */
    public static final Short PLANCASH_BETWEEN_FM_TTM = 1;

    /**
     * 投放金额取值范围 枚举 2000万~5000万
     */
    public static final Short PLANCASH_BETWEEN_TTM_FTM = 2;

    /**
     * 投放金额取值范围 枚举 5000万以下
     */
    public static final Short PLANCASH_FTMIL_DOWN = 3;

    /**
     * 租赁方式 枚举 直租
     */
    public static final Short RENT_METHOD_PLUMPLY = 0;

    /**
     * 租赁方式 枚举 回租
     */
    public static final Short RENT_METHOD_CALLBACK = 1;

    /**
     * 租赁方式 枚举 无
     */
    public static final Short RENT_METHOD_NULL = 2;

    /**
     * 租赁方式 枚举 直租+回租
     */
    public static final Short RENT_METHOD_PLUMPLY_AND_CALLBACK = 3;

    /**
     /**
     * 保证金收取方式 枚举 期初一次性收取
     */
    public static final Short DEPOSIT_GM_ONE = 0;

    /* 事件类别对IRR影响设置值 枚举 增加
     */
    public static final Short IRREVENT_ADD = 0;

    /**
     * 事件类别对IRR影响设置值 枚举 减小
     */
    public static final Short IRREVENT_SUB = 1;

    /**
     * 租金表调整对象 枚举 租金
     */
    public static final Short ADJUST_RENT = 0;

    /**
     * 业务模块 枚举 资金业务
     */
    public static final Short BUSI_MODEL_CAPITAL = 0;

    /**
     * 业务模块 枚举 租赁业务
     */
    public static final Short BUSI_MODEL_LEASE = 1;

    /**
     * 业务模块 枚举 保理业务
     */
    public static final Short BUSI_MODEL_FACTOR = 4;

    /**
     * 最后一期收租计算规则 枚举 重算利息
     */
    public static final Short AFTERCALRULE_RE_INTEREST = 0;

    /**
     * 最后一期收租计算规则 枚举 重算租金
     */
    public static final Short AFTERCALRULE_RE_RENT = 1;

    /** ADD WJJ 20160706 BUG修改 只能修改交易类别计划日期 租金或本金或 租金本金利息 根据租金调整对象*/
    /**
     * 租金表调整对象 枚举 租金
     */
    public static final Short ADJUST_CASH = 0;
    /** ADD END*/

    /**
     * 租金表调整对象 枚举 本金
     */
    public static final Short ADJUST_CURPUS = 1;

    /**
     * 租金表调整对象 枚举 不限
     */
    public static final Short ADJUST_UNLIMITED = 2;

    /**
     * 账户性质 枚举 一般户
     */
    public static final Short DOOR_GENERAL = 0;

    /**
     * 账户性质 枚举 基本户
     */
    public static final Short DOOR_BASIC = 1;

    /**
     * 账户性质 枚举 监管户
     */
    public static final Short DOOR_SUPERVISION = 2;

    /**
     * 账户使用状态 枚举 有效
     */
    public static final Short ACCOUNT_USE_EFFE = 0;

    /**
     * 账户使用状态 枚举 冻结
     */
    public static final Short ACCOUNT_USE_LOGO = 1;

    /**
     * 账户使用状态 枚举 销户
     */
    public static final Short ACCOUNT_USE_CANCEL = 3;

    /**
     * 服务费收入基数 枚举 投放本金
     */
    public static final Short SRVINBASE_LOAN = 0;

    /**
     * 保证金收取方式 枚举 手工维护
     */
    public static final Short DEPOSIT_GM_MANUAL = 2;



    /**
     * 保证金收取方式 枚举 标准确认
     */
    public static final Short DEPOSIT_GM_STD = 3;

    /**
     * 服务费收入基数 枚举 剩余本金
     */
    public static final Short SRVINBASE_BALANCE = 1;

    /**
     * 服务费支出方式 枚举 期初一次性支付
     */
    public static final Short SRVOUT_METHOD_ONE = 0;

    /**
     * 服务费支出方式 枚举 每年支付
     */
    public static final Short SRVOUT_METHOD_EVERY = 1;

    /**
     * 服务费支出方式 枚举 手工维护
     */
    public static final Short SRVOUT_METHOD_MANUAL = 2;

    /**
     * 频率 枚举 月
     */
    public static final Short PERIOD_MONTH = 0;

    /**
     * 频率 枚举 季
     */
    public static final Short PERIOD_SEASON = 2;

    /**
     * 频率 枚举 半年
     */
    public static final Short PERIOD_HALF_YEAR = 4;

    /**
     * 频率 枚举 年
     */
    public static final Short PERIOD_YEAR = 5;

    /**
     * 建设期利息处理方式 枚举 非资本化
     */
    public static final Short BUILDREST_METHOD_CAPITALIZATION_NON = 0;

    /**
     * 建设期利息处理方式 枚举 资本化
     */
    public static final Short BUILDREST_METHOD_CAPITALIZATION = 1;

    /**
     * 计划收租日 枚举 1
     */
    public static final Short PLANLEASE_DAY_1 = 1;

    /**
     * 计划收租日 枚举 2
     */
    public static final Short PLANLEASE_DAY_2 = 2;

    /**
     * 计划收租日 枚举 3
     */
    public static final Short PLANLEASE_DAY_3 = 3;

    /**
     * 计划收租日 枚举 4
     */
    public static final Short PLANLEASE_DAY_4 = 4;

    /**
     * 计划收租日 枚举 5
     */
    public static final Short PLANLEASE_DAY_5 = 5;

    /**
     * 计划收租日 枚举 6
     */
    public static final Short PLANLEASE_DAY_6 = 6;

    /**
     * 计划收租日 枚举 7
     */
    public static final Short PLANLEASE_DAY_7 = 7;

    /**
     * 计划收租日 枚举 8
     */
    public static final Short PLANLEASE_DAY_8 = 8;

    /**
     * 计划收租日 枚举 9
     */
    public static final Short PLANLEASE_DAY_9 = 9;

    /**
     * 计划收租日 枚举 10
     */
    public static final Short PLANLEASE_DAY_10 = 10;

    /**
     * 计划收租日 枚举 11
     */
    public static final Short PLANLEASE_DAY_11 = 11;

    /**
     * 计划收租日 枚举 12
     */
    public static final Short PLANLEASE_DAY_12 = 12;

    /**
     * 计划收租日 枚举 13
     */
    public static final Short PLANLEASE_DAY_13 = 13;

    /**
     * 计划收租日 枚举 14
     */
    public static final Short PLANLEASE_DAY_14 = 14;

    /**
     * 计划收租日 枚举 15
     */
    public static final Short PLANLEASE_DAY_15 = 15;

    /**
     * 计划收租日 枚举 16
     */
    public static final Short PLANLEASE_DAY_16 = 16;

    /**
     * 计划收租日 枚举 17
     */
    public static final Short PLANLEASE_DAY_17 = 17;

    /**
     * 计划收租日 枚举 18
     */
    public static final Short PLANLEASE_DAY_18 = 18;

    /**
     * 计划收租日 枚举 19
     */
    public static final Short PLANLEASE_DAY_19 = 19;

    /**
     * 计划收租日 枚举 20
     */
    public static final Short PLANLEASE_DAY_20 = 20;

    /**
     * 计划收租日 枚举 21
     */
    public static final Short PLANLEASE_DAY_21 = 21;

    /**
     * 计划收租日 枚举 22
     */
    public static final Short PLANLEASE_DAY_22 = 22;

    /**
     * 计划收租日 枚举 23
     */
    public static final Short PLANLEASE_DAY_23 = 23;

    /**
     * 计划收租日 枚举 24
     */
    public static final Short PLANLEASE_DAY_24 = 24;

    /**
     * 计划收租日 枚举 25
     */
    public static final Short PLANLEASE_DAY_25 = 25;

    /**
     * 计划收租日 枚举 26
     */
    public static final Short PLANLEASE_DAY_26 = 26;

    /**
     * 计划收租日 枚举 27
     */
    public static final Short PLANLEASE_DAY_27 = 27;

    /**
     * 计划收租日 枚举 28
     */
    public static final Short PLANLEASE_DAY_28 = 28;

    /**
     * 计划收租日 枚举 29
     */
    public static final Short PLANLEASE_DAY_29 = 29;

    /**
     * 数据状态 枚举 有效
     */
    public static final Short DATA_STATUS_ENABLE = 0;

    /**
     * 数据状态 枚举 作废
     */
    public static final Short DATA_STATUS_DISABLE = 1;

    /**
     * 计划收租日 枚举 30
     */
    public static final Short PLANLEASE_DAY_30 = 30;

    /**
     * 计划收租日 枚举 31
     */
    public static final Short PLANLEASE_DAY_31 = 31;

    /**
     * 计划收租日 枚举 随起租日
     */
    public static final Short PLANLEASE_DAY_0 = 0;

    /**
     * 收租规则周期 枚举 按年循环
     */
    public static final Short LEASERULE_YEAR_CYCLE = 1;

    /**
     * 收租规则周期 枚举 按租赁期
     */
    public static final Short LEASERULE_LEASE_TERM = 0;

    /**
     * 特殊算法设置 枚举 常规
     */
    public static final Short SPECMETHOD_NOTHING = 0;

    /**
     * 特殊算法设置 枚举 平息法
     */
    public static final Short SPECMETHOD_FIXED_INTEREST = 1;

    /**
     * 先付后付标志 枚举 先付
     */
    public static final Short PREPAY_PREPAY = 0;

    /**
     * 先付后付标志 枚举 后付
     */
    public static final Short PREPAY_AFTERPAY = 1;

    /**
     * 总投放金额的计息方式 枚举 约定计息(第一笔投放)
     */
    public static final Short CALREST_METHOD_BEGINNING = 0;

    /**
     * 总投放金额的计息方式 枚举 按投放时点计息
     */
    public static final Short CALREST_METHOD_PUTTING = 1;

    /**
     * 利息补差计息方式 枚举 不补差
     */
    public static final Short FILL_REST_NOTHING = 0;

    /**
     * 利息补差计息方式 枚举 按实际补差
     */
    public static final Short FILL_REST_FACT = 1;

    /**
     * 利息补差计息方式 枚举 多补少不退
     */
    public static final Short FILL_REST_NOMORE = 2;

    /**
     * 计算天数 枚举 360
     */
    public static final Short CALDAY_360 = 0;

    /**
     * 计算天数 枚举 365
     */
    public static final Short CALDAY_365 = 1;

    /**
     * 计息方式-常规
     */
    public static final Short Calc_interest_type_Normal = 0;
    /**
     * 计息方式-首笔计息天数+1
     */
    public static final Short Calc_interest_type_SPDB = 1;

    /**
     * 计算精度 枚举 分
     */
    public static final Short PRECISION_CENT = 0;

    /**
     * 计算精度 枚举 元
     */
    public static final Short PRECISION_DOLLER = 1;

    /**
     * 计算精度 枚举 万元
     */
    public static final Short PRECISION_MYRIAD = 2;
    /**
     * 计算精度 枚举 百元
     */
    public static final Short PRECISION_CENTURY = 3;
    /**
     * 计算精度 枚举 千元
     */
    public static final Short PRECISION_THOUSAND = 4;


    /**
     * 利率类型 枚举 浮动
     */
    public static final Short RATE_TYPE_FLOAT = 0;

    /**
     * 利率类型 枚举 固定
     */
    public static final Short RATE_TYPE_FIXED = 1;

    /**
     * 利率类型 枚举
     * 无利率
     */
    public static final Short RATE_TYPE_NO = 2;

    /**
     * 利率浮动方式 枚举 百分比
     */
    public static final Short RATE_FLOATMETHOD_PERCENT = 0;

    /**
     * 利率浮动方式 枚举 绝对值
     */
    public static final Short RATE_FLOATMETHOD_ABSOLUTE = 1;

    /**
     * 保证金退回方式 枚举 期末一次性退款
     */
    public static final Short DEPOST_CBM_LAST_BACK = 0;

    /**
     * 保证金退回方式 枚举 冲抵最后几期租金
     */
    public static final Short DEPOST_CBM_DEPOSITING_RENT = 1;

    /**
     * 保证金退回方式<br>
     * 冲抵两期租金
     */
    public static final Short DEPOST_CBM_DEPOSITING_TWO_RENT = 2;

    /**
     * 保证金退回方式 枚举 手工维护
     */
    public static final Short DEPOST_CBM_MANUAL = 3;

    /**
     * 租金计算方式 枚举 等额租金
     */
    public static final Short RENT_CALM_RENT_EQ = 0;

    /**
     * 租金计算方式 枚举 等额本金
     */
    public static final Short RENT_CALM_PRINCIPAL_EQ = 1;

    /**
     * 租金计算方式 枚举 指定租金
     */
    public static final Short RENT_CALM_RENT_SPE = 3;

    /**
     * 租金计算方式 枚举 指定本金
     */
    public static final Short RENT_CALM_PRINCIPAL_SPE = 4;

    /**
     * 租金计算方式 枚举 等差租金
     */
    public static final Short RENT_CALM_RENT_DIF = 2;

    /**
     * 付款方式 枚举 现金
     */
    public static final Short PAY_METHOD_CASH = 0;

    /**
     * 付款方式 枚举 银票
     */
    public static final Short PAY_METHOD_BANK = 1;

    /**
     * 生成方式 枚举 系统
     */
    public static final Short MAKE_METHOD_SYS = 0;

    /**
     * 生成方式 枚举 手动
     */
    public static final Short MAKE_METHOD_HAND = 1;

    /** ADD WJJ 20160812 收款核销撤销 */
    /**
     * 生成方式 枚举 撤销方式
     */
    public static final Short MAKE_METHOD_BACKOUT = 2;
    /** ADD END*/

    /**
     * 特殊期 枚举 无
     */
    public static final Short SPEC_NULL = 0;

    /**
     * 特殊期 枚举 远期支付
     */
    public static final Short SPEC_TIMEPAY = 1;

    /**
     * 特殊期 枚举 在建期
     */
    public static final Short SPEC_BUILD = 2;

    /**
     * 特殊期 枚举 租前息
     */
    public static final Short SPEC_BEFORE_INTEREST = 3;

    /**
     * 业务类型 枚举 普通
     */
    public static final Short BUSITYPE_COMMON = 0;

    /**
     * 业务类型 枚举 在建期
     */
    public static final Short BUSITYPE_BUILD = 1;

    /**
     * 业务类型 枚举 厂商
     */
    public static final Short BUSITYPE_VENDOR = 2;

    /**
     * 服务费类型 枚举 服务费
     */
    public static final Short SRVTYPE_SRVFEE = 0;

    /**
     * 服务费类型 枚举 中间业务收入
     */
    public static final Short SRVTYPE_MIDFEE = 1;

    /**
     * 租金表类型 枚举 市场表
     */
    public static final Short RENTTYPE_MARKET = 0;

    /**
     * 租金表类型 枚举 会计表
     */
    public static final Short RENTTYPE_ACCOUNT = 1;

    /**
     * 租金表类型 枚举 费用分摊
     */
    public static final Short RENTTYPE_FEE_APPRO = 2;

    /**
     * 是否费率历史表 是
     */
    public static final Short IF_RATE_HIS_YES = 0;
    /**
     * 是否费率历史表 否
     */
    public static final Short IF_RATE_HIS_NO = 1;
    /**
     * 分栏 第一栏
     */
    public static final Short SUBFIELD_ONE = 1;
    /**
     * 分栏 第二栏
     */
    public static final Short SUBFIELD_TWO = 2;
    /**
     * 分栏 第三栏
     */
    public static final Short SUBFIELD_THREE = 3;
    /**
     * 分栏 第四栏
     */
    public static final Short SUBFIELD_FOUR = 4;
    /**
     * 日期格式 yyyy
     */
    public static final Short DATE_FORMAT_YEAR = 0;
    /**
     * 日期格式 yyyy-MM
     */
    public static final Short DATE_FORMAT_YEAR_MONTH = 1;
    /**
     * 日期格式 yyyy-MM-dd
     */
    public static final Short DATE_FORMAT_YEAR_MONTH_DAY = 2;

    /**
     * 计算方式(标准版用) 等额租金
     */
    public static final Short CALM_STANDARD_RENT_EQ = 0;

    /**
     * 计算方式(标准版用) 等额本金
     */
    public static final Short CALM_STANDARD_PRINCIPAL_EQ = 1;

    /**
     * 计算方式(标准版用) 平息法
     */
    public static final Short CALM_STANDARD_FIXED_INTEREST = 2;

    /**
     * 客户黑名单处理方式 枚举 冻结
     */
    public static final Short BLACK_HANDLE_FREEZE = 1;

    /**
     * 客户黑名单处理方式 枚举 解冻
     */
    public static final Short BLACK_HANDLE_THAW = 2;

    /**
     * 客户黑名单处理方式 枚举 变更冻结
     */
    public static final Short BLACK_HANDLE_ALTERA_FREEZE = 3;

    /**
     * 业务处理方式 枚举 列入黑名单-不可做业务
     */
    public static final Short BUSINESS_PROCESS_NO_ELECT = 0;

    /**
     * 业务处理方式 枚举 列入黑名单-可做业务
     */
    public static final Short BUSINESS_PROCESS_YES_PROMPT = 1;

    /**
     * 业务处理方式 枚举 正常
     */
    public static final Short BUSINESS_PROCESS_NORMAL = 2;

    /**
     * 项目来源[1000185]<br>
     * 中介推荐
     */
    public static final Short PROJECT_SOURCE_MEDIATION_RECOMMENDED = 0;

    /**
     * 项目来源[1000185]<br>
     * 厂商租赁
     */
    public static final Short PROJECT_SOURCE_VENDOR_LEASE = 1;

    /**
     * 项目来源[1000185]<br>
     * 银租合作
     */
    public static final Short PROJECT_SOURCE_BANK_LEASING_COOPER = 2;

    /**
     * 项目来源[1000185]<br>
     * 直销
     */
    public static final Short PROJECT_SOURCE_DIRECT_SELLING = 3;

    /**
     * 项目来源[1000185]<br>
     * 其他
     */
    public static final Short PROJECT_SOURCE_OTHER = 4;

    /**
     * 项目来源[1000185]<br>
     * 厂商推荐
     */
    public static final Short PROJECT_SOURCE_VENDOR_RECOMMENDED = 5;

    /**
     * 项目来源[1000185]<br>
     * 转租赁
     */
    public static final Short PROJECT_SOURCE_TURN_LEASE = 6;

    /**
     * 项目来源[1000185]<br>
     * 直销-老客户
     */
    public static final Short PROJECT_SOURCE_DIRECT_SELLING_OLD = 7;

    /**
     * 项目类型[1000186]<br>
     * 单体项目
     */
    public static final Short PROJECT_TYPE_INDIVIDUAL_PROJECT = 0;

    /**
     * 项目类型[1000186]<br>
     * 额度项目
     */
    public static final Short PROJECT_TYPE_CREDIT_PROJECTS = 1;

    /**
     * 项目类型[1000186]<br>
     * 承租人框架协议
     */
    public static final Short PROJECT_TYPE_LESSEE_FRAMEWORK_AGREEMENT = 2;

    /**
     * 项目类型[1000186]<br>
     * 厂商框架协议
     */
    public static final Short PROJECT_TYPE_VENDER_FRAMEWORK_AGREEMENT = 3;

    /**
     * 项目类型[1000186]<br>
     * 厂商协议子项目
     */
    public static final Short PROJECT_TYPE_VENDER_PROJECT = 4;
    /**
     * 项目类型[1000186]<br>
     * 贷款项目-提款业务编号
     */
    public static final Short PROJECT_TYPE_WITHDRAW_MANAGER = 5;
    /**
     * 项目类型[1000186]<br>
     * 中介协议项目
     */
    public static final Short PROJECT_TYPE_AGENCY = 6;
    /**
     * 项目类型[1000186]<br>
     * 中介协议项目
     */
    public static final Short PROJECT_TYPE_AGENCY_AGREEMENT = 7;

    /**
     * 项目类型[1000186]<br>
     * 通道业务项目
     */
    public static final Short PROJECT_TYPE_CHANNEL_BUSINESS = 8;

    /**
     * 项目类型[1000186]<br>
     * 医疗项目
     */
    public static final Short PROJECT_TYPE_MEDICAL_PROJECT = 9;
    /**
     * 租赁物类型[1000187]<br>
     * 机械
     */
    public static final Short THING_TYPE_MACHINE = 0;

    /**
     * 尽职调查方式[1000188]<br>
     * 单人尽调
     */
    public static final Short DUE_DILIGENCE_TYPE_SINGLE_DILIGENCE = 0;

    /**
     * 尽职调查方式[1000188]<br>
     * 双人尽调
     */
    public static final Short DUE_DILIGENCE_TYPE_DOUBLE_DILIGENCE = 1;

    /**
     * 尽职调查方式[1000188]<br>
     * 团体尽调
     */
    public static final Short DUE_DILIGENCE_TYPE_GROUP_DILIGENCE = 2;

    /**
     * 审批结果[1000189]<br>
     * 未审批
     */
    public static final Short APPROVE_RESULT_NO_APPROVAL = 0;

    /**
     * 审批结果[1000189]<br>
     * 审批通过
     */
    public static final Short APPROVE_RESULT_APPROVAL_PASS = 1;

    /**
     * 审批结果[1000189]<br>
     * 审批不通过
     */
    public static final Short APPROVE_RESULT_APPROVAL_NOPASS = 2;

    /**
     * 附件来源[1000190]<br>
     * 系统生成
     */
    public static final Short ATTACHMENT_SOURCE_SYS_GEN = 0;

    /**
     * 附件来源[1000190]<br>
     * 手动上传
     */
    public static final Short ATTACHMENT_SOURCE_UPLOAD = 1;

    /**
     * 收税模式
     * 增值税
     */
    public static final Short TAX_MODEL_VALUE_ADDED = 0;

    /**
     * 收税模式
     * 营业税
     */
    public static final Short TAX_MODEL_SALES = 1;
    /**
     * 授信类型
     * 可循环授信
     */
    public static final Short LIMIT_TYPE_CYCLE=0;
    /**
     * 授信类型
     * 不可循环授信
     */
    public static final Short LIMIT_TYPE_NO_CYCLE=1;
    /**
     * 授信状态
     * 无效
     */
    public static final Short LIMIT_STATUS_INVALID=1;
    /**
     * 授信状态
     * 有效
     */
    public static final Short LIMIT_STATUS_VALID=0;


    /**
     * 转移状态
     * 初始
     */
    public static final Short TRANSFER_INITIAL = 0;

    /**
     * 转移状态
     * 已移交
     */
    public static final Short TRANSFER_HAVE = 1;

    /**
     * 其他关系类型
     * 其他关系
     */
    public static final Short RELATION_OTHER = 0;

    /**
     * 其他关系类型
     * 客户来源
     */
    public static final Short RELATION_CUST = 1;

    /**
     * 其他关系类型
     * 高管信息
     */
    public static final Short RELATION_EXECUTIVE = 2;

    /**
     * 其他关系类型
     * 家族企业
     */
    public static final Short RELATION_FAMILY = 3;


    /**
     * 服务费支出税率
     */
    public static final Short SRV_TAX_3 = 0;
    /**
     * 服务费支出税率
     */
    public static final Short SRV_TAX_6 = 1;
    /**
     * 服务费支出税率
     */
    public static final Short SRV_TAX_17 = 2;
    /**
     * 服务费支出税率
     */
    public static final Short SRV_TAX_0 = 3;

    /**
     * 服务费支出税率
     */
    public static final Short SRV_TAX_11 = 4;



    /**
     * 租赁类别[1000198]<br>
     * 融资租赁
     */
    public static final Short LEASE_CATEGRY_FINANCE = 0;

    /**
     * 租赁类别[1000198]<br>
     * 经营性租赁
     */
    public static final Short LEASE_CATEGRY_OPERATING = 1;

    /**
     * 租赁类别[1000198]<br>
     * 委托租赁
     */
    public static final Short LEASE_CATEGRY_TRUST = 2;

    /**
     * 租赁类别[1000198]<br>
     * 商业保理
     */
    public static final Short LEASE_CATEGRY_BUSI = 4;

    /**
     * 租赁类别[1000198]<br>
     * 其它
     */
    public static final Short LEASE_CATEGRY_OTHER = 3;

    /**
     * 保证金退回方式<br>
     * 期末退回
     */
    public static final Short LAST_BACK = 0;


    /**
     * 有效封存<br>
     * 有效
     */
    public static final Short CUST_TYPE_EFFECTIVE = 0;

    /**
     * 有效封存<br>
     * 封存
     */
    public static final Short CUST_TYPE_STORAGE = 1;

    /**
     * 项目负责人角色[1000200]<br>
     * 主办
     */
    public static final Short PROJECT_LEADER_ROLE_HOST = 0;
    /**
     * 项目负责人角色[1000200]<br>
     * 协办
     */
    public static final Short PROJECT_LEADER_ROLE_CO_HOST = 1;
    /**
     * 项目负责人角色[1000200]<br>
     * 部门经理
     */
    public static final Short PROJECT_LEADER_ROLE_MANAGER = 2;
    /**
     * 关系方向--正向
     */
    public static final Short RELATION_DIRECTION = 0;
    /**
     * 关系方向--反向
     */
    public static final Short RELATION_DIRECTION_REVERSE = 1;

    /**
     * 保证金结算方式
     * 一次性结算
     */
    public static final Short DEPOSIT_ONE_OFF = 0;

    /**
     * 保证金结算方式
     * 随租赁项目结算
     */
    public static final Short DEPOSIT_LEASE_PROGRAM = 1;
    /**
     * 调息类别
     * 手工
     */
    public static final Short ADJUST_TYPE_HANDMADE=0;
    /**
     * 调息类别
     * 系统
     */
    public static final Short ADJUST_TYPE_SYSTEM=1;

    /**
     * 调息类别
     * 免调息
     */
    public static final Short ADJUST_TYPE_SPARE=2;

    /**
     * 调息类别
     * 无
     */
    public static final Short ADJUST_TYPE_NOTHING=3;

    /**
     * 调息时点
     * 随基准调息
     */
    public static final Short ADJUST_TIME_BASE=0;
    /**
     * 调息时点
     * 调息月次月1日
     */
    public static final Short ADJUST_TIME_STANDARD=1;
    /**
     * 调息时点
     * 次年1月1日
     */
    public static final Short ADJUST_TIME_NEXTMONTH=2;
    /**
     * 调息时点
     * 下一收租日
     */
    public static final Short ADJUST_TIME_NEXT=3;
    /**
     * 调息时点
     * 投放满一月后收租日
     */
    public static final Short ADJUST_TIME_FULLMONTH=4;
    /**
     * 调息时点
     * 投放满一季后收租日
     */
    public static final Short ADJUST_TIME_FULLPERIOD=5;
    /**
     * 调息时点
     * 投放满半年后收租日
     */
    public static final Short ADJUST_TIME_HALFYEAR=6;
    /**
     * 调息时点
     * 投放满一年后收租日
     */
    public static final Short ADJUST_TIME_FULLYEAR=7;

    /**
     * 调息时点
     * 调息月次月对应日
     */
    public static final Short BASE_NM_DAY=8;
    /**
     * 调息时点
     * 合同签订日对应整年度调整
     */
    public static final Short SIGN_DATE_YEAR=9;
    /**
     * 调息时点
     * 调息后最近签订日
     */
    public static final Short ADJUST_SIGN_DATE=10;
    /**
     * 调息时点
     * 按季的合同签订日
     */
    public static final Short NS_SIGN_DATE=11;
    /**
     * 调息时点
     * 按三月的合同签订日
     */
    public static final Short MARCH_SIGN_DATE=12;
    /**
     * 调息时点
     * 不调息
     */
    public static final Short NO_ADJ=13;

    /**
     * 调息时点
     * 次日
     */
    public static final Short NEXT_DAY=14;


    /**
     * 调息方式
     * 比例法
     */
    public static final Short ADJUST_METHOD_PROPORTION=0;
    /**
     * 调息方式
     * 单一利率法
     */
    public static final Short ADJUST_METHOD_ONLY=1;
    /**
     * 调息方式
     * 复合利率法
     */
    public static final Short ADJUST_METHOD_CHECK=2;
    /**
     * 调息方式
     * 明确利率法
     */
    public static final Short ADJUST_EXPLICIT=3;
    /**
     * 调息方式
     * 本金不变法
     */
    public static final Short ADJUST_CORPUS_UNCHANGE=4;
    /**
     * 调息方式
     * 无明示利率法
     */
    public static final Short ADJUST_ANONYMOUS_RATE=5;
    /**
     * 调息方式
     * 不调息
     */
    public static final Short ADJUST_NOT=6;

    /**
     * 调息方式
     * 无
     */
    public static final Short ADJUST_NO=7;

    /**
     * 调息方式
     * 明确利率法(PMT)
     */
    public static final Short ADJUST_EXPLCIT_PMT=9;

    /**
     * 开票方式
     * 投放时本金全额开票
     */
    public static final Short INVOICE_METHOD_ALL=0;
    /**
     * 开票方式
     * 本金、利息分开开票
     */
    public static final Short INVOICE_METHOD_SEPARATE=1;
    /**
     * 开票方式
     * 本金、利息一起开票
     */
    public static final Short INVOICE_METHOD_TOGETHER=2;
    /**
     * 开票方式
     * 利息开票
     */
    public static final Short INVOICE_METHOD_INTEREST=3;
    /**
     * 开票条件
     * 先开票后到账
     */
    public static final Short INVOICE_CONT_INVOICE_ACCT=0;
    /**
     * 开票条件
     * 先到账后开票
     */
    public static final Short INVOICE_CONT_ACCT_INVOICE=1;
    /**
     * 合同状态
     * 已生成
     */
    public static final Short CONT_STATUS_CREATED=0;
    /**
     * 合同状态
     * 已签订/已生效
     */
    public static final Short CONT_STATUS_SIGN=1;
    /** INSERT  【 wangjj】 【2017年6月12日】 【多次投放】 */
    /**
     * 合同状态[1000212]<br>
     * 部分起租
     */
    public static final Short CONT_STATUS_PART = 7;
    /** INSERT  END */
    /**
     * 合同状态[1000212]<br>
     * 起租
     */
    public static final Short CONT_STATUS_START = 2;
    /**
     * 合同状态[1000212]<br>
     * 结清
     */
    public static final Short CONT_STATUS_NORMAL_END = 3;
    /**
     * 合同状态[1000212]<br>
     * 未起租结束
     */
    public static final Short CONT_STATUS_END = 4;
    /**
     * 合同状态[1000212]<br>
     * 已撤销
     */
    public static final Short CONT_REVOKE = 5;

    /**
     * 合同状态[1000212]<br>
     * 起租（通道）
     */
    public static final Short CONT_STATUS_CHANNEL = 8;

    /**
     * 审批变更类型
     * 二次评审
     */
    public static final Short APPROVAL_SECOND = 0;

    /**
     * 审批变更类型
     * 审批变更
     */
    public static final Short APPROVAL_CHANGE = 1;

    /**
     * 审批变更类型
     * 审批修改
     */
    public static final Short APPROVAL_MODIFY = 2;

    /**
     * 审批变更类型
     * 初次评审
     */
    public static final Short APPROVAL_FIRST = 3;

    /**
     * 条件类型
     * 未执行
     */
    public static final Short CONDITION_TYPE_NOT=0;
    /**
     * 条件类型
     * 部分执行
     */
    public static final Short CONDITION_TYPE_PART=1;
    /**
     * 条件类型
     * 已执行
     */
    public static final Short CONDITION_TYPE_OVER=2;
    /**
     * 起租条件
     * 首笔保证金已收
     */
    public static final Short  ON_CONDITION_MARGIN=0;
    /**
     * 起租条件
     * 首付款已收
     */
    public static final Short  ON_CONDITION_PAYMENT=1;
    /**
     * 起租条件
     * 首笔服务费已收
     */
    public static final Short  ON_CONDITION_SERVICE=2;
    /**
     * 起租条件
     * 首笔投放已付
     */
    public static final Short  ON_CONDITION_PUT=3;
    /**
     * 起租条件
     * 首笔投放票据已收
     */
    public static final Short  ON_CONDITION_INVOICE=4;
    /**
     * 起租条件
     * 合同已签订
     */
    public static final Short  ON_CONDITION_CONT=5;
    /**
     * 起租条件
     * 设备验收合格证书已上传
     */
    public static final Short  ON_CONDITION_ACCESSORY=6;

    /**
     * 合同类型
     * 转让协议
     */
    public static final Short CONTRACT_TRANSFER = 0;

    /**
     * 合同类型
     * 买卖合同（厂商）
     */
    public static final Short CONTRACT_MANUFACTURER = 1;

    /**
     * 合同类型
     * 买卖合同（分包商）
     */
    public static final Short CONTRACT_SUBCONTRACTOR = 2;

    /**
     * 合同类型
     * 采购合同
     */
    public static final Short CONTRACT_PROCUREMENT = 3;


    /**
     * 合同类型
     * 融资租赁合同
     */
    public static final Short CONTRACT_FINA = 4;
    /**
     * 合同类型
     * 中介合同
     */
    public static final Short CONTRACT_MEDIUM = 5;
    /**
     * 合同类型
     * 担保合同
     */
    public static final Short CONTRACT_GUARANTEE = 6;
    /**
     * 合同类型
     * 买卖合同
     */
    public static final Short CONTRACT_SALES = 7;
    /**
     * 合同类型
     * 合作协议
     */
    public static final Short CONTRACT_PROTOCOL = 8;
    /**
     * 合同类型
     * 抵押合同
     */
    public static final Short CONTRACT_PLEDGE = 9;
    /**
     * 合同类型
     * 质押合同
     */
    public static final Short CONTRACT_MORTGAGE = 10;
    /**
     * 合同类型
     * 回购协议
     */
    public static final Short CONTRACT_BACK = 11;

    /**
     * 合同类型
     * 咨询服务合同
     */
    public static final Short CONTRACT_CONSULT = 12;

    /**
     * 协议状态
     * 已生成
     */
    public static final Short PROTOCOL_GEN = 0;

    /**
     * 协议状态
     * 已签订
     */
    public static final Short PROTOCOL_SIGN = 1;

    /**
     * 协议状态
     * 已生效
     */
    public static final Short PROTOCOL_EFFECT = 2;
    /**
     * 付款条件
     * 所有款项收回
     */
    public static final Short  PAY_CONDITION_ALL=0;
    /**
     * 付款条件
     * 租赁合同已生效
     */
    public static final Short  PAY_CONDITION_LEASE=1;
    /**
     * 付款条件
     * 担保合同已生效
     */
    public static final Short  PAY_CONDITION_GUARANTEE=2;
    /**
     * 付款条件
     * 买卖合同已生效
     */
    public static final Short  PAY_CONDITION_BUS=3;

    /**
     * 付款条件
     * 收到租赁物验收合格通知
     */
    public static final Short  PAY_CONDITION_NOTICE=4;

    /**
     * 付款条件
     * 收到首笔手续费
     */
    public static final Short  PAY_CONDITION_FIRST_SERVICE=5;

    /**
     * 付款条件
     * 收到首付款
     */
    public static final Short  PAY_CONDITION_FIRST=6;

    /**
     * 付款条件
     * 收到首笔保证金
     */
    public static final Short  PAY_CONDITION_DEPOSIT=7;

    /**
     * 不规则-本金为负是否调整为0
     * 是
     */
    public static final Short  CORPUS_ADJUST_ZERO_YES=0;


    /**
     * 不规则-本金为负是否调整为0
     * 否
     */
    public static final Short  CORPUS_ADJUST_ZERO_NO=1;

    /**
     * 协议状态 ： 已生成
     */
    public static final Short  TREATY_STATUS_MAKE=0;


    /**
     * 协议状态 ： 已生效
     */
    public static final Short  TREATY_STATUS_EFFECTIVE=1;
    /**
     * 租赁范围 ： 手机
     */
    public static final Short  PHONE_LA=0;
    /**
     * 租赁范围 ： 宽带
     */
    public static final Short  BROADBAND_LA=1;
    /**
     * 租赁范围 ： ICT
     */
    public static final Short  ICT_LA=2;
    /**
     * 租赁范围 ： 电脑
     */
    public static final Short  COMPUTER_LA=3;
    /**
     * 租赁范围 ： 固话
     */
    public static final Short  FIXED_LINE_LA=4;
    /**
     * 租赁范围 ： 其他
     */
    public static final Short  OTHER_LA=5;
    /**
     * 客户类型 ： 公众
     */
    public static final Short  PUBLIC_CM=0;
    /**
     * 客户类型 ： 政企
     */
    public static final Short  GOVERNMENT_CM=1;
    /**
     * 收费方式 ： 预收
     */
    public static final Short  RECEIVE_CM=0;
    /**
     * 收费方式 ： 后付
     */
    public static final Short  AFTER_CM=1;
    /**
     * 调息对象 ： 费率调息
     */
    public static final Short  RATE_AO=0;
    /**
     * 调息对象 ： 租金调息
     */
    public static final Short  RENT_AO=1;

    /**
     * 审批模式 格式
     */
    public static final Short APPROVE_MODEL_FORMAT = 0;

    /**
     * 审批模式 非格式
     */
    public static final Short APPROVE_MODEL_UN_FORMAT = 1;
    /**
     * 供应商开票方式
     * 投放后即收票
     */
    public static final Short INVOICE_WAY_PUT=0;
    /**
     * 供应商开票方式
     * 先收票后投放
     */
    public static final Short INVOICE_WAY_INVOICE=1;
    /**
     * 供应商纳税主体
     * 一般纳税人
     */
    public static final Short TAXES_MAIN_ORDINARY=0;
    /**
     * 供应商纳税主体
     * 小规模纳税人
     */
    public static final Short TAXES_MAIN_SMALL=1;
    /**
     * 供应商纳税主体
     * 营业税纳税人
     */
    public static final Short TAXES_MAIN_TAXES=2;
    /**
     * 发票性质
     * 增值税普通
     */
    public static final Short INVOICE_NATURE_COMMON=0;
    /**
     * 发票性质
     * 增值税专用
     */
    public static final Short INVOICE_NATURE_DEDICATED=1;
    /**
     * 发票性质
     * 可扣额发票
     */
    public static final Short INVOICE_NATURE_CAN=2;
    /**
     * 发票性质
     * 税务局代开增值税专用发票
     */
    public static final Short INVOICE_NATURE_TAX=3;
    /**
     * 发票性质
     * 营业税发票
     */
    public static final Short INVOICE_NATURE_SALE=4;
    /**
     * 发票性质
     * 收据
     */
    public static final Short INVOICE_NATURE_RECEIPT=5;
    /**
     * 发票性质
     * 无
     */
    public static final Short INVOICE_NATURE_NULL=6;
    /**
     * 发票状态
     * 正常
     */
    public static final Short NORMAL=0;
    /**
     * 发票状态
     * 作废
     */
    public static final Short INVALID=1;
    /**
     * 担保方式（合同）
     * 代垫保险
     */
    public static final Short GUARANTEE_WAY_INSURE=0;
    /**
     * 担保方式（合同）
     * 承租人投保
     */
    public static final Short GUARANTEE_WAY_COVER=1;
    /**
     * 担保方式（合同）
     * 自投
     */
    public static final Short GUARANTEE_WAY_ONESELF=2;
    /**
     * 指标分类
     * 定量指标
     */
    public static final Short QUANT_RATING=0;
    /**
     * 指标分类
     * 定性指标
     */
    public static final Short ORIENTATION_RATING=1;
    /**
     * 指标分类
     * 信用等级
     */
    public static final Short HIGHER_RATING=2;
    /**
     * 客户级别
     * A
     */
    public static final Short CLEVEL_A=0;
    /**
     * 客户级别
     * AA
     */
    public static final Short CLEVEL_AA=1;
    /**
     * 客户级别
     * AA+
     */
    public static final Short CLEVEL_AAM=2;
    /**
     * 客户级别
     * AAA
     */
    public static final Short CLEVEL_AAA=3;
    /**
     * 客户级别
     * B
     */
    public static final Short CLEVEL_B=4;
    /**
     * 客户级别
     * BB
     */
    public static final Short CLEVEL_BB=5;
    /**
     * 客户级别
     * BB+
     */
    public static final Short CLEVEL_BBM=6;
    /**
     * 客户级别
     * BBB
     */
    public static final Short CLEVEL_BBB=7;
    /**
     * 客户级别
     * C
     */
    public static final Short CLEVEL_C=8;
    /**
     * 客户级别
     * D
     */
    public static final Short CLEVEL_D=9;
    /**
     * 合同类型(资金)
     * 授信合同
     */
    public static final Short ZJ_CONT_TYPE_CREDIT=0;
    /**
     * 合同类型(资金)
     * 借款合同
     */
    public static final Short ZJ_CONT_TYPE_LOAN=1;

    /**
     * 合同类型(资金)
     * 融资顾问合同
     */
    public static final Short ZJ_CONT_TYPE_COUNSELOR=2;

    /**
     * 合同类型(资金)
     * 其他合同
     */
    public static final Short ZJ_CONT_TYPE_OTHER=3;



    /**
     * 授信类型
     * 可循环授信
     */
    public static final Short CREDIT_CALSS_CYCLE = 0;
    /**
     * 授信类型
     * 不可循环授信
     */
    public static final Short CREDIT_CALSS_UNCYCLE = 1;

    /**
     * 授信分类
     * 承租人授信
     */
    public static final Short LIMIT_CLASS_LESSEE=0;
    /**
     * 授信分类
     * 项目授信
     */
    public static final Short LIMIT_CLASS_PRJ=1;
    /**
     * 授信分类
     * 总承租人授信
     */
    public static final Short LIMIT_CLASS_GROUPPRJ=2;
    /**
     * 授信分类
     * 合作协议授信
     */
    public static final Short LIMIT_CLASS_PROTOCOL=3;
    /**
     * 上市地点
     * 上海
     */
    public static final Short LISTING_LOCATION_SHANGHAI = 0;
    /**
     * 上市地点
     * 深圳
     */
    public static final Short LISTING_LOCATION_SHENZHEN = 1;
    /**
     * 上市地点
     * 香港
     */
    public static final Short LISTING_LOCATION_HONGKONG = 2;
    /**
     * 付息方式：等间隔，还本不付息
     */
    public static final Short PAY_INTEREST_EQ = 0;

    /**
     * 付息方式：等间隔，还本利随本清付息
     */
    public static final Short PAY_INTEREST_EQ_ALL_REPAY = 1;

    /**
     * 付息方式：随本金支付，正常付息
     */
    public static final Short PAY_INTEREST_NOMAL_INTEREST = 2;

    /**
     * 付息方式：随本金支付，利随本清
     */
    public static final Short PAY_INTEREST_ALL_REPAY = 3;

    /**
     * 付息方式：等间隔，还本正常付息
     */
    public static final Short PAY_INTEREST_EQ_NOMAL_REPAY = 4;

    /**
     * 还款计划表生成规则：标准规则
     */
    public static final Short REPAY_RULE_STANDARD = 0;

    /**
     * 还款计划表生成规则：非标准规则
     */
    public static final Short REPAY_RULE_NON_STANDARD = 1;

    /**
     * 付息方式:随本金支付，利随本清
     */
    public static final Short REPAY_PERIOD_ONE_TIMES = 0;

    /**
     * 资金支付频率:还本时支付
     */
    public static final Short REPAY_PERIOD_CORPUS_PAY = 1;

    /**
     * 资金支付频率:手工录入
     */
    public static final Short REPAY_PERIOD_HANDWORK = 2;

    /**
     * 资金计算基数:贷款本金余额
     */
    public static final Short REPAY_BASE_CORPUS_BALANCE = 0;

    /**
     * 款项名称:融资手续费
     */
    public static final Short REPAY_FEETYPE_SRVFEE = 0;

    /**
     * 款项名称：保险费
     */
    public static final Short REPAY_FEETYPE_DEPOSIT = 1;

    /**
     * 款项名称：财务顾问费
     */
    public static final Short REPAY_FEETYPE_ADVISERS = 2;

    /**
     * 款项名称：其他
     */
    public static final Short REPAY_FEETYPE_OTHER = 3;

    /**
     * 渠道类型：银行
     */
    public static final Short CHANNEL_TYPE_BANK = 0;

    /**
     * 渠道类型：信托
     */
    public static final Short CHANNEL_TYPE_TRUST = 1;

    /**
     * 渠道类型：证券
     */
    public static final Short CHANNEL_TYPE_BOND = 2;

    /**
     * 渠道类型：股东
     */
    public static final Short CHANNEL_TYPE_STOCK = 3;

    /**
     * 渠道类型：其他
     */
    public static final Short CHANNEL_TYPE_OTHER = 4;
    /**
     * 渠道类型：银团
     */
    public static final Short CHANNEL_TYPE_SYNDICATE = 7;

    /**
     * 资金还本付息间隔：月
     */
    public static final Short CAPITAL_PERIOD_MONTH = 0;

    /**
     * 资金还本付息间隔：双月
     */
    public static final Short CAPITAL_PERIOD_DB_MONTH = 1;

    /**
     * 资金还本付息间隔：等三月
     */
    public static final Short CAPITAL_PERIOD_EQTH_MONTH = 2;

    /**
     * 资金还本付息间隔：季初
     */
    public static final Short CAPITAL_PERIOD_STARTS = 3;

    /**
     * 资金还本付息间隔：季末
     */
    public static final Short CAPITAL_PERIOD_QUARTER = 4;

    /**
     * 资金还本付息间隔：半年
     */
    public static final Short CAPITAL_PERIOD_HF_YEAR = 5;

    /**
     * 资金还本付息间隔：年
     */
    public static final Short CAPITAL_PERIOD_YEAR = 6;

    /**
     * 资金还本付息间隔：还本月
     */
    public static final Short CAPITAL_CORPUS_MONTH = 7;

    /**
     * 资金还本付息间隔：季中
     */
    public static final Short CAPITAL_PERIOD_MID = 8;


    /**
     * 还本规则：等间隔还本
     */
    public static final Short REPAY_RULE_EQUALS = 0;

    /**
     * 还本规则：到期还本
     */
    public static final Short REPAY_RULE_FINAL = 1;

    /**
     * 还本规则：本金不规则
     */
    public static final Short REPAY_RULE_NO = 2;

    /**
     * 还本规则：随收租日还本
     */
    public static final Short LEASE_PAY_CORPUS = 3;

    /**
     * 还本规则：租赁本金折扣还贷款本金
     */
    public static final Short LEASE_CORPUS_PAY_CORPUS = 4;

    /**
     * 融资本金计算规则：租赁本金合计
     */
    public static final Short LEASE_CORPUS_TOTAL = 0;

    /**
     * 融资本金计算规则：租金合计
     */
    public static final Short LEASE_TOTAL = 1;

    /**
     * 融资本金计算规则：NPV(租赁本金)
     */
    public static final Short NPV_LEASE_CORPUS_TOTAL = 2;

    /**
     * 融资本金计算规则：NPV（租金）
     */
    public static final Short NPV_LEASE_TOTAL = 3;

    /**
     * 融资本金计算规则：不规则
     */
    public static final Short LOAN_RULE_NO = 4;

    /**
     * 现金流方向:收款
     */
    public static final Short CASH_DERICTION_GATHING=0;

    /**
     * 现金流方向:付款
     */
    public static final Short CASH_DERICTION_PAY=1;
    /**
     * 起租流程
     * 先投放后起租
     */
    public static final Short LEASE_FLOW_BACK=2;
    /**
     * 起租流程
     * 先起租后投放
     */
    public static final Short LEASE_FLOW_FIRST=1;
    /**
     * 起租流程
     * 投放时起租
     */
    public static final Short LEASE_FLOW_LEASE=0;

    /**
     * 起租流程
     * 约定固定起租日
     */
    public static final Short LEASE_FLOW_APPOINT=3;


    /**
     * 起租流程
     * 无
     */
    public static final Short LEASE_FLOW_NOT=4;



    /**
     * 高管人员类别
     * 法定代表人
     */
    public static final Short EXECUTIVE_LEGAL = 0;

    /**
     * 高管人员类别
     * 财务负责人
     */
    public static final Short EXECUTIVE_TREASURER = 1;

    /**
     * 高管人员类别
     * 其他
     */
    public static final Short EXECUTIVE_OTHER = 2;

    /**
     * 高管人员类别
     * 总经理
     */
    public static final Short EXECUTIVE_GENERAL_MANAGER = 3;

    /**
     * 家族关系
     * 配偶
     */
    public static final Short FAMILY_SPOUSE = 0;

    /**
     * 家族关系
     * 父母
     */
    public static final Short FAMILY_PARENTS = 1;

    /**
     * 家族关系
     * 子女
     */
    public static final Short FAMILY_CHILDREN = 2;

    /**
     * 家族关系
     * 血亲
     */
    public static final Short FAMILY_RELATIVES = 3;

    /**
     * 家族关系
     * 姻亲
     */
    public static final Short FAMILY_IN_LAWS = 4;

    /**
     * 变更状态
     * 允许
     */
    public static final Short ALTERA_STATUS_YSE = 0;

    /**
     * 变更状态
     * 不允许
     */
    public static final Short ALTERA_STATUS_NO = 1;

    /**
     * 贷款利率类型
     * 人民币贷款基准利率
     */
    public static final Short CNY_LOAN_INTERRATE = 0;

    /**
     * 贷款利率类型
     * 美元贷款利率
     */
    public static final Short USD_LOAND_INTERRATE = 1;

    /**
     * 贷款利率类型
     * 港元贷款利率
     */
    public static final Short HKD_LOAND_INTERRATE = 2;

    /**
     * 贷款利率类型
     * 其他币种
     */
    public static final Short OTH_LOAND_INTERRATE = 3;

    /**
     * 贷款利率浮动方式
     * 百分比
     */
    public static final Short LOAN_RATE_FLOATMETHOD_PERCENT = 0;

    /**
     * 贷款利率浮动方式
     * 绝对值
     */
    public static final Short LOAND_RATE_FLOATMETHOD_ABSOLUTE = 1;

    /**
     * 贷款利率浮动方式
     * 固定利率
     */
    public static final Short LOAND_RATE_TYPE_FIXED = 2;

    /**
     * 流程定义状态[1000257]<br>
     * 新建
     */
    public static final Short WORKFLOW_STATUS_NEW = 0;
    /**
     * 流程定义状态[1000257]<br>
     * 允计
     */
    public static final Short WORKFLOW_STATUS_ENABLE = 1;
    /**
     * 流程定义状态[1000257]<br>
     * 停用
     */
    public static final Short WORKFLOW_STATUS_STOP = 2;
    /**
     * 融资成本测算
     * 流贷资金
     */
    public static final Short CAPITAL_TYPE_FLOW=0;
    /**
     * 融资成本测算
     * 项目保理
     */
    public static final Short CAPITAL_TYPE_PRJ=1;
    /**
     * 资金提款类别
     * 流贷资金
     */
    public static final Short WITHDRAW_TYPE_FLOW=0;
    /**
     * 资金提款类别
     * 项目保理
     */
    public static final Short WITHDRAW_TYPE_PRJ=1;
    /**
     * 融资本金计算规则
     * 按租赁本金合计
     */
    public static final Short FIN_RULE_SUM_CORPUS=0;
    /**
     * 融资本金计算规则
     * 按租金合计
     */
    public static final Short FIN_RULE_SUM_CASH=1;
    /**
     * 融资本金计算规则
     * NPV（租赁本金）
     */
    public static final Short FIN_RULE_NPV_CORPUS=2;
    /**
     * 融资本金计算规则
     * NPV（租金）
     */
    public static final Short FIN_RULE_NPV_CASH=3;
    /**
     * 融资本金计算规则
     * 不规则
     */
    public static final Short FIN_RULE_IRREGULAR=4;
    /**
     * 项目匹配类型
     * 未生效项目
     */
    public static final Short PROJ_TYPE_NOT=0;
    /**
     * 项目匹配类型
     * 已生效项目
     */
    public static final Short PROJ_TYPE_YES=1;
    /**
     * 还本宽限期类型
     * 日
     */
    public static final Short GRACE_TYPE_DAY=0;
    /**
     * 还本宽限期类型
     * 月
     */
    public static final Short GRACE_TYPE_MONTH=1;

    /**
     * 收款类别
     * 银行到账单
     */
    public static final Short GATHER_TYPE_BILL=0;

    /**
     * 收款类别
     * 暂收款
     */
    public static final Short GATHER_TYPE_ADRE=1;

    /**
     * 收款类别
     * 银票
     */
    public static final Short GATHER_TYPE_NOTE=2;

    /**
     * 收款类别
     * 保证金冲抵
     */
    public static final Short GATHER_TYPE_DEPOSIT=3;

    /**
     * 收款类别
     * 保证金利息冲抵
     */
    public static final Short GATHER_TYPE_DEPOSIT_INTEREST=4;

    /**
     * 收款类别
     * 预收租金冲抵
     */
    public static final Short GATHER_TYPE_ADVANCE_AGAINST=5;

    /**
     * 收款类别
     * 存入保证金冲抵
     */
    public static final Short GATHER_TYPE_DEPOSIT_AGAINST=6;

    /**
     * 收款类别
     * 银票保证金退回
     */
    public static final Short GATHER_TYPE_DEPOSIT_BACK_BANK=7;


    /**
     * 核销方式
     * 系统
     */
    public static final Short CHARGE_METHOD_SYS=1;

    /**
     * 核销方式
     * 手工
     */
    public static final Short CHARGE_METHOD_HAND=2;

    /**
     * 核销方式
     * 暂挂账
     */
    public static final Short CHARGE_METHOD_TEMP=3;

    /**
     * 核销方式
     * 系统（日终）
     */
    public static final Short CHARGE_METHOD_DAYEND=4;

    /**
     * 核销方式
     * 无
     */
    public static final Short CHARGE_METHOD_NOTHING=0;


    /**
     * 贷款支付日 枚举 随收租日
     */
    public static final Short CAPITAL_PAY_DAY_0 = 0;

    /**
     * 贷款支付日 枚举 1
     */
    public static final Short CAPITAL_PAY_DAY_1 = 1;

    /**
     * 贷款支付日 枚举 2
     */
    public static final Short CAPITAL_PAY_DAY_2 = 2;

    /**
     * 贷款支付日 枚举 3
     */
    public static final Short CAPITAL_PAY_DAY_3 = 3;

    /**
     * 贷款支付日 枚举 4
     */
    public static final Short CAPITAL_PAY_DAY_4 = 4;

    /**
     * 贷款支付日 枚举 5
     */
    public static final Short CAPITAL_PAY_DAY_5 = 5;

    /**
     * 贷款支付日 枚举 6
     */
    public static final Short CAPITAL_PAY_DAY_6 = 6;

    /**
     * 贷款支付日 枚举 7
     */
    public static final Short CAPITAL_PAY_DAY_7 = 7;

    /**
     * 贷款支付日 枚举 8
     */
    public static final Short CAPITAL_PAY_DAY_8 = 8;

    /**
     * 贷款支付日 枚举 9
     */
    public static final Short CAPITAL_PAY_DAY_9 = 9;

    /**
     * 贷款支付日 枚举 10
     */
    public static final Short CAPITAL_PAY_DAY_10 = 10;

    /**
     * 贷款支付日 枚举 11
     */
    public static final Short CAPITAL_PAY_DAY_11 = 11;

    /**
     * 贷款支付日 枚举 12
     */
    public static final Short CAPITAL_PAY_DAY_12 = 12;

    /**
     * 贷款支付日 枚举 13
     */
    public static final Short CAPITAL_PAY_DAY_13 = 13;

    /**
     * 贷款支付日 枚举 14
     */
    public static final Short CAPITAL_PAY_DAY_14 = 14;

    /**
     * 贷款支付日 枚举 15
     */
    public static final Short CAPITAL_PAY_DAY_15 = 15;

    /**
     * 贷款支付日 枚举 16
     */
    public static final Short CAPITAL_PAY_DAY_16 = 16;

    /**
     * 贷款支付日 枚举 17
     */
    public static final Short CAPITAL_PAY_DAY_17 = 17;

    /**
     * 贷款支付日 枚举 18
     */
    public static final Short CAPITAL_PAY_DAY_18 = 18;

    /**
     * 贷款支付日 枚举 19
     */
    public static final Short CAPITAL_PAY_DAY_19 = 19;

    /**
     * 贷款支付日 枚举 20
     */
    public static final Short CAPITAL_PAY_DAY_20 = 20;

    /**
     * 贷款支付日 枚举 21
     */
    public static final Short CAPITAL_PAY_DAY_21 = 21;

    /**
     * 贷款支付日 枚举 22
     */
    public static final Short CAPITAL_PAY_DAY_22 = 22;

    /**
     * 贷款支付日 枚举 23
     */
    public static final Short CAPITAL_PAY_DAY_23 = 23;

    /**
     * 贷款支付日 枚举 24
     */
    public static final Short CAPITAL_PAY_DAY_24 = 24;

    /**
     * 贷款支付日 枚举 25
     */
    public static final Short CAPITAL_PAY_DAY_25 = 25;

    /**
     * 贷款支付日 枚举 26
     */
    public static final Short CAPITAL_PAY_DAY_26 = 26;

    /**
     * 贷款支付日 枚举 27
     */
    public static final Short CAPITAL_PAY_DAY_27 = 27;

    /**
     * 贷款支付日 枚举 28
     */
    public static final Short CAPITAL_PAY_DAY_28 = 28;

    /**
     * 贷款支付日 枚举 29
     */
    public static final Short CAPITAL_PAY_DAY_29 = 29;

    /**
     * 贷款支付日 枚举 30
     */
    public static final Short CAPITAL_PAY_DAY_30 = 30;

    /**
     * 贷款支付日 枚举 31
     */
    public static final Short CAPITAL_PAY_DAY_31 = 31;


    /**
     * 计划表类别
     * 其它资金计划表
     */
    public static final Short PLAN_TABLE_TYPE_CAPITAL=0;

    /**
     * 计划表类别
     * 还款计划表
     */
    public static final Short PLAN_TABLE_TYPE_REPAY=1;

    /**
     * 银票状态[1000265]<br>
     * 未生效
     */
    public static final Short BA_STATUS_DISABLE = 1;

    /**
     * 银票状态[1000265]<br>
     * 生效
     */
    public static final Short BA_STATUS_ENABLE = 0;

    /**
     * 银票状态[1000265]<br>
     * 已核销
     */
    public static final Short BA_STATUS_HANDED = 2;

    /**
     * 银票状态[1000265]<br>
     * 承兑
     */
    public static final Short BA_STATUS_ACCEPT = 3;

    /**
     * 银票状态[1000265]<br>
     * 申请付款
     */
    public static final Short BA_STATUS_APPLY = 4;

    /**
     * 贷款融资金额计算精度 枚举 分
     */
    public static final Short CAPITAL_CENT = 0;

    /**
     * 贷款融资金额计算精度 枚举 元
     */
    public static final Short CAPITAL_DOLLER = 1;
    /**
     * 贷款融资金额计算精度 枚举 百元
     */
    public static final Short CAPITAL_CENTURY = 2;
    /**
     * 贷款融资金额计算精度 枚举 千元
     */
    public static final Short CAPITAL_THOUSAND = 3;

    /**
     * 贷款融资金额计算精度 枚举 万元
     */
    public static final Short CAPITAL_MYRIAD = 4;

    /**
     * 收支计划执行状态 初始
     */
    public static final Short EXEC_STATUS_INITIAL = 0;

    /**
     * 收支计划执行状态 付款审核中
     */
    public static final Short EXEC_STATUS_AUDITING = 1;

    /**
     * 收支计划执行状态 付款驳回修改中
     */
    public static final Short EXEC_STATUS_PAY_DISMISSING = 2;

    /**
     * 收支计划执行状态 付款安排中
     */
    public static final Short EXEC_STATUS_ARRANGING = 3;

    /**
     * 收支计划执行状态 付款处理中
     */
    public static final Short EXEC_STATUS_EXECING = 4;

    /**
     * 收支计划执行状态 付款核销中
     */
    public static final Short EXEC_STATUS_PAY_CHARGING = 5;

    /**
     * 收支计划执行状态 收款核销中
     */
    public static final Short EXEC_STATUS_GA_CHARGING = 6;

    /**
     * 收支计划执行状态 收款驳回修改中
     */
    public static final Short EXEC_STATUS_GA_DISMISSING = 7;

    /**
     * 收支计划执行状态 免罚息中
     */
    public static final Short EXEC_STATUS_NOPENALTY = 8;

    /**
     * 收支计划执行状态 自动核销中
     */
    public static final Short EXEC_STATUS_AUTOCHARGING = 9;

    /**
     * 收支计划执行状态 已完成
     */
    public static final Short EXEC_STATUS_OVER = 10;

    /**
     * 收支计划执行状态 付款待审核
     */
    public static final Short EXEC_STATUS_PAY_UNAUDIT = 11;

    /**
     * 收支计划执行状态 收款待审核
     */
    public static final Short EXEC_STATUS_GA_UNAUDIT = 12;

    /**
     * 收支计划执行状态 转出转回项目中
     */
    public static final Short EXEC_STATUS_ROLL_OUT_IN = 13;

    /**
     * 核销状态：未核销
     */
    public static final Short CHARGE_STATUS_NO = 0;

    /**
     * 核销状态：部分核销
     */
    public static final Short CHARGE_STATUS_PART = 1;

    /**
     * 核销状态：已核销
     */
    public static final Short CHARGE_STATUS_OVER = 2;

    /**
     * 核销状态：核销中
     */
    public static final Short CHARGE_STATUS_CHARGEING = 3;

    /**
     * 核销状态：部分减免
     */
    public static final Short CHARGE_STATUS_PARTRE= 4;

    /**
     * 立即舍位
     *
     */
    public static final Short DATE_INTEREST_NOW = 0;

    /**
     * 暂不舍位
     *
     */
    public static final Short DATE_INTEREST_WAIT = 1;

    /**
     * 计提业务类型[1000273]<br>
     * 租金计提
     */
    public static final Short ACCRUAL_TYPE_RENT = 0;
    /**
     * 计提业务类型[1000273]<br>
     * 手续费计提
     */
    public static final Short ACCRUAL_TYPE_DEPOSIT = 1;
    /**
     * 计提业务类型[1000273]<br>
     * 转出预收租金
     */
    public static final Short ACCRUAL_TYPE_OUT_CASH = 2;
    /**
     * 计提业务类型[1000273]<br>
     * 转入预收租金
     */
    public static final Short ACCRUAL_TYPE_IN_CAHS = 3;
    /**
     * 计提业务类型[1000273]<br>
     * 暂收款转租金
     */
    public static final Short ACCRUAL_TYPE_HAND_SUSPENSE = 4;
    /**
     * 计提业务类型[1000273]<br>
     * 存入保证金冲抵租金
     */
    public static final Short ACCRUAL_TYPE_HAND_DEPOSIT = 5;
    /**
     * 计提业务类型[1000273]<br>
     * 预收租金冲抵租金
     */
    public static final Short ACCRUAL_TYPE_HAND_RENT_CASH = 6;
    /**
     * 计提业务类型[1000273]<br>
     * 应收租金转逾期
     */
    public static final Short ACCRUAL_TYPE_HAND_OVERDUE = 7;
    /**
     * 计提业务类型[1000273]<br>
     * 计提本月租息
     */
    public static final Short ACCRUAL_TYPE_HAND_ACCRUAL = 8;
    /**
     * 计提业务类型[1000273]<br>
     * 调整预提利息
     */
    public static final Short ACCRUAL_TYPE_HAND_ADJUST = 9;
    /**
     * 计提业务类型[1000273]<br>
     * 转出应付增值税
     */
    public static final Short ACCRUAL_TYPE_HAND_ADDED = 10;
    /**
     * 计提业务类型[1000273]<br>
     * 手续费计提(中投)
     */
    public static final Short ACCRUAL_TYPE_SRV_ZT = 11;
    /**
     * 计提业务类型[1000273]<br>
     * 其他收入(留购价-中投)
     */
    public static final Short ACCRUAL_TYPE_PRICE_ZT = 12;
    /**
     * 计提业务类型[1000273]<br>
     * 其他支出(中间费用支出-中投)
     */
    public static final Short ACCRUAL_TYPE_BUSINESS_ZT = 13;
    /**
     * 计提业务类型[1000273]<br>
     * 保证金利息计提(江苏)
     */
    public static final Short ACCRUAL_TYPE_DEP_INTEREST_JZ = 14;
    /**
     * 计提业务类型[1000273]<br>
     * 厂商保证金冲抵
     */
    public static final Short ACCRUAL_TYPE_HAND_VENDER_DEPOSIT = 15;
    /**
     * 计提业务类型[1000273]<br>
     * 风险金冲抵
     */
    public static final Short ACCRUAL_TYPE_HAND_RISK = 16;
    /**
     * 计提业务类型[1000273]<br>
     * 保证金冲抵转回
     */
    public static final Short ACCRUAL_TYPE_DEPOSIT_BACK = 17;
    /**
     * 计提业务类型[1000273]<br>
     * 预收租金冲抵转回
     */
    public static final Short ACCRUAL_TYPE_RENT_CASH_BACK = 18;
    /**
     * 计提业务类型[1000273]<br>
     * 风险金冲抵转回
     */
    public static final Short ACCRUAL_TYPE_RISK_BACK = 19;
    /**
     * 计提业务类型[1000273]<br>
     * 厂商保证金冲抵转回
     */
    public static final Short ACCRUAL_TYPE_VENDER_DEPOSIT_BACK = 20;


    /**
     * 暂收款处理方式：冲抵
     */
    public static final Short DEAL_METHOD_OFFSET = 0;

    /**
     * 暂收款处理方式：退回
     */
    public static final Short DEAL_METHOD_RETURN = 1;
    /**
     * 调息状态
     * 调息申请中
     */
    public static final Short PRA_STATUS_APPLY=0;
    /**
     * 调息状态
     * 调息执行中
     */
    public static final Short PRA_STATUS_EXECUTE=1;
    /**
     * 调息状态
     * 调息免调中
     */
    public static final Short PRA_STATUS_SPARE=2;
    /**
     * 调息状态
     * 调息完成
     */
    public static final Short PRA_STATUS_FINISH=3;
    /**
     * 资产状态：正常
     */
    public static final Short ASSET_STATUS_NORMAL = 0;

    /**
     * 资产状态：有追索转出
     */
    public static final Short ASSET_STATUS_SEARCH = 1;

    /**
     * 资产状态：无追索转出
     */
    public static final Short ASSET_STATUS_NO_SEARCH = 2;
    /**
     * 银行对账单分类: 收款
     */
    public static final Short CLASSIFY_INCOME = 1;

    /**
     * 借贷方向: 借
     */
    public static final Short DEBIT = 0;

    /**
     * 借贷方向: 贷
     */
    public static final Short LOAN = 1;

    /**
     * 逾期表类型--逾期处理
     */
    public static final Short PENALTY_TABLE_TYPE_PENALTY = 0;

    /**
     * 逾期表类型--预测罚息
     */
    public static final Short PENALTY_TABLE_TYPE_FORECAST = 1;

    /**
     * 逾期表类型--客户预测罚息
     */
    public static final Short PENALTY_TABLE_TYPE_FORECASTCUST = 2;

    /**
     * 控制类型--软性控制
     */
    public static final Short CONTROL_TYPE_SOFT = 0;

    /**
     * 控制类型--硬性控制
     */
    public static final Short CONTROL_TYPE_HARD = 1;

    /**
     * 测算方案状态--初始测算
     */
    public static final Short INITIAL_QUOT = 0;

    /**
     * 测算方案状态--立项中
     */
    public static final Short PROJECT_IN = 1;

    /**
     * 测算方案状态--已签约
     */
    public static final Short SIGNED = 2;

    /**
     * 测算方案状态--共享方案
     */
    public static final Short SHARE_SCHEME = 3;

    /**
     * 是否内扣 是-收入
     */
    public static final Short INNER_DEDUCT_YESIN = 0;

    /**
     * 是否内扣 否
     */
    public static final Short INNER_DEDUCT_NO = 1;

    /**
     * 是否内扣 是-支出
     */
    public static final Short INNER_DEDUCT_YESOUT = 2;

    /**
     * 处理状态-未处理
     */
    public static final Short DEAL_STATUS_NO_TREATMENT  = 0;
    /**
     * 处理状态-已处理
     */
    public static final Short DEAL_STATUS_PROCESSED = 1;
    /**
     * 处理状态-已核销
     */
    public static final Short DEAL_STATUS_WRITE_OFF  = 2;

    /**
     * 处理状态-作废
     */
    public static final Short DEAL_STATUS_DISCARDED  = 3;


    /**
     * 资质分类  医疗许可证
     */
    public static final Short QUALIFICATION_TYPE_MEDICAL = 0;

    /**
     * 资质分类  印刷许可证
     */
    public static final Short QUALIFICATION_TYPE_PRINTING = 1;

    /**
     * 资质分类  医疗设备经营许可证
     */
    public static final Short QUALIFICATION_TYPE_MEDICAL_EQUIPMENT = 2;

    /**
     * 资质分类  COS/CEP证书
     */
    public static final Short QUALIFICATION_TYPE_CERTIFICATE = 3;

    /**
     * 设备类型  国产
     */
    public static final Short EQUIPMENT_TYPE_HOMEMADE = 0;

    /**
     * 设备类型  进口
     */
    public static final Short EQUIPMENT_TYPE_IMPORT = 1;

    /**
     * 事项类型  停产
     */
    public static final Short MATTER_TYPE_SHUTDOWN = 0;

    /**
     * 事项类型  半停产
     */
    public static final Short MATTER_TYPE_SEMI_SHUTDOWN = 1;

    /**
     * 事项类型  展期
     */
    public static final Short MATTER_TYPE_EXTENSION = 2;

    /**
     * 事项类型  重组
     */
    public static final Short MATTER_TYPE_RECOMBINATION = 3;

    /**
     * 事项类型  破产
     */
    public static final Short MATTER_TYPE_BANKRUPTCY = 4;

    /**
     * 事项类型  涉诉
     */
    public static final Short MATTER_TYPE_LAWSUIT = 5;

    /**
     * 事项类型  其他
     */
    public static final Short MATTER_TYPE_OTHER = 6;

    /**
     * 事项类型  高管变动
     */
    public static final Short MATTER_EXECUTIVE_CHANGE = 7;

    /**
     * 股东关系  集团
     */
    public static final Short SHAREHOLDER_ROLE_GROUP = 0;

    /**
     * 股东关系  股东
     */
    public static final Short SHAREHOLDER_ROLE_SHAREHOLDER = 1;

    /**
     * 不动产分类  企业土地
     */
    public static final Short REAL_ESTATE_CLASS_ENTERPRISE_LAND = 0;

    /**
     * 不动产分类  企业厂房
     */
    public static final Short REAL_ESTATE_CLASS_ENTERPRISES_FACTORY = 1;

    /**
     * 不动产分类  在建工程
     */
    public static final Short REAL_ESTATE_CLASS_ENGINEERING = 2;

    /**
     * 不动产分类  个人土地
     */
    public static final Short REAL_ESTATE_CLASS_INDIVIDUAL_LAND = 3;

    /**
     * 不动产分类  个人房产
     */
    public static final Short REAL_ESTATE_CLASS_INDIVIDUAL_PROPERTY = 4;

    /**
     * 不动产分类  其它
     */
    public static final Short REAL_ESTATE_CLASS_OTHER = 5;

    /**
     * 银行到账单（是否） 枚举 否
     */
    public static final Short BANK_YESNO_NO = 0;

    /**
     * 银行到账单（是否） 枚举 是
     */
    public static final Short BANK_YESNO_YES = 1;

    /**
     * 客户诉讼角色  主诉
     */
    public static final Short LITIGATION_ROLES_PLAINTIFF = 0;

    /**
     * 客户诉讼角色  被诉
     */
    public static final Short LITIGATION_ROLES_DEFENDANT = 1;

    /**
     * 称号  211
     */
    public static final Short TITLE_TITLE_ONE = 0;

    /**
     * 称号  985
     */
    public static final Short TITLE_TITLE_TWO = 1;

    /**
     * 称号  百强示范
     */
    public static final Short TITLE_TITLE_THREE = 2;

    /**
     * 称号  百强骨干
     */
    public static final Short TITLE_TITLE_FOUR = 3;

    /**
     * 称号  无
     */
    public static final Short TITLE_TITLE_FIVE = 4;

    /**
     * 隶属  部署
     */
    public static final Short SUBJECTION_SUBJEC_ONE = 0;

    /**
     * 隶属  省属
     */
    public static final Short SUBJECTION_SUBJEC_TWO = 1;

    /**
     * 隶属  市属
     */
    public static final Short SUBJECTION_SUBJEC_THREE = 2;

    /**
     * 隶属  无
     */
    public static final Short SUBJECTION_SUBJEC_FOUR = 3;

    /**
     * 隶属  县
     */
    public static final Short SUBJECTION_SUBJEC_FIVE = 4;

    /**
     * 隶属  地市级
     */
    public static final Short SUBJECTION_SUBJEC_SIX = 5;

    /**
     * 隶属  省
     */
    public static final Short SUBJECTION_SUBJEC_SEVEN = 6;

    /**
     * 提醒方式: 短信
     */
    public static final Short REMIND_METHOD_NOTE = 0;

    /**
     * 提醒方式: 邮件
     */
    public static final Short REMIND_METHOD_MAIL = 1;

    /**
     * 提醒方式: 通知函
     */
    public static final Short REMIND_METHOD_NOTICE = 2;

    /**
     * 提醒类别: 提前提醒
     */
    public static final Short REMIND_CATEGORY_PRE = 0;

    /**
     * 提醒类别: 逾期提醒
     */
    public static final Short REMIND_CATEGORY_OVERDUE = 1;
    /**
     * 提醒类别: 提前结清
     */
    public static final Short REMIND_CATEGORY_BEFOREND = 2;
    /**
     * 提醒类别: 起租提醒
     */
    public static final Short REMIND_CATEGORY_BEGIN = 3;
    /**
     * 提醒类别: 结束提醒
     */
    public static final Short REMIND_CATEGORY_END = 4;

    /**
     * 提醒标记: 未提醒
     */
    public static final Short REMIND_FLAG_NO = 0;

    /**
     * 提醒标记: 已提醒
     */
    public static final Short REMIND_FLAG_OVER = 1;

    /**
     * 提醒标记: 提醒已免除
     */
    public static final Short REMIND_FLAG_AVOID = 2;

    /**
     * 快递公司: 顺风速递
     */
    public static final Short EXPRESS_COMPANY_SF = 0;

    /**
     * 快递公司: EMS
     */
    public static final Short EXPRESS_COMPANY_EMS = 1;

    /**
     * 快递公司: 圆通快递
     */
    public static final Short EXPRESS_COMPANY_YT = 2;

    /**
     * 快递公司: 申通快递
     */
    public static final Short EXPRESS_COMPANY_ST = 3;

    /**
     * 担保方式(保证信息) 无
     */
    public static final Short GUARANTEE_METHODS_NO = 0;

    /**
     * 担保方式(保证信息) 保证担保
     */
    public static final Short GUARANTEE_METHODS_GUARANTEE = 1;

    /**
     * 担保方式(保证信息) 信用担保
     */
    public static final Short GUARANTEE_METHODS_CREDIT = 2;

    /**
     * 担保方式(保证信息) 抵押担保
     */
    public static final Short GUARANTEE_METHODS_COLLATERAL = 3;

    /**
     * 担保方式(保证信息) 贴现及买断式转贴现
     */
    public static final Short GUARANTEE_METHODS_DISCOUNT = 4;

    /**
     * 担保方式(保证信息) 质押担保
     */
    public static final Short GUARANTEE_METHODS_PRENDA = 5;

    /**
     * 担保方式(保证信息) 供应商回购
     */
    public static final Short GUARANTEE_METHODS_BACK = 6;
    /**
     * 担保方式(保证信息) 风险金计提
     */
    public static final Short GUARANTEE_METHODS_RISK = 7;
    /**
     * 担保方式(保证信息) 收取保证金
     */
    public static final Short GUARANTEE_METHODS_DEPOSIT = 8;

    /**
     * 提醒对象: 客户经理
     */
    public static final Short REMIND_OBJ_CUST_MANAGER = 0;

    /**
     * 提醒对象: 承租方联系人
     */
    public static final Short REMIND_OBJ_CONTACT = 1;


    /**
     * 系统标识： 江租
     */
    public static final Short SYSTEM_JZ = 2;
    /**
     * 系统标识： 中投
     */
    public static final Short SYSTEM_ZT = 1;
    /**
     * 系统标识： 原型
     */
    public static final Short SYSTEM = 0;
    /**
     * 系统标识： 聚信
     */
    public static final Short SYSTEM_JX = 3;

    /**
     * 指标集类型[1000297]<br>
     * 一维指标
     */
    public static final Short SET_TYPE_ONE = 0;
    /**
     * 指标集类型[1000297]<br>
     * 二维指标
     */
    public static final Short SET_TYPE_TWO = 1;
    /**
     * 指标集类型[1000297]<br>
     * 参数
     */
    public static final Short SET_TYPE_ARG = 2;

    /**
     * 催收标记: 未催收
     */
    public static final Short OVERDUE_FLAG_NO = 0;

    /**
     * 催收标记: 已催收
     */
    public static final Short OVERDUE_FLAG_OVER = 1;

    /**
     * 催收标记: 催收已免除
     */
    public static final Short OVERDUE_FLAG_AVOID = 2;

    /**
     * 是否有效 有效
     */
    public static final Short IF_EFFECTIVE_YES = 0;

    /**
     * 是否有效 无效
     */
    public static final Short IF_EFFECTIVE_NO = 1;
    /**
     * 数据类型
     * 金额
     */
    public static final Short DATA_TYPE_AMT=0;
    /**
     * 数据类型
     * 枚举
     */
    public static final Short DATA_TYPE_ENUMS=1;
    /**
     * 数据类型
     * 字符
     */
    public static final Short DATA_TYPE_STR=2;
    /**
     * 数据类型
     * 百分比
     */
    public static final Short DATA_TYPE_RCENT=3;
    /**
     * 数据类型
     * 整数
     */
    public static final Short DATA_TYPE_INTEGER=4;

    /**
     * 逾期记录处理状态 已处理
     */
    public static final Short IF_HANDLE_YES = 0;

    /**
     * 逾期记录处理状态 未处理
     */
    public static final Short IF_HANDLE_NO = 1;

    /**
     * 记账指标设置选项：业务凭证
     */
    public static final Short ACCT_KPI_OPTION_BUSIBILL = 0;

    /**
     * 记账指标设置选项：业务流水影响因素
     */
    public static final Short ACCT_KPI_OPTION_BFFACTOR = 1;

    /**
     * 记账指标设置选项：会计流水影响因素
     */
    public static final Short ACCT_KPI_OPTION_AFFACTOR = 2;

    /**
     * 记账指标设置选项：辅助核算
     */
    public static final Short ACCT_KPI_OPTION_ASSIST = 3;
    /**
     * 合同修改（调息）
     * 调息方法
     */
    public static final Short CONT_MODIFI_ADJUST_0=0;
    /**
     * 合同修改（调息）
     * 调息相应日
     */
    public static final Short CONT_MODIFI_ADJUST_1=1;
    /**
     * 合同修改（调息）
     * 不需要
     */
    public static final Short CONT_MODIFI_ADJUST_2=2;



    /**
     * 指标分析种类
     * 原材料及半成品
     */
    public static final Short ANALYSIS_CLASS_HALF=0;
    /**
     * 指标分析种类
     * 产成品
     */
    public static final Short ANALYSIS_CLASS_ALL=1;

    /**
     * 款项类型
     * 应收账款
     */
    public static final Short ANALYSIS_TYPE_RECEIVABLE = 0;

    /**
     * 款项类型
     * 其他应收款
     */
    public static final Short ANALYSIS_TYPE_OTHER_RECEIVABLE = 1;

    /**
     * 款项类型
     * 应付账款
     */
    public static final Short ANALYSIS_TYPE_PAYABLE = 2;

    /**
     * 款项类型
     * 其他应付款
     */
    public static final Short ANALYSIS_TYPE_PAYABLE_OTHERS = 3;

    /**
     * 融资信贷类型
     * 融资
     */
    public static final Short CREDIT_TYPE_FINANCING = 0;

    /**
     * 融资信贷类型
     * 信贷
     */
    public static final Short CREDIT_TYPE_CREDIT = 1;

    /**
     * 操作状态
     * 未操作
     */
    public static final Short OPERATOR_NOT = 0;
    /**
     * 操作状态
     * 保存
     */
    public static final Short OPERATOR_SAVE = 1;
    /**
     * 操作状态
     * 修改
     */
    public static final Short OPERATOR_EDIT = 2;
    /**
     * 操作状态
     * 删除
     */
    public static final Short OPERATOR_DELETE = 3;
    /**
     * 调息时点(资金-提款)
     * 当日调息
     */
    public static final Short ADJUST_TIME_FUNDS_DAY = 0;

    /**
     * 调息时点(资金-提款)
     * 次日调息
     */
    public static final Short ADJUST_TIME_FUNDS_NEXT_DAY = 1;

    /**
     * 调息时点(资金-提款)
     * 次月调息
     */
    public static final Short ADJUST_TIME_FUNDS_NEXT_MONTH = 2;

    /**
     * 调息时点(资金-提款)
     * 调息后第一个工作日
     */
    public static final Short ADJUST_TIME_FUNDS_WORK_DAY = 3;

    /**
     * 调息时点(资金-提款)
     * 次月第一个工作日
     */
    public static final Short ADJUST_TIME_FUNDS_MONTH_WORK_DAY = 4;

    /**
     * 调息时点(资金-提款)
     * 次季度首月第一个工作日
     */
    public static final Short ADJUST_TIME_FUNDS_NEXT_QUARTERLY = 5;
    /**
     * 调息时点(资金-提款)
     * 下一结息日次日
     */
    public static final Short NEXT_EXPIRY_DAY = 6;
    /**
     * 调息时点(资金-提款)
     * 次月第一天
     */
    public static final Short NEXT_MONTH_DAY = 7;
    /**
     * 调息时点(资金-提款)
     * 提款日每满年
     */
    public static final Short PAYLOAN_NEXT_YEAR=11;

    /**
     * 逾期状态
     * 正常
     */
    public static final Short OVERDUE_STATUS_NORMAL = 0;

    /**
     * 逾期状态
     * 逾期中
     */
    public static final Short OVERDUE_STATUS_MIDWAY = 1;

    /**
     * 逾期状态
     * 已完成
     */
    public static final Short OVERDUE_STATUS_COMPLETION = 2;

    /**
     * 逾期状态
     * 初始未定
     */
    public static final Short OVERDUE_STATUS_UNDECIDED = 3;

    /**
     * 逾期状态
     * 初始已定
     */
    public static final Short OVERDUE_STATUS_DECIDED = 4;

    /**
     * 保证金类型[1000311]<br>
     * 预收租金
     */
    public static final Short DEPOSIT_TYPE_PRE_RENT = 0;
    /**
     * 保证金类型[1000311]<br>
     * 风险金
     */
    public static final Short DEPOSIT_TYPE_RISK = 1;
    /**
     * 合同参与调息控制
     * 合同签订后
     */
    public static final Short CONT_ADJUST_SIGNING=0;
    /**
     * 合同参与调息控制
     * 起租后
     */
    public static final Short CONT_ADJUST_PLAN=1;

    /**
     * 指标项类型[1000312]<br>
     * 其它
     */
    public static final Short KPI_ITEM_TYPE_OTHER = 0;
    /**
     * 指标项类型[1000312]<br>
     * 计账体系影响因素
     */
    public static final Short KPI_ITEM_TYPE_FACTOR = 1;
    /**
     * 指标项类型[1000312]<br>
     * 计账体系辅助核算
     */
    public static final Short KPI_ITEM_TYPE_ACCOUNTING = 2;

    /**
     * 违约金计算基数 租金总额
     *
     */
    public static final Short LIQUIDATE_DAMAGES_BASE_RENT_TOTAL = 0;

    /**
     * 违约金计算基数 投放总额
     *
     */
    public static final Short LIQUIDATE_DAMAGES_BASE_LOAN_TOTAL = 1;

    /**
     * 版本类型 原始
     */
    public static final Short VERSION_TYPE_ORIGINAL = 0;

    /**
     * 版本类型 历史
     */
    public static final Short VERSION_TYPE_HISTORY = 1;

    /**
     * 版本类型 生效
     */
    public static final Short VERSION_TYPE_CHECK = 2;

    /**
     * 安排状态 - 已安排
     */
    public static final Short ARRANGE_STATUS_YES = 0;

    /**
     * 安排状态 - 未安排
     */
    public static final Short ARRANGE_STATUS_NO = 1;


    /**
     * 单据定义设置数据存储类别 - 不存储
     */
    public static final Short BILLDEF_SAVETYPE_NO = 0;

    /**
     * 单据定义设置数据存储类别 - 增量存储
     */
    public static final Short BILLDEF_SAVETYPE_PART_ADD = 1;

    /**
     * 单据定义设置数据存储类别 - 完全更新存储
     */
    public static final Short BILLDEF_SAVETYPE_ALL_ADD = 2;

    /**
     * 查询期间 - 本月
     */
    public static final Short QUERY_BETWEEN_MONTH = 0;
    /**
     * 查询期间 - 本季
     */
    public static final Short QUERY_BETWEEN_QUARTER = 1;
    /**
     * 查询期间 - 本年
     */
    public static final Short QUERY_BETWEEN_YEAR = 2;

    /**
     * 付款节点-付款类型 网银
     */
    public static final Short LOAN_PAY_TYPE_NET = 0;
    /**
     * 付款节点-付款类型 银票
     */
    public static final Short LOAN_PAY_TYPE_NOTE = 1;
    /**
     * 付款节点-付款类型 电汇
     */
    public static final Short LOAN_PAY_TYPE_TELEGRAPHIC = 2;
    /**
     * 付款节点-付款类型 支票
     */
    public static final Short LOAN_PAY_TYPE_CHECK = 3;
    /**
     * 付款节点-付款类型 本票
     */
    public static final Short LOAN_PAY_TYPE_STAMP = 4;
    /**
     * 综合报价-年化利率方式 费用/（本金-保证金）/年数
     */
    public static final Short YEAR_RATE_WAY_0 = 0;
    /**
     * 综合报价-年化利率方式 费用/本金/年数
     */
    public static final Short YEAR_RATE_WAY_1 = 1;
    /**
     * 综合报价-年化利率方式 费用/（本金-保证金）/年数*2
     */
    public static final Short YEAR_RATE_WAY_2 = 2;
    /**
     * 综合报价-年化利率方式 费用/（本金）/年数*2
     */
    public static final Short YEAR_RATE_WAY_3 = 3;
    /**
     * 综合报价-年化利率方式 费用/（本金-保证金）/月数*12
     */
    public static final Short YEAR_RATE_WAY_4 = 4;
    /**
     * 综合报价-年化利率方式 费用/本金/月数*12
     */
    public static final Short YEAR_RATE_WAY_5 = 5;
    /**
     * 综合报价-年化利率方式 费用/（本金-保证金）/月数*12*2
     */
    public static final Short YEAR_RATE_WAY_6 = 6;
    /**
     * 综合报价-年化利率方式 费用/本金/月数*12*2
     */
    public static final Short YEAR_RATE_WAY_7 = 7;

    /**
     * 行业信息-船舶行业
     */
    public static final Short INDUSTRY_TYPE_WATERCRAFT = 0;
    /**
     * 行业信息-教育行业
     */
    public static final Short INDUSTRY_TYPE_EDUCATION = 1;
    /**
     * 行业信息-医疗行业
     */
    public static final Short INDUSTRY_TYPE_HOSPITAL = 2;
    /**
     * 行业信息-印刷
     */
    public static final Short INDUSTRY_TYPE_PRINT = 3;
    /**
     * 转出转回类型-转出
     */
    public static final Short ROLL_TYPE_OUT = 0;
    /**
     * 转出转回类型-转回
     */
    public static final Short ROLL_TYPE_IN = 1;
    /**
     * 船舶种类-散货船
     */
    public static final Short WATERCRAFT_CLASS_BULKLOAD = 0;
    /**
     * 能源类型 用水
     */
    public static final Short ENERGY_TYPE_WATER = 0;
    /**
     * 能源类型 用电
     */
    public static final Short ENERGY_TYPE_POWER = 1;
    /**
     * 产品种类 原材料
     */
    public static final Short PRODUCTS_TYPE_RAW_MATERIAL = 0;
    /**
     * 产品种类 半成品
     */
    public static final Short PRODUCTS_TYPE_HALF = 1;
    /**
     * 产品种类 产成品
     */
    public static final Short PRODUCTS_TYPE_ALL = 2;
    /**
     * 质量状态 优
     */
    public static final Short QUALITY_STATE_AMPLE = 0;
    /**
     * 质量状态 良
     */
    public static final Short QUALITY_STATE_GOOD = 1;
    /**
     * 质量状态 差
     */
    public static final Short QUALITY_STATE_MISTAKE = 2;


    /**
     * 光影像类型 无
     */
    public static final Short LIGHT_TYPE_WITHOUT = 0;
    /**
     * 光影像类型 核磁
     */
    public static final Short LIGHT_TYPE_NMR  = 1;
    /**
     * 光影像类型 彩超
     */
    public static final Short LIGHT_TYPE_COLOUR = 2;
    /**
     * 光影像类型 直线加速器
     */
    public static final Short LIGHT_TYPE_LINAC = 3;
    /**
     * 光影像类型 CT
     */
    public static final Short LIGHT_TYPE_CT = 4;
    /**
     * 光影像类型 DR
     */
    public static final Short LIGHT_TYPE_DR = 5;
    /**
     * 光影像类型 体检
     */
    public static final Short LIGHT_TYPE_TEST = 6;


    /**
     * 教育行业类型
     */
    public static final Short DEGREE_TYPE_PLAN = 0;
    /**
     * 教育行业类型
     */
    public static final Short DEGREE_TYPE_FACT = 1;
    /**
     * 教育行业类型
     */
    public static final Short DEGREE_TYPE_ON = 2;

    /**
     * 来源类型(ksj) - 客户账户
     */
    public static final Short SOURCE_TYPE_CUSTOMER = 0;
    /**
     * 来源类型(ksj) - 租赁公司账户
     */
    public static final Short SOURCE_TYPE_BOSS = 1;

    /**
     * 开票状态[1000334] - 未开票
     */
    public static final Short INVOICE_STATUS_NO = 0;
    /**
     * 开票状态[1000334] - 部分开票
     */
    public static final Short INVOICE_STATUS_PART = 1;
    /**
     * 开票状态[1000334] - 已开票
     */
    public static final Short INVOICE_STATUS_ALL = 2;

    /**
     * 开票流程状态[1000335] - 初始
     */
    public static final Short PROCESS_STATUS_START = 0;
    /**
     * 开票流程状态[1000335] - 已申请
     */
    public static final Short PROCESS_STATUS_APPLY = 1;
    /**
     * 开票流程状态[1000335] - 已完成
     */
    public static final Short PROCESS_STATUS_END = 2;

    /* 税票改造 201709 lvcn start*/
    /**
     * 开票流程状态[1000335] - 已作废
     */
    public static final Short PROCESS_STATUS_DISCARD = 3;
    /* 税票改造 201709 lvcn end*/

    /**
     * 回租类别[1000202]<br>
     * 普通回租
     */
    public static final Short LEASEBACK_TYPE_COMMON = 0;
    /**
     * 回租类别[1000202]<br>
     * 建设期回租
     */
    public static final Short LEASEBACK_TYPE_BUILD = 1;

    /**
     * 开票内容(增值税)[1000337] - 本金
     */
    public static final Short BILLING_CONTENT_CORPUS = 0;
    /**
     * 开票内容(增值税)[1000337] - 利息
     */
    public static final Short BILLING_CONTENT_INTEREST = 5;
    /**
     * 开票内容(增值税)[1000337] - 租金
     */
    public static final Short BILLING_CONTENT_RENT = 6;
    /**
     * 开票内容(增值税)[1000337] - 佣金收入
     */
    public static final Short BILLING_CONTENT_RAKEOFF = 7;
    /**
     * 开票内容(增值税)[1000337] - 收银票—贴现息
     */
    public static final Short BILLING_CONTENT_DISCOUNT = 8;

    /**
     * 开票内容(增值税)[1000337] - 咨询费
     */
    public static final Short BILLING_CONTENT_CONSULT = 9;
    /**
     * 开票内容(增值税)[1000337] - 罚息
     */
    public static final Short BILLING_CONTENT_PENALTY = 10;
    /**
     * 开票内容(增值税)[1000337] - 提前还款手续费
     */
    public static final Short BILLING_CONTENT_PRESERVICE = 11;
    /**
     * 开票内容(增值税)[1000337] - 收租（在建期）
     */
    public static final Short BILLING_CONTENT_BUILDING = 12;

    /**
     * 开票内容(增值税)[1000337] - 追加收益  (新增)
     */
    public static final Short BILLING_CONTENT_CONTRACTADDITION = 13;

    /**
     * 开票内容(增值税)[1000337] - 首付款
     */
    public static final Short BILLING_CONTENT_FIRST = 1;
    /**
     * 开票内容(增值税)[1000337] - 名义货价
     */
    public static final Short BILLING_CONTENT_PRICE = 2;
    /**
     * 开票内容(增值税)[1000337] - 调息补差
     */
    public static final Short BILLING_CONTENT_RESERVE  = 3;
    /**
     * 开票内容(增值税)[1000337] - 手续费收入
     */
    public static final Short BILLING_CONTENT_SERVICE = 4;

    /**
     * 缴税状态[1000338] - 未缴税
     */
    public static final Short SCOTTARE_STATUS_NO = 0;
    /**
     * 缴税状态[1000338] - 部分缴税
     */
    public static final Short SCOTTARE_STATUS_PART = 1;
    /**
     * 缴税状态[1000338] - 已缴税
     */
    public static final Short SCOTTARE_STATUS_END = 2;
    /**
     * 最大租赁期限
     * 一年
     */
    public static final Short MAX_YEAR1=0;
    /**
     * 最大租赁期限
     * 三年
     */
    public static final Short MAX_YEAR3=1;
    /**
     * 最大租赁期限
     * 五年
     */
    public static final Short MAX_YEAR5=2;
    /**
     * 产品品种
     * 直租
     */
    public static final Short PRODUCT_PLUMPLY=0;
    /**
     * 产品品种
     * 回租
     */
    public static final Short PRODUCT_CALLBACK=1;
    /**
     * 产品品种
     * 全品种
     */
    public static final Short PRODUCT_ALL=2;

    /**
     * 资产五级分类
     * 正常
     */
    public static final Short ASSETS_CLASSIFY_NORMAL = 0;
    /**
     * 资产五级分类
     * 关注
     */
    public static final Short ASSETS_CLASSIFY_ATTENT = 1;
    /**
     * 资产五级分类
     * 次级
     */
    public static final Short ASSETS_CLASSIFY_SECOND = 2;

    /**
     * 资产五级分类
     * 可疑
     */
    public static final Short ASSETS_CLASSIFY_DUBIOUS = 3;

    /**
     * 资产五级分类
     * 损失
     */
    public static final Short ASSETS_CLASSIFY_LOSS = 4;

    /**
     * 资产五级分类
     * 不详
     */
    public static final Short ASSETS_CLASSIFY_NO = 5;


    /**
     * 风险分类评定资产类别
     * 应收租赁款
     */
    public static final Short RISK_ASSETS_CLASSIFY_CORPUS = 0;
    /**
     * 风险分类评定资产类别
     * 应收利息
     */
    public static final Short RISK_ASSETS_CLASSIFY_INTEREST = 1;

    /**
     * 客户其他债务
     * 银行
     */
    public static final Short CUSTOMER_OTHERDEBT_BANK = 0;
    /**
     * 客户其他债务
     * 融资租赁
     */
    public static final Short CUSTOMER_OTHERDEBT_RENT = 1;
    /**
     * 客户其他债务
     * 财务公司
     */
    public static final Short CUSTOMER_OTHERDEBT_FINALCORP = 2;

    /**
     * 客户其他债务
     * 其他
     */
    public static final Short CUSTOMER_OTHERDEBT_OTHER = 3;

    /**
     * 经营情况
     * 正常
     */
    public static final Short OPERATION_NORMAL = 0;
    /**
     * 经营情况
     * 经营状况不佳
     */
    public static final Short OPERATION_BUSINESS_POOR = 1;
    /**
     * 经营情况
     * 勉强维持
     */
    public static final Short OPERATION_EKE_OUT = 2;

    /**
     * 经营情况
     * 出现经营危机
     */
    public static final Short OPERATION_BUSINESS_CRISIS = 3;

    /**
     * 经营情况
     * 已停(歇)业
     */
    public static final Short OPERATION_ENCLOSED = 4;

    /**
     * 经营情况
     * 交易客户失踪
     */
    public static final Short OPERATION_MISSING = 5;

    /**
     * 经营情况
     * 已被关闭或破产
     */
    public static final Short OPERATION_CLOSE = 6;

    /**
     * 财务状况预测期
     * 未来三个月内
     */
    public static final Short FINAL_STATUS_FORECAST_THREE_MONTH = 0;
    /**
     * 财务状况预测期
     * 到年底
     */
    public static final Short FINAL_STATUS_FORECAST_YEAR = 1;
    /**
     * 财务状况预测期
     * 到合同到期日
     */
    public static final Short FINAL_STATUS_FORECAST_END_DATE = 2;

    /**
     * 财务状况预测期
     * 其他
     */
    public static final Short FINAL_STATUS_FORECAST_OTHER = 3;

    /**
     * 企业发展趋势
     * 优
     */
    public static final Short CORP_DEVELOP_TREND_ACTOR = 0;
    /**
     * 企业发展趋势
     * 良好
     */
    public static final Short CORP_DEVELOP_TREND_WELL = 1;
    /**
     * 企业发展趋势
     * 较好
     */
    public static final Short CORP_DEVELOP_TREND_PREFERABLY = 2;

    /**
     * 企业发展趋势
     * 一般
     */
    public static final Short CORP_DEVELOP_TREND_COMMON = 3;

    /**
     * 企业发展趋势
     * 恶化
     */
    public static final Short CORP_DEVELOP_TREND_WORSEN = 4;

    /**
     * 利润变动趋势
     * 增加
     */
    public static final Short PROFIT_CHARGE_TREND_ADD = 0;
    /**
     * 利润变动趋势
     * 稳定
     */
    public static final Short PROFIT_CHARGE_TREND_STABLE = 1;
    /**
     * 利润变动趋势
     * 减少
     */
    public static final Short PROFIT_CHARGE_TREND_REDUCE = 2;

    /**
     * 利润变动趋势
     * 恶化
     */
    public static final Short PROFIT_CHARGE_TREND_WORSEN = 3;

    /**
     * 现金流量变动趋势
     * 增加
     */
    public static final Short CASHFLOW_CHARGE_TREND_ADD = 0;
    /**
     * 现金流量变动趋势
     * 稳定
     */
    public static final Short CASHFLOW_CHARGE_TREND_STABLE = 1;
    /**
     * 现金流量变动趋势
     * 减少
     */
    public static final Short CASHFLOW_CHARGE_TREND_REDUCE = 2;

    /**
     * 现金流量变动趋势
     * 恶化
     */
    public static final Short CASHFLOW_CHARGE_TREND_WORSEN = 3;

    /**
     * 有无违法违规行为
     * 无重大违法违规行为
     */
    public static final Short IF_VIOLATIONS_BEHAVIOR_NO = 0;
    /**
     * 有无违法违规行为
     * 存在重大违法违规行为
     */
    public static final Short IF_VIOLATIONS_BEHAVIOR_YES = 1;

    /**
     * 有无违约行为
     * 无重大违约行为
     */
    public static final Short IF_BREACH_BEHAVIOR_NO = 0;
    /**
     * 有无违约行为
     * 存在重大违约行为
     */
    public static final Short IF_BREACH_BEHAVIOR_YES = 1;

    /**
     * 履约意愿
     * 良好
     */
    public static final Short IMPLEMENTATION_WILLINGNESS_WELL = 0;
    /**
     * 履约意愿
     * 一般
     */
    public static final Short IMPLEMENTATION_WILLINGNESS_COMMON = 1;
    /**
     * 履约意愿
     * 较差，不愿意与我公司合作
     */
    public static final Short IMPLEMENTATION_WILLINGNESS_WORSE = 2;

    /**
     * 履约意愿
     * 经过多次协商谈判，客户明显无还款意愿
     */
    public static final Short IMPLEMENTATION_WILLINGNESS_NO = 3;

    /**
     * 履约意愿
     * 有逃废债行为或迹象
     */
    public static final Short IMPLEMENTATION_WILLINGNESS_SKIP = 4;

    /**
     * 履约能力
     * 能足额偿还本息
     */
    public static final Short IMPLEMENTATION_ABILITY_FULL = 0;
    /**
     * 履约能力
     * 能部分偿还本息
     */
    public static final Short IMPLEMENTATION_ABILITY_PART = 1;
    /**
     * 履约能力
     * 基本无力偿还本息
     */
    public static final Short IMPLEMENTATION_ABILITY_NO = 2;

    /**
     * 履约记录
     * 良好
     */
    public static final Short IMPLEMENTATION_RECORD_WELL = 0;
    /**
     * 履约记录
     * 一般
     */
    public static final Short IMPLEMENTATION_RECORD_COMMON = 1;
    /**
     * 履约记录
     * 较差
     */
    public static final Short IMPLEMENTATION_RECORD_WORSE = 2;
    /**
     * 履约记录
     * 恶劣
     */
    public static final Short IMPLEMENTATION_RECORD_EVIL = 3;

    /**
     * 是否已经在其他金融机构出现违约
     * 是
     */
    public static final Short IF_HAS_BREACH_YES = 0;
    /**
     * 是否已经在其他金融机构出现违约
     * 否
     */
    public static final Short IF_HAS_BREACH_NO = 1;
    /**
     * 是否已经在其他金融机构出现违约
     * 不详
     */
    public static final Short IF_HAS_BREACH_UNKNOWN = 2;

    /**
     * 外部宏观经济环境
     * 有利变化
     */
    public static final Short OUTSIDE_MACRO_YES = 0;
    /**
     * 外部宏观经济环境
     * 没有变化
     */
    public static final Short OUTSIDE_MACRO_NO = 1;
    /**
     * 外部宏观经济环境
     * 不利变化
     */
    public static final Short OUTSIDE_MACRO_HARMFUL = 2;

    /**
     * 管理层变动
     * 没有变动
     */
    public static final Short MANAGEMENT_CHARGE_NO = 0;
    /**
     * 管理层变动
     * 无影响
     */
    public static final Short MANAGEMENT_CHARGE_NO_EFFECT = 1;
    /**
     * 管理层变动
     * 有正面影响
     */
    public static final Short MANAGEMENT_CHARGE_HAS_EFFECT_FRONT = 2;

    /**
     * 管理层变动
     * 有一定负面影响，但无法判断影响程度
     */
    public static final Short MANAGEMENT_CHARGE_NEG_EFFECT_UN = 3;
    /**
     * 管理层变动
     * 将产生较大负面影响
     */
    public static final Short MANAGEMENT_CHARGE_HAS_NEG_EFFECT = 4;

    /**
     * 主要股东、关联关系或母子公司变动
     * 没有变动
     */
    public static final Short ASSOCIATION_CHARGE_NO = 0;
    /**
     * 主要股东、关联关系或母子公司变动
     * 无影响
     */
    public static final Short ASSOCIATION_CHARGE_NO_EFFECT = 1;
    /**
     * 主要股东、关联关系或母子公司变动
     * 有正面影响
     */
    public static final Short ASSOCIATION_CHARGE_HAS_EFFECT_FRONT = 2;

    /**
     * 主要股东、关联关系或母子公司变动
     * 有一定负面影响，但无法判断影响程度
     */
    public static final Short ASSOCIATION_CHARGE_NEG_EFFECT_UN = 3;
    /**
     * 主要股东、关联关系或母子公司变动
     * 将产生较大负面影响
     */
    public static final Short ASSOCIATION_CHARGE_HAS_NEG_EFFECT = 4;

    /**
     * 风险内控
     * 良好
     */
    public static final Short RISK_INTROCONTROL_WELL = 0;
    /**
     * 风险内控
     * 一般
     */
    public static final Short RISK_INTROCONTROL_COMMON = 1;
    /**
     * 风险内控
     * 存在严重问题，可能影响款项偿还
     */
    public static final Short RISK_INTROCONTROL_MAYBE = 2;

    /**
     * 风险内控
     * 管理混乱，阻碍款项偿还
     */
    public static final Short RISK_INTROCONTROL_HINDER = 3;

    /**
     * 重大涉诉、事故或赔偿
     * 无影响
     */
    public static final Short ACCIDENT_NO_EFFECT = 0;
    /**
     * 重大涉诉、事故或赔偿
     * 有正面影响
     */
    public static final Short ACCIDENT_HAS_EFFECT_FRONT = 1;
    /**
     * 重大涉诉、事故或赔偿
     * 有一定负面影响，但无法判断影响程度
     */
    public static final Short ACCIDENT_NEG_EFFECT_UN = 2;

    /**
     * 重大涉诉、事故或赔偿
     * 将产生较大负面影响
     */
    public static final Short ACCIDENT_HAS_NEG_EFFECT = 3;

    /**
     * 重大自然灾害
     * 无影响
     */
    public static final Short NATURAL_HAZARD_NO_EFFECT = 0;
    /**
     * 重大自然灾害
     * 有一定负面影响，但无法判断影响程度
     */
    public static final Short NATURAL_HAZARD_NEG_EFFECT_UN = 1;
    /**
     * 重大自然灾害
     * 将产生较大负面影响
     */
    public static final Short NATURAL_HAZARD_HAS_NEG_EFFECT = 2;


    /**
     * 资产风险评定类别： 定期
     */
    public static final Short EVALUATE_CLASSIFY_FIXED = 0;

    /**
     * 资产风险评定类别： 不定期
     */
    public static final Short EVALUATE_CLASSIFY_NOFIXED = 1;

    /**
     * 罚息类型(罚息规则设置)
     * 罚息
     */
    public static final Short PENALTY_TYPE_PENALTY = 0;

    /**
     * 罚息类型(罚息规则设置)
     * 违约金
     */
    public static final Short PENALTY_TYPE_LIQUIDATE = 1;

    /**
     * 变更管理 - 执行状态
     * 未执行
     */
    public static final Short REPAYMENT_PLANT_EXE_NO = 0;

    /**
     * 变更管理 - 执行状态
     * 执行中
     */
    public static final Short REPAYMENT_PLANT_EXE_ING = 1;

    /**
     * 变更管理 - 执行状态
     * 已执行
     */
    public static final Short REPAYMENT_PLANT_EXE_ED = 2;


    /**
     * 核销单据: 付款核销(支付本金,支付利息,支付手续费,保险费等)
     */
    public static final Short Capital_Gather_Type_PayMoney = 0 ;

    /**
     * 核销单据: 提款核销(提取贷款)
     */
    public static final Short Capital_Gather_Type_ReceiveLoan = 1 ;

    /**
     * 核销记账状态[1001003] - 未核销
     */
    public static final Short UNAPPLIED = 0;
    /**
     * 核销记账状态[1001003] - 核销中
     */
    public static final Short VERIFICATION = 1;
    /**
     * 核销记账状态[1001003] - 已核销
     */
    public static final Short WRITTEN = 2;
    /**
     * 类型(保险)
     * 保险
     */
    public static final Short INSURE_CLASS_INSURE = 0;
    /**
     * 类型(保险)
     * 公正
     */
    public static final Short INSURE_CLASS_PUB = 1;
    /**
     * 结清状态[1001522] -未结清
     */
    public static final Short UNCLEARED = 0;
    /**
     * 结清状态[1001522] -结清中
     */
    public static final Short SETTLEMENT = 1;
    /**
     * 结清状态[1001522] -已结清
     */
    public static final Short CLEARED = 2;
    /**
     * 划拨类型[1001005] -购汇
     */
    public static final Short GOUHUI = 0;
    /**
     * 划拨类型[1001005] -结汇
     */
    public static final Short JIEHUI = 1;
    /**
     * 划拨类型[1001005] -正常划拨
     */
    public static final Short ZCHB = 2;

    /**
     * 变现能力[1000363]<br>
     * 高
     */
    public static final Short REALIZATION_CAPACITY_H = 0;
    /**
     * 变现能力[1000363]<br>
     * 中
     */
    public static final Short REALIZATION_CAPACITY_M = 1;
    /**
     * 变现能力[1000363]<br>
     * 低
     */
    public static final Short REALIZATION_CAPACITY_L = 2;

    /**
     * 承租人性质[1001006]<br>
     * 主承租人
     */
    public static final Short LESSEE_TYPE_MAIN = 0;
    /**
     * 承租人性质[1001006]<br>
     * 共同承租人
     */
    public static final Short LESSEE_TYPE_BOTH = 1;
    /**
     * 承租人性质[1001006]<br>
     * 子承租人
     */
    public static final Short LESSEE_TYPE_CHILD = 2;
    /**
     * 承租人性质[1001006]<br>
     * 小承租人
     */
    public static final Short LESSEE_TYPE_SMALL = 3;

    /**
     * 承租人账户类别[1001007]<br>
     * 主账户
     */
    public static final Short ACC_CATEGORY_MAIN = 0;
    /**
     * 承租人账户类别[1001007]<br>
     * 辅账户
     */
    public static final Short ACC_CATEGORY_ASSIST = 1;
    /**
     * 承租人账户类别[1001007]<br>
     * 代付账户
     */
    public static final Short ACC_CATEGORY_AGENT = 2;
    /**
     * 折旧属性
     * 入账和减少当期提
     */
    public static final Short DEPRECIATION_ATTRIBUTE_ZERO = 0;
    /**
     * 折旧属性
     * 入账当期计提折旧、减少当期不提折旧
     */
    public static final Short DEPRECIATION_ATTRIBUTE_ONE = 1;

    /**
     * 计提属性
     * 不计提
     */
    public static final Short ACCRUAL_ATTRIBUTE_NOT_ACCRUAL = 0;
    /**
     * 计提属性
     * 正常计提
     */
    public static final Short ACCRUAL_ATTRIBUTE_NORMAL_ACCRUAL = 1;
    /**
     * 计提属性
     * 总量计提
     */
    public static final Short ACCRUAL_ATTRIBUTE_TOTAL_ACCRUAL = 2;

    /**
     * 导入类型：子承租人
     */
    public static final Short INPUT_TYPE_LESSEE = 0;

    /**
     * 导入类型：供应商
     */
    public static final Short INPUT_TYPE_PROVIDER = 1;

    /**
     * 导入类型：国家银监会平台
     */
    public static final Short INPUT_TYPE_COUNTRY = 2;

    /**
     * 导入类型：供应商江苏银监会平台
     */
    public static final Short INPUT_TYPE_JFS = 3;

    /**
     * 导入类型：文件模板管理
     */
    public static final Short INPUT_TYPE_MANAGER = 4;

    /**
     * 条件分类
     * 直租
     */
    public static final Short COND_CLASS_PLUMPLY = 0;
    /**
     * 条件分类
     * 回租
     */
    public static final Short COND_CLASS_CALLBACK = 1;
    /**
     * 条件分类
     * 回租-普通回租
     */
    public static final Short COND_CLASS_CALLBACK_PT = 2;
    /**
     * 条件分类
     * 回租-共同承租人（标准）
     */
    public static final Short COND_CLASS_CALLBACK_GT = 3;
    /**
     * 无
     * 回租-建设期回租
     */
    public static final Short COND_CLASS_NOT = 4;
    /**
     * 条件分类
     * 回租-建设期回租
     */
    public static final Short COND_CLASS_CALLBACK_ZJ = 5;

    /**
     * 条件分类
     * 直租或回租
     */
    public static final Short COND_CLASS_MIXTURE = 6;

    /**
     * 风险金变更方法[1001015]<br>
     * 自动退回
     */
    public static final Short DEPOSIT_ALTER_BACK = 0;
    /**
     * 风险金变更方法[1001015]<br>
     * 自动冲抵
     */
    public static final Short DEPOSIT_ALTER_CHARGE = 1;
    /**
     * 风险金变更方法[1001015]<br>
     * 手工
     */
    public static final Short DEPOSIT_ALTER_HAND = 2;
    /**
     * 租金期限变化[1001016]<br>
     * 展期
     */
    public static final Short ALTER_TIME_LONG = 0;
    /**
     * 租金期限变化[1001016]<br>
     * 缩期
     */
    public static final Short ALTER_TIME_SHORT = 1;
    /**
     * 租金期限变化[1001016]<br>
     * 不变
     */
    public static final Short ALTER_TIME_INVARIANT = 2;
    /**
     * 处置难易度
     * 可处置
     */
    public static final Short MANAGEMENT_DIFFICULTY_SURE = 0;

    /**
     * 处置难易度
     * 难处置
     */
    public static final Short MANAGEMENT_DIFFICULTY_HARD = 1;

    /**
     * 处置难易度
     * 不可处置
     */
    public static final Short MANAGEMENT_DIFFICULTY_CAN_NOT = 2;

    /**
     * 租金变更方式[1001018]<br>
     * 规则
     */
    public static final Short RENT_ALTER_REGULAR = 0;

    /**
     * 租金变更方式[1001018]<br>
     * 不规则
     */
    public static final Short RENT_ALTER_IRREGULAR = 1;

    /**
     * 租金变更方式[1001018]<br>
     * 不变
     */
    public static final Short RENT_ALTER_NOTHING = 2;

    /**
     * 与投放日一致
     *
     */
    public static final Short LOAN_DAY = 1;

    /**
     * 与收租日一致
     *
     */
    public static final Short RENT_DAY = 0;

    /**
     * 提前还款类型（计划内）
     */
    public static final Short AHEAD_PAYMENT_IN_PLANT = 0;

    /**
     * 提前还款类型（计划外）
     */
    public static final Short AHEAD_PAYMENT_OUT_PLANT = 1;

    /**
     * 部分核销记录处理方式[1001511]<br>
     * 保留原计划
     */
    public static final Short PART_VERIF_TYPE_KEEP = 0;

    /**
     * 部分核销记录处理方式[1001511]<br>
     * 变更原计划
     */
    public static final Short PART_VERIF_TYPE_BECOME = 1;

    /**
     * 值类型,这些值存入参数表中,取负值为特殊处理[1001508]<br>
     * 无
     */
    public static final Short VALUE_TYPE_NULL = -99;
    /**
     * 值类型,这些值存入参数表中,取负值为特殊处理[1001508]<br>
     * 文本值
     */
    public static final Short VALUE_TYPE_TEXT = -98;
    /**
     * 值类型,这些值存入参数表中,取负值为特殊处理[1001508]<br>
     * 枚举值
     */
    public static final Short VALUE_TYPE_ENUM = -97;


    /**
     * 回访方式
     * 电话回访
     */
    public static final Short REVIEW_TYPE_TEL_REVIEW = 0;
    /**
     * 回访方式
     * 实地回访
     */
    public static final Short REVIEW_TYPE_FIELD_REVIEW = 1;
    /**
     * 回访方式
     * 联合回访
     */
    public static final Short REVIEW_TYPE_UNION_REVIEW = 2;

    /**
     * 关系状态 正常
     */
    public static final Short RELATION_STATUS_NORMAL = 0;

    /**
     * 关系状态 重复
     */
    public static final Short RELATION_STATUS_REPEAT = 1;

    /**
     * 联系人类型 法定代表人
     */
    public static final Short CONTACT_TYPE_LEGAL_REPRESENTATIVE = 0;

    /**
     * 联系人类型 实际控制人
     */
    public static final Short CONTACT_TYPE_ACTUAL_CONTROL = 1;

    /**
     * 联系人类型 其他
     */
    public static final Short CONTACT_TYPE_OTHER = 2;

    /**
     * 条件设置 控制类型[1001513]<br>
     * 系统控制
     */
    public static final Short CONDITION_CONTROL_TYPE_CONTROL = 0;

    /**
     * 条件设置 控制类型[1001513]<br>
     * 系统提示
     */
    public static final Short CONDITION_CONTROL_TYPE_SHOW = 1;

    /**
     * 挂账原因是否必输：是
     */
    public static final Short HANDACCOUNT_REASON_YES = 0;

    /**
     * 挂账原因是否必输：否
     */
    public static final Short HANDACCOUNT_REASON_NO = 1;

    /**
     * 折旧方法 平均年限法
     */
    public static final Short DEPRECIATION_METHOD_AVERAGE = 0;

    /**
     * 折旧方法 工作量法
     */
    public static final Short DEPRECIATION_METHOD_WORKLOAD = 1;

    /**
     * 合作协议类型[1001507]<br>
     * 租赁合作协议
     */
    public static final Short PROTOCOL_TYPE_LEASE = 0;
    /**
     * 合作协议类型[1001507]<br>
     * 采购协议
     */
    public static final Short PROTOCOL_TYPE_PURCHASE = 1;
    /**
     * 合作协议类型[1001507]<br>
     * 租赁主协议
     */
    public static final Short PROTOCOL_TYPE_MAIN = 2;
    /**
     * 合作协议类型[1001507]<br>
     * 其它协议
     */
    public static final Short PROTOCOL_TYPE_OTHER = 3;
    /**
     * 合作协议类型[1001507]<br>
     * 中介协议
     */
    public static final Short PROTOCOL_TYPE_AGENCY = 4;

    /**
     * 厂商保证金退回方式[1001516]<br>
     * 代垫逾期租金
     */
    public static final Short VD_RETURN_TYPE_ADVANCE = 1;
    /**
     * 厂商保证金退回方式[1001516]<br>
     * 期末退回
     */
    public static final Short VD_RETURN_TYPE_TERM_END = 0;

    /**
     * 承租人保证金退回方式[1001517]<br>
     * 冲抵两期租金
     */
    public static final Short LD_RETURN_TYPE_CHARGE_AGAINST_2 = 2;
    /**
     * 承租人保证金退回方式[1001517]<br>
     * 冲抵逾期租金
     */
    public static final Short LD_RETURN_TYPE_CHARGE_AGAINST_OVER = 3;
    /**
     * 承租人保证金退回方式[1001517]<br>
     * 冲抵租金
     */
    public static final Short LD_RETURN_TYPE_CHARGE_AGAINST = 1;
    /**
     * 承租人保证金退回方式[1001517]<br>
     * 期末退回
     */
    public static final Short LD_RETURN_TYPE_TERM_END = 0;

    /**
     * 供应商分类[1001520]<br>
     * 自营
     */
    public static final Short SUPPLIER_TYPE_DIRECT = 0;
    /**
     * 供应商分类[1001520]<br>
     * 代理
     */
    public static final Short SUPPLIER_TYPE_AGENT = 1;

    /**
     * 起租变更规则[1001519]
     * 折让
     */
    public static final Short BEGIN_ALTER_RULE_DISCOUNT = 0;

    /**
     * 起租变更规则[1001519]
     * 顺延
     */
    public static final Short BEGIN_ALTER_RULE_POSTPONE = 1;

    /**
     * 起租变更规则[1001519]
     * 不变
     */
    public static final Short BEGIN_ALTER_RULE_NOTHING = 2;

    /**
     * 政策意见[1001521]<br>
     * 积极介入
     */
    public static final Short POLICY_RESULT_ACTIVE = 0;
    /**
     * 政策意见[1001521]<br>
     * 适度介入
     */
    public static final Short POLICY_RESULT_MODERATION = 1;
    /**
     * 政策意见[1001521]<br>
     * 谨慎介入
     */
    public static final Short POLICY_RESULT_CAREFUL = 2;

    /**
     * 合同变更渠道[1001523]<br>
     * 协议变更
     */
    public static final Short CONTRACT_ALTER_CANAL_PROTOCOL = 0;

    /**
     * 合同变更渠道[1001523]<br>
     * 外贸结汇
     */
    public static final Short CONTRACT_ALTER_CANAL_EXCHANGE = 1;

    /**
     * 合同变更渠道[1001523]<br>
     * 调解变更
     */
    public static final Short CONTRACT_ALTER_CANAL_MEDIATE = 2;

    /**
     * 合同变更渠道[1001523]<br>
     * 诉讼变更
     */
    public static final Short CONTRACT_ALTER_CANAL_LAWSUIT = 3;

    /**
     * 合同变更类型[1001524]<br>
     * 租金变更
     */
    public static final Short CONTRACT_ALTER_TYPE_RENT = 0;

    /**
     * 合同变更类型[1001524]<br>
     * 非报价因素变更
     */
    public static final Short CONTRACT_ALTER_TYPE_NO_CAL = 1;


    /**
     * 让利方式[1001525]<br>
     * 不调整
     */
    public static final Short BENEFIT_NOT = 0;
    /**
     * 让利方式[1001525]<br>
     * 租金折让
     */
    public static final Short BENEFIT_RENT = 1;
    /**
     * 让利方式[1001525]<br>
     * 顺延
     */
    public static final Short BENEFIT_POSTPONE = 2;

    /**
     * 信用担保
     * 股东
     */
    public static final Short CREDIT_SHAREHOLDER=0;
    /**
     * 信用担保
     * 其他
     */
    public static final Short CREDIT_OTHER=1;
    /**
     * 租赁物保险购置人
     * 承租人
     */
    public static final Short INSURE_LESSEE=0;
    /**
     * 租赁物保险购置人
     * 出租人
     */
    public static final Short INSURE_LEASER=1;

    /**
     * 交易框架[1000318]
     * 非卖断式
     */
    public static final Short TABLE_LEASES=0;

    /**
     * 交易框架[1000318]
     * 卖断式
     */
    public static final Short SHEET_LEASES=1;

    /**
     * 收款核销
     */
    public static final Short GATHER_TYPE_ACCOUNT=0;

    /**
     * 资金回收
     */
    public static final Short GATHER_TYPE_PLAN=1;

    /**
     * 调息对象
     */

    public static final Short ADJUST_OBJECT_RATE=0;

    /**
     * irr倒算对象[1001528]<br>
     * 计划irr
     */
    public static final Short IRR_CONVERT_TYPE_PLAN = 0;

    /**
     * irr倒算对象[1001528]<br>
     * 实际irr
     */
    public static final Short IRR_CONVERT_TYPE_REAL = 1;

    /**
     * 客户来源[1001530]<br>
     * 自营
     */
    public static final Short CUST_SOURCE_SELF_SUPPORT =0 ;
    /**
     * 客户来源[1001530]<br>
     * 渠道一
     */
    public static final Short CUST_SOURCE_TRENCH1 =1 ;
    /**
     * 客户来源[1001530]<br>
     * 渠道二
     */
    public static final Short CUST_SOURCE_TRENCH2 = 2;


    /**
     * 提醒状态[1001531]<br>
     * 未提醒
     */
    public static final Short ALERT_STATUS_NOT = 0;
    /**
     * 提醒状态[1001531]<br>
     * 已提醒
     */
    public static final Short ALERT_STATUS_YET =1 ;



    /**
     * 反馈阶段[1001532]<br>
     * 安排问题
     */
    public static final Short FEEDBACK_PHASE_PLAN = 0;
    /**
     * 反馈阶段[1001532]<br>
     * 实地评估问题
     */
    public static final Short FEEDBACK_PHASE_INDEED = 1;

    /**
     * 问题分类[1001533]<br>
     * 接待问题
     */
    public static final Short QUESTION_CLASS_RECEPTION = 0;
    /**
     * 问题分类[1001533]<br>
     * 财报问题
     */
    public static final Short QUESTION_CLASS_FINANCE = 1;
    /**
     * 问题分类[1001533]<br>
     * 其他
     */
    public static final Short QUESTION_CLASS_OTHER = 2;

    /**
     * 文档载体[1001534]<br>
     * 电子版
     */
    public static final Short CARRIER_TYPE_ELE = 0;
    /**
     * 文档载体[1001534]<br>
     * 实物
     */
    public static final Short CARRIER_TYPE_THING = 1;

    /**
     * 文档类型[1001535]<br>
     * 模板
     */
    public static final Short DOC_TYPE_TPL = 0;
    /**
     * 文档类型[1001535]<br>
     * 原件
     */
    public static final Short DOC_TYPE_ORIGINAL = 1;
    /**
     * 文档类型[1001535]<br>
     * 扫描件
     */
    public static final Short DOC_TYPE_SCANNING = 2;
    /**
     * 会议状态<br>
     * 初始
     */
    public static final Short MEETING_BEGIN = 0;

    /**
     * 会议状态<br>
     * 进行中
     */
    public static final Short MEETING_RUNNING = 1;

    /**
     * 会议状态<br>
     * 结束
     */
    public static final Short MEETING_OVER = 2;

    /**
     * 投票状态<br>
     * 已投票
     */
    public static final Short VOTE_DONE = 0;

    /**
     * 投票状态<br>
     * 未投票
     */
    public static final Short VOTE_UNDONE = 1;

    /**
     * 授信评审状态<br>
     * 未评审
     */
    public static final Short REVIEW_NO = 0;

    /**
     * 授信评审状态<br>
     * 评审通过
     */
    public static final Short REVIEW_PASS = 1;

    /**
     * 授信评审状态<br>
     * 评审未通过
     */
    public static final Short REVIEW_UNPASS = 2;

    /**
     * 投票结果<br>
     * 同意
     */
    public static final Short VOTE_OK = 0;

    /**
     * 投票结果<br>
     * 不同意
     */
    public static final Short VOTE_NO = 1;

    /**
     * 主持人确认状态
     * 已确认
     */
    public static final Short COMPERE_STATUS_AFFIRM=0;
    /**
     * 主持人确认状态
     * 未确认
     */
    public static final Short COMPERE_STATUS_AFFIRM_NO=1;
    /**
     * 发票类型[1001539]<br>
     * 融资利息发票
     */
    public static final Short RECEIPT_TYPE_INTEREST = 0;

    /**
     * 发票类型[1001539]<br>
     * 增值税专用发票
     */
    public static final Short RECEIPT_TYPE_ADDED_SPECIAL = 1;

    /**
     * 发票类型[1001539]<br>
     * 安装费发票
     */
    public static final Short RECEIPT_TYPE_INSTALL = 2;

    /**
     * 发票类型[1001539]<br>
     * 一般发票
     */
    public static final Short RECEIPT_TYPE_COMMON = 3;

    /**
     * 发票类型[1001539]<br>
     * 增值税普通发票
     */
    public static final Short RECEIPT_TYPE_ADDED_COMMON = 4;

    /**
     * 发票类型[1001539]<br>
     * 关税发票
     */
    public static final Short RECEIPT_TYPE_CUSTOMS = 5;

    /**
     * 发票类型[1001539]<br>
     * 收据
     */
    public static final Short RECEIPT_TYPE_ACQUITTANCE = 6;

    /**
     * 所属模块[1001540]<br>
     * 租赁业务模块
     */
    public static final Short MODULE_TYPE_LEASE = 0;

    /**
     * 所属模块[1001540]<br>
     * 综合业务模块
     */
    public static final Short MODULE_TYPE_COLLIGATE = 1;

    /**
     * 发票导入类型[1001542]<br>
     * 收票导入
     */
    public static final Short INVOICE_IMPTYPE_REC = 0;
    /**
     * 发票导入类型[1001542]<br>
     * 开票导入
     */
    public static final Short INVOICE_IMPTYPE_OPEN = 1;

    /**
     * 红蓝发票[1001543]<br>
     * 红票
     */
    public static final Short INVOICE_TYPE_R = 0;
    /**
     * 红蓝发票[1001543]<br>
     * 蓝票
     */
    public static final Short INVOICE_TYPE_G = 1;

    /**
     * 分摊方式<br>
     * 金额
     */
    public static final Short LINK_TYPE_AMOUNT = 0;

    /**
     * 自动核销时，根据校验规则
     * 0 :只用账户名
     * 1 :账户 + 账号
     */
    public static final Short VERIFI_RULE_CODE = 0;
    public static final Short VERIFI_RULE_CODE_AND_NAME = 1;

    /**
     * 调息利息处理方式
     * 调整在当期:0
     */
    public static final Short ADJUST_INTEREST_NOW=0;
    /**
     * 调息利息处理方式
     * 调整在下期:1
     */
    public static final Short ADJUST_INTEREST_NEXT=1;

    /**
     * 起租类型[1001546]<br>
     * 起租
     */
    public static final Short BEGIN_TYPE_STATUS = 0;
    /**
     * 起租类型[1001546]<br>
     * 起租变更
     */
    public static final Short BEGIN_TYPE_ALTER = 1;
    /**
     * 指标范围[1001545]<br>
     * 交易指标
     */
    public static final Short OWEN_SCOPE_TRADE = 0;
    /**
     * 指标范围[1001545]<br>
     * 全局指标
     */
    public static final Short OWEN_SCOPE_GLOBAL = 1;

    /**
     * 执行状态（票）[1001547]<br>
     * 未执行
     */
    public static final Short TICKET_STATUS_NO = 0;

    /**
     * 执行状态（票）[1001547]<br>
     * 部分执行
     */
    public static final Short TICKET_STATUS_PART = 1;

    /**
     * 执行状态（票）[1001547]<br>
     * 已执行
     */
    public static final Short TICKET_STATUS_ALL = 2;

    /**
     * 交易框架[1000318]
     * 不限
     */
    public static final Short OTHER_LEASES=0;





    /**
     * 邮件账户类型[1001548]<br>
     * 公用
     */
    public static final Short MA_TYPE_PUB = 0;
    /**
     * 邮件账户类型[1001548]<br>
     * 个人
     */
    public static final Short MA_TYPE_PRV = 1;

    /**
     * 邮件类型[1001549]<br>
     * 文本邮件
     */
    public static final Short MAIL_TYPE_TEXT = 0;
    /**
     * 邮件类型[1001549]<br>
     * HTML邮件
     */
    public static final Short MAIL_TYPE_HTML = 1;

    /**
     * 凭证操作类别：凭证制单
     */
    public static final Short VOUCHER_OPER_TYPE_OPERATOR = 0;

    /**
     * 凭证操作类别：凭证审核
     */
    public static final Short VOUCHER_OPER_TYPE_CHECKER = 1;

    /**
     * 费用类别：银行服务费
     */
    public static final Short EXPENSE_BANK_SERV_FEE = 0;

    /**
     * 费用类别：保证金
     */
    public static final Short EXPENSE_CASH_DEPOSIT = 1;

    /**
     * 厂商项目代偿条件[1001557]<br>
     * 逾期
     */
    public static final Short COMPENSATION_COND_OVERDUE = 0;

    /**
     * 结汇调整类型[1001558]<br>
     * 上调
     */
    public static final Short ADJUST_SETTLE_TYPE_UP = 0;

    /**
     * 结汇调整类型[1001558]<br>
     * 下调
     */
    public static final Short ADJUST_SETTLE_TYPE_DOWN = 1;

    /**
     * 调整规则[1001559]<br>
     * 手工
     */
    public static final Short ADJUST_RULE_MANUAL = 0;

    /**
     * 调整规则[1001559]<br>
     * 自动
     */
    public static final Short ADJUST_RULE_AUTO = 1;

    /**
     * 授信种类:普通
     */
    public static final Short CREDIT_TYPE_NORMAL = 0;

    /**
     * 授信种类:银团
     */
    public static final Short CREDIT_TYPE_SYNDICATED = 1;

    /**
     * 红票类型：申请
     */
    public static final Short RED_TYPE_APPLY = 0;

    /**
     * 红票类型：通知书
     */
    public static final Short RED_TYPE_NOTICE = 1;

    /**
     * 支付频率(评审会议用)：月
     */
    public static final Short MEET_PERIOD_0 = 0;

    /**
     * 支付频率(评审会议用)：季
     */
    public static final Short MEET_PERIOD_2 = 2;

    /**
     * 支付频率(评审会议用)：半年
     */
    public static final Short MEET_PERIOD_4 = 4;

    /**
     * 支付频率(评审会议用)：年
     */
    public static final Short MEET_PERIOD_5 = 5;

    /**
     * 支付频率(评审会议用)：全品种
     */
    public static final Short MEET_PERIOD_99 = 99;

    /**
     * @classification 调息时点
     * @description 下个年度第一天调整利率 NEXT_YEAR_FIRST_DAY 11
     */
    public static final Short ATF_NEXT_YEAR_FIRST_DAY = 11;

    /**
     * @classification 调息时点
     * @description 合同签订日对应整年度调整 NEXT_YEAR_CSD 12
     * @details CSD contract signed date
     */
    public static final Short ATF_NEXT_YEAR_CSD = 12;

    /**
     * @classification 调息时点
     * @description 调息后最近签订日 ADJUST_NEAREST_CSD 13
     * @details CSD contract signed date
     */
    public static final Short ATF_ADJUST_NEAREST_CSD = 13;

    /**
     * @classification 调息时点
     * @description 下次还本 NEXT_TIME_REPAYMENT_CORPUS 14
     */
    public static final Short ATF_NEXT_TIME_REPAYMENT_CORPUS = 14;

    /**
     * @classification 调息时点
     * @description 按季末的合同签订日 END_OF_SEASON_CSD 15
     * @details CSD contract signed date
     */
    public static final Short ATF_END_OF_SEASON_CSD = 15;



    /**
     * @classification 调息时点
     * @description 不调息 NOT_ADJUST 16
     */
    public static final Short ATF_NOT_ADJUST = 16;

    /**
     * @classification 调息时点
     * @description 从融资日起每6个月调整一次 FINANCE_DAY_PER_SIX_MONTHS 17
     */
    public static final Short ATF_FINANCE_DAY_PER_SIX_MONTHS = 17;

    /**
     * @classification 调息时点
     * @description 按季初的合同签订日 SEASON_BEGIN_CSD 18
     * @details CSD contract signed date
     */
    public static final Short ATF_SEASON_BEGIN_CSD = 18;

    /**
     * @classification 调息时点
     * @description 按季初的第一天 SEASON_FIRST_DAY 19
     */
    public static final Short ATF_SEASON_FIRST_DAY = 19;


    /**
     * 打印状态：未打印
     */
    public static final Short PRINT_STATUS_0 = 0;

    /**
     * 打印状态：已打印
     */
    public static final Short PRINT_STATUS_1 = 1;

    /**
     * 资产风险分类执行状态－未完成
     */
    public static final Short UNFINISHED = 0;

    /**
     * 资产风险分类执行状态－完成
     */
    public static final Short COMPLETED = 1;

    /**
     * SWAP利率掉期利率档次[1001564]<br>
     * 1年
     */
    public static final Short SWAP_1_YEAR = 1;
    /**
     * SWAP利率掉期利率档次[1001564]<br>
     * 2年
     */
    public static final Short SWAP_2_YEAR = 2;
    /**
     * SWAP利率掉期利率档次[1001564]<br>
     * 3年
     */
    public static final Short SWAP_3_YEAR = 3;
    /**
     * SWAP利率掉期利率档次[1001564]<br>
     * 5年
     */
    public static final Short SWAP_5_YEAR = 5;
    /**
     * SWAP利率掉期利率档次[1001564]<br>
     * 7年
     */
    public static final Short SWAP_7_YEAR = 7;
    /**
     * SWAP利率掉期利率档次[1001564]<br>
     * 10年
     */
    public static final Short SWAP_10_YEAR = 10;
    /**
     * SWAP利率掉期利率档次[1001564]<br>
     * 30年
     */
    public static final Short SWAP_30_YEAR = 30;

    /**
     * 月末处理明细类型<br>
     * 厂商保证金冲抵
     */
    public static final Short HAND_DETAIL_VENDER = 0;





    /**
     *催收提醒标记-未处理
     */
    public static final Short COLLECTION_REMIND_FLAG_NO_TREATMENT =0;

    /**
     *催收提醒标记-已处理
     */
    public static final Short COLLECTION_REMIND_FLAG_TREATMENT =1;

    /**
     * 非报价因素[1001584]<br>
     * 不变
     */
    public static final Short NON_PRICE_FACTORS_UNCHANGED = 0;
    /**
     * 非报价因素[1001584]<br>
     * 担保变更
     */
    public static final Short NON_PRICE_FACTORS_GUARANTEE = 1;
    /**
     * 非报价因素[1001584]<br>
     * 抵质押变更
     */
    public static final Short NON_PRICE_FACTORS_COLLATERAL = 2;
    /**
     * 非报价因素[1001584]<br>
     * 供应商变更
     */
    public static final Short NON_PRICE_FACTORS_SUPPLIER = 3;
    /**
     * 非报价因素[1001584]<br>
     * 租赁物变更
     */
    public static final Short NON_PRICE_FACTORS_LEASE = 4;
    /**
     * 报价因素[1001585]<br>
     * 不变
     */
    public static final Short PRICE_FACTORS_UNCHANGED = 0;
    /**
     * 报价因素[1001585]<br>
     * 租金计划变更
     */
    public static final Short PRICE_FACTORS_RENT = 1;
    /**
     * 报价因素[1001585]<br>
     * 其他收款变更
     */
    public static final Short PRICE_FACTORS_OTHER = 2;
    /**
     * 报价因素[1001585]<br>
     * 租后日期变更
     */
    public static final Short PRICE_FACTORS_DATE = 3;


    /**
     *租后巡检巡视频率：月
     */
    public static final Short ROUTING_FREQUENCY_MONTH = 0;

    /**
     *租后巡检巡视频率：双月
     */
    public static final Short ROUTING_FREQUENCY_BIMONTHLY = 1;

    /**
     *租后巡检巡视频率：季
     */
    public static final Short ROUTING_FREQUENCY_QUARTER = 2;

    /**
     *租后巡检巡视频率：半年
     */
    public static final Short ROUTING_FREQUENCY_HALFYEAR = 3;

    /**
     *租后巡检巡视频率：年
     */
    public static final Short ROUTING_FREQUENCY_YEAR = 4;

    /**
     *租后巡检巡视频率：指定日期
     */
    public static final Short ROUTING_FREQUENCY_DATE = 5;


    /**
     *租后巡检巡视方式：现场
     */
    public static final Short ROUTING_METHODS_SCENE = 0;

    /**
     *租后巡检巡视方式：非现场
     */
    public static final Short ROUTING_METHODS_NOSCENE = 1;

    /**
     *资金划拨-划入
     */
    public static final Short ALLOCATIONB_TRADETYPE_IN = 0;

    /**
     *资金划拨-划入
     */
    public static final Short ALLOCATIONB_TRADETYPE_OUT = 1;


    /**
     * 利息分类类型[1001560]<br>
     * 含半年
     */
    public static final Short INTERATE_TYPE_HAVEHALF = 0;

    /**
     * 利息分类类型[1001560]<br>
     * 不含半年
     */
    public static final Short INTERATE_TYPE_NO_HAVEHALF = 1;

    /**
     * 利息分类类型[1001560]<br>
     * 含半年_光大
     */
    public static final Short INTERATE_TYPE_HALF_GD = 2;

    /**
     * 利息分类类型[1001560]<br>
     * 不规则
     */
    public static final Short INTERATE_TYPE_NO_RULE = 3;

    /**
     * 利息分类类型[1001560]<br>
     * 含半年_光大
     */
    public static final Short INTERATE_TYPE_HALF_GD_CALBYBALANCE = 4;

    /**
     * 账户类型
     * 活期
     */
    public static final Short ACCOUNT_USE_0=0;
    /**
     * 账户类型
     * 协定
     */
    public static final Short ACCOUNT_USE_1=1;
    /**
     * 账户类型
     * 定期
     */
    public static final Short ACCOUNT_USE_2=2;
    /**
     * 账户类型
     * 通知
     */
    public static final Short ACCOUNT_USE_3=3;
    /**
     * 账户类型
     * 保证金户
     */
    public static final Short ACCOUNT_USE_4=4;
    /**
     * 账户类型
     * 监管户
     */
    public static final Short ACCOUNT_USE_5=5;
    /**
     * 账户类型
     * 基本户
     */
    public static final Short ACCOUNT_USE_6=6;
    /**
     * 账户类型
     * 一般户
     */
    public static final Short ACCOUNT_USE_7=7;
    /**
     * 账户类型
     * 专用户
     */
    public static final Short ACCOUNT_USE_8=8;
    /**
     * 账户类型
     * 财政专户
     */
    public static final Short ACCOUNT_USE_9=9;

    /**
     * 生成罚息收支计划的方法	000037
     * '收租'收支计划全额到账
     */
    public static final Short ALL_PAY_PENALTY=0;
    /**
     * 生成罚息收支计划的方法	000037
     * 走逾期处理流程
     */
    public static final Short FLOW_PENALTY=1;
    /**
     * 生成罚息收支计划的方法	000037
     * 逾期即生成
     */
    public static final Short OVERDUE_PENALTY=2;
    /**
     * 起租变更规则[1001519]
     * 投放计划调整
     */
    public static final Short BEGIN_ALTER_RULE_LOANPLAN = 3;
    /**
     * 计息金额计算方式：全额起息
     */
    public static final Short CALINTEREST_STLYE_ZERO = 0;
    /**
     * 计息金额计算方式：按已投放本金
     */
    public static final Short CALINTEREST_STLYE_ONE = 1;
    /**
     * 计息金额计算方式：无
     */
    public static final Short CALINTEREST_STLYE_TWO = 2;

    /**
     * xubo
     * 附件类别：来源附件
     */
    public static final Short SOURCE_ATTACH = 0;
    /**
     * 附件类别：暂存阶段附件
     */
    public static final Short STANTING_ATTACH = 1;
    /**
     * 附件类别：提交后阶段附件
     */
    public static final Short ONCHECK_ATTACH = 2;

    /**
     * 合同数据类型：手工添加
     */
    public static final Short MANUAL_ADD = 1;
    /**
     * 合同数据类型：批量抽取
     */
    public static final Short BATCH_GET = 2;

    /**
     * 指标数据状态:暂存
     */
    public static final Short TEMP = 1; //暂存
    /**
     * 指标数据状态:已发送
     */
    public static final Short SEND = 2; //已发送
    /**
     * 指标数据状态:已退回
     */
    public static final Short BACK = 3; //已退回
    /**
     * 指标数据状态:已接收
     */
    public static final Short RECEIVE = 4; //已接收

    /**
     * add by lihongjian 资产类型 - 动产 不动产
     */
    public static final Short MOVABLE_PROPERTY = 0;

    public static final Short REAL_ESTATE = 1;

    /**
     * 税率方案
     */
    public static final Short ORIGINAL_ADDED_VALUE_TAX = 1;

    public static final Short ORIGINAL_ORIBUSINESS_TAX = 0;

    public static final Short THE_NEW_TAX = 2;

    /** ADD WJJ 20160705 香港账套 税种 税率 */
    public static final Short ORIGINAL_NULL_TAX = 4;
    /** ADD END */

    //by lihongjian 营改增 @2016/05/11 ADD START
    /**
     * 收税模式 混合税种
     */
    public static final Short TAX_MODEL_MIXED_TAX_MODE = 2;

    /**
     * 收税模式：无 仅限香港公司
     */
    public static final Short TAX_MODEL_NULL_TAX = 3;
    //by lihongjian 营改增 @2016/05/11 ADD END
    //by wjj 电信营改增 @2016/06/16 ADD START
    /**
     * 税率百分比类型
     * 0:3%
     */
    public static final Short RENT_TAX_TATE_3 = 0;
    /**
     * 税率百分比类型
     * 1:6%
     */
    public static final Short RENT_TAX_TATE_6 = 1;
    /**
     * 税率百分比类型
     * 2:17%
     */
    public static final Short RENT_TAX_TATE_17 = 2;
    /**
     * 税率百分比类型
     * 3:0%
     */
    public static final Short RENT_TAX_TATE_0 = 3;
    /**
     * 税率百分比类型
     * 4:11%
     */
    public static final Short RENT_TAX_TATE_11 = 4;
    /**
     * 税率百分比类型
     * 5:16%
     */
    public static final Short RENT_TAX_TATE_16 = 5;
    /**
     * 税率百分比类型
     * 6:10%
     */
    public static final Short RENT_TAX_TATE_10 = 6;
    /**
     * 信息技术类型
     * 铁塔业务
     */
    public static final Short THE_TOWER = 1;
    //ADD END

    //[资金模块-报价算法] wangjj@2016/08/02 ADD START
    /**
     * 融资手续费计算基数
     * 剩余本金
     */
    public static final Short BALANCE_CORPUS = 1;
    /**
     * 融资手续费计算基数
     * 融资本金
     */
    public static final Short FINANCE_FEE_CORPUS = 0 ;
    /**
     * 融资手续费利率类型
     * 日利率
     */
    public static final Short DAY_INTERRATE = 0;
    /**
     * 融资手续费利率类型
     * 期利率
     */
    public static final Short PERIOD_INTERRATE = 1 ;
    //[资金模块-报价算法] wangjj@2016/08/02 ADD END

    /** ADD WJJ 20160726 撤销状态 */
    /**
     * 撤销状态
     * 初始
     */
    public static final Short BACKOUT_STATUS_NULL = null;
    /**
     * 撤销状态
     * 撤销中
     */
    public static final Short BACKOUT_STATUS_ING = 1;
    /**
     * 撤销状态
     * 撤销不通过
     */
    public static final Short BACKOUT_STATUS_NO = 2;
    /**
     * 撤销状态
     * 已撤销
     */
    public static final Short BACKOUT_STATUS_END = 3;
    /** ADD END */

    /**[会计IRR算法调整] @2016年10月27日 @wangjj start*/

    /**
     * 会计IRR算法启用年份[1001603]
     * 2015
     */
    public static final Short CAL_OLD = 0;

    /**
     * 会计IRR算法启用年份[1001603]
     * 2016
     */
    public static final Short CAL_NEW = 1;
    /**[会计IRR算法调整] @2016年10月27日 @wangjj end*/

    /**ADD WANGJJ 20160921 JICL-451 担保信息 新增‘保证担保’子表页签*/
    /**
     * 资产类型 枚举 保证担保
     */
    public static final Short ASSETS_TYPE_GUARANTEE = 8;
    /**ADD WANGJJ 20160921*/

    //by wangxy 指标采集 @2016/10/14 ADD START
    public static final Character TRUE = 'Y';

    public static final Character FALSE = 'N';
    //ADD END

    /** INSERT  【 wangjj】 【2016年11月16日】 【BUG修改】<BUG号 JICL-564号> 新增保证金退回方式枚举项：冲抵兼退回*/
    /**
     * 冲抵兼退回
     */
    public static final Short RENT_BACK_ALL = 4;
    /** INSERT  END */
    /**
     * 按提前还款上期收租日剩余本金
     */
    public static final Short REFUND_RENT_CORPUS = 0;
    /**
     * 按提前还款日剩余本金
     */
    public static final Short REFUND_CORPUS = 1;
    /**
     * 按剩余租赁本金
     */
    public static final Short LEASE_RENT_CORPUS = 2;


    /*
     * add by jiaoshy  用户合同数据维护
     * 合同信息、报价信息
     */
    public static final Short CONTRACT_INFO = 0;    //合同信息

    public static final Short INVOICE_INFO = 1;     //报价信息
    //ADD   END

    /** INSERT  【 wangjj】 【2017年7月10日】 【BUG修改】<BUG号ZTYW-753 号> 资金 - 调息时点 枚举*/

    /**
     * 调息时点 （资金提款）[1000308]<br>
     * 次年当日
     */
    public static final Short NEXT_YEAR_DAY = 12;

    /**
     * 调息时点 （资金提款）[1000308]<br>
     * 除当月首日,否则次月第一天
     */
    public static final Short MONTH_ONE_NEXT_MONTH = 13;
    /**
     * 调息时点 （资金提款）[1000308]<br>
     * 次年一月一号
     */
    public static final Short NEXT_YEAR_FIRST_DAY = 14;
    /** INSERT  END */


    /**ADD chenxc 2017/07/17 添加逾期记录类型，用于区分保理和租赁*/
    /**
     * 逾期记录类型  保理业务
     */
    public static final Short OVERDUE_TYPE_FACTORING = 1;

    /**
     * 逾期记录类型  租赁业务
     */
    public static final Short OVERDUE_TYPE_LEASE = 0;
    /**ADD chenxc 2017/07/17*/

    /** ADD 【WJJ】 【20170712】 BUG修改 <ZTYW-668> START */
    /**
     * 项目审批报表 审批类型：9 合同变更
     */
    public static final Short PROJECT_AUDIT_CONTRACT = 9;
    /**
     * 项目审批报表 审批类型：8 总承租人合作协议变更
     */
    public static final Short PROJECT_AUDIT_PROJECT = 8;
    /** ADD 【WJJ】 【20170712】 END */

    /*
     * add by jiaoshy ZTYW-741  香港机构
     * */
    public static final String HK_ORG = "1004";
    public static final String USD = "USD";  //美元
    public static final String CYN = "CNY";  //人民币

    /**
     * 资金业务类别（表外）
     */
    public static final Short FI_HANDLE_TYPE_OUT = 0;
    /**
     * 资金业务类别（表内）
     */
    public static final Short FI_HANDLE_TYPE_IN = 1;
    /**
     * 报价表 类型 枚举 ：保理
     */
    public static final Short CAL_TYPE_LF = 1;

    /**
     * 报价表类型  枚举 ：租赁
     */
    public static final Short CAL_TYPE_RENT = 0 ;

    /**
     * 区分保理 租赁
     */
    public static final Short LEASE_TYPE = 0 ;

    public static final Short FACTOR_TYPE= 1;
    /* 税票改造 201709 lvcn start*/
    /**
     * 未收票
     */
    public static final Short NOT_RECEIVE = 0;
    /**
     * 部分收票
     */
    public static final Short PART_RECEIVE = 1;
    /**
     * 已收票
     */
    public static final Short ALREADY_RECEIVE = 2;
    /**
     * 已删除
     */
    public static final Short DEL_FLAG_YES = 1;
    /**
     * 未删除
     */
    public static final Short DEL_FLAG_NO = 0;

    //发票类型
    /**
     * 开出发票
     */
    public static final Short INVOICE_BILLING = 0;
    /**
     * 收取发票
     */
    public static final Short INVOICE_RECEIVE = 1;

    /* 税票改造 201709 lvcn end*/

    /** INSERT  【 wangjj】 【2017年11月17日】 【BUG修改】<BUG号 JICL-1488号> */
    /**
     * 凭证状态：撤销中
     */
    public static final Short VOUCHER_STATUS_BANKOUT = 0;
    /** INSERT  END */

    /**
     * lv_contract_all_c 视图中 cont_type 区分租赁合同还是保理合同
     * 合同类型 保理合同
     */
    public static final Short FACTORING_CONTRACT = 20;

    /**
     * 客户性质(内部)外资企业
     */
    public static final String KEHU_FOREIGN_ENTERPRISE = "269006";

    /**
     * 经济性质外资企业
     */
    public static final String JINGJI_FOREIGN_ENTERPRISE = "330";

    /**
     * 中华人民共和国
     */
    public static final String CHINA = "0";

    /**
     * 担保人
     */
    public static final String GUARANTEE = "14";

    /**
     * 服务费支出税率
     */
    public static final Short SRV_TAX_16 = 5;
    /**
     * 服务费支出税率
     */
    public static final Short SRV_TAX_10 = 6;
    /**
     * 审批流 待办 （0）
     */
    public static final Short PROCESS_STATUS_NO = 0 ;
    public static final Short admittace_type_1 = 1 ;
    public static final Short admittace_type_2 = 2 ;
    public static final Short admittace_type_3 = 3 ;
    public static final Short admittance_source_1 = 1 ;
    public static final Short admittance_source_2 = 2 ;

    /**
     * 算法版本
     */
    //算法版本1 其它事件类别向最近收租日合并(默认算法)。
    public static final Short cal_merge_event = 1 ;
    //算法版本2 不同事件类别向同一日期收租日合并,非同一日期则单据计算
    public static final Short cal_independent_event = 2 ;
    //算法版本3 单独计算所有事件日期,不合并。(未实现)
    public static final Short cal_all_event = 3 ;

    /**
     * 租赁类型 融资租赁
     */
    public static final Short LEASING = 0;

    /**
     * 租赁类型 项目保理
     */
    public static final Short FACTORING = 1;
}