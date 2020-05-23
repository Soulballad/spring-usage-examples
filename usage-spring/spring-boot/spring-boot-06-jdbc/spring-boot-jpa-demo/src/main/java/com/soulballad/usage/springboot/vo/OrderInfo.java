package com.soulballad.usage.springboot.vo;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : order
 * @since ：2020/5/23 15:26
 */
public interface OrderInfo {

    Long getUserId();
    Long getOrderId();
    Integer getAge();
    String getOrderCode();
    String getAddress();
    String getPhone();
    String getOrderDate();
}
