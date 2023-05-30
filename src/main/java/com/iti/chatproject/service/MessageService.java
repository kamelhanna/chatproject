package com.iti.chatproject.service;

import com.iti.chatproject.entity.Chat;
import com.iti.chatproject.entity.Message;
import com.iti.chatproject.mapstruct.dto.MessageDto;
import com.iti.chatproject.mapstruct.mapper.MapStructMapper;
import com.iti.chatproject.mapstruct.mapper.MapStructMapperImp;
import com.iti.chatproject.repository.ChatEntityRepository;
import com.iti.chatproject.repository.MessageRepository;
import com.iti.chatproject.repository.UserEntityRepository;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class MessageService {

    private MessageRepository messageRepository;

    private UserEntityRepository userEntityRepository;

    private ChatEntityRepository chatEntityRepository;

    private SimpMessagingTemplate simpMessagingTemplate;

    private MapStructMapper mapStructMapper;

    public MessageService(MessageRepository messageRepository,
                          UserEntityRepository userEntityRepository,
                          ChatEntityRepository chatEntityRepository,
                          SimpMessagingTemplate simpMessagingTemplate,
                          MapStructMapper mapStructMapper) {
        this.messageRepository = messageRepository;
        this.userEntityRepository = userEntityRepository;
        this.chatEntityRepository = chatEntityRepository;
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.mapStructMapper = mapStructMapper;
    }

    public void addAndSendMessage(String chatId, MessageDto messageDto){
        Message message = mapStructMapper.messageDtoToMessage(messageDto);

        message.setMessageUser(userEntityRepository.findById(messageDto.getUserId()).get());
        message.setMessageChat(chatEntityRepository.findById(chatId).get());
        message.setMessageDatetime(Instant.now());

        messageRepository.save(message);

        MessageDto messageDtoAfterSave = MapStructMapperImp.messageToMessageDto(message);

        simpMessagingTemplate.convertAndSend("/topic/messages/chat/" + chatId, messageDtoAfterSave);

        //return messageDtoAfterSave;
    }


    public List<Message> getChatMessages(Chat chat) {

        return messageRepository.findMessagesByMessageChat(chat);
    }
}
