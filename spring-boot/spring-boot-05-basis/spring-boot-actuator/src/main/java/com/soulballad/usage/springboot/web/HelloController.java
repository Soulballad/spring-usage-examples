package com.soulballad.usage.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : hello world
 * @since ：2020/5/22 20:29
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }
}
