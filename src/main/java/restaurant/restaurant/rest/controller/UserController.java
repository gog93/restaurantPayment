package restaurant.restaurant.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import restaurant.restaurant.model.dto.response.ResponseUser;
import restaurant.restaurant.rest.service.UserService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reg")
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    @GetMapping()
    public String adminPage(ModelMap modelMap) {
        modelMap.addAttribute("user", new ResponseUser());

        return "registration";
    }

    @PostMapping()
    public String save(@ModelAttribute("user") @Valid ResponseUser responseUser,
                       BindingResult result, Model model) {

        model.addAttribute("user", responseUser);

        if (result.hasErrors()) {
            return "reg";
        }

        String rawPassword = responseUser.getPassword();
        responseUser.setPassword(passwordEncoder.encode(rawPassword));
        userService.saveUser(responseUser);

        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(responseUser.getLogin(), rawPassword)
        );

        SecurityContextHolder.getContext().setAuthentication(auth);

        return "redirect:/";
    }

}
