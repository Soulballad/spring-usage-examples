package com.soulballad.usage.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.soulballad.usage.springcloud.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : provider
 * @since ：2020/6/14 16:10
 */
@RestController
public class UserServerController {

    private static final Map<Long, UserModel> USER_MAP = new HashMap<>();
    private static final AtomicLong ID_GENERATOR = new AtomicLong(2);
    private final Random random = new Random();
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServerController.class);

    @GetMapping(value = "/user/list")
    @HystrixCommand(fallbackMethod = "fallBackList", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
    })
    public List<UserModel> list() throws InterruptedException {
        int seconds = random.nextInt(200);
        LOGGER.info("user server controller list sleep for {} seconds!", seconds);
        Thread.sleep(seconds);
        return new ArrayList<>(USER_MAP.values());
    }

    @PostMapping(value = "/user/save")
    public UserModel save(@RequestBody UserModel userModel) {
        long id = ID_GENERATOR.incrementAndGet();
        userModel.setId(id);
        USER_MAP.put(id, userModel);
        return userModel;
    }

    public List<UserModel> fallBackList() {
        LOGGER.warn("user server controller list fallback!");
        return Collections.emptyList();
    }

    @PostConstruct
    public void init() {
        UserModel user1 = new UserModel(1L, "zhangsan", 20, "2000-01-01", "shenzhen", "13888888888");
        UserModel user2 = new UserModel(2L, "lisi", 21, "1999-01-01", "shanghai", "13777777777");
        USER_MAP.put(user1.getId(), user1);
        USER_MAP.put(user2.getId(), user2);
    }
}
