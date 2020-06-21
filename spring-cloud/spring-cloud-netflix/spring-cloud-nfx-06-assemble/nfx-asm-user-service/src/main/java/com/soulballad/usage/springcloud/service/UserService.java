package com.soulballad.usage.springcloud.service;

import com.soulballad.usage.springcloud.model.UserModel;

import java.util.List;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/6/5 21:21
 */
public interface UserService {

    List<UserModel> findAll();

    UserModel findById(Long id);

    UserModel findByUserName(String name);

    UserModel update(UserModel userModel);

    Integer deleteByName(String name);
}
