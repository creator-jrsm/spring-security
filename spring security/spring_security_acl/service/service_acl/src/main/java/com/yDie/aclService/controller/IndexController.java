package com.yDie.aclService.controller;

import com.alibaba.fastjson.JSONObject;
import com.yDie.aclService.service.IndexService;
import com.yDie.utils.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/acl/index")
public class IndexController {

    @Autowired
    private IndexService indexService;

    /**
     * 根据token获取用户信息
     */
    @GetMapping("info")
    public R info(){
        //获取当前登录用户用户名
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String,Object> userinfo=indexService.getUserInfo(username);
        return R.ok().data(userinfo);
    }

    /**
     * 获取菜单
     */
    @GetMapping("menu")
    public R getMenu(){
        String username=SecurityContextHolder.getContext().getAuthentication().getName();
        List<JSONObject> permissionList=indexService.getMenu(username);
        return R.ok().data("permissionList",permissionList);
    }

    @PostMapping("logout")
    public R logout(){
        return R.ok();
    }

}
