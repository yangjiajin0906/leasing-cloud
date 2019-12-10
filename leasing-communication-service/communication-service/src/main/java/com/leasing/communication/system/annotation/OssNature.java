package com.leasing.communication.system.annotation;

/**
 * @project:leasing-cloud
 * @date:2019-12-6
 * @author:lvcna@yonyou.com
 * @description: C端业务接口文件业务类型注解
 **/
public @interface OssNature {

    //顺序
    int order();
    //类型
    String type();
    //失败信息
    String fail() default "";



}
