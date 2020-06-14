package com.soulballad.usage.springcloud.fallback;

import com.soulballad.usage.springcloud.model.UserModel;
import com.soulballad.usage.springcloud.service.UserService;

import java.util.Collections;
import java.util.List;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : fallback
 * @since ：2020/6/14 16:03
 */
public class UserServiceFallback implements UserService {
    @Override
    public List<UserModel> list() {
        return Collections.emptyList();
    }

    @Override
    public UserModel save(UserModel userModel) {
        return new UserModel();
    }
}
