package com.rimeh.livre.functions;

import com.rimeh.livre.service.LivreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import java.util.function.Consumer;

@Configuration
public class LivreFunctions {
    private static final Logger log = LoggerFactory.getLogger(LivreFunctions.class);

    @Bean
    public Consumer<Long> updateCommunication(LivreService livreServiceService) {
        return teacherId -> {
            log.info("Updating Communication status for the teacher Id : " + teacherId.toString());
            livreServiceService.updateCommunicationStatus(teacherId);

        };
    }
}