package com.soulballad.usage.springboot.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.soulballad.usage.springboot.model.UserModel;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/5/28 20:20
 */
@Repository
public class UserRepository {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(2);

    private static final Map<Long, UserModel> USER_MAP = new HashMap<>();

    @PostConstruct
    public void init() {
        UserModel user1 =
            new UserModel(1L, "zhangsan", 20, new Date(), new BigDecimal("23456.11"), "13666666666");
        UserModel user2 =
            new UserModel(2L, "lisi", 30, new Date(), new BigDecimal("12345.67"), "13888888888");
        USER_MAP.put(user1.getId(), user1);
        USER_MAP.put(user2.getId(), user2);
    }

    public List<UserModel> findAll() {
        return new ArrayList<>(USER_MAP.values());
    }

    public UserModel findById(Long id) {
        return USER_MAP.get(id);
    }

    public UserModel add(UserModel userModel) {
        long id = ID_GENERATOR.incrementAndGet();
        userModel.setId(id);
        USER_MAP.put(id, userModel);
        return userModel;
    }

    public UserModel update(UserModel userModel) {
        USER_MAP.put(userModel.getId(), userModel);
        return USER_MAP.get(userModel.getId());
    }

    public UserModel deleteById(Long id) {
        UserModel userModel = USER_MAP.get(id);
        USER_MAP.remove(id);
        return userModel;
    }
}
