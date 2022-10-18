package com.iti.chatproject.service;

import com.iti.chatproject.entity.User;
import com.iti.chatproject.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserEntityRepository userEntityRepository;

    /*public User getUser(){
        return userEntityRepository.save(User.builder().userEmail("kamel")
                .userPassword("Kamel").userLogin("Kamel").build());
    }*/

    public User addUser(User user) {
        return userEntityRepository.save(user);
    }

    public User updateUser(User user){

            return userEntityRepository.save(user);
    }

    public Optional<User> getUser(String id) {
         return userEntityRepository.findById(id);
    }
}
