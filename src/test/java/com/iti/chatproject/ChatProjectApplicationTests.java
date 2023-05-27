package com.iti.chatproject;

import com.iti.chatproject.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class ChatProjectApplicationTests {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void getPasswordEncoder(){
        System.out.println(passwordEncoder.matches("david", "$2a$10$XaQvGDXTxOCJIE3I9zrjL.0Xw7a/kLNDgF1P5D5lLVFCkbhvsnjgi"));
    }
}
