package com.soulballad.usage.springboot.model;

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
 * @apiNote : order
 * @since ：2020/5/22 22:20
 */
@Entity
@Table(name = "t_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false, unique = true)
    private String orderCode;
    @Column(nullable = false)
    private BigDecimal totalMoney;
    @Column(nullable = false)
    private String orderDate;

    public Order() {}

    public Order(Long userId, String orderCode, BigDecimal totalMoney, String orderDate) {
        this.userId = userId;
        this.orderCode = orderCode;
        this.totalMoney = totalMoney;
        this.orderDate = orderDate;
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

    public void setOrderCode(String oderCode) {
        this.orderCode = oderCode;
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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderCode='" + orderCode + '\'' +
                ", totalMoney=" + totalMoney +
                ", orderDate='" + orderDate + '\'' +
                '}';
    }
}
