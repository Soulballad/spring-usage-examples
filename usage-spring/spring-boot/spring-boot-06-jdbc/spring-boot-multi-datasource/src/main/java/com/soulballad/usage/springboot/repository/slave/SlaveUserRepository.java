package com.soulballad.usage.springboot.repository.slave;

import com.soulballad.usage.springboot.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : repository
 * @since ：2020/5/23 21:15
 */
@Repository
public interface SlaveUserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByName(String name);

    UserModel findByPhone(String phone);
}
