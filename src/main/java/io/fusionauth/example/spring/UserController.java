package io.fusionauth.example.spring;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    public UserController() {

    }

    @RequestMapping("/user")
    public String userPage(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            System.out.println(principal.getClaims().toString());
            model.addAttribute("profile", principal.getClaims());
        }
        return "user";
    }
}
