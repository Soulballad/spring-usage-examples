package com.soulballad.usage.springboot.repository;

import com.soulballad.usage.springboot.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : order repository
 * @since ：2020/5/22 22:23
 */
public interface OrderRepository extends JpaRepository<Order, Long> {


}
