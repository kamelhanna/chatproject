package com.iti.chatproject.controller;

import com.iti.chatproject.entity.User;
import com.iti.chatproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public @ResponseBody Optional<User> getUser(@PathVariable String id){
        return userService.getUser(id);
    }



    @PostMapping
    public @ResponseBody User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping
    public @ResponseBody User updateUser(@RequestBody User user){
        return userService.updateUser(user);

    }

}
