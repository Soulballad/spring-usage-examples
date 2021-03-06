package com.soulballad.usage.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OfcZkRegistryProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfcZkRegistryProviderApplication.class, args);
    }
}
