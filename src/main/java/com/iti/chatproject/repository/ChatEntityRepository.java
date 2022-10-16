package com.iti.chatproject.repository;

import com.iti.chatproject.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatEntityRepository extends JpaRepository<Chat, String> {
}