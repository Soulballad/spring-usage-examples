package com.soulballad.usage.springcloud.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : config
 * @since ：2020/6/14 12:14
 */
@Configuration
public class Resilience4jConfig {

    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> resilience4JCircuitBreaker() {
        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
                .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(3)).build())
                .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults()).build());
    }

    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> slowCustomizer() {
        return factory -> factory.configure(builder -> builder.circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
                .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(2)).build()), "slow");
    }

    @Bean
    public CircuitBreakerConfig circuitBreakerConfig() {
        return CircuitBreakerConfig.custom().failureRateThreshold(50) // 错误率，这个是根据滑动窗口大小决定的，e.g. windowSize = 2，failureRate=50% 那么，当出现一个错误的时候即为失败
                .waitDurationInOpenState(Duration.ofMillis(3000))
                .permittedNumberOfCallsInHalfOpenState(2)
                .slidingWindowSize(2) // 滑动窗口大小
                .recordExceptions(RuntimeException.class) // 当出现列表中的异常类型时记录
                .build();
    }
}
