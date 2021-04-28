package com.eshore.controller;


import com.eshore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/login")
    public String login(){
        return "home";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/regist")
    public String regist(String username,String password){
        int i=userService.insertUser(username,password);
        if (i>0)
            return "login";
        return "register";
    }
}
