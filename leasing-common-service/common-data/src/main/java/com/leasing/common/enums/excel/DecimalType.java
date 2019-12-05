package com.leasing.common.enums.excel;

/**
 * @project:leasing-cloud
 * @date:2019/11/18
 * @author:Yjj@yonyou.com
 * @description:
 **/
public enum DecimalType {
    /**
     * 一位
     */
    ONE(1, "0.0"),
    /**
     * 两位
     */
    TWO(2, "0.00"),
    /**
     * 三位
     */
    THREE(3, "0.000"),
    /**
     * 四位
     */
    FOUR(4, "0.0000"),
    /**
     * 五位
     */
    FIVE(5, "0.00000"),

    /**
     * 六位
     */
    SIX(6, "0.000000");

    /**
     * 日期格式
     */
    private String decimal;

    private int scale;

    /**
     * 日期格式
     *
     * @param scale
     * @param decimal
     */
    DecimalType(int scale, String decimal) {
        this.scale = scale;
        this.decimal = decimal;
    }

    /**
     * 获取日期格式
     *
     * @return
     */
    public String getDecimal() {
        return decimal;
    }

    /**
     * 获取日期格式
     *
     * @return
     */
    public int getScale() {
        return scale;
    }
}