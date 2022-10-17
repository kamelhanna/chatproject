package com.iti.chatproject.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "chat")
public class Chat {
    @Id
    @Column(name = "chat_id", nullable = false, length = 32)
    private Long id;

    @Column(name = "chat_topic", length = 32)
    private String chatTopic;

    @Column(name = "chat_password", length = 64)
    private String chatPassword;


}