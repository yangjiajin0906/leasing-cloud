package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:付款方式
 **/
public class Pay_method extends EnumType {

    public Pay_method(int code, String label) {
        super(code, label);
    }
    /**
     * 现金
     */
    public final static Pay_method CASH = new Pay_method(0, "现金");
    /**
     * 银票
     */
    public final static Pay_method BANK = new Pay_method(1, "银票");

}
