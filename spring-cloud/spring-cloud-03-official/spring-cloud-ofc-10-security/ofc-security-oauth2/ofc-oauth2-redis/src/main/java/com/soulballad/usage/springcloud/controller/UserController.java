package com.soulballad.usage.springcloud.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user controller
 * @since ：2020/6/20 21:36
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping(value = "/getUser")
    public Object getUser() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
