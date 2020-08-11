package com.soulballad.usage.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : provider
 * @since ：2020/6/13 20:41
 */
@RestController
@RequestMapping(value = "/provider")
public class ZKProviderController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "this is ofc-zk-registry-provider!";
    }
}
