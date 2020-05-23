package com.soulballad.usage.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soulballad.usage.springboot.model.User;
import com.soulballad.usage.springboot.service.UserService;

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
    public List<User> list() {
        return userService.selectList();
    }

    @GetMapping(value = "/findByName/{name}")
    public User findByName(@PathVariable String name) {
        return userService.findUserByName(name);
    }

    @GetMapping(value = "/findByPhone/{phone}")
    public List<User> findByPhone(@PathVariable String phone) {
        return userService.findUserByPhone(phone);
    }

    @GetMapping(value = "/page")
    public Page<User> page(Pageable pageable) {
        return userService.findByPage(pageable);
    }

    @PostMapping(value = "/add")
    public User add(User user) {
        return userService.add(user);
    }

    @PutMapping(value = "/updateByName")
    public User updateByName(@RequestBody User user) {
        return userService.updateByName(user.getPhone(), user.getName());
    }

    @DeleteMapping(value = "/deleteByName/{name}")
    public User deleteByName(@PathVariable String name) {
        return userService.deleteByName(name);
    }
}
