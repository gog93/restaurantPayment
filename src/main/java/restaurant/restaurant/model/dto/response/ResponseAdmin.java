package restaurant.restaurant.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import restaurant.restaurant.model.UserType.UserType;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseAdmin {
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String password;
    private UserType userType;
}
