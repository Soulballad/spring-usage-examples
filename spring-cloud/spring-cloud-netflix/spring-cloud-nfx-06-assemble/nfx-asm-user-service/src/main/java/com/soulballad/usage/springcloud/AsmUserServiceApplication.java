package com.soulballad.usage.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine
@EnableHystrix
@EnableEurekaClient
@EnableHystrixDashboard
@SpringBootApplication
public class AsmUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsmUserServiceApplication.class, args);
    }
}
