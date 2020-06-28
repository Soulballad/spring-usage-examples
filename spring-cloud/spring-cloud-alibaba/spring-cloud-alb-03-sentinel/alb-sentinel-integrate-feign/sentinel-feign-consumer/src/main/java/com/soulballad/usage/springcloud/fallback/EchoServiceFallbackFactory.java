package com.soulballad.usage.springcloud.fallback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote :
 * @since ：2020/6/28 20:15
 */
@Component
public class EchoServiceFallbackFactory implements FallbackFactory<EchoServiceFallback> {

    @Override
    public EchoServiceFallback create(Throwable throwable) {
        return new EchoServiceFallback(throwable);
    }
}
