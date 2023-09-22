package restaurant.restaurant.rest.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restaurant.restaurant.model.Basket;
import restaurant.restaurant.model.dto.request.RequestBasket;
import restaurant.restaurant.model.dto.response.ResponseBasket;
import restaurant.restaurant.model.mapper.BasketMapper;
import restaurant.restaurant.rest.repository.BasketRepository;
import restaurant.restaurant.rest.service.BasketService;
import restaurant.restaurant.rest.service.UserService;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {

    private final UserService userService;
    private final BasketRepository basketRepository;

    @Override
    public void saveBasket(Basket basket) {
        basketRepository.save(basket);
    }


    @Override
    public RequestBasket findById(Long id) {
        return BasketMapper.mapToRequestBasket(basketRepository.findById(id).get());
    }

    @Override
    public RequestBasket findByUserId(Long id) {
        Basket byUserId = basketRepository.findByUserId(id);
        if (byUserId==null){
            return null;
        }
        return BasketMapper.mapToRequestBasket(byUserId);

    }


//    @Override
//    public void updateBasket(Long byUserId) {
//        BasketItem byUserId1 = basketItemRepository.findByUserId(byUserId);
////        BasketItem basketItem = BasketItemMapper.mapToBasketItem(byUserId);
////        basketItemRepository.save(basketItem);
//    }

}
