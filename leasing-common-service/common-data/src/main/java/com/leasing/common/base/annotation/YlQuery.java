package com.leasing.common.base.annotation;

import com.leasing.common.base.enums.QueryEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @project:leasing-cloud
 * @date:2019-10-18
 * @author:lvcna@yonyou.com
 * @description: 查询对象字段逻辑注解
 **/
@Target({ElementType.FIELD})
public @interface YlQuery {
    QueryEnum logic() default QueryEnum.EQUAL;

}
