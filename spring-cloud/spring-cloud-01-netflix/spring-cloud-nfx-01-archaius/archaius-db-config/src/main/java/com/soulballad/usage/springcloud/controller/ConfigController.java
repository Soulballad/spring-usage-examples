package com.soulballad.usage.springcloud.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote :
 * @since ：2020/5/31 17:23
 */
@RestController
public class ConfigController {

    private final DynamicPropertyFactory propertyFactory = DynamicPropertyFactory.getInstance();

    @GetMapping(value = "/config")
    public Map<String, String> getConfig() {

        Map<String, String> propertyMap = new HashMap<>();

        DynamicStringProperty dbOne =
            propertyFactory.getStringProperty("spring.cloud.netflix.archaius.db.one", "db one not found");
        DynamicStringProperty dbTwo =
            propertyFactory.getStringProperty("spring.cloud.netflix.archaius.db.two", "db two not found");
        DynamicStringProperty dbThree =
            propertyFactory.getStringProperty("spring.cloud.netflix.archaius.db.three", "db three not found");

        propertyMap.put(dbOne.getName(), dbOne.getValue());
        propertyMap.put(dbTwo.getName(), dbTwo.getValue());
        propertyMap.put(dbThree.getName(), dbThree.getValue());

        return propertyMap;
    }
}
