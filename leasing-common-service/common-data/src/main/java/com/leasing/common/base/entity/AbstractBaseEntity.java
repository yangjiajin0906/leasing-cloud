package com.leasing.common.base.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.leasing.common.base.repository.support.StringModalType;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.reflect.FieldUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @project:leasing-cloud
 * @date:2019-10-18
 * @author:lvcna@yonyou.com
 * @description: 对象原始基类
 **/
public abstract class AbstractBaseEntity implements Serializable,Cloneable{

    //存取对象及其字段值
    private static transient Map<Class, String[]> map = new HashMap();
    //对象属性读写锁
    private static transient ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    @Override
    public boolean equals(Object obj) {
        return obj == null ? false
                : obj.getClass() != this.getClass() ? Boolean.FALSE
                : this.equalsContent((AbstractBaseEntity)obj, this.getAttributeNames());
    }


    /**
     * 判断两个相同对象指定字段属性是否相等 调用字段属性equals方法进行比较
     */
    public boolean equalsContentBetween(AbstractBaseEntity source,AbstractBaseEntity target) {
        if(source==null||target==null) return false;
        String []arr$ = source.getAttributeNames();
        if (arr$ != null && target != null) {
            int len$ = arr$.length;
            for (int i$ = 0; i$ < len$; ++i$) {
                String field = arr$[i$];
                if (!this.isAttributeEquals(source.getAttributeValue(field), target.getAttributeValue(field))) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断该对象下与目标对象指定字段属性是否相等,调用字段属性equals方法进行比较
     * @param target 目标对象
     * @param fieldNames 属性数组
     * @return
     */
    public boolean equalsContent(AbstractBaseEntity target, @Nullable String[] fieldNames) {
        String[] arr$ = null == fieldNames ? this.getAttributeNames() : fieldNames;
        if (arr$ != null && target != null) {
            int len$ = arr$.length;
            for (int i$ = 0; i$ < len$; ++i$) {
                String field = arr$[i$];
                if (!this.isAttributeEquals(this.getAttributeValue(field), target.getAttributeValue(field))) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     *获取当前对象属性集合
     * @return
     */
    public String[] getAttributeNames() {
        rwl.readLock().lock();
        String[] arg0;
        try {
            arg0 = this.getAttributeAry();
        } finally {
            rwl.readLock().unlock();
        }
        return arg0;
    }

    /**
     * 获取当前对象属性名数组
     * 私有方法
     * @return
     */
    private String[] getAttributeAry() {
        String[] arys = (String[]) map.get(this.getClass());
        if (arys == null) {
            rwl.readLock().unlock();
            rwl.writeLock().lock();
            try {
                arys = (String[]) map.get(this.getClass());
                if (arys == null) {
                    //获取当前对象(包含父类)的每个属性值
                    HashSet set = getFieldSet(this.getClass());
                    arys = (String[]) set.toArray(new String[set.size()]);
                    map.put(this.getClass(), arys);
                }
            } finally {
                rwl.readLock().lock();
                rwl.writeLock().unlock();
            }
        }
        return arys;
    }


    /**
     * 自封装获取当前对象所有属性  指定到当前基类为最顶层  排除顶层两字段属性
     */
    public static HashSet getFieldSet(Class clazz){
        if(clazz == null){
            return null;  //如果当前对象为空 则直接返回空数组
        }
        HashSet set = new HashSet();
        for(; clazz != AbstractBaseEntity.class ; clazz = clazz.getSuperclass()) {
            Field[] field = clazz.getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
            int len$ = field.length;
            for (int i$ = 0; i$ < len$; ++i$) {
                String str = field[i$].getName();
                set.add(str);
            }
        }
        return set;
    }

    /**
     * 动态获取当前对象属性
     * @param attributeName
     * @return
     */
    public Object getAttributeValue(String attributeName) {
        if (StringUtils.isNotBlank(attributeName)) {
            return getProperty(this, attributeName);
        } else {
            return null;
        }
    }


    /**
     * 动态获取属性,拼接该属性get方法,反射调用
     * @param bean
     * @param propertyName
     * @return
     */
    public static Object getProperty(Object bean, String propertyName) {
        Assert.hasLength(propertyName,"propertyName is empty,please check!");
        Method e = null;
        Class clazz = bean.getClass();
        Class tagetclazz = bean.getClass();
        for(; clazz != AbstractBaseEntity.class ; clazz = clazz.getSuperclass()) {
            Field[] field = clazz.getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
            int len$ = field.length;
            for (int i$ = 0; i$ < len$; ++i$) {
                String name = field[i$].getName();
                if(name.equals(propertyName)){
                    tagetclazz = clazz;
                    break;
                }
            }
        }
        try {
            propertyName = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);  //改驼峰式命名
            e = tagetclazz.getMethod("get" + propertyName);
            return propertyName != null && e == null ? null : (e == null ? null : e.invoke(bean));
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
            throw new RuntimeException("IllegalAccess for method " + e.getName() + "in Class " + bean.getClass());
        } catch (InvocationTargetException e1) {
            e1.printStackTrace();
            throw new RuntimeException("InvocationTarget for method " + e.getName() + "in Class " + bean.getClass());
        } catch (NoSuchMethodException e1) {
            e1.printStackTrace();
            throw new RuntimeException("NoSuchMethod " + e.getName() + "in Class " + bean.getClass());
        }
    }

    /**
     * 动态为当前对象属性赋值
     * @param propertyName
     * @param value
     */
    public void setAttributeValue(String propertyName, Object value) {
        if (StringUtils.isNotBlank(propertyName)) {
            setProperty(this, propertyName, value);
        }
    }

    /**
     * 动态设置对象属性赋值
     * @param bean
     * @param propertyName
     * @param value
     */
    public static void setProperty(Object bean, String propertyName, Object value) {
        Class type = java.lang.String.class;
        Class clazz = bean.getClass();
        for(; clazz != AbstractBaseEntity.class ; clazz = clazz.getSuperclass()) {
            Field[] field = clazz.getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
            int len$ = field.length;
            for (int i$ = 0; i$ < len$; ++i$) {
                String name = field[i$].getName();
                if(name.equals(propertyName)){
                    type = field[i$].getType();
                    break;
                }
            }
        }
        propertyName = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1); //改驼峰式命名
        Method e = null;
        try {
            e = bean.getClass().getMethod("set" + propertyName,type);
            Object[] errStr1 = new Object[] { value };
            e.invoke(bean, errStr1);
        } catch (NoSuchMethodException e1) {
            e1.printStackTrace();
            throw new RuntimeException(e1.getMessage());
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
            throw new RuntimeException(e1.getMessage());
        } catch (InvocationTargetException e1) {
            e1.printStackTrace();
            throw new RuntimeException(e1.getMessage());
        }
    }

    /**
     * 判断对象是否相等
     * @param attrOld
     * @param attrNew
     * @return
     */
    private boolean isAttributeEquals(Object attrOld, Object attrNew) {
        if(attrOld == attrNew){
            return true;
        }else{
            if(attrOld!=null&&attrNew!=null){
                if(attrNew.getClass().getName().equals("com.leasing.common.base.repository.support.StringModalType")
                        &&attrOld.getClass().getName().equals("com.leasing.common.base.repository.support.StringModalType")) {
                    return true;
                }else if(attrNew.getClass().getSuperclass().getName().equals("java.lang.Object")&&attrOld.getClass().getSuperclass().getName().equals("java.lang.Object")){
                    return attrOld.equals(attrNew);
                } else{
                    return equalsContentBetween((AbstractBaseEntity) attrNew,(AbstractBaseEntity)attrOld);
                }
            }else{
                return false;
            }
        }
    }

    /**
     * 重写clone方法
     * @return
     */
    @Override
    public Object clone(){
        AbstractBaseEntity vo = null;
        try {
            vo = this.getClass().newInstance();
            String jsonS = JSON.toJSONString(this);
            vo = JSONObject.parseObject(jsonS,this.getClass());
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new RuntimeException("InstantiationException in Class " + this.getClass().getName());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("IllegalAccessException in Class " + this.getClass().getName());
        }
        return vo;
    }


    /**
     * 判断该对象下与目标对象指定字段属性是否相等,调用字段属性equals方法进行比较
     * @param target 目标对象
     * @param fieldNames 属性数组
     * @return
     */
    public List<String> differentColumn(AbstractBaseEntity target, @Nullable String[] fieldNames) {
        String[] arr$ = null == fieldNames ? this.getAttributeNames() : fieldNames;
        List<String> returnlist=new ArrayList<String>();
        if (arr$ != null && target != null) {
            int len$ = arr$.length;
            for (int i$ = 0; i$ < len$; ++i$) {
                String field = arr$[i$];
                if (!this.isAttributeEquals(this.getAttributeValue(field), target.getAttributeValue(field))) {
                    returnlist.add(field);
                }
            }
        }
        return  returnlist;
    }
}
