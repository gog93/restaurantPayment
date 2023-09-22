package restaurant.restaurant.rest.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restaurant.restaurant.model.Card;
import restaurant.restaurant.model.dto.request.RequestCard;
import restaurant.restaurant.model.dto.request.RequestUser;
import restaurant.restaurant.model.dto.response.ResponseCard;
import restaurant.restaurant.model.mapper.CardMapper;
import restaurant.restaurant.model.mapper.UserMapper;
import restaurant.restaurant.rest.repository.CardRepository;
import restaurant.restaurant.rest.service.CardService;
import restaurant.restaurant.rest.service.UserService;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final UserService userService;

    @Override
    public void saveCard(ResponseCard card, Long userId) {
        RequestUser byId = userService.findById(userId);
        card.setUser(UserMapper.mapToUserFromRequestUser(byId));
        int amount = (int) (Math.random() * 1001);
        card.setAmount(amount);
        cardRepository.save(CardMapper.mapToCard(card));

    }

    @Override
    public RequestCard findById(Long id) {
        return CardMapper.mapToRequestCard(cardRepository.findById(id).get());
    }

    @Override
    public RequestCard findByUserId(Long userId) {
        Card byUserId = cardRepository.findByUserId(userId);
        if (byUserId == null) {
            return null;
        }
        return CardMapper.mapToRequestCard(byUserId);
    }
    @Override
    public void updateCard(RequestCard byUserId) {
        Card card = CardMapper.mapToCardToRequestCard(byUserId);
        cardRepository.save(card);
    }
}
