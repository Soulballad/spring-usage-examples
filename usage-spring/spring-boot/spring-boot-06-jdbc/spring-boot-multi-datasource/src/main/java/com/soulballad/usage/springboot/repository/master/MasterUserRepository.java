package com.soulballad.usage.springboot.repository.master;

import com.soulballad.usage.springboot.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : repository
 * @since ：2020/5/23 21:07
 */
@Repository
public interface MasterUserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByName(String name);

    UserModel findByPhone(String phone);
}
