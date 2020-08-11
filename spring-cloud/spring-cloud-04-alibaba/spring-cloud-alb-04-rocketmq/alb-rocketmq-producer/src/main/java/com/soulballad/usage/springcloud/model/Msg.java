package com.soulballad.usage.springcloud.model;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : dmq消息
 * @since ：2020/6/29 20:43
 */
public class Msg {

    private Integer id;
    private String bar;

    public Msg() {
    }

    public Msg(Integer id, String bar) {
        this.id = id;
        this.bar = bar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }

    @Override
    public String toString() {
        return "Msg{id=" + id + ", bar='" + bar + '\'' + '}';
    }
}
