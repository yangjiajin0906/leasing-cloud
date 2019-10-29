package com.leasing.rentearly.rentearlyservice.projectInfo.utils;

import javax.persistence.Table;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

/**
 * @project:leasing-cloud
 * @date:2019/10/25
 * @author:jiaoshy@yonyou.com
 * @description: 工具类 校验vo里面属性 是否和数据库一致
 **/
public class CheckFieldNotInDataBaseUtil {
    private final static String driver = "oracle.jdbc.driver.OracleDriver";
    private final static String tableName = "YLS_PROJECT_INFO";
    private final static String url = "jdbc:oracle:thin:@192.168.249.87:1521:ncdb";
    private final static String user = "ztnc";
    private final static String passWorld = "ztnc";
    private final static String vo = "com.leasing.rentearly.rentearlyservice.projectInfo.enity.refVO.RatingMaintainBRefVO";
    private final static boolean ref = true;


    public static void main(String[] args) throws Exception {
        Map<String, String> tableInfo = new HashMap<>();
        List<String> fieldList = getVoField();

        if (ref) {
            tableInfo = getColumnInfo(getQuerySql());
            check(tableInfo, fieldList);

        } else {
            tableInfo = getColumnInfo();
            //校验vo
            check(tableInfo, fieldList);

            //输出DO
            printDOField(tableInfo);
        }


    }

    /**
     * 如果是参照 通过注解获取表
     *
     * @return
     * @throws ClassNotFoundException
     */
    public static String getTableName() throws ClassNotFoundException {
        Class clazz = Class.forName(vo);
        Table table = (Table) clazz.getAnnotation(Table.class);
        String tableSql = table.name();
        return tableSql;
    }

    /**
     * 拼接处参照查询SQL
     *
     * @return
     * @throws ClassNotFoundException
     */
    public static String getQuerySql() throws ClassNotFoundException {
        String query = "select * from " + getTableName() + " where rownum = 1";
        return query;
    }

    public static Map<String, String> getColumnInfo(String sql) throws SQLException, ClassNotFoundException {
        Map<String, String> map = new HashMap();

        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(getQuerySql());
        ResultSet result = preparedStatement.executeQuery();
        ResultSetMetaData resultSetMetaData = result.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            map.put(getNameValue(resultSetMetaData.getColumnName(i)), null);
        }
        return map;

    }


    /**
     * 获取数据库连接
     */
    public static Connection getConnection() throws SQLException {
        //Class.forName(driver);
        Properties properties = new Properties();
        properties.put("user", user);
        properties.put("password", passWorld);
        Connection connection = DriverManager.getConnection(url, properties);
        return connection;
    }


    /**
     * 获取表信息
     */
    public static Map<String, String> getColumnInfo() throws SQLException {
        Map<String, String> map = new HashMap();
        DatabaseMetaData databaseMetaData = getConnection().getMetaData();
        ResultSet resultSet = databaseMetaData.getColumns(null, "%", tableName, "%");

        while (resultSet.next()) {
            String key = getNameValue(resultSet.getString("COLUMN_NAME").toLowerCase());
            String tableType = resultSet.getString("TYPE_NAME");
            //由于元数据integer 和 number 都是 number类型 所以这里根据小数位 判断是 short 还是 bigDecimel;
            if ("NUMBER".equals(tableType)) {
                if (resultSet.getInt("DECIMAL_DIGITS") >= 2) {
                    map.put(key, "BigDecimal");
                } else {
                    map.put(key, "Short");
                }
            } else {
                map.put(key, "String");

            }
        }

        return map;
    }

    /**
     * 转驼峰
     */
    public static String getNameValue(String key) {
        String[] strings = key.toLowerCase().split("_");
        String result = strings[0];
        for (int i = 1; i < strings.length; i++) {
            String s1 = strings[i];
            if (Character.isUpperCase(s1.charAt(0))) {
                result = result + s1;
            } else {
                result = result + (new StringBuilder()).append(Character.toUpperCase(s1.charAt(0))).append(s1.substring(1)).toString();
            }
        }
        return result;
    }

    /**
     * 获取vo 属性
     *
     * @return
     * @throws ClassNotFoundException
     */
    public static List<String> getVoField() throws ClassNotFoundException {
        List<String> result = new ArrayList<>();
        Class clazz = Class.forName(vo);
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            result.add(field.getName());
        }
        return result;
    }

    /**
     * 校验vo属性 是否在数据库中
     *
     * @param map       数据库属性
     * @param fieldList vo属性
     */
    public static void check(Map<String, String> map, List<String> fieldList) {
        System.out.println("-------vo中字段与数据库关联不上的属性-------加    @Transient 注解");
        System.out.println("");
        System.out.println("");
        for (String string : fieldList) {
            if (!map.containsKey(string)) {
                System.out.println("vo属性" + string);
            }
        }
    }

    public static void printDOField(Map<String, String> map) {
        System.out.println("");
        System.out.println("");
        System.out.println("-----------生成的DO属性字段--------------");
        System.out.println("");
        System.out.println("");
        Iterator<String> keys = map.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            System.out.println("private " + map.get(key) + " " + key + ";");
            System.out.println("");

        }

    }


}
