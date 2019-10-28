package com.leasing.common.utils.base;


import com.leasing.common.exception.BaseException;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:类型转换工具类 完成不同类型间的转换及判空处理
 **/
public class TypeCast {
    public static boolean isNull(String Content, String msg) throws BaseException {
        if (Content == null) {
            throw new BaseException("内部错误:", String.valueOf(new Object[] { msg }));
        } else if (Content.equals("")) {
            throw new BaseException("内部错误:", String.valueOf(new Object[] { msg }));
        } else {
            return true;
        }
    }

    public static boolean isNull(int Content, String msg) throws BaseException {
        if (Content == 0) {
            throw new BaseException("内部错误:", String.valueOf(new Object[] { msg }));
        } else {
            return true;
        }
    }

    public static boolean isNull(double Content, String msg) throws BaseException {
        if (Content == 0.0D) {
            throw new BaseException("内部错误:", String.valueOf(new Object[] { msg }));
        } else {
            return true;
        }
    }

    public static boolean isNull(long Content, String msg) throws BaseException {
        if (Content == 0L) {
            throw new BaseException("内部错误:", String.valueOf(new Object[] { msg }));
        } else {
            return true;
        }
    }

    public static boolean isNull(Object Content, String msg) throws BaseException {
        if (Content == null) {
            throw new BaseException("内容存在空值");
        } else {
            return true;
        }
    }

    public static String addBr(String Content) {
        if (Content == null) {
            return "";
        } else {
            String makeContent = new String();
            StringTokenizer strToken = new StringTokenizer(Content, "\n");

            while (strToken.hasMoreTokens()) {
                if (!makeContent.equals("")) {
                    makeContent = makeContent + "<br>" + strToken.nextToken();
                } else {
                    makeContent = makeContent + strToken.nextToken();
                }
            }

            return makeContent;
        }
    }

    public static Timestamp dateToDateTime(Date date) {
        return date == null ? null : new Timestamp(date.getTime());
    }

    public static Date dateTimeToDate(Timestamp dateTime) {
        return dateTime == null ? null : new Date(dateTime.getTime());
    }

    public static String toString(Object obj) {
        return obj == null ? "" : "" + obj.toString();
    }

    public static String toString(String para) {
        return stringToString(para);
    }

    public static String toString(int para) {
        return intToString(para);
    }

    public static String toString(long para) {
        return longToString(para);
    }

    public static String toString(double para) {
        return doubleToString(para);
    }

    public static String toString(Date para) {
        return simpleDateToString(para);
    }

    public static String toString(BigDecimal para) {
        return para != null ? para.toString() : "";
    }

    public static String toMoneyString(BigDecimal para) {
        return para != null ? para.setScale(2, 4).toString() : "";
    }

    public static BigDecimal toMoney(BigDecimal para) {
        return para != null ? para.setScale(2, 4) : null;
    }

    public static int stringToInt(String str, String paraName, boolean isCanNull) throws BaseException {
        if (str != null && !str.equals("")) {
            try {
                str = str.trim();
                return Integer.parseInt(str);
            } catch (NumberFormatException arg3) {
                throw new BaseException("内部错误:", String.valueOf(new Object[] { paraName }));
            }
        } else if (isCanNull) {
            return Integer.MIN_VALUE;
        } else {
            throw new BaseException("内部错误:", String.valueOf(new Object[] { paraName }));
        }
    }

