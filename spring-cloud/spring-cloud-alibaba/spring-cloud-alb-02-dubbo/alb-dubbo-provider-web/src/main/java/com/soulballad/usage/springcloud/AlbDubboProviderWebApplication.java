package com.soulballad.usage.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AlbDubboProviderWebApplication {

    public static void main(String[] args) {
        // 指定 spring.profiles.active=nacos
        new SpringApplicationBuilder(AlbDubboProviderWebApplication.class)
                .properties("spring.profiles.active=nacos").run(args);
    }
}
