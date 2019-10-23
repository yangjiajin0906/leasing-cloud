package com.leasing.common.annotation;



import com.leasing.common.enums.MatchType;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface QueryCondition {
    // 数据库中字段名,默认为空字符串,则Query类中的字段要与数据库中字段一致
    String column() default "";

    // equal, like, gt, lt...
    MatchType func() default MatchType.equal;

    // object是否可以为null
    boolean nullable() default false;

    // 字符串是否可为空
    boolean emptyable() default false;
}
