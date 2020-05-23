package com.soulballad.usage.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soulballad.usage.springboot.model.Order;
import com.soulballad.usage.springboot.service.OrderService;
import com.soulballad.usage.springboot.vo.OrderInfo;
import com.soulballad.usage.springboot.vo.OrderParam;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : order
 * @since ：2020/5/23 12:40
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/list")
    public List<Order> list() {
        return orderService.selectList();
    }

    @GetMapping(value = "/queryByCode/{orderCode}")
    public OrderInfo queryByCode(@PathVariable String orderCode) {
        return orderService.selectOrderByCode(orderCode);
    }

    @GetMapping(value = "/queryByExample")
    public List<Order> selectByExample(@RequestBody Order order) {
        return orderService.selectByExample(order);
    }

    @GetMapping(value = "/queryByCondition")
    public Page<Order> queryByCondition(@RequestBody OrderParam orderParam, Pageable pageable) {
        return orderService.selectByCondition(orderParam, pageable);
    }
}
