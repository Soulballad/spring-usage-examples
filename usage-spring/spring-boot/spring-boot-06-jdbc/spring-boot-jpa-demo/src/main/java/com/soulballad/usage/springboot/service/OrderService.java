package com.soulballad.usage.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.soulballad.usage.springboot.model.Order;
import com.soulballad.usage.springboot.vo.OrderInfo;
import com.soulballad.usage.springboot.vo.OrderParam;


/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : order
 * @since ：2020/5/23 10:41
 */
public interface OrderService {

    /**
     * 查询所有user
     * @return order
     */
    List<Order> selectList();

    /**
     * 根据订单号关联查询
     * @param orderCode 订单号
     * @return OrderInfo
     */
    OrderInfo selectOrderByCode(String orderCode);

    /**
     * 使用example查询
     * @param order 查询参数
     * @return Order
     */
    List<Order> selectByExample(Order order);

    /**
     * 多条件组合查询
     * @param orderParam 查询参数
     * @return Order
     */
    Page<Order> selectByCondition(OrderParam orderParam, Pageable pageable);
}
