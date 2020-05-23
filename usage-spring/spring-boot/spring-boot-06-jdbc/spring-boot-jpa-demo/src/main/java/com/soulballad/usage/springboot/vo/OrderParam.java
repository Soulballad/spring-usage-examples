package com.soulballad.usage.springboot.vo;

import java.math.BigDecimal;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : 参数
 * @since ：2020/5/23 11:09
 */
public class OrderParam {

    private Long id;
    private Long userId;
    private String orderCode;
    private BigDecimal totalMoney;
    private String orderStartDate;
    private String orderEndDate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getOrderStartDate() {
        return orderStartDate;
    }

    public void setOrderStartDate(String orderStartDate) {
        this.orderStartDate = orderStartDate;
    }

    public String getOrderEndDate() {
        return orderEndDate;
    }

    public void setOrderEndDate(String orderEndDate) {
        this.orderEndDate = orderEndDate;
    }
}
