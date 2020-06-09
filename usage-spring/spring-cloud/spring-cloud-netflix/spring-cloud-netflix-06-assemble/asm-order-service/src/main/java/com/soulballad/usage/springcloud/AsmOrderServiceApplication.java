package com.soulballad.usage.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.soulballad.usage.springcloud.config.RibbonConfig;

@EnableTurbine
@EnableHystrix
@EnableEurekaClient
@EnableHystrixDashboard
@SpringBootApplication
@RibbonClient(name = "ams-user-service", configuration = RibbonConfig.class)
public class AsmOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsmOrderServiceApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
