package com.soulballad.usage.springcloud.controller;

import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping(value = "/dept")
public class DeptController {

    @GetMapping(value = "/getAdmin")
    @PreAuthorize("hasRole('ADMIN')")
    public Object getAdmin() {
        return "get admin dept!";
    }

    @GetMapping(value = "/getUser")
    @PreAuthorize("hasRole('USER')")
    public Object getUser() {
        return "get user dept!";
    }
}
