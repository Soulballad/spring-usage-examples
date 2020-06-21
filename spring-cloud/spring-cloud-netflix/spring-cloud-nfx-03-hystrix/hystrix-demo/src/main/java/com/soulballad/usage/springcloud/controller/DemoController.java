package com.soulballad.usage.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.soulballad.usage.springcloud.command.HelloCommand;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : demo
 * @since ：2020/6/1 20:55
 */
@RestController
public class DemoController {

    // HystrixCommandProperties
    @GetMapping(value = "/demo")
    @HystrixCommand(fallbackMethod = "timeoutMethod", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")})
    public String demo(@RequestParam(name = "time", defaultValue = "50") String value) throws InterruptedException {

        long timeout = Long.parseLong(value);
        Thread.sleep(timeout);
        return "hystrix demo";
    }

    public String timeoutMethod(String value) {
        return "the request cost " + value + " ms, timeout!";
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return new HelloCommand().execute();
    }
}
