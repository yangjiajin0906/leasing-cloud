package com.leasing.communication.interfaces;

import java.lang.annotation.*;

/**
 * @project:leasing-cloud
 * @date:2019/11/17
 * @author:Yjj@yonyou.com
 * @description: 导入导出自定义注解
 **/
@Target({ElementType.FIELD, ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelTag {
    /**
     * 表头
     *
     * @return
     */
    String tag();
}