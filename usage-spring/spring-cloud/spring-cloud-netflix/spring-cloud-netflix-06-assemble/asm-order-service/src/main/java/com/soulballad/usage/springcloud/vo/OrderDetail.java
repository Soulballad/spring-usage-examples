package com.soulballad.usage.springcloud.vo;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : detail
 * @since ：2020/6/5 21:49
 */
public interface OrderDetail {
    Long getUserId();
    Long getOrderId();
    Integer getAge();
    String getOrderCode();
    String getAddress();
    String getPhone();
    String getOrderDate();
}
