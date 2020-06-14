package com.soulballad.usage.springcloud.controller;

import com.soulballad.usage.springcloud.model.UserModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : provider
 * @since ：2020/6/14 16:10
 */
@RestController
public class UserProvController {

    private static final Map<Long, UserModel> USER_MAP = new HashMap<>();
    private static final AtomicLong ID_GENERATOR = new AtomicLong();

    @GetMapping(value = "/user/list")
    public List<UserModel> list() {
        return new ArrayList<>(USER_MAP.values());
    }

    @PostMapping(value = "/user/save")
    public UserModel save(@RequestBody UserModel userModel) {
        long id = ID_GENERATOR.incrementAndGet();
        userModel.setId(id);
        USER_MAP.put(id, userModel);
        return userModel;
    }
}
