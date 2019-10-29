package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:年利率计算方式
 **/
public class Float_method extends EnumType {

    public Float_method(int code, String label) {
        super(code, label);
    }
    /**
     * 百分比-0
     */
    public final static Float_method PERCENT = new Float_method(0, "百分比");
    /**
     * 绝对值-1
     */
    public final static Float_method ABSOLUTE_VALUE = new Float_method(1, "绝对值");

}
