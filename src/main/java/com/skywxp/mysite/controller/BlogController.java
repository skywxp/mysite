package com.skywxp.mysite.controller;

import com.skywxp.mysite.common.R;
import com.skywxp.mysite.entity.Blogtext;
import com.skywxp.mysite.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @RequestMapping("/listAllBlog")
    public R<List<Blogtext>> getAllBlog(){
        List<Blogtext> list = blogService.getAllBlog();
        log.info("查询所有文章！");
        return R.success(list);
    }

    @RequestMapping("/addNewBlog")
    public R<String> AddNewBlog(Blogtext blogtext){
        blogService.addNewBlog(blogtext);
        log.info("文章添加成功！");
        return R.success("添加成功！");
    }


}
