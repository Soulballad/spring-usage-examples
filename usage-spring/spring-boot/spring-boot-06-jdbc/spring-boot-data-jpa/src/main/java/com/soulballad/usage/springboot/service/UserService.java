package com.soulballad.usage.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.soulballad.usage.springboot.model.User;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/5/23 10:40
 */
public interface UserService {

    /**
     * 查询所有数据
     * @return user
     */
    List<User> selectList();

    /**
     * 根据名称查询
     * @param name name
     * @return user
     */
    User findUserByName(String name);

    /**
     * 根据电话查询
     * @param phone 电话
     * @return user
     */
    List<User> findUserByPhone(String phone);

    /**
     * 分页查询
     * @param pageable 分页参数
     * @return user
     */
    Page<User> findByPage(Pageable pageable);

    /**
     * 根据名称更新电话
     * @param phone 电话
     * @param name 名称
     * @return 影响行数
     */
    User updateByName(String phone, String name);

    /**
     * 根据名称删除
     * @param name 名称
     * @return 影响行数
     */
    User deleteByName(String name);

    /**
     * 新增
     * @param user user
     * @return user
     */
    User add(User user);
}
