package com.soulballad.usage.springboot.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.soulballad.usage.springboot.model.User;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user repository
 * @since ：2020/5/22 22:22
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.name = ?1")
    User findUserByName(String name);

    @Query("select u from User u")
    Page<User> findByPage(Pageable pageable);

    @Query("select u from User u where u.phone = :phone")
    List<User> findUserByPhone(@Param("phone") String phone);

    @Modifying
    @Transactional
    @Query("update User set phone = ?1 where name = ?2")
    int updateByName(String phone, String name);

    @Modifying
    @Transactional
    @Query("delete from User where name = :name")
    int deleteByName(@Param("name") String name);
}
