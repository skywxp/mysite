package com.skywxp.mysite.mapper;

import com.skywxp.mysite.entity.Blogtext;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BlogMapper {
    @Select("select * from blogtext")
    List<Blogtext> getAllBlog();
    @Insert("insert into blogtext(blogid,blogtitle,blogcontent,love) values (default,#{blogtitle},#{blogcontent},#{love})")
    void addNewBlog(Blogtext blogtext);

    @Delete("delete from blogtext where blogtext.blogid = #{blogid}")
    void deleteBlogById(int blogid);
    @Update("update blogtext set blogtitle = #{blogtitle}, blogcontent = #{blogcontent}, love = #{love} where blogid = #{blogid}")
    void upgradeBlog(Blogtext blogtext);
}
