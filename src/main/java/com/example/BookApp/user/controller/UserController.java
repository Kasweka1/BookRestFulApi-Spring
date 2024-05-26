package com.example.BookApp.user.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.example.BookApp.user.service.UserRegistrationDto;
import com.example.BookApp.user.model.User;
import com.example.BookApp.user.service.LoginRequestDto;
import com.example.BookApp.user.service.UserService;

import jakarta.servlet.http.HttpSession;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(@RequestParam(value = "success", required = false) String success, Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        model.addAttribute("success", success != null);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        userService.registerUser(registrationDto);
        return "redirect:/login?success";
    }

    @GetMapping("/login")
    public String showLoginForm(@RequestParam(value = "success", required = false) String success, Model model) {
        model.addAttribute("loginRequest", new LoginRequestDto());
        model.addAttribute("success", success != null);
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("loginRequest") LoginRequestDto loginRequestDto, Model model, HttpSession session) {
        User user = userService.loginUser(loginRequestDto);
        if (user != null) {
            session.setAttribute("loggedInUser", user);
            return "redirect:/books/dashboard"; // Redirect to books page upon successful login
        }
        model.addAttribute("error", "Invalid email or password");
        return "login";
    }
}
