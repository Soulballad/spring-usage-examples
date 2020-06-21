package com.soulballad.usage.springcloud.controller;

import java.util.Random;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : dashboard
 * @since ：2020/6/2 19:43
 */
@RestController
public class DashboardController {

    @GetMapping(value = "/dashboard")
    @HystrixCommand(fallbackMethod = "fallBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
    })
    public String dashboard() throws InterruptedException {
        int second = new Random().nextInt(200);
        Thread.sleep(second);
        return "hello hystrix dashboard!";
    }

    public String fallBack() {
        return "fallBack appear!";
    }

}
