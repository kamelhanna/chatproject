package com.iti.chatproject.service;

import com.iti.chatproject.entity.Chat;
import com.iti.chatproject.entity.User;
import com.iti.chatproject.entity.UserChat;
import com.iti.chatproject.entity.UserChatId;
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

    public Optional<Chat> getChat(String id) {
        return chatEntityRepository.findById(id);
    }


    public void addUserToChat(String chat_id, String user_id) {
        UserChatId userChatId = UserChatId.builder().userChatChatId(chat_id).userChatUserId(user_id).build();

        userChatRepository.save(UserChat.builder()
                .userChatUser(userEntityRepository.getById(user_id))
                .id(userChatId)
                .build());

    }
}
