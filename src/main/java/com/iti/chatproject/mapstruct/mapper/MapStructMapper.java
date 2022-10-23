package com.iti.chatproject.mapstruct.mapper;

import com.iti.chatproject.entity.Chat;
import com.iti.chatproject.entity.Message;
import com.iti.chatproject.entity.User;
import com.iti.chatproject.entity.UserChat;
import com.iti.chatproject.mapstruct.dto.ChatDto;
import com.iti.chatproject.mapstruct.dto.MessageDto;
import com.iti.chatproject.mapstruct.dto.UserChatDto;
import com.iti.chatproject.mapstruct.dto.UserDto;

import java.util.List;

@org.mapstruct.Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {
    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);

    ChatDto chatToChatDto(Chat chat);

    Chat chatDtoToChat(ChatDto chatDto);

    List<ChatDto> chatsToChatDtos(List<Chat> chats);

    UserChat userChatDtoToUserChat(UserChatDto userChatDto);

    MessageDto MessageToMessageDto(Message message);

    Message messageDtoToMessage(MessageDto messageDto);



}
