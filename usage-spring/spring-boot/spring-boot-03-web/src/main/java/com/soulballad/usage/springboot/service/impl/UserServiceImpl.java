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
 * @apiNote : userService
 * @since ：2020/5/20 19:06
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> selectAll() {
        return userRepository.selectAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User addUser(User user) {
        return userRepository.addUser(user);
    }

    @Override
    public User update(User user) {
        return userRepository.update(user);
    }

    @Override
    public User delete(Integer id) {
        return userRepository.delete(id);
    }

    @Override
    public boolean exist(User user) {
        return userRepository.exist(user);
    }
}
