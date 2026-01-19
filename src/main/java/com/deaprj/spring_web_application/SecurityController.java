package com.deaprj.spring_web_application;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SecurityController {

    @GetMapping("/")
    public String greet(HttpServletRequest request) {
        return "index"; // loads index.html
    }

}
