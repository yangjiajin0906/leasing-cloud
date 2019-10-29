package com.leasing.common.utils.base;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:Object工具类 完成不同引用数据类型间的转换 或 转化成相应实体类
 **/
public class ObjectUtil {
    /**
     * Object 是否是null或者是""
     */
    public static boolean isEmpty(Object obj) {
        return (obj == null || StringUtils.isEmpty(obj.toString()));
    }

    /**
     * Object转String
     */
    public static String toString(Object obj) {
        return isEmpty(obj)?"":obj.toString();
    }

    /**
     * Object转int
     */
    public static int toInteger(Object obj) {
        return isEmpty(obj)?0:Integer.parseInt(obj.toString());
    }
    /**
     * Object转int
     */
    public static Integer toIntegerNull(Object obj) {
        return isEmpty(obj)?null:Integer.parseInt(obj.toString());
    }
    /**
     * Object转Long
     */
    public static Long toLong(Object obj) {
        return isEmpty(obj)?null:Long.valueOf(obj.toString());
    }

    /**
     * Object转Short
     */
    public static Short toShort(Object obj) {
        return isEmpty(obj)?null:Short.valueOf(obj.toString());
    }
    /**
     * Object 来转换BigDecimal如果空值 则返回0
     */
    public static BigDecimal toBigDecimal(Object obj) {
        return isEmpty(obj)?BigDecimal.ZERO:new BigDecimal(obj.toString());
    }

    /**
     * subtract
     */
    public static BigDecimal subtract(Object obj1,Object obj2) {
        return toBigDecimal(obj1).subtract(toBigDecimal(obj2));
    }

    /**
     * add
     */
    public static BigDecimal add(Object obj1,Object obj2) {
        return toBigDecimal(obj1).add(toBigDecimal(obj2));
    }

    /**
     * divide
     */
    public static BigDecimal divide(Object obj1,Object obj2, int scale, int roundingMode) {
        return toBigDecimal(obj1).divide(toBigDecimal(obj2), scale, roundingMode);
    }

    /**
     * multiply
     */
    public static BigDecimal multiply(Object obj1,Object obj2) {
        return toBigDecimal(obj1).multiply(toBigDecimal(obj2));
    }

    /**
     * Object转Boolean
     * @param obj
     * @return
     */
    public static boolean toBoolean(Object obj) {
        return Boolean.valueOf(toString(obj));
    }

    /**
     * Object转Double
     * @return
     */
    public static double toDouble(Object obj) {
        return toBigDecimal(obj).doubleValue();
    }

    /**
     * Object转Date
     */
    public static Date toDate(Object obj,String format) {
        return DateUtils.stringToDate(obj.toString(), format);
    }

