package com.iti.chatproject.controller;

import com.iti.chatproject.entity.User;
import com.iti.chatproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/user")
    public @ResponseBody User getUser(){
        return userService.getUser();
    }

    @PostMapping("/user")
    public @ResponseBody User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/user/update")
    public @ResponseBody User updateUser(@RequestBody String id, String password){
        return userService.updateUserPassword(id,password);

    }

}
