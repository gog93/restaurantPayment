package restaurant.restaurant.rest.service;

import restaurant.restaurant.model.dto.request.RequestCard;
import restaurant.restaurant.model.dto.response.ResponseCard;

public interface CardService {
    void saveCard(ResponseCard card, Long userId);

    RequestCard findById(Long id);
    void updateCard(RequestCard byUserId);

    RequestCard findByUserId(Long userId);
}
