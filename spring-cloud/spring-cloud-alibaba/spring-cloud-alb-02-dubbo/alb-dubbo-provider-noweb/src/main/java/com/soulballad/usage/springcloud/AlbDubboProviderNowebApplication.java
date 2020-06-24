package com.soulballad.usage.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AlbDubboProviderNowebApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(AlbDubboProviderNowebApplication.class)
                .properties("spring.profiles.active=nacos")
                .web(WebApplicationType.NONE).run(args);
    }
}
