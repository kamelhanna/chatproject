package com.iti.chatproject.controller;

import com.iti.chatproject.entity.User;
import com.iti.chatproject.mapstruct.dto.UserDto;
import com.iti.chatproject.mapstruct.mapper.MapStructMapper;
import com.iti.chatproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    private MapStructMapper mapstructMapper;

    private UserService userService;

    @Autowired
    public UserController(
            MapStructMapper mapstructMapper, UserService userService) {
        this.mapstructMapper = mapstructMapper;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void>  addUser(@Valid @RequestBody UserDto userDto){
        userService.addUser(mapstructMapper.userDtoToUser(userDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void>  updateUser(@RequestBody UserDto userDto){
        userService.updateUser(mapstructMapper.userDtoToUser(userDto));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto>  getUser(@PathVariable String id){
        return new ResponseEntity<>(mapstructMapper.userToUserDto(userService.getUser(id)),
                HttpStatus.OK);
    }

}
