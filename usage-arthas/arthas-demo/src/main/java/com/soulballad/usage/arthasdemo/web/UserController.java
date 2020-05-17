package com.soulballad.usage.arthasdemo.web;

import com.soulballad.usage.arthasdemo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id) {

        if (null == id) {
            throw new IllegalArgumentException("id can not be null");
        }
        if (id < 1) {
            throw new IllegalArgumentException("id must be greater than 1");
        }

        return new User(id, "zhangsan");
    }
}
