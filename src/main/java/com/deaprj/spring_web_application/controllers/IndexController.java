package com.deaprj.spring_web_application.controllers;

import com.deaprj.spring_web_application.repositories.EventRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final EventRepository eventRepository;

    public IndexController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("events", eventRepository.findAll());
        return "index";
    }
}
