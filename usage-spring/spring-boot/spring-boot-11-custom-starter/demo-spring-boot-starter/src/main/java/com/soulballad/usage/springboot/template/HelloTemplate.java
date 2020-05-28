package com.soulballad.usage.springboot.template;

import java.util.Map;

import com.soulballad.usage.springboot.hello.Hello;
import com.soulballad.usage.springboot.properties.HelloProperties;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote :
 * @since ：2020/5/28 22:07
 */
public class HelloTemplate {

    private Hello hello;
    private HelloProperties helloProperties;

    public HelloTemplate(Hello hello, HelloProperties helloProperties) {
        this.hello = hello;
        this.helloProperties = helloProperties;
    }

    public String hello() {
        Map<String, Object> objectMap = helloProperties.getDetail();
        String helloName = hello.getClass().getSimpleName();
        String description = "helloName: " + helloName + ", properties: " + objectMap.toString();
        return hello.hello() + ", " + description;
    }
}
