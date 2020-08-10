package com.soulballad.usage.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : ribbon 服务端
 * @since ：2020/6/2 21:53
 */
@RestController
@RequestMapping(value = "/server")
public class RibbonServerController {

    @GetMapping(value = "/ribbon")
    public String ribbon() {
        System.err.println("ribbon server is calling!");
        return "Ribbon server has started!";
    }
}
