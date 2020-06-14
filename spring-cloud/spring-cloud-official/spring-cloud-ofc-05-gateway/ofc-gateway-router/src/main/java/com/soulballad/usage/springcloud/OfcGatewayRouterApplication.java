package com.soulballad.usage.springcloud;

import com.soulballad.usage.springcloud.config.filters.TokenFilter;
import com.soulballad.usage.springcloud.config.filters.UriKeyResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class OfcGatewayRouterApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfcGatewayRouterApplication.class, args);
    }

    @Bean
    public UriKeyResolver uriKeyResolver() {
        return new UriKeyResolver();
    }

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }
}
