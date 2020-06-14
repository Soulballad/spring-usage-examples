package com.soulballad.usage.springcloud.service;

import com.soulballad.usage.springcloud.fallback.UserServiceFallback;
import com.soulballad.usage.springcloud.model.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : feign
 * @since ：2020/6/14 16:00
 */
// 服务提供方的应用名称
@FeignClient(value = "ofc-feign-user-server", fallback = UserServiceFallback.class)
public interface UserService {

    @GetMapping(value = "/user/list")
    List<UserModel> list();

    @PostMapping(value = "/user/save")
    UserModel save(@RequestBody UserModel userModel);
}
