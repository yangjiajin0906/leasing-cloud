package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:
 **/
public class CalMethodEnum extends EnumType {
    public CalMethodEnum(int code, String label) {
        super(code, label);
    }

    /**
     * 计算过程以现金流为准,反写现金流中期数,投放日期,结束日期等参数
     */
    public static final CalMethodEnum ONCASHFLOW = new CalMethodEnum(0, "以现金流为准");

    /**
     * 重算现金流,并生成最新计算参数重新计算
     */
    public static final CalMethodEnum ONCALCULATOR = new CalMethodEnum(0, "以报价为准");
}