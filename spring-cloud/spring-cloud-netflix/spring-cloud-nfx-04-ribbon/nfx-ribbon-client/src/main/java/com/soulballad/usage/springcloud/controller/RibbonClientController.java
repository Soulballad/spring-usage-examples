package com.soulballad.usage.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : hello
 * @since ：2020/6/2 21:53
 */
@RestController
@RequestMapping(value = "/client")
public class RibbonClientController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancer;

    /**
     * 直接使用 ribbon api
     */
    @GetMapping(value = "/ribbon")
    public String ribbon() {
        ServiceInstance instance = loadBalancer.choose("nfx-ribbon-server");
        String host = instance.getHost();
        int port = instance.getPort();
        System.err.println("ribbon request: " + host + ":" + port);
        return "ribbon request: " + host + ":" + port;
    }

    /**
     * 使用 restTemplate 调用ribbon
     */
    @GetMapping(value = "/rest")
    public String rest() {
        return restTemplate.getForObject("http://nfx-ribbon-server/server/ribbon", String.class);
    }
}
