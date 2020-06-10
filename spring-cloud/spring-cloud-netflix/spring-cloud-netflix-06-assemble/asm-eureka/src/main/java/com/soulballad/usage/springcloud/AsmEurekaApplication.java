package com.soulballad.usage.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class AsmEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsmEurekaApplication.class, args);
    }
}
