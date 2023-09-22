package restaurant.restaurant.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import restaurant.restaurant.model.dto.response.ResponseCard;
import restaurant.restaurant.rest.service.CardService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping()
public class CardController {
    private final CardService cardService;

    @PostMapping("/{id}/addCard")
    public String addCard(@ModelAttribute("card") @Valid ResponseCard responseCard, @PathVariable("id") Long userId,
                          BindingResult result, Model model) {

        model.addAttribute("user", responseCard);

        if (result.hasErrors()) {
            return "res";
        }

        cardService.saveCard(responseCard, userId);

        return "redirect:/res?id=" + userId;
    }

}
