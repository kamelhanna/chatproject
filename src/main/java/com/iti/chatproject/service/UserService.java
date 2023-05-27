package com.iti.chatproject.service;

import com.iti.chatproject.entity.AuthoritiesEntity;
import com.iti.chatproject.entity.User;
import com.iti.chatproject.exception.UserNotFoundException;
import com.iti.chatproject.mapstruct.dto.UserDto;
import com.iti.chatproject.mapstruct.mapper.MapStructMapper;
import com.iti.chatproject.repository.AuthoritiesEntityRepository;
import com.iti.chatproject.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserEntityRepository userEntityRepository;
    private MapStructMapper mapstructMapper;
    private AuthoritiesEntityRepository authoritiesEntityRepository;

    @Autowired
    public UserService(UserEntityRepository userEntityRepository, MapStructMapper mapstructMapper, AuthoritiesEntityRepository authoritiesEntityRepository) {
        this.userEntityRepository = userEntityRepository;
        this.mapstructMapper = mapstructMapper;
        this.authoritiesEntityRepository = authoritiesEntityRepository;
    }


    public UserDto addUser(UserDto userDto) {
        User user = userEntityRepository.save(mapstructMapper.userDtoToUser(userDto));
        authoritiesEntityRepository.save(
                AuthoritiesEntity.builder()
                        .userId(user.getId())
                        .username(user.getUserLogin())
                        .authority("ROLE_USER")
                        .build()
        );

        return mapstructMapper.userToUserDto(user);
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

    public List<User> getAllUsers() {
        return userEntityRepository.findAll();
    }

    public User getUserId(String userName) {

        return userEntityRepository.findUserByUserLogin(userName);
    }
}
