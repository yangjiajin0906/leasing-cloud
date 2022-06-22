package com.leasing.communication.calculate;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.Contact;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @project:leasing-cloud
 * @date:2019/10/18
 * @author:Yjj@yonyou.com
 * @description:  Swagger2配置类
 **/

@Configuration //标记配置类
@EnableSwagger2 //开启在线接口文档
public class Swagger2Config {

    /**
     * 添加摘要信息(Docket)
     */
    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("标题：XXX_核心业务租赁系统_接口文档")
                        .description("描述：用于管理XXX租赁业务系统,具体包括XXX,XXX模块...")
                        .contact(new Contact("用友金融", null, null))
                        .version("版本号:1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.leasing.calculate.controller"))
                .paths(PathSelectors.any())
                .build();
    }

}
