package com.leasing.common.enums.constant;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:业务类别常量类
 **/
public class ParamTransType {
    /**
     * 投放类别
     */
    public static final String LOAN_TYPE = "01";

    /**
     * 租金类别
     */
    public static final String RENT_TYPE = "02";

    /**
     * 保证金类别
     */
    public static final String DEPOSIT_TYPE = "03";

    /**
     * 服务费收入类别
     */
    public static final String SRVIN_TYPE = "04";

    /**
     * 服务费支出类别
     */
    public static final String SRVOUT_TYPE = "05";

    /**
     * 服务费支出类别
     */
    public static final String OTHER_TYPE = "06";

    /**
     * 资金 提款类别
     */
    public static final String CP_DRAWMONEY_TYPE = "01";

    /**
     * 资金 还款类别
     */
    public static final String CP_REPAY_TYPE = "02";

    /**
     * 资金 融资手续费类别
     */
    public static final String CP_SRVFEE_TYPE = "03";

    /**
     * 资金 保险费类别
     */
    public static final String CP_PREMIUM_TYPE = "04";

    /**
     * 资金 其他支出类别
     */
    public static final String CP_ORTHERPAY_TYPE = "05";

    //新增 保函手续费  start
    /**
     * 资金 保函手续费类别
     */
    public static final String CP_SRVBHFEE_TYPE = "09";
    // 新增 保函手续费  end
    /** add 投资管理 start*/
    /**
     * 资金 投资理财购买
     */
    public static final String CP_INVEST_BUY_TYPE = "10";

    /**
     * 资金 投资理财赎回
     */
    public static final String CP_INVEST_REP_TYPE = "11";
    /** add 投资管理  end*/
}