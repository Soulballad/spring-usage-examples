package com.soulballad.usage.springboot.vo;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : orderDetail
 * @since ：2020/5/22 22:24
 */
public class OrderVo {

    private Long userId;
    private Long orderId;
    private String orderCode;
    private String address;
    private String phone;
    private String orderDate;

    public OrderVo() {}

    public OrderVo(Long userId, Long orderId, String orderCode, String address, String phone, String orderDate) {
        this.userId = userId;
        this.orderId = orderId;
        this.orderCode = orderCode;
        this.address = address;
        this.phone = phone;
        this.orderDate = orderDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
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

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
