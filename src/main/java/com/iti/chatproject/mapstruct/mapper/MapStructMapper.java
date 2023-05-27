package com.iti.chatproject.mapstruct.mapper;

import com.iti.chatproject.entity.Chat;
import com.iti.chatproject.entity.Message;
import com.iti.chatproject.entity.User;
import com.iti.chatproject.entity.UserChat;
import com.iti.chatproject.mapstruct.dto.ChatDto;
import com.iti.chatproject.mapstruct.dto.MessageDto;
import com.iti.chatproject.mapstruct.dto.UserChatDto;
import com.iti.chatproject.mapstruct.dto.UserDto;
import org.mapstruct.Mapping;

import java.util.List;

@org.mapstruct.Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {
    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);

    List<UserDto> usersToUserDtos(List<User> users);

    ChatDto chatToChatDto(Chat chat);

    Chat chatDtoToChat(ChatDto chatDto);

    List<ChatDto> chatsToChatDtos(List<Chat> chats);

    UserChat userChatDtoToUserChat(UserChatDto userChatDto);

    Message messageDtoToMessage(MessageDto messageDto);
}
