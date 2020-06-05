package com.soulballad.usage.springcloud.service;

import java.util.List;

import com.soulballad.usage.springcloud.model.OrderModel;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/6/5 21:21
 */
public interface UserService {

    List<OrderModel> findAll();

    OrderModel findById(Long id);

    OrderModel findByUserName(String name);

    OrderModel update(OrderModel orderModel);

    Integer deleteByName(String name);
}
