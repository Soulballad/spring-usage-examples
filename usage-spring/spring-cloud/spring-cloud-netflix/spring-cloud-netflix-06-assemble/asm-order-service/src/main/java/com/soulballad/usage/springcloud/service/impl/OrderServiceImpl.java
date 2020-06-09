package com.soulballad.usage.springcloud.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.criteria.Predicate;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.soulballad.usage.springcloud.model.OrderModel;
import com.soulballad.usage.springcloud.repository.OrderRepository;
import com.soulballad.usage.springcloud.service.OrderService;
import com.soulballad.usage.springcloud.service.RibbonService;
import com.soulballad.usage.springcloud.vo.OrderParam;
import com.soulballad.usage.springcloud.vo.OrderStatusEnum;
import com.soulballad.usage.springcloud.vo.UserVo;

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

    @Autowired
    private RibbonService ribbonService;

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
    public UserVo updateOrderPay(OrderModel orderModel) {
        // 先查询订单状态，再查用户余额，支付（省略），然后更新订单状态（已支付），最后更新用户积分
        Optional<OrderModel> orderOpt = orderRepository.findById(orderModel.getId());
        OrderModel dbOrder = orderOpt.orElseGet(OrderModel::new);
        // 不是未支付，不存在肯定不是未支付
        if (!OrderStatusEnum.WAIT.getKey().equals(dbOrder.getStatus())) {
            return null;
        }
        UserVo userVo = ribbonService.queryUserInfo(dbOrder.getUserId());
        if (userVo.getMoney().compareTo(dbOrder.getTotalMoney()) < 0) {
            // 余额不足
            return null;
        }
        // 支付，省略
        // 更新订单状态
        dbOrder.setStatus(OrderStatusEnum.PAID.getKey());
        orderRepository.save(dbOrder);
        // 更新用户积分
        int points = dbOrder.getTotalMoney().divide(new BigDecimal(100), BigDecimal.ROUND_FLOOR).intValue();
        userVo.setPoints(userVo.getPoints() + points);
        return ribbonService.updateUserPoint(userVo);
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
