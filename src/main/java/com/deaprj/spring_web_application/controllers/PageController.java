package com.deaprj.spring_web_application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    // Load index page
    @GetMapping("/")
    public String indexPage() {
        return "index"; // loads index.html
    }

    // Load admin dashboard
    @GetMapping("/admin")
    public String adminPage() {
        return "admin"; // loads admin.html
    }

}
