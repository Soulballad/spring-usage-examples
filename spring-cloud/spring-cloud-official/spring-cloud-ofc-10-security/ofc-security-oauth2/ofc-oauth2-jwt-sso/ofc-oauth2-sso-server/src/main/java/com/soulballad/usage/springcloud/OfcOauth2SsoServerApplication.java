package com.soulballad.usage.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class OfcOauth2SsoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfcOauth2SsoServerApplication.class, args);
    }
}
