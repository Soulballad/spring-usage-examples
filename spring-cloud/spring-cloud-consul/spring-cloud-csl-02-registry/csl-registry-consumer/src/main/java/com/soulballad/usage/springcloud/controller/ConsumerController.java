package com.soulballad.usage.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Optional;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : consumer
 * @since ：2020/6/12 21:17
 */
@RestController
public class ConsumerController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/call")
    public String call() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("csl-provider");
        // 使用 restTemplate 发送请求
        return new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/hello", String.class);
    }

    public Optional<URI> serviceUrl() {
        return discoveryClient.getInstances("csl-provider").stream().findFirst().map(ServiceInstance::getUri);
    }
}
