package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:特殊期类型
 *  0-无
 *  1-远期支付
 *  2-在建期
 *  3-租前息
 **/
public class Special_Type extends EnumType {

    public Special_Type(int code, String label) {
        super(code, label);
    }

    /** 无-0 */
    public final static Special_Type SPEC_NULL = new Special_Type(0, "无");
    /** 远期支付-1 */
    public final static Special_Type SPEC_TIMEPAY = new Special_Type(1, "远期支付");
    /** 在建期-2 */
    public final static Special_Type SPEC_BUILD = new Special_Type(2, "在建期");
    /** 租前息-3 */
    public final static Special_Type SPEC_BEFORE_INTEREST = new Special_Type(3, "租前息");

}
