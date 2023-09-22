package restaurant.restaurant.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import restaurant.restaurant.model.User;
import restaurant.restaurant.model.UserType.UserType;

import javax.persistence.OneToOne;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestCard {
    private Long id;
    private String cardNumber;
    private int expirationDateMonth;
    private int expirationDateYear;
    private User user;
    private double amount;
}
