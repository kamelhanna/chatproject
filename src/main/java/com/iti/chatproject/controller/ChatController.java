package com.iti.chatproject.controller;

import com.iti.chatproject.entity.Chat;
import com.iti.chatproject.entity.UserChat;
import com.iti.chatproject.entity.UserChatId;
import com.iti.chatproject.mapstruct.dto.ChatDto;
import com.iti.chatproject.mapstruct.dto.UserChatDto;
import com.iti.chatproject.mapstruct.dto.UserDto;
import com.iti.chatproject.mapstruct.mapper.MapStructMapper;
import com.iti.chatproject.service.ChatService;
import com.iti.chatproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@Controller
@RequestMapping("/chats")
public class ChatController {

    private MapStructMapper mapStructMapper;
    private ChatService chatService;
    @Autowired
    private UserService userService;

    @Autowired
    public ChatController(MapStructMapper mapStructMapper, ChatService chatService){
        this.mapStructMapper = mapStructMapper;
        this.chatService = chatService;
    }

    @PostMapping
    public ResponseEntity<Void> createChat(@RequestBody ChatDto chatDto){
        chatService.createChat(mapStructMapper.chatDtoToChat(chatDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/{chat_id}/user/{user_id}")
    public ResponseEntity<Void> addUserToChat(@PathVariable String chat_id,
                                                @PathVariable String user_id){

        UserChatId userChatId = UserChatId.builder().userChatChatId(chat_id).userChatUserId(user_id).build();
        UserChatDto userChatDto = UserChatDto.builder().userChatUser(userService.getUser(user_id)).id(userChatId).build();
        chatService.addUserToChat(mapStructMapper.userChatDtoToUserChat(userChatDto));

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<ChatDto>>  gitAllChats(){
        return new ResponseEntity<>(mapStructMapper.chatsToChatDtos(chatService.getChats()),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatDto>  getChat(@PathVariable String id){
        return new ResponseEntity<>(mapStructMapper.chatToChatDto(chatService.getChat(id)),
                HttpStatus.OK);
    }

}
