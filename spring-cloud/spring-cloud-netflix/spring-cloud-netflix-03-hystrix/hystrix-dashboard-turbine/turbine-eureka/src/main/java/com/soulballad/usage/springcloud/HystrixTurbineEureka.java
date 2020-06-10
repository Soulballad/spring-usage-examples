package com.soulballad.usage.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HystrixTurbineEureka {

    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineEureka.class, args);
    }
}
