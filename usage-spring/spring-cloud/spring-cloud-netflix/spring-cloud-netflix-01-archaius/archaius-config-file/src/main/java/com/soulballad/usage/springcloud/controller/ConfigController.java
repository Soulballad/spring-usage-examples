package com.soulballad.usage.springcloud.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : config
 * @since ：2020/5/31 15:28
 */
@RestController
@RequestMapping(value = "/config")
public class ConfigController {

    private final DynamicPropertyFactory propertyFactory = DynamicPropertyFactory.getInstance();

    @GetMapping(value = "/default")
    public Map<String, String> getDefaultConfig() {

        Map<String, String> propertyMap = new HashMap<>();

        // 默认从 config.properties 中读取配置信息
        DynamicStringProperty propertyOne =
            propertyFactory.getStringProperty("spring.cloud.netflix.archaius.config.one", "one not found");
        DynamicStringProperty propertyTwo =
            propertyFactory.getStringProperty("spring.cloud.netflix.archaius.config.two", "two not found");
        DynamicStringProperty propertyThree =
            propertyFactory.getStringProperty("spring.cloud.netflix.archaius.config.three", "three not found");
        DynamicStringProperty propertyFour =
            propertyFactory.getStringProperty("spring.cloud.netflix.archaius.config.four", "four not found");

        propertyMap.put(propertyOne.getName(), propertyOne.getValue());
        propertyMap.put(propertyTwo.getName(), propertyTwo.getValue());
        propertyMap.put(propertyThree.getName(), propertyThree.getValue());
        propertyMap.put(propertyFour.getName(), propertyFour.getValue());

        return propertyMap;
    }

    @GetMapping(value = "/extend")
    public Map<String, String> getExtendConfig() {

        Map<String, String> propertyMap = new HashMap<>();

        // 默认从 config.properties 中读取配置信息
        DynamicStringProperty propertyOne =
            propertyFactory.getStringProperty("spring.cloud.netflix.archaius.other.one", "one not found");
        DynamicStringProperty propertyTwo =
            propertyFactory.getStringProperty("spring.cloud.netflix.archaius.other.two", "two not found");
        DynamicStringProperty propertyThree =
            propertyFactory.getStringProperty("spring.cloud.netflix.archaius.other.three", "three not found");
        DynamicStringProperty propertyFour =
            propertyFactory.getStringProperty("spring.cloud.netflix.archaius.other.four", "four not found");

        propertyMap.put(propertyOne.getName(), propertyOne.getValue());
        propertyMap.put(propertyTwo.getName(), propertyTwo.getValue());
        propertyMap.put(propertyThree.getName(), propertyThree.getValue());
        propertyMap.put(propertyFour.getName(), propertyFour.getValue());

        return propertyMap;
    }
}
