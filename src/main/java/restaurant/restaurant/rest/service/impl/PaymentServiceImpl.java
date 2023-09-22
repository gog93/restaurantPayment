package restaurant.restaurant.rest.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurant.restaurant.model.Card;
import restaurant.restaurant.model.Food;
import restaurant.restaurant.model.Payment;
import restaurant.restaurant.model.User;
import restaurant.restaurant.model.dto.request.RequestBasketItem;
import restaurant.restaurant.model.dto.request.RequestCard;
import restaurant.restaurant.model.dto.request.RequestPayment;
import restaurant.restaurant.model.mapper.CardMapper;
import restaurant.restaurant.model.mapper.PaymentMapper;
import restaurant.restaurant.model.mapper.UserMapper;
import restaurant.restaurant.rest.repository.PaymentRepository;
import restaurant.restaurant.rest.service.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    @PersistenceContext
    private EntityManager entityManager;
    private final PaymentRepository paymentRepository;
    private final UserService userService;
    private final CardService cardService;
    private final FoodService foodService;
    private final BasketItemService basketItemService;

    @Transactional
    @Override
    public void savePayment(Long userId, Food foodById, RequestCard card) {
        Payment payment = new Payment();
        List<Food> foods = new ArrayList<>();
        User userById = UserMapper.mapToUserFromRequestUser(userService.findById(userId));
        Card cardByUserId=CardMapper.mapToCardToRequestCard(card);
        Food attachedFood = entityManager.merge(foodById);


            double amount = cardByUserId.getAmount() - foodById.getPrice();
            cardByUserId.setAmount(amount);
            cardService.updateCard(CardMapper.mapToRequestCard(cardByUserId));
            foods.add(attachedFood);
            payment.setCard(cardByUserId);
            payment.setFoodsInBasket(foods);
            payment.setUserId(userById);
            payment.setPriceAmount(attachedFood.getPrice());
            paymentRepository.save(payment);
            List<RequestBasketItem> byFoodsInBasket = basketItemService.findByFoodsInBasket(foodById.getId());
            basketItemService.deleteBasketItem(byFoodsInBasket.get(0));



    }

    @Override
    public RequestPayment findById(Long id) {
        return PaymentMapper.mapToRequestPayment(paymentRepository.findById(id).get());
    }

    @Override
    public RequestPayment findByUserId(Long userId) {

        return PaymentMapper.mapToRequestPayment(paymentRepository.findByUserId(userId));
    }

}
