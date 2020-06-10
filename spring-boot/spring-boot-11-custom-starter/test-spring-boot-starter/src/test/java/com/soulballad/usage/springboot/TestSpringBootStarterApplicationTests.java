package com.soulballad.usage.springboot;

import com.soulballad.usage.springboot.template.HelloTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSpringBootStarterApplicationTests {

    @Autowired
    private HelloTemplate helloTemplate;

    @Test
    public void contextLoads() {}

    @Test
    public void test() {
        String hello = helloTemplate.hello();
        System.out.println(hello);
    }
}
