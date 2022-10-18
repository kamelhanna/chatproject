package com.iti.chatproject.controller;

import com.iti.chatproject.entity.Chat;
import com.iti.chatproject.entity.UserChat;
import com.iti.chatproject.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;


    @GetMapping
    public @ResponseBody List<Chat>  gitAChats(){
        return chatService.getChats();
    }

    @PostMapping
    public @ResponseBody Chat createChat(@RequestBody Chat chat){
        return chatService.createChat(chat);
    }

    @PostMapping("/{chat_id}/user/{user_id}")
    public @ResponseBody void addUserToChat(@PathVariable String chat_id,
                                                @PathVariable String user_id){

         chatService.addUserToChat(chat_id, user_id);
    }

}
