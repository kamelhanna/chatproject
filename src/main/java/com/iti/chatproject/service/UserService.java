package com.iti.chatproject.service;

import com.iti.chatproject.entity.User;
import com.iti.chatproject.exception.UserNotFoundException;
import com.iti.chatproject.mapstruct.dto.UserDto;
import com.iti.chatproject.mapstruct.mapper.MapStructMapper;
import com.iti.chatproject.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    @Autowired
    private UserEntityRepository userEntityRepository;
    @Autowired
    private MapStructMapper mapstructMapper;

    /*public User getUser(){
        return userEntityRepository.save(User.builder().userEmail("kamel")
                .userPassword("Kamel").userLogin("Kamel").build());
    }*/

    public UserDto addUser(UserDto userDto) {
        return mapstructMapper.userToUserDto(userEntityRepository.save(mapstructMapper.userDtoToUser(userDto)));
    }

    public User updateUser(User user){
            return userEntityRepository.save(user);
    }

    public User getUser(String id) {
        if(userEntityRepository.existsById(id)) {
            return userEntityRepository.findById(id).get();
        }
        throw new UserNotFoundException();
    }
}
