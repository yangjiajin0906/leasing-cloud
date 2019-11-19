package com.leasing.communication.utils;


import com.leasing.communication.enums.DecimalType;
import com.leasing.communication.enums.TimeType;

import java.lang.annotation.*;

/**
 * <p>
 * excel 注解
 * </p>
 *
 * @author <a href="mailto:yangyanrui@yidianlife.com">xiaoyang</a>
 * @version V0.0.1
 * @date 2019年09月10日
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Excel {


    /**
     * 表头中文
     *
     * @return
     */
    String titleName();

    /**
     * 列宽
     *
     * @return
     */
    int titleSize() default 30;

    /**
     * 字段顺序  正序
     *
     * @return
     */
    int orderNum();

    /**
     * 是否允许空值 ，默认允许
     *
     * @return
     */
    boolean empty() default true;

    /**
     * 内部类
     *
     * @return
     */
    CellType type() default @CellType;

    /**
     * 设置格式
     *
     * @return
     */
    @interface CellType {

        TimeType timeType() default TimeType.TIMEF_FORMAT;

        DecimalType decimalType() default DecimalType.TWO;

        boolean IsMoney() default true;
    }
}
