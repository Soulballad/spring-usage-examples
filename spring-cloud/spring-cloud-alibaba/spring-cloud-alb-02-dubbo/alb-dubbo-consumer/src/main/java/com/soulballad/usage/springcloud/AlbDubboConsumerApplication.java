package com.soulballad.usage.springcloud;

import com.alibaba.cloud.dubbo.annotation.DubboTransported;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@EnableCaching
@EnableScheduling
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class AlbDubboConsumerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(AlbDubboConsumerApplication.class)
                .properties("spring.profiles.active=nacos").run(args);
    }

    @LoadBalanced
    @DubboTransported
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
