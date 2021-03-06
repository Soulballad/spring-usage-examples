package com.soulballad.usage.springcloud.service;

import java.util.List;

import com.soulballad.usage.springcloud.model.UserModel;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/5/31 21:56
 */
public interface UserService {

    List<UserModel> findAll();

    UserModel findById(Long id);

    UserModel add(UserModel userModel);

    UserModel update(UserModel userModel);

    UserModel deleteById(Long id);
}
