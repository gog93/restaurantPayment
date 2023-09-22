package restaurant.restaurant.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import restaurant.restaurant.model.UserType.UserType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestAdmin {
    private Long id;
    private String name;
    private String surname;
    private UserType userType;
    private String phoneNumber;
    private String email;
}
