package com.zjt.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/toIndex")
    public String toIndex(){

        return "index";
    }

    @RequestMapping("/login")
    public String login2(){

        return "index";
    }
}
