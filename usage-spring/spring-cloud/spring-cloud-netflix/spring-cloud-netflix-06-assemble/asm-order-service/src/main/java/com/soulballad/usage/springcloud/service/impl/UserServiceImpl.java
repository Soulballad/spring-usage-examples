package com.soulballad.usage.springcloud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soulballad.usage.springcloud.model.OrderModel;
import com.soulballad.usage.springcloud.repository.OrderRepository;
import com.soulballad.usage.springcloud.service.UserService;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/6/5 21:28
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderModel> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public OrderModel findById(Long id) {
        Optional<OrderModel> userOpt = orderRepository.findById(id);
        return userOpt.get();
    }

    @Override
    public OrderModel findByUserName(String name) {
        return orderRepository.findUserByName(name);
    }

    @Override
    public OrderModel update(OrderModel orderModel) {
        orderRepository.save(orderModel);
        return findByUserName(orderModel.getName());
    }

    @Override
    public Integer deleteByName(String name) {
        return orderRepository.deleteByName(name);
    }
}
