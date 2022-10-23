package com.iti.chatproject.mapstruct.dto;

import com.iti.chatproject.entity.User;
import com.iti.chatproject.entity.UserChatId;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserChatDto {

    private UserChatId id;

    @NotNull
    private User userChatUser;
}
