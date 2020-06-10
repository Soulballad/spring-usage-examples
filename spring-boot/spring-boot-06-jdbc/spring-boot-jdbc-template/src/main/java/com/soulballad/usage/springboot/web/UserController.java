package com.soulballad.usage.springboot.web;

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

import com.soulballad.usage.springboot.model.UserModel;
import com.soulballad.usage.springboot.service.UserService;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : controller
 * @since ：2020/5/23 23:11
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    public List<UserModel> list() {
        return userService.findAll();
    }

    @GetMapping(value = "/findByName/{name}")
    public UserModel findByName(@PathVariable String name) {
        return userService.findUserByName(name);
    }

    @GetMapping(value = "/findById/{id}")
    public UserModel findById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @PostMapping(value = "/add")
    public UserModel add(@RequestBody UserModel userModel) {
        return userService.addUser(userModel);
    }

    @PostMapping(value = "/insert")
    public UserModel insert(@RequestBody UserModel userModel) {
        return userService.insertUser(userModel);
    }

    @PostMapping(value = "/insertAndGet")
    public UserModel insertAndGet(@RequestBody UserModel userModel) {
        return userService.insertAndGetPK(userModel);
    }

    @PutMapping(value = "/updateAddressById")
    public UserModel updateAddressById(@RequestBody UserModel userModel) {
        return userService.updateAddressById(userModel.getAddress(), userModel.getId());
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public UserModel deleteById(@PathVariable Long id) {
        return userService.deleteById(id);
    }
}
