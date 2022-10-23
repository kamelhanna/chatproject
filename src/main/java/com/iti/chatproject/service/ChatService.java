package com.iti.chatproject.service;

import com.iti.chatproject.entity.Chat;
import com.iti.chatproject.entity.User;
import com.iti.chatproject.entity.UserChat;
import com.iti.chatproject.entity.UserChatId;
import com.iti.chatproject.exception.ChatNotFoundException;
import com.iti.chatproject.repository.ChatEntityRepository;
import com.iti.chatproject.repository.UserChatRepository;
import com.iti.chatproject.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    @Autowired
    private ChatEntityRepository chatEntityRepository;

    @Autowired
    private UserChatRepository userChatRepository;

    @Autowired
    private UserEntityRepository userEntityRepository;

    public Chat createChat(Chat chat) {
        return chatEntityRepository.save(chat);
    }

    public List<Chat> getChats() {
        return chatEntityRepository.findAll();
    }

    public Chat getChat(String id) {
        if(chatEntityRepository.existsById(id)) {
            return chatEntityRepository.findById(id).get();
        }
        throw new ChatNotFoundException();
    }


    public void addUserToChat(UserChat userChat) {

        userChatRepository.save(userChat);

    }
}
