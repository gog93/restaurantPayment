package restaurant.restaurant.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import restaurant.restaurant.model.User;
import restaurant.restaurant.model.UserType.UserType;

import javax.persistence.OneToOne;
import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCard {
    private String cardNumber;
    private int expirationDateMonth;
    private int expirationDateYear;
    private User user;
    private int cvv;
    private double amount;
}
