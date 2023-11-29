package com.skywxp.mysite.controller;

import com.skywxp.mysite.common.R;
import com.skywxp.mysite.mapper.CountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/main")
public class MainpageController {

    @RequestMapping("/title")
    public R<String> webTitle(){
        return R.success("欢迎！");
    }

    @RequestMapping("/count")
    public R<Integer> count(){
        return R.success(1);
    }
}
