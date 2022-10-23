package com.iti.chatproject.mapstruct.dto;

import com.iti.chatproject.entity.Chat;
import com.iti.chatproject.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class MessageDto {

    private String id;

    private String messageText;

    private Instant messageDatetime;

    private Chat messageChat;

    private User messageUser;


}
