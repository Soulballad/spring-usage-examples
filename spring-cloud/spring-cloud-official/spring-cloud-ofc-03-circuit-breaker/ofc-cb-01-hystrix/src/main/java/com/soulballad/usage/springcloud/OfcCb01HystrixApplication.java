package com.soulballad.usage.springcloud;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixObservableCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.netflix.hystrix.ReactiveHystrixCircuitBreakerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
public class OfcCb01HystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfcCb01HystrixApplication.class, args);
    }

    @Bean
    public WebClient.Builder builder() {
        return WebClient.builder();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }

    @Bean
    public Customizer<ReactiveHystrixCircuitBreakerFactory> circuitBreaker() {
        return factory -> factory.configureDefault(id -> {
            return HystrixObservableCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(id))
                    .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                            .withExecutionTimeoutInMilliseconds(3000));
        });
    }
}
