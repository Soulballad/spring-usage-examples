package com.soulballad.usage.springbootd.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : demo
 * @since ：2020/5/19 19:58
 */
@RestController
public class DemoController {

    @GetMapping("/demo")
    public String demo() {
        return "demo";
    }
}
