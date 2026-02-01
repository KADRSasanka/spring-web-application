package com.deaprj.spring_web_application.controllers;

import com.deaprj.spring_web_application.models.User;
import com.deaprj.spring_web_application.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserRepository userRepository;

    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String adminDashboard(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "admin";
    }

    @PostMapping("/create-user")
    public String createUser(User user, RedirectAttributes redirectAttributes) {

        userRepository.save(user);

        redirectAttributes.addFlashAttribute(
                "successMessage", "New User added Successfully!"
        );

        return "redirect:/admin";
    }

}
