package com.soulballad.usage.springcloud.vo;

import java.math.BigDecimal;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/6/5 21:07
 */
public class UserVo {
    private Long id;
    private String name;
    private Integer age;
    private String birthday;
    private String address;
    private String phone;
    private BigDecimal money; // 余额
    private Integer points; // 积分

    public UserVo() {}

    public UserVo(String name, Integer age, String birthday, String address, String phone, BigDecimal money,
        Integer points) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.money = money;
        this.points = points;
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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "UserModel{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", birthday='" + birthday + '\''
            + ", address='" + address + '\'' + ", phone='" + phone + '\'' + ", money=" + money + ", points=" + points
            + '}';
    }
}
