package com.leasing.common.enums.constant;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:条件明细设置常量类
 **/
public class ConditionItemConstant {
    /**
     * 条件名称：付款条件
     * 类别：直租
     * 租赁物所有权转移登记（如有）办理完毕
     */
    public static final String PAYMENT_LEASE_REG="ZT-00020";


    /**
     * 条件名称：付款条件
     * 类别：直租或回租
     * 融资租赁合同已生效
     */
    public static final String PAYMENT_FINANCIAL ="zt-0007";
    /**
     * 条件名称：付款条件
     * 类别：直租或回租
     * 买卖合同
     */
    public static final String PAYMENT_SALES ="zt-0008";
    /**
     * 条件名称：付款条件
     * 类别：直租或回租
     * 转让协议
     */
    public static final String PAYMENT_TRANSFER ="zt-0020";
    /**
     * 条件名称：付款条件
     * 类别：直租或回租
     * 保证合同
     */
    public static final String PAYMENT_GUARANTY ="zt-0009";


    /**
     * 起租条件----------------------------------------------------------------------------
     */

    /**
     * 条件名称：起租条件
     * 类别：直租或回租
     * 融资租赁合同已生效
     */
    public static final String RENT_FINANCIAL ="00009";
    /**
     * 条件名称：起租条件
     * 类别：直租或回租
     * 买卖合同
     */
    public static final String RENT_SALES ="00010";
    /**
     * 条件名称：起租条件
     * 类别：直租或回租
     * 转让协议
     */
    public static final String RENT_TRANSFER ="00019";
    /**
     * 条件名称：起租条件
     * 类别：直租或回租
     * 保证合同
     */
    public static final String RENT_GUARANTY ="00011";
}