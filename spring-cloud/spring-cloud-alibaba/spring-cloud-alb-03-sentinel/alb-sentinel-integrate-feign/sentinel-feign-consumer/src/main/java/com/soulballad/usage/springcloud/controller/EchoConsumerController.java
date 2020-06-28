package com.soulballad.usage.springcloud.controller;

import com.soulballad.usage.springcloud.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : consumer
 * @since ：2020/6/28 20:19
 */
@RestController
public class EchoConsumerController {

    @Autowired
    private EchoService echoService;

    @GetMapping(value = "/echo-feign/{str}")
    public String echoFeign(@PathVariable String str) {
        return echoService.echo(str);
    }
}
