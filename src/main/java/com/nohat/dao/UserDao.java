package com.nohat.dao;

import com.nohat.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("select * from user where id = #{id}")
    public User getUserById(@Param("id")int id);

    @Insert("insert into user(id,name) values (#{id},#{name})")
    public boolean AddUser(User user);

}
