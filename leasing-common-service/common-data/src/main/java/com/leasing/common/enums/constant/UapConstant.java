package com.leasing.common.enums.constant;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:银行对账单常量
 **/
public class UapConstant {
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
     * 租金表类型 枚举 市场表
     */
    public static final Short RENTTYPE_MARKET = 0;

    /**
     * 租金表类型 枚举 会计表
     */
    public static final Short RENTTYPE_ACCOUNT = 1;
    /**
     * 银行对账单分类: 收款
     */
    public static final Short CLASSIFY_INCOME = 1;
    /**
     * 银行对账单分类: 付款
     */
    public static final Short CLASSIFY_OUTCOME = 2;
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
     * 无
     */
    public static final Short CHARGE_METHOD_NOTHING=0;
    /**
     * 暂存
     */
    public static final Short INITALIZE=20;

    /**
     * 审核中
     */
    public static final Short APPROVING = 204  ;

    /**
     * 初始
     * */
    public static final Short INITIAL =99;

    /**
     * 现金流方向 枚举 付款
     */
    public static final Short CASH_PAY = 1;

    /**
     * 现金流方向 枚举 收款
     */
    public static final Short CASH_GATHING = 0;

    /**
     * 参数编号
     */
    public static final String GATHER_ORDER = "1000267";

    //排序使用
    /**
     * 保证金
     */
    public static final String DEPOSIT = "DEPOSIT";

    /**
     * 首付款
     */
    public static final String INDEX = "INDEX";

    /**
     * 业务逾期租金
     */
    public static final String BUSIRENT = "BUSIRENT";

    /**
     * 手续费
     */
    public static final String SRVFEE = "SRVFEE";

    /**
     * 本金
     */
    public static final String CORPUS = "CORPUS";

    /**
     * 租息
     */
    public static final String INTEREST = "INTEREST";

    /**
     * 罚息
     */
    public static final String REST = "REST";

    /**
     * 名义货价
     */
    public static final String NORMAL = "NORMAL";

    //事件类别
    /** 投放（现金） */
    public static final String TRADETYPE_PUTTING = "10101";
    /** 投放（银票） */
    public static final String TRADETYPE_PUTTING_BANK = "10102";
    /** 商业折扣 */
    public static final String BUSINESS_DISCOUNT = "10103";
    /** 收租 */
    public static final String TRADETYPE_RENT = "10201";
    /** 收租（建设期） */
    public static final String TRADETYPE_RENT_C = "10202";
    /** 首付款 */
    public static final String TRADETYPE_FIRST = "10203";
    /** 留购价款 */
    public static final String TRADETYPE_PRICE = "10204";
    /** 资产余值 */
    public static final String TRADETYPE_BALANCE = "10205";
    /** 银票保证金支付 */
    public static final String TRADETYPE_DEPOSIT_INCOME_BANK = "10206";
    /** 承兑银票 */
    public static final String TRADETYPE_NOTE_BANK = "10207";
    /** 银票保证金退回 */
    public static final String TRADETYPE_DEPOSIT_BACK_BANK = "10208";
    /** 银票保证金计息 */
    public static final String TRADETYPE_DEPOSIT_INTEREST_BANK = "10209";
    /** 罚息 */
    public static final String TRADETYPE_DEFAULT_INTEREST = "10213";
    /** 收取保证金 */
    public static final String TRADETYPE_DEPOSIT_INCOME = "10301";
    /** 保证金冲抵 */
    public static final String TRADETYPE_DEPOSIT_RENT = "10302";
    /** 厂商保证金 */
    public static final String TRADETYPE_DEPOSIT_FACTORY = "10303";
    /** 退还保证金 */
    public static final String TRADETYPE_DEPOSIT_BACK = "10304";
    /** 退还厂商保证金 */
    public static final String TRADETYPE_DEPOSIT_BACK_FACTOR = "10305";
    /** 支付保证金利息 */
    public static final String TRADETYPE_DEPOSIT_INTEREST = "10306";
    /** 保证金冲抵租金 */
//     public static final String TRADETYPE_DEPOSIT_RUSHRENT = "10307";
    /** 补回保证金 */
    public static final String TRADETYPE_DEPOSIT_FILLBACK = "10308";
    /** 租赁服务费 */
    public static final String TRADETYPE_SRV_INCOME = "10401";
    /** 中间业务费 */
    public static final String TRADETYPE_BUSINESS_INCOME = "10402";
    /** 服务费支出 */
    public static final String TRADETYPE_SRV_PAY = "10501";
    /** 其他收入 */
    public static final String TRADETYPE_OTHER_INCOME = "10601";
    /** 其他支出 */
    public static final String TRADETYPE_OTHER_PAY = "10602";
    /** 租赁利息计提 */
    public static final String TRADETYPE_RENT_ACCRUAL = "10701";
    /** 手续费计提 */
    public static final String TRADETYPE_DEPOSIT_ACCRUAL = "10702";
    /** 转出预收租金 */
    public static final String TRADETYPE_OUT_LEASECASE = "30408";
    /** 转入预收租金 */
    public static final String TRADETYPE_IN_LEASECASE = "30401";

    //=====================自动核销运行参数
    public static final String ARGS_CODE = "000043";
    public static final String SYSTEM_FLAG = "000030";
    public static final String GATHER_TYPE = "000050";
    public static final String SYSTEM_ZT = "1";
    public static final String YES = "0";
    public static final String NO = "1";


    /**
     * 合同状态[1000212]<br>
     * 结清
     */
    public static final Short CONT_STATUS_NORMAL_END = 3;

    /**
     * 合同状态[1000212]<br>
     * 已撤销
     */
    public static final Short CONT_REVOKE = 5;

    /**
     * 自动核销时，根据校验规则
     * 0 :只用账户名
     * 1 :账户 + 账号
     */
    public static final String VERIFI_RULE = "000058";
    /**
     * 自动核销时，根据校验规则
     * 0 :只用账户名
     * 1 :账户 + 账号
     */
    public static final Short VERIFI_RULE_CODE = 0;
    public static final Short VERIFI_RULE_CODE_AND_NAME = 1;
}