package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:错误信息
 **/
public class Error_Message extends EnumType {

    public Error_Message(int code, String label) {
        super(code, label);
    }

    /** 租金规则设置错误-0 */
    public final static Error_Message ERROR_0 = new Error_Message(0, "租金规则设置错误");
    /** 租赁期限无法整除-1 */
    public final static Error_Message ERROR_1 = new Error_Message(1, "租赁期限无法整除");
    /** 在建期支付频率设置错误，不能整除-2 */
    public final static Error_Message ERROR_2 = new Error_Message(2, "在建期支付频率设置错误，不能整除");
    /** 手工维护的收支计划存在问题-3 */
    public final static Error_Message ERROR_3 = new Error_Message(3, "手工维护的收支计划存在问题");
}
