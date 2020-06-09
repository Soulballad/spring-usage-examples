package com.soulballad.usage.springcloud.controller;

import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : config
 * @since ：2020/6/9 20:24
 */
@RestController
@RequestMapping(value = "/config")
public class ArchaiusController {

    private final DynamicPropertyFactory propertyFactory = DynamicPropertyFactory.getInstance();

    @GetMapping(value = "/orderPoint")
    public String getOrderPoint() {
        DynamicStringProperty property = propertyFactory.getStringProperty("order.point.rate", "0.01");
        return property.getValue();
    }

    @GetMapping(value = "/userLevel")
    public Map<String, String> userLevel() {
        Map<String, String> propertyMap = new HashMap<>();

        DynamicStringProperty bronzeLevel = propertyFactory.getStringProperty("user.level.bronze", "1000");
        DynamicStringProperty sliverLevel = propertyFactory.getStringProperty("user.level.sliver", "2000");
        DynamicStringProperty goldenLevel = propertyFactory.getStringProperty("user.level.golden", "3000");
        DynamicStringProperty platinumLevel = propertyFactory.getStringProperty("user.level.platinum", "4000");
        DynamicStringProperty diamondLevel = propertyFactory.getStringProperty("user.level.diamond", "5000");
        DynamicStringProperty imperialLevel = propertyFactory.getStringProperty("user.level.imperial", "10000");

        propertyMap.put(bronzeLevel.getName(), bronzeLevel.getValue());
        propertyMap.put(sliverLevel.getName(), sliverLevel.getValue());
        propertyMap.put(goldenLevel.getName(), goldenLevel.getValue());
        propertyMap.put(platinumLevel.getName(), platinumLevel.getValue());
        propertyMap.put(diamondLevel.getName(), diamondLevel.getValue());
        propertyMap.put(imperialLevel.getName(), imperialLevel.getValue());

        return propertyMap;
    }
}
