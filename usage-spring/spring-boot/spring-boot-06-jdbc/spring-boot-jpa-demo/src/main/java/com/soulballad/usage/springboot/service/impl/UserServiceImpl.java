package com.soulballad.usage.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.soulballad.usage.springboot.model.User;
import com.soulballad.usage.springboot.repository.UserRepository;
import com.soulballad.usage.springboot.service.UserService;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/5/23 10:41
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> selectList() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public List<User> findUserByPhone(String phone) {
        return userRepository.findUserByPhone(phone);
    }

    @Override
    public Page<User> findByPage(Pageable pageable) {
        return userRepository.findByPage(pageable);
    }

    @Override
    public User updateByName(String phone, String name) {
        userRepository.updateByName(phone, name);
        return findUserByName(name);
    }

    @Override
    public User deleteByName(String name) {
        User user = findUserByName(name);
        userRepository.deleteByName(name);
        return user;
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }
}
