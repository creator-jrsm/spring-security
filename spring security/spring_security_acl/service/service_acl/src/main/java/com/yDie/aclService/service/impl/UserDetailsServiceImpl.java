package com.yDie.aclService.service.impl;

import com.yDie.aclService.entity.User;
import com.yDie.aclService.service.PermissionService;
import com.yDie.aclService.service.UserService;
import com.yDie.security.entity.SecurityUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    PermissionService permissionService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userService.selectByUsername(username);

        if (user==null){
            throw new UsernameNotFoundException("用户不存在");
        }

        com.yDie.security.entity.User curUser=new com.yDie.security.entity.User();

        BeanUtils.copyProperties(user,curUser);

        //根据用户查询用户权限列表
        List<String> permissionValueList=permissionService.selectPermissionValueByUserId(user.getId());

        SecurityUser securityUser=new SecurityUser();
        securityUser.setCurrentUserInfo(curUser);
        securityUser.setPermissionValueList(permissionValueList);
        return securityUser;
    }
}
