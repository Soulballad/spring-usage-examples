package com.soulballad.usage.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

//@EnableHystrix
@EnableTurbine
@EnableHystrixDashboard
@SpringBootApplication
public class NetflixHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixHystrixDashboardApplication.class, args);
    }
}
