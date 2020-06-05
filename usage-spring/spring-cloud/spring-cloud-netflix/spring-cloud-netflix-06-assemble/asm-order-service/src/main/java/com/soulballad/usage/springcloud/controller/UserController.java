package com.soulballad.usage.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soulballad.usage.springcloud.model.UserModel;
import com.soulballad.usage.springcloud.service.UserService;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/6/5 21:06
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

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

    @GetMapping(value = "/find")
    public UserModel find(@RequestParam(name = "name") String name) {
        return userService.findByUserName(name);
    }

    @PostMapping(value = "/update")
    public UserModel update(@RequestBody UserModel userModel) {
        return userService.update(userModel);
    }

    @DeleteMapping(value = "/delete")
    public Integer deleteByName(@RequestParam(name = "name") String name) {
        return userService.deleteByName(name);
    }
}
