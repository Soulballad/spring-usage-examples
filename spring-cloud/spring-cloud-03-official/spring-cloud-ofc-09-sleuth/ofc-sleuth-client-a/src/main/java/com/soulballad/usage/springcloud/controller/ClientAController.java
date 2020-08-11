package com.soulballad.usage.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : controller
 * @since ：2020/6/17 21:50
 */
@RestController
public class ClientAController {

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/port")
    public String port() {
        return "this is client a. the port is : " + port;
    }
}
