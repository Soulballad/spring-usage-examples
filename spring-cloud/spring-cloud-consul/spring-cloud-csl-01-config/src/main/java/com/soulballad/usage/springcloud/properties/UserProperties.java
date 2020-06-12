package com.soulballad.usage.springcloud.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/6/12 20:22
 */
@ConfigurationProperties(prefix = "user")
public class UserProperties {

    private String name;
    private int age;
    private String birthday;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserProperties{name='" + name + '\'' + ", age=" + age + ", birthday=" + birthday + ", phone='" + phone + '\'' + '}';
    }
}
