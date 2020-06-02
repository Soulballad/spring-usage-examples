package com.soulballad.usage.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soulballad.usage.springcloud.model.UserModel;
import com.soulballad.usage.springcloud.service.UserService;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/5/31 22:13
 */
@RestController
@RequestMapping(value = "/provider/user")
public class UserProviderController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    public List<UserModel> list() {
        return userService.findAll();
    }

    @GetMapping(value = "/query/{id}")
    public UserModel query(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping(value = "/add")
    public UserModel add(@RequestBody UserModel userModel) {
        return userService.add(userModel);
    }

    @PutMapping(value = "/update")
    public UserModel update(@RequestBody UserModel userModel) {
        return userService.update(userModel);
    }

    @DeleteMapping(value = "/delete/{id}")
    public UserModel deleteById(@PathVariable Long id) {
        return userService.deleteById(id);
    }
}
