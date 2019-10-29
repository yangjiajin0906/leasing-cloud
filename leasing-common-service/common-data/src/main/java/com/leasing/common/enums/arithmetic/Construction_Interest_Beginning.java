package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:总投放金额的计息方式(针对在建期多次投放)
 *  0-以多次投放总额开始计息
 *  1-以每笔投放金额开始计息
 **/
public class Construction_Interest_Beginning extends EnumType {

    public Construction_Interest_Beginning(int code, String label) {
        super(code, label);
    }
    /**约定计息（总投放金额）-0*/
    public final static Construction_Interest_Beginning BEGINNING_INTEREST = new Construction_Interest_Beginning(0, "约定计息（总投放金额）");
    /**按投放时点计息-1*/
    public final static Construction_Interest_Beginning PUTTING_INTEREST = new Construction_Interest_Beginning(1, "按投放时点计息");

}
