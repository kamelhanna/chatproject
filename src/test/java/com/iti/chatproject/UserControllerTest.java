package com.iti.chatproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iti.chatproject.controller.UserController;
import com.iti.chatproject.mapstruct.dto.UserDto;
import com.iti.chatproject.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
public class UserControllerTest {
    @InjectMocks
    private UserController userController;
    @Mock
    private UserService userService;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void addUserTest() throws Exception{
        //given
        UserDto userDto = UserDto.builder().userLogin("Kamelhanna")
                .userEmail("Kamel@gemail.com")
                .userPassword("kameltestpass").build();
        ArgumentCaptor<UserDto> argumentCaptor = ArgumentCaptor.forClass(UserDto.class);


        //when
        ResultActions resultActions = mockMvc.perform(post("/users")
                .content(objectMapper.writeValueAsString(userDto))
                .contentType(MediaType.APPLICATION_JSON));

        //then
        verify(userService).addUser(argumentCaptor.capture());
        resultActions.andExpect(status().isCreated());

    }
}
