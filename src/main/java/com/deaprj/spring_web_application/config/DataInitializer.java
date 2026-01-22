package com.deaprj.spring_web_application.config;

import com.deaprj.spring_web_application.models.User;
import com.deaprj.spring_web_application.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {

        if (userRepository.findByEmail("admin@email.com") == null) {

            User admin = new User();
            admin.setFirstName("Admin");
            admin.setLastName("User");
            admin.setEmail("admin@email.com");
            admin.setPassword("admin123"); // plain text (dev only)
            admin.setRole("ADMIN");

            userRepository.save(admin);
        }
    }
}

