package de.neuefische.ffmjava221.auth.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/app-users")
@RequiredArgsConstructor
public class AppUserController {
    @GetMapping("/login")
    public String login() {
        return "OK";
    }

    @GetMapping("/logout")
    public void logout(HttpSession httpSession) {
        httpSession.invalidate();
    }

    @GetMapping("/me")
    public String me() {
        User loggedInUser = (User)SecurityContextHolder
            .getContext()
            .getAuthentication()
            .getPrincipal();

        return loggedInUser.getUsername();
    }
}
