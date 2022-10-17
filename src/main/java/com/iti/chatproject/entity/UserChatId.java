package com.iti.chatproject.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserChatId implements Serializable {
    private static final long serialVersionUID = 8894348990935064899L;
    @Column(name = "user_chat_chat_id", nullable = false, length = 32)
    private String userChatChatId;

    @Column(name = "user_chat_user_id", nullable = false, length = 32)
    private String userChatUserId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserChatId entity = (UserChatId) o;
        return Objects.equals(this.userChatUserId, entity.userChatUserId) &&
                Objects.equals(this.userChatChatId, entity.userChatChatId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userChatUserId, userChatChatId);
    }

}