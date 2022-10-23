package com.iti.chatproject.controller;

import com.iti.chatproject.entity.Chat;
import com.iti.chatproject.entity.Message;
import com.iti.chatproject.entity.User;
import com.iti.chatproject.mapstruct.dto.MessageDto;
import com.iti.chatproject.mapstruct.mapper.MapStructMapper;
import com.iti.chatproject.service.ChatService;
import com.iti.chatproject.service.MessageService;
import com.iti.chatproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Optional;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private MapStructMapper mapStructMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private ChatService chatService;

    @PostMapping("/chats/{chat_id}/users/{user_id}")
    public ResponseEntity<Void> addMessage(@RequestBody MessageDto messageDto,
                                           @PathVariable String chat_id,
                                           @PathVariable String user_id){
        User user  = userService.getUser(user_id);
        messageDto.setMessageUser(user);

        Chat chat = chatService.getChat(chat_id);
        messageDto.setMessageChat(chat);

        messageService.addMessage(mapStructMapper.messageDtoToMessage(messageDto));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
