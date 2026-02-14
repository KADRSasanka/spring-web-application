package com.deaprj.spring_web_application.controllers;

import com.deaprj.spring_web_application.models.Events;
import com.deaprj.spring_web_application.repositories.EventRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

import java.util.List;

@Controller
@RequestMapping("/index")
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
        model.addAttribute("event", new Events()); //Add this for the model
        return "index"; // index.html
    }

    // 🔹 Show Add Event form
//    @GetMapping("/add")
//    public String showAddEventForm(Model model) {
//        model.addAttribute("event", new Events());
//        return "redirect:/index";
//    }

    // 🔹 Save new event
    @PostMapping("/save")
    public String saveEvent(@ModelAttribute Events event) {
        eventRepository.save(event);
        return "redirect:/index";
    }

    // 🔹 Show Edit Event form
    @GetMapping("/edit/{id}")
    public String showEditEventForm(@PathVariable Long id, Model model) {
        Events event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        model.addAttribute("event", event);
        model.addAttribute("events", eventRepository.findAll());
        model.addAttribute("editMode", true);

        return "index"; // index.html
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
        //event.setProjectChair(updatedEvent.getProjectChair());

        eventRepository.save(event);

        return "redirect:/index";
    }

    // 🔹 Delete event
    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventRepository.deleteById(id);
        return "redirect:/index";
    }

    // 🔹 Export events as Excel
    @GetMapping("/export/excel")
    public void exportEventsToExcel(HttpServletResponse response) throws IOException {

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=events_list.xlsx");

        List<Events> events = eventRepository.findAll();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Events");

        // 🔹 Header Style (Bold)
        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerStyle.setFont(headerFont);

        // 🔹 Create Header Row
        Row headerRow = sheet.createRow(0);
        String[] columns = {
                "Event Code",
                "Event Name",
                "Venue",
                "Start Date",
                "End Date",
                "Status"
        };

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerStyle);
        }

        // 🔹 Fill Data Rows
        int rowNum = 1;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (Events event : events) {

            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(event.getEventCode());
            row.createCell(1).setCellValue(event.getEventName());
            row.createCell(2).setCellValue(event.getVenue());

            row.createCell(3).setCellValue(
                    event.getStartDate() != null ?
                            event.getStartDate().format(formatter) : "-"
            );

            row.createCell(4).setCellValue(
                    event.getEndDate() != null ?
                            event.getEndDate().format(formatter) : "-"
            );

            row.createCell(5).setCellValue(
                    event.getStatus() != null ?
                            event.getStatus().name() : "-"
            );
        }

        // 🔹 Auto-size columns
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        workbook.write(response.getOutputStream());
        workbook.close();
    }

}
