package com.deaprj.spring_web_application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String root() {
        return "redirect:/home";
    }
}
