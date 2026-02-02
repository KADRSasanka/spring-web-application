package com.deaprj.spring_web_application.controllers;

import com.deaprj.spring_web_application.repositories.EventRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final EventRepository eventRepository;

    public HomeController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("events", eventRepository.findTop6ByOrderByCreatedAtDesc());
        return "home";
    }

}

