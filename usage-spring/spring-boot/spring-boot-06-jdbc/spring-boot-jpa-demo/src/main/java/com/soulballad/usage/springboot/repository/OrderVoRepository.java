package com.soulballad.usage.springboot.repository;

import com.soulballad.usage.springboot.vo.OrderVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : orderVo
 * @since ：2020/5/22 22:27
 */
public interface OrderVoRepository extends JpaSpecificationExecutor<OrderVo>, JpaRepository<OrderVo, Long> {
}
