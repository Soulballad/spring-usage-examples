package com.soulballad.usage.springcloud.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/6/5 21:37
 */
@Entity
@Table(name = "t_order")
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false, unique = true)
    private String orderCode;
    @Column(nullable = false)
    private BigDecimal totalMoney;
    @Column(nullable = false)
    private String orderDate;
    @Column(nullable = false, length = 16)
    private String status; // 状态：未支付、已支付

    public OrderModel() {}

    public OrderModel(Long userId, String orderCode, BigDecimal totalMoney, String orderDate, String status) {
        this.userId = userId;
        this.orderCode = orderCode;
        this.totalMoney = totalMoney;
        this.orderDate = orderDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderModel{" + "id=" + id + ", userId=" + userId + ", orderCode='" + orderCode + '\'' + ", totalMoney="
            + totalMoney + ", orderDate='" + orderDate + '\'' + ", status='" + status + '\'' + '}';
    }
}
