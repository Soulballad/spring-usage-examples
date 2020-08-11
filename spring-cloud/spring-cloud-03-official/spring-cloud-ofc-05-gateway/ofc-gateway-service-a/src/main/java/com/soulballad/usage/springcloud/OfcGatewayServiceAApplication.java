package com.soulballad.usage.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class OfcGatewayServiceAApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfcGatewayServiceAApplication.class, args);
    }
}
