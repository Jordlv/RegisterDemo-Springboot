package com.example.demo.mapper;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
@Mapper//标记文件位置
@Repository//与数据库相关component
public interface UserMapper {
    @Select(value ="select u.username,u.password from user u where u.username=#{username}")
    @Results({
                    @Result(property = "username",column = "username"),
                    @Result(property = "password",column ="password")
            })
    User findUserByName(@Param("username") String username);

    /*注册*/
    @Insert("insert into user values(#{id},#{username},#{password})")
    //加入该注解可以保存对象后，查看对象插入id
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    void regiser(User user);

    /*登录*/
    @Select("select u.id from user u where username=#{username} and password=#{password}"   )
    Long longin(User user);
}
