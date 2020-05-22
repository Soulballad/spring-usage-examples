package com.soulballad.usage.springboot;

import com.soulballad.usage.springboot.service.EmailSenderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootEmailApplicationTests {

    @Autowired
    private EmailSenderService senderService;

    @Test
    public void contextLoads() {}

    @Test
    public void test_send_simpleEmail() {
        senderService.sendSimpleEmail("bbb@324.com", "test", "test");
    }
}
