package com.leasing.common.entity.base;

import org.springframework.beans.BeanUtils;

import javax.persistence.Version;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @project:leasing-cloud
 * @date:2019-10-8
 * @author:lvcna@yonyou.com
 * @description: 业务对象实体基类
 **/
public abstract class BaseBusiEntity extends BaseEntity{
    private static transient Map<Class, String[]> map = new HashMap();                    //存取对象及其字段值
    private static transient ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();  //对象属性读写锁

    /**
     * 获取业务对象对应的数据库表名
     * @return
     */
    public abstract String getTableName();

    @Override
    //个体对象全体属性字段复制
    public Object clone() {
        BaseBusiEntity vo =null;
        try {
            vo = this.getClass().newInstance();
            BeanUtils.copyProperties(this,vo);
        } catch (Exception e) {
           e.printStackTrace();
        }

        return vo;
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this ? true
                : (obj == null ? false
                : (obj.getClass() != this.getClass() ? false
                : this.equalsContent((BaseBusiEntity) obj, this.getAttributeNames())));
    }

    public boolean equalsContent(BaseBusiEntity vo, String[] fieldnames) {
        if (fieldnames != null && vo != null) {
            String[] arr$ = fieldnames;
            int len$ = fieldnames.length;

            for (int i$ = 0; i$ < len$; ++i$) {
                String field = arr$[i$];
                if (!this.isAttributeEquals(this.getAttributeValue(field), vo.getAttributeValue(field))) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    //个体对象部分属性字段复制(选定值复制)
    public Object cloneWithProperties(String []args){
        BaseBusiEntity vo =null;
        HashSet set = new HashSet();
        for(String arg:args){
            set.add(arg);
        }
        try {
            vo = this.getClass().newInstance();
            Field[] field = this.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
            int len$ = field.length;
            for (int i$ = 0; i$ < len$; ++i$) {
                String str = field[i$].getName();
                if(set.contains(str)){
                    vo.setAttributeValue(str, this.getAttributeValue(str));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }

    //个体对象部分属性字段复制(忽略值复制)
    public Object cloneWithoutProperties(String[] ignore) {
        BaseBusiEntity vo =null;
        try {
            vo = this.getClass().newInstance();
            BeanUtils.copyProperties(this,vo,ignore);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }

    //获取对象属性字段
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

    //获取某个字段属性值
    public Object getAttributeValue(String attributeName) {
        if (attributeName != null && attributeName.length() != 0) {
            return getProperty(this, attributeName);
        } else {
            return null;
        }
    }


    //远程方法获取属性值
    public static Object getProperty(Object bean, String propertyName) {
        try {
            propertyName = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);  //改驼峰式命名
            Method e = bean.getClass().getMethod("get" + propertyName);
            return propertyName != null && e == null ? null : (e == null ? null : e.invoke(bean));
        } catch (Exception arg3) {
            String errStr = "Failed to get property: " + propertyName;
            throw new RuntimeException(errStr, arg3);
        }
    }

    //给某个字段赋值
    public void setAttributeValue(String propertyName, Object value) {
        if (propertyName != null && propertyName.length() != 0) {
            setProperty(this, propertyName, value);
        }
    }

    public static void setProperty(Object bean, String propertyName, Object value) {
        try {
            Class type = java.lang.String.class;
            Field[] field = bean.getClass().getDeclaredFields();  // 获取实体类的所有属性，返回Field数组
            int len$ = field.length;
            for (int i$ = 0; i$ < len$; ++i$) {
                String name =field[i$].getName();
                if(name.equals(propertyName)){
                    type = field[i$].getType();      //确定修改字段的实体类型  避免赋值方法类型异常
                    break;
                }
            }
            propertyName = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1); //改驼峰式命名
            Method e = bean.getClass().getMethod("set"+propertyName,type);
            if (propertyName == null || e != null) {
                if (e != null) {
                    Object[] errStr1 = new Object[] { value };
                    e.invoke(bean, errStr1);
                }
            }
        } catch (Exception arg4) {
            String errStr = "Failed to set property: " + propertyName + " on bean: " + bean.getClass().getName()
                    + " with value:" + value;
            throw new RuntimeException(errStr, arg4);
        }
    }

    private boolean isAttributeEquals(Object attrOld, Object attrNew) {
        return attrOld == attrNew ? true : (attrOld != null && attrNew != null ? attrOld.equals(attrNew) : false);
    }


}
