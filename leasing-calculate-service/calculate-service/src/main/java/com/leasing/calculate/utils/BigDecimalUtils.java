package com.leasing.calculate.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;

/**
 * @project:leasing-cloud
 * @date:2019/10/12
 * @author:Yjj@yonyou.com
 * @description:
 **/
public class BigDecimalUtils {
    /** BigDecimal的默认值0.0. */
    public static final BigDecimal ZERO = BigDecimal.ZERO;
    /**
     * 100常量
     */
    public static final BigDecimal N100 = new BigDecimal(100.0);

    /**
     * 精度16位
     */
    public static final MathContext MATHCONTEXT_16 = MathContext.DECIMAL64;

    /**
     * 构造函数
     */
    private BigDecimalUtils() {
        super();
    }

    /**
     * 返回实际数据<br>
     * 如果是null，返回BigDecimal(0.0)
     *
     * @param number
     *            元数据,有可能是null
     * @return 编辑后的数据或者是默认值
     */
    public static BigDecimal defaultIfNull(BigDecimal number) {

        if (number == null) {
            return ZERO;
        }
        return number;
    }

    /**
     * 两个BigDecimal相乘
     *
     * @param multiplicand
     *            被乘数
     * @param multiplier
     *            乘数
     * @return 返回两个数的乘积，小数点保留2位，进位规则是ROUND_HALF_EVEN
     */
    public static BigDecimal multiplyEven2(BigDecimal multiplicand, BigDecimal multiplier) {

        return multiply(multiplicand, multiplier, 2, BigDecimal.ROUND_HALF_EVEN);
    }

    /**
     * 两个BigDecimal相乘
     *
     * @param multiplicand
     *            被乘数
     * @param multiplier
     *            乘数
     * @return 返回两个数的乘积，小数点保留2位，进位规则是ROUND_DOWN
     */
    public static BigDecimal multiplyDown2(BigDecimal multiplicand,
                                           BigDecimal multiplier) {

        return multiply(multiplicand, multiplier, 2, BigDecimal.ROUND_DOWN);
    }


    /**
     * 计算两个BigDecimal相乘
     *
     * @param multiplicand
     *            被乘数
     * @param multiplier
     *            乘数
     * @param scaleCount
     *            小数点保留位数
     * @param roundType
     *            进位标志
     * @return 返回两个数的乘积
     */
    public static BigDecimal multiply(BigDecimal multiplicand,
                                      BigDecimal multiplier, int scaleCount, int roundType) {
        // Validates input
        if (multiplicand == null) {
            throw new IllegalArgumentException(
                    "The multiplicand must not be null.");
        }
        if (multiplier == null) {
            throw new IllegalArgumentException(
                    "The multiplier must not be null.");
        }

        return multiplicand.multiply(multiplier)
                .setScale(scaleCount, roundType);
    }

    /**
     * 是否小于等于0
     *
     * @param number
     *            比较数
     * @return 如果小于等于0，返回true
     */
    public static boolean isLessEqualsZero(BigDecimal number) {
        // Validates input
        if (number == null) {
            throw new IllegalArgumentException("The number must not be null.");
        }
        // 小于等于0返回true
        if (number.compareTo(ZERO) <= 0) {
            return true;
        }

        return false;
    }

    /**
     * 是否等于0
     *
     * @param number
     *            比较数
     * @return 如果等于0，返回true
     */
    public static boolean equalZero(BigDecimal number) {
        // Validates input
        if (number == null) {
            throw new IllegalArgumentException("The number must not be null.");
        }
        // 等于0返回true
        if (number.compareTo(ZERO) == 0) {
            return true;
        }

        return false;
    }

    /**
     * 是否大于等于0
     *
     * @param number
     *            比较数
     * @return 如果大于等于0，返回true
     */
    public static boolean isBiggerEqualsZero(BigDecimal number) {
        // Validates input
        if (number == null) {
            throw new IllegalArgumentException("The number must not be null.");
        }
        // 大于等于0返回true
        if (number.compareTo(ZERO) >= 0) {
            return true;
        }

        return false;
    }

    /**
     * Description: 数据金额格式化<br>
     * @param obj
     * @return
     * @author: xingxi<br>
     * @Date：2013-11-29
     */
    public static String bigDecimalStr(BigDecimal obj){
        if(obj==null){
            return "";
        }
        return new DecimalFormat("###,###,##0.00").format(obj);
    }
    /**
     * Description: 数据金额格式化<br>
     * @param obj
     * @return
     * @author: xingxi<br>
     * @Date：2013-11-29
     */
    public static String bigDecimalStr(Object obj){

        if(obj==null){
            return "";
        }
        if(obj instanceof String){
            obj =((String)obj).replaceAll(",", "");
        }
        return new DecimalFormat("###,###,##0.00").format(TypeCast.obj2BigDecimal(obj));
    }

    /**
     * Description: big保留小数位数<br>
     * @param obj
     * @param scale 位数
     * @return
     * @author: xingxi<br>
     * @Date：2013-12-8
     */
    public static BigDecimal bigdecimalScale(BigDecimal obj,int scale){
        if(obj==null){
            return BigDecimal.ZERO;
        }else{
            obj=obj.setScale(scale, BigDecimal.ROUND_HALF_UP);
        }
        return obj;
    }

    /**
     * Description: irr显示结果，文档打印使用<br>
     * @return
     * @author: xingxi<br>
     * @Date：2013-12-8
     */
    public static BigDecimal bigdecimalScaleIrr(BigDecimal obj){
        if(obj==null){
            return BigDecimal.ZERO;
        }else{
            obj=obj.multiply(new BigDecimal(100));
        }
        return bigdecimalScale(obj, 4);
    }
    /**
     * Description: 年利率显示结果，文档打印使用<br>
     * @return
     * @author: xingxi<br>
     * @Date：2013-12-8
     */
    public static BigDecimal bigdecimalScaleRate(BigDecimal obj){
        if(obj==null){
            return BigDecimal.ZERO;
        }else{
            obj=obj.multiply(new BigDecimal(100));
        }
        return bigdecimalScale(obj, 4);
    }

    /**
     * Description: 比例显示结果，文档打印使用<br>
     * @return
     * @author: xingxi<br>
     * @Date：2013-12-8
     */
    public static BigDecimal bigdecimalScaleRatio(BigDecimal obj){
        if(obj==null){
            return BigDecimal.ZERO;
        }else{
            obj=obj.multiply(new BigDecimal(100));
        }
        return bigdecimalScale(obj, 4);
    }
}