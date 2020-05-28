package com.soulballad.usage.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soulballad.usage.springboot.model.UserModel;
import com.soulballad.usage.springboot.repository.UserRepository;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/5/28 20:19
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/add1", consumes = "text/properties", produces = "application/json;charset=UTF-8")
    public UserModel add1(@RequestBody UserModel userModel) {
        return userRepository.add(userModel);
    }

    @PostMapping(value = "/add2", consumes = "application/json;charset=UTF-8", produces = "text/properties")
    public UserModel add2(@RequestBody UserModel userModel) {
        return userRepository.add(userModel);
    }
}
