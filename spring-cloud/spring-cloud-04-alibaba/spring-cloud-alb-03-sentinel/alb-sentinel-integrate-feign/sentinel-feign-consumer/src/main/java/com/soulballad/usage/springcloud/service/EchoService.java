package com.soulballad.usage.springcloud.service;

import com.soulballad.usage.springcloud.fallback.EchoServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : feign service
 * @since ：2020/6/28 20:14
 */
@FeignClient(name = "sentinel-feign-provider", fallbackFactory = EchoServiceFallbackFactory.class)
public interface EchoService {

    @GetMapping(value = "/echo/{str}")
    String echo(@PathVariable("str") String str);
}
