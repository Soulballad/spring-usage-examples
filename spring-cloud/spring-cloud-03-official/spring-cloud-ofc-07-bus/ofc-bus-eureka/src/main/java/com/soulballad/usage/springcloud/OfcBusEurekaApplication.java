package com.soulballad.usage.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.PropertySource;

@EnableEurekaServer
@SpringBootApplication
@PropertySource("classpath:kafka.properties")
public class OfcBusEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfcBusEurekaApplication.class, args);
    }
}
