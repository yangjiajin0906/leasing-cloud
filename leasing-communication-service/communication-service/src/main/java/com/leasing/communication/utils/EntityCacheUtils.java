package com.leasing.communication.utils;

import com.leasing.common.base.entity.AbstractBaseEntity;
import com.leasing.common.utils.base.BaseBusinessUtils;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019-12-3
 * @author:lvcna@yonyou.com
 * @description: 缓存业务对象指定字段信息
 **/
public class EntityCacheUtils {

    /**
     * 缓存指定键值对
     * @param entityName 业务对象名称
     * @param key 键 field名字
     * @param value 值 value名字
     * @param where 条件
     * @param clazz 业务对象 泛型
     * @param fiedClazz 值 泛型
     * @param <T>
     * @param <S>
     * @return
     */
    public static <T extends AbstractBaseEntity,S>  Map cacheEntityField(String entityName, String key, String value, Map where,
                                                                         Class<T> clazz, Class<S> fiedClazz){
        Map returnMap = new HashMap();
        StringBuffer sql = new StringBuffer();
        sql.append(" select a from ").append(entityName).append(" a");
        List<T> list = BaseBusinessUtils.findListByJpql(clazz, sql.toString());

        Boolean valueTypeFlag = StringUtils.isBlank(value) ? Boolean.FALSE : Boolean.TRUE;

        //重复的key,会导致value覆盖,方法内不处理,调用方自行控制
        for(T t : list){
            String tKey = (String)t.getAttributeValue(key);
            if(valueTypeFlag){
                returnMap.put(tKey, fiedClazz.cast(t.getAttributeValue(value)));
            } else {
                returnMap.put(tKey, t);
            }

        }

        return returnMap;
    }

    /**
     *
     * @param entityName
     * @param key
     * @param value
     * @param clazz
     * @param fiedClazz
     * @param <T>
     * @param <S>
     * @return
     */
    public static <T extends AbstractBaseEntity,S>  Map cacheEntityField(String entityName, String key, String value,
                                                                 Class<T> clazz, Class<S> fiedClazz){
        return cacheEntityField(entityName, key, value, null, clazz, fiedClazz);
    }

    /**
     *
     * @param entityName
     * @param key
     * @param value
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T extends AbstractBaseEntity>  Map cacheEntityField(String entityName, String key, String value,
                                                                 Class<T> clazz){
        return cacheEntityField(entityName, key, value, null, clazz, String.class);
    }
}
