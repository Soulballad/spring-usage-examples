package com.soulballad.usage.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/5/22 22:17
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true, length = 32)
    private String name;
    private String birthday;
    private String address;
    @Column(nullable = false, length = 16)
    private String phone;

    public User() {}

    public Long getId() {
        return id;
    }

    public User(String name, String birthday, String address, String phone) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
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
}
