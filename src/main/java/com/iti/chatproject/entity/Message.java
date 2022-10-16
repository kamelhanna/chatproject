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

}