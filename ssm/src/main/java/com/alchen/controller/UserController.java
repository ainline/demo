package com.alchen.controller;

import com.alchen.domain.User;
import com.alchen.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("userController")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/find")
    public @ResponseBody
    User getUser(){
        return userService.findUserById();
    }
}
