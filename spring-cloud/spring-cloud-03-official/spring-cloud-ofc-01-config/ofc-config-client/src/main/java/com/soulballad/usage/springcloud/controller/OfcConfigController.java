package com.soulballad.usage.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : config
 * @since ：2020/6/11 21:08
 */
// 1. 需要开启actuator端点，然后调用刷新接口才能生效； 2. 多节点的情况下，只有调用了刷新接口的节点生效，其他节点未变；
@RefreshScope
@RestController
public class OfcConfigController {

    @Value("${my.name}")
    private String name;

    @GetMapping(value = "/name")
    public String getName() {
        return name;
    }
}
