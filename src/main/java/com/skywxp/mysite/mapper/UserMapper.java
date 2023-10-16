package com.skywxp.mysite.mapper;

import com.skywxp.mysite.common.R;
import com.skywxp.mysite.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select password from user where username = #{username}")
    String getPasswordByUsername(String username);
    @Select("select email from user")
    List<String> getAllUserEmail();
    @Insert("insert into user(userid,username,password,email)\n" +
            "                values (default,#{username},#{password},#{email}) ")
    int AddNewUser(User user);
    @Select("select * from user where user.userid =#{userid}")
    User getUserDetails(Integer userid);
}
