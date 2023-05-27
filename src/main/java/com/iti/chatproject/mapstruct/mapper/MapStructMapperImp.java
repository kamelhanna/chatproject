package com.iti.chatproject.mapstruct.mapper;

import com.iti.chatproject.entity.Message;
import com.iti.chatproject.mapstruct.dto.MessageDto;
import com.iti.chatproject.repository.ChatEntityRepository;
import com.iti.chatproject.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class MapStructMapperImp {

    @Autowired
    private static UserEntityRepository userEntityRepository;

    @Autowired
    private static ChatEntityRepository chatEntityRepository;


    public static List<MessageDto> messagesToMessageDtos(List<Message> messages){
        if ( messages == null ) {
            return null;
        }

        List<MessageDto> list = new ArrayList<MessageDto>( messages.size() );
        for ( Message message : messages ) {
            list.add( messageToMessageDto( message ) );
        }

        return list;
    }

    public static MessageDto messageToMessageDto(Message message){
        if ( message == null ) {
            return null;
        }

        MessageDto messageDto = new MessageDto();

        messageDto.setMessageText( message.getMessageText() );
        messageDto.setChatId(message.getMessageChat().getId());
        messageDto.setUserId(message.getMessageUser().getId());
        messageDto.setUserName(message.getMessageUser().getUserLogin());

        return messageDto;
    }



/*
    public static Message messageDtoToMessage(MessageDto messageDto){
        if (messageDto == null){
            return null;
        }

        Message message = new Message();

        message.setMessageUser(userEntityRepository.getById(messageDto.getUserId()));
        message.setMessageChat(chatEntityRepository.getById(messageDto.getChatId()));
        message.setMessageDatetime(Instant.now());
        message.setMessageText(messageDto.getMessageText());

        return message;
    }
*/
}
