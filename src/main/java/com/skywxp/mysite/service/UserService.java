package com.skywxp.mysite.service;

import com.skywxp.mysite.common.R;
import com.skywxp.mysite.entity.User;
import com.skywxp.mysite.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {

    User getUserDetails(Integer userid);
}
