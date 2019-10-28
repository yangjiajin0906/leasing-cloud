package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:最后一期收租计算规则
 **/
public class Last_Term_Rule extends EnumType {

    public Last_Term_Rule(int code, String label) {
        super(code, label);
    }

    /** 重算利息-0 */
    public final static Last_Term_Rule RE_INTEREST = new Last_Term_Rule(0, "重算利息");
    /** 重算租金-1 */
    public final static Last_Term_Rule RE_RENT = new Last_Term_Rule(1, "重算租金");
}
