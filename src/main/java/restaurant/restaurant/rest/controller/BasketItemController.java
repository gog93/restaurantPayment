package restaurant.restaurant.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import restaurant.restaurant.model.BasketItem;
import restaurant.restaurant.model.Food;
import restaurant.restaurant.model.dto.request.RequestBasket;
import restaurant.restaurant.model.dto.request.RequestBasketItem;
import restaurant.restaurant.rest.service.BasketItemService;
import restaurant.restaurant.rest.service.BasketService;
import restaurant.restaurant.security.CurrentUser;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/basketItem")
public class BasketItemController {
    private final BasketItemService basketItemService;
    private final BasketService basketService;


    @GetMapping("/{userId}")
    public String basketPagePage(ModelMap modelMap, @PathVariable("userId") Long userId, @AuthenticationPrincipal CurrentUser currentUser) {
        RequestBasket basket = basketService.findByUserId(userId);
        List<RequestBasketItem> byBasket = basketItemService.findByBasketId(basket.getId());

        if (basket != null) {
            if (byBasket.size()==0) {
                modelMap.addAttribute("food", "you don't have any foods added yet");
            }
            modelMap.addAttribute("foods", byBasket);

            return "basket";
        }


        return "basket";
    }

    @GetMapping("/putInBasket/{userId}/{foodId}")
    public String cardPage( @PathVariable("userId") Long userId,
                           @PathVariable("foodId") Long foodId) {

            basketItemService.saveBasket(userId, foodId);

        return "redirect:/res/menu/" + userId;
    }

}
