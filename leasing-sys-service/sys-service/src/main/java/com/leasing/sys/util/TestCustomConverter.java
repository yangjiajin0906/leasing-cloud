package com.leasing.sys.util;

import com.leasing.common.base.entity.AbstractBaseEntity;
import com.leasing.sys.entity.dos.DFuncMenuDO;
import com.leasing.sys.entity.vo.DFuncMenuVO;
import org.dozer.CustomConverter;
import org.dozer.MappingException;

import java.lang.reflect.Field;

/**
 * @project:leasing-cloud
 * @date:2019/10/22
 * @author:wangjc@yonyou.com
 * @description:
 **/
public class TestCustomConverter implements CustomConverter {
    public Object convert(Object destination, Object source,

                          Class destClass, Class sourceClass) {

        if (source == null) {

            return null;

        }

        Class<?> clazz = sourceClass;
        for(; clazz != AbstractBaseEntity.class ; clazz = clazz.getSuperclass()) {
            Field[] field = clazz.getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
            int len$ = field.length;
            for (int i$ = 0; i$ < len$; ++i$) {
                String str = field[i$].getName();
            }
        }

        DFuncMenuDO dest = null;

        if (source instanceof DFuncMenuVO) {
            if (destination == null) {
                dest = new DFuncMenuDO();
            } else {
                dest = (DFuncMenuDO) destination;
            }

            dest.setFuncCode(((DFuncMenuVO)source).getFuncCode());


            return dest;

        } else if (source instanceof DFuncMenuDO) {

            String sourceObj = ((DFuncMenuDO)source).getFuncCode();

            return sourceObj;

        } else {

            throw new MappingException("ConverterTestCustomConverter "

                    + "used incorrectly. Arguments passed inwere:"

                    + destination + " and " + source);

        }

    }

}