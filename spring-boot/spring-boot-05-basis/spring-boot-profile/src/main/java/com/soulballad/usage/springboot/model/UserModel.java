package com.soulballad.usage.springboot.model;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/7/12 21:06
 */
public class UserModel {

    private String name;

    @Value("${user.age}")
    private String age;

    public UserModel(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public UserModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserModel{name='" + name + '\'' + ", age='" + age + '\'' + '}';
    }
}
