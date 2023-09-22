package restaurant.restaurant.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import restaurant.restaurant.model.Admin;
import restaurant.restaurant.model.User;
import restaurant.restaurant.model.dto.request.RequestAdmin;
import restaurant.restaurant.model.dto.request.RequestUser;
import restaurant.restaurant.model.dto.response.ResponseCard;
import restaurant.restaurant.model.dto.response.ResponseFood;
import restaurant.restaurant.rest.service.AdminService;
import restaurant.restaurant.rest.service.FoodService;
import restaurant.restaurant.rest.service.UserService;
import restaurant.restaurant.security.CurrentUser;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/res")
public class RestaurantController {
    private final UserService userService;
    private final AdminService adminService;
    private final FoodService foodService;


    @GetMapping()
    public String resPage(ModelMap modelMap, @RequestParam(value = "id", required = false) Long id, @AuthenticationPrincipal CurrentUser currentUser) {

        if (currentUser != null) {
            if (currentUser.getUser() instanceof User) {
                RequestUser byLogin = userService.findByLogin(currentUser.getUsername()).get();
                String nameAndSurname = byLogin.getName() + " " + byLogin.getSurname();
                modelMap.addAttribute("nameAndSurname", nameAndSurname);
                modelMap.addAttribute("id", byLogin.getId());
                modelMap.addAttribute("user", currentUser.getUser());


            }  else  if (currentUser.getAdmin() instanceof Admin) {
                RequestAdmin byEmail = adminService.findByEmail(currentUser.getUsername()).get();
                modelMap.addAttribute("admin", byEmail);

            }

                modelMap.addAttribute("food", new ResponseFood());
            modelMap.addAttribute("card", new ResponseCard());

        }
        return "res";
    }
    @GetMapping("/menu/{userId}")
    public String menuPage(ModelMap modelMap, @PathVariable("userId") Long userId, @AuthenticationPrincipal CurrentUser currentUser) {

        modelMap.addAttribute("foods",foodService.findAll() );
        modelMap.addAttribute("userId",userId );

        return "menu";
    }

}
