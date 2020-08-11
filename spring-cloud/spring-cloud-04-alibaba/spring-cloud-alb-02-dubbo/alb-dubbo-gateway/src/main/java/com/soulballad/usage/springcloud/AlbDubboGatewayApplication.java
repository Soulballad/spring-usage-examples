package com.soulballad.usage.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@EnableAutoConfiguration
@ServletComponentScan(basePackages = "com.soulballad.usage.springcloud.gateway")
public class AlbDubboGatewayApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(AlbDubboGatewayApplication.class)
                .properties("spring.profiles.active=nacos").run(args);
    }
}
