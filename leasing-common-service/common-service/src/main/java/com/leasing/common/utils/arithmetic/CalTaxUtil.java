package com.leasing.common.utils.arithmetic;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import com.leasing.common.enums.constant.EnumsByDBConstantUtils;
import com.leasing.common.utils.base.BigDecimalUtils;
import com.leasing.common.utils.base.ObjectUtil;
import com.leasing.common.utils.tools.DocumentConvertUtil;
import org.apache.commons.lang.StringUtils;

/**
 * Title: 融资租赁管理系统<br>
 * Description: 计税工具类<br>
 * Copyright: Copyright (c) 2013<br>
 * Company: Yonyou Financial<br>
 */
public class CalTaxUtil {

    /**
     * Description: 枚举到税率的转换<br>
     *
     * @return
     * @author: kehy<br>
     * @Date：2014-3-13
     */
    public static BigDecimal enum2Rate(Short value) {
        String enum_name = DocumentConvertUtil.convertEnum(value, EnumsByDBConstantUtils.SRVICE_TAX_PAY);
        if (StringUtils.isBlank(enum_name)) {
            return BigDecimal.ZERO;
        }
        enum_name = enum_name.replace("%", "");
        BigDecimal rlt = new BigDecimal(enum_name);
        rlt = rlt.divide(BigDecimalUtils.N100, BigDecimalUtils.MATHCONTEXT_16);
        return rlt;
    }

    /**
     * 计算税公式（税率为参数） 公式：税额=金额*参数/（1+参数）
     *
     * @param bd
     *            需要算税的金额
     * @param tax_rate
     *            税率
     * @param diag
     *            计算精度
     */
    public static BigDecimal calSrvOutTax(BigDecimal bd, BigDecimal tax_rate, int diag) {
        if (bd == null || tax_rate == null) {
            return bd;
        }
        return bd.divide(tax_rate.add(BigDecimal.ONE), MathContext.DECIMAL64).multiply(tax_rate, MathContext.DECIMAL64)
                .setScale(diag, RoundingMode.HALF_UP);
    }

    /**
     * Description: 根据设置的枚举置计算税<br>
     *
     * @param value
     *            枚举值
     * @param bd
     *            需要算税的金额
     * @param diag
     *            舍入位数
     * @return 税额
     * @author: kehy<br>
     * @Date：2014-3-13
     */
    public static BigDecimal calTaxByEnum(Short value, BigDecimal bd, int diag) {
        BigDecimal rate = enum2Rate(value);
        return calSrvOutTax(bd, rate, diag);
    }

    /**
     * Description: 根据设置的枚举置计算税<br>
     * 舍入位数为两位
     *
     * @param value
     *            枚举值
     * @param bd
     *            需要算税的金额
     * @return 税额
     * @author: kehy<br>
     * @Date：2014-3-13
     */
    public static BigDecimal calTaxByEnum(Short value, BigDecimal bd) {
        BigDecimal rate = enum2Rate(value);
        return calSrvOutTax(bd, rate, 2);
    }

    public static BigDecimal calTaxByShort(Short value) {
        BigDecimal tax = BigDecimal.ZERO;
        if (Short.valueOf("0").equals(value)) {
            tax = ObjectUtil.toBigDecimal("0.03");
        } else if (Short.valueOf("1").equals(value)) {
            tax = ObjectUtil.toBigDecimal("0.06");
        } else if (Short.valueOf("2").equals(value)) {
            tax = ObjectUtil.toBigDecimal("0.17");
        } else if (Short.valueOf("3").equals(value)) {
        } else if (Short.valueOf("4").equals(value)) {
            tax = ObjectUtil.toBigDecimal("0.11");
        }else if (Short.valueOf("5").equals(value)) {
            tax = ObjectUtil.toBigDecimal("0.16");
        }else if (Short.valueOf("6").equals(value)) {
            tax = ObjectUtil.toBigDecimal("0.10");
        }else if(Short.valueOf("7").equals(value)){
            //税改增加 13% 税率
            tax = ObjectUtil.toBigDecimal("0.13");

        }
        return tax;
    }

}
