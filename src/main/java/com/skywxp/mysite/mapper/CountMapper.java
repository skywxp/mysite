package com.skywxp.mysite.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CountMapper {
    @Update("update count set count = #{count}")
    Integer updateCount(Integer count);
    @Select("select count from count ")
    int getCount();
}
