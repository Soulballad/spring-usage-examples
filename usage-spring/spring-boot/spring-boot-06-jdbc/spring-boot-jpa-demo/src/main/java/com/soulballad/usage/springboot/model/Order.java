package com.soulballad.usage.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : order
 * @since ：2020/5/22 22:20
 */
@Entity
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false, unique = true)
    private String oderCode;
    @Column(nullable = false)
    private BigDecimal totalMoney;
    @Column(nullable = false)
    private String orderDate;

    public Order() {}

    public Order(Long userId, String oderCode, BigDecimal totalMoney, String orderDate) {
        this.userId = userId;
        this.oderCode = oderCode;
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

    public String getOderCode() {
        return oderCode;
    }

    public void setOderCode(String oderCode) {
        this.oderCode = oderCode;
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
}
