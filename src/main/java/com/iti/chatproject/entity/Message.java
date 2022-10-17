package com.iti.chatproject.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "message")
public class Message {
    @Id

    @Column(name = "message_id", nullable = false, length = 32)
    private String id;

    @Column(name = "message_datetime")
    private Instant messageDatetime;

    @Lob
    @Column(name = "message_text")
    private String messageText;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "message_id")
    private Chat messageChat;*/

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User messageUser;*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getMessageDatetime() {
        return messageDatetime;
    }

    public void setMessageDatetime(Instant messageDatetime) {
        this.messageDatetime = messageDatetime;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    /*public Chat getMessageChat() {
        return messageChat;
    }

    public void setMessageChat(Chat messageChat) {
        this.messageChat = messageChat;
    }*/

    /*public User getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(User messageUser) {
        this.messageUser = messageUser;
    }*/

}