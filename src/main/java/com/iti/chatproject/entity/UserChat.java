package com.iti.chatproject.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_chat")
public class UserChat {
    @EmbeddedId
    private UserChatId id;

    @MapsId("userChatUserId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_chat_user_id", nullable = false)
    private User userChatUser;
}