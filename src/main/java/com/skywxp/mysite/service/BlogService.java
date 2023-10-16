package com.skywxp.mysite.service;

import com.skywxp.mysite.entity.Blogtext;

import java.util.List;

public interface BlogService {
    List<Blogtext> getAllBlog();

    void addNewBlog(Blogtext blogtext);
}
