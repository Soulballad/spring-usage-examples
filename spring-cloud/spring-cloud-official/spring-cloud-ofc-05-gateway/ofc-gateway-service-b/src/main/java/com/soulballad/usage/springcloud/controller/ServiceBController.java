package com.soulballad.usage.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : controller
 * @since ：2020/6/14 19:03
 */
@RestController
public class ServiceBController {

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello, this is service-b. listening port at : " + port;
    }

    @GetMapping(value = "/name")
    public String name(String name) {
        return "service-b current name is : " + name;
    }

    @GetMapping(value = "/age")
    public String age(String age) {
        return "service-b current age is :" + age;
    }

    @GetMapping(value = "/routeAll")
    public String routeAll(String pass) {
        return "service-b can pass?" + pass + "! port: " + port;
    }
}
