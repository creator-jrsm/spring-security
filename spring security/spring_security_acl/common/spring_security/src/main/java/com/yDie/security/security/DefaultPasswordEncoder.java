package com.yDie.security.security;

import com.yDie.utils.utils.MD5;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DefaultPasswordEncoder implements PasswordEncoder {

    public DefaultPasswordEncoder(){
        this(-1);
    }

    public DefaultPasswordEncoder(int length){

    }

    //进行MD5加密
    @Override
    public String encode(CharSequence rawPassword) {
        MD5.encrypt(rawPassword.toString());
        return null;
    }


    /**
     * 密码比对，判断密码是否一样
     * @param rawPassword       加密后的密码
     * @param encodedPassword   传入的密码
     * @return
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(MD5.encrypt(rawPassword.toString()));
    }
}
