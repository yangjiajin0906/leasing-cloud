package com.leasing.common.base.annotation;

import com.leasing.common.enums.base.ConvertType;

import java.lang.annotation.*;

/**
 * @project:leasing-cloud
 * @date:2019-9-24
 * @author:lvcna@yonyou.com
 * @description: 类型转换缓存类
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ConvertCache {

    String paramName();

    String entityName();

    String cacheName() default "";

    String targetName() default "";

    ConvertType type() default ConvertType.ref;

}
