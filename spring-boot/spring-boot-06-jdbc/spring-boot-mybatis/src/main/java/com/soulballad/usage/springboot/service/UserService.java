package com.soulballad.usage.springboot.service;

import com.soulballad.usage.springboot.model.UserModel;

import java.util.List;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : service
 * @since ：2020/7/20 21:35
 */
public interface UserService {

    /**
     * 查询所有数据
     * @return user
     */
    List<UserModel> selectList();

    /**
     * 根据名称查询
     * @param name name
     * @return user
     */
    UserModel findUserByName(String name);

    /**
     * 根据电话查询
     * @param phone 电话
     * @return user
     */
    List<UserModel> findUserByPhone(String phone);

    /**
     * 根据名称更新电话
     * @param phone 电话
     * @param name 名称
     * @return 影响行数
     */
    UserModel updateByName(String phone, String name);

    /**
     * 根据名称删除
     * @param name 名称
     * @return 影响行数
     */
    UserModel deleteByName(String name);

    /**
     * 新增
     * @param user user
     * @return user
     */
    UserModel add(UserModel user);
}
