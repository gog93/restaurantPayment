package restaurant.restaurant.util;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import restaurant.restaurant.model.UserType.UserType;
import restaurant.restaurant.model.dto.response.ResponseAdmin;
import restaurant.restaurant.rest.service.AdminService;

@Component
@RequiredArgsConstructor
public class OnApplicationStartEvent implements ApplicationListener<ApplicationReadyEvent> {


    private final AdminService adminService;

    private final PasswordEncoder passwordEncoder;


    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        if (!adminService.findByEmail("admin@mail.com").isPresent()) {
            adminService.saveAdmin(ResponseAdmin.builder()
                    .email("admin@mail.com")
                    .password(passwordEncoder.encode("admin"))
                    .surname("admin")
                    .name("admin")
                    .userType(UserType.ADMIN)
                    .phoneNumber("374000000")
                    .build());
        }
    }
}
