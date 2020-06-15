package com.soulballad.usage.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : target
 * @since ：2020/6/15 19:29
 */
@RestController
public class TargetController {

    @GetMapping(value = "/index")
    public String index() {
        return "this is ofc-gateway-target service index!";
    }

    @GetMapping(value = "/access")
    public String access() {
        return "this is ofc-gateway-target service access!";
    }
}
