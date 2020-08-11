package com.soulballad.usage.springcloud.service;

import com.soulballad.usage.springcloud.model.UserModel;
import org.apache.dubbo.config.annotation.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user service
 * @since ：2020/6/23 21:49
 */
@Service(protocol = "dubbo")
public class UserServiceImpl implements UserService {

    private static final Map<Long, UserModel> USER_MAP = new HashMap<>();

    @Override
    public List<UserModel> findAll() {
        return new ArrayList<>(USER_MAP.values());
    }

    @Override
    public boolean save(UserModel userModel) {
        return USER_MAP.put(userModel.getId(), userModel) == null;
    }

    @Override
    public boolean delete(Long id) {
        return USER_MAP.remove(id) != null;
    }
}
