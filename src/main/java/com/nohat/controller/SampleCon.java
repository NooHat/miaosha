package com.nohat.controller;

import com.nohat.domain.User;
import com.nohat.redis.RedisService;
import com.nohat.redis.UserKey;
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
    @Autowired
    RedisService redisService;

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
        userService.addUser();
        return Result.success(true);
    }

    @RequestMapping("redisGet")
    @ResponseBody
    public Result<User> redisGet(){
        User user = redisService.get(UserKey.getById,""+3,User.class);
        return Result.success(user);
    }
    @RequestMapping("redisSet")
    @ResponseBody
    public Result<String> redisSet(){
        User user=new User();
        user.setId(3);
        user.setName("sfds");

        redisService.set(UserKey.getById,""+3,user);
        return Result.success(redisService.get(UserKey.getById,""+3,String.class));
    }

}
