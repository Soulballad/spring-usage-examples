package com.soulballad.usage.springcloud;

import com.soulballad.usage.springcloud.properties.UserProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableConfigurationProperties(UserProperties.class)
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudCsl01ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudCsl01ConfigApplication.class, args);
    }
}
