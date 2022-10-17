package com.iti.chatproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    @Id
    @Column(name = "chat_id", nullable = false, length = 32)
    private String id;

    @Column(name = "chat_topic", length = 32)
    private String chatTopic;

    @Column(name = "chat_password", length = 64)
    private String chatPassword;

}