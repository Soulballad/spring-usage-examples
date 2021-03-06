package com.soulballad.usage.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class OfcGatewayEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfcGatewayEurekaApplication.class, args);
    }
}
