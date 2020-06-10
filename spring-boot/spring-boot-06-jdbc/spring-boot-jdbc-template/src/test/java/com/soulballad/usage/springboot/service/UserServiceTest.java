package com.soulballad.usage.springboot.service;

import com.soulballad.usage.springboot.model.UserModel;
import net.minidev.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : test
 * @since ：2020/5/24 11:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private JdbcTemplate masterJdbcTemplate;

    @Autowired
    private JdbcTemplate slaveJdbcTemplate;

    @Test
    public void test_findAll() {
        String sql = "select id, `name`, age, birthday, address, phone from t_user";
        List<UserModel> masterUserList = masterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserModel.class));
        List<UserModel> slaveUserList = slaveJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserModel.class));

        System.err.println(JSONArray.toJSONString(masterUserList));
        System.err.println(JSONArray.toJSONString(slaveUserList));
    }

    @Test
    public void test_add() {
        String sql = "INSERT INTO t_user(`name`, age, birthday, address, phone) VALUES (?, ?, ?, ?, ?);";
        UserModel user = new UserModel("xx123", 22, "1998-05-24", "changsha", "18222222222");
        masterJdbcTemplate.update(sql, user.getName(), user.getAge(), user.getBirthday(), user.getAddress(), user.getPhone());
        slaveJdbcTemplate.update(sql, user.getName(), user.getAge(), user.getBirthday(), user.getAddress(), user.getPhone());
    }

    @Test
    public void test_update() {
        String sql = "UPDATE t_user set address = ? where id = ?";
        String address = "wuhu";
        Long id = 5L;
        masterJdbcTemplate.update(sql, address, id);
        slaveJdbcTemplate.update(sql, address, id);
    }
}
