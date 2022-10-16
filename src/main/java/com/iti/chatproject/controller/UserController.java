package com.iti.chatproject.controller;

import com.iti.chatproject.entity.User;
import com.iti.chatproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    /*@GetMapping("user")
    public String addUser(){
        return userService.addUser().getUserLogin();
    }*/

    @PostMapping("/user")
    public @ResponseBody User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

}
