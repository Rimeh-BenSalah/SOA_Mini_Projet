package com.rimeh.theme;

import com.rimeh.theme.entities.Theme;
import com.rimeh.theme.repos.ThemeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ThemeMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThemeMicroserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ThemeRepository themeRepository) {
        return args -> {
            themeRepository.save(Theme.builder().themeName("Science-Fiction").themeCode("SF").build());
            themeRepository.save(Theme.builder().themeName("Histoire").themeCode("HI").build());
        };
    }

}
