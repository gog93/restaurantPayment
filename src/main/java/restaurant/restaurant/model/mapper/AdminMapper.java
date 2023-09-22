package restaurant.restaurant.model.mapper;

import restaurant.restaurant.model.Admin;
import restaurant.restaurant.model.dto.request.RequestAdmin;
import restaurant.restaurant.model.dto.response.ResponseAdmin;

public class AdminMapper {
    public static Admin mapToAdmin(ResponseAdmin adminDto) {
        return Admin.builder()
                .name(adminDto.getName())
                .surname(adminDto.getSurname())
                .email(adminDto.getEmail())
                .password(adminDto.getPassword())
                .userType(adminDto.getUserType())
                .phoneNumber(adminDto.getPhoneNumber())
                .build();
    }

    public static RequestAdmin mapToRequestAdmin(Admin admin) {
        return RequestAdmin.builder()
                .id(admin.getId())
                .name(admin.getName())
                .surname(admin.getSurname())
                .email(admin.getEmail())
                .userType(admin.getUserType())
                .phoneNumber(admin.getPhoneNumber())
                .build();
    }

    public static ResponseAdmin mapToResponseAdmin(Admin admin) {
        return ResponseAdmin.builder()
                .name(admin.getName())
                .surname(admin.getSurname())
                .email(admin.getEmail())
                .userType(admin.getUserType())
                .phoneNumber(admin.getPhoneNumber())
                .password(admin.getPassword())
                .build();
    }
}
