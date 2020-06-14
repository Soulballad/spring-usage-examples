package com.soulballad.usage.springcloud.config;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.bulkhead.BulkheadRegistry;
import io.github.resilience4j.bulkhead.ThreadPoolBulkhead;
import io.github.resilience4j.bulkhead.ThreadPoolBulkheadConfig;
import io.github.resilience4j.bulkhead.ThreadPoolBulkheadRegistry;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.vavr.control.Try;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.WebServiceException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.function.Supplier;

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

    @Bean
    public BulkheadConfig bulkheadConfig() {
        BulkheadConfig bulkheadConfig = BulkheadConfig.custom()
                .maxConcurrentCalls(5)
                .maxWaitDuration(Duration.ofMillis(10))
                .build();

        BulkheadRegistry registry = BulkheadRegistry.of(bulkheadConfig);
        Bulkhead bulkhead = registry.bulkhead("bulkhead");
        Supplier<List<Object>> arrayListSupplier = Bulkhead.decorateSupplier(bulkhead, ArrayList::new);
        List<Object> objects = Try.ofSupplier(arrayListSupplier).recover(throwable -> Arrays.asList("123", "234")).get();

        return bulkheadConfig;
    }

    @Bean
    public ThreadPoolBulkheadConfig threadPoolBulkheadConfig() {
        ThreadPoolBulkheadConfig poolBulkheadConfig = ThreadPoolBulkheadConfig.custom().maxThreadPoolSize(3)
                .coreThreadPoolSize(1)
                .queueCapacity(1)
                .build();
        ThreadPoolBulkheadRegistry registry = ThreadPoolBulkheadRegistry.of(poolBulkheadConfig);
        ThreadPoolBulkhead threadPoolBulkhead = registry.bulkhead("ThreadPoolBulkhead");
        Callable<CompletionStage<List<Object>>> decorateCallable = ThreadPoolBulkhead.decorateCallable(threadPoolBulkhead, ArrayList::new);
        Executors.newFixedThreadPool(2).submit(decorateCallable);

        return poolBulkheadConfig;
    }

    @Bean
    public RetryConfig retryConfig() {
        RetryConfig retryConfig = RetryConfig.custom()
                .maxAttempts(2) // 最大重试次数
                .waitDuration(Duration.ofMillis(10)) // 等待时间
                .retryOnException(e -> e instanceof WebServiceException)
                .retryExceptions(IOException.class, TimeoutException.class, RuntimeException.class)
                .build();

        RetryRegistry registry = RetryRegistry.of(retryConfig);
        Retry retry = registry.retry("retry");
        Function<String, List<String>> listFunc = Retry.decorateFunction(retry, Arrays::asList);
        listFunc.apply("soulballad");

        return retryConfig;
    }
}
