package com.leasing.common.enums.base;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:计算精度
 **/
public class Cal_Digit extends EnumType {

    public Cal_Digit(int code, String label) {
        super(code, label);
    }

    /** 分-0 */
    public final static Cal_Digit DECIMAL_2 = new Cal_Digit(0, "分");
    /** 元-1 */
    public final static Cal_Digit DECIMAL_0 = new Cal_Digit(1, "元");
    /** 万元-2 */
    public final static Cal_Digit DECIMAL_1000 = new Cal_Digit(2, "万元");
}
