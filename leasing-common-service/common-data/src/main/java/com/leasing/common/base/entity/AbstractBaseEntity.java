package com.leasing.common.base.entity;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
     * 判断该对象下与目标对象指定字段属性是否相等,调用字段属性equals方法进行比较
     * @param target 目标对象
     * @param fieldNames 属性数组
     * @return
     */
    public boolean equalsContent(AbstractBaseEntity target, @Nullable String[] fieldNames) {
        String[] arr$ = null == fieldNames ? this.getAttributeAry() : fieldNames;
        if (fieldNames != null && target != null) {
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
     * 判断该对象下与目标对象指定字段属性是否相等,调用字段属性equals方法进行比较
     * 比较所有字段
     * @param target
     * @return
     */
    public boolean equalsContent(AbstractBaseEntity target) {
        return this.equalsContent(target,null);
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
                    HashSet set = new HashSet();
                    //获取当前对象的每个属性值
                    Field[] field = this.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
                    int len$ = field.length;
                    for (int i$ = 0; i$ < len$; ++i$) {
                        String str = field[i$].getName();
                        set.add(str);
                    }
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
        try {
            propertyName = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);  //改驼峰式命名
            e = bean.getClass().getMethod("get" + propertyName);
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
        Field[] field = bean.getClass().getDeclaredFields();
        int len$ = field.length;
        for (int i$ = 0; i$ < len$; ++i$) {
            String name = field[i$].getName();
            if(name.equals(propertyName)){
                type = field[i$].getType();
                break;
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
        return attrOld == attrNew ? true : (attrOld != null && attrNew != null ? attrOld.equals(attrNew) : false);
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
            BeanUtils.copyProperties(this,vo);
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new RuntimeException("InstantiationException in Class " + this.getClass().getName());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("IllegalAccessException in Class " + this.getClass().getName());
        }
        return vo;
    }
}
