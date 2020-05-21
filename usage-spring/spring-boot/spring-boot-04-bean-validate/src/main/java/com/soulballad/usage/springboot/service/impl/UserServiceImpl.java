package com.soulballad.usage.springboot.service.impl;

import com.soulballad.usage.springboot.model.User;
import com.soulballad.usage.springboot.repository.UserRepository;
import com.soulballad.usage.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : userServiceImpl
 * @since ：2020/5/21 20:02
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> selectAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User delete(Long id) {
        User user = getUserById(id);
        userRepository.deleteById(id);
        return user;
    }
}
