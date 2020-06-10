package com.soulballad.usage.springboot.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user 这里为了测试类型转换，特意加了不同类型的参数
 * @since ：2020/5/28 20:17
 */
public class UserModel {

    private Long id;
    private String name;
    private Integer age;
    private Date birthday;
    private BigDecimal salary;
    private String phone;

    public UserModel() {}

    public UserModel(Long id, String name, Integer age, Date birthday, BigDecimal salary, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.salary = salary;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserModel{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", birthday=" + birthday
            + ", salary=" + salary + ", phone='" + phone + '\'' + '}';
    }
}
