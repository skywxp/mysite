package com.skywxp.mysite.service.ServiceImpl;

import com.skywxp.mysite.entity.Blogtext;
import com.skywxp.mysite.mapper.BlogMapper;
import com.skywxp.mysite.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;


    @Override
    public List<Blogtext> getAllBlog() {
        return blogMapper.getAllBlog();
    }

    @Override
    public void addNewBlog(Blogtext blogtext) {
        blogMapper.addNewBlog(blogtext);
    }
}
