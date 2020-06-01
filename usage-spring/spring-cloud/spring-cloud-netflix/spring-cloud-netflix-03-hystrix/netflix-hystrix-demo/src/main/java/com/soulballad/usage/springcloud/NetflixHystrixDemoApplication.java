package com.soulballad.usage.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : hystrix demo
 * @since ：2020/6/1 20:53
 */
@EnableHystrix // 启用 hystrix
@SpringBootApplication
public class NetflixHystrixDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixHystrixDemoApplication.class, args);
    }
}
