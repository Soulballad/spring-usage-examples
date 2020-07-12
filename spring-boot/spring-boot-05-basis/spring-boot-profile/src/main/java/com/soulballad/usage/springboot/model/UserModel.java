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
    private Integer age;

    public UserModel(String name, Integer age) {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserModel{name='" + name + '\'' + ", age='" + age + '\'' + '}';
    }
}
