package com.soulballad.usage.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class OfcBusConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfcBusConfigClientApplication.class, args);
    }
}
