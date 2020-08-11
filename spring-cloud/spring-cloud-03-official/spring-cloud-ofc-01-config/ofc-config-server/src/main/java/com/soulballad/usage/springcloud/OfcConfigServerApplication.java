package com.soulballad.usage.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class OfcConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfcConfigServerApplication.class, args);
    }
}
