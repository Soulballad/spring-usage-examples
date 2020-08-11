package com.soulballad.usage.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote :
 * @since ：2020/6/23 20:14
 */
@RestController
public class GatewayServiceController {

    @GetMapping(value = "/echo/{str}")
    public String echo(@PathVariable String str) {
        return "hello nacos alb-gateway-service : " + str;
    }

    @GetMapping(value = "/divide")
    public String divide(@RequestParam Integer a, Integer b) {
        return String.valueOf(a / b);
    }
}
