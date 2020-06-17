package com.soulballad.usage.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : config
 * @since ：2020/6/17 19:32
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${my.name}")
    private String name;

    @GetMapping(value = "/name")
    public String name() {
        return name;
    }
}
