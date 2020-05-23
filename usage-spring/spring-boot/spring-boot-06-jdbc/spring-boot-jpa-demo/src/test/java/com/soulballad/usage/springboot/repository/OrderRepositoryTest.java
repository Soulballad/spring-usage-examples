package com.soulballad.usage.springboot.repository;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.soulballad.usage.springboot.SpringBootJpaDemoApplicationTests;
import com.soulballad.usage.springboot.model.Order;
import com.soulballad.usage.springboot.service.OrderService;
import com.soulballad.usage.springboot.vo.OrderInfo;
import com.soulballad.usage.springboot.vo.OrderParam;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONValue;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : order test
 * @since ：2020/5/23 16:34
 */
public class OrderRepositoryTest extends SpringBootJpaDemoApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    public void test_selectOrderByCode() {
        OrderInfo orderInfo = orderService.selectOrderByCode("OC2020052312050002");
        System.err.println(orderInfo);
    }

    @Test
    public void test_selectByExample() {
        Order order = new Order();
        // order.setUserId(2L);
        order.setOrderCode("OC20200523");
        order.setOrderDate("2020-03");
        List<Order> orders = orderService.selectByExample(order);
        System.err.println(JSONArray.toJSONString(orders));
    }

    @Test
    public void test_selectByCondition() {
        OrderParam orderParam = new OrderParam();
        // orderParam.setUserId(2L);
        orderParam.setOrderCode("OC20200523");
        orderParam.setOrderStartDate("2020-02-10");
        orderParam.setOrderStartDate("2020-05-10");
        orderParam.setTotalMoney(BigDecimal.valueOf(200));

        int pageNum = 1, pageSize = 2;
        Sort dateDesc = new Sort(Sort.Direction.DESC, "orderDate");
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize, dateDesc);

        Page<Order> page = orderService.selectByCondition(orderParam, pageRequest);
        System.err.println(JSONValue.toJSONString(page));
    }
}
