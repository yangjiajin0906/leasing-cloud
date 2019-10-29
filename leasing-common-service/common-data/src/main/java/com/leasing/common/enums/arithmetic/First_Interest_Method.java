package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:首期计息方式
 **/
public class First_Interest_Method extends EnumType {

    public First_Interest_Method(int code, String label) {
        super(code, label);
    }
    /**按整期-0*/
    public final static First_Interest_Method INTEREST_TERM = new First_Interest_Method(0, "按整期");
    /**按实际天数-1*/
    public final static First_Interest_Method INTEREST_FACT = new First_Interest_Method(1, "按实际天数");

}
