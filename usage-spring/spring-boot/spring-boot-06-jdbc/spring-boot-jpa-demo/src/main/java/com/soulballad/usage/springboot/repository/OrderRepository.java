package com.soulballad.usage.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soulballad.usage.springboot.model.Order;
import com.soulballad.usage.springboot.vo.OrderInfo;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : order repository {@link JpaSpecificationExecutor}中泛型类型为返回值类型
 * @since ：2020/5/22 22:23
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {

    @Query(value = "select "
        + "o.id as orderId, o.orderCode as orderCode, o.orderDate as orderDate, o.userId as userId, "
        + "u.address as address, u.phone as phone, u.age as age from Order o inner join User u on o.userId = u.id where o.orderCode = ?1")
    OrderInfo selectOrderByCode(String orderCode);
}
