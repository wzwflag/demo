package com.example.demo.controller;

import com.example.demo.common.UserService;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    UserService userService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello()
    {
        User user = userService.getById(1L);
        System.out.println(user);
        return "asd";
    }
    @RequestMapping("/index")
    public String index()
    {
        return "/index";
    }
}
