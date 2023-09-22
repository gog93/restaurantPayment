package restaurant.restaurant.rest.service;

import restaurant.restaurant.model.Basket;
import restaurant.restaurant.model.dto.request.RequestBasket;
import restaurant.restaurant.model.dto.request.RequestBasketItem;
import restaurant.restaurant.model.dto.response.ResponseBasket;

import java.util.List;

public interface BasketService {
    void saveBasket(Basket basket);

    RequestBasket findById(Long id);
    RequestBasket findByUserId(Long id);

}
