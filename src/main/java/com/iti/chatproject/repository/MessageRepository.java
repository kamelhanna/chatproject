package com.iti.chatproject.repository;

import com.iti.chatproject.entity.Chat;
import com.iti.chatproject.entity.Message;
import com.iti.chatproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, String> {
    List<Message> findMessagesByMessageChat(Chat messageChat);

}