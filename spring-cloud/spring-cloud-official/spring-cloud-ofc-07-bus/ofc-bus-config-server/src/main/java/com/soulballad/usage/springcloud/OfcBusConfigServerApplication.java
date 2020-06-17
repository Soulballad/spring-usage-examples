package com.soulballad.usage.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;

@EnableConfigServer
@EnableEurekaClient
@SpringBootApplication
@PropertySource("classpath:kafka.properties")
public class OfcBusConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfcBusConfigServerApplication.class, args);
    }
}
