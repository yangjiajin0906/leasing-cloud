package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:先付后付标志
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
