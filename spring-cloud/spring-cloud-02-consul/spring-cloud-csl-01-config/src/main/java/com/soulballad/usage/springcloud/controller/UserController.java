package com.soulballad.usage.springcloud.controller;

import com.soulballad.usage.springcloud.properties.UserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user controller
 * @since ：2020/6/12 20:24
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Value("${userName}")
    private String userName;

    @Autowired
    private UserProperties userProperties;

    @GetMapping(value = "/name")
    public String name() {
        return userName;
    }

    @GetMapping(value = "/info")
    public String info() {
        return userProperties.toString();
    }
}
