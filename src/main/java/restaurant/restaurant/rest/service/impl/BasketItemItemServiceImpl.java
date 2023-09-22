package restaurant.restaurant.rest.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restaurant.restaurant.model.Basket;
import restaurant.restaurant.model.BasketItem;
import restaurant.restaurant.model.Food;
import restaurant.restaurant.model.dto.request.RequestBasket;
import restaurant.restaurant.model.dto.request.RequestBasketItem;
import restaurant.restaurant.model.dto.request.RequestFood;
import restaurant.restaurant.model.mapper.BasketItemMapper;
import restaurant.restaurant.model.mapper.BasketMapper;
import restaurant.restaurant.model.mapper.FoodMapper;
import restaurant.restaurant.model.mapper.UserMapper;
import restaurant.restaurant.rest.repository.BasketItemRepository;
import restaurant.restaurant.rest.service.BasketItemService;
import restaurant.restaurant.rest.service.BasketService;
import restaurant.restaurant.rest.service.FoodService;
import restaurant.restaurant.rest.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketItemItemServiceImpl implements BasketItemService {

    @PersistenceContext
    private EntityManager entityManager;
    private final BasketItemRepository basketItemRepository;
    private final BasketService basketService;
    private final FoodService foodService;
    private final UserService userService;

    @Transactional
    @Override
    public void saveBasket(Long userId, Long foodId) {
        RequestBasket basket = basketService.findByUserId(userId);
        Basket basket1 = new Basket();
        BasketItem basketItem = new BasketItem();
        // Get existing food from the database
        RequestFood food = foodService.findById(foodId);

        Food mappedFood = FoodMapper.mapToFoodFromRequestFood(food);
        Food attachedFood = entityManager.merge(mappedFood);

        if (food == null) {
            throw new RuntimeException("Food not found");
        }

        if (basket == null) {
            basket1.setUser(UserMapper.mapToUserFromRequestUser(userService.findById(userId)));
            basketService.saveBasket(basket1);
            basketItem.setBasket(basket1);
            basketItem.setFoodsInBasket(attachedFood);
            basketItemRepository.save(basketItem);
        } else {

            basketItem.setBasket(BasketMapper.mapToBasketToRequestBasket(basket));
            basketItem.setFoodsInBasket(attachedFood);
            basketItemRepository.save(basketItem);

        }
    }

    @Override
    public void deleteBasketItem(RequestBasketItem requestBasketItem) {
        basketItemRepository.delete(BasketItemMapper.mapToBasketToRequestBasketItem(requestBasketItem));
    }


    @Override
    public RequestBasketItem findById(Long id) {
        return BasketItemMapper.mapToRequestBasketItem(basketItemRepository.findById(id).get());
    }

    @Override
    public List <RequestBasketItem> findByBasketId(Long id) {
        return BasketItemMapper.basketItemsListConvert(basketItemRepository.findByBasketId(id));

    }

    @Override
    public List<RequestBasketItem> findByFoodsInBasket(Long id) {
        return BasketItemMapper.basketItemsListConvert(basketItemRepository.findByFoodsInBasketId(id));

    }

    @Override
    public void updateBasket(Long byUserId) {
//        BasketItem byUserId1 = basketItemRepository.findByBasketId(byUserId);
//        BasketItem basketItem = BasketItemMapper.mapToBasketItem(byUserId);
//        basketItemRepository.save(basketItem);
    }

    @Override
    public List<RequestBasketItem> findAll() {
        return null;
    }
}
