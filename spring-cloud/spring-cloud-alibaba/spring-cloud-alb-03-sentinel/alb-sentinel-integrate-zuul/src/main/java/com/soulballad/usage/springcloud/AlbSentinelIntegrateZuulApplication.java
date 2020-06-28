package com.soulballad.usage.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class AlbSentinelIntegrateZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlbSentinelIntegrateZuulApplication.class, args);
    }
}
