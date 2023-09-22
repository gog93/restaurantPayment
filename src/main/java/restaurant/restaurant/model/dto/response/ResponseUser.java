package restaurant.restaurant.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseUser {
    private String name;
    private String surname;
    private String login;
    private String password;
    private String phoneNumber;
    private String gender;
}
