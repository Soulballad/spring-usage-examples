package com.soulballad.usage.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/5/23 17:42
 */
@Entity
@Table(name = "t_user")
public class UserModel {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true, length = 32)
    private String name;
    @Column(nullable = false)
    private Integer age;
    @Column(length = 32)
    private String birthday;
    private String address;
    @Column(nullable = false, length = 16)
    private String phone;

    public UserModel() {}

    public UserModel(String name, Integer age, String birthday, String address, String phone) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserModel{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", birthday='" + birthday + '\''
            + ", address='" + address + '\'' + ", phone='" + phone + '\'' + '}';
    }
}
