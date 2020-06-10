package com.soulballad.usage.springboot.web;

import com.soulballad.usage.springboot.model.User;
import com.soulballad.usage.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : controller
 * @since ：2020/5/21 20:05
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> list() {
        return userService.selectAll();
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public User add(@Valid @RequestBody User user) {
        return userService.add(user);
    }

    @ResponseBody
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public User get(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public User delete(@PathVariable Long id) {
        return userService.delete(id);
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public User update(@Valid @RequestBody User user) {
        return userService.update(user);
    }
}
