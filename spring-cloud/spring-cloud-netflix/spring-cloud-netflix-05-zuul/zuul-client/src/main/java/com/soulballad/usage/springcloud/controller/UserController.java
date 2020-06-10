package com.soulballad.usage.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/6/3 20:31
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping(value = "/query/{id}")
    public String query(@PathVariable Long id) {
        return "user " + id;
    }
}
