package com.soulballad.usage.springcloud.feign.fallback;

import com.soulballad.usage.springcloud.feign.api.FeignApi;
import org.springframework.stereotype.Component;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : fallback
 * @since ：2020/6/17 22:01
 */
@Component
public class FeignFallback implements FeignApi {
    @Override
    public String port() {
        return "sorry! feign client has fallback!";
    }
}
