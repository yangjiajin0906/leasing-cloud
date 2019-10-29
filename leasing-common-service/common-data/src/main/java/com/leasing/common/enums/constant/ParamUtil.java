package com.leasing.common.enums.constant;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:指标参数常量类
 **/
public class ParamUtil {
    //指标是否可以重新计算
    public static String PARAM_HA001 = "HA001";
    //参与指标计算的账簿
    public static String PARAM_HA002 = "HA002";
    //参与指标计算的科目类别
    public static String PARAM_HA003 = "HA003";
    //报表折算汇率方案编码
    public static String PARAM_HA004 = "HA004";
    //月均汇率方案编码
//	public static String PARAM_HA005 = "HA005";

    //集团型参数
    public static String PARAM_TYPE_GROUP = "0001";

    //人民币主键
    public static String PARAM_CURRTYPE = "00010000000000000001";


    //字符常量all
    public static String STRING_CONST_ALL = "ALL";
    //字符常量本币
    public static String STRING_CONST_CURR = "本币";

    //分隔符_@
    public static String STRING_CONST_OPERATOR1 = "@";
    //分隔符_#
    public static String STRING_CONST_OPERATOR2 = "#";

    public static String STRING_CONST_TAB = "tab";


    //科目类别_资产
    public static String ACCTYPE_ZC = "00010000000000000001";
    //科目类别_负债
    public static String ACCTYPE_FZ = "00010000000000000002";
    //科目类别_权益
    public static String ACCTYPE_QY = "00010000000000000003";
    //科目类别_成本
    public static String ACCTYPE_CB = "00010000000000000004";
    //科目类别_损益
    public static String ACCTYPE_SY = "00010000000000000005";
}