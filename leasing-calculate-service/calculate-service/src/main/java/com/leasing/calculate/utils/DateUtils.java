package com.leasing.calculate.utils;

import com.leasing.calculate.Exception.BusinessException;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @project:leasing-cloud 日期转换格式工具类
 * @date:2019/10/11
 * @author:Yjj@yonyou.com
 * @description:
 **/
public class DateUtils {
    public static final String DEFAULT_FORMAT = "yyyy-MM-dd";
    static SimpleDateFormat defaultDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static int getInterval(String beginStr, String endStr) {
        return getInterval(beginStr, endStr, "yyyy-MM-dd");
    }

    public static int getInterval(String beginStr, String endStr, String formatStr) {
        Date begin = parseDate(beginStr, formatStr);
        Date end = parseDate(endStr, formatStr);
        return getInterval(begin, end);
    }

    public static int getInterval(Date begin, Date end) {
        return (new Long((begin.getTime() - end.getTime()) / 86400000L)).intValue();
    }

    public static Date firstDateOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(5, cal.getActualMinimum(5));
        return cal.getTime();
    }

    public static Date lastDateOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(5, cal.getActualMaximum(5));
        return cal.getTime();
    }

    public static Date firstDateOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(2, cal.getActualMinimum(2));
        cal.set(5, cal.getActualMinimum(5));
        return cal.getTime();
    }

    public static Date lastDateOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(2, cal.getActualMaximum(2));
        cal.set(5, cal.getActualMaximum(5));
        return cal.getTime();
    }

    public static Date addMonth(String dateStr, int interval) {
        Date date = parseDate(dateStr);
        return addMonth(date, interval);
    }

    public static Date addMonth(Date date, int interval) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(2, interval);
        return cal.getTime();
    }

    public static Date addYear(Date date, int interval) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(1, interval);
        return cal.getTime();
    }

    public static int compare(String dateStr1, String dateStr2) {
        return compare(dateStr1, dateStr2, "yyyy-MM-dd");
    }

    public static int compare(String dateStr1, String dateStr2, String formatStr) {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        Date date1 = null;
        Date date2 = null;

        try {
            date1 = format.parse(dateStr1);
            date2 = format.parse(dateStr2);
        } catch (ParseException arg6) {
            arg6.printStackTrace();
            throw new RuntimeException(arg6);
        }

        return compare(date1, date2);
    }

    public static int compare(Date date1, Date date2) {
        return date1.before(date2) ? -1 : (date1.after(date2) ? 1 : 0);
    }

    public static Date parseDate(String dateStr) {
        return parseDate(dateStr, "yyyy-MM-dd");
    }

    public static UFDate getUFDate(String dateStr) {
        try {
            Date e = defaultDateFormat.parse(dateStr);
            return new UFDate(e);
        } catch (ParseException arg1) {
            throw new BusinessException("日期格式错误", new Object[0]);
        }
    }

    public static Date parseDate(String dateStr, String formatStr) {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);

        try {
            return format.parse(dateStr);
        } catch (ParseException arg3) {
            arg3.printStackTrace();
            return null;
        }
    }

    public static String formatDate(Date date) {
        return formatDate(date, "yyyy-MM-dd");
    }

    public static String formatDate(Date date, String formatStr) {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        return format.format(date);
    }

    public static void main(String[] args) {
        System.out.println(getUFDate("2012/02/32"));
        System.out.println((new BigDecimal("1")).add(new BigDecimal("2")).divide(new BigDecimal("3"), 2, 4));
    }
}