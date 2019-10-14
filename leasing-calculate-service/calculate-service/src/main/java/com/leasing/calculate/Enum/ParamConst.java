package com.leasing.calculate.Enum;

import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/10/12
 * @author:Yjj@yonyou.com
 * @description:
 **/
public class ParamConst {
    /**投放日*/
    public static String LEASE_PUUTING = "投放日";
    /**后续投放*/
    public static String LEASE_FOLLOW_PUUTING = "后续投放";
    /**第一，期次*/
    public static int LEASE_ONE = 1;
    /**精度,计算过程中的保留精度*/
    public static int CAL_DIAG = 16;
    /** 税率默认值 */
    public static BigDecimal TAX_RATE_DEFAULT = new BigDecimal("0.17");

}