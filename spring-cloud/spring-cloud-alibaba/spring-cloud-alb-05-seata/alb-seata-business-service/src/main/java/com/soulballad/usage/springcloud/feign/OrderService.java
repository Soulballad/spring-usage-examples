package com.soulballad.usage.springcloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : feign client
 * @since ：2020/6/30 21:49
 */
@FeignClient("alb-seata-order-service")
public interface OrderService {

    @PostMapping(path = "/order")
    String order(@RequestParam("userId") String userId,
                 @RequestParam("commodityCode") String commodityCode,
                 @RequestParam("orderCount") Integer orderCount);
}
