package com.soulballad.usage.springcloud.controller;

import com.soulballad.usage.springcloud.model.UserModel;
import com.soulballad.usage.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : client
 * @since ：2020/6/14 16:55
 */
@RestController
public class UserClientController implements UserService {

    private final UserService userService;

    @Autowired
    public UserClientController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserModel> list() {
        return userService.list();
    }

    @Override
    public UserModel save(@RequestBody UserModel userModel) {
        return userService.save(userModel);
    }
}
