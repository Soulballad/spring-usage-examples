package com.soulballad.usage.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : call consul service
 * @since ：2020/6/12 21:12
 */
@RestController
public class ServiceController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 获取所有服务
     */
    @GetMapping(value = "/services")
    public List<ServiceInstance> services() {
        // provider 中 spring.cloud.consul.discovery.service-name 配置
        return discoveryClient.getInstances("csl-provider");
    }

    /**
     * 从所有服务中选择一个服务（轮询）
     */
    @GetMapping(value = "/discover")
    public String discover() {
        return loadBalancerClient.choose("csl-provider").getUri().toString();
    }
}
