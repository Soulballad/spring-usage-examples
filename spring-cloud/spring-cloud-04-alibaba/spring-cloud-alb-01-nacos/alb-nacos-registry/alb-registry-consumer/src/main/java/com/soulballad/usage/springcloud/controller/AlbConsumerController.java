package com.soulballad.usage.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : consumer
 * @since ：2020/6/22 22:16
 */
@RestController
@RequestMapping(value = "/consumer")
public class AlbConsumerController {

    private final RestTemplate restTemplate;

    @Autowired
    public AlbConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/echo/{str}")
    public String echo(@PathVariable String str) {
        return restTemplate.getForObject("http://alb-registry-provider/provider/echo/" + str, String.class);
    }
}
