package com.iti.chatproject.controller;

import com.iti.chatproject.entity.User;
import com.iti.chatproject.mapstruct.dto.UserDto;
import com.iti.chatproject.mapstruct.mapper.MapStructMapper;
import com.iti.chatproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private MapStructMapper mapstructMapper;

    private UserService userService;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(MapStructMapper mapstructMapper, UserService userService, PasswordEncoder passwordEncoder) {
        this.mapstructMapper = mapstructMapper;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public ResponseEntity<UserDto>  addUser(@Valid @RequestBody UserDto userDto){
         userDto.setUserPassword(passwordEncoder.encode(userDto.getUserPassword()));
        return new ResponseEntity<>(userService.addUser(userDto),HttpStatus.CREATED);
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

    @GetMapping
    public ResponseEntity<List<UserDto>>  getAllUsers(){
        return new ResponseEntity<>(mapstructMapper.usersToUserDtos(userService.getAllUsers()),
                HttpStatus.OK);
    }


    @GetMapping("/userId")
    @ResponseBody
    public ResponseEntity<UserDto> currentUserId(Principal principal) {
       return new ResponseEntity<>(mapstructMapper.userToUserDto(userService.getUserId(principal.getName())), HttpStatus.OK);
    }


}
