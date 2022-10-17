package com.iti.chatproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "chat")
public class Chat {
    @Id

    @Column(name = "chat_id", nullable = false, length = 32)
    private String id;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "chat_id", referencedColumnName = "user_chat_chat_id", nullable = false),
            @JoinColumn(name = "user_chat_user_id", referencedColumnName = "user_chat_user_id", nullable = false)
    })
    private UserChat userChat;


    @Column(name = "chat_topic", length = 32)
    private String chatTopic;


    @Column(name = "chat_password", length = 64)
    private String chatPassword;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserChat getUserChat() {
        return userChat;
    }

    public void setUserChat(UserChat userChat) {
        this.userChat = userChat;
    }

    public String getChatTopic() {
        return chatTopic;
    }

    public void setChatTopic(String chatTopic) {
        this.chatTopic = chatTopic;
    }

    public String getChatPassword() {
        return chatPassword;
    }

    public void setChatPassword(String chatPassword) {
        this.chatPassword = chatPassword;
    }

}