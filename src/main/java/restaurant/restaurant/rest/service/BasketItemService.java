package restaurant.restaurant.rest.service;

import restaurant.restaurant.model.dto.request.RequestBasketItem;

import java.util.List;

public interface BasketItemService {
    void saveBasket(Long userId, Long foodId);
    void deleteBasketItem(RequestBasketItem requestBasketItem);

    RequestBasketItem findById(Long id);
   List< RequestBasketItem> findByBasketId(Long id);
   List< RequestBasketItem> findByFoodsInBasket(Long id);
     void updateBasket(Long byUserId);

    List<RequestBasketItem> findAll();
}
