package com.soulballad.usage.springboot.mapper;

import com.soulballad.usage.springboot.model.UserModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : mapper
 * @since ：2020/7/20 20:55
 */
@Repository
public interface UserMapper {

    @Select("SELECT id, `name`, age, birthday, address, phone FROM t_user")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "address", column = "address"),
            @Result(property = "phone", column = "phone")
    })
    List<UserModel> findAll();

    UserModel findUserByName(String name);

//    Page<UserModel> findByPage(SpringDataWebProperties.Pageable pageable);

    List<UserModel> findUserByPhone(@Param("phone") String phone);

    int updateByName(UserModel userModel);

    int deleteByName(@Param("name") String name);

    @Insert("INSERT INTO t_user(`name`, age, birthday, address, phone) VALUES(#{name}, #{age}, #{birthday}, #{address}, #{phone})")
    int insertUser(UserModel userModel);
}
