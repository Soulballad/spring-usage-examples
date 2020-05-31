package com.soulballad.usage.springcloud.config;

import org.apache.commons.configuration.AbstractConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.config.DynamicConfiguration;
import com.netflix.config.FixedDelayPollingScheduler;
import com.netflix.config.PolledConfigurationSource;
import com.netflix.config.sources.URLConfigurationSource;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : config
 * @since ：2020/5/31 16:21
 */
@Configuration
public class FileLocationConfig {

    @Bean
    public AbstractConfiguration addApplicationPropertySource() {
        // 默认从 config.properties 中读取配置，这里自定义从 other.properties 中获取
        PolledConfigurationSource source = new URLConfigurationSource("classpath:other.properties");
        return new DynamicConfiguration(source, new FixedDelayPollingScheduler());
    }
}
