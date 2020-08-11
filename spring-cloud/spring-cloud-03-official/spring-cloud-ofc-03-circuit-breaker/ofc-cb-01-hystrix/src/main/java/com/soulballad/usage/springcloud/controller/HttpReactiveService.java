package com.soulballad.usage.springcloud.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : reactive
 * @since ：2020/6/13 21:32
 */
@Service
public class HttpReactiveService {

    private WebClient webClient;

    public HttpReactiveService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://www.soulballad.com").build();
    }

    public Mono<Map> get() {
        return webClient.get().uri("/get").retrieve().bodyToMono(Map.class);
    }

    public Mono<Map> delay(int seconds) {
        return webClient.get().uri("http://www.soulballad.com/delay/{seconds}", seconds).retrieve().bodyToMono(Map.class);
    }

    public Flux<String> fluxDelay(int seconds) {
        return Flux.just("1", "2", "3").delayElements(Duration.ofSeconds(seconds));
    }

    public Supplier<Mono<Map>> delaySupplier(int seconds) {
        return () -> this.delay(seconds);
    }
}
