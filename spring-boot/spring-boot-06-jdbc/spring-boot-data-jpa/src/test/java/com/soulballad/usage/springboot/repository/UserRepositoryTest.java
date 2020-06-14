package com.soulballad.usage.springboot.repository;

import com.soulballad.usage.springboot.SpringBootJpaDemoApplicationTests;
import com.soulballad.usage.springboot.model.User;
import net.minidev.json.JSONValue;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.io.IOException;
import java.io.StringWriter;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user test
 * @since ：2020/5/23 16:35
 */
public class UserRepositoryTest extends SpringBootJpaDemoApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test_findUserByName() {
        User user = userRepository.findUserByName("zhangsan");
        System.err.println(user);
    }

    @Test
    public void test_findUserByPhone() {
        User user = userRepository.findUserByName("13666666666");
        System.err.println(user);
    }

    @Test
    public void test_findByPage() {
        int pageNum = 1, pageSize = 3;
        Sort ageDesc = Sort.by(Sort.Direction.DESC, "age");
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize, ageDesc);
        Page<User> userPage = userRepository.findByPage(pageRequest);
        System.err.println(JSONValue.toJSONString(userPage));
    }

    @Test
    public void test_updateByName() {
        userRepository.updateByName("18777777777", "lisi");
        System.err.println(userRepository.findUserByName("lisi"));
    }

    @Test
    public void test_updateByPhone() {
        userRepository.deleteByName("lisi");
        System.err.println(userRepository.findUserByName("lisi"));
    }
}
