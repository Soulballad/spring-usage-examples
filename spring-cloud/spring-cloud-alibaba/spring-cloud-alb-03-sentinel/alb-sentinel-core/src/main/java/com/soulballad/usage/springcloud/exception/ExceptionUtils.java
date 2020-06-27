package com.soulballad.usage.springcloud.exception;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : exception util
 * @since ：2020/6/27 17:34
 */
public class ExceptionUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionUtils.class);

    private ExceptionUtils() {
    }

    public static SentinelClientHttpResponse handleException(HttpRequest request, byte[] body,
        ClientHttpRequestExecution execution, BlockException be) {
        LOGGER.info("handleException Oops: {}", be.getClass().getCanonicalName());
        return new SentinelClientHttpResponse("the request has been blocked!");
    }
}
