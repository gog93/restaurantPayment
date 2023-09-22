package restaurant.restaurant.model.mapper;

import restaurant.restaurant.model.User;
import restaurant.restaurant.model.dto.request.RequestUser;
import restaurant.restaurant.model.dto.response.ResponseUser;

public class UserMapper {
    public static User mapToUser(ResponseUser userDto) {
        return User.builder()
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .password(userDto.getPassword())
                .login(userDto.getLogin())
                .gender(userDto.getGender())
                .phoneNumber(userDto.getPhoneNumber())
                .build();
    }

    public static RequestUser mapToRequestUser(User user) {
        return RequestUser.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .gender(user.getGender())
                .build();
    }

    public static ResponseUser mapToResponseUser(User user) {
        return ResponseUser.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .password(user.getPassword())
                .login(user.getLogin())
                .gender(user.getGender())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

    public static User mapToUserFromRequestUser(RequestUser requestUser) {
        return User.builder()
                .id(requestUser.getId())
                .name(requestUser.getName())
                .surname(requestUser.getSurname())
                .gender(requestUser.getGender())
                .build();
    }
}
