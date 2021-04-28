package com.eshore.config;

import com.eshore.mapper.UserMapper;
import com.eshore.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;


@Configuration
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserMapper userMapper;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username=authentication.getName();
        String password=authentication.getCredentials().toString();

         if (username.equals("yDie")){
            Collection<GrantedAuthority> authorityCollection=new ArrayList<>();
            authorityCollection.add(new SimpleGrantedAuthority("ROLE_MASTER"));
            authorityCollection.add(new SimpleGrantedAuthority("ROLE_USER"));
            return new UsernamePasswordAuthenticationToken("admin",password,authorityCollection);
        }else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
