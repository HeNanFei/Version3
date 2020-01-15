package com.zjt.manager.controller;

import com.zjt.manager.mapper.UserMapper;
import com.zjt.manager.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Component
@EnableWebSecurity
@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/test")
    public String test(){

        return "layui";
    }
    @RequestMapping("/hello")
    public String hello(){


        return "index";
    }
    @ResponseBody
    @RequestMapping("/test/layui")
    public String testLayui(String msg){
        System.out.println(msg);
        return "nothing";
    }
    @RequestMapping("/success")
    public String success(){


        return "layui";
    }
    @ResponseBody
    @RequestMapping("/test/user/role")
    public List<User> users(){

        return userMapper.selectUserAndRoles();


    }


}
