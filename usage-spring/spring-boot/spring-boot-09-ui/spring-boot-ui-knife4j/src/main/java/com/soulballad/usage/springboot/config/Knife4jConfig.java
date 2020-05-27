package com.soulballad.usage.springboot.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
 * @apiNote : config
 * @since ：2020/5/27 22:03
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class Knife4jConfig {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("spring-boot-ui-knife4j").description("SpringBoot2整合Knife4j")
            .termsOfServiceUrl("http://localhost:9090/").version("v1.0")
            .contact(new Contact("soulballad", "https://github.com", "xxx@123.com")).build();
    }

    @Bean
    public Docket createApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
            .apis(RequestHandlerSelectors.basePackage("com.soulballad.usage.springboot")).paths(PathSelectors.any())
            .build();
    }
}
