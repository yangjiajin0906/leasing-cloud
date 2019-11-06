package com.leasing.calculate.utils;

import com.leasing.common.utils.base.BigDecimalUtils;
import io.micrometer.core.instrument.util.StringUtils;

import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/10/31
 * @author:Yjj@yonyou.com
 * @description: 计税工具类
 **/
public class CalTaxUtil {
    /**
     * Description: 枚举到税率的转换<br>
     *
     * @return
     * @author: kehy<br>
     * @Date：2014-3-13
     */
    public static BigDecimal enum2Rate(Short value) {
        //String enum_name = DocumentConvertUtil.convertEnum(value, EnumsByDBConstantUtils.SRVICE_TAX_PAY);
        String enum_name = null;
        if (StringUtils.isBlank(enum_name)) {
            return BigDecimal.ZERO;
        }
        enum_name = enum_name.replace("%", "");
        BigDecimal rlt = new BigDecimal(enum_name);
        rlt = rlt.divide(BigDecimalUtils.N100, BigDecimalUtils.MATHCONTEXT_16);
        return rlt;
    }
}