package com.deaprj.spring_web_application.controllers;

import com.deaprj.spring_web_application.models.EventStatus;
import com.deaprj.spring_web_application.models.Events;
import com.deaprj.spring_web_application.repositories.EventRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomeController {

    private final EventRepository eventRepository;

    public HomeController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/home")
    public String home(Model model, @RequestParam(defaultValue = "0") int page) {

        // ✅ Pagination (5 events per page for overview table)
        Page<Events> eventPage = eventRepository.findAllByOrderByCreatedAtDesc(PageRequest.of(page, 5));
        model.addAttribute("events", eventPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", eventPage.getTotalPages());

        // ✅ Featured events (top 6 by creation date)
        model.addAttribute("featuredEvents", eventRepository.findTop6ByOrderByCreatedAtDesc());

        // ✅ Event statistics
        model.addAttribute("totalEvents", eventRepository.count());
        model.addAttribute("upcomingEvents", eventRepository.countByStatus(EventStatus.UPCOMING));
        model.addAttribute("ongoingEvents", eventRepository.countByStatus(EventStatus.ONGOING));
        model.addAttribute("completedEvents", eventRepository.countByStatus(EventStatus.COMPLETED));
        model.addAttribute("postponedEvents", eventRepository.countByStatus(EventStatus.POSTPONED));
        model.addAttribute("cancelledEvents", eventRepository.countByStatus(EventStatus.CANCELLED));

        return "home";
    }

    @GetMapping("/search")
    @ResponseBody
    public List<Events> searchEvents(@RequestParam("keyword") String keyword) {
        if(keyword == null || keyword.isEmpty()) {
            return eventRepository.findAll(); // fallback: return all
        }
        return eventRepository.findByEventNameContainingIgnoreCaseOrEventCodeContainingIgnoreCaseOrVenueContainingIgnoreCase(
                keyword, keyword, keyword
        );
    }


}

