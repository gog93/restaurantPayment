package restaurant.restaurant.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import restaurant.restaurant.model.Basket;
import restaurant.restaurant.model.Food;
import restaurant.restaurant.model.User;
import restaurant.restaurant.model.UserType.UserType;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestBasketItem {
    private Long id;
    private Food foods;
    private Basket basket;
    private int foodCount;

}
