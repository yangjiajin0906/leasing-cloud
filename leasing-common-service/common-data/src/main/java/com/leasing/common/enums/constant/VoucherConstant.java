package com.leasing.common.enums.constant;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:
 **/
public class VoucherConstant {
    /********************* 记账体系的参数公用key **********************/
    /**
     * 特殊排序
     */
    public static final String SORTSPECIALRULE = "SORTSPECIALRULE";

    /** 原有业务凭证主键*/
    public static final String OLD_PKS_FOR_VOUCHER = "OLD_PKS_FOR_VOUCHER";

    /** 数据源*/
    public static final String DB_SOURCE = "DB_SOURCE";

    /** 业务凭证数据源*/
    public static final String BUSI_VOUCHER_DB_SOURCE = "BUSI_VOUCHER_DB_SOURCE";

    /** 业务流水*/
    public static final String BUSI_FLOW_DB_SOURCE = "BUSI_FLOW_DB_SOURCE";

    /** 财务流水*/
    public static final String FINAL_FLOW_DB_SOURCE = "FINAL_FLOW_DB_SOURCE";

    /** 辅助核算*/
    public static final String ASSIST_DB_SOURCE = "ASSIST_DB_SOURCE";

    /*******************模块名称*******************/
    public static final String MODULE_NAME = "MODULE_NAME";

    /** 租赁模块 */
    public static final String LEASE_MODULE = "LEASE_MODULE";

    /** 资金模块 */
    public static final String CAPITAL_MODULE = "CAPITAL_MODULE";

    /** 保理模块 */
    public static final String FACTOR_MODULE = "FACTOR_MODULE";

    /*******************公用表名*******************/
    /** 业务流水表 */
    public static final String BUSI_FLOW_TABLE = "BUSI_FLOW_TABLE";

    /** 会计流水表 */
    public static final String ACCOUNT_FLOW_TABLE = "ACCOUNT_FLOW_TABLE";

    /** 业务凭证表 */
    public static final String BUS_BILL_TABLE = "BUS_BILL_TABLE";

    /** 业务余额表 */
    public static final String BUSI_BALANCE_TABLE = "BUSI_BALANCE_TABLE";

    /***********************自动柜员主键************************/
    /**自动柜员001*/
    public static final String AUTO001 = "0001A21000000005A8RV";

    /** 凭证号是否自动补号的编码 */
    public static final String VOUCHERNO_INITCODE = "GL039";

    /******** 来源系统********/
    /**来源系统-核心账务系统*/
    public static final String SOURCE_SYSTEM_YLS = "JFL";
    /**来源系统-总账*/
    public static final String SOURCE_SYSTEM_GL = "GL";

    /********************* 后台传数operMap key **********************/
    /**
     * 功能节点编号
     */
    public static final String FUNCODE = "FUNCODE";

    /**
     * 操作人
     */
    public static final String PK_OPERATOR = "PK_OPERATOR";

    /**
     * 操作日期
     */
    public static final String OPERATE_DATE = "OPERATE_DATE";

    /**
     * 操作时间
     */
    public static final String OPERATE_TIME = "OPERATE_TIME";

    /**
     * 机构
     */
    public static final String PK_ORG = "PK_ORG";

    /**
     * 时间戳
     */
    public static final String TS = "TS";

    /**
     * 记账动作
     */
    public static final String BUSIACTION = "BUSIACTION";

    /**
     * 记账动作：执行全部
     */
    public static final String EXEC_ALL = "EXECALL";

    /**
     * 记账动作：提交部分
     */
    public static final String EXEC_SUBMITPART = "EXEC_SUBMITPART";

    /**
     * 记账动作：审核部分
     */
    public static final String EXEC_CHECKPART = "EXEC_CHECKPART";

    /**
     * 凭证主键
     */
    public static final String PK_VOUCHER = "PK_VOUCHER";

    /**
     * 旧凭证主键
     */
    public static final String OLD_PK_VOUCHER = "OLD_PK_VOUCHER";

    /**
     * 交易主体
     */
    public static final String PK_CORP = "PK_CORP";

    /**
     * 登录机构(记账参数)
     */
    public static final String MAIN_PK_CORP = "MAIN_PK_CORP";

    /**
     * 来源单据(记账参数)
     */
    public static final String SOURCE_BILL = "SOURCE_BILL";

    /**
     * 事件编码参数名称
     */
    public static final String EVENT_CODE = "EVENT_CODE";

    /********************* 业务凭证属性 **********************/
    /**
     * 业务凭证：主键
     */
    public static final String BV_PK_BUS_BILL = "PK_BUS_BILL";

    /**
     * 业务凭证：来源单据
     */
    public static final String BV_SOURCE_BILL = "SOURCE_BILL";

    /**
     * 业务凭证：合同
     */
    public static final String BV_PK_CONTRACT = "PK_CONTRACT";

