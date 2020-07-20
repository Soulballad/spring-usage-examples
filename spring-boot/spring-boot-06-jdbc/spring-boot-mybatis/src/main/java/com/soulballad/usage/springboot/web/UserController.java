package com.soulballad.usage.springboot.web;

import com.soulballad.usage.springboot.model.UserModel;
import com.soulballad.usage.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/5/23 12:29
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    public List<UserModel> list() {
        return userService.selectList();
    }

    @GetMapping(value = "/findByName/{name}")
    public UserModel findByName(@PathVariable String name) {
        return userService.findUserByName(name);
    }

    @GetMapping(value = "/findByPhone/{phone}")
    public List<UserModel> findByPhone(@PathVariable String phone) {
        return userService.findUserByPhone(phone);
    }

    @PostMapping(value = "/add")
    public UserModel add(@RequestBody UserModel user) {
        return userService.add(user);
    }

    @PutMapping(value = "/updateByName")
    public UserModel updateByName(@RequestBody UserModel user) {
        return userService.updateByName(user.getPhone(), user.getName());
    }

    @DeleteMapping(value = "/deleteByName/{name}")
    public UserModel deleteByName(@PathVariable String name) {
        return userService.deleteByName(name);
    }
}
