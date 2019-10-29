package com.leasing.common.utils.base;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:年化时间按360天一年处理工具类
 **/
class CDate {
    public CDate() {
    };

    int year;
    int month;
    int day;

    @Override
    public String toString() {
        return String.format("%d-%d-%d", year, month, day);
    }
}

public class Days360 {
    public Days360() {
    }

    static DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args) {
        String [][] dates = {
                {"2011-2-27","2011-3-29"},
                {"2011-2-27","2011-3-30"},
                {"2011-2-27","2011-3-31"},
                {"2011-2-27","2011-4-1"},
                {"2011-2-27","2011-4-2"},
                {"2011-2-28","2011-3-29"},
                {"2011-2-28","2011-3-31"},
                {"2011-2-28","2011-4-1"},
                {"2011-2-28","2011-4-2"},
                {"2011-3-1","2011-4-1"},
                {"2011-3-2","2011-4-2"},
                {"2011-3-3","2011-4-2"},
                {"2011-3-3","2011-4-2"},
                {"2011-2-27","2012-3-30"},
                {"2011-2-27","2012-3-31"},
                {"2011-2-28","2012-3-30"},
                {"2011-2-28","2012-3-31"},

        };
        String [][]date1s = {
                {"2011-1-1","2011-1-31"},
                {"2011-2-1","2011-2-28"},
                {"2011-4-1","2011-4-30"},
                {"2011-5-1","2011-5-15"},
                {"2011-5-5","2011-5-31"},
                {"2011-6-15","2011-6-30"},
                {"2012-2-1","2012-2-29"},
                {"2012-2-12","2012-2-29"},
                {"2011-2-12","2011-2-28"},
                {"2012-2-12","2012-2-28"},
        };
        String [][]date2s = {
                {"2011-1-1","2011-2-3"},
                {"2011-1-1","2011-2-28"},
                {"2011-1-25","2011-3-1"},
                {"2011-1-4","2011-4-4"},
                {"2011-2-1","2011-3-1"},
                {"2011-2-15","2011-5-15"},
                {"2011-2-28","2011-3-1"},
                {"2012-1-1","2012-2-3"},
                {"2012-1-1","2012-2-29"},
                {"2012-2-1","2012-3-1"},
                {"2012-2-15","2012-5-15"},
                {"2012-2-29","2012-3-1"},

        };
        String [][]date3s = {
                {"2010-1-1","2011-1-1"},
                {"2009-1-1","2011-1-15"},
                {"2010-1-1","2011-2-28"},
                {"2010-12-5","2012-2-19"},
                {"2011-2-28","2012-2-29"},
                {"2011-2-15","2013-3-1"},
                {"2009-1-23","2012-12-24"},
                {"1900-1-1","2000-12-24"},
                {"1904-8-26","2400-3-1"},
                {"2012-1-1","2012-1-31"},
                {"2012-12-1","2012-12-31"},
                {"2012-12-1","2013-1-1"},
                {"2012-12-1","2013-1-2"},
                {"2012-1-1","2013-12-31"},
                {"2012-1-1","2012-12-31"},
                {"2012-1-1","2013-1-1"}

        };
            /*for(String[] d : date3s) {
                long r = days360(d[0], d[1]);
                long r1 = days360(d[1], d[0]);
                System.out.println(String.format("%d,%d", r,r1));
            }*/

        System.out.println(days360("2012-02-29","2012-02-28"));


        System.out.println();
    }

    /**
     * 计算两个日期之间的天数
     * @param d0 String(YYYY-MM-DD) 起日
     * @param d1 String(YYYY-MM-DD) 止日
     * @return
     * @throws ParseException
     */
    public static int days360(String d0, String d1)  {
        Date date0 = null;
        Date date1 = null;
        try {
            date0 = format.parse(d0);
        } catch ( ParseException e) {
            e.printStackTrace();
            //throw new BusinessException("日期格式错误：" + d0);
        }
        try {
            date1 = format.parse(d1);
        } catch ( ParseException e) {
            e.printStackTrace();
            //throw new BusinessException("日期格式错误：" + d1);
        }
        int result = (int)days360(date0,date1);
        // 当终止日期大于等于初始日期时，如果结果为负数，则置为0。bug74
        if(date1.compareTo(date0) >= 0
                && result < 0){
            result = 0;
        }
        return result;

    }

    /**
     * 计算两个日期之间的天数
     * @param d0 Date 起日
     * @param d1 Date 止日
     * @return
     */
    public static long days360(Date d0, Date d1) {
        CDate start = getStartingDate(d0);
        CDate end = getEndingDateAccordingToStartingDate(d1, d0);
        //System.out.println(String.format("%s %s", start, end));
        long startingDay = start.month * 30 + start.day;
        long endingDay = (end.year - start.year) * 360 + end.month * 30 + end.day;
        return (endingDay - startingDay);
    }

    private static Calendar getDate(Date date) {
        Calendar processedDate = new GregorianCalendar();
        processedDate.setTime(date);
        return processedDate;
    }

    private static CDate getStartingDate(Date date) {
        CDate sd = new CDate();
        Calendar startingDate = getDate(date);
        sd.year = startingDate.get(Calendar.YEAR);
        sd.month = startingDate.get(Calendar.MONTH);
        if (isLastDayOfMonth(startingDate)) {
            sd.day = 30;
        } else {
            sd.day = startingDate.get(Calendar.DATE);
        }
        return sd;
    }

    private static CDate getEndingDateAccordingToStartingDate(Date date, Date startDate) {
        CDate ed = new CDate();
        Calendar endingDate = getDate(date);
        Calendar startingDate = getDate(startDate);
        if (endingDate.get(Calendar.DAY_OF_MONTH) <= 30) {
            ed.year = endingDate.get(Calendar.YEAR);
            ed.month = endingDate.get(Calendar.MONTH);
            ed.day = endingDate.get(Calendar.DAY_OF_MONTH);
        } else if (isLastDayOfMonth(endingDate) ) {
            if (isLastDayOfMonth(startingDate) ) {
                ed.year = endingDate.get(Calendar.YEAR);
                ed.month = endingDate.get(Calendar.MONTH);
                ed.day = 30;
            } else {
                Calendar newEndingDate = getFirstDayOfNextMonth(endingDate);
                ed.year = newEndingDate.get(Calendar.YEAR);
                ed.month = newEndingDate.get(Calendar.MONTH);
                ed.day = newEndingDate.get(Calendar.DAY_OF_MONTH);
            }
        } else {

        }


        return ed;
    }

    private static boolean isLastDayOfMonth(Calendar date) {
        Calendar clone = (Calendar) date.clone();
        clone.add(Calendar.MONTH, 1);
        clone.set(Calendar.DATE, 1);
        clone.add(Calendar.DATE, -1);
        int lastDayOfMonth = clone.get(5);
        return date.get(5) == lastDayOfMonth;
    }

    private static Calendar getFirstDayOfNextMonth(Calendar date) {
        Calendar newDate = (Calendar) date.clone();
        if (date.get(Calendar.MONTH) < 11) {
            newDate.set(Calendar.MONTH, date.get(Calendar.MONTH) + 1);
        } else {
            newDate.set(Calendar.MONTH, 0);
            newDate.set(Calendar.YEAR, date.get(Calendar.YEAR) + 1);
        }
        newDate.set(Calendar.DATE, 1);
        return newDate;
    }
}