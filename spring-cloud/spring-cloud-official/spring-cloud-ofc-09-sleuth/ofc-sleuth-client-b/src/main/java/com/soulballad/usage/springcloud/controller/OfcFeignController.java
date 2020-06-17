package com.soulballad.usage.springcloud.controller;

import com.soulballad.usage.springcloud.feign.api.FeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : feign
 * @since ：2020/6/17 22:02
 */
@RestController
public class OfcFeignController {

    private final FeignApi feignApi;

    @Autowired
    public OfcFeignController(FeignApi feignApi) {
        this.feignApi = feignApi;
    }

    @RequestMapping(value = "/aPort")
    public String clientAPort() {
        return feignApi.port();
    }
}
