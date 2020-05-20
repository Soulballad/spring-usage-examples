package com.soulballad.usage.springboot.service;

import com.soulballad.usage.springboot.model.User;

import java.util.List;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user接口
 * @since ：2020/5/20 19:00
 */
public interface UserService {
    /**
     * 查询所有
     *
     * @return User
     */
    List<User> selectAll();

    /**
     * 根据id查询
     *
     * @param id id
     * @return User
     */
    User getUserById(Integer id);

    /**
     * 新增
     *
     * @param user user
     * @return user
     */
    User addUser(User user);

    /**
     * 更新
     *
     * @param user user
     * @return user
     */
    User update(User user);

    /**
     * 删除
     *
     * @param id id
     * @return user {@link User}
     */
    User delete(Integer id);

    /**
     * check exist
     *
     * @param user user
     * @return true/false
     */
    boolean exist(User user);
}
