package com.iti.chatproject.repository;

import com.iti.chatproject.entity.UserChat;
import com.iti.chatproject.entity.UserChatId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserChatRepository extends JpaRepository<UserChat, UserChatId> {
}