package com.soulballad.usage.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : swagger
 * @since ：2020/5/27 20:31
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("spring-boot-ui-swagger").description("SpringBoot2整合Swagger2").version("v1.0")
            .contact(new Contact("spring-boot-ui-swagger", "https://github.com", "xxx@123.com"))
            .license("Apache License V2.0").licenseUrl("https://www.apache.org/").build();
    }

    @Bean
    public Docket createApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).paths(PathSelectors.any()).build();
    }
}
