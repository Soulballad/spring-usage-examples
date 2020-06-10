package com.soulballad.usage.springboot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.soulballad.usage.springboot.model.UserModel;
import com.soulballad.usage.springboot.repository.master.MasterUserRepository;
import com.soulballad.usage.springboot.repository.slave.SlaveUserRepository;

import java.util.Arrays;
import java.util.List;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : test
 * @since ：2020/5/23 21:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private MasterUserRepository masterUserRepository;

    @Autowired
    private SlaveUserRepository slaveUserRepository;

    @Before
    public void save() {
        UserModel user1 = new UserModel("zhangsan", 20, "2000-01-01", "shenzhen", "13888888888");
        UserModel user2 = new UserModel("lisi", 21, "1999-01-01", "shanghai", "13777777777");
        UserModel user3 = new UserModel("wangwu", 22, "1998-01-01", "beijing", "13666666666");
        UserModel user4 = new UserModel("zhaoliu", 23, "1997-01-01", "guangzhou", "13555555555");
        UserModel user5 = new UserModel("sunqi", 24, "1996-01-01", "wuhan", "13444444444");

        List<UserModel> userList = Arrays.asList(user1, user2, user3, user4, user5);

        masterUserRepository.saveAll(userList);
        slaveUserRepository.saveAll(userList);
    }

    @Test
    public void test_findByName() {
        UserModel masterUser = masterUserRepository.findByName("zhangsan");
        UserModel slaveUser = slaveUserRepository.findByName("zhangsan");
        System.err.println(masterUser);
        System.err.println(slaveUser);
    }

    @Test
    public void test_findUserByPhone() {
        UserModel masterUser = masterUserRepository.findByName("13666666666");
        UserModel slaveUser = slaveUserRepository.findByName("13666666666");
        System.err.println(masterUser);
        System.err.println(slaveUser);
    }
}
