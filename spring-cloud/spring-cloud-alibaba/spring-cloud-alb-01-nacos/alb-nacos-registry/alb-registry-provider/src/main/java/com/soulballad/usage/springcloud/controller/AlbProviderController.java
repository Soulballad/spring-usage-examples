package com.soulballad.usage.springcloud.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote :
 * @since ：2020/6/22 22:13
 */
@RestController
@RequestMapping(value = "/provider")
public class AlbProviderController {
    @RequestMapping(value = "/echo/${string}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {
        return "alb nacos registry provider : " + str;
    }
}
