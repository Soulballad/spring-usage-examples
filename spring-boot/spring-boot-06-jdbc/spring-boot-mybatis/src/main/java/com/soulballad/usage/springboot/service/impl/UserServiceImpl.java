package com.soulballad.usage.springboot.service.impl;

import com.soulballad.usage.springboot.mapper.UserMapper;
import com.soulballad.usage.springboot.model.UserModel;
import com.soulballad.usage.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : impl
 * @since ：2020/7/20 21:37
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserModel> selectList() {
        return userMapper.findAll();
    }

    @Override
    public UserModel findUserByName(String name) {
        return userMapper.findUserByName(name);
    }

    @Override
    public List<UserModel> findUserByPhone(String phone) {
        return userMapper.findUserByPhone(phone);
    }

    @Override
    public UserModel updateByName(String phone, String name) {
        UserModel userModel = new UserModel();
        userModel.setPhone(phone);
        userModel.setName(name);
        userMapper.updateByName(userModel);
        return findUserByName(name);
    }

    @Override
    public UserModel deleteByName(String name) {
        UserModel user = findUserByName(name);
        userMapper.deleteByName(name);
        return user;
    }

    @Override
    public UserModel add(UserModel user) {
        userMapper.insertUser(user);
        return findUserByName(user.getName());
    }
}
