package com.leasing.common.utils.base;
import com.leasing.common.exception.BaseException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:Date日期处理工具类(读取当前系统日期,时间,传入年月日或传入string格式化时间等工具)
 **/
public class DateUtils {
    public static final String DEFAULT_FORMAT = "yyyy-MM-dd";
    static SimpleDateFormat defaultDateFormat = new SimpleDateFormat("yyyy-MM-dd");


    /**
     * getDate
     * 取系统日期(当前服务器时间)
     *
     * @return String
     */
    public static String getCurDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
    }

    public static String getCurDateTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
    }

    public static java.sql.Date getDate(int yyyy, int MM, int dd) {
        if (!verityDate(yyyy, MM, dd)) {
            throw new IllegalArgumentException("This is illegimate date!");
        } else {
            Calendar oneCalendar = Calendar.getInstance();
            oneCalendar.clear();
            oneCalendar.set(yyyy, MM - 1, dd);
            return new java.sql.Date(oneCalendar.getTime().getTime());
        }
    }

    public static boolean verityDate(int yyyy, int MM, int dd) {
        boolean flag = false;
        if (MM >= 1 && MM <= 12 && dd >= 1 && dd <= 31) {
            if (MM != 4 && MM != 6 && MM != 9 && MM != 11) {
                if (MM == 2) {
                    if ((yyyy % 100 == 0 || yyyy % 4 != 0) && yyyy % 400 != 0) {
                        if (dd <= 28) {
                            flag = true;
                        }
                    } else if (dd <= 29) {
                        flag = true;
                    }
                } else {
                    flag = true;
                }
            } else if (dd <= 30) {
                flag = true;
            }
        }

        return flag;
    }

    public static Date stringToDate(String strDate, String oracleFormat) {
        if (strDate == null) {
            return null;
        } else {
            Hashtable h = new Hashtable();
            String javaFormat = new String();
            String s = oracleFormat.toLowerCase();
            if (s.indexOf("yyyy") != -1) {
                h.put(new Integer(s.indexOf("yyyy")), "yyyy");
            } else if (s.indexOf("yy") != -1) {
                h.put(new Integer(s.indexOf("yy")), "yy");
            }

            if (s.indexOf("mm") != -1) {
                h.put(new Integer(s.indexOf("mm")), "MM");
            }

            if (s.indexOf("dd") != -1) {
                h.put(new Integer(s.indexOf("dd")), "dd");
            }

            if (s.indexOf("hh24") != -1) {
                h.put(new Integer(s.indexOf("hh24")), "HH");
            }

            if (s.indexOf("mi") != -1) {
                h.put(new Integer(s.indexOf("mi")), "mm");
            }

            if (s.indexOf("ss") != -1) {
                h.put(new Integer(s.indexOf("ss")), "ss");
            }

            int intStart;
            for (intStart = 0; s.indexOf("-", intStart) != -1; ++intStart) {
                intStart = s.indexOf("-", intStart);
                h.put(new Integer(intStart), "-");
            }

            for (intStart = 0; s.indexOf("/", intStart) != -1; ++intStart) {
                intStart = s.indexOf("/", intStart);
                h.put(new Integer(intStart), "/");
            }

            for (intStart = 0; s.indexOf(" ", intStart) != -1; ++intStart) {
                intStart = s.indexOf(" ", intStart);
                h.put(new Integer(intStart), " ");
            }

            for (intStart = 0; s.indexOf(":", intStart) != -1; ++intStart) {
                intStart = s.indexOf(":", intStart);
                h.put(new Integer(intStart), ":");
            }

            if (s.indexOf("年") != -1) {
                h.put(new Integer(s.indexOf("年")), "年");
            }

            if (s.indexOf("月") != -1) {
                h.put(new Integer(s.indexOf("月")), "月");
            }

            if (s.indexOf("日") != -1) {
                h.put(new Integer(s.indexOf("日")), "日");
            }

            if (s.indexOf("时") != -1) {
                h.put(new Integer(s.indexOf("时")), "时");
            }

            if (s.indexOf("分") != -1) {
                h.put(new Integer(s.indexOf("分")), "分");
            }

            if (s.indexOf("秒") != -1) {
                h.put(new Integer(s.indexOf("秒")), "秒");
            }

            String e;
            for (boolean i = false; h.size() != 0; javaFormat = e + javaFormat) {
                Enumeration df = h.keys();
                int myDate = 0;

                while (df.hasMoreElements()) {
                    int arg10 = ((Integer) df.nextElement()).intValue();
                    if (arg10 >= myDate) {
                        myDate = arg10;
                    }
                }

                e = (String) h.get(new Integer(myDate));
                h.remove(new Integer(myDate));
            }

            SimpleDateFormat arg11 = new SimpleDateFormat(javaFormat);
            new Date();

            try {
                Date arg12 = arg11.parse(strDate);
                return arg12;
            } catch (Exception arg9) {
                return null;
            }
        }
    }

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
            throw new BaseException("日期格式错误", String.valueOf(new Object[0]));
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

}