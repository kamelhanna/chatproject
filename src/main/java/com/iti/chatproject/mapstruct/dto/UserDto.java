package com.iti.chatproject.mapstruct.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String id;
    private String userLogin;

    @NotEmpty
    private String userPassword;

    @Email
    @NotNull
    private String userEmail;

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", userLogin='" + userLogin + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
