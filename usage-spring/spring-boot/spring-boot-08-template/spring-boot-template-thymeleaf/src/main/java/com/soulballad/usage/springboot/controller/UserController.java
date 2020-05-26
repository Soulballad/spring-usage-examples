package com.soulballad.usage.springboot.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soulballad.usage.springboot.model.UserModel;
import com.soulballad.usage.springboot.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/5/26 21:47
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    public String list(Model model) {
        List<UserModel> userList = userService.findAll();
        model.addAttribute("userList", Flux.fromIterable(userList));
        return "userList";
    }

    @GetMapping(value = "/detail/{id}")
    public String query(Model model, @PathVariable Long id) {
        UserModel userModel = userService.findById(id);
        model.addAttribute("user", Mono.justOrEmpty(userModel));
        return "userDetail";
    }

    @PostMapping(value = "/update")
    public String update(Model model, @ModelAttribute UserModel userModel) {
        if (Objects.nonNull(userModel.getId())) {
            userService.update(userModel);
        } else {
            userService.add(userModel);
        }
        return list(model);
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable Long id) {
        userService.deleteById(id);
        return list(model);
    }
}
