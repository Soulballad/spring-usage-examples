package com.soulballad.usage.springcloud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soulballad.usage.springcloud.model.UserModel;
import com.soulballad.usage.springcloud.repository.UserRepository;
import com.soulballad.usage.springcloud.service.UserService;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/6/5 21:28
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserModel findById(Long id) {
        Optional<UserModel> userOpt = userRepository.findById(id);
        return userOpt.get();
    }

    @Override
    public UserModel findByUserName(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public UserModel update(UserModel userModel) {
        userRepository.save(userModel);
        return findByUserName(userModel.getName());
    }

    @Override
    public Integer deleteByName(String name) {
        return userRepository.deleteByName(name);
    }
}
