package com.soulballad.usage.springcloud.service;

import java.util.List;

import com.soulballad.usage.springcloud.vo.OrderParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.soulballad.usage.springcloud.model.OrderModel;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/6/5 21:41
 */
public interface OrderService {

    List<OrderModel> findAll();

    OrderModel findByOrderCode(String orderCode);

    OrderModel createOrder(OrderModel orderModel);

    Integer updateOrderPay(OrderModel orderModel);

    Page<OrderModel> selectByCondition(OrderParam orderParam, Pageable pageable);
}
