package com.soulballad.usage.springboot;

import com.soulballad.usage.springboot.model.User;
import com.soulballad.usage.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : command
 * @since ：2020/5/21 20:11
 */
@Component
public class UserCommand implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        // 身份证号由 http://sfz.uzuzuz.com/ 在线生成
        User user1 = new User("zhangsan", 23, "110101200303072399");
        User user2 = new User("lisi", 34, "110113198708074275");
        User user3 = new User("wangwu", 45, "110113197308182272");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));
        userRepository.deleteById(3L);
    }
}
