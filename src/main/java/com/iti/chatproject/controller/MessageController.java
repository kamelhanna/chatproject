package com.iti.chatproject.controller;

import com.iti.chatproject.entity.Chat;
import com.iti.chatproject.entity.Message;
import com.iti.chatproject.mapstruct.dto.MessageDto;
import com.iti.chatproject.mapstruct.mapper.MapStructMapper;
import com.iti.chatproject.mapstruct.mapper.MapStructMapperImp;
import com.iti.chatproject.service.ChatService;
import com.iti.chatproject.service.MessageService;
import com.iti.chatproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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

    @MessageMapping("/messages/chats/{chatId}")
    public void sendMessage(@DestinationVariable String chatId, MessageDto messageDto) {

        messageService.addAndSendMessage(chatId, messageDto);

    }


    @PostMapping("/chats/{chatId}")
    public ResponseEntity<Void> addMessage(@PathVariable String chatId,
                                              @RequestBody MessageDto messageDto){

        messageService.addAndSendMessage(chatId, messageDto);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @GetMapping("/chats/{chat_id}")
    public ResponseEntity<List<MessageDto>> getUserMessages(@PathVariable String chat_id){

        Chat chat = chatService.getChat(chat_id);

        return new ResponseEntity<>
                (MapStructMapperImp.messagesToMessageDtos
                        (messageService.getChatMessages(chat)), HttpStatus.OK);
    }
}
