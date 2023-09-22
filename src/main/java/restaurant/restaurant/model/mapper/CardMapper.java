package restaurant.restaurant.model.mapper;

import restaurant.restaurant.model.Card;
import restaurant.restaurant.model.dto.request.RequestCard;
import restaurant.restaurant.model.dto.response.ResponseCard;

public class CardMapper {
    public static Card mapToCard(ResponseCard responseCard) {
        return Card.builder()
                .cardNumber(responseCard.getCardNumber())
                .expirationDateMonth(responseCard.getExpirationDateMonth())
                .expirationDateYear(responseCard.getExpirationDateYear())
                .user(responseCard.getUser())
                .cvv(responseCard.getCvv())
                .amount(responseCard.getAmount())
                .build();
    } public static Card mapToCardToRequestCard(RequestCard reqCard) {
        return Card.builder()
                .id(reqCard.getId())
                .cardNumber(reqCard.getCardNumber())
                .expirationDateMonth(reqCard.getExpirationDateMonth())
                .expirationDateYear(reqCard.getExpirationDateYear())
                .user(reqCard.getUser())
                .amount(reqCard.getAmount())
                .build();
    }

    public static RequestCard mapToRequestCard(Card card) {
        return RequestCard.builder()
                .id(card.getId())
                .cardNumber(card.getCardNumber())
                .expirationDateMonth(card.getExpirationDateMonth())
                .expirationDateYear(card.getExpirationDateYear())
                .user(card.getUser())
                .amount(card.getAmount())
                .build();
    }

    public static ResponseCard mapToResponseCard(Card card) {
        return ResponseCard.builder()
                .cardNumber(card.getCardNumber())
                .expirationDateMonth(card.getExpirationDateMonth())
                .expirationDateYear(card.getExpirationDateYear())
                .user(card.getUser())
                .cvv(card.getCvv())
                .amount(card.getAmount())
                .build();
    }
}
