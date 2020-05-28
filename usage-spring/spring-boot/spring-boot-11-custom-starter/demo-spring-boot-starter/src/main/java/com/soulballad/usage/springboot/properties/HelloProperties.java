package com.soulballad.usage.springboot.properties;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : properties
 * @since ：2020/5/28 22:08
 */
@Component
@ConfigurationProperties(prefix = HelloProperties.HELLO_PREFIX)
public class HelloProperties {

    public static final String HELLO_PREFIX = "com.soulballad.hello";

    private Map<String, Object> detail;

    public Map<String, Object> getDetail() {
        return detail;
    }

    public void setDetail(Map<String, Object> detail) {
        this.detail = detail;
    }
}
