package restaurant.restaurant.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import restaurant.restaurant.model.Card;
import restaurant.restaurant.model.Food;
import restaurant.restaurant.model.User;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePayment {
    private User user;
    private Card card;
    private double priceAmount;
    private List<Food> foodsInBasket;
}
