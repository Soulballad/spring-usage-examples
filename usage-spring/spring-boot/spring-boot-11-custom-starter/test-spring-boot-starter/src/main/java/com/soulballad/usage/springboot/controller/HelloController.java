package com.soulballad.usage.springboot.controller;

import com.soulballad.usage.springboot.template.HelloTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote :
 * @since ：2020/5/28 22:35
 */
@RestController
public class HelloController {

    @Autowired
    private HelloTemplate helloTemplate;

    @GetMapping(value = "/hello")
    public String hello() {
        return helloTemplate.hello();
    }
}
