package com.skywxp.mysite.service;

public interface VerifyService {
    void sendVerifyCode(String mail);

    boolean doVerify(String code);
}
