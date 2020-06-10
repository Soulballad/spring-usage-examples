package com.soulballad.usage.springboot.service;

import java.util.List;

import com.soulballad.usage.springboot.model.UserModel;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/5/26 21:10
 */
public interface UserService {

    List<UserModel> findAll();

    UserModel findById(Long id);

    UserModel add(UserModel userModel);

    UserModel update(UserModel userModel);

    UserModel deleteById(Long id);
}
