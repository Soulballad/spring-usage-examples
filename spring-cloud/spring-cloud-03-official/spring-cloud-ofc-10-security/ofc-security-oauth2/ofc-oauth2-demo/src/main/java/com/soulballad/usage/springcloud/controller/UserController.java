package com.soulballad.usage.springcloud.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/6/18 22:00
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping(value = "/currentUser")
    public Object currentUser(Authentication authentication) {
        return authentication.getPrincipal();
    }

    @GetMapping(value = "/getAdmin")
    public Object getAdmin() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @GetMapping(value = "/getUser")
    public Object getUser() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
