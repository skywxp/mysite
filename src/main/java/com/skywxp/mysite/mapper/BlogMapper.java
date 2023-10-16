package com.skywxp.mysite.mapper;

import com.skywxp.mysite.entity.Blogtext;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BlogMapper {
    @Select("select * from blogtext")
    List<Blogtext> getAllBlog();
    @Insert("insert into blogtext(blogid,blogtitle,blogcontent,love) values (default,#{blogtitle},#{blogcontent},#{love})")
    void addNewBlog(Blogtext blogtext);


}
