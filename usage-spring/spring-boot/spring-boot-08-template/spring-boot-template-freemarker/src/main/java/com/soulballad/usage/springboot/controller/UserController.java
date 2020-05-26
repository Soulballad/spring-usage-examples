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

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/5/26 20:19
 */
//@RestController
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    public String list(Model model) {
        List<UserModel> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "userList";
    }

    @GetMapping(value = "/detail/{id}")
    public String query(Model model, @PathVariable Long id) {
        UserModel user = userService.findById(id);
        model.addAttribute("user", user);
        return "userDetail";
    }

    @PostMapping(value = "/add")
    public String add(Model model, @ModelAttribute("form") UserModel userModel) {
        if (Objects.nonNull(userModel.getId())) {
            userService.update(userModel);
        }else{
            userService.add(userModel);
        }
        return list(model);
    }

    // 这里应该为DeleteMapping，需要单独绑定事件触发
    @GetMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable Long id) {
        UserModel user = userService.deleteById(id);
        return list(model);
    }
}
