package com.soulballad.usage.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soulballad.usage.springboot.mode.UserModel;
import com.soulballad.usage.springboot.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : controller
 * @since ：2020/5/24 12:48
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/list")
    public Flux<UserModel> list() {
        return Flux.fromStream(userRepository.findAll().stream());
    }

    @GetMapping(value = "/find/{id}")
    public Mono<UserModel> findById(@PathVariable Long id) {
        return Mono.just(userRepository.findById(id));
    }

    @PostMapping(value = "/add")
    public Mono<UserModel> add(@RequestBody UserModel userModel) {
        return Mono.just(userRepository.add(userModel));
    }

    @PutMapping(value = "/update")
    public Mono<UserModel> update(@RequestBody UserModel userModel) {
        return Mono.just(userRepository.update(userModel));
    }

    @DeleteMapping(value = "/delete/{id}")
    public Mono<UserModel> deleteById(@PathVariable Long id) {
        return Mono.just(userRepository.deleteById(id));
    }
}
