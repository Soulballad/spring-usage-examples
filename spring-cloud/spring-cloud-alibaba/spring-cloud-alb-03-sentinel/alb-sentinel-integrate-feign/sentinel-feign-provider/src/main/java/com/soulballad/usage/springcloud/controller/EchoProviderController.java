package com.soulballad.usage.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : controller
 * @since ：2020/6/28 20:11
 */
@RestController
public class EchoProviderController {

    @GetMapping(value = "/echo/{str}")
    public String echo(@PathVariable String str) {
        return "sentinel-feign-provider echo : " + str;
    }
}
