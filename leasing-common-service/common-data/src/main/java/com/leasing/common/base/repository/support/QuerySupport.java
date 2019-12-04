package com.leasing.common.base.repository.support;

import com.leasing.common.base.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @project:leasing-cloud
 * @date:2019-10-28
 * @author:lvcna@yonyou.com
 * @description: 提供基础SQL整理工具方法
 **/
@SuppressWarnings("Duplicates")
public class QuerySupport<S extends BaseQuery>{

    public static QuerySupport querySupport = null;

    public static QuerySupport getInstance(){
        if(querySupport == null){
            return new QuerySupport();
        }
        return querySupport;
    }

    /**
     * 整理SQL语句,生成动态查询条件
     * @param query
     * @param sql
     * @param ifNative 是否原生SQL true：原生SQL false:JPQL
     * @return
     */
    public QueryDataParam queryWhere(S query, String sql, Boolean ifNative){
        QueryDataParam queryDataParam = new QueryDataParam();
        Map<String,Object> map = new HashMap();
        if(query == null){
            queryDataParam.setIfArrange(false);
            queryDataParam.setParamMap(map);
            return queryDataParam;
        }
        List<Field> fields = getAllFieldsWithRoot(query.getClass());
        StringBuffer whereSql = new StringBuffer();
        Boolean flag = ifWhere(sql);
        for (Field field : fields) {
            //获取注解
            QueryCondition qw = field.getAnnotation(QueryCondition.class);
            if (qw == null){
                continue;
            }
            //获取对应数据库字段名
            String column =  ifNative ? qw.column() : qw.field();
            //获取字段名
            String fieldName = field.getName();
            if (StringUtils.isBlank(column)){
                column = fieldName;
            }
            //获取字段值
            Object value = query.getAttributeValue(field.getName());
            if(value == null || StringUtils.isBlank(value.toString())){
                continue;
            }
            //根据字段描述生成相应表达式
            String func =  column + " = :" + fieldName;
            switch (qw.func()) {
                case equal:
                    break;
                case like:
                    func = column + " like :" + fieldName;
                    value = "%" + value + "%";
                    break;
                case gt:
                    func = column + " > :" + fieldName;
                    break;
                case lt:
                    func = column + " < :" + fieldName;
                    break;
                case ge:
                    func = column + " >= :" + fieldName;
                    break;
                case le:
                    func = column + " <= :" + fieldName;
                    break;
                case notEqual:
                    func = column + " <> :" + fieldName;
                    break;
                case notLike:
                    func = column + " not like :" + fieldName;
                    value = "%" + value + "%";
                    break;
                case greaterThan:
                    func = column + " > :" + fieldName;
                    break;
                case greaterThanOrEqualTo:
                    func = column + " >= :" + fieldName;
                    break;
                case lessThan:
                    func = column + " < :" + fieldName;
                    break;
                case lessThanOrEqualTo:
                    func = column + " <= :" + fieldName;
                    break;
            }
            map.put(fieldName,value);
            if(StringUtils.isNotBlank(whereSql.toString())){
                func = " and " + func;
            }
            whereSql.append(func);
        }
        //判断是否生成了动态条件
        if(StringUtils.isBlank(whereSql.toString())){
            queryDataParam.setIfArrange(false);
            queryDataParam.setParamMap(map);
        } else {
            String sqlWhere = StringUtils.isBlank(whereSql.toString()) ? ""
                    : flag ? whereSql.toString() : " where " + whereSql.toString();
            String returnSql = arrangeResultSql(sql,sqlWhere);
            queryDataParam.setSql(returnSql);
            queryDataParam.setParamMap(map);
            queryDataParam.setWhere(sqlWhere);
            queryDataParam.setIfArrange(true);
        }
        return queryDataParam;
    }

    /**
     * 重新组织SQL,生成WHERE条件
     * 关键字优先级排序：WHERE->HAVING->GROUP->ORDER
     * @param sql
     * @param sqlWhere
     * @return
     */
    private String arrangeResultSql(String sql, String sqlWhere) {
        StringBuffer result = new StringBuffer(sql);
        String upperCaseSql = sql.toUpperCase();
        int i = sql.length();
        if(ifWhere(sql)){
            //where条件开始的地方
            i = upperCaseSql.lastIndexOf("WHERE");
            result.insert(i+5," " + sqlWhere + " AND ");
            return result.toString();
        } else if(ifHaving(sql)){
            i = upperCaseSql.lastIndexOf("HAVING");
            result.insert(i,sqlWhere + " AND ");
        } else if(ifGroup(sql)){
            i = upperCaseSql.lastIndexOf("GROUP");
        } else if(ifOrder(sql)){
            i = upperCaseSql.lastIndexOf("ORDER");
        }
        result.insert(i," " + sqlWhere + " ");
        return result.toString();
    }
    /**
     * 将查询SQL queryName 转换为计数SQL queryName
     * 目前规则是 #queryName#+".count"
     * @param queryName
     * @return
     */
    public String countWhere(String queryName){
        return queryName.trim().concat(".count").trim();
    }
    /**
     * 判断是否有WHERE条件
     * @param sql
     * @return
     */
    private Boolean ifWhere(String sql){
        int i = sql.lastIndexOf(")");
        int j = sql.toUpperCase().lastIndexOf("WHERE");
        if(j == -1 || i > j){
            return false;
        } else {
            return true;
        }
    }
    /**
     * 判断是否有ORDER关键字
     * @param sql
     * @return
     */
    private Boolean ifOrder(String sql){
        int i = sql.lastIndexOf(")");
        int j = sql.toUpperCase().lastIndexOf("ORDER");
        if(j == -1 || i > j){
            return false;
        } else {
            return true;
        }

    }

    /**
     * 判断是否有GROUP关键字
     * @param sql
     * @return
     */
    private Boolean ifGroup(String sql){
        int i = sql.lastIndexOf(")");
        int j = sql.toUpperCase().lastIndexOf("GROUP");
        if(j == -1 || i > j){
            return false;
        } else {
            return true;
        }

    }
    /**
     * 判断是否有HAVING关键字
     * @param sql
     * @return
     */
    private Boolean ifHaving(String sql){
        int i = sql.lastIndexOf(")");
        int j = sql.toUpperCase().lastIndexOf("HAVING");
        if(j == -1 || i > j){
            return false;
        } else {
            return true;
        }

    }

    /**
     *
     * @param clazz
     * @return
     */
    private List<Field> getAllFieldsWithRoot(Class<?> clazz) {
        List<Field> fieldList = new ArrayList<>();
        Field[] dFields = clazz.getDeclaredFields();//获取本类所有字段
        if (null != dFields && dFields.length > 0)
            fieldList.addAll(Arrays.asList(dFields));

        // 若父类是Object，则直接返回当前Field列表
        Class<?> superClass = clazz.getSuperclass();
        if (superClass == Object.class) return Arrays.asList(dFields);

        // 递归查询父类的field列表
        List<Field> superFields = getAllFieldsWithRoot(superClass);

        if (null != superFields && !superFields.isEmpty()) {
            superFields.stream().
                    filter(field -> !fieldList.contains(field)).//不重复字段
                    forEach(field -> fieldList.add(field));
        }
        return fieldList;
    }


}
