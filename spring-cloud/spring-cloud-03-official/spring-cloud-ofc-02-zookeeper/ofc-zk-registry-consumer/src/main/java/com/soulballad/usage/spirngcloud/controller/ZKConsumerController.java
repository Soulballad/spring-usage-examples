package com.soulballad.usage.spirngcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : consumer
 * @since ：2020/6/13 20:48
 */
@RestController
@RequestMapping(value = "/consumer")
public class ZKConsumerController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/demo")
    public String demo() {
        String url = "http://ofc-zk-registry-provider/provider";
        return restTemplate.getForObject(url + "/hello", String.class);
    }

    @GetMapping(value = "/services")
    public List<ServiceInstance> services() {
        return discoveryClient.getInstances("ofc-zk-registry-provider");
    }
}
