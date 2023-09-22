package restaurant.restaurant.rest.service;

import restaurant.restaurant.model.Food;
import restaurant.restaurant.model.dto.request.RequestCard;
import restaurant.restaurant.model.dto.request.RequestPayment;

public interface PaymentService {

    RequestPayment findById(Long id);

    RequestPayment findByUserId(Long userId);

    void savePayment(Long userId, Food foodById, RequestCard cardByUserId);
}
