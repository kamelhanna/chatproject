package com.iti.chatproject.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id", nullable = false, length = 32)
    private String id;

    @Column(name = "user_login")
    private String userLogin;

    @Column(name = "user_password", length = 64)
    private String userPassword;

    @Column(name = "user_email", length = 400)
    private String userEmail;

}