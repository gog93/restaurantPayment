package restaurant.restaurant.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {

        CurrentUser securityUser = (CurrentUser) authentication.getPrincipal();
        String redirectURL = request.getContextPath();

        if (securityUser.getAdmin() != null && securityUser.getAdmin().getUserType().name().equalsIgnoreCase("ADMIN")) {
            redirectURL = "/admin?id="+ securityUser.getAdmin().getId();
        } else if (securityUser.getUser() != null && securityUser.getUser().getUserType().name().equalsIgnoreCase("USER")) {
            redirectURL = "/res?id="+securityUser.getUser().getId();
        }

        response.sendRedirect(redirectURL);
    }

}
