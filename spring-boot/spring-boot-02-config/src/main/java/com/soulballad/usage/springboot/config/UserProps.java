package com.soulballad.usage.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user属性
 * @since ：2020/5/19 20:33
 */
@Component
public class UserProps {
    @Value("${user.prop.name}")
    private String name;

    @Value("${user.prop.age}")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
