package com.health.mapper;

import com.health.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
//@Repository
//@Mapper
@Repository
public interface UserMapper {

    @Insert("INSERT INTO user( userName,password,phone) VALUE (#{userName},#{password},#{phone})")
    @Options(useGeneratedKeys = true)
    Integer insert(User user);

    List<User> select();

    User selectByName(String userName);


//  void registerAutoLogin(@Param("uid") String uid, @Param("taken") String taken);
    void registerAutoLogin(@Param("userName")String userName,@Param("taken")  String taken);

    User autoLogin(@Param("taken") String taken);
}
