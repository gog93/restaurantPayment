package restaurant.restaurant.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import restaurant.restaurant.model.Admin;
import restaurant.restaurant.rest.service.AdminService;
import restaurant.restaurant.security.CurrentUser;

@Controller
@RequiredArgsConstructor
@RequestMapping()
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/admin")
    public String adminPage(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        modelMap.addAttribute("admin", currentUser.getAdmin());
        return "res";
    }
    @GetMapping("/card")
    public String cardPage() {
        return "card";
    }

}
