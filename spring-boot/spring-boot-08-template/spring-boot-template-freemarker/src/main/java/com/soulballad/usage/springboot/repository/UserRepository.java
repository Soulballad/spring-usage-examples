package com.soulballad.usage.springboot.repository;

import java.util.ArrayList;
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
 * @apiNote : repository
 * @since ：2020/5/24 22:25
 */
@Repository
public class UserRepository {

    // 预置两条数据，所以起始值从2开始
    private static final AtomicLong ID_GENERATOR = new AtomicLong(2);

    // 模拟数据库操作
    private static final Map<Long, UserModel> USER_MAP = new HashMap<>();

    @PostConstruct
    public void init() {
        UserModel user1 = new UserModel(1L, "zhangsan", 20, "2000-01-02", "beijing", "13666666666");
        UserModel user2 = new UserModel(2L, "lisi", 30, "1990-03-23", "shanghai", "13888888888");
        USER_MAP.put(user1.getId(), user1);
        USER_MAP.put(user2.getId(), user2);
    }

    public List<UserModel> findAll() {
        return new ArrayList<>(USER_MAP.values());
    }

    public UserModel findById(Long id) {
        return USER_MAP.containsKey(id) ? USER_MAP.get(id) : new UserModel();
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
