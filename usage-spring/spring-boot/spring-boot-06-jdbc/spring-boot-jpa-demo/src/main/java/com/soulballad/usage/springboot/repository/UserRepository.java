package com.soulballad.usage.springboot.repository;

import com.soulballad.usage.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user repository
 * @since ：2020/5/22 22:22
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
