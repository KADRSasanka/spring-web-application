package com.deaprj.spring_web_application.controllers;

import com.deaprj.spring_web_application.models.Events;
import com.deaprj.spring_web_application.repositories.EventRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {

    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // 🔹 View all events (table)
    @GetMapping
    public String viewEvents(Model model) {
        List<Events> events = eventRepository.findAll();
        model.addAttribute("events", events);
        return "index"; // index.html
    }

    // 🔹 Show Add Event form
    @GetMapping("/add")
    public String showAddEventForm(Model model) {
        model.addAttribute("event", new Events());
        return "event-add"; // event-add.html
    }

    // 🔹 Save new event
    @PostMapping("/save")
    public String saveEvent(@ModelAttribute Events event) {
        eventRepository.save(event);
        return "redirect:/events";
    }

    // 🔹 Show Edit Event form
    @GetMapping("/edit/{id}")
    public String showEditEventForm(@PathVariable Long id, Model model) {
        Events event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        model.addAttribute("event", event);
        return "event-edit"; // event-edit.html
    }

    // 🔹 Update event
    @PostMapping("/update/{id}")
    public String updateEvent(@PathVariable Long id, @ModelAttribute Events updatedEvent) {

        Events event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        event.setEventCode(updatedEvent.getEventCode());
        event.setEventName(updatedEvent.getEventName());
        event.setVenue(updatedEvent.getVenue());
        event.setStartDate(updatedEvent.getStartDate());
        event.setEndDate(updatedEvent.getEndDate());
        event.setStatus(updatedEvent.getStatus());
        event.setProjectChair(updatedEvent.getProjectChair());

        eventRepository.save(event);

        return "redirect:/events";
    }

    // 🔹 Delete event
    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventRepository.deleteById(id);
        return "redirect:/events";
    }
}
