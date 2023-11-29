package com.skywxp.mysite.controller;

import com.mysql.cj.log.Log;
import com.skywxp.mysite.common.R;
import com.skywxp.mysite.service.VerifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/email")
public class EmailController {
    @Autowired
    VerifyService verifyService;

    /**
     * 验证码发送服务
     * @param email
     * @return
     */
    @ResponseBody
    @RequestMapping("/sendverifycode")
    public R<String> sendVerifyCode(@RequestParam("email") String email){
        try {

            //发送不成功就报错。
            verifyService.sendVerifyCode(email);
            log.info("邮件发送成功！");
            return R.success("邮件发送成功！");
        } catch (Exception e) {
            log.info("邮件发送失败！");
            return R.error("邮件发送失败！");
        }
    }
}
