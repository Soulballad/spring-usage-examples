package com.soulballad.usage.springboot.model;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user实体类
 * @since ：2020/5/20 18:59
 */
public class User {

    /**
     * id
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }
}
