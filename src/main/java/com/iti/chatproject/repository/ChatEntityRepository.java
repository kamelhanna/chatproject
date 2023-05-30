package com.iti.chatproject.repository;

import com.iti.chatproject.entity.Chat;
import com.iti.chatproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ChatEntityRepository extends JpaRepository<Chat, String> {
    @Query(value = "Select c from Chat c join UserChat uc on c.id = uc.id.userChatChatId where uc.userChatUser.id = :id")
    List<Chat> findAllChatsForUser(String id);

}