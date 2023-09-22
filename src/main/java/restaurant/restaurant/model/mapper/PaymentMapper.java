package restaurant.restaurant.model.mapper;

import restaurant.restaurant.model.Payment;
import restaurant.restaurant.model.dto.request.RequestPayment;
import restaurant.restaurant.model.dto.response.ResponsePayment;

public class PaymentMapper {
    public static Payment mapToPayment(ResponsePayment paymentDto) {
        return Payment.builder()
                .card(paymentDto.getCard())
                .userId(paymentDto.getUser())
                .priceAmount(paymentDto.getPriceAmount())
                .foodsInBasket(paymentDto.getFoodsInBasket())
                .build();
    }

    public static RequestPayment mapToRequestPayment(Payment payment) {
        return RequestPayment.builder()
                .id(payment.getId())
                .user(payment.getUserId())
                .foodsInBasket(payment.getFoodsInBasket())
                .priceAmount(payment.getPriceAmount())
                .build();
    }

    public static ResponsePayment mapToResponsePayment(Payment payment) {
        return ResponsePayment.builder()
                .card(payment.getCard())
                .user(payment.getUserId())
                .foodsInBasket(payment.getFoodsInBasket())
                .priceAmount(payment.getPriceAmount())
                .build();
    }
}
