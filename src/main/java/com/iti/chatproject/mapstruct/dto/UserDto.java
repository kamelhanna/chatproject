package com.iti.chatproject.mapstruct.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@Setter
public class UserDto {

    private String id;

    private String userLogin;

    @NotEmpty
    private String userPassword;

    @Email
    @NotNull
    private String userEmail;
}
