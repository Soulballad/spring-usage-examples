package com.soulballad.usage.springboot.service;

import java.util.List;

import com.soulballad.usage.springboot.model.UserModel;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user service
 * @since ：2020/5/23 22:35
 */
public interface UserService {

    /**
     * 根据id查找
     * @param id id
     * @return userModel
     */
    UserModel findUserById(Long id);

    /**
     * 根据名称查找
     * @param name name
     * @return userModel
     */
    UserModel findUserByName(String name);

    /**
     * 查询所有
     * @return userModel
     */
    List<UserModel> findAll();

    /**
     * 新增
     * @param userModel userModel
     * @return userModel
     */
    UserModel addUser(UserModel userModel);

    /**
     * 新增2
     * @param userModel userModel
     * @return userModel
     */
    UserModel insertUser(UserModel userModel);

    /**
     * 新增并获取主键
     * @param userModel userModel
     * @return userModel
     */
    UserModel insertAndGetPK(UserModel userModel);

    /**
     * 根据id更新地址
     * @param address 地址
     * @param id id
     * @return userModel
     */
    UserModel updateAddressById(String address, Long id);

    /**
     * 根据id删除
     * @param id id
     * @return userModel
     */
    UserModel deleteById(Long id);
}