    /**
     * 转锟斤拷为Map
     *
     * @param model 模型
     */
    public static Map<String, Object> toMap(Object model) {
        Map<String, Object> map = new HashMap<String, Object>();
        final Method[] methods = model.getClass().getMethods();
        for (Method method : methods) {
            if(method.getParameterTypes() != null && method.getParameterTypes().length !=0 ) continue;
            final String methodName = method.getName();
            if (methodName.startsWith("get") && methodName.length() > 3 && !"getClass".equals(methodName)
                    && !"getValue".equals(methodName) && !"getPrimaryKey".equals(methodName)) {
                final String fieldName = getGeneralField(methodName);

                Object value = null;
                try {
                    System.out.println(method.getName());
                    value = method.invoke(model);
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
                if (value != null) {
                    map.put(fieldName, value);
                }
            }

        }

        return map;
    }

    /**
     * 转锟斤拷为Map
     *
     * @param model 模型
     */
    public static Map<String, Object> toMap(Object model,List flters) {
        Map<String, Object> map = new HashMap<String, Object>();
        final Method[] methods = model.getClass().getMethods();
        for (Method method : methods) {
            if(method.getParameterTypes() != null && method.getParameterTypes().length !=0 ) continue;
            final String methodName = method.getName();
            if (methodName.startsWith("get") && methodName.length() > 3 && !"getClass".equals(methodName)
                    && !"getValue".equals(methodName) && !"getPrimaryKey".equals(methodName)
                    && (flters == null || !flters.contains(method.getName()))) {
                final String fieldName = getGeneralField(methodName);

                Object value = null;
                try {
                    System.out.println(method.getName());
                    value = method.invoke(model);
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
                if (value != null) {
                    map.put(fieldName, value);
                }
            }

        }

        return map;
    }

    /**
     * 转锟斤拷为Map
     *
     * @param model 模型
     */
    public static Map<String, Object> toContainsMap(Object model,List contains) {
        Map<String, Object> map = new HashMap<String, Object>();
        final Method[] methods = model.getClass().getMethods();
        for (Method method : methods) {
            if(method.getParameterTypes() != null && method.getParameterTypes().length !=0 ) continue;
            final String methodName = method.getName();
            if (methodName.startsWith("get") && methodName.length() > 3 && !"getClass".equals(methodName)
                    && !"getValue".equals(methodName) && !"getPrimaryKey".equals(methodName)
                    && (contains == null || contains.contains(method.getName()))) {
                final String fieldName = getGeneralField(methodName);

                Object value = null;
                try {
                    System.out.println(method.getName());
                    value = method.invoke(model);
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
                if (value != null) {
                    map.put(fieldName, value);
                }
            }

        }

        return map;
    }


    /**
     * 转锟斤拷为Map
     *
     * @param
     */
//    public static Map<String, Object> toMap(Object model,String[] strs) {
//        List flters = null;
//        if(strs != null ){
//            flters = Arrays.asList(strs);
//        }
//        Map<String, Object> map = new HashMap<String, Object>();
//        final Method[] methods = model.getClass().getMethods();
//        for (Method method : methods) {
//            if(method.getParameterTypes() != null && method.getParameterTypes().length !=0 ) continue;
//            final String methodName = method.getName();
//            if (methodName.startsWith("get") && methodName.length() > 3 && !"getClass".equals(methodName)
//                    && !"getValue".equals(methodName) && !"getPrimaryKey".equals(methodName)
//                    && (flters == null || !flters.contains(method.getName()))) {
//                final String fieldName = getGeneralField(methodName);
//
//                Object value = null;
//                try {
//                    System.out.println(method.getName());
//                    value = method.invoke(model);
//                    if(value instanceof nc.vo.pub.lang.UFDate){
//                        nc.vo.pub.lang.UFDate date = ((nc.vo.pub.lang.UFDate)value);
//                        value = date.toString();
//                        if(value != null){
//                            map.put(fieldName+"_year", date.getYear());
//                            map.put(fieldName+"_month", date.getMonth());
//                            map.put(fieldName+"_day", date.getDay());
//                        }
//                    }
//                    if(value instanceof nc.vo.pub.lang.UFDouble){
//
//                        nc.vo.pub.lang.UFDouble amount = (nc.vo.pub.lang.UFDouble)value;
//                        BigDecimal amountNum = new BigDecimal(amount.toString());
//                        int numScale = 2;
//                        if(fieldName.toLowerCase().contains("excrate")) {
//                            numScale = 6;
//                        }
//                        value = amount.abs().setScale(numScale, nc.vo.pub.lang.UFDouble.ROUND_HALF_UP).toString();
//                        String str = "";
//                        if(amount.compareTo(new nc.vo.pub.lang.UFDouble(0)) != 0){
//                            str = value.toString().replace(".", "");
//                            String CN = DocumentConvertUtil.convertAmt(new BigDecimal(amount.toString()).setScale(numScale));
//                            map.put(fieldName+"_CN", CN);
//                        }
//                        int size = 11-str.length();
//                        for (int i = 0; i < size; i++) {
//                            str = " "+ str;
//                        }
//                        map.put(fieldName+"_str", str);
//                    }
//                } catch (Exception e) {
//                    throw new RuntimeException(e.getMessage(), e);
//                }
//                if (value != null) {
//                    map.put(fieldName, value);
//                }
//            }
//
//        }
//
//        return map;
//    }

    private static String getGeneralField(String getOrSetMethodName) {
        if (getOrSetMethodName == null) {
            return null;
        }


        if (getOrSetMethodName.startsWith("get") || getOrSetMethodName.startsWith("set")) {
            if (getOrSetMethodName.length() > 3) {
                char first = Character.toLowerCase(getOrSetMethodName.charAt(3));
                if (getOrSetMethodName.length() > 3 + 1) {
                    return first + getOrSetMethodName.substring(3 + 1);
                }
                return String.valueOf(first);
            }
        }

        return null;
    }
}