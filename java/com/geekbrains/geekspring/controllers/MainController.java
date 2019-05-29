package com.geekbrains.geekspring.controllers;

import com.geekbrains.geekspring.entities.User;
import com.geekbrains.geekspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class MainController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String showHomePage(Principal principal) {
//        User user = userService.findByUserName(principal.getName());
//        System.out.println(user.getRoles());
        return "index";
    }
}