    /**
     * 业务凭证：流水号
     */
    public static final String BV_SERIAL_NO = "SERIAL_NO";

    /**
     * 业务凭证：来源单据类型
     */
    public static final String BV_SOURCE_BILLTYPE = "SOURCE_BILLTYPE";

    /**
     * 业务凭证：发生日期
     */
    public static final String BV_OCCR_DATE = "OCCR_DATE";

    /**
     * 业务凭证：发生金额
     */
    public static final String BV_OCCR_CASH = "OCCR_CASH";

    /**
     * 业务凭证：冲销凭证主键
     */
    public static final String BV_PK_OFFER = "PK_OFFER";

    /**
     * 业务凭证：冲销操作员
     */
    public static final String BV_PK_OPERATOR_OFFER = "PK_OPERATOR_OFFER";

    /**
     * 业务凭证：冲销操作日期
     */
    public static final String BV_OPERATE_DATE_OFFER = "OPERATE_DATE_OFFER";

    /**
     * 业务凭证：作废标识
     */
    public static final String BV_DISCARD_FLAG = "DISCARD_FLAG";

    /**
     * 业务凭证：影响因素1
     */
    public static final String BV_FACTOR1 = "FACTOR1";

    /**
     * 业务凭证：影响因素2
     */
    public static final String BV_FACTOR2 = "FACTOR2";

    /**
     * 业务凭证：影响因素3
     */
    public static final String BV_FACTOR3 = "FACTOR3";

    /**
     * 业务凭证：影响因素4
     */
    public static final String BV_FACTOR4 = "FACTOR4";

    /**
     * 业务凭证：影响因素5
     */
    public static final String BV_FACTOR5 = "FACTOR5";

    /********************* 业务流水属性 **********************/
    /**
     * 业务流水：主键
     */
    public static final String BF_PK_BUSI_FLOW = "PK_BUSI_FLOW";

    /**
     * 业务流水：来源单据
     */
    public static final String BF_SOURCE_BILL = "SOURCE_BILL";

    /**
     * 业务流水：主体账簿
     */
    public static final String BF_PK_GLORGBOOK = "PK_GLORGBOOK";

    /**
     * 业务流水：核算主体
     */
    public static final String BF_PK_CORP = "PK_CORP";

    /**
     * 业务流水：收支计划主键
     */
    public static final String BF_PK_INOUT_PLAN = "PK_INOUT_PLAN";

    /**
     * 业务流水：事件类别
     */
    public static final String BF_PK_TRADETYPE = "PK_TRADETYPE";

    /**
     * 业务流水：业务流水编号
     */
    public static final String BF_FLOW_CODE = "FLOW_CODE";

    /**
     * 业务流水：发生日期
     */
    public static final String BF_OCCR_DATE = "OCCR_DATE";

    /**
     * 业务流水：发生金额
     */
    public static final String BF_OCCR_CASH = "OCCR_CASH";

    /**
     * 业务流水：本币发生金额
     */
    public static final String BF_LOCAL_OCCR_CASH = "LOCAL_OCCR_CASH";

    /**
     * 业务流水：余额项
     */
    public static final String BF_BALANCE_COL = "BALANCE_COL";

    /**
     * 业务流水：方向
     */
    public static final String BF_DIRECTION = "DIRECTION";

    /**
     * 业务流水：币种
     */
    public static final String BF_PK_CURRTYPE = "PK_CURRTYPE";

    /**
     * 业务流水：汇率
     */
    public static final String BF_EXCHANGE_RATE = "EXCHANGE_RATE";

    /**
     * 业务流水：客户
     */
    public static final String BF_PK_CUSTOMER = "PK_CUSTOMER";

    /**
     * 业务流水：合同
     */
    public static final String BF_PK_CONTRACT = "PK_CONTRACT";

    /**
     * 业务流水：冲销凭证主键
     */
    public static final String BF_PK_OFFER = "PK_OFFER";

    /**
     * 业务流水：流水编号
     */
    public static final String BF_BUSI_CODE = "BUSI_CODE";

    /**
     * 业务流水：备注
     */
    public static final String BF_MEMO = "MEMO";

    /**
     * 业务流水：预留辅助1
     */
    public static final String BF_PK_ASS1 = "PK_ASS1";

    /**
     * 业务流水：预留辅助2
     */
    public static final String BF_PK_ASS2 = "PK_ASS2";

    /**
     * 业务流水：预留辅助3
     */
    public static final String BF_PK_ASS3 = "PK_ASS3";

    /**
     * 业务流水：预留辅助4
     */
    public static final String BF_PK_ASS4 = "PK_ASS4";

    /**
     * 业务流水：预留辅助5
     */
    public static final String BF_PK_ASS5 = "PK_ASS5";


    /********************* 财务流水属性 **********************/
    /**
     * 财务流水：单据中，手工输入的凭证号
     */
    public static final String FF_VOUCHER_NO = "VOUCHER_NO";

