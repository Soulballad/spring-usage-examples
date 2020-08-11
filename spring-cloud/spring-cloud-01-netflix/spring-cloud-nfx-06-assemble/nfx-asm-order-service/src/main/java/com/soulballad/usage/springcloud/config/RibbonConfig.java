package com.soulballad.usage.springcloud.config;

import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RoundRobinRule;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : ribbon
 * @since ：2020/6/6 22:13
 */
// @Configuration
public class RibbonConfig {

    @Bean
    public IRule ribbonRule() {
        return new RoundRobinRule();
    }

    @Bean
    public IPing ribbonPing() {
        return new PingUrl();
    }
}
