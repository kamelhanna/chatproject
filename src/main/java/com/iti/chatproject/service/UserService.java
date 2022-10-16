package com.iti.chatproject.service;

import com.iti.chatproject.entity.User;
import com.iti.chatproject.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserEntityRepository userEntityRepository;

    /*public User addUser(){
        return userEntityRepository.save(User.builder().userEmail("kamel")
                .userPassword("Kamel").userLogin("Kamel").build());
    }*/

    public User addUser(User user) {
        return userEntityRepository.save(user);
    }

    public User updateUserPassword(String id, String password){
        Optional<User> user = userEntityRepository.findById(id);
        if(user.isEmpty()) return null;
        else{
            user.get().setUserPassword(password);
            return userEntityRepository.save(user.get());
        }
    }

}
