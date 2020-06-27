package com.soulballad.usage.springcloud.service;

import org.apache.dubbo.config.annotation.Service;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : service
 * @since ：2020/6/27 22:10
 */
@Service(version = "${foo.service.version}", application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}", registry = "${dubbo.registry.id}")
public class FooServiceImpl implements FooService {
    @Override
    public String hello(String name) {
        return "hello sentinel-dubbo-provider: " + name;
    }
}
