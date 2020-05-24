package com.soulballad.usage.springboot.webflux;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.soulballad.usage.springboot.model.UserModel;
import com.soulballad.usage.springboot.repository.UserRepository;

import javassist.NotFoundException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : handler
 * @since ：2020/5/24 14:53
 */
@Component
public class UserHandler {

    @Autowired
    private UserRepository userRepository;

    public Mono<ServerResponse> list(ServerRequest request) {
        return ServerResponse.ok().body(Flux.fromStream(userRepository.findAll().stream()), UserModel.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        return Mono.justOrEmpty(userRepository.findById(Long.valueOf(request.pathVariable("id"))))
            .flatMap(user -> ServerResponse.ok().body(Mono.just(user), UserModel.class))
            .switchIfEmpty(ServerResponse.notFound().build()); // 输出 404 Not Found
    }

    public Mono<ServerResponse> add(ServerRequest request) {
        return ServerResponse.ok().body(
            request.bodyToMono(UserModel.class).flatMap(userModel -> Mono.just(userRepository.add(userModel))),
            UserModel.class);
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        /*request.bodyToMono(UserModel.class)
            .flatMap(user -> Mono.justOrEmpty(userRepository.findById(user.getId()))
                .then(ServerResponse.ok().body(Mono.just(userRepository.update(user)), UserModel.class))
                // .switchIfEmpty(Mono.error(new NotFoundException(String.valueOf(user.getId())))))
                .switchIfEmpty(ServerResponse.notFound().build()));*/

        return request.bodyToMono(UserModel.class)
            .flatMap(body -> Mono.justOrEmpty(userRepository.findById(body.getId())).flatMap(foundUser -> {
                foundUser.setAge(body.getAge());
                foundUser.setName(body.getName());
                foundUser.setBirthday(body.getBirthday());
                foundUser.setAddress(body.getAddress());
                foundUser.setPhone(body.getPhone());
                return Mono.just(foundUser);
            }).flatMap(u -> ServerResponse.ok().body(fromObject(u))).switchIfEmpty(ServerResponse.notFound().build()));
    }

    public Mono<ServerResponse> deleteById(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        return Mono.justOrEmpty(userRepository.findById(id))
            .switchIfEmpty(Mono.error(new NotFoundException(String.valueOf(id)))) // 控制台异常：NotFoundException: 30
            .then(ServerResponse.ok().body(Mono.justOrEmpty(userRepository.deleteById(id)), UserModel.class));
    }

    public Mono<ServerResponse> deleteId(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        return Mono.justOrEmpty(userRepository.findById(id))
            .flatMap(user -> ServerResponse.ok().body(Mono.just(userRepository.deleteById(id)), UserModel.class))
            .switchIfEmpty(ServerResponse.notFound().build());
    }
}
