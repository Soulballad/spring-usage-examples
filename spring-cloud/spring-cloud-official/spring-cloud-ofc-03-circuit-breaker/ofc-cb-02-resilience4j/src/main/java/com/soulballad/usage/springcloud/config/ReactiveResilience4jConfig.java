package com.soulballad.usage.springcloud.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.event.CircuitBreakerOnErrorEvent;
import io.github.resilience4j.circuitbreaker.event.CircuitBreakerOnSuccessEvent;
import io.github.resilience4j.core.EventConsumer;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : resilience4j config
 * @since ：2020/6/14 12:25
 */
@Configuration
public class ReactiveResilience4jConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReactiveResilience4jConfig.class);

    @Autowired
    private NormalFluxErrorConsumer normalFluxErrorConsumer;

    @Autowired
    private NormalFluxSuccessConsumer normalFluxSuccessConsumer;

    /**
     * Reactive 方式
     */
    @Bean
    public Customizer<ReactiveResilience4JCircuitBreakerFactory> reactiveResilience4JCircuitBreaker() {
        return factory -> {
            factory.configure(builder -> builder.timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(3)).build())
                    .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults()), "slow", "slowFlux");
            factory.addCircuitBreakerCustomizer(circuitBreaker -> circuitBreaker.getEventPublisher()
                    .onError(normalFluxErrorConsumer).onSuccess(normalFluxSuccessConsumer), "normalFlux");
        };
    }

    // Reactive方式
    @Bean
    public Customizer<ReactiveResilience4JCircuitBreakerFactory> reactiveSlowCustomizer() {
        return factory -> {
            factory.configure(builder -> builder
                    .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(2)).build())
                    .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults()), "slow", "slowFlux");
            factory.addCircuitBreakerCustomizer(circuitBreaker -> circuitBreaker.getEventPublisher()
                    .onError(normalFluxErrorConsumer).onSuccess(normalFluxSuccessConsumer), "normalFlux");
        };
    }

    @Bean
    public NormalFluxErrorConsumer fluxErrorConsumer() {
        return new NormalFluxErrorConsumer();
    }

    @Bean
    public NormalFluxSuccessConsumer fluxSuccessConsumer() {
        return new NormalFluxSuccessConsumer();
    }

    static class NormalFluxErrorConsumer implements EventConsumer<CircuitBreakerOnErrorEvent> {
        @Override
        public void consumeEvent(CircuitBreakerOnErrorEvent event) {
            LOGGER.info("normal flux error consumer event: {}", event.toString());
        }
    }

    static class NormalFluxSuccessConsumer implements EventConsumer<CircuitBreakerOnSuccessEvent> {
        @Override
        public void consumeEvent(CircuitBreakerOnSuccessEvent event) {
            LOGGER.info("normal flux success consumer event: {}", event.toString());
        }
    }
}
