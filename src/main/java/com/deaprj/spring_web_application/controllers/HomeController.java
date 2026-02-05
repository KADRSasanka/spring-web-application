package com.deaprj.spring_web_application.controllers;

import com.deaprj.spring_web_application.models.EventStatus;
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
        // ✅ NEW: statistics (safe additions)
        model.addAttribute("totalEvents",
                eventRepository.count());

        model.addAttribute("upcomingEvents",
                eventRepository.countByStatus(EventStatus.UPCOMING));

        model.addAttribute("ongoingEvents",
                eventRepository.countByStatus(EventStatus.ONGOING));

        model.addAttribute("completedEvents",
                eventRepository.countByStatus(EventStatus.COMPLETED));

        model.addAttribute("postponedEvents",
                eventRepository.countByStatus(EventStatus.POSTPONED));

        model.addAttribute("cancelledEvents",
                eventRepository.countByStatus(EventStatus.CANCELLED));

        return "home";
    }



}

