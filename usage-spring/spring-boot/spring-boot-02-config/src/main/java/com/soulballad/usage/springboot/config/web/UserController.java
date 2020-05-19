package com.soulballad.usage.springboot.config.web;

import com.soulballad.usage.springboot.config.config.UserProperties;
import com.soulballad.usage.springboot.config.config.UserProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : userController
 * @since ：2020/5/19 20:35
 */
@RestController
public class UserController {

    @Autowired
    private UserProperties userProperties;

    @Autowired
    private UserProps userProps;

    @GetMapping("/user/get/1")
    public String getUser1() {
        return userProperties.getName() + "'s age is " + userProperties.getAge();
    }

    @GetMapping("/user/get/2")
    public String getUser2() {
        return userProps.getName() + "'s age is " + userProps.getAge();
    }
}
