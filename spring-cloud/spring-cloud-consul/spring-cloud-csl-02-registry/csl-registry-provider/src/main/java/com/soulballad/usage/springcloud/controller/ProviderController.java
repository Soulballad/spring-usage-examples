package com.soulballad.usage.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : provider
 * @since ：2020/6/12 21:03
 */
@RestController
public class ProviderController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "this is csl provider!";
    }
}
