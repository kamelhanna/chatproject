package com.iti.chatproject.mapstruct.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class ChatDto {

    private String id;

    private String chatTopic;

    @NotEmpty
    private String chatPassword;
}
