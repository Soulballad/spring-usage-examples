package com.soulballad.usage.springcloud.service;

import com.soulballad.usage.springcloud.model.UserModel;

import java.util.List;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : service
 * @since ：2020/6/23 21:25
 */
public interface UserService {

    List<UserModel> findAll();

    boolean save(UserModel userModel);

    boolean delete(Long id);
}
