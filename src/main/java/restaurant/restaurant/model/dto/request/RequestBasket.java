package restaurant.restaurant.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import restaurant.restaurant.model.Basket;
import restaurant.restaurant.model.BasketItem;
import restaurant.restaurant.model.Food;
import restaurant.restaurant.model.User;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestBasket {
    private Long id;
    private User user;


}
