package com.ritesh.studyhabitanalyzer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ritesh.studyhabitanalyzer.model.User;
import com.ritesh.studyhabitanalyzer.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    // ==============================
    // SHOW REGISTER PAGE
    // ==============================
    @GetMapping("/register")
    public String registerPage(Model model) {

        model.addAttribute("user", new User());

        return "register";
    }

    // ==============================
    // REGISTER USER
    // ==============================
    @PostMapping("/register")
    public String registerUser(User user) {

        userService.registerUser(user);

        return "redirect:/login";
    }

    // ==============================
    // SHOW LOGIN PAGE
    // ==============================
    @GetMapping("/login")
    public String loginPage() {

        return "login";
    }

    // ==============================
    // LOGIN
    // ==============================
    @PostMapping("/login")
    public String loginUser(
            @RequestParam String email,
            @RequestParam String password,
            HttpSession session) {

        boolean result = userService.checkLogin(email, password);

        System.out.println("Login Result : " + result);

        if (result) {

            User user = userService.findByEmail(email);

            session.setAttribute("loggedUser", user);

            System.out.println("Login Success");

            return "redirect:/dashboard";
        }

        System.out.println("Login Failed");

        return "redirect:/login?error=true";
    }

    // ==============================
    // LOGOUT
    // ==============================
    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/login";
    }
}