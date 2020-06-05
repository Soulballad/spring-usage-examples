package com.soulballad.usage.springcloud.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.criteria.Predicate;

import com.soulballad.usage.springcloud.vo.OrderStatusEnum;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.soulballad.usage.springcloud.model.OrderModel;
import com.soulballad.usage.springcloud.repository.OrderRepository;
import com.soulballad.usage.springcloud.service.OrderService;
import com.soulballad.usage.springcloud.vo.OrderParam;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/6/5 21:48
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderModel> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public OrderModel findByOrderCode(String orderCode) {
        return orderRepository.selectOrderByCode(orderCode);
    }

    @Override
    public OrderModel createOrder(OrderModel orderModel) {
        orderModel.setStatus(OrderStatusEnum.WAIT.getKey()); // 待支付
        return orderRepository.save(orderModel);
    }

    @Override
    public Integer updateOrderPay(OrderModel orderModel) {
        // 先查询订单状态，再查用户余额，支付（省略），然后更新订单状态（已支付），最后更新用户积分
        Optional<OrderModel> orderOpt = orderRepository.findById(orderModel.getId());
        // 不存在或者不是未支付
        if (!orderOpt.isPresent() || !OrderStatusEnum.WAIT.getKey().equals(orderModel.getStatus())) {
            return 0;
        }
        return null;
    }

    @Override
    public Page<OrderModel> selectByCondition(OrderParam orderParam, Pageable pageable) {
        return orderRepository.findAll((Specification<OrderModel>)(root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            // equal userId
            if (Objects.nonNull(orderParam.getUserId())) {
                predicates.add(cb.equal(root.get("userId"), orderParam.getUserId()));
            }
            // equal status
            if (Objects.nonNull(orderParam.getStatus())) {
                predicates.add(cb.equal(root.get("status"), orderParam.getStatus()));
            }
            // like orderCode
            if (StringUtils.isNotBlank(orderParam.getOrderCode())) {
                predicates.add(cb.like(root.get("orderCode"), "%" + orderParam.getOrderCode() + "%"));
            }
            // between
            if (StringUtils.isNotBlank(orderParam.getOrderStartDate())
                && StringUtils.isNotBlank(orderParam.getOrderEndDate())) {
                predicates.add(
                    cb.between(root.get("orderDate"), orderParam.getOrderStartDate(), orderParam.getOrderEndDate()));
            }
            // greater than
            if (Objects.nonNull(orderParam.getTotalMoney())) {
                predicates.add(cb.greaterThan(root.get("totalMoney"), orderParam.getTotalMoney()));
            }
            return query.where(predicates.toArray(new Predicate[0])).getRestriction();
        }, pageable);
    }
}
