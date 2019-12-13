package com.leasing.common.enums.constant;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:收支计划交易类型常量类
 **/
public class TradeType {
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
    /** 收租（租前息） */
    public static final String TRADETYPE_RENT_BEFORE_INTEREST = "10216";
    /** 首付款 */
    public static final String TRADETYPE_FIRST = "10203";
    /**咨询费收入*/
    public static final String CONSULTING_FEE_INCOME = "10210";
    /** 佣金收入 */
    public static final String RAKEOFF_INCOME = "10602";
    /** 留购价款 */
    public static final String TRADETYPE_PRICE = "10204";
    /** 资产余值 */
    public static final String TRADETYPE_BALANCE = "10205";
    /** 银票保证金支付 */
    public static final String TRADETYPE_DEPOSIT_INCOME_BANK = "10206";
    /** 银票承兑 */
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
    /** 保理保证金冲抵 */
    public static final String TRADETYPE_DEPOSIT_FACTOR = "51307";
    /** 厂商保证金 */
    public static final String TRADETYPE_DEPOSIT_FACTORY = "10303";
    /** 退还保证金 */
    public static final String TRADETYPE_DEPOSIT_BACK = "10304";
    /** 退还厂商保证金 */
    public static final String TRADETYPE_DEPOSIT_BACK_FACTOR = "10305";
    /** 支付保证金利息 */
    public static final String TRADETYPE_DEPOSIT_INTEREST = "10306";
    /** 保证金冲抵租金 */
//    public static final String TRADETYPE_DEPOSIT_RUSHRENT = "10307";
    /** 补回保证金 */
    public static final String TRADETYPE_DEPOSIT_FILLBACK = "10308";
    /** 保证金利息冲抵 */
    public static final String TRADETYPE_DEPOSIT_INTEREST_RENT = "10309";
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
    /** 退还预收租金 */
    public static final String TRADETYPE_BACK_LEASECASE = "10803";
    /** 退还预收租金利息 */
    public static final String TRADETYPE_BACK_LEASECASE_INTEREST = "10804";
    /** 退还存入保证金 */
    public static final String TRADETYPE_BACK_INLEASECASE = "10903";
    /** 退还存入保证金利息 */
    public static final String TRADETYPE_BACK_INLEASECASE_INTEREST = "10904";

    /** 存入保证金冲抵 */
    public static final String TRADETYPE_DEPOSIT_AGAINST = "10902";
    /** 预收租金冲抵 */
    public static final String TRADETYPE_ADVANCE_AGAINST = "10802";

    /** 手续费计提 */
    public static final String TRADETYPE_DEPOSIT_ACCRUAL = "10702";
    /** 转出预收租金 */
    public static final String TRADETYPE_OUT_LEASECASE = "30408";
    /** 转入预收租金 */
    public static final String TRADETYPE_IN_LEASECASE = "30401";
    /** 调息补差 */
    public static final String TRADETYPE_RESERVE = "10211";
    /** 退还暂收款 */
    public static final String TRADETYPE_ADVANCE = "12101";

    /****************收银票***************************/
    public static final String REC_BILL_CHECK = "11101";
    public static final String REC_BILL_ACCEPT = "11102";
    /**
     * 银票支付手续费
     */
    public static final String TRADETYPE_CHARGE_OUT_BANK = "11003";

    /****************资金模块***************************/

    /**贷款-提前还款费用**/
    public static final String CP_TRADETYPE_PREPAY = "200801";

    /** 贷款-收取贷款 */
    public static final String CP_TRADETYPE_LOAN = "20101";

    /** 贷款-支付本金 */
    public static final String CP_TRADETYPE_PAY_CORPUS = "20201";

    /** 贷款-支付利息 */
    public static final String CP_TRADETYPE_PAY_INTEREST = "20202";

    /** 贷款-支付融资手续费 */
    public static final String CP_TRADETYPE_PAY_SRVFEE = "20301";

