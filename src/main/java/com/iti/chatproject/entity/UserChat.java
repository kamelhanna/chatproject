package com.iti.chatproject.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_chat")
public class UserChat {
    @EmbeddedId
    private UserChatId id;

    public UserChatId getId() {
        return id;
    }

    public void setId(UserChatId id) {
        this.id = id;
    }

    //TODO [JPA Buddy] generate columns from DB
}