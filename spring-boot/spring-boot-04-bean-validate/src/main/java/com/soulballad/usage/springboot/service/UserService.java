package com.soulballad.usage.springboot.service;

import com.soulballad.usage.springboot.model.User;

import java.util.List;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : service
 * @since ：2020/5/21 20:01
 */
public interface UserService {

    List<User> selectAll();

    User getUserById(Long id);

    User add(User user);

    User update(User user);

    User delete(Long id);
}
