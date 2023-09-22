package restaurant.restaurant.model.mapper;

import restaurant.restaurant.model.Basket;
import restaurant.restaurant.model.BasketItem;
import restaurant.restaurant.model.Food;
import restaurant.restaurant.model.dto.request.RequestBasketItem;
import restaurant.restaurant.model.dto.request.RequestFood;
import restaurant.restaurant.model.dto.response.ResponseBasketItem;

import java.util.List;
import java.util.stream.Collectors;

public class BasketItemMapper {
    public static BasketItem mapToBasketItem(ResponseBasketItem basketDto) {
        return BasketItem.builder()
                .foodsInBasket(basketDto.getFoods())
                .basket(basketDto.getBasket())
                .foodCount(basketDto.getFoodCount())
                .build();
    }
    public static List<RequestBasketItem> basketItemsListConvert(List<BasketItem> basketList) {
        List<RequestBasketItem> collect = basketList.stream()
                .map(BasketItemMapper::mapToRequestBasketItem)
                .collect(Collectors.toList());
        return collect;
    }

    public static RequestBasketItem mapToRequestBasketItem(BasketItem basketItem) {
        return RequestBasketItem.builder()
                .id(basketItem.getId())
                .foods(basketItem.getFoodsInBasket())
                .basket(basketItem.getBasket())
                .foodCount(basketItem.getFoodCount())
                .build();
    }

    public static ResponseBasketItem mapToResponseBasketItem(BasketItem basketItem) {
        return ResponseBasketItem.builder()
                .foods(basketItem.getFoodsInBasket())
                .basket(basketItem.getBasket())
                .foodCount(basketItem.getFoodCount())
                .build();
    }

    public static BasketItem mapToBasketToRequestBasketItem(RequestBasketItem basket) {
        return BasketItem.builder()
                .id(basket.getId())
                .foodsInBasket(basket.getFoods())
                .basket(basket.getBasket())
               .foodCount(basket.getFoodCount())
                .build();
    }
}
