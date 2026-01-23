package com.deaprj.spring_web_application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }

//    @GetMapping("/index")
//    public String index() {
//        return "index";
//    }

//    @GetMapping("/admin")
//    public String admin() {
//        return "admin";
//    }
}
