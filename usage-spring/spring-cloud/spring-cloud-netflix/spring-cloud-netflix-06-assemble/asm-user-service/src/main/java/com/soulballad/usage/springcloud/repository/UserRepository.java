package com.soulballad.usage.springcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.soulballad.usage.springcloud.model.UserModel;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user
 * @since ：2020/6/5 21:18
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    @Query("select u from UserModel u where u.name = ?1")
    UserModel findUserByName(String name);

    @Modifying
    @Transactional
    @Query("delete from UserModel where name = :name")
    int deleteByName(@Param("name") String name);
}
