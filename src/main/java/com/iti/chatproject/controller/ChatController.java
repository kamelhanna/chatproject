package com.iti.chatproject.controller;

import com.iti.chatproject.entity.Chat;
import com.iti.chatproject.entity.User;
import com.iti.chatproject.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/chat")
    public @ResponseBody Chat createChat(@RequestBody Chat chat){
        return chatService.createChat(chat);
    }

}
