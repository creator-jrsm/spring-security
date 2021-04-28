package com.eshore.service;

import com.eshore.mapper.UserMapper;
import com.eshore.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.logging.Logger;

@Service
public class UserService implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    public int insertUser(String username,String password){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        User user=new User();
        user.setId(9);
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        user.setRole("USER");
        return userMapper.insert(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userMapper.getUserByName(s);
        if (user==null){
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }


}
