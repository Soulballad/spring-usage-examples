package com.soulballad.usage.springcloud.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.function.Supplier;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : rest
 * @since ：2020/6/13 22:46
 */
@Service
public class HttpRestService {

    private RestTemplate restTemplate;

    public HttpRestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map get() {
        return restTemplate.getForObject("http://www.soulballad.com/get", Map.class);
    }

    public Map delay(int seconds) {
        return restTemplate.getForObject("http://www.soulballad.com/delay/" + seconds, Map.class);
    }

    public Supplier<Map> delaySupplier(int seconds) {
        return () -> this.delay(seconds);
    }
}
