package com.soulballad.usage.springcloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : feign client
 * @since ：2020/6/30 21:46
 */
@FeignClient("alb-seata-storage-service")
public interface StorageService {

    @GetMapping(path = "/storage/{commodityCode}/{count}")
    String storage(@PathVariable("commodityCode") String commodityCode, @PathVariable("count") Integer count);
}
