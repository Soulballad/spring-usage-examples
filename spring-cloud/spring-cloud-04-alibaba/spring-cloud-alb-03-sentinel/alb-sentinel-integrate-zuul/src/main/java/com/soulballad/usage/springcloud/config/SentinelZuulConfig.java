package com.soulballad.usage.springcloud.config;

import com.alibaba.csp.sentinel.adapter.gateway.zuul.callback.RequestOriginParser;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.fallback.BlockResponse;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.fallback.ZuulBlockFallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : config
 * @since ：2020/6/28 21:38
 */
@Configuration
public class SentinelZuulConfig {

    @Bean
    public ZuulBlockFallbackProvider zuulBlockFallbackProvider() {
        return new ZuulBlockFallbackProvider() {
            @Override
            public String getRoute() {
                return "*";
            }

            @Override
            public BlockResponse fallbackResponse(String route, Throwable cause) {
                String msgPrefix = "alb-sentinel-integrate-zuul blocked ";
                if ("my-service3".equals(route)) {
                    return new BlockResponse(433, msgPrefix + "my-service3", route);
                } else if ("my-service4".equals(route)) {
                    return new BlockResponse(444, msgPrefix + "my-service4", route);
                } else {
                    return new BlockResponse(499, msgPrefix + "default 499", route);
                }
            }
        };
    }

    @Bean
    public RequestOriginParser requestOriginParser() {
        return new RequestOriginParser() {
            @Override
            public String parseOrigin(HttpServletRequest request) {
                return "123";
            }
        };
    }
}
