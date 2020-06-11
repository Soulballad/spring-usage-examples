package com.soulballad.usage.springcloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Set;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : refresh
 * @since ：2020/6/11 21:13
 */
@Configuration
public class RefreshConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefreshConfig.class);

    private final ContextRefresher contextRefresher;

    @Autowired
    public RefreshConfig(ContextRefresher contextRefresher) {
        this.contextRefresher = contextRefresher;
    }

    // 定时刷新配置，每5秒执行一次，首次执行延迟3秒
    @Scheduled(fixedRate = 5 * 1000, initialDelay = 3 * 1000)
    public void autoRefresh() {
        Set<String> refresh = contextRefresher.refresh();
        if (!refresh.isEmpty()) {
            LOGGER.info("context refresh configs: " + refresh);
        }
    }
}
