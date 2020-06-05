package com.soulballad.usage.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soulballad.usage.springcloud.model.OrderModel;
import com.soulballad.usage.springcloud.service.OrderService;
import com.soulballad.usage.springcloud.vo.OrderParam;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/6/5 22:19
 */
@RestController
@RequestMapping(value = "/user")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/list")
    public List<OrderModel> list() {
        return orderService.findAll();
    }

    @GetMapping(value = "/find")
    public OrderModel find(@RequestParam(name = "orderCode") String orderCode) {
        return orderService.findByOrderCode(orderCode);
    }

    @PutMapping(value = "/create")
    public OrderModel create(@RequestBody OrderModel orderModel) {
        return orderService.createOrder(orderModel);
    }

    @PostMapping(value = "/pay")
    public Integer updateOrderPay(@RequestBody OrderModel orderModel) {
        return orderService.updateOrderPay(orderModel);
    }

    @GetMapping(value = "/queryByCondition")
    public Page<OrderModel> deleteByName(@RequestBody OrderParam orderParam, Pageable pageable) {
        return orderService.selectByCondition(orderParam, pageable);
    }
}
