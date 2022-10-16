package com.iti.chatproject.service;

import com.iti.chatproject.entity.Chat;
import com.iti.chatproject.entity.User;
import com.iti.chatproject.repository.ChatEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    private ChatEntityRepository chatEntityRepository;

    public Chat createChat(Chat chat) {
        return chatEntityRepository.save(chat);
    }
}
