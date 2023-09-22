package restaurant.restaurant.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import restaurant.restaurant.model.Card;
import restaurant.restaurant.model.Food;
import restaurant.restaurant.model.User;
import restaurant.restaurant.model.dto.request.RequestBasket;
import restaurant.restaurant.model.dto.request.RequestBasketItem;
import restaurant.restaurant.model.dto.request.RequestCard;
import restaurant.restaurant.model.dto.request.RequestUser;
import restaurant.restaurant.model.dto.response.ResponseCard;
import restaurant.restaurant.model.mapper.CardMapper;
import restaurant.restaurant.model.mapper.FoodMapper;
import restaurant.restaurant.model.mapper.UserMapper;
import restaurant.restaurant.rest.service.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping()
public class PaymentController {
    private final PaymentService paymentService;
    private final CardService cardService;
    private final FoodService foodService;
    private final BasketItemService basketItemService;
    private final BasketService basketService;

    @GetMapping("/pay/{userId}/{foodId}")
    public String addCard(@PathVariable("userId") Long userId, @PathVariable("foodId") Long foodId,
                          Model model) {


        RequestCard cardByUserId = cardService.findByUserId(userId);
        Food foodById = FoodMapper.mapToFoodFromRequestFood(foodService.findById(foodId));
        RequestBasket basket = basketService.findByUserId(userId);
        List<RequestBasketItem> byBasket = basketItemService.findByBasketId(basket.getId());
        if (cardByUserId == null) {
//            if (byBasket.size() == 0) {
//                model.addAttribute("food", "you don't have any foods added yet. " +
//                        "Please go menu and choose foods.");
//
//            }
            model.addAttribute("foods", byBasket);
            model.addAttribute("cardMsg", "you don't have any card added yet");
            model.addAttribute("userId", userId);

            return "basket";

        } else {
            if (cardByUserId.getAmount() < foodById.getPrice()) {
                model.addAttribute("foods", byBasket);
                model.addAttribute("userId", userId);
                model.addAttribute("cardMsgEnough", "you don't have enough money");
                return "basket";

            } else
                paymentService.savePayment(userId, foodById, cardByUserId);
        }
        return "redirect:/res?id=" + userId;
    }

}
