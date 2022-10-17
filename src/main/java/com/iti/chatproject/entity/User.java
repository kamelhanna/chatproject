package com.iti.chatproject.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false, length = 32)
    private Long id;

    @Column(name = "user_login")
    private String userLogin;

    @Column(name = "user_password", length = 64)
    private String userPassword;

    @Column(name = "user_email", length = 400)
    private String userEmail;

}