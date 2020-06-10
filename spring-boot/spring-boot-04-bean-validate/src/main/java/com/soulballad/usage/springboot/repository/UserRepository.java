package com.soulballad.usage.springboot.repository;

import com.soulballad.usage.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : repository
 * @since ：2020/5/21 20:00
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
