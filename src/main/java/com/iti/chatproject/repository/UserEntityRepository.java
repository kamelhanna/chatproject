package com.iti.chatproject.repository;

import com.iti.chatproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserEntityRepository extends JpaRepository<User, String> {
    User findUserByUserLogin(String userLogin);

}