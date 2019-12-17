package com.leasing.communication;

import com.leasing.communication.interceptor.CbInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @project:leasing-cloud
 * @date:2019/12/10
 * @author:wangjc@yonyou.com
 * @description: C端单据设置的拦截请求  后期统一后需要删除
 **/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    CbInterceptor Interceptor() {
        return new CbInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(Interceptor()).addPathPatterns("/**");
    }

}