    /**
     * 财务流水：来源单据
     */
    public static final String FF_SOURCE_BILL = "SOURCE_BILL";

    /**
     * 财务流水：收支计划主键
     */
    public static final String FF_PK_INOUT_PLAN = "PK_INOUT_PLAN";

    /**
     * 财务流水：事件类别
     */
    public static final String FF_PK_TRADETYPE = "PK_TRADETYPE";

    /**
     * 财务流水：实际发生金额
     */
    public static final String FF_FACT_CASH = "FACT_CASH";

    /**
     * 财务流水：本币实际发生金额
     */
    public static final String FF_LOCAL_FACT_CASH = "LOCAL_FACT_CASH";

    /**
     * 财务流水：发生数量
     */
    public static final String FF_FACT_QUANTITY = "FACT_QUANTITY";

    /**
     * 财务流水：本币发生数量
     */
    public static final String FF_LOCAL_FACT_QUANTITY = "LOCAL_FACT_QUANTITY";

    /**
     * 财务流水：方向
     */
    public static final String FF_DIRECTION = "DIRECTION";

    /**
     * 财务流水：发生日期
     */
    public static final String FF_FACT_DATE = "FACT_DATE";

    /**
     * 财务流水：科目主键
     */
    public static final String FF_PK_ACCSUBJ = "PK_ACCSUBJ";

    /**
     * 财务流水：摘要
     */
    public static final String FF_MEMO = "MEMO";

    /**
     * 财务流水：币种
     */
    public static final String FF_PK_CURRTYPE = "PK_CURRTYPE";

    /**
     * 财务流水：汇率
     */
    public static final String FF_EXCHANGE_RATE = "EXCHANGE_RATE";

    /**
     * 财务流水：账户
     */
    public static final String FF_PK_ACCOUNT = "PK_ACCOUNT";

    /**
     * 财务流水：客户
     */
    public static final String FF_PK_CUSTOMER_DOC = "PK_CUSTOMER_DOC";

    /**
     * 财务流水：合同
     */
    public static final String FF_PK_CONTRACT_DEF = "PK_CONTRACT_DEF";

    /**
     * 财务流水：部门
     */
    public static final String FF_PK_DEPT = "PK_DEPT";

    /**
     * 财务流水：人员信息
     */
    public static final String FF_PK_EMPLOYEE = "PK_EMPLOYEE";

    /**
     * 财务流水：项目信息
     */
    public static final String FF_PK_PROJECT_PRO = "PK_PROJECT_PRO";

    /**
     * 财务流水：核算主体
     */
    public static final String FF_PK_CORP = "PK_CORP";

    /**
     * 财务流水：分录编号
     */
    public static final String FF_DETAIL_NO = "DETAIL_NO";

    /**
     * 财务流水：主体账簿
     */
    public static final String FF_PK_GLORGBOOK = "PK_GLORGBOOK";

    /**
     * 财务流水：
     */
    public static final String FF_FORCAST_NO = "FORCAST_NO";

    /**
     * 财务流水：冲销凭证主键
     */
    public static final String FF_PK_OFFER = "PK_OFFER";

    /**
     * 财务流水：预留辅助1
     */
    public static final String FF_PK_ASS1 = "PK_ASS1";

    /**
     * 财务流水：预留辅助2
     */
    public static final String FF_PK_ASS2 = "PK_ASS2";

    /**
     * 财务流水：预留辅助3
     */
    public static final String FF_PK_ASS3 = "PK_ASS3";

    /**
     * 财务流水：预留辅助4
     */
    public static final String FF_PK_ASS4 = "PK_ASS4";

    /**
     * 财务流水：预留辅助5
     */
    public static final String FF_PK_ASS5 = "PK_ASS5";

    /**
     * 财务流水：发生额
     */
    public static final String FF_OCCUR_CASH_0 = "OCCUR_CASH_0";

    /**
     * 财务流水：发生额
     */
    public static final String FF_OCCUR_CASH_1 = "OCCUR_CASH_1";

    /**
     * 财务流水：发生额
     */
    public static final String FF_OCCUR_CASH_2 = "OCCUR_CASH_2";

    /**
     * 财务流水：发生额
     */
    public static final String FF_OCCUR_CASH_3 = "OCCUR_CASH_3";

    /**
     * 财务流水：发生额
     */
    public static final String FF_OCCUR_CASH_4 = "OCCUR_CASH_4";

    /**
     * 财务流水：发生额
     */
    public static final String FF_OCCUR_CASH_5 = "OCCUR_CASH_5";


    //[投资-购买] wangjj@2016/09/05 ADD START
    /**
     * 投资产品
     */
    public static final String FF_PK_INVEST_PROJECT = "PK_INVEST_PROJECT";
    //[投资-购买] wangjj@2016/09/05 ADD END

    /**
     * 核算主体机构
     */
    public static final String PK_ACCT_ORG = "PK_ACCT_ORG";
}