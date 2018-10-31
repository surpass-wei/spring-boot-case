package com.surpass.demo.mapper;

import com.surpass.demo.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by surpass.wei@gmail.com on 2017/4/10.
 */
@Repository
public interface UserMapper {

    @Select("SELECT * FROM t_user WHERE name = #{name}")
    List<User> likeName(String name);

    @Select("SELECT * FROM t_user WHERE id = #{id}")
    User getById(long id);

    @Select("SELECT name FROM t_user WHERE id = #{id}")
    String getNameById(long id);

    @Select("SELECT * FROM t_user")
    List<User> getAll();

    @Insert("INSERT INTO t_user(name, age) values(#{name}, #{age})")
    int insertOne(@Param("name") String name, @Param("age") Integer age);
}
