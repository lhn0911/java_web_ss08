package com.rikkei.ss08.controller;

import com.rikkei.ss08.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegistrationController {
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "Bai4/registration";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") @Validated User user,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "Bai4/registration";
        }
        model.addAttribute("user", user);
        return "Bai4/result";
    }
}
