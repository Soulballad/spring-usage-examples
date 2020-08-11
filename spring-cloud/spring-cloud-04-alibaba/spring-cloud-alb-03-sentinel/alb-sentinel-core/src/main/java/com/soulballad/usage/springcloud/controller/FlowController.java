package com.soulballad.usage.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : controller
 * @since ：2020/6/27 17:38
 */
@RestController
public class FlowController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @GetMapping(value = "/hello")
    @SentinelResource("resource")
    public String hello() {
        return "alb-sentinel-core hello!";
    }

    @GetMapping(value = "/aa")
    @SentinelResource("aa")
    public String aa(int a, int b) {
        return "alb-sentinel-core aa!";
    }

    // 没有使用 @SentinelResource 加入控制，可在管理台配置
    @GetMapping(value = "/test")
    public String test() {
        return "alb-sentinel-core test!";
    }

    @GetMapping("/slow")
    public String slow() {
        return circuitBreakerFactory.create("slow").run(() -> {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "alb-sentinel-core slow!";
        }, throwable -> "fallback");
    }
}
