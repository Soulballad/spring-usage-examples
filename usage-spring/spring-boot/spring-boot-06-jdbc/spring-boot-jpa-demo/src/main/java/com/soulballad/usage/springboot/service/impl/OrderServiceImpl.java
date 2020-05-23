package com.soulballad.usage.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.criteria.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.soulballad.usage.springboot.model.Order;
import com.soulballad.usage.springboot.repository.OrderRepository;
import com.soulballad.usage.springboot.service.OrderService;
import com.soulballad.usage.springboot.vo.OrderInfo;
import com.soulballad.usage.springboot.vo.OrderParam;

import static org.springframework.data.domain.ExampleMatcher.*;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : order
 * @since ：2020/5/23 10:41
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> selectList() {
        return orderRepository.findAll();
    }

    @Override
    public OrderInfo selectOrderByCode(String orderCode) {
        return orderRepository.selectOrderByCode(orderCode);
    }

    @Override
    public List<Order> selectByExample(Order order) {
        // exact：精确比配 contains: 模糊匹配 startsWith：从头匹配
        // 同 matcher -> matcher.exact();
        ExampleMatcher exampleMatcher = matching().withMatcher("userId", GenericPropertyMatcher::exact)
            .withMatcher("orderCode", GenericPropertyMatcher::contains)
            .withMatcher("orderDate", GenericPropertyMatcher::startsWith);
        Example<Order> example = Example.of(order, exampleMatcher);
        return orderRepository.findAll(example);
    }

    @Override
    public Page<Order> selectByCondition(OrderParam orderParam, Pageable pageable) {
        return orderRepository.findAll((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            // equal userId
            if (Objects.nonNull(orderParam.getUserId())) {
                predicates.add(cb.equal(root.get("userId"), orderParam.getUserId()));
            }
            // like orderCode
            if (StringUtils.isNotBlank(orderParam.getOrderCode())) {
                predicates.add(cb.like(root.get("orderCode"), "%" + orderParam.getOrderCode() + "%"));
            }
            // between
            if (StringUtils.isNotBlank(orderParam.getOrderStartDate()) && StringUtils.isNotBlank(orderParam.getOrderEndDate())) {
                predicates.add(cb.between(root.get("orderDate"), orderParam.getOrderStartDate(), orderParam.getOrderEndDate()));
            }
            // greater than
            if (Objects.nonNull(orderParam.getTotalMoney())) {
                predicates.add(cb.greaterThan(root.get("totalMoney"), orderParam.getTotalMoney()));
            }
            return query.where(predicates.toArray(new Predicate[0])).getRestriction();
        }, pageable);
    }
}
