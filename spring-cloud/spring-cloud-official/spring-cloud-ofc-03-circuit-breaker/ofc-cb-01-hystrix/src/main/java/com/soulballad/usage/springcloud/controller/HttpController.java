package com.soulballad.usage.springcloud.controller;

import com.netflix.hystrix.HystrixCommandProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : demo
 * @since ：2020/6/13 22:27
 */
@RestController
public class HttpController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpController.class);

    private final HttpRestService restService;
    private final HttpReactiveService reactiveService;
    private final CircuitBreakerFactory circuitBreakerFactory;

    public HttpController(HttpRestService restService, HttpReactiveService reactiveService, CircuitBreakerFactory circuitBreakerFactory) {
        this.restService = restService;
        this.reactiveService = reactiveService;
        this.circuitBreakerFactory = circuitBreakerFactory;
    }

    /**
     * 使用 webFlux 方式
     */
    @GetMapping(value = "/get")
    public Mono<Map> get() {
        return reactiveService.get();
    }

    /**
     * 使用 webFlux 方式
     */
    @GetMapping(value = "/delay/{seconds}")
    public Mono<Map> delay(@PathVariable int seconds) {
        return new ReactiveHystrixCircuitBreaker("mono", HystrixCommandProperties.Setter()
                .withExecutionTimeoutInMilliseconds(3000)).run(reactiveService.delay(seconds),
                t -> {
                    LOGGER.warn("mono delay for seconds failed, fallback!");
                    Map<String, String> fallback = new HashMap<>();
                    fallback.put("sorry", "mono delay time out");
                    return Mono.just(fallback);
                });
    }

    /**
     * 使用 webFlux 方式
     */
    @GetMapping(value = "/fluxDelay/{seconds}")
    public Flux<String> fluxDelay(@PathVariable int seconds) {
        return new ReactiveHystrixCircuitBreaker("flux", HystrixCommandProperties.Setter()
                .withExecutionTimeoutInMilliseconds(3000)).run(reactiveService.fluxDelay(seconds),
                t -> {
                    LOGGER.warn("flux delay for seconds failed, fallback!");
                    return Flux.just("sorry", "flux delay time out");
                });
    }

    /**
     * 使用 webMvc restTemplate 方式
     */
    @GetMapping(value = "/webGet")
    public Map webGet() {
        return restService.get();
    }

    /**
     * 使用 webMvc restTemplate 方式
     */
    @GetMapping(value = "/webDelay/{seconds}")
    public Map webDelay(@PathVariable int seconds) {
        return circuitBreakerFactory.create("delay").run(restService.delaySupplier(seconds), t -> {
            LOGGER.warn("web delay for seconds failed, fallback!");
            Map<String, String> fallback = new HashMap<>();
            fallback.put("sorry", "web delay time out");
            return fallback;
        });
    }
}
