package com.soulballad.usage.springboot.service.impl;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.soulballad.usage.springboot.mapper.UserRowMapper;
import com.soulballad.usage.springboot.model.UserModel;
import com.soulballad.usage.springboot.service.UserService;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user service impl
 * @since ：2020/5/23 22:42
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserModel findUserById(Long id) {
        String sql = "select id, `name`, age, birthday, address, phone from t_user where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new UserRowMapper());
    }

    @Override
    public UserModel findUserByName(String name) {
        String sql = "select id, `name`, age, birthday, address, phone from t_user where name = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {name}, new UserRowMapper());
    }

    @Override
    public List<UserModel> findAll() {
        String sql = "select id, `name`, age, birthday, address, phone from t_user";
        return jdbcTemplate.queryForList(sql, UserModel.class);
    }

    @Override
    public UserModel addUser(UserModel user) {
        String sql = "INSERT INTO t_user(`name`, age, birthday, address, phone) VALUES (?, ?, ?, ?, ?);";
        // jdbcTemplate.update(sql, new Object[] {user.getName(), user.getAge(), user.getBirthday(), user.getAddress(),
        // user.getPhone()});
        // 批量操作使用 batchUpdate
        jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getBirthday(), user.getAddress(), user.getPhone());
        return findUserByName(user.getName());
    }

    @Override
    public UserModel insertUser(UserModel user) {
        String sql = "INSERT INTO t_user(`name`, age, birthday, address, phone) VALUES (?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, ps -> {
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.setString(3, user.getBirthday());
            ps.setString(4, user.getAddress());
            ps.setString(5, user.getPhone());
        });
        return findUserByName(user.getName());
    }

    @Override
    public UserModel insertAndGetPK(UserModel user) {
        String sql = "INSERT INTO t_user(`name`, age, birthday, address, phone) VALUES (?, ?, ?, ?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.setString(3, user.getBirthday());
            ps.setString(4, user.getAddress());
            ps.setString(5, user.getPhone());
            return ps;
        }, keyHolder);
        long pk = keyHolder.getKey().longValue();
        return findUserById(pk);
    }

    @Override
    public UserModel updateAddressById(String address, Long id) {
        String sql = "UPDATE t_user set address = ? where id = ?";
        jdbcTemplate.update(sql, address, id);
        return findUserById(id);
    }

    @Override
    public UserModel deleteById(Long id) {
        String sql = "DELETE FROM t_user where id = ?";
        UserModel user = findUserById(id);
        jdbcTemplate.update(sql, id);
        return user;
    }
}