    public static double stringToDouble(String str, String paraName, boolean isCanNull) throws BaseException {
        if (str != null && !str.equals("")) {
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException arg3) {
                throw new BaseException("内部错误:", String.valueOf(new Object[] { paraName }));
            }
        } else if (isCanNull) {
            return -1.0E-10D;
        } else {
            throw new BaseException("内部错误:", String.valueOf(new Object[] { paraName }));
        }
    }

    public static Date stringToDate(String strDate, String paraName, boolean isCanNull) throws BaseException {
        Date targetDate = null;
        if (strDate != null && !strDate.equals("")) {
            if (strDate.indexOf("-") == -1) {
                throw new BaseException("日期格式不正确:", String.valueOf(new Object[] { paraName }));
            } else {
                try {
                    int yyyy = Integer.parseInt(strDate.substring(0, strDate.indexOf("-")));
                    int MM = Integer.parseInt(strDate.substring(strDate.indexOf("-") + 1, strDate.lastIndexOf("-")));
                    int dd = Integer.parseInt(strDate.substring(strDate.lastIndexOf("-") + 1, strDate.length()));
                    targetDate = DateUtils.getDate(yyyy, MM, dd);
                    return targetDate;
                } catch (NumberFormatException arg7) {
                    throw new BaseException("内部错误:", String.valueOf(new Object[] { paraName }));
                } catch (IllegalArgumentException arg8) {
                    throw new BaseException("内部错误:", String.valueOf(new Object[] { paraName }));
                }
            }
        } else if (isCanNull) {
            return null;
        } else {
            throw new BaseException("内部错误:", String.valueOf(new Object[] { paraName }));
        }
    }

    private static String intToString(int para) {
        return "" + para;
    }

    private static String doubleToString(double para) {
        DecimalFormat nf = new DecimalFormat("###.##");
        String strValue = nf.format(para);
        if (strValue.indexOf(".") == -1) {
            strValue = strValue + ".00";
        } else if (strValue.substring(strValue.indexOf(".") + 1).length() == 1) {
            strValue = strValue + "0";
        }

        return strValue;
    }

    private static String simpleDateToString(Date date) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            return format.format(date);
        }
    }

    public static String dateTimeToString(Date date) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return format.format(date);
        }
    }

    private static String stringToString(String strSource, String paraName, boolean isCanNull)
            throws BaseException {
        if (strSource == null) {
            if (isCanNull) {
                return "";
            } else {
                throw new BaseException("内部错误:", String.valueOf(new Object[] { paraName }));
            }
        } else {
            return strSource;
        }
    }

    private static String stringToString(String strSource) {
        return strSource == null ? "" : strSource;
    }

    private static long stringToLong(String str, String paraName, boolean isCanNull) throws BaseException {
        if (str != null && !str.equals("")) {
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException arg3) {
                throw new BaseException("内部错误:", String.valueOf(new Object[] { paraName }));
            }
        } else if (isCanNull) {
            return Long.MIN_VALUE;
        } else {
            throw new BaseException("内部错误:", String.valueOf(new Object[] { paraName }));
        }
    }

    private static String longToString(long para) {
        return "" + para;
    }

    public static String notMoneyDoubleToString(double para) {
        return "" + para;
    }

    private static String moneyDoubleToString(double para) {
        return doubleToString(para);
    }

    public static String objToString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static String array2String(String[] array, String separator) {
        StringBuffer ret = new StringBuffer("");
        if (array != null && array.length > 0) {
            for (int i = 0; i < array.length; ++i) {
                ret.append(separator).append(array[i]);
            }

            return ret.substring(separator.length());
        } else {
            return "";
        }
    }

    public static String month2YearMonth(Integer month) {
        String yearMonth = "";
        boolean smonth = false;
        boolean year = false;
        boolean rmonth = false;
        if (month != null && !month.equals(new Integer("0"))) {
            int smonth1 = month.intValue();
            int year1 = smonth1 / 12;
            int rmonth1 = smonth1 - 12 * year1;
            if (year1 > 0) {
                yearMonth = intToString(year1) + "年";
            }

            if (rmonth1 > 0) {
                yearMonth = yearMonth + intToString(rmonth1) + "个月";
            }

            return yearMonth;
        } else {
            return "0月";
        }
    }

    public static String period2YearMonth(String ym) {
        if (ym == null) {
            return "";
        } else {
            String year = ym.substring(0, 4);
            String month = ym.substring(4, 6);
            return year + "年" + month + "月";
        }
    }

    public static String period2YearMonthDay(String ym) {
        if (ym == null) {
            return "";
        } else {
            String year = ym.substring(0, 4);
            String month = ym.substring(5, 7);
            String day = ym.substring(8, 10);
            return year + "年" + month + "月" + day + "日";
        }
    }

    public static String addYear(String grade) {
        return grade == null ? "" : grade + "年";
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

    public static Short obj2Short(Object obj) {
        if (obj == null) {
            return Short.valueOf("0");
        } else {
            try {
                return obj instanceof Short ? (Short) obj
                        : (obj instanceof String ? new Short((String) obj)
                        : (obj instanceof BigDecimal ? new Short(((BigDecimal) obj).shortValue())
                        : Short.valueOf("0")));
            } catch (Exception arg1) {
                return Short.valueOf("0");
            }
        }
    }

    public static Integer obj2Integer(Object obj) {
        if (obj == null) {
            return Integer.valueOf("0");
        } else {
            try {
                return obj instanceof Integer ? (Integer) obj
                        : (obj instanceof String ? new Integer((String) obj)
                        : (obj instanceof BigDecimal ? new Integer(((BigDecimal) obj).intValue())
                        : Integer.valueOf("0")));
            } catch (Exception arg1) {
                return Integer.valueOf("0");
            }
        }
    }

    public static String convertToChineseNumber(double number) {
        StringBuffer chineseNumber = new StringBuffer();
        String[] num = new String[] { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
        String[] unit = new String[] { "分", "角", "圆", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "万" };
        String tempNumber = String.valueOf(Math.round(number * 100.0D));
        int tempNumberLength = tempNumber.length();
        if ("0".equals(tempNumber)) {
            return "零圆整";
        } else {
            if (tempNumberLength > 15) {
                try {
                    throw new Exception("超出转化范围.");
                } catch (Exception arg9) {
                    arg9.printStackTrace();
                }
            }

            boolean preReadZero = true;

            for (int i = tempNumberLength; i > 0; --i) {
                if ((tempNumberLength - i + 2) % 4 == 0) {
                    if (i - 4 >= 0 && "0000".equals(tempNumber.substring(i - 4, i))) {
                        if (!preReadZero) {
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
                    if (!preReadZero) {
                        chineseNumber.insert(0, "零");
                        preReadZero = true;
                    }

                    if ((tempNumberLength - i + 2) % 4 == 0) {
                        chineseNumber.insert(0, unit[tempNumberLength - i]);
                    }
                } else {
                    chineseNumber.insert(0, num[digit] + unit[tempNumberLength - i]);
                    preReadZero = false;
                }
            }

            if (tempNumberLength - 2 >= 0
                    && "00".equals(tempNumber.substring(tempNumberLength - 2, tempNumberLength))) {
                chineseNumber.append("整");
            }

            return chineseNumber.toString();
        }
    }

    public static String number2BigRMB(double sum) {
        String[] numeral = new String[] { "十", "百", "千" };
        String[] bigNumeral = new String[] { "亿", "万" };
        String[] measure = new String[] { "元", "角", "分" };
        String[] numbers = new String[] { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
        StringBuffer result = new StringBuffer();
        int digit = 0;

        for (double loop = sum; loop >= 1.0D; loop /= 10.0D) {
            ++digit;
        }

        int arg17 = 0;

        int srcLoop;
        for (srcLoop = digit - 4; srcLoop > 0; srcLoop -= 4) {
            ++arg17;
        }

        srcLoop = arg17;

        for (boolean acrossLoopZeroFlag = true; arg17 >= 0; --arg17) {
            int df = (int) (sum / Math.pow(10000.0D, (double) arg17));
            sum %= Math.pow(10000.0D, (double) arg17);
            int floatStr = 0;

            for (double floatPart = (double) df; floatPart >= 1.0D; floatPart /= 10.0D) {
                ++floatStr;
            }

            if (floatStr < 4 && srcLoop != arg17 && acrossLoopZeroFlag) {
                result.append(numbers[0]);
                acrossLoopZeroFlag = false;
            } else {
                acrossLoopZeroFlag = true;
            }

            boolean arg20 = true;
            if (arg17 > 0) {
                arg20 = false;
            }

            boolean jiao = true;
            if (df == 0) {
                jiao = false;
            }

            boolean fen = false;

            for (int i = (int) Math.pow(10.0D, (double) (floatStr - 1)); i >= 1; --floatStr) {
                int doubleNumber = df / i;
                if (doubleNumber > 0) {
                    if (fen) {
                        result.append(numbers[0]);
                        fen = false;
                    }

                    result.append(numbers[doubleNumber]);
                    if (floatStr == 1) {
                        if (arg20) {
                            result.append(measure[0]);
                        } else {
                            result.append(bigNumeral[arg17 % 2]);
                        }
                    } else {
                        result.append(numeral[floatStr - 2]);
                    }
                } else if (floatStr == 1) {
                    if (arg20) {
                        result.append(measure[0]);
                    } else if (jiao) {
                        result.append(bigNumeral[arg17 % 2]);
                    }
                } else {
                    fen = true;
                }

                df %= i;
                i /= 10;
            }
        }

        DecimalFormat arg18 = new DecimalFormat("#.##");
        String arg19 = arg18.format(sum);
        arg19 = arg19.substring(arg19.indexOf(".") + 1);
        int arg21 = Integer.parseInt(arg19);
        int arg22 = arg21 / 10;
        int arg23 = arg21 % 10;
        if (arg22 > 0) {
            result.append(numbers[arg22]);
            result.append(measure[1]);
        }

        if (arg23 > 0) {
            result.append(numbers[arg23]);
            result.append(measure[2]);
        }

        return result.toString();
    }
}