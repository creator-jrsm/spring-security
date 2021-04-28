package com.eshore.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eshore.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where username = #{username}")
    User getUserByName(@Param("username") String username);

}
