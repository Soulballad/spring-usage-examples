package com.soulballad.usage.springcloud.controller;

import com.alibaba.csp.sentinel.adapter.reactor.SentinelReactorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : controller
 * @since ：2020/6/28 21:06
 */
@RestController
public class SentinelWebFluxController {

    @Autowired
    private ReactiveCircuitBreakerFactory circuitBreakerFactory;

    @GetMapping(value = "/mono")
    public Mono<String> mono() {
        return Mono.just("alb-sentinel-webflux mono()")
                // transform the publisher here.
                .transform(new SentinelReactorTransformer<>("mono"));
    }

    @GetMapping(value = "/test")
    public Mono<String> test() {
        return Mono.just("alb-sentinel-webflux test()")
                .transform(new SentinelReactorTransformer<>("test"));
    }

    @GetMapping(value = "/flux")
    public Flux<String> flux() {
        return Flux.fromArray(new String[]{"a", "b", "c"})
                .transform(new SentinelReactorTransformer<>("flux"));
    }

    @GetMapping(value = "/cbSlow")
    public Mono<String> cbSlow() {
        int delaySec = 2;
        return WebClient.builder().baseUrl("http://httpbin.org/").build().get()
                .uri("/delay/" + delaySec).retrieve().bodyToMono(String.class)
                .transform(it -> circuitBreakerFactory.create("slow_mono").run(it, t -> {
                    t.printStackTrace();
                    return Mono.just("alb-sentinel-webflux cbSlow() fallback!");
                }));
    }

    @GetMapping(value = "/cbError")
    public Mono<String> cbError() {
        String code = String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return WebClient.builder().baseUrl("http://httpbin.org/").build().get()
                .uri("/status/" + code).retrieve().bodyToMono(String.class)
                .transform(it -> circuitBreakerFactory.create("cbError").run(it, t -> {
                    t.printStackTrace();
                    return Mono.just("alb-sentinel-webflux cbError() fallback!");
                }));
    }
}
