package com.leasing.calculate.utils;

import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/10/10
 * @author:Yjj@yonyou.com
 * @description:
 **/
public class TypeCast {
    public static String toString(Object obj) {
        return obj == null ? "" : "" + obj.toString();
    }

    public static BigDecimal obj2BigDecimal(Object obj) {
        if (obj == null) {
            return BigDecimal.valueOf(0L);
        } else {
            try {
                return obj instanceof BigDecimal ? (BigDecimal) obj
                        : (obj instanceof String ? new BigDecimal((String) obj) : BigDecimal.valueOf(0L));
            } catch (Exception arg1) {
                return BigDecimal.valueOf(0L);
            }
        }
    }
}