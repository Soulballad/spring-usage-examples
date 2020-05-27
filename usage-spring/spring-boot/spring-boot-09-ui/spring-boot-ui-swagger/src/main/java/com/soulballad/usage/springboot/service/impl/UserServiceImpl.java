package com.soulballad.usage.springboot.service.impl;

import com.soulballad.usage.springboot.model.UserModel;
import com.soulballad.usage.springboot.repository.UserRepository;
import com.soulballad.usage.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/5/27 20:45
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
        return userRepository.findById(id);
    }

    @Override
    public UserModel add(UserModel userModel) {
        return userRepository.add(userModel);
    }

    @Override
    public UserModel update(UserModel userModel) {
        return userRepository.update(userModel);
    }

    @Override
    public UserModel deleteById(Long id) {
        return userRepository.deleteById(id);
    }
}
