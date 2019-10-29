package com.leasing.common.utils.base;

import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:文档生成数据集定义中,数据转换格式化 完成数字金额转换成大写工具类
 **/
public class DocumentConvertUtil {
    //金额转换成大写
    public static String convertAmt(BigDecimal amount) {
        String amt = "";
        if (amount != null) {
            if (amount.doubleValue() < 0) {
                amt = "负 "+convertToChineseNumber(amount.abs().doubleValue());
                return amt;
            }
            amt = convertToChineseNumber(amount.doubleValue());
        }
        return amt;
    }

    public static String convertToChineseNumber(double number) {
        StringBuffer chineseNumber = new StringBuffer();
        String[] num = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
        String[] unit = { "分", "角", "圆", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "万" };
        String tempNumber = String.valueOf(Math.round(number * 100.0D));
        int tempNumberLength = tempNumber.length();
        if ("0".equals(tempNumber)) {
            return "零圆整";
        }
        if (tempNumberLength > 15){
            try {
                throw new Exception("超出转化范围.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        boolean preReadZero = true;
        for (int i = tempNumberLength; i > 0; --i) {
            if ((tempNumberLength - i + 2) % 4 == 0) {
                if ((i - 4 >= 0) && ("0000".equals(tempNumber.substring(i - 4, i)))) {
                    if (!(preReadZero)) {
                        chineseNumber.insert(0, "零");
                        preReadZero = true;
                    }
                    i -= 3;
                    continue;
                }

                preReadZero = true;
            }
            int digit = Integer.parseInt(tempNumber.substring(i - 1, i));
            if (digit == 0) {
                if (!(preReadZero)) {
                    chineseNumber.insert(0, "零");
                    preReadZero = true;
                }

                if ((tempNumberLength - i + 2) % 4 != 0)
                    continue;
                chineseNumber.insert(0, unit[(tempNumberLength - i)]);
            } else {
                chineseNumber.insert(0, num[digit] + unit[(tempNumberLength - i)]);
                preReadZero = false;
            }
        }

        if ((tempNumberLength - 2 >= 0)
                && ("00".equals(tempNumber.substring(tempNumberLength - 2, tempNumberLength)))) {
            chineseNumber.append("整");
        }
        return chineseNumber.toString();
    }
}