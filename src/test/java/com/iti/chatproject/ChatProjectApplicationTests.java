package com.iti.chatproject;

import com.iti.chatproject.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@WebMvcTest(UserController.class)
class ChatProjectApplicationTests {

    @Test
    void contextLoads() {
    }

    public void allowEntryForNewUser(){

    }

}
