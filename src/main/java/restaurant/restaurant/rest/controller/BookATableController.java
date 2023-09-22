package restaurant.restaurant.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import restaurant.restaurant.model.BookATable;
import restaurant.restaurant.model.dto.request.RequestCard;
import restaurant.restaurant.model.dto.request.RequestUser;
import restaurant.restaurant.model.dto.response.ResponseBookATable;
import restaurant.restaurant.rest.service.BookATableService;
import restaurant.restaurant.rest.service.CardService;
import restaurant.restaurant.rest.service.FoodService;
import restaurant.restaurant.rest.service.UserService;
import restaurant.restaurant.security.CurrentUser;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/bookATable")
public class BookATableController {
    private final BookATableService bookATableService;
    private final UserService userService;
private final FoodService foodService;
private final CardService cardService;
    @GetMapping("/{id}")
    public String adminBookATable(ModelMap modelMap, @PathVariable("id")Long id, @AuthenticationPrincipal CurrentUser currentUser) {
        modelMap.addAttribute("bookATable", new BookATable());
        RequestUser byLogin = userService.findByLogin(currentUser.getUsername()).get();
        String nameAndSurname=byLogin.getName()+" "+ byLogin.getSurname();
        modelMap.addAttribute("nameAndSurname", nameAndSurname);
        modelMap.addAttribute("foods", foodService.findAll());


        return "book";
    }
    @PostMapping ("/{userId}")
    public String bookATablePage(@ModelAttribute("bookATable") @Valid ResponseBookATable responseBookATable,
                           @PathVariable("userId") Long userId,
                           BindingResult result, Model model) {
        RequestCard byUserId = cardService.findByUserId(userId);
        double amount = byUserId.getAmount();
        if (amount<responseBookATable.getFeeAmount()){
            model.addAttribute("bookATable", responseBookATable);
            model.addAttribute("foods", foodService.findAll());

            model.addAttribute("money","You don't have enough money");
            return "book";
        }else {
            amount-=responseBookATable.getFeeAmount();
            byUserId.setAmount(amount);
            cardService.updateCard(byUserId);
        }


        if (result.hasErrors()) {
            model.addAttribute("bookATable", responseBookATable);
            model.addAttribute("foods", foodService.findAll());

            return "res";
        }

        bookATableService.saveBookATable(responseBookATable, userId);
        return "redirect:/res?id="+userId;
    }

}
