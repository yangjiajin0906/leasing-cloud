package com.leasing.communication.calculate.utils;

import com.leasing.communication.common.enums.constant.ParamValueConstant;

import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/10/30
 * @author:Yjj@yonyou.com
 * @description:
 **/
public class PublicBOUtils {
    /**
     *
     * 税率 转换
     *
     */
    public static BigDecimal getTaxRate(Short TaxRateShort) {
        return ParamValueConstant.MULTIPLY_TAX;
    }

}