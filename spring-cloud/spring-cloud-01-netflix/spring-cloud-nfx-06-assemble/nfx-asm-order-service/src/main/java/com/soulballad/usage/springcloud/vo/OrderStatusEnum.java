package com.soulballad.usage.springcloud.vo;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : enum
 * @since ：2020/6/5 22:16
 */
public enum OrderStatusEnum {

    WAIT("wait"), PAID("paid");

    private String key;

    OrderStatusEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
