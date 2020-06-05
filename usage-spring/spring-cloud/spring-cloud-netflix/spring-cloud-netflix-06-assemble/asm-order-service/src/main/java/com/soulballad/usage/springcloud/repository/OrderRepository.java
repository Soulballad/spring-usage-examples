package com.soulballad.usage.springcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.soulballad.usage.springcloud.model.OrderModel;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/6/5 21:38
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long>, JpaSpecificationExecutor<OrderModel> {

    @Query("select o from OrderModel o where o.orderCode = ?1")
    OrderModel selectOrderByCode(String orderCode);

    @Modifying
    @Transactional
    @Query("update OrderModel set status = :status where orderCode = :orderCode")
    Integer updateStatusByCode(@Param("status") String status, @Param("orderCode") String orderCode);
}
