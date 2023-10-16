package com.skywxp.mysite.service.ServiceImpl;

import com.skywxp.mysite.common.R;
import com.skywxp.mysite.entity.User;
import com.skywxp.mysite.mapper.UserMapper;
import com.skywxp.mysite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getUserDetails(Integer userid) {
        return userMapper.getUserDetails(userid);
    }
}
