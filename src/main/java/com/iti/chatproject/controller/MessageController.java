package com.iti.chatproject.controller;

import com.iti.chatproject.entity.Chat;
import com.iti.chatproject.entity.Message;
import com.iti.chatproject.entity.User;
import com.iti.chatproject.service.ChatService;
import com.iti.chatproject.service.MessageService;
import com.iti.chatproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;
    @Autowired
    private ChatService chatService;

    @PostMapping("/chats/{chat_id}/users/{user_id}")
    public  void addMessage(@RequestBody Message message,
                                            @PathVariable String chat_id,
                                            @PathVariable String user_id){
        Optional<User> user = userService.getUser(user_id);
        Optional<Chat> chat = chatService.getChat(chat_id);

        message.setMessageChat(chat.get());
        message.setMessageUser(user.get());
        messageService.addMessage(message);

        System.out.println("Message is: " + message.getMessageText());
    }
}
