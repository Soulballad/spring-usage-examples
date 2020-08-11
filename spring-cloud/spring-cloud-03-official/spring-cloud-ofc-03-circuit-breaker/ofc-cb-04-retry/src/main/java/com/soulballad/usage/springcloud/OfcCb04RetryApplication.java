package com.soulballad.usage.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.springretry.SpringRetryCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.springretry.SpringRetryConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryListener;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.policy.TimeoutRetryPolicy;

@SpringBootApplication
public class OfcCb04RetryApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfcCb04RetryApplication.class, args);
    }

    @Bean
    public Customizer<SpringRetryCircuitBreakerFactory> circuitBreaker() {
        return factory -> factory.configure(builder -> builder.retryPolicy(new SimpleRetryPolicy(1)).build(), "slow");
    }

    @Bean
    public Customizer<SpringRetryCircuitBreakerFactory> circuitBreaker2() {
        return factory -> factory.configureDefault(id -> new SpringRetryConfigBuilder(id).retryPolicy(new TimeoutRetryPolicy()).build());
    }

    @Bean
    public Customizer<SpringRetryCircuitBreakerFactory> circuitBreaker3() {
        return factory -> factory.addRetryTemplateCustomizers(retryTemplate -> retryTemplate.registerListener(new RetryListener() {
            @Override
            public <T, E extends Throwable> boolean open(RetryContext retryContext, RetryCallback<T, E> retryCallback) {
                return false;
            }

            @Override
            public <T, E extends Throwable> void close(RetryContext retryContext, RetryCallback<T, E> retryCallback, Throwable throwable) {

            }

            @Override
            public <T, E extends Throwable> void onError(RetryContext retryContext, RetryCallback<T, E> retryCallback, Throwable throwable) {

            }
        }));
    }
}
