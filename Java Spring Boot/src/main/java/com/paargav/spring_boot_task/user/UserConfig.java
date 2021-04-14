package com.paargav.spring_boot_task.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User testUser1 = new User(
                    "TestUser1",
                    17,
                    "Chennai",
                    "Frontend Developer"
            );

            User testUser2 = new User(
                    "TestUser2",
                    28,
                    "Chennai",
                    "Backend Developer"
            );

            User testUser3 = new User(
                    "TestUser3",
                    20,
                    "Chennai",
                    "UI/UX Designer"
            );

            userRepository.saveAll(List.of(testUser1, testUser2, testUser3));

        };
    }


}
