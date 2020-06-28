package com.soulballad.usage.springcloud.fallback;

import com.soulballad.usage.springcloud.service.EchoService;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote :
 * @since ：2020/6/28 20:16
 */
public class EchoServiceFallback implements EchoService {

    private Throwable throwable;

    public EchoServiceFallback(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public String echo(String str) {
        return "sentinel-feign-consumer fallback for error : " + throwable.getMessage();
    }
}