    //[资金模块-报价算法] wangjj@2016/08/01 ADD START
    /** 贷款-支付保函手续费 */
    public static final String CP_TRADETYPE_PAY_SRVFEE_BH = "20901";
    //[资金模块-报价算法] wangjj@2016/08/01 ADD END
    /** 贷款-支付保险费 */
    public static final String CP_TRADETYPE_PAY_PREMIUM = "20401";

    /** 贷款-支付其他费用 */
    public static final String CP_TRADETYPE_PAY_OTHER = "20501";

    /** 凭证，事件类别：银行到账 */
    public static final String V_TRADETYPE_ACCOUNT = "07";

    /** 佣金收入 */
    public static final String BROKERAGE_IN = "10602";

    /** 咨询顾问费支出 */
    public static final String INQUIRY_FEE = "10601";
    /** 租金计提 */
    public static final String ACCRUAL_TYPE_RENT = "20601";
    /** 手续费 */
    public static final String ACCRUAL_TYPE_DEPOSIT = "20602";

    public static final String ALLOCATUNDS_TYPE_DEPOSIT = "20701";
    /****************财务模块***************************/
    /** 退暂收款 */
    public static final String BACK_TEMPCASH = "30203";
    /**
     * 收取资产管理费
     */
    public static final String GATHER_MANAGE_AMT = "10403";

    /**
     * 提前还款手续费
     */
    public static final String EARLY_REPAYMENT_CHARGES = "10404";
    /**
     * 存入保证金
     */
    public static final String GUARANTEE_DEPOSITS = "10901";
    /**
     * 预收租金
     */
    public static final String PREPAID_RENT = "10801";
    //luxiaogang BUG ZTL-640 不规则报价---其他收支计划---缺少的事件类别
    /**
     * 厂商手续费
     */
    public static final String SRVFEE_FACTORY = "10606";
    /**
     * 税额补偿
     */
    public static final String AMOUNT_COMPENSATION = "10605";
    /**
     * 收代垫保险费
     */
    public static final String CLOSED_INSURANCE = "10603";
    /**
     * 其他支出
     */
    public static final String OTHER_SPENDING = "10609";
    /**
     * 付代垫保险费
     */
    public static final String PAY_INSURANCE = "10604";
    /**
     * 违约金
     */
    public static final String DEFAULT_CASH = "10610";
    //end

    /**
     * 追加收益
     */
    public static final String ADDITIONAL_BENEFITS = "12001";

    /** ADD 投资管理 start*/
    /**
     * 资金 投资理财购买
     */
    public static final String CP_INVEST_BUY = "21001";
    /**
     * 资金 投资理财赎回
     */
    public static final String CP_INVEST_REP = "21101";
    /** ADD 投资管理  end*/

    /** ADD chenxc 2017-7-17  添加事件类别end*/
    /** 保理-回款本息*/
    public static final String TRADETYPE_FACTORING = "51301";

    /** 保理-手续费 编号*/
    public static final String COMMISSION_CHARGE = "51302";

    /** 保理首付款 */
    public static final String FACTORING_TRADETYPE_FIRST = "51310";
    /** ADD chenxc 2017-7-17   添加事件类别end*/

    /** 保理 保证金冲抵*/
    public static final String FACTORING_TRADETYPE_DEPOSIT = "51307";

    /** 保理 保证金冲抵*/
    public static final String FACTORING_CONSULTING_FEE_INCOME = "51309";

    /** 保理罚息 */
    public static final String FACTORING_DEFAULT_INTEREST = "51303";

    /** 保理-融资本金 编号*/
    public static final String FINANCING_PRINCIPAL = "51306";

    /** 保理-保证金冲抵 编号*/
    public static final String FACTORING_TRADETYPE_DEPOSIT_RENT = "51307";

    /** 保理-保证金退回 编号*/
    public static final String FACTORING_TRADETYPE_DEPOSIT_BACK = "51308";

    /** 保理-保证金 编号*/
    public static final String FACTORING_TRADETYPE_DEPOSIT_INCOME = "51304";

    /** 保理-中间业务费 编号*/
    public static final String MIDDLE_SERVICE_CHARGE = "51305";

}