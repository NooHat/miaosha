package com.nohat.controller;

import com.nohat.domain.User;
import com.nohat.service.UserService;
import com.nohat.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;

@Controller
@RequestMapping("/demo")
public class SampleCon {

    @Autowired
    UserService userService;


    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name", "nohat");
        return "hello";

    }

    @RequestMapping("/getUserById")
    @ResponseBody
    public Result<User> getUserById(){
        User user=userService.getUserById(1);
        return Result.success(user);
    }
    @RequestMapping("/addUser")
    @ResponseBody
    public Result<Boolean> addUser(){

        return Result.success(true);
    }

}
