package com.skywxp.mysite.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmailMapper {
    @Insert("insert into emailverify(verifycode) values (#{vCode})")
    void addNewVerify(String vCode);

    @Select("select * from emailverify;")
    List<String> getVerifyCode();
}
