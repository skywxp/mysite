package com.skywxp.mysite.controller;

import com.skywxp.mysite.common.R;
import com.skywxp.mysite.entity.User;
import com.skywxp.mysite.mapper.UserMapper;
import com.skywxp.mysite.service.VerifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    UserMapper userMapper;
    @Autowired
    VerifyService verifyService;
    @ResponseBody
    @RequestMapping("/login")
    public R<User> login(User user, HttpSession session){
        if (user.getPassword().equals(userMapper.getPasswordByUsername(user.getUsername()))){
            session.setAttribute("user",user);//用户数据存进session，以供项目使用。
            log.info("登录成功！");

            return R.success(user);//将用户数据直接返回回去。

        }else{
            log.info("登录失败！");
            return R.error("登录失败！");
        }
    }
    @ResponseBody
    @RequestMapping("/register")
    public R<User> register(User user, String verifyCode){
        //查看数据库中是否已有该用户
        if(userMapper.getAllUserEmail().contains(user.getEmail())) {
            log.info("注册失败！");
            return R.error("用户已存在");
        }
        if(verifyService.doVerify(verifyCode)){
            int userReturnNum = userMapper.AddNewUser(user);
            System.out.println(userReturnNum);
            log.info("验证码正确，注册成功！");
            return R.success(user);
        }else{
            log.info("验证码错误，注册失败！");
            return R.error("验证码错误，注册失败");
        }



    }




}
