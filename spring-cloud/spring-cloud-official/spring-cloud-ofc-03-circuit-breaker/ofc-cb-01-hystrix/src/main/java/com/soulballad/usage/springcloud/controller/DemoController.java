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
public class DemoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    private HttpService httpService;
    private CircuitBreakerFactory circuitBreakerFactory;

    public DemoController(HttpService httpService, CircuitBreakerFactory circuitBreakerFactory) {
        this.httpService = httpService;
        this.circuitBreakerFactory = circuitBreakerFactory;
    }

    @GetMapping(value = "/get")
    public Mono<Map> get() {
        return httpService.get();
    }

    @GetMapping(value = "/delay/{seconds}")
    public Mono<Map> delay(@PathVariable int seconds) {
        return new ReactiveHystrixCircuitBreaker("mono", HystrixCommandProperties.Setter()
                .withExecutionTimeoutInMilliseconds(3000)).run(httpService.delay(seconds),
                t -> {
                    Map<String, String> fallback = new HashMap<>();
                    LOGGER.warn("mono delay for seconds failed, fallback!");
                    fallback.put("sorry", "mono delay time out");
                    return Mono.just(fallback);
                });
    }

    @GetMapping(value = "/fluxDelay/{seconds}")
    public Flux<String> fluxDelay(@PathVariable int seconds) {
        return new ReactiveHystrixCircuitBreaker("flux", HystrixCommandProperties.Setter()
                .withExecutionTimeoutInMilliseconds(3000)).run(httpService.fluxDelay(seconds),
                t -> {
                    LOGGER.warn("flux delay for seconds failed, fallback!");
                    return Flux.just("sorry", "flux delay time out");
                });
    }
}
