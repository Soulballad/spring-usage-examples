package com.soulballad.usage.springcloud.service;

import org.apache.dubbo.config.annotation.Reference;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : consumer
 * @since ：2020/6/27 22:16
 */
public class FooServiceConsumer {

    @Reference(version = "${foo.service.version}", application = "${dubbo.application.id}",
            url = "dubbo://localhost:20881?version=1.0.0", timeout = 30000)
    private FooService fooService;

    public String hello(String name) {
        return fooService.hello(name);
    }
}
