package com.iti.chatproject.mapstruct.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDto {

    private String messageText;

    private String userId;

    private String chatId;

    private String userName;
}
