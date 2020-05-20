package com.soulballad.usage.springboot.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.soulballad.usage.springboot.model.User;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user repository
 * @since ：2020/5/20 19:06
 */
@Repository
public class UserRepository {

    // 生成id
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();

    // 模拟内存数据库
    private static final Map<Integer, User> USER_MAP = new HashMap<>();

    public List<User> selectAll() {
        return new ArrayList<>(USER_MAP.values());
    }

    public User getUserById(Integer id) {
        return USER_MAP.get(id);
    }

    public User addUser(User user) {
        if (Objects.isNull(user.getId())) {
            user.setId(ID_GENERATOR.incrementAndGet());
        }
        USER_MAP.put(user.getId(), user);
        return user;
    }

    public User update(User user) {
        USER_MAP.put(user.getId(), user);
        return user;
    }

    public User delete(Integer id) {
        return USER_MAP.remove(id);
    }

    public boolean exist(User user) {
        List<String> nameList = USER_MAP.values().stream().map(User::getName).collect(Collectors.toList());
        return nameList.contains(user.getName());
    }
}
