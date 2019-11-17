//package com.leasing.sys;
//
//import com.leasing.sys.interceptor.LoginInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * @project:leasing-cloud
// * @date:2019/11/6
// * @author:Yjj@yonyou.com
// * @description: 登录拦截配置类
// **/
//@Configuration
//public class LoginConfiguration implements WebMvcConfigurer {
//    /**
//     * @Function: 这个方法才能在拦截器中自动注入查询数据库的对象
//     * @author: YangXueFeng
//     * @Date:  2019/4/14 13:10
//     */
//    @Bean
//    LoginInterceptor loginInterceptor() {
//        return new LoginInterceptor();
//    }
//
//    /**
//     * @Function: 配置生成器：添加一个拦截器，拦截路径为login以后的路径
//     * @author: YangXueFeng
//     * @Date:  2019/4/14 13:10
//     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry ){
//        registry.addInterceptor(loginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login", "/register", "/static");
//    }
//}