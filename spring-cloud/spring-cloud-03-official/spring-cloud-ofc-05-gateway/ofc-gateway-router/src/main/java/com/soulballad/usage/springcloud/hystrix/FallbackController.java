package com.soulballad.usage.springcloud.hystrix;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : fallback
 * @since ：2020/6/14 19:11
 */
@RestController
public class FallbackController {

    @RequestMapping(value = "/fallback")
    public String fallback() {
        return "spring cloud gateway is now fallback!";
    }
}
