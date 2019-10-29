package com.leasing.common.enums.base;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:收支方向
 **/
public class Direction extends EnumType {

    public Direction(int code, String label) {
        super(code, label);
    }
    /**
     * 收入-0
     */
    public final static Direction INCOME = new Direction(0, "收入");
    /**
     * 支出-1
     */
    public final static Direction PAY = new Direction(1, "支出");

}
