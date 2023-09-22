package restaurant.restaurant.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import restaurant.restaurant.model.dto.response.ResponseCard;
import restaurant.restaurant.model.dto.response.ResponseFood;
import restaurant.restaurant.rest.service.FoodService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping()
public class FoodController {
    private final FoodService foodService;


    @PostMapping("/addFood")
    public String addFood(@ModelAttribute("food") @Valid ResponseFood responsefood,
                          BindingResult result, Model model) {
        model.addAttribute("user", responsefood);

        if (result.hasErrors()) {
            return "res";
        }

        foodService.saveFood(responsefood);
        return "redirect:/res";
    }

}
