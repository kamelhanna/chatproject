package com.iti.chatproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "message")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @Column(name = "message_id", nullable = false, length = 32)
    private String id;

    @Column(name = "message_datetime")
    private Instant messageDatetime;

    @Lob
    @Column(name = "message_text")
    private String messageText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "message_chat_id")
    private Chat messageChat;

}