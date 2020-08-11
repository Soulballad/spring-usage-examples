package com.soulballad.usage.springcloud.controller;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixObservableCommand;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import rx.Observable;
import rx.RxReactiveStreams;
import rx.Subscription;

import java.util.function.Function;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : breaker
 * @since ：2020/6/13 21:37
 */
public class ReactiveHystrixCircuitBreaker {

    private String id;
    private HystrixCommandProperties.Setter commandPropertiesSetter;

    public ReactiveHystrixCircuitBreaker(String id, HystrixCommandProperties.Setter commandPropertiesSetter) {
        this.id = id;
        this.commandPropertiesSetter = commandPropertiesSetter;
    }

    public <T> Mono<T> run(Mono<T> toRun) {
        return run(toRun, null);
    }

    public <T> Flux<T> run(Flux<T> toRun) {
        return run(toRun, null);
    }

    public <T> Flux<T> run(Flux<T> toRun, Function<Throwable, Flux<T>> fallback) {

        HystrixObservableCommand<T> command = createCommand(toRun, fallback);
        return Flux.create(s -> {
            Subscription sub = command.toObservable().subscribe(s::next, s::error, s::complete);
            s.onCancel(sub::unsubscribe);
        });
    }

    public <T> Mono<T> run(Mono<T> toRun, Function<Throwable, Mono<T>> fallback) {

        HystrixObservableCommand<T> command = createCommand(toRun, fallback);
        return Mono.create(s -> {
            Subscription sub = command.toObservable().subscribe(s::success, s::error, s::success);
            s.onCancel(sub::unsubscribe);
        });
    }

    private <T> HystrixObservableCommand<T> createCommand(Publisher<T> toRun, Function fallback) {
        HystrixObservableCommand.Setter setter = HystrixObservableCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(id))
                .andCommandPropertiesDefaults(commandPropertiesSetter);

        return new HystrixObservableCommand<T>(setter) {
            @Override
            protected Observable<T> construct() {
                return RxReactiveStreams.toObservable(toRun);
            }

            @Override
            protected Observable<T> resumeWithFallback() {
                if (fallback == null) {
                    super.resumeWithFallback();
                }
                return RxReactiveStreams.toObservable((Publisher<T>) fallback.apply(this.getExecutionException()));
            }
        };
    }
}
