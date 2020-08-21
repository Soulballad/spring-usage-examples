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

    /**
     * 设置线程的超时时间是100ms，默认值为50ms
     * 如果超时触发降级之后，执行 fallbackMethod 中的 timeoutMethod 方法
     */
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

    /**
     * 使用自定义的 HelloCommand 定义降级策略
     */
    @GetMapping(value = "/hello")
    public String hello() {
        return new HelloCommand().execute();
    }
}
