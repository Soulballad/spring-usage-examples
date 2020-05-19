package com.soulballad.usage.arthasdemo.web;

import com.soulballad.usage.arthasdemo.model.User;
import com.soulballad.usage.arthasdemo.util.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController  {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id) {

        LOGGER.info("get user");

        if (null == id) {
            throw new IllegalArgumentException("id can not be null");
        }
        if (id < 1) {
            throw new IllegalArgumentException("id must be greater than 1");
        }

        return new User(id, "zhangsan");
    }

    @GetMapping("/user/get")
    public Object get() {
        return SpringContextUtil.getBean(UserController.class);
    }
}
