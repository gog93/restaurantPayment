package restaurant.restaurant.model.mapper;

import restaurant.restaurant.model.Basket;
import restaurant.restaurant.model.dto.request.RequestBasket;
import restaurant.restaurant.model.dto.response.ResponseBasket;

public class BasketMapper {
    public static Basket mapToBasket(ResponseBasket basketDto) {
        return Basket.builder()
                .user(basketDto.getUser())
                .build();
    }

    public static RequestBasket mapToRequestBasket(Basket basket) {
        return RequestBasket.builder()
                .id(basket.getId())
                .user(basket.getUser())
                .build();
    }

    public static ResponseBasket mapToResponseBasket(Basket basket) {
        return ResponseBasket.builder()
                .user(basket.getUser())
                .build();
    }

    public static Basket mapToBasketToRequestBasket(RequestBasket basket) {
        return Basket.builder()
                .id(basket.getId())
                .user(basket.getUser())
                .build();
    }
}
