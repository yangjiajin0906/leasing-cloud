package com.leasing.calculate.Enum;

/**
 * @project:leasing-cloud 先付后付标志
 * @date:2019/10/11
 * @author:Yjj@yonyou.com
 * @description:
 **/
public class Prepay_Or_Not extends EnumType {
    public Prepay_Or_Not(int code, String label) {
        super(code, label);
    }
    /**先付-0*/
    public static final Prepay_Or_Not PREPAY = new Prepay_Or_Not(0, "先付");
    /**后付-1*/
    public static final Prepay_Or_Not AFTERPAY = new Prepay_Or_Not(1, "后付");

}