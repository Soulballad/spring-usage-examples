package com.soulballad.usage.springboot.mapper;

import com.soulballad.usage.springboot.model.UserModel;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : mapper
 * @since ：2020/5/23 22:45
 */
public class UserRowMapper implements RowMapper<UserModel> {
    @Override
    public UserModel mapRow(ResultSet resultSet, int i) throws SQLException {
        UserModel userModel = new UserModel();
        userModel.setId(resultSet.getLong("id"));
        userModel.setName(resultSet.getString("name"));
        userModel.setAge(resultSet.getInt("age"));
        userModel.setBirthday(resultSet.getString("birthday"));
        userModel.setAddress(resultSet.getString("address"));
        userModel.setPhone(resultSet.getString("phone"));
        return userModel;
    }
}
