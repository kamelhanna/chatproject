package com.iti.chatproject.controller;

import com.iti.chatproject.exception.ChatNotFoundException;
import com.iti.chatproject.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity handleUserNotFoundException(Exception exception, WebRequest webRequest){
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ChatNotFoundException.class)
    public ResponseEntity handleChatNotFoundException(Exception exception, WebRequest webRequest){
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
