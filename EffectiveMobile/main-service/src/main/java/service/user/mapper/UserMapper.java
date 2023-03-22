package service.user.mapper;

import service.user.dto.UserDto;
import service.user.model.User;

public class UserMapper {
    public static UserDto toUserDto(User user) {
        if (user == null) {
            return null;
        }
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail()

        );
    }

    public static User toUser(UserDto userDto){
        if (userDto == null) {
            return null;
        }
        return User.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .build();


    }

}
