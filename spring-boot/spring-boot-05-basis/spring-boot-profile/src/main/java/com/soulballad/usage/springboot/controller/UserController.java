package com.soulballad.usage.springboot.controller;

import com.soulballad.usage.springboot.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : controller
 * @since ：2020/7/12 21:08
 */
@RestController
public class UserController {

    @Autowired
    private final ApplicationContext applicationContext;

    public UserController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @GetMapping(value = "/user/get")
    public UserModel getUser() {
        return applicationContext.getBean(UserModel.class);
    }

    @Profile("dev")
    @GetMapping(value = "/user/dev")
    public UserModel devUser() {
        return new UserModel("dev-user", 22);
    }

    @Profile("prod")
    @GetMapping(value = "/user/prod")
    public UserModel prodUser() {
        return new UserModel("prod-user", 33);
    }
}
