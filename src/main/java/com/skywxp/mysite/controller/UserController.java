package com.skywxp.mysite.controller;

import com.skywxp.mysite.common.R;
import com.skywxp.mysite.entity.User;
import com.skywxp.mysite.mapper.UserMapper;
import com.skywxp.mysite.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/getUserDetailsById")
    public R<User> getUserDetailsById(@RequestParam("userid") Integer userid){
        log.info("查询用户信息！");
        User user = userService.getUserDetails(userid);
        return R.success(user);
    }
}
