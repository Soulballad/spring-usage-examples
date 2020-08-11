package com.soulballad.usage.springcloud.feign.api;

import com.soulballad.usage.springcloud.feign.fallback.FeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : feign api
 * @since ：2020/6/17 21:59
 */
@FeignClient(value = "ofc-sleuth-client-a", fallback = FeignFallback.class)
public interface FeignApi {

    @RequestMapping("/port")
    String port();
}
