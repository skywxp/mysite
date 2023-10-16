package com.skywxp.mysite.service.ServiceImpl;

import com.skywxp.mysite.mapper.EmailMapper;
import com.skywxp.mysite.service.VerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@Service
public class VerifyServiceImpl implements VerifyService {
    @Resource
    JavaMailSender sender;

    @Value("${spring.mail.username}")
    String from;

    @Autowired
    EmailMapper emailMapper;
    @Override
    public void sendVerifyCode(String mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("[XX网站] 您的注册验证码");
        Random random = new Random();
        int code = random.nextInt(899999)+100000;
        //将验证码加入到数据库
        emailMapper.addNewVerify(String.valueOf(code));

        message.setText("您的注册验证码为:"+code+"，三分钟内有效，请及时完成注册。");
        message.setTo(mail);
        message.setFrom(from);
        sender.send(message);

    }

    /**
     * 执行验证
     * @param code
     * @return
     */
    @Override
    public boolean doVerify(String code) {
       List<String> verifyCodeSet = emailMapper.getVerifyCode();

       if (verifyCodeSet.contains(code)){
           return true;
       }else{
           return false;
       }
    }
}
