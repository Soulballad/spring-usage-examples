package com.soulballad.usage.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : config
 * @since ：2020/6/22 21:19
 */
@RestController
@RefreshScope
public class NacosConfigController {

    // dataId 规则： ${prefix}-${spring.profile.active}.${file-extension}  alb-nacos-config.yaml
    // prefix 默认为 spring.application.name 的值，也可以通过配置项 spring.cloud.nacos.config.prefix 来配置
    @Value("${albNacosConfigInfo:nacos-defalut}")
    public String configInfo;

    @GetMapping(value = "/configInfo")
    public Object configInfo() {
        return configInfo;
    }
}
